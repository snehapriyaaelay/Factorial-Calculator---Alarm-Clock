import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;



 public class AlarmClock extends Applet implements Runnable, ActionListener{
	protected Thread clockThread = null;
	protected Font font = new Font("Monospaced", Font.BOLD,48);
	protected Color color = Color.BLACK;
	Button alarm_on, alarm_off;
	TextField hours, minutes;
	int hh,mm,set=0,ampm_alarm;
	AudioClip sound_click, min_alarm, alarm;
	Calendar calendar = Calendar.getInstance();
	int hour = calendar.get(Calendar.HOUR);
	int minute = calendar.get(Calendar.MINUTE);
	int second = calendar.get(Calendar.SECOND);
	int ampm = calendar.get(Calendar.AM_PM);
	Choice ampm_dropdown = new Choice();
	public void start(){
		setSize(700,700);
			if(clockThread == null){
				clockThread = new Thread(this);
				clockThread.start();
			}
			ampm_dropdown.add("AM");
			ampm_dropdown.add("PM");
			hours = new TextField(2);
			minutes = new TextField(2);
			add(hours);
			add(minutes);
			add(ampm_dropdown);
			hours.setText("HH");
			minutes.setText("MM");
			alarm_on = new Button("ALARM ON");
			alarm_off = new Button("ALARM OFF");
			add(alarm_on);
			add(alarm_off);
			alarm_on.addActionListener(this);
			alarm_off.addActionListener(this);
		//	sound_click = getAudioClip(getCodeBase(),"clock-ticking.wav");
		//	min_alarm= getAudioClip(getCodeBase(),"clock-cuckoo2.wav");
		//	alarm= getAudioClip(getCodeBase(),"alarm.wav");
			
	}
	public void stop(){
		clockThread = null;
	}
	public void run(){
		while(Thread.currentThread()== clockThread){
			repaint();
			try{
				Thread.currentThread().sleep(1000);
			}
			catch(InterruptedException e){
				
			}
		}
	}
	public void paint(Graphics g){
		Image img= getImage(getDocumentBase(), "analog.png");
		 setBackground(Color.white);
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int ampm = calendar.get(Calendar.AM_PM);
		String time_ampm = "";
		SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yyyy EEE");
		g.setColor(Color.BLACK);
		Date date = new Date();
		g.drawImage(img, 0, 0, null);
		if(ampm == 0) time_ampm = time_ampm + "AM"; else time_ampm = time_ampm + "PM";
		g.setFont(font);
		g.setColor(color);
		g.drawString(date_format.format(date), 96, 507);
		g.drawString(hour+":"+minute / 10 + minute % 10 +":"+second / 10 + second % 10+" "+time_ampm, 93, 563);

	/*	if((minute%15)==0){
			min_alarm.play();
			if(second > 10){
				min_alarm.stop();
			}
		} */
		
	/*	if(set ==1 ){
			if(hh==hour && mm==minute && ampm_alarm==ampm) alarm.play();
		}
		else alarm.stop();
		//	sound_click.play(); */
			switch(minute){
			
			case 1:	g.drawLine(248, 253, 270, 53); break;
			case 2:	g.drawLine(248, 253, 286, 56); break;
			case 3:	g.drawLine(248, 253, 306, 65); break;
			case 4:	g.drawLine(248, 253, 327, 68); break;
			case 5:	g.drawLine(248, 253, 348, 81); break;
			case 6:	g.drawLine(248, 253, 363, 90); break;
			case 7:	g.drawLine(248, 253, 380, 101); break;
			case 8:	g.drawLine(248, 253, 395, 117); break;
			case 9:	g.drawLine(248, 253, 407, 138); break;
			case 10: g.drawLine(248, 253, 420, 151); break;
			case 11: g.drawLine(248, 253, 428, 169); break;
			case 12: g.drawLine(248, 253, 436, 192); break;
			case 13: g.drawLine(248, 253, 439, 210); break;
			case 14: g.drawLine(248, 253, 440, 229); break;
			case 15: g.drawLine(248, 253, 441, 251); break;
			case 16: g.drawLine(248, 253, 442, 273); break;
			case 17: g.drawLine(248, 253, 440, 290); break;
			case 18: g.drawLine(248, 253, 435, 306); break;
			case 19: g.drawLine(248, 253, 429, 327); break;
			case 20: g.drawLine(248, 253, 416, 343); break;
			case 21: g.drawLine(248, 253, 405, 360); break;
			case 22: g.drawLine(248, 253, 396, 380); break;
			case 23: g.drawLine(248, 253, 380, 394); break;
			case 24: g.drawLine(248, 253, 365, 407); break;
			case 25: g.drawLine(248, 253, 348, 422); break;
			case 26: g.drawLine(248, 253, 332, 432); break;
			case 27: g.drawLine(248, 253, 311, 438); break;
			case 28: g.drawLine(248, 253, 290, 442); break;
			case 29: g.drawLine(248, 253, 267, 447); break;
			case 30: g.drawLine(248, 253, 246, 447); break;
			case 31: g.drawLine(248, 253, 226, 451); break;
			case 32: g.drawLine(248, 253, 207, 449); break;
			case 33: g.drawLine(248, 253, 188, 442); break;
			case 34: g.drawLine(248, 253, 164, 433); break;
			case 35: g.drawLine(248, 253, 149, 421); break;
			case 36: g.drawLine(248, 253, 127, 412); break;
			case 37: g.drawLine(248, 253, 113, 399); break;
			case 38: g.drawLine(248, 253, 101, 383); break;
			case 39: g.drawLine(248, 253, 89, 369); break;
			case 40: g.drawLine(248, 253, 78, 351); break;
			case 41: g.drawLine(248, 253, 68, 331); break;
			case 42: g.drawLine(248, 253, 58, 316); break;
			case 43: g.drawLine(248, 253, 52, 293); break;
			case 44: g.drawLine(248, 253, 51, 271); break;
			case 45: g.drawLine(248, 253, 47, 248); break;
			case 46: g.drawLine(248, 253, 47, 230); break;
			case 47: g.drawLine(248, 253, 51, 208); break;
			case 48: g.drawLine(248, 253, 60, 189); break;
			case 49: g.drawLine(248, 253, 66, 170); break;
			case 50: g.drawLine(248, 253, 75, 151); break;
			case 51: g.drawLine(248, 253, 87, 133); break;
			case 52: g.drawLine(248, 253, 100, 117); break;
			case 53: g.drawLine(248, 253, 116, 106); break;
			case 54: g.drawLine(248, 253, 134, 90); break;
			case 55: g.drawLine(248, 253, 153, 80); break;
			case 56: g.drawLine(248, 253, 170, 71); break;
			case 57: g.drawLine(248, 253, 191, 64); break;
			case 58: g.drawLine(248, 253, 207, 58); break;
			case 59: g.drawLine(248, 253, 228, 55); break;
			case 00: g.drawLine(248, 253, 248, 54); break;
						}
			switch(second){
			case 1:	g.drawLine(248, 253, 270, 53); break;
			case 2:	g.drawLine(248, 253, 286, 56); break;
			case 3:	g.drawLine(248, 253, 306, 65); break;
			case 4:	g.drawLine(248, 253, 327, 68); break;
			case 5:	g.drawLine(248, 253, 348, 81); break;
			case 6:	g.drawLine(248, 253, 363, 90); break;
			case 7:	g.drawLine(248, 253, 380, 101); break;
			case 8:	g.drawLine(248, 253, 395, 117); break;
			case 9:	g.drawLine(248, 253, 407, 138); break;
			case 10: g.drawLine(248, 253, 420, 151); break;
			case 11: g.drawLine(248, 253, 428, 169); break;
			case 12: g.drawLine(248, 253, 436, 192); break;
			case 13: g.drawLine(248, 253, 439, 210); break;
			case 14: g.drawLine(248, 253, 440, 229); break;
			case 15: g.drawLine(248, 253, 441, 251); break;
			case 16: g.drawLine(248, 253, 442, 273); break;
			case 17: g.drawLine(248, 253, 440, 290); break;
			case 18: g.drawLine(248, 253, 435, 306); break;
			case 19: g.drawLine(248, 253, 429, 327); break;
			case 20: g.drawLine(248, 253, 416, 343); break;
			case 21: g.drawLine(248, 253, 405, 360); break;
			case 22: g.drawLine(248, 253, 396, 380); break;
			case 23: g.drawLine(248, 253, 380, 394); break;
			case 24: g.drawLine(248, 253, 365, 407); break;
			case 25: g.drawLine(248, 253, 348, 422); break;
			case 26: g.drawLine(248, 253, 332, 432); break;
			case 27: g.drawLine(248, 253, 311, 438); break;
			case 28: g.drawLine(248, 253, 290, 442); break;
			case 29: g.drawLine(248, 253, 267, 447); break;
			case 30: g.drawLine(248, 253, 246, 447); break;
			case 31: g.drawLine(248, 253, 226, 451); break;
			case 32: g.drawLine(248, 253, 207, 449); break;
			case 33: g.drawLine(248, 253, 188, 442); break;
			case 34: g.drawLine(248, 253, 164, 433); break;
			case 35: g.drawLine(248, 253, 149, 421); break;
			case 36: g.drawLine(248, 253, 127, 412); break;
			case 37: g.drawLine(248, 253, 113, 399); break;
			case 38: g.drawLine(248, 253, 101, 383); break;
			case 39: g.drawLine(248, 253, 89, 369); break;
			case 40: g.drawLine(248, 253, 78, 351); break;
			case 41: g.drawLine(248, 253, 68, 331); break;
			case 42: g.drawLine(248, 253, 58, 316); break;
			case 43: g.drawLine(248, 253, 52, 293); break;
			case 44: g.drawLine(248, 253, 51, 271); break;
			case 45: g.drawLine(248, 253, 47, 248); break;
			case 46: g.drawLine(248, 253, 47, 230); break;
			case 47: g.drawLine(248, 253, 51, 208); break;
			case 48: g.drawLine(248, 253, 60, 189); break;
			case 49: g.drawLine(248, 253, 66, 170); break;
			case 50: g.drawLine(248, 253, 75, 151); break;
			case 51: g.drawLine(248, 253, 87, 133); break;
			case 52: g.drawLine(248, 253, 100, 117); break;
			case 53: g.drawLine(248, 253, 116, 106); break;
			case 54: g.drawLine(248, 253, 134, 90); break;
			case 55: g.drawLine(248, 253, 153, 80); break;
			case 56: g.drawLine(248, 253, 170, 71); break;
			case 57: g.drawLine(248, 253, 191, 64); break;
			case 58: g.drawLine(248, 253, 207, 58); break;
			case 59: g.drawLine(248, 253, 228, 55); break;
			case 00: g.drawLine(248, 253, 248, 54); break;
			}
			switch(hour){
			case 12: g.drawLine(248, 253, 248, 97); break;
			case 1:	g.drawLine(248, 253, 324, 123); break;
			case 2: g.drawLine(248, 253, 376, 188); break;
			case 3: g.drawLine(248, 253, 389, 254); break;
			case 4: g.drawLine(248, 253, 377, 316); break;
			case 5: g.drawLine(248, 253, 323, 374); break;
			case 6: g.drawLine(248, 253, 247, 381); break;
			case 7: g.drawLine(248, 253, 176, 373); break;
			case 8: g.drawLine(248, 253, 129, 313); break;
			case 9: g.drawLine(248, 253, 105, 252); break;
			case 10: g.drawLine(248, 253, 118, 117); break;
			case 11: g.drawLine(248, 253, 178, 124); break;
			case 00: g.drawLine(248, 253, 248, 97); break;
						}
			
	}
	public void actionPerformed(ActionEvent ae){
	Button source =(Button)ae.getSource();
	if(source.getLabel() == "ALARM ON") { 
		set=1;
		hh = Integer.parseInt(hours.getText());
		mm = Integer.parseInt(minutes.getText());
		if(ampm_dropdown.getSelectedItem() == "AM")
		ampm_alarm = 0;
		else
			ampm_alarm=1;
	}
	if(source.getLabel() == "ALARM OFF") set=0;

	}
		
}
 