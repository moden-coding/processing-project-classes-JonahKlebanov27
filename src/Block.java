import processing.core.PApplet;
public class Block {

    public int blockX=335;
    public int blockY=320;
    public int blockWidth=30;
    public int blockHeight=30;
    public int radiusB = 15;
    public int ballX=350;
    public int ballY=590;

public void draw(PApplet p){
p.rect(blockX,blockY,blockWidth,blockHeight);

}
   

boolean circleIntersectsRectangle(float ballX, float ballY , float radiusB, float blockX, float blockY, float blockWidth, float blockHeight) {
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

    // Check if the circle's center is within the rectangle
    if (ballX >= rectLeft && ballX <= rectRight && ballY >= rectTop && ballY <= rectBottom) {
        return true; // Center is inside the rectangle, intersection occurs
    }

    // Check if the circle intersects any edge of the rectangle
    float closestX = Math.max(rectLeft, Math.min(ballX, rectRight));
    float closestY = Math.max(rectTop, Math.min(ballY, rectBottom));

    float distanceX = ballX - closestX;
    float distanceY = ballY - closestY;

    if( )

    return (distanceX * distanceX + distanceY * distanceY) <= (radiusB * radiusB);
}

    

}

