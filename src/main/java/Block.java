/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 25.02.14
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class Block {
    private final int WEIGHT = 50;
    private int carringWeight = NOT_INITIALIZED_WEIGHT;
    public static final int NOT_INITIALIZED_WEIGHT = -1;

    public int getCarringWeight() {
        return carringWeight;
    }

    public void setCarringWeight(int carringWeight) {
        this.carringWeight = carringWeight;
    }

    public int getWeight() {
        return this.WEIGHT;
    }
}
