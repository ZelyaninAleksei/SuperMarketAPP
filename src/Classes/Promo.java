package Classes;

/**
 * Класс для описывающий акцию в магазине
 */

public class Promo {
    
    private String namePromo;
    private int numPromo;

    /**
     * 
     * @param namePromo - название акции;
     * @param numPromo - максимальное количество участников акции;
     */
    public Promo(String namePromo, int numPromo) {
        this.namePromo = namePromo;
        this.numPromo = numPromo;
    }

    /**
     * 
     * @return возвращает наименование акции
     */
    public String getNamePromo() {
        return namePromo;
    }

    /**
     * 
     * @param namePromo устанавливает наименование акции
     */
    public void setNamePromo(String namePromo) {
        this.namePromo = namePromo;
    }

    /**
     * 
     * @return  получение максимального количества участников акции
     * 
     */
    public int getNumPromo() {
        return numPromo;
    }

    /**
     * 
     * @param numPromo -установка максимального количества участников акции
     */
    public void setNumPromo(int numPromo) {
        this.numPromo = numPromo;
    }

    
}
