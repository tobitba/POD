import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Ej2 {
    private static final String PATH = "/home/tobias/Documentos";
    public static void main(String[] args) throws IOException, InterruptedException,
            ExecutionException {
        Path path = Paths.get(PATH);
        List<Path> files = listFiles(path);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> calls = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        for (Path p : files) {
            calls.add(new FileProcessor(path,buffer));
        }
        executor.invokeAll(calls);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(buffer);
    }
    private static List<Path> listFiles(Path dir) throws IOException {
        List<Path> result = new ArrayList<>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        for (Path entry : stream) {
            result.add(entry);
        }
        return result;
    }

    public static class FileLinesCounter implements Supplier<Long> {
        private File file;
        public FileLinesCounter(File file) {
            this.file = file;
        }
        @Override
        public Long get() {
            try {
                return Files.lines(file.toPath(), StandardCharsets.ISO_8859_1).count(); //TODO: esta ok o hay algo mejor? y lo del try with resource
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class FileSizeGetter implements Supplier<Long> {
        private File file;
        public FileSizeGetter(File file) {
            this.file = file;
        }

        @Override
        public Long get() {
            return file.length();
        }
    }

    public static class FileProcessor implements Callable<Void> {
        private final Path path;
        StringBuffer buffer;

        FileProcessor(Path path, StringBuffer buffer) {
            this.path = path;
            this.buffer = buffer;
        }

        @Override
        public Void call() {
            ExecutorService service = Executors.newCachedThreadPool();
            File file = path.toFile();
            if(file.isFile()) {
                String fileName = file.getName();
                System.out.println(fileName);
                CompletableFuture<Long> size = CompletableFuture.supplyAsync(new FileSizeGetter(file), service);
                CompletableFuture<Long> lines = CompletableFuture.supplyAsync(new FileLinesCounter(file),service);
                size.thenCombine(lines,(s,l)-> buffer.append(fileName).append(" size:").append(s).append(" lines:").append(l).append("\n")); //Es medio feo esto, esta ok?
            }
            return null;
        }
    }
}
