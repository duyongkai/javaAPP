package guess_number_game;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.lang.Integer;

public class GUI extends JFrame implements ActionListener {
	/**
	 * new a GUI to response many events.
	 */
	private static final long serialVersionUID = 1L;
	
	
	JLabel label_up=new JLabel("-");
	JTextField txt_up = new JTextField("100");
	
	JLabel label_low=new JLabel("设置上下限");
	JTextField txt_low = new JTextField("0");
	
	JLabel label_setTimes=new JLabel("设置允许的次数");
	JTextField txt_setTimes = new JTextField("10");
	
	JLabel label_myNum=new JLabel("自己所猜的数字");
	JTextField txt_myNum = new JTextField();
	
	JLabel label_times=new JLabel("已经猜的次数");
	JTextField txt_times = new JTextField("0");
	
	JLabel label_time=new JLabel("所用时间");
	JTextField txt_time = new JTextField(" 秒");
	
	JLabel label_compare=new JLabel("提示信息");
	JTextField txt_compare = new JTextField();
	
	JButton btn_start = new JButton("开始");
	JButton btn_submit = new JButton("提交");
	
	JTextArea txt_result = new JTextArea();
	
	int randomNum, times, set_times = 10, lower = 0, upper = 100;
	long startTime, endTime;
	
	
	
	GUI() {
		super("猜数字游戏");
		this.setSize(1000, 618);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(null);
		
		/*下限的label与text*/
		label_low.setFont(label_low.getFont().deriveFont(26.0f));
		label_low.setBounds(30, 50, 230, 50);
		c.add(label_low);
		
		txt_low.setFont(txt_low.getFont().deriveFont(26.0f));
		txt_low.setBounds(270, 50, 70, 50);
		c.add(txt_low);
		
		/*上限的label与text*/
		label_up.setFont(label_up.getFont().deriveFont(26.0f));
		label_up.setBounds(340, 50, 10, 50);
		c.add(label_up);
		
		txt_up.setFont(txt_up.getFont().deriveFont(26.0f));
		txt_up.setBounds(350, 50, 70, 50);
		c.add(txt_up);
		
		/*设置可以猜的次数的label与text*/
		label_setTimes.setFont(label_setTimes.getFont().deriveFont(26.0f));
		label_setTimes.setBounds(530, 50, 230, 50);
		c.add(label_setTimes);
		
		txt_setTimes.setFont(txt_setTimes.getFont().deriveFont(26.0f));
		txt_setTimes.setBounds(770, 50, 150, 50);
		c.add(txt_setTimes);
		
		/*自己输入数字的label与text*/
		label_myNum.setFont(label_myNum.getFont().deriveFont(26.0f));
		label_myNum.setBounds(30, 150, 230, 50);
		c.add(label_myNum);
		
		txt_myNum.setFont(txt_myNum.getFont().deriveFont(26.0f));
		txt_myNum.setBounds(270, 150, 150, 50);
		txt_myNum.setEditable(false);
		c.add(txt_myNum);
		
		/*比较的label与text*/
		label_compare.setFont(label_compare.getFont().deriveFont(26.0f));
		label_compare.setBounds(530, 150, 230, 50);
		c.add(label_compare);
		
		txt_compare.setFont(txt_compare.getFont().deriveFont(26.0f));
		txt_compare.setBounds(770, 150, 150, 50);
		txt_compare.setEditable(false);
		c.add(txt_compare);
		
		/*次数的label与text*/
		label_times.setFont(label_times.getFont().deriveFont(26.0f));
		label_times.setBounds(30, 250, 230, 50);
		c.add(label_times);
		
		txt_times.setFont(txt_times.getFont().deriveFont(26.0f));
		txt_times.setBounds(270, 250, 150, 50);
		txt_times.setEditable(false);
		c.add(txt_times);
		
		/*时间的label与text*/
		label_time.setFont(label_time.getFont().deriveFont(26.0f));
		label_time.setBounds(530, 250, 230, 50);
		c.add(label_time);
		
		txt_time.setFont(txt_time.getFont().deriveFont(0.0f));
		txt_time.setBounds(770, 250, 150, 50);
		txt_time.setEditable(false);
		c.add(txt_time);
		
		/*开始按钮*/
		btn_start.setFont(btn_start.getFont().deriveFont(26.0f));
		btn_start.setBounds(30, 350, 390, 50);
		btn_start.addActionListener(this);	//设置按钮的监听事件
		c.add(btn_start);
		
		/*提交按钮*/
		btn_submit.setFont(btn_submit.getFont().deriveFont(26.0f));
		btn_submit.setBounds(530, 350, 390, 50);
		btn_submit.addActionListener(this);	//设置按钮的监听事件
		btn_submit.setEnabled(false);
		c.add(btn_submit);
		
		/*最低层文本域*/
		txt_result.setFont(txt_time.getFont().deriveFont(26.0f));
		txt_result.setBounds(30, 450, 890, 80);
		txt_result.setLineWrap(true);
		c.add(txt_result);
		
		this.setVisible(true);
	}
	/*****************************************************************************************************************************************/
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		JButton finish = new JButton();
		/*判断那个按钮按下，以执行相应的操作*/
		if(btn.getText().equals("开始") || btn.getText().equals("停止")) {
			/*如果按下的是start按钮*/
			if(btn.getText().equals("开始")) {
				txt_result.setText("");
				btn_start.setText("停止");
				times = 0;
				txt_time.setFont(txt_time.getFont().deriveFont(26.0f));
				txt_myNum.setEditable(true);
				btn_submit.setEnabled(true);
				txt_low.setEditable(false);
				txt_up.setEditable(false);
				txt_setTimes.setEditable(false);
				txt_compare.setText("");
				txt_time.setText(" 秒");
				txt_times.setText("0");
				try {
					lower = Integer.valueOf(txt_low.getText());
					upper = Integer.valueOf(txt_up.getText());
					if((upper - lower) <= 5) {
						JOptionPane.showMessageDialog(btn_start, "你输入的上下限必须满足“上限-下限>5”'", "警告！", JOptionPane.WARNING_MESSAGE);
						btn_start.setText("开始");
						txt_time.setFont(txt_time.getFont().deriveFont(0.0f));
						btn_submit.setEnabled(false);
						txt_low.setEditable(true);
						txt_up.setEditable(true);
						txt_myNum.setEditable(false);
						txt_setTimes.setEditable(true);
					}
					randomNum = (int)(Math.random()*(upper - lower)) + lower;
					set_times = Integer.valueOf(txt_setTimes.getText());
					startTime = System.currentTimeMillis();	//get the start time
				} catch(NumberFormatException numForEx) {
					txt_time.setFont(txt_time.getFont().deriveFont(0.0f));
					btn_start.setText("开始");
					btn_submit.setEnabled(false);
					txt_myNum.setEditable(false);
					txt_low.setEditable(true);
					txt_up.setEditable(true);
					txt_setTimes.setEditable(true);
					JOptionPane.showMessageDialog(btn_start, "请输入一个整数", "错误！", JOptionPane.ERROR_MESSAGE);
				}
			}
			/*如果按下的是stop按钮*/
			else {
				finish.setEnabled(true);
				endAction();
				btn_start.setText("开始");
				finish.setEnabled(false);
			}
		}
		/*如果按下的submit按钮*/
		else {
			try {
				int myNum = Integer.valueOf(txt_myNum.getText());
				times += 1;	//记录猜的次数
				txt_times.setText(Integer.toString(times));
				/*对自己输入的数字的各种情况进行判断，记住以下的顺序不允许交换*/
				if(times > set_times) {
					finish.setEnabled(true);
					endAction();
					btn_start.setText("开始");
					JOptionPane.showMessageDialog(finish, "抱歉！你猜的次数过多了。请点击“开始”重试！", "抱歉！", JOptionPane.INFORMATION_MESSAGE);
					finish.setEnabled(false);
				}
				else if(myNum > upper) {
					finish.setEnabled(true);
					JOptionPane.showMessageDialog(finish, "请输入一个小于上限的数字", "警告！", JOptionPane.WARNING_MESSAGE);
					finish.setEnabled(false);
				}
				else if(myNum < lower) {
					finish.setEnabled(true);
					JOptionPane.showMessageDialog(finish, "请输入一个大于下限的数字", "警告！", JOptionPane.WARNING_MESSAGE);
					finish.setEnabled(false);
				}
				else if(myNum > randomNum) {
					txt_compare.setText("偏大");
				}
				else if(myNum < randomNum) {
					txt_compare.setText("偏小");
				}
				else {
					txt_compare.setText("相等");
					finish.setEnabled(true);
					endAction();
					btn_start.setText("开始");
					JOptionPane.showMessageDialog(finish, "恭喜你！你猜对了！点击“开始”按钮可重玩。", "恭喜你！", JOptionPane.INFORMATION_MESSAGE);
					finish.setEnabled(false);
				}
			} catch(NumberFormatException numForEx) {
				JOptionPane.showMessageDialog(btn_start, "请输入一个整数！", "错误！", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**停止每一次游戏时候的必须执行的操作**/
	private void endAction() {
		btn_submit.setEnabled(false);
		txt_myNum.setEditable(false);
		txt_low.setEditable(true);
		txt_up.setEditable(true);
		txt_setTimes.setEditable(true);
		txt_result.setText("答案是： ");
		txt_result.append(Integer.toString(randomNum)+"\n");
		endTime = System.currentTimeMillis();	//get the end time
		txt_time.setFont(txt_time.getFont().deriveFont(0.0f));
		long spentTime=(endTime - startTime)/1000;
		txt_result.append("你所用的时间是： ");
		txt_result.append(Integer.toString((int)spentTime) + " 秒");
	}
}
