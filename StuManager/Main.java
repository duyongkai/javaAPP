import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		MyFrame f=new MyFrame();
	}
}

class MyFrame extends JFrame implements ActionListener{
	JTextField txt_xm=new JTextField();
	JTextField txt_xh=new JTextField();
	JRadioButton rb_male=new JRadioButton("��");
	JRadioButton rb_female=new JRadioButton("Ů");
	ButtonGroup bg=new ButtonGroup();
	JTextField txt_nl=new JTextField();
	JButton btn_add,btn_save,btn_open;
	ArrayList<Student> stuList=new ArrayList<Student>();
	int current=0;
	
	MyFrame(){
		super("ѧ�����ݹ���ϵͳ");
		this.setSize(600, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(null);
		
		JLabel label_xm=new JLabel("������");
		label_xm.setFont(label_xm.getFont().deriveFont(26.0f));
		label_xm.setBounds(50, 60, 100, 30);
		c.add(label_xm);
		
		txt_xm.setFont(txt_xm.getFont().deriveFont(26.0f));
		txt_xm.setBounds(150, 60, 150, 30);
		c.add(txt_xm);
		
		JLabel label_xh=new JLabel("ѧ�ţ�");
		label_xh.setFont(label_xh.getFont().deriveFont(26.0f));
		label_xh.setBounds(50, 20, 100, 30);
		c.add(label_xh);

		txt_xh.setFont(txt_xh.getFont().deriveFont(26.0f));
		txt_xh.setBounds(150, 20, 150, 30);
		c.add(txt_xh);
		
		JLabel lb_gender=new JLabel("�Ա�");
		lb_gender.setFont(lb_gender.getFont().deriveFont(26.0f));
		lb_gender.setBounds(50, 100, 100, 30);
		c.add(lb_gender);
		
		rb_male.setFont(rb_male.getFont().deriveFont(26.0f));
		rb_male.setBounds(150, 100, 60, 30);
		c.add(rb_male);
		
		rb_female.setFont(rb_female.getFont().deriveFont(26.0f));
		rb_female.setBounds(220, 100, 60, 30);
		c.add(rb_female);
		
		bg.add(rb_female);
		bg.add(rb_male);
		
		JLabel lb_nl=new JLabel("���䣺");
		lb_nl.setFont(lb_nl.getFont().deriveFont(26.0f));
		lb_nl.setBounds(50, 140, 100, 30);
		c.add(lb_nl);
		
		txt_nl.setFont(txt_nl.getFont().deriveFont(26.0f));
		txt_nl.setBounds(150, 140, 100, 30);
		c.add(txt_nl);
		
		btn_save=new JButton("�����ļ�");
		btn_save.setFont(btn_save.getFont().deriveFont(26.0f));
		btn_save.setBounds(50, 180, 150, 30);
		btn_save.addActionListener(this);
		btn_save.setEnabled(false);
		c.add(btn_save);
		
		btn_open=new JButton("���ļ�");
		btn_open.setFont(btn_open.getFont().deriveFont(26.0f));
		btn_open.setBounds(200, 180, 150, 30);
		btn_open.addActionListener(this);
		c.add(btn_open);
		
		JButton btn_first=new JButton("��һ��");
		btn_first.setFont(btn_first.getFont().deriveFont(26.0f));
		btn_first.setBounds(380, 20, 150, 30);
		btn_first.addActionListener(this);
		c.add(btn_first);
		
		JButton btn_pre=new JButton("��һ��");
		btn_pre.setFont(btn_pre.getFont().deriveFont(26.0f));
		btn_pre.setBounds(380, 60, 150, 30);
		btn_pre.addActionListener(this);
		c.add(btn_pre);
		
		JButton btn_next=new JButton("��һ��");
		btn_next.setFont(btn_next.getFont().deriveFont(26.0f));
		btn_next.setBounds(380, 100, 150, 30);
		btn_next.addActionListener(this);
		c.add(btn_next);
		
		JButton btn_last=new JButton("���һ��");
		btn_last.setFont(btn_last.getFont().deriveFont(26.0f));
		btn_last.setBounds(380, 140, 150, 30);
		btn_last.addActionListener(this);
		c.add(btn_last);
		
		btn_add=new JButton("����ѧ��");
		btn_add.setFont(btn_add.getFont().deriveFont(26.0f));
		btn_add.setBounds(380, 180, 150, 30);
		btn_add.addActionListener(this);
		btn_add.setEnabled(false);
		c.add(btn_add);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		File file=new File("Student.txt");
		// �ж��û����µİ�ť����һ��
		JButton btn=(JButton)event.getSource();
		if(btn.getText().equals("�����ļ�")){
			try {
				FileOutputStream fos=new FileOutputStream(file);
				OutputStreamWriter osw=new OutputStreamWriter(fos);
				for(int i=0;i<stuList.size();i++){
					//���б��л�ȡ��i��ѧ��������
					Student stu=stuList.get(i);
					//���ı�������ݶ�ȡ��д���ļ�
					osw.write(stu.xh+" "+stu.xm+" "+stu.xb+" "+stu.nl+"\n");
				}
				osw.close();
				fos.close();
				JOptionPane.showMessageDialog(null, "���Ѿ��ɹ�����������", "ѧ�����ݹ���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "�Բ��𣬱����ļ�ʧ���ˣ�", "ѧ�����ݹ���ϵͳ", JOptionPane.ERROR_MESSAGE);
			}
		}else if(btn.getText().equals("���ļ�")){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis);
				BufferedReader br=new BufferedReader(isr);
				String str;
				while((str=br.readLine()) != null){
					//���ļ��ж�ȡ���������õ��ı�����
					String temp[]=str.split(" ");
					//ʹ���ļ��е����ݽ���ѧ������
					Student stu=new Student(temp[0],temp[1],temp[2],Integer.parseInt(temp[3]));
					//��ѧ����ӵ�ѧ���б�
					stuList.add(stu);
				}
				//��ѧ��������ʾ�ڴ�����
				this.showStu(0);
				br.close();
				isr.close();
				fis.close();
				btn_save.setEnabled(true);
				//JOptionPane.showMessageDialog(null, "���Ѿ��ɹ�����������", "ѧ�����ݹ���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "�Բ��𣬴��ļ�ʧ���ˣ�", "ѧ�����ݹ���ϵͳ", JOptionPane.ERROR_MESSAGE);
			}
		}else if(btn.getText().equals("��һ��")){
			showStu(current-1);
			current = current - 1;
		}else if(btn.getText().equals("��һ��")){
			if(current == stuList.size() - 1){
				txt_xm.setText("");
				txt_xh.setText("");
				txt_nl.setText("");
				rb_male.setSelected(true);
				btn_add.setEnabled(true);
			}else{
				showStu(current+1);
				current = current + 1;
			}
		}else if(btn.getText().equals("��һ��")){
			showStu(0);
			current = 0;
		}else if(btn.getText().equals("���һ��")){
			showStu(stuList.size()-1);
			current = stuList.size() - 1;
		}else if(btn.getText().equals("����ѧ��")){
			Student stu=new Student();
			stu.xm=txt_xm.getText();
			stu.xh=txt_xh.getText();
			stu.xb=(rb_male.isSelected()?"Male":"Female");
			stu.nl=Integer.parseInt(txt_nl.getText());
			stuList.add(stu);
			current=stuList.size()-1;
			JOptionPane.showMessageDialog(null, "���Ѿ��ɹ������һ������", "ѧ�����ݹ���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	void showStu(int index){
		//��ѧ���б���ȡ����Ӧindex��ѧ��
		Student stu = stuList.get(index);
		//��ѧ����Ϣչ�ֵ���ƵĽ�����
		this.txt_xh.setText(stu.xh);
		this.txt_xm.setText(stu.xm);
		this.txt_nl.setText(""+stu.nl);
		if(stu.xb.equals("male"))
			this.rb_male.setSelected(true);
		else
			this.rb_female.setSelected(true);
	}
}

class Student{
	String xh;
	String xm;
	String xb;
	int nl;
	
	Student(){
		
	}
	
	Student(String xh,String xm,String xb,int nl){
		this.xh=xh;
		this.xm=xm;
		this.xb=xb;
		this.nl=nl;
	}
}
