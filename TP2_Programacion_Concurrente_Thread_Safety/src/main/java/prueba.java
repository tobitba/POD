import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public  class prueba implements Callable<result> {
    private final Map<Integer,Long> fiboHashMap = new HashMap<>();
    private int n;

    public prueba(int n) {
        if(n < 0){
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    private long fibo(int number) {
        if(number == 0 || number == 1) { return number;}
        if(fiboHashMap.containsKey(number)) { return fiboHashMap.get(number); }
        long value = fibo(number - 1) + fibo(number - 2);
        fiboHashMap.put(number,value);
        return value;
    }

    @Override
    public result call() throws Exception {
        return new result(fibo(n),n) ;
    }
}

