import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PromotionSender {
    public static void main(String[] args) {
        List<String> promotions = Arrays.asList("Descuento en Café: ",
                "Descuento en Refrescos: ",
                "Descuento en Congelados: ");
        notifyPromotionsParallel(promotions);
        System.out.println("Se realizaron todas las notificaciones de la promoción.");
    }
    private static void notifyCustomers(String promotion) {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Cliente: " + promotion);
        } catch (InterruptedException e) {
//
        }
    }
    private static void notifyMarketing(String promotion) {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Marketing: " + promotion);
        } catch (InterruptedException e) {
//
        }
    }
    private static void notifyPromotions(List<String> promotions) {
        for (String promotion : promotions) {
            promotion = promotion + "30%";
            promotion = promotion + " Sólo por hoy";
            notifyCustomers(promotion);
        }
        notifyMarketing("Hoy se publicitó un descuento del 30%");
    }
                                                //TODO: VERIFICAR!!!!!!!!!!!!!!!!!!!!!!!
    /***
     * EJERCICIO 1.A
     */
    private static void notifyPromotionsParallel(List<String> promotions) {
        promotions.parallelStream().forEach(promotion -> {
            promotion = promotion + "30%";
            promotion = promotion + " Sólo por hoy";
            notifyCustomers(promotion);
        });
        notifyMarketing("Hoy se publicitó un descuento del 30%");
    }

    /***
     EJERCICIO 1.B
     */
    private static void notifyPromotionsCompletable(List<String> promotions) {
        //TODO: no entendi que hay que hacer xd preguntar
        for(String promotion : promotions) {
            AtomicReference<String> promo = new AtomicReference<>(promotion);
            CompletableFuture.runAsync(() -> {
                promo.set(promotion + "30%");
                promo.set(promotion + " Sólo por hoy");
                notifyCustomers(promotion);
            });
        }
        notifyMarketing("Hoy se publicitó un descuento del 30%");
    }
}