import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    paddle myPaddle;
    ball myBall;

    public void setup() {

        background(0, 200, 50);
        myPaddle = new paddle();
        myBall = new ball();

        myBall._paddle=myPaddle;

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

    }

    public void keyPressed() {

        if (keyCode == RIGHT) {
            myPaddle.setSpeedPaddle(10);

        } else if (keyCode == LEFT) {
            myPaddle.setSpeedPaddle(-10);
        }

        if(keyCode == UP){
            myBall.setSpeedBallY(-7);
            myBall.setSpeedBallX(-1);
        }

    }

    public void keyReleased() {
        myPaddle.setSpeedPaddle(0);
        //myBall.setSpeedBall(-7);
    }

}
