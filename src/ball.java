import processing.core.PApplet;
public class ball {

    public int ballX=350;
    public int ballY=590;
    private float speedB;
    private int topBound;
    public paddle _paddle;
    public int paddleX;
    
    
  
     public ball(){
        setBoundariesB();
     }
    public void draw(PApplet p){
        p.ellipse(ballX, ballY, 20, 20);
        p.fill(0);


    }

    public void setSpeedBall(float spb){
        speedB=spb;
        
    }
    public void moveBall(){
    ballY+=speedB;
        
    


    if(ballY>=(10+speedB/2) && ballY <= (10-speedB/2)){ //ball bounce off topBoundary
        setSpeedBall(speedB*-1);
       }
        if(ballY<=(590+speedB/2) && ballY>=(590-speedB/2)){ //ball bounce off paddle
            setSpeedBall(speedB*-1);
        }
        if(ballY<=(590+speedB/2) && ballY>=(590-speedB/2) && paddleX>=350 && paddleX<=250){
            setSpeedBall(7);
        }
        
    }

    public void setBoundariesB(){
        topBound=0;

    }
        
    
}

