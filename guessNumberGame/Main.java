package guess_number_game;

import java.lang.Integer;

public class Main {
	
	public static void main(String[] args) {
		GUI window = new GUI();	//构造一个GUI类
		while(true) {
			try {
				window.endTime = System.currentTimeMillis();
				window.txt_time.setText(Integer.toString(spendTime(window.startTime, window.endTime)));
			} catch(NullPointerException P) {
			}
		}
	}
	
	public static int spendTime(long startTime, long endTime) {
		int spendTime;
		spendTime = (int)((endTime - startTime)/1000);
		return spendTime;
	}
}
