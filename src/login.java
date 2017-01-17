import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  


class login extends JFrame implements ActionListener{
	JLabel j1,j2;
	JTextField t1,t2;
	JPasswordField p1;
	JButton b1;
	login(String s){
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		j1=new JLabel();
		j2=new JLabel();
		j1.setText("USER NAME");
		j2.setText("PASSWORD");
		j1.setBounds(70,50,100,20);
		j2.setBounds(70,100,100,20);
		t1=new JTextField();
		p1=new JPasswordField();
		t1.setBounds(220,50,200,20);
		p1.setBounds(220,100,200,20);
		b1=new JButton("Login");
		b1.setBounds(270,170,100,30);
		add(j1);add(j2);add(t1);add(p1);add(b1);
		b1.addActionListener(this);
        setLocation(250,100);  
        setVisible(true);  
        setSize(520,320);  
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			//super.dispose();
			if(t1.getText().equals("root")){
				question q=new question("Question Change");
				q.setVisible(true);
			}
			super.dispose();
		}
	}
	
	public static void main(String s[])  
    {  
        new login("login for Question Changing");  
    }
}