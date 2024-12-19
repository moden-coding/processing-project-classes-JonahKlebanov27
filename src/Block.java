import processing.core.PApplet;

public class Block {

    public int blockX = 335;
    public int blockY = 320;
    public int blockWidth = 200;
    public int blockHeight = 200;

    public void draw(PApplet p) {
        p.rect(blockX, blockY, blockWidth, blockHeight);

    }

    
    public boolean circleTouching(float ballX, float ballY , float radiusB) {

    // Check for overlap in the x and y ranges
    float circleLeft = ballX - radiusB;
    float circleRight = ballX + radiusB;
    float circleTop = ballY - radiusB;
    float circleBottom = ballY + radiusB;

    float rectLeft = blockX;
    float rectRight = blockX + blockWidth;
    float rectTop = blockY;
    float rectBottom = blockY + blockHeight;

    // If circle is completely outside the rectangle, no intersection
    if (circleRight < rectLeft || circleLeft > rectRight ||
    circleBottom < rectTop || circleTop > rectBottom) {
    return false;
    }

    

    // Check if the circle intersects any edge of the rectangle
    float closestX = Math.max(rectLeft, Math.min(ballX, rectRight));
    float closestY = Math.max(rectTop, Math.min(ballY, rectBottom));

    float distanceX = ballX - closestX;
    float distanceY = ballY - closestY;

    return (distanceX * distanceX + distanceY * distanceY) <= (radiusB *
    radiusB);
    }

    // public boolean circleTouchingHorizontal(float ballX, float ballY, float radiusB) {
    //     float circleTop = ballY - radiusB;
    //     float circleBottom = ballY + radiusB;
    //     float circleLeft = ballX - radiusB;
    //     float circleRight = ballX + radiusB;
    //     float rectLeft = blockX;
    //     float rectRight = blockX + blockWidth;
    //     float rectTop = blockY;
    //     float rectBottom = blockY + blockHeight;

    //     if (circleBottom < rectTop || circleTop > rectBottom || circleRight < rectLeft || circleLeft > rectRight) {
    //         return false;
    //     }
    //     float closestY = Math.max(rectTop, Math.min(ballY, rectBottom));

    //     float distanceY = ballY - closestY;

    //     return (distanceY * distanceY) <= (radiusB * radiusB);
    // }

    // public boolean circleTouchingVertical(float ballX, float ballY, float radiusB) {

    //     float circleLeft = ballX - radiusB;
    //     float circleRight = ballX + radiusB;
    //     float circleTop = ballY - radiusB;
    //     float circleBottom = ballY + radiusB;
    //     float rectTop = blockY;
    //     float rectBottom = blockY + blockHeight;
    //     float rectLeft = blockX;
    //     float rectRight = blockX + blockWidth;

    //     if (circleRight < rectLeft || circleLeft > rectRight || circleBottom < rectTop || circleTop > rectBottom) {
    //         return false;
    //     }
    //     float closestX = Math.max(rectLeft, Math.min(ballX, rectRight));
    //     float distanceX = ballX - closestX;

    //     return (distanceX * distanceX) <= (radiusB * radiusB);

    // }

}
