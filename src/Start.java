import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

class Start extends JFrame implements ActionListener{


	JButton b1,b2;
	Start(String s){
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		b1=new JButton("Start Quiz");
		b2=new JButton("Change Question");
		b1.setBounds(110,90,300,50);
		b2.setBounds(180,170,150,20);
		add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
        setLocation(250,100);  
        setVisible(true);  
        setSize(520,320);  
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(b1)){
			OnlineTest o=new OnlineTest("Online Test Of Java");
			o.setVisible(true);
			super.dispose();
		}
		if(e.getSource().equals(b2)){
			login l=new login("login for Question Changing");
			l.setVisible(true);
			super.dispose();
		}
	}
	
	public static void main(String s[])  
    {  
        new Start("Start Page");  
    }
}