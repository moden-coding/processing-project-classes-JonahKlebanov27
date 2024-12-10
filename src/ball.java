import processing.core.PApplet;
public class ball {

    public int ballX=350;
    public int ballY=590;
    private float speedBY;
    private float speedBX;
    private int topBound;
    public paddle _paddle;
   
    
    
    
  
     public ball(){
        setBoundariesB();
     }
    public void draw(PApplet p){
        p.ellipse(ballX, ballY, 20, 20);
        p.fill(0);


    }

    public void setSpeedBallY(float spby){
        speedBY=spby;
        
        
    }

    public void setSpeedBallX(float spbx){
        speedBX=spbx;
    }
    public void moveBall(){
    ballY+=speedBY;
    ballX+=speedBX;
        
    


    if(ballY>=(10+speedBY/2) && ballY <= (10-speedBY/2)){ //ball bounce off topBoundary
        setSpeedBallY(speedBY*-1);
       }
        
        if(speedBY!=0 && ballY<=(590+speedBY/2) && ballY>=(590-speedBY/2)) {                //ball bounce off paddle and know when to not bounce off paddle
            if(ballX>=_paddle.paddleX && ballX<=(_paddle.paddleX+_paddle.paddleWidth)){
           setSpeedBallY(speedBY*-1);
        }
    }
    }

    public void setBoundariesB(){
        topBound=0;

    }
        
    
}

