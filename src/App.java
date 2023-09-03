import Classes.Market;
import Classes.OrdinaryClient;
import Classes.Promo;
import Classes.PromotionalClient;
import Classes.SpecialClient;
import Classes.TaxInspector;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        Market magnit = new Market();
        Promo promo = new Promo("50%", 1);


        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new SpecialClient("prezident", 1);
        iActorBehaviour client3 = new TaxInspector();
        iActorBehaviour client4 = new PromotionalClient("Вася", 111, "Sale 50");
        if (PromotionalClient.numberParticipantsPromotion <= promo.getNumPromo()) {
            iActorBehaviour client5 = new PromotionalClient("Юра", 1111, "50%");
            magnit.acceptToMarket(client5);
        } else {
            iActorBehaviour client5 = new OrdinaryClient("Юра");
            magnit.acceptToMarket(client5);
        }
        
           
        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
                

        magnit.update();

        /**
         * returnOrder - возврат заказа
         * orderReplacement - замена заказа;
         * refundCostOrder - возврат денег;
         */
        magnit.returnOrder(client4);
        magnit.orderReplacement(client2);
        magnit.refundCostOrder(client1);


        /**
         * Вывод общего и частного количетсва возвратов и замен заказов
         */
        System.out.println("====================================================================");
        System.out.println("Всего произведено возвратов заказов " + Market.countReplace + " раз(а)");
        System.out.println("Количесвто возвратов денежных средcтв " + Market.countReturn + " раз(а)");
        System.out.println("Количество замен товара (заказов) " + Market.countReplacement + " раз(а)");
    
    }
}