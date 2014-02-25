import junit.framework.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 25.02.14
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class LogicTest {
    @Test
    public void testGetHumanEdgeWeightImpl() throws Exception {
        int levelNumber = 10;
        Logic logic = new Logic(levelNumber);

        Assert.assertEquals(0, logic.getHumanEdgeWeightImplementation(0, 0));
        Assert.assertEquals(1, logic.getHumanEdgeWeightImplementation(1, 0));
        Assert.assertEquals(5, logic.getHumanEdgeWeightImplementation(3, 1));
        Assert.assertEquals(11, logic.getHumanEdgeWeightImplementation(5, 2));
        Assert.assertEquals(5, logic.getHumanEdgeWeightImplementation(5, 0));
    }

    @Test
    public void testGetHumanEdgeWeight() throws Exception {
        int levelNumber = 20;
        Logic logic = new Logic(levelNumber);

        Assert.assertEquals(404, logic.getHumanEdgeWeight(-1, -1).getStatus());
        Assert.assertEquals(404, logic.getHumanEdgeWeight(0, -1).getStatus());
        Assert.assertEquals(404, logic.getHumanEdgeWeight(-1, 0).getStatus());
        Assert.assertEquals(0, logic.getHumanEdgeWeight(0, 0).getStatus());
        Assert.assertEquals(404, logic.getHumanEdgeWeight(3, 4).getStatus());
        Assert.assertEquals(404, logic.getHumanEdgeWeight(levelNumber + 1, 3).getStatus());
        Assert.assertEquals(404, logic.getHumanEdgeWeight(levelNumber + 1, levelNumber + 2).getStatus());

        Assert.assertEquals(11, logic.getHumanEdgeWeightImplementation(5, 2));
    }

    @Test
    public void stressTest() throws Exception {
        int levelNumber = 1000;
        Logic logic = new Logic(levelNumber);
        int requestsNumber = 10000;
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int requestIndex = 0; requestIndex < requestsNumber; requestIndex++) {
            int level = -50 + random.nextInt(levelNumber + 100);
            int index = -50 + random.nextInt(levelNumber + 100);
            logic.getHumanEdgeWeight(level, index);
        }
        Assert.assertTrue(System.currentTimeMillis() - startTime < 1000);
    }


}
