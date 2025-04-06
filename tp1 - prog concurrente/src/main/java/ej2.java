public class ej2 {

    /*** Sacado de https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.State.html
     *  A thread can be in one of the following states:
     *
     *     NEW
     *     A thread that has not yet started is in this state.
     *     RUNNABLE
     *     A thread executing in the Java virtual machine is in this state.
     *     BLOCKED
     *     A thread that is blocked waiting for a monitor lock is in this state.
     *     WAITING
     *     A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
     *     TIMED_WAITING
     *     A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
     *     TERMINATED
     *     A thread that has exited is in this state.
     *
     * A thread can be in only one state at a given point in time. These states are virtual machine states which do not reflect any operating system thread states.
     */



    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        Thread thread = new Thread(() -> {
            System.out.printf("Hello!, my state is %s%n",
                    Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Thread state: %s%n", thread.getState());
        thread.start();
        Thread.sleep(500);
        System.out.printf("Thread state: %s%n", thread.getState());
        Thread.sleep(2000);
        System.out.printf("Thread state: %s%n", thread.getState());
        synchronized (lock) {
            lock.notifyAll(); //puede ejecutar este bloque porque al ejecutar lock.wait el otro thread RENUNCIA al lock conseguido en su bloque syncronized (ver comentario mas abajo)
        }
        thread.join();
        System.out.printf("Thread state: %s%n", thread.getState());
    }
}
/***
 * INFO de que hace lock.wait()
 * Causes the current thread to wait until it is awakened, typically by being notified or interrupted, or until a certain amount of real time has elapsed.
 * The current thread must own this object's monitor lock. See the notify method for a description of the ways in which a thread can become the owner of a monitor lock.
 * This method causes the current thread (referred to here as T) to place itself in the wait set for this object and then to relinquish any and all synchronization claims
 * on this object. Note that only the locks on this object are relinquished; any other objects on which the current thread may be synchronized remain locked while the
 * thread waits.
 * Thread T then becomes disabled for thread scheduling purposes and lies dormant until one of the following occurs:
 * Some other thread invokes the notify method for this object and thread T happens to be arbitrarily chosen as the thread to be awakened.
 * Some other thread invokes the notifyAll method for this object.
 * Some other thread interrupts thread T.
 * The specified amount of real time has elapsed, more or less. The amount of real time, in nanoseconds, is given by the expression 1000000 * timeoutMillis + nanos.
 * If timeoutMillis and nanos are both zero, then real time is not taken into consideration and the thread waits until awakened by one of the other causes.
 * Thread T is awakened spuriously. (See below.)
 * The thread T is then removed from the wait set for this object and re-enabled for thread scheduling. It competes in the usual manner with other threads for the right
 * to synchronize on the object; once it has regained control of the object, all its synchronization claims on the object are restored to the status quo ante - that is,
 * to the situation as of the time that the wait method was invoked. Thread T then returns from the invocation of the wait method. Thus, on return from the wait method,
 * the synchronization state of the object and of thread T is exactly as it was when the wait method was invoked.
 * A thread can wake up without being notified, interrupted, or timing out, a so-called spurious wakeup. While this will rarely occur in practice, applications must
 * guard against it by testing for the condition that should have caused the thread to be awakened, and continuing to wait if the condition is not satisfied.
 */