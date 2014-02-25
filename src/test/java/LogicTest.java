import junit.framework.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: sergeyrybalkin
 * Date: 25.02.14
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class LogicTest {
    @org.junit.Test
    public void testGetHumanEdgeWeight() throws Exception {
        int levelNumber = 10;
        Logic logic = new Logic(levelNumber);

        Assert.assertEquals(5, logic.getHumanEdgeWeight(3, 1));
    }
}
