import processing.core.PApplet;

public class ball {

    public int ballX = 350;
    public int ballY = 590;
    public float speedBY;
    public float speedBX;
    public float radiusB = 10;
    private int topBound;
    private int leftBound;
    private int rightBound;
    public paddle _paddle;

    public ball() {
        setBoundariesB();
    }

    public void draw(PApplet p) {
        p.ellipse(ballX, ballY, radiusB * 2, radiusB * 2);
        p.fill(0);

    }

    public void setSpeedBallY(float spby) {  //setting a variable for speedBY
        speedBY = spby;

    }

    public void setSpeedBallX(float spbx) { // setting a variable for speedBX
        speedBX = spbx;
    }

    public void moveBall() {
        ballY += speedBY;
        ballX += speedBX;

        if ((ballY >= (10 + speedBY / 2) && ballY <= (10 - speedBY / 2)) || ballY<0 ) { // ball bounce off topBound(top of the screen)
            setSpeedBallY(speedBY * -1);
        }

        if (speedBY != 0 && ballY <= (590 + speedBY / 2) && ballY >= (590 - speedBY / 2)) { // ball bounce off paddle
                                                                                            // and know when to not bounce off paddle
                                                                                             
            if (ballX >= _paddle.paddleX && ballX <= (_paddle.paddleX + _paddle.paddleWidth)) {
                setSpeedBallY(speedBY * -1);
                randomNudgeSpeed();
            }

        }
        if ((ballX >= (10 + speedBX / 2) && ballX <= (10 - speedBX / 2)) || ballX<0) { // ball bounce off leftBound(left side of the screen)
            setSpeedBallX(speedBX * -1);
        }
        if ((ballX <= (690 + speedBX / 2) && ballX >= (690 - speedBX / 2)) || ballX>700) { // ball bounce off rightBound(right side of the screen)
            setSpeedBallX(speedBX * -1);
        }
    }

    public void setBoundariesB() {  //boundaries for the ball
        topBound = 0;
        leftBound = 0;
        rightBound = 700;

    }
    public void randomNudgeSpeed(){                     //random angle code for bounce off paddle
        float x = (float)(Math.random() * 0.2 + .9);
        float newXSpeed= speedBX * x;
        float newYSpeed = (float)Math.sqrt((double)(speedBX * speedBX + speedBY * speedBY - newXSpeed * newXSpeed) );

        
       if(speedBY<0){            //if the ball is traveling up, reverse the direction of the ball
       speedBY=newYSpeed * -1;
       } else{
        speedBY=newYSpeed;
       }

       speedBX=newXSpeed;
        
}
}
