package Classes;

import java.util.List;
import java.util.ArrayList;

import Interfaces.iActorBehaviour;

import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;


public class Market implements iMarketBehaviour, iQueueBehaviour, iReturnOrder {

    private List<iActorBehaviour> queue;
    public static int countReplace;
    public static int countReturn;
    public static int countReplacement;
    public int action = 5;

    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(actor.getActor().getName() + " пришел в магазин ");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().getName() + " добавлен в очередь ");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " ушел из магазина ");
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();    
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName() + "  получил свой заказ ");
            }
        }

    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент сделал заказ ");

            }
        }

    }

    /**
     * returnOrder() - возврат заказа
     * acceptToMarket() - посещение магазина
     * refundCostOrder() - возврат денежных средств 
     */
    @Override
    public void returnOrder(iActorBehaviour actor) {
        acceptToMarket(actor);
        System.out.println(actor.getActor().getName() + " вернул заказ");
        refundCostOrder(actor);
        Market.countReturn ++;
    }
/***
 * orderReplacement() - замена заказа
 * acceptToMarket() - посещение магазина
 * countReplacement - подсчет количества замен товара
 */
    @Override
    public void orderReplacement(iActorBehaviour actor) {
        acceptToMarket(actor);
        System.out.println(actor.getActor().getName() + " заменил ранее полученный заказ");
        System.out.println(actor.getActor().getName() + " ушел из магазина ");
        Market.countReplacement ++;
    }

    /**
     * refundCostOrder() - возврат денежных средств
     * countReplace ++ - подсчет количества операций возврата денежных средств

     */
    @Override
    public void refundCostOrder(iActorBehaviour actor) {
    System.out.println(actor.getActor().getName() + " пришел в магазин ");
    System.out.println(actor.getActor().getName() + " получил возрат денежных средств за возращенный заказ");
    System.out.println(actor.getActor().getName() + " ушел из магазина ");
    Market.countReplace ++;
    }

}