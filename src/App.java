import processing.core.*;
import java.util.ArrayList;

public class App extends PApplet {

    // ArrayList <Block> blocks;

    public static void main(String[] args) {

        // test();

        PApplet.main("App");
    }

    // public static void test() {

    // boolean test = Block.circleIntersectsRectangle(330, 364, 15, 335, 320, 30,
    // 30);

    // System.out.println(test);

    // }

    paddle myPaddle;
    ball myBall;
    Block myBlock;

    public void setup() {

        background(0, 200, 50);
        myPaddle = new paddle();
        myBall = new ball();
        myBlock = new Block();
        // blocks = new ArrayList<>();

        myBall._paddle = myPaddle;

    }

    public void settings() {
        size(700, 700);

    }

    public void draw() {
        background(0, 200, 50);
        myPaddle.draw(this);
        myPaddle.movePaddle();
        myBall.draw(this);
        myBall.moveBall();
        myBlock.draw(this);
        ballBounceOffBlocks();

    }

    public void keyPressed() {

        if (keyCode == RIGHT) {
            myPaddle.setSpeedPaddle(13);

        } else if (keyCode == LEFT) {
            myPaddle.setSpeedPaddle(-10);
        }

        if (keyCode == UP) {
            myBall.setSpeedBallY(-6);
            myBall.setSpeedBallX(-6);
        }

    }

    public void keyReleased() {
        myPaddle.setSpeedPaddle(0);

    }

    public void ballBounceOffBlocks() {

        // if (myBlock.circleTouchingHorizontal(myBall.ballX, myBall.ballY, myBall.radiusB) == true) {

        //     myBall.setSpeedBallY(myBall.speedBY * -1);

        // }

        //   if (myBlock.circleTouchingVertical(myBall.ballX, myBall.ballY, myBall.radiusB) == true) {

        //       myBall.setSpeedBallX(myBall.speedBX * -1);

        //  }

        if(myBlock.circleTouching(myBall.ballX, myBall.ballY, myBall.radiusB)==true){
            myBall.setSpeedBallY(myBall.speedBY * -1);
            myBall.setSpeedBallX(myBall.speedBX * -1);

        }
    }
}
