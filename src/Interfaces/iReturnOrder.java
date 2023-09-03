package Interfaces;

public interface iReturnOrder {

    //Возврат товара
    void returnOrder(iActorBehaviour actor);

    //замена товара
    void orderReplacement(iActorBehaviour actor);

    //Возврат стоимоси заказа
    void refundCostOrder(iActorBehaviour actor);
}
