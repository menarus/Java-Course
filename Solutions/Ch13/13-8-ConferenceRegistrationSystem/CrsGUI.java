package conference_registration_system;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

/**
 * This class designs a GUI for the conference registration system.
 * It will allow the user to select a registration type, 
 * dinner/speech attendance, as well as optional workshop participation.
 * This class utilizes action listeners for combo boxes and check boxes, and a list selection listener for lists.
 * This class demonstrates the ability to implement aforementioned listeners, 
 * utilize the aforementioned JComponents, use JIcons, Tooltips, Mnemonics,
 * scroll panes, and menu bars and menu bar components.
 * Requires compiler compatibility 1.5 or higher.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class CrsGUI extends JFrame 
{
	//////////////////////////////////////////////Fields////////////////////////////////////////////////
	
	// Menu bar components
	private JMenuBar menuBar;
	private JMenu optionsMenu;
	private JMenu exitMenu;
	
	private JMenuItem exitItem;
	private JCheckBoxMenuItem dinner;
	private JCheckBoxMenuItem workshop;
	
	// Panel Components
	private JPanel regPanel;
	private JPanel imgPanel;
	private JPanel totalPanel;
	private JPanel workPanel;
	private JScrollPane scrollWorkList;
	private JList workList;
		
	private JComboBox regType;
	private String[] regTypes = {"Regular", "Student"};
	
	private JLabel totalText;
	
	private JLabel imgLabel;
	private ImageIcon confImg;
	
	// Format total
	DecimalFormat formatter = new DecimalFormat("#,###");
	
	// Regular Fields
	private String[] workTypes = {"Introduction to E-commerce", "The Future of the Web", "Advanced Java Programming", "Network Security", "Advanced GUI Design",
			  "Advanced Class Concept", "Data Structures", "TC/IP Open Socket Connections", "Exception Handling", "Code Testing and Debugging"};
	private int[] workPrices = {295, 295, 395, 395, 495, 495, 595, 595, 695, 695};
	public static final int regularPrice = 895;
	public static final int studentPrice = 495;
	public static final int dinnerPrice = 30;
	private int total;
	private int workTotal;
	
	static int calls = 0;
	
	///////////////////////////////////////////Constructors/////////////////////////////////////////////

	public CrsGUI()
	{
		setTitle("Welcome to the Conference Registration System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildMenu();
		setJMenuBar(menuBar);
		
		buildTotal();
		add(totalPanel, BorderLayout.SOUTH);
		
		buildReg();
		add(regPanel, BorderLayout.WEST);
		
		buildWork();
		add(workPanel, BorderLayout.EAST);
		
		buildImg();
		add(imgPanel, BorderLayout.CENTER); // Default adds to center, but added manually for clarity.
		
		pack();
		setVisible(true);
		
		total = regularPrice;
		workTotal = 0;
	}
	

	//////////////////////////////////////////////Methods///////////////////////////////////////////////

	private void buildMenu()
	{
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		
		dinner = new JCheckBoxMenuItem("Attend Dinner and Keynote Speech");
		dinner.addActionListener(new dinnerListener());
		dinner.setMnemonic(KeyEvent.VK_S);
		dinner.setToolTipText("Selection will add $30 to your cost.");
		optionsMenu.add(dinner);
		
		workshop = new JCheckBoxMenuItem("Attend Optional Workshops");
		workshop.addActionListener(new optionalListener());
		workshop.setMnemonic(KeyEvent.VK_W);
		workshop.setToolTipText("Select to display workshop options and include in price.");
		optionsMenu.add(workshop);
		
		exitMenu = new JMenu("Finished: ");
		exitMenu.setMnemonic(KeyEvent.VK_F);
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new exitListener());
		exitMenu.add(exitItem);
		optionsMenu.add(exitMenu);
		
		menuBar.add(optionsMenu);
	}
	
	private void buildReg()
	{	
		regPanel = new JPanel();
		
		regType = new JComboBox(regTypes);
		regType.addActionListener(new regListener());
		regPanel.add(regType);
	}
	
	private void buildImg()
	{	
		imgPanel = new JPanel();
		
		confImg = new ImageIcon("Conference.jpg");
		imgLabel = new JLabel();
		
		imgLabel.setIcon(confImg);
		imgPanel.add(imgLabel);
	}
	
	private void buildTotal()
	{
		totalPanel = new JPanel();
		
		totalText = new JLabel("Your total is: $" + regularPrice);
		totalPanel.add(totalText);		
	}
	
	private void buildWork()
	{
		workPanel = new JPanel();
		workList = new JList(workTypes);
		workList.setVisibleRowCount(5);
		workList.addListSelectionListener(new workListener());
		
		scrollWorkList = new JScrollPane(workList);
		workPanel.add(scrollWorkList);
		workPanel.setVisible(false);
	}
	
	private void displayTotal()
	{
		totalText.setText("Your total is: $" + (total + workTotal));
	}
	
	/////////////////////////////////////////////Listeners//////////////////////////////////////////////
	
	private class workListener implements ListSelectionListener
	{

		public void valueChanged(ListSelectionEvent e) 
		{
			if(!e.getValueIsAdjusting() && workshop.isSelected())
			{
				workTotal = 0;
				
				int works[] = workList.getSelectedIndices();
				
				for(int i : works)
				{
					workTotal += workPrices[i];
				}
			}
			
			displayTotal();
		}
	}
	
	private class regListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(((String) regType.getSelectedItem()).equals("Regular"))
			{
				total -= studentPrice;
				total += regularPrice;
			}
			else
			{
				total -= regularPrice;
				total += studentPrice;
			}
			
			displayTotal();
		}
	}
	
	private class dinnerListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			if(dinner.isSelected())
				total += dinnerPrice;
			else
				total -= dinnerPrice;
			
			displayTotal();
		}
		
	}
	
	private class optionalListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			if(!workshop.isSelected())
			{
				workTotal = 0;
				workPanel.setVisible(false);
				pack();
			}
			else
			{
				workPanel.setVisible(true);
				pack();
			}
			
			displayTotal();
		}
		
	}
	
	private class exitListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
		
	}
}
