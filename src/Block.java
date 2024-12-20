import processing.core.PApplet;

public class Block {

    public int blockX = 335;
    public int blockY = 320;
    public int blockWidth = 25;
    public int blockHeight = 25;

    public Block(int x, int y) {
        blockX = x;
        blockY = y;

    }

    public void draw(PApplet p) {
        p.rect(blockX, blockY, blockWidth, blockHeight);

    }

    public boolean circleTouching(float ballX, float ballY, float radiusB) {  //this is chatGPT code;

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

        return (distanceX * distanceX + distanceY * distanceY) <= (radiusB * radiusB);
    }

    public boolean topBottom(float ballX) {

        if (ballX <= blockX + blockWidth && ballX >= blockX) {
            return true;
        }
        return false;
    }

    public boolean leftRight(float ballY, float ballX) {
        if (ballY >= blockY && ballY <= blockY + blockHeight) {

            return true;

        }
        return false;
    }

}