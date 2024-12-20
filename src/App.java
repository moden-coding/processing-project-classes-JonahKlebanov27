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
    // Block myBlock;

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
        background(0, 200, 50);
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
        text("Score: " + score,500,650);

        textSize(30);
        text("highScore: " + highScore,50,650);


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

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   