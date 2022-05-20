import java.io.File;
import java.net.URL;
import java.awt.*;

public class StartScreen {
    private DrawingPanel startScreen;
    private Graphics g;


    public StartScreen() throws Exception{
        startScreen = new DrawingPanel(720,540, 0);
        Image f = startScreen.loadImage(new File(".\\StartScreen.jpg"));
        g = startScreen.getGraphics();
        g.drawImage(f, 0, 0, startScreen);
        g.setFont(new Font("Koulen", Font.BOLD, 45));
        g.drawString("Choose a game mode!", 100, 290);
        String fonts[] = 
      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }

        
    }
}
