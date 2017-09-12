package stop_watch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

/**
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class StopWatch extends JApplet 
{
	private JButton start, stop;
	private Timer timer;
	private JLabel time;
	private int seconds, minutes, hours;
	private DecimalFormat formatter;
	
	public void init()
	{
		formatter = new DecimalFormat("00");
		
		start = new JButton("Start");
		stop = new JButton("Stop");
		time = new JLabel("00 : 00 : 00");
		time.setHorizontalAlignment(JLabel.CENTER);
		timer = new Timer(1000, new TimeListener());
		
		setLayout(new BorderLayout());
		start.addActionListener(new StartListener());
		stop.addActionListener(new StopListener());
		
		add(start, BorderLayout.WEST);
		add(stop, BorderLayout.EAST);
		add(time, BorderLayout.CENTER);
		
		seconds = minutes = hours = 0;
	}
	
	public class StopListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			timer.stop();
		}
	}
	
	public class StartListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			timer.start();
		}
	}
	
	public class TimeListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			calcTime();
			updateTime();
		}
	}
	
	private void updateTime()
	{
		time.setText(formatter.format((seconds / 3600)) + " : " + formatter.format((seconds / 60)) + " : " + formatter.format(seconds));
	}
	
	private void calcTime()
	{
		if(seconds < 60)
			seconds++;
		else
		{
			if(minutes < 60)
			{
				seconds = 0;
				minutes++;
			}
			else
			{
				seconds = 0;
				minutes = 0;
				hours++;
			}
		}

	}
}
