import java.awt.Graphics;
 import java.awt.Graphics2D;
 import javax.swing.JComponent;

 /**
 This component draws two car shapes.
 */
 public class CarComponent extends JComponent
 {
 public void paintComponent(Graphics g)
 {
 Graphics2D g2 = (Graphics2D) g;

 Car car1 = new Car(0, 0);

 int x = getWidth() - 60;
 int y = getHeight() - 30;

 CarOne car2 = new CarOne(60, 0);
 CarTwo car3 = new CarTwo(120, 0);
 CarThree car4 = new CarThree(120, 90);

 car1.draw(g2);
 car2.draw(g2);
 car3.draw(g2);
 car4.draw(g2);
 }
 }