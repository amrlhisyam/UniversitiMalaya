
package bank.management.system;
import javax.swing.* ; 
import java.awt.* ; 
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{

    JButton login, signup, clear ; 
    JTextField CardTextField; 
    JPasswordField pinTextField ; 
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons.png")) ; 
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ; 
        JLabel label = new JLabel (i3);
        label.setBounds(70,10,100,100) ; 
        
        add(label);
        
        JLabel text = new JLabel ("Welcone to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardNo = new JLabel ("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(200, 150, 400, 40);
        add(cardNo);
        
        CardTextField = new JTextField() ; 
        CardTextField.setBounds(400,155,250,30);
        CardTextField.setFont(new Font("Artial", Font.BOLD,28));
        add(CardTextField);
        
        
        
        JLabel pin = new JLabel ("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(200, 220, 400, 40);
        add(pin);
        
        pinTextField = new JPasswordField() ; 
        pinTextField.setBounds(400,225,250,30);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(400,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(550,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(470,350,100,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        add(signup);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            CardTextField.setText("") ; 
            pinTextField.setText("");
        }
        else if (ae.getSource() == login){
        
        }
        else if (ae.getSource() == signup){
        
        }
    }

    public static void main(String[] args) {
        new Login();
    }
    
}
