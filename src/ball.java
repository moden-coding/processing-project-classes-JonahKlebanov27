import processing.core.PApplet;
public class ball {

    public int ballX=350;
    public int ballY=590;
    private float speedB;
    private int topBound;
    
  
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

        if(speedB<0){
            if(ballY<topBound-10){
                ballY+=speedB;
            }
        }
    }

    public void setBoundariesB(){
        topBound=0;

    }
}

