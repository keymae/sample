import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
    final private Font mainFont=new Font("Segoe print", Font.BOLD,18);
    TextField tfFirstName;
    TextField tfLastName;
    
    public void Initialize(){
        Label lbfirstName=new Label("First Name");
        lbfirstName.setFont(mainFont);

        tfFirstName=new TextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName=new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName=new TextField();
        tfLastName.setFont(mainFont);
        
        // //add the following to a panel
        Panel formPanel=new Panel();
        formPanel.add(lbfirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);
        JLabel lbWelcome=new JLabel();
        lbWelcome.setFont(mainFont);
        setVisible(true);

        //adding button
        Button OKBtn=new Button("Ok");
        OKBtn.setFont(mainFont);
        OKBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String firstName=tfFirstName.getText();
                String lastName=tfLastName.getText();
                lbWelcome.setText("Hello"+firstName+" "+lastName);
                
            }
        });

        Button btnClear=new Button ("clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
        });

        Panel buttonsPanel=new Panel();
         buttonsPanel.setLayout(new GridLayout(1, 2,5,5));
         buttonsPanel.add(OKBtn);
         buttonsPanel.add(btnClear);
         setVisible(true);



        Panel mainPanel=new Panel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Welcome");
        setSize(500,600);
        setMinimumSize((new Dimension(300,400)));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainPanel);
        
    }
    public static void main(String[] args) {
        MainFrame myFrame=new MainFrame();
        myFrame.Initialize();
        }
}
