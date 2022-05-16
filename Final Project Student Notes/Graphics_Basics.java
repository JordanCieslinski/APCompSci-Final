import java.awt.*;

import MarchMadness.DrawingPanel;
public class Graphics_Basics
{
   public static void main(String[] args)
   {
      DrawingPanel frame = new DrawingPanel(800,600); //width, height
      Graphics g  = frame.getGraphics();
      g.drawLine(0, 0, 500, 500);
      frame.setBackground(Color.YELLOW);
      
      g.setColor(Color.BLUE);
      g.fillOval(400, 300, 50, 50);
      frame.sleep(1000); //5000ms (5s)
      frame.setBackground(Color.RED);
      g.fillRect(600, 200, 100, 100);
      Color brown = new Color(192,128,64);
      g.setColor(brown);
      g.fillRect(100, 100, 100, 100);
      Font font = new Font("Arial", Font.BOLD, 45);
      g.setFont(font);
      g.drawString("Hello Class", 200, 200);

      Image fr = frame.loadImage(".\\Final Project Student Notes\\frame2.png");
      g.drawImage(fr, 0, 0, frame);
   }
}
