import processing.core.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends PApplet {

    ArrayList<Block> blocks;
    public int score;
    public int highScore;
    int gameState=0;

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
  

    public void setup() {

        background(0, 200, 50);
        myPaddle = new paddle();
        myBall = new ball();
        
        blocks = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int x = 30 * i + 50;
           

            for(int j = 0; j < 8; j++){
                int y = 30*j + 50;

                blocks.add(new Block(x, y));
            }

            

        }
        myBall._paddle = myPaddle;


       readHighScore();


    }

    public void settings() {
        size(700, 700);

    }

    public void draw() {
        
        // textSize(30);
        // text("highScore: " + highScore,50,650);


        if(gameState==0){
            showStartScreen(); 

        }else if(gameState==1){  //for multiple screens
            runGame();
        }if(gameState==2){
            showEndScreen();
        }

            if(myBall.ballY>700){
               gameState=2;
            }
    }

    public void runGame(){
        background(20, 50, 40);
        myPaddle.draw(this);
        myPaddle.movePaddle();
        myBall.draw(this);
        myBall.moveBall();
        // myBlock.draw(this);
        ballBounceOffBlocks();

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);

            b.draw(this);

        }
        textSize(30);
        text("Score: " + score,350,650);

    }

    public void resetGame(){
        myBall.ballX=350;
        myBall.ballY=590;
        myBall.setSpeedBallX(0);
        myBall.setSpeedBallY(0);
        myPaddle.paddleX=300;
        setup();
        score=0;

    }

    public void showStartScreen(){
        background(0, 0, 128);
        textSize(22);
        text("Objective: Hit the ball with the paddle to destroy the blocks. \n Controls: use the up arrow key to launch the ball and use \n the left and right arrow keys to move the paddle. " ,350,200 );
        textSize(40);
        fill(255);
        textAlign(CENTER, CENTER);
        text("Press SPACE to Start", width / 2, height / 2);
    }

    public void showEndScreen(){
        background(0, 0, 128);
        textSize(30);
        fill(255);
        text("Score: " + score, 350,200);
        text("High Score: " + highScore, 350,300);
        textSize(40);
        text("press ENTER to play again", 350,400);

    }

    public void keyPressed() {

        if (keyCode == RIGHT) {
            myPaddle.setSpeedPaddle(14);

        } else if (keyCode == LEFT) {
            myPaddle.setSpeedPaddle(-14);
        }

        if (keyCode == UP) {
            
            
            myBall.setSpeedBallY(-6);
            myBall.setSpeedBallX(-4);

            myBall.randomNudgeSpeed();
        }
             if(gameState==0 && key ==' '){
                gameState=1;
             }
             if(gameState==2 && key == '\n'){
                gameState=1;
                resetGame();
                
             }
    }

    public void keyReleased() {
        myPaddle.setSpeedPaddle(0);

    }

    public void ballBounceOffBlocks() {

        for (int i = 0; i < blocks.size(); i++) {
            Block b= blocks.get(i);
            
            if (b.circleTouching(myBall.ballX, myBall.ballY, myBall.radiusB) == true) {

                if (b.topBottom(myBall.ballX) == true) {

                    myBall.setSpeedBallY(myBall.speedBY * -1);

                } else {
                    myBall.setSpeedBallX(myBall.speedBX * -1);
                }     
                     
                     
                     blocks.remove(i);
                      score+=100;

                      if(score>highScore){
                        highScore=score;

                        saveHighScore();
                      }
                      
                     
                     break;

            }
        }
    }
       
  public void readHighScore(){
    try (Scanner scanner = new Scanner(Paths.get("highScore.txt"))) {

        // we read the file until all lines have been read
        while (scanner.hasNextLine()) {
            // we read one line
            String row = scanner.nextLine();
            // we print the line that we read
            highScore = Integer.valueOf(row);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    
  }
    public void saveHighScore(){
      

        try (PrintWriter writer = new PrintWriter("highScore.txt")){
            writer.println(highScore); // Writes the integer to the file
            writer.close(); // Closes the writer and saves the file
            System.out.println("Integer saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    

    }
}

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   