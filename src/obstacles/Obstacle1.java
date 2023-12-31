package obstacles;

import model.Direction;
import model.Sprite;
import knight.Knight;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Obstacle1 extends Obstacle {
	//private final ImageRenderer imageRenderdr;
	
	public Obstacle1(String path, Point place, Direction d) {
	    this.location = place;
	    this.size = new Dimension(2048, 90);
	    this.face = d;
            try {
                this.image = ImageIO.read(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
	    //this.imageRenderdr = new ObstacleRenderer(this);
	}

        public Image getImage() {
		return this.image;
	}

        public Point getLocation() {
		return this.location;
	}

        public Dimension getSize() {
		return this.size;
	}

        public Direction getFace() {
		return this.face;
	}

	public void collisionHandler(Point originalLocation, Sprite from) {
            from.setLocation(originalLocation);
            Rectangle body = from.getBody();
	    if (from instanceof Knight && body.x + body.width > this.getLocation().x && body.x < this.getLocation().x + this.getSize().width) {
	        ((Knight)from).fallCount = -1;
	        ((Knight)from).jumpLV = 0;
	        ((Knight)from).jumpStep = -1;
	    }
        }
}
            
            //Rectangle range = from.getRange();
	    //Point newPoint = new Point(range.x + 2 * (originalLocation.x - range.x), range.y + 2 * (originalLocation.y - range.y));
            //from.setLocation(newPoint);

	    /*
            int offsetLeft = range.x + range.width - this.getLocation().x;
            int offsetRight = this.getLocation().x + this.getSize().width - range.x;
            int offsetUp = range.y + range.height - this.getLocation().y;
            int offsetDown = this.getLocation().y + this.getSize().height - range.y;
	    */
     /*
	    int min = 1000;
	    if (offsetLeft > 0 && offsetLeft < min)
		    min = offsetLeft;
	    if (offsetRight > 0 && offsetRight < min)
		    min = offsetRight;
	    if (offsetUp > 0 && offsetUp < min)
		    min = offsetUp;
	    if (offsetDown > 0 && offsetDown < min)
		    min = offsetDown;
     */
	 /*
	    if (offsetLeft > 0 && offsetLeft < 60)
                from.setLocation(new Point(from.getX() - 12, from.getY()));
	    else if (offsetRight > 0 && offsetLeft < 60)
                from.setLocation(new Point(from.getX() + 12, from.getY()));
	    if (offsetUp > 0 && offsetUp < 60)
                from.setLocation(new Point(from.getX(), from.getY() - 12));
	    else if (offsetDown > 0 && offsetLeft < 60)
                from.setLocation(new Point(from.getX(), from.getY() + 12));
	*/
	    /*
            if (offsetLeft < 0) {
                from.setLocation(new Point(to.getX() - (to.getRange().width + offsetLeft) / 3, to.getY()));
            } else {
                from.setLocation(new Point(to.getX() + offsetRight / 3, to.getY()));
            }
	    */
