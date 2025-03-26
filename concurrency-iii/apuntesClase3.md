# Alternativas a la concurrencia

### - Objetos Inmutables:
> Un objeto inmutable es aquel cuyo estado no cambia una
vez que fue creado.

Podemos usar final en los atributos para que sean inmutables
 
### - Pub-Sub
Separo las partes que necesitan una conexion por algo que se produce en una parte para ser consumida en otra. tengo los producers que generan algo lo poonen en una cola, y los consumers leen de esa cola, pero los consumers no saben que producers lo produjo
ej consumer 
```java
SynchronousQueue<Integer> queue = new SynchronousQueue<>();
//-----
Runnable producer = () -> {
    Integer producedElement = ThreadLocalRandom
            .current()
            .nextInt();
    try {
        queue.put( producedElement );
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
};
//----
Runnable consumer = () -> {
    try {
        Integer consumedElement = queue.take();
…
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
};
```

### - Subdivisión de la Tarea
 Particiono la tarea en unidades de procesamiento (ej: mergesort)
 se juntan los resultados de cada particion y se calcula el resultado total
 En java 8 se incluye la opcion de paralerizar stream
 ```java
 double average = roster
        .parallelStream()
        .filter(p -> p.getGender() == Person.Sex.MALE)
        .mapToInt(Person::getAge)
        .average()
        .getAsDouble();
 ```

