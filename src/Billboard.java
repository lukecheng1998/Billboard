import java.awt.*;
import javax.swing.*;

public class Billboard extends JComponent {

    public void paintComponent(Graphics g) {
        if(g instanceof Graphics2D){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawString("Hello World", 70, 80);
        }
    }

}
