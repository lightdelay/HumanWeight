import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 25.02.14
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class Logic {
    private List<List<Block>> weightHolder;

    public Logic(int levelsNumber) {
        weightHolder = new ArrayList<List<Block>>(levelsNumber);
        for (int level = 0; level < levelsNumber; level++) {
            List<Block> blocks = new ArrayList<Block>(level + 1);
            for (int index = 0; index < level + 1; index++) {
                blocks.add(index, new Block());
            }
            weightHolder.add(level, blocks);
        }
        // initializing level 0 (top level)
        weightHolder.get(0).get(0).setCarringWeight(0);
    }

    public int getHumanEdgeWeight(int level, int index) {
        if (weightHolder.get(level).get(index).getCarringWeight() != Block.NOT_INITIALIZED_WEIGHT) {
            return weightHolder.get(level).get(index).getCarringWeight();
        } else {
            int middleBrunchWeight = (level - 2 >= 0 && index - 1 >= 0) ?
                    getHumanEdgeWeight(level - 2, index - 1) + 1 :
                    0;
            int leftBrunchWeight = (level - 1 >= 0 && index - 1 >= 0) ?
                    getHumanEdgeWeight(level - 1, index - 1) + 1 :
                    0;
            int rightBrunchWeight = (level - 1 >= 0 && index < level) ?
                    getHumanEdgeWeight(level - 1, index) + 1 :
                    0;
            return leftBrunchWeight + rightBrunchWeight - middleBrunchWeight;
        }
    }

}
