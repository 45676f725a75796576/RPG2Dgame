package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * Key handler to control player
 */
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, hit, use;
    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }if(code == KeyEvent.VK_SPACE) hit = true;
        if(code == KeyEvent.VK_E) use = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        } if(code == KeyEvent.VK_SPACE) hit = false;
        if(code == KeyEvent.VK_E) use = false;
    }
}
