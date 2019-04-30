import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;

// Functionality:
// - Add multiple contacts
// - Delete contacts
// - A way to search for contacts1 using multiple fields, name, occupation, etc…
// Challenge: Create a UI using buttons for functionality of address book.
// How are the contacts being stored? Will they be deleted every time you run the application?
// Exporting the contact list to a text file would be a good function to have.

// Tentative Due date is April 25th (Next Thursday)

public class GUI_project extends JFrame {

    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JRadioButton radiobutton1;
    private JRadioButton radiobutton2; 
    private JPanel panel1; 
    private JTextArea textarea1;
    private JTextArea textarea2;
    private JTextArea textarea3;
    private String label;
    private String text;
    private int EnterPressC;
    private int x;
    private String num;
    private boolean buttonAddContact = false;
    private boolean buttonRemoveContact = false;
    private boolean buttonEnter = false;

    //Constructor 
    public GUI_project(){
         
        //title of GUI
        this.setTitle("C O N T A C T     L I S T");
        this.setSize(500,400);

        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800, 430));
        contentPane.setBackground(new Color(192,192,192));
        
        //Creating button 1 with size and color
        button1 = new JButton();
        button1.setBounds(5,4,140,32);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Add Contact");
        button1.setVisible(true);
        //event listener for the button 
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //When button 1 is pressed, make the textbox and instructions visible. 
                    textarea2.setFont(new Font("sansserif",0,12));
                    textarea3.setFont(new Font("sansserif",0,12)); 
                    textarea2.setVisible(true);
                    textarea3.setVisible(true);
                    textarea3.setText("Enter first name:");
                    buttonAddContact = true;
                    x++;
                }
            });
        
        //creating button 2
        button2 = new JButton();
        button2.setBounds(5,40,140,32);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Remove Contact");
        button2.setVisible(true);
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textarea1.setFont(new Font("sansserif",0,12));
                    buttonRemoveContact = true;
                    textarea2.setVisible(true);
                    textarea3.setVisible(true);
                    textarea3.setText("Enter the number of the contact you want to remove:");
                    
                }
            });
        //creating button 3
        button3 = new JButton();
        button3.setBounds(5,370,140,50);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("ENTER");
        button3.setVisible(true);
        button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    buttonEnter = true;
                    //only add contact if button1 was pressed
    
                    if(buttonAddContact){
                        EnterPressC++;
                        textarea3.setText(addContact());
                    }
                    if(buttonRemoveContact){
                        num = textarea2.getText();
                        int location1;
                        int location2;
                        location1 = textarea1.getText().indexOf("Contact #"+ num +":");
                        location2 = textarea1.getText().substring(location1, textarea1.getText().length()).indexOf("****************************************************************************************************");
                        
                        textarea1.setText(textarea1.getText().substring(0, location1)+textarea1.getText().substring(location2, textarea1.getText().length()));
                        //textarea1.setText(textarea1.getText() + "\n" + Integer.toString(textarea1.getText().indexOf("Contact #"+ num +":")));
                        buttonRemoveContact = false;
                         
                        textarea2.setText("");
                        textarea2.setVisible(false);
                        textarea3.setVisible(false);
                    
                    }
                   
                    textarea1.setFont(new Font("sansserif",0,12));
                }
            });

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,295,140,60);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        radiobutton1 = new JRadioButton();
        radiobutton1.setBounds(5,320,90,35);
        radiobutton1.setBackground(new Color(214,217,223));
        radiobutton1.setForeground(new 
            Color(0,0,0));
        radiobutton1.setEnabled(true);
        radiobutton1.setFont(new Font("sansserif",0,12));
        radiobutton1.setText("DarkMode");
        radiobutton1.setVisible(true);
        radiobutton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    button1.setBackground(new Color(0,0,0));
                    button1.setForeground(new Color(255,255,255));
                    button2.setBackground(new Color(0,0,0));
                    button2.setForeground(new Color(255,255,255));
                    button3.setBackground(new Color(0,0,0));
                    button3.setForeground(new Color(255,255,255));
                    textarea1.setBackground(new Color(20,20,20));
                    textarea1.setForeground(new Color(255,255,255));
                    textarea2.setBackground(new Color(20,20,20));
                    textarea2.setForeground(new Color(255,255,255));
                    textarea3.setBackground(new Color(20,20,20));
                    textarea3.setForeground(new Color(255,255,255));
                    contentPane.setBackground(new Color(4,4,4));
                    panel1.setBackground(new Color(20,20,20));                
                }
            });

        radiobutton2 = new JRadioButton();
        radiobutton2.setBounds(5,290,90,35);
        radiobutton2.setBackground(new Color(214,217,223));
        radiobutton2.setForeground(new Color(0,0,0));
        radiobutton2.setEnabled(true);
        radiobutton2.setFont(new Font("sansserif",0,12));
        radiobutton2.setText("LightMode");
        radiobutton2.setVisible(true);
        radiobutton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    button1.setBackground(new Color(255,255,255));
                    button1.setForeground(new Color(0,0,0));
                    button2.setBackground(new Color(255,255,255));
                    button2.setForeground(new Color(0,0,0));
                    button3.setBackground(new Color(255,255,255));
                    button3.setForeground(new Color(0,0,0));
                    textarea1.setBackground(new Color(255,255,255));
                    textarea1.setForeground(new Color(0,0,0));
                    textarea2.setBackground(new Color(255,255,255));
                    textarea2.setForeground(new Color(0,0,0));
                    textarea3.setBackground(new Color(192,192,192));
                    textarea3.setForeground(new Color(0,0,0));
                    contentPane.setBackground(new Color(192,192,192));
                    panel1.setBackground(new Color(214,217,223));
                    radiobutton1.setForeground(new Color(0,0,0));
                    radiobutton2.setForeground(new Color(0,0,0));
                }
            });
        textarea1 = new JTextArea();
        textarea1.setBounds(150,70,620,350);
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEnabled(true);
        textarea1.setFont(new Font("sansserif",0,12));
        textarea1.setText("");
        textarea1.setBorder(BorderFactory.createBevelBorder(1));
        textarea1.setVisible(true);

        textarea2 = new JTextArea();
        textarea2.setBounds(150,35,620,30);
        textarea2.setBackground(new Color(255,255,255));
        textarea2.setForeground(new Color(0,0,0));
        textarea2.setEnabled(true);
        textarea2.setFont(new Font("sansserif",0,12));
        textarea2.setText("");
        textarea2.setBorder(BorderFactory.createBevelBorder(1));
        textarea2.setVisible(false);

        textarea3 = new JTextArea();
        textarea3.setBounds(150,5,620,30);
        textarea3.setBackground(new Color(192,192,192));
        textarea3.setForeground(new Color(0,0,0));
        textarea3.setEnabled(true);
        textarea3.setFont(new Font("sansserif",0,20));
        textarea3.setText("");
        textarea3.setVisible(false);

        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(radiobutton1);
        contentPane.add(radiobutton2);
        contentPane.add(panel1);
        contentPane.add(textarea1);
        contentPane.add(textarea3);
        contentPane.add(textarea2);

        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }
    //method for generate menu
    public void generateMenu(){

    }

    public String addContact(){
        boolean done = false;
        String first = "";
        String last = "";
        String number = "";
        String birthday = "";
        String occupation = "";
        String gender = "";
        while(!done){
            if(EnterPressC == 1){
                MediaFile.writeString(textarea2.getText());
                textarea1.setText(textarea1.getText() + "\n" + "Contact #"+ x + ":");
                textarea1.setText(textarea1.getText() + "\n" + getText());
                label = "Enter last name:";
                textarea2.setText("");
            } 
            else if(EnterPressC == 2){
                MediaFile.writeString(getText());
                textarea1.setText(textarea1.getText() + "\n" + getText());
                label = "Enter phone number:";
                textarea2.setText("");
            } 
            else if(EnterPressC == 3){
                MediaFile.writeString(getText());
                textarea1.setText(textarea1.getText() + "\n" + getText());
                label = "Enter date of birth:";
                textarea2.setText("");
            }
            else if(EnterPressC == 4){
                MediaFile.writeString(getText());
                textarea1.setText(textarea1.getText() + "\n" + getText());
                label = "Enter occupation:";
                textarea2.setText("");
            }
            else if(EnterPressC == 5){
                MediaFile.writeString(getText());
                textarea1.setText(textarea1.getText() + "\n" + getText());
                label = "Enter gender:";
                textarea2.setText("");
            }
            else if(EnterPressC == 6){
                MediaFile.writeString(getText());
                textarea1.setText(textarea1.getText() + "\n" + getText());
                textarea1.setText(textarea1.getText() + "\n" + 
                "****************************************************************************************************");
                textarea2.setText("");
                textarea2.setVisible(false);
                textarea3.setVisible(false);
                EnterPressC = 0;
                buttonAddContact = false;
                done = true;
                MediaFile.saveAndClose();
            }
            return label;
        }
        
        return "";
    }

    public void setText(){
        int x = 0;
        int y = MediaFile.readString().indexOf("|");
        for (int i = 0; i < 6; i++){
            String info = MediaFile.readString().substring(x, y);
            x = y; 
            while((y == x)&&(MediaFile.readString().substring(y,y)!="|")){
                y++;
            }
            textarea2.setText(info);
        }
    }

    public String getText(){
        return textarea2.getText();
    }
    // public String toString(String[][] array, int x, int y){
    // return array[x][y];
    // }
    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new GUI_project();
                }
            });
    }
}