import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class out extends JFrame implements ActionListener {
    JFrame frame;
    JTextField tf1;
    JButton submit;
    JTextField txt;
    JPasswordField val;
    
    protected String emailId;
    protected String paswd;
    JLabel res;
    JLabel attempt;

    static int attempts=3;
    out() {
        frame = new JFrame("Login Page!");
        JLabel l = new JLabel("Enter your Credentials");
        l.setForeground(Color.LIGHT_GRAY);
        l.setBounds(20, 15, 250, 50);

        JLabel l1 = new JLabel("UserName: ");
        l1.setBounds(20, 60, 100, 30);
        l1.setForeground(Color.LIGHT_GRAY);
        txt = new JTextField();
        txt.setBackground(Color.orange);
        txt.setBounds(100, 60, 120, 30);
        txt.setToolTipText("Enter your Username");

        JLabel l2 = new JLabel("Password: ");
        l2.setBounds(20, 120, 100, 30);
        l2.setForeground(Color.LIGHT_GRAY);
        val = new JPasswordField();
        val.setBounds(100, 120, 120, 30);
        val.setBackground(Color.orange);
        val.setToolTipText("Enter your password");

        submit = new JButton("Login");
        submit.setForeground(Color.white);
        submit.setBackground(Color.magenta);
        submit.setToolTipText("Click to Login");
        submit.setBounds(100, 170, 80, 30);

        res= new JLabel();
        res.setBounds(70,250,150,40);
        res.setVisible(true);

        attempt = new JLabel();
        attempt.setBounds(70,300,150,40);

        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.add(val);
        frame.add(l1);
        frame.add(l);
        frame.add(l2);
        frame.add(submit);
        frame.add(txt);
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(res);
        frame.add(attempt);
        submit.addActionListener(this);
        frame.getContentPane().setBackground(Color.black);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    void display(){
        /**
         * the login credentials are being checked
         * email = dd
         * password = 1234
         */
        if(emailId.compareTo("dd")==0 && paswd.compareTo("1234")==0)
        {
            res.setText("Logged in successfully");
            res.setForeground(Color.GREEN);
            val.setEditable(false);
            txt.setEditable(false);
            submit.setEnabled(false);
            afterLogin x= new afterLogin();

        }
        else{
            res.setText("Incorrect Password/email");
            res.setForeground(Color.red);
            attempts--;
        }
        attempt.setText("Attempts left: "+attempts);
        attempt.setVisible(true);
    }
    public static void main(String[] args) {
        new out();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        emailId = txt.getText();
        paswd = new String(val.getPassword());
        display();
        
        switch(attempts)
        {
            case 0: 
            attempt.setText("ERR: Cannot sign in");
            attempt.setForeground(Color.red);
            submit.setEnabled(false);
            break;

            case 1:attempt.setForeground(Color.orange); break;
            case 2:attempt.setForeground(Color.yellow); break;
            case 3:attempt.setForeground(Color.green); break;
        }
        
    }
}

class afterLogin extends Canvas{

    public void paint(Graphics g){
        g.drawString("Hello", 40, 40);
        setBackground(Color.gray);
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        setForeground(Color.YELLOW);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);
    }

    afterLogin(){
        JFrame f=new JFrame("Welcome to the dashboard");
        f.setAlwaysOnTop(true);
        f.getContentPane().setBackground(Color.GRAY);
        JLabel l=new JLabel("Hello Dipankar");
        l.setBounds(10,20,100,40);
        f.add(l);
        f.add(this);
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}