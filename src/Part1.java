import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Part1 extends JFrame{
    int CircleSize;
    int TrailSize = 100;
    float alpha = 0.5f;

    Queue<Point> MouseTrail = new LinkedList<Point>();
    Point lasPos = null;

    public void Trail(Point pos){
      if(pos != null){
        if(MouseTrail.size() >= TrailSize){

          MouseTrail.poll();
        }
        MouseTrail.add(pos);
      }
    }

    public void CreateTrail(Point pos, Graphics g) {
      g.setColor(new Color(0, 0, 0, 128));
      for (Point point : MouseTrail) {
          g.fillOval(point.x - 5, point.y - 5, 10, 10);
      }
  }
  
}
