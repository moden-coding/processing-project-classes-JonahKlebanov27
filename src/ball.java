import processing.core.PApplet;
public class ball {

    public int ballX=350;
    public int ballY=590;
    private float speedD;
    
    public void draw(PApplet p){
        p.ellipse(ballX, ballY, 20, 20);
        p.fill(0);


    }

    public void setSpeedBall(float spb){
        speedD=spb;
        
    }
    public void moveBall(){
        ballY+=speedD;
    }
}
