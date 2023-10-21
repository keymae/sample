import java.awt.*;
import java.awt.event.*;
import javax.swing.WindowConstants;
public class frame extends Frame {
    final private Font mainFont=new Font("Segoe print", Font.BOLD,18);
    TextField tfFirstName;
    TextField tfLastName;
    /**
     * 
     */
    public void panel(){

        Panel mainPanel=new Panel();
        
        Label lbfirstName=new Label("First Name");
        lbfirstName.setFont(mainFont);
        add(lbfirstName);
        setTitle("Welcome");
        setSize(500,600);
        setMinimumSize((new Dimension(300,400)));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setDefaultCloseOperation(int exitOnClose) {
    }

    public static void main(String[] args) {
        frame myFrame=new frame();
        myFrame.panel();
        }
    }
