import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


class question extends JFrame implements ActionListener{
	JTable table_question;
	JLabel l1,l2,l3,l4,l5,l6,l7,message;
	JTextField qn,qno,first,second,third,fourth,ans;
	JButton jButton1,jButton2,refresh,jButton4,back;
	
	
	
	
	
	
	question(String s){
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table_question=new JTable();
		add(table_question);
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		l6=new JLabel();
		l7=new JLabel();
		message=new JLabel();
		l1.setText("Question No.");
        l2.setText("Question ");
        l3.setText("1st Option");
        l4.setText("2nd Option");
        l5.setText("3rd Option");
        l6.setText("4th Option");
		l7.setText("Ans.");
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
		l1.setBounds(30,50,100,20);
		l2.setBounds(30,100,100,20);
		l3.setBounds(30,150,100,20);
		l4.setBounds(30,200,100,20);
		l5.setBounds(30,250,100,20);
		l6.setBounds(30,300,100,20);
		l7.setBounds(30,350,100,20);
		qn = new JTextField();
        qno = new JTextField();
        first = new JTextField();
        second = new JTextField();
        third = new JTextField();
        fourth = new JTextField();
        ans = new JTextField();
		qno.setBounds(130,50,150,25);
		qn.setBounds(130,100,150,25);
		first.setBounds(130,150,150,25);
		second.setBounds(130,200,150,25);
		third.setBounds(130,250,150,25);
		fourth.setBounds(130,300,150,25);
		ans.setBounds(130,350,150,25);
		add(qn);add(qno);add(first);add(second);add(third);add(fourth);add(ans);
		jButton1 = new JButton("ADD");
        jButton2 = new JButton("EDIT");
        refresh = new JButton("REFRESH");
        jButton4 = new JButton("DELETE");
		back=new JButton("BACK");
		jButton1.addActionListener(this);  
        jButton2.addActionListener(this);  
        refresh.addActionListener(this);
		jButton4.addActionListener(this);
		back.addActionListener(this);
		jButton1.setBounds(310,50,100,25);
		jButton2.setBounds(310,100,100,25);
		refresh.setBounds(310,150,100,25);
		jButton4.setBounds(310,200,100,25);
		back.setBounds(310,350,100,25);
		add(jButton1);add(jButton2);add(refresh);add(jButton4);add(back);
		table_question.setBounds(500,30,650,550);
		setLayout(null);  
        setLocation(50,50);  
        setVisible(true);  
        setSize(1200,650);
		
		getTableData();
	}
	private void getTableData(){
        Connection conn=null;
        Statement st=null;
        try{
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            String sql="SELECT * FROM qt_table";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Q-No", "Question", "1st Op", "2nd Op","3rd Op","4th Op","Ans"}, 0);
            while(rs.next())
            {
                String col1 = rs.getString("Q-No");
                String col2 = rs.getString("Question");
                String col3 = rs.getString("1st Op");                
                String col4 = rs.getString("2nd Op");
                String col5 = rs.getString("3rd Op");
                String col6 = rs.getString("4th Op");
                String col7 = rs.getString("Ans");
                model.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7});
            }
            table_question.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
	public void theQuery(String query){
        Connection conn=null;
        Statement st=null;
        //System.out.println(query);
        try{
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qt_table","root","");
            st = (Statement) conn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Congratulations!! The operation done successfully.");
            refreshMethod();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
	private void refreshMethod(){
        qno.setEditable(true);
        message.setText("");
        qno.setText("");
        qn.setText("");
        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");
        ans.setText("");
        getTableData(); 
    }
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jButton1){
			try{
			message.setText("");
			if(!qno.getText().equals("") && !qn.getText().equals("") && !first.getText().equals("")&& !second.getText().equals("")&& !third.getText().equals("")&& !fourth.getText().equals("")&& !ans.getText().equals("")){
				theQuery("INSERT INTO `qt_table`.`qt_table` (`Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans`) VALUES ('"+qno.getText()+"','"+qn.getText()+"','"+first.getText()+"','"+second.getText()+"','"+third.getText()+"','"+fourth.getText()+"','"+ans.getText()+"')");
			}
        else{
            message.setText("You must need to fill the fields!!");
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
		
		
		if(e.getSource()==jButton4){
			if(table_question.getSelectedRow()==-1){
			if(table_question.getSelectedRow()==0){
				message.setText("Table is empty!!");
				}
			else{
				 message.setText("You need to select an user");
				}
		}
		
		else{
			int selectedRowIndex = table_question.getSelectedRow();
			theQuery("DELETE FROM `qt_table`.`qt_table` WHERE `qt_table`.`Q-No` ="+table_question.getModel().getValueAt(selectedRowIndex, 0));
			}
		}
		
		if(e.getSource()==refresh){
			refreshMethod();
			getTableData();
		}
		if(e.getSource()==jButton2){
			if(table_question.getSelectedRow()==-1){
			if(table_question.getSelectedRow()==0){
				message.setText("Table is empty!!");
				}
			else{
				 message.setText("You need to select an user");
				}
			}
			else{
			qno.setEditable(false);
			int selectedRowIndex = table_question.getSelectedRow();        
			if(qno.getText().equals("") && qn.getText().equals("") && first.getText().equals("")&& second.getText().equals("")&& third.getText().equals("")&& fourth.getText().equals("")&& ans.getText().equals("")){
				qno.setText(table_question.getModel().getValueAt(selectedRowIndex, 0).toString());
				qn.setText(table_question.getModel().getValueAt(selectedRowIndex, 1).toString());
				first.setText(table_question.getModel().getValueAt(selectedRowIndex, 2).toString());
				second.setText(table_question.getModel().getValueAt(selectedRowIndex, 3).toString());
				third.setText(table_question.getModel().getValueAt(selectedRowIndex, 4).toString());
				fourth.setText(table_question.getModel().getValueAt(selectedRowIndex, 5).toString());
				ans.setText(table_question.getModel().getValueAt(selectedRowIndex, 6).toString());
			}
			else if(!qno.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!qn.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!first.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!second.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!third.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!fourth.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())||
					!ans.getText().equals(table_question.getModel().getValueAt(selectedRowIndex, 0).toString())){            
				
				theQuery("UPDATE `qt_table` SET `Q-No`='"+qno.getText()+"',`Question`='"+qn.getText()+"',`1st Op`='"+first.getText()+"',`2nd Op`='"+second.getText()+"',`3rd Op`='"+third.getText()+"',`4th Op`='"+fourth.getText()+"',`Ans`='"+ans.getText()+"' WHERE `qt_table`.`Q-No` ="+qno.getText());
				//String update="UPDATE `qt_table` SET `Q-No`="+qno.getText()+",`Question`="+qn.getText()+",`1st Op`="+first.getText()+",`2nd Op`="+second.getText()+",`3rd Op`="+third.getText()+",`4th Op`="+fourth.getText()+",`Ans`="+ans.getText()+ " WHERE `Q-No`="+qno.getText();
				//System.out.println(update);
				}
			else{
				message.setText("You dont't update the value!!");
				}
		
			}
		}
		if(e.getSource().equals(back)){
			Start s=new Start("Start Page");
			s.setVisible(true);
			super.dispose();
		}
	}
	
	public static void main(String s[])  
    {  
        new question("Question Change");  
    }
}