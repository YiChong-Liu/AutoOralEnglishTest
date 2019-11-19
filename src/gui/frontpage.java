package gui;

import backend.Readwords;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class frontpage extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton start;
	JTextArea showContent=null;
	static JTextArea noticeboard=null;
	
	static int flag=0;
	public frontpage(){
		
		this.setTitle("英语考试系统");
		this.setSize(800,800);
		this.setLocation(200,200);
		this.setLayout(null);
	}
	
	
	private void init() {
		Readwords rd=new Readwords();
		start=new JButton("点击开始测试");
		Font style=new Font("宋体",Font.BOLD,32);
		start.setFont(style);
		start.setBounds(200,600,400,120);
		
		
		showContent=new JTextArea("");
		showContent.setBounds(50,50,700,260);
		
		noticeboard=new JTextArea("");
		noticeboard.setBounds(50,400,700,80);
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag=1;
				showContent.setText(rd.concludeContent());
				Font f1=new Font("华文仿宋",Font.BOLD,20);
				showContent.setFont(f1);
			}
			
		});
		
		
		this.add(showContent);
		this.add(noticeboard);
		this.add(start);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void endTest() {
		try {
			Thread.sleep(36*1000);
			Color  red  = new Color(255, 0, 0);
			noticeboard.setText("Times up!");
			Font f2=new Font("华文仿宋",Font.BOLD,26);
			noticeboard.setFont(f2);
			Thread.sleep(1000);
			noticeboard.setText("");
		}catch(Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		frontpage OETS=new frontpage();
		while(true) {
			OETS.init();
			if(flag==1) {
				OETS.endTest();
			}
			flag=0;
		}
	}

}
