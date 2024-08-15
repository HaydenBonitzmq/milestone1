import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame {


   Part1 part1 = new Part1();


   public static void main(String[] args) {
       Main window = new Main();
       window.run();
   }


   class Canvas extends JPanel {
       Part1 part1 = new Part1();
       Grid grid = new Grid();
       Point mousepos;


       public Canvas() {
           setPreferredSize(new Dimension(720, 720));
           addMouseMotionListener(new MouseMotionListener() {
               @Override
               public void mouseMoved(MouseEvent e) {
                   mousepos = e.getPoint();
                   repaint();
                   //part1.Trail(mousepos);
               }


               @Override
               public void mouseDragged(MouseEvent e) {
                   mousepos = e.getPoint();
                   repaint();
               }
           });
       }


       @Override
       public void paint(Graphics g) {
           super.paint(g);
           if (mousepos != null) {
               part1.Trail(mousepos);
           }
           grid.paint(g, mousepos);
           part1.CreateTrail(null, g);
       }
   }


   private Main() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Canvas canvas = new Canvas();
       this.setContentPane(canvas);
       this.pack();
       this.setVisible(true);
   }


   public void run() {
       while (true) {
           repaint();
       }
   }
}
