import processing.core.PApplet;

public class paddle {
     
   public int paddleX=300;
   private float speedP;
   private int leftBound;
   private int rightBound;
   public int paddleWidth=125;

     public paddle(){
        setBoundariesP();
     }
    public void draw(PApplet p){
        p.rect(paddleX,600,paddleWidth,20);
        p.fill(0,0,255);

    }
    public void movePaddle(){
        

        if(speedP<0){             // So the paddle knows when to stop at the right and left boundaries. 
            if(paddleX>leftBound){
                paddleX+=speedP;
            }
        }
        if(speedP>0){
            if(paddleX<rightBound-100){
                paddleX+=speedP;
            }
        }

        

    }

    public void setSpeedPaddle(float spp){ //setting a variable for speedP
        speedP=spp;
    }

    public void setBoundariesP(){ //boundaries for the paddle
        leftBound=0;
        rightBound=700;

        
    }

    
}

