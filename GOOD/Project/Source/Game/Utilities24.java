package Source.Game;
import java.util.Random;
/**
 * @author yury
 * @Description:
 * @date 2023/12/12 14:56
 */
public class Utilities24 {
    Random random = new Random();
    protected int getRandomNum(int mod) {
        return random.nextInt() % mod + 1;
    }
    protected void checkExistingAnswer(int x, int y, int z, int j) {

    }
}
