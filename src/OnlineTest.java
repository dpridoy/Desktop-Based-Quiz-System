import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,b;
	ButtonModel buttonModel;
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(40,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
	String getSelectedButtonText(JRadioButton j1,JRadioButton j2,JRadioButton j3,JRadioButton j4) {
		
		if (j1.isSelected()) {
		b = j1.getText();
		} else if (j2.isSelected()) {
		b = j2.getText();
		} else if (j3.isSelected()) {
		b = j3.getText();
		}else if (j4.isSelected()) {
		b = j4.getText();
		}
		return b;
	
	}
    void set()  
    {
		jb[4].setSelected(true);  
        if(current==0)  
        {  
			try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=1";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
				s1=rs.getString("Ans");
                //System.out.println(s1);
                
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}   
        }
		if(current==1)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=2";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
				s2=rs.getString("Ans");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
        } 
        if(current==2)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=3";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s3=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}  
        }  
        if(current==3)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=4";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s4=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}  
        }  
        if(current==4)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=5";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s5=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
        }  
        if(current==5)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=6";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s6=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
        }  
        if(current==6)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=7";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s7=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
        }  
        if(current==7)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=8";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s8=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
        }  
        if(current==8)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=9";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s9=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
        }  
        if(current==9)  
        {  
            try{
            Connection conn=null;
            Statement st=null;
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT `Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans` FROM `qt_table` WHERE `Q-No`=10";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l.setText(rs.getString("Question"));
                jb[0].setText(rs.getString("1st Op"));
                jb[1].setText(rs.getString("2nd Op"));
                jb[2].setText(rs.getString("3rd Op"));
                jb[3].setText(rs.getString("4th Op"));
                s10=rs.getString("Ans");
                //System.out.println(s1);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			} 
        }  
        l.setBounds(40,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0){
			//a=getSelectedButtonText(jb[0],jb[1],jb[2],jb[3]);
			//System.out.println(a);
			if(s1.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==1){
			if(s2.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}    
        if(current==2){
			if(s3.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==3){
			if(s4.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==4){
			if(s5.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==5){
			if(s6.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==6){
			if(s7.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==7){
			if(s8.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==8){
			if(s9.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        if(current==9){
			if(s10.equals(getSelectedButtonText(jb[0],jb[1],jb[2],jb[3])))
				return true;
		}  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
} 