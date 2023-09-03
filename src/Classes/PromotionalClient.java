package Classes;

/**
 *  Класс, описывающий акционного клиента. 
 */

public class PromotionalClient extends Actor {
    private String namePromo;
    private int promotionalClientID;
    public static int numberParticipantsPromotion;
    
    /**
     * 
     * @param promotionalClientID ID акционного клиента
     * @param namePromotion назвние акции
     */

    public PromotionalClient(String name, int promotionalClientID, String namePromotion) {
        super(name);
        this.namePromo = namePromotion;
        this.promotionalClientID = promotionalClientID;
        PromotionalClient.numberParticipantsPromotion++ ;
    }

    /**
     * проверка получен ли заказ
     */
    public boolean isTakeOrder() 
    {
        return super.isTakeOrder;
    }

    /**
     * устанавливает состояние получения заказа
     */
    public void setTakeOrder(boolean takenOrder) {
        super.isTakeOrder = takenOrder;
    }

    /**
     * проверка создан заказ
     */
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /**
     * создать заказ
     */
    public void setMakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }
  
/**
 * установка названия акции
 * @param namePromotion - название акции
 */
    public void setNamePromotion(String namePromotion) {
        this.namePromo = namePromotion;
    }

    /**
     * 
     * @return возвращает название акции
     */
    public String getNamePromotion() {
        return namePromo;
    }

    /**
     * 
     * @return возвращает текущее количество участников акции
     */
    public static int getNumberParticipantsPromotion() {
        return numberParticipantsPromotion;
    }

    /**
     * получает Actor
     */
    @Override
    public Actor getActor() {
        return this;
    }

    /**
     * Устанавливает имя
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * возвращает имя 
     */
    @Override
    public String getName() {
        return name;
    }
}
