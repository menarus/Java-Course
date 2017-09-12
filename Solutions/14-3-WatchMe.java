package watch_me;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JApplet;

/**
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class WatchMeAp extends JApplet 
{
	private int mouseX, mouseY;
	private boolean entered = false;
	private final int x = 150, y = 100;
	private final int pupilSize = 50;
	
	public void init()
	{
		getContentPane().setBackground(Color.white);
		addMouseMotionListener(new MyMouseMotionListener());
		addMouseListener(new MyMouseListener());
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.black);
		
		g.drawOval(x      , y     , 100, 200);
		g.drawOval(x + 200, y     , 100, 200);
		
		if(!entered)
		{
			g.fillOval(x + 25 , y + 75, pupilSize , pupilSize);
			g.fillOval(x + 225, y + 75, pupilSize , pupilSize);
		}
		else
		{
			// down right
			if(mouseX > x + 300 && mouseY > y + 200)
			{
				g.fillOval(x + 40 , y + 125, pupilSize , pupilSize);
				g.fillOval(x + 240, y + 125, pupilSize , pupilSize);
			}
			// up right
			else if(mouseX > x + 300 && mouseY < y)
			{
				g.fillOval(x + 40 , y + 25, pupilSize , pupilSize);
				g.fillOval(x + 240, y + 25, pupilSize , pupilSize);
			}
			// down left
			else if(mouseX < x && mouseY > y + 200)
			{
				g.fillOval(x + 10 , y + 125, pupilSize , pupilSize);
				g.fillOval(x + 210, y + 125, pupilSize , pupilSize);
			}
			// up left
			else if(mouseX < x && mouseY < y)
			{
				g.fillOval(x + 10 , y + 25, pupilSize , pupilSize);
				g.fillOval(x + 210, y + 25, pupilSize , pupilSize);
			}
			// left
			else if(mouseX < x)
			{
				g.fillOval(x + 0 , y + 75, pupilSize , pupilSize);
				g.fillOval(x + 200, y + 75, pupilSize , pupilSize);
			}
			// right
			else if(mouseX > x + 300)
			{
				g.fillOval(x + 50 , y + 75, pupilSize , pupilSize);
				g.fillOval(x + 250, y + 75, pupilSize , pupilSize);
			}
			// up
			else if(mouseY < y)
			{
				g.fillOval(x + 25 , y + 25, pupilSize , pupilSize);
				g.fillOval(x + 225, y + 25, pupilSize , pupilSize);
			}
			// down
			else if(mouseY > y + 200)
			{
				g.fillOval(x + 25 , y + 125, pupilSize , pupilSize);
				g.fillOval(x + 225, y + 125, pupilSize , pupilSize);
			}
			// center
			else
			{
				g.fillOval(x + 25 , y + 75, pupilSize , pupilSize);
				g.fillOval(x + 225, y + 75, pupilSize , pupilSize);
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			entered = true;
			repaint();
		}
		
		public void mouseExited(MouseEvent e)
		{
			entered = false;
			repaint();
		}
	}
	
	private class MyMouseMotionListener extends MouseMotionAdapter
	{
		public void mouseMoved(MouseEvent e)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			
			repaint();
		}
	}
}
