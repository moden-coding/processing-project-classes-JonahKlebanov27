import processing.core.PApplet;
public class ball {

    public int ballX=350;
    public int ballY=590;
    private float speedBY;
    private float speedBX;
    private float radiusB=10;
    private int topBound;
    private int leftBound;
    private int rightBound;
    public paddle _paddle;
   
    
    
    
  
     public ball(){
        setBoundariesB();
     }
    public void draw(PApplet p){
        p.ellipse(ballX, ballY, radiusB*2, radiusB*2);
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
        
    


    if(ballY>=(10+speedBY/2) && ballY <= (10-speedBY/2)){ //ball bounce off topBound
        setSpeedBallY(speedBY*-1);
       }
        
        if(speedBY!=0 && ballY<=(590+speedBY/2) && ballY>=(590-speedBY/2)) {                //ball bounce off paddle and know when to not bounce off paddle
            if(ballX>=_paddle.paddleX && ballX<=(_paddle.paddleX+_paddle.paddleWidth)){
           setSpeedBallY(speedBY*-1);
        }
    }
          if(ballX>=(10+speedBX/2) && ballX<= (10-speedBX/2)){ //ball bounce off leftBound
            setSpeedBallX(speedBX*-1);
          }
        if(ballX<=(690+speedBX/2) && ballX>=(690-speedBX/2)){ //ball bounce off rightBound
                 setSpeedBallX(speedBX*-1);
            }
    }

    public void setBoundariesB(){
        topBound=0;
        leftBound=0;
        rightBound=700;

        
    }
        
    
}

