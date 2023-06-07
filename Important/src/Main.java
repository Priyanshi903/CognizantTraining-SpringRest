
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Random;

public class Main {
	public static int getRandomNum(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		Robot r = new Robot();
		while (true) {
			Point p = MouseInfo.getPointerInfo().getLocation(); // current positions
			int currentX = p.x;
			int currentY = p.y;
// new positions
			int nextX = getRandomNum(0, 1000);
			int nextY = getRandomNum(0, 1000);
			if (currentX != nextX || currentY != nextY) {
				r.mouseMove(nextX, nextY);
				Thread.sleep(180000);
			} else {
				Thread.sleep(1000);
			}
		}
	}
}
