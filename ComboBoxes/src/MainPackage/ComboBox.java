package MainPackage;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class ComboBox {

	private JFrame frame;
	
	public static final String[] MONTHS = {"Janurary","February","March","April","May","June","July","August","September","October","November","December"};
	
	public static final String[] DAYS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	
	public static final int[] YEARS = {2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox window = new ComboBox();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComboBox() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox(MONTHS);
		comboBox.setBounds(79, 28, 84, 20);
		frame.getContentPane().add(comboBox);
		
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		//final int year = now.get(Calendar.YEAR);
		final int year = 2016;
		
		
		//This code for setting current Month
		for (int altmon = 1; altmon <= MONTHS.length - 1; altmon++ ) {
				
			if (altmon == month) {
					comboBox.setSelectedIndex(month - 1);
				}
			}
		
		final JComboBox comboBox_1 = new JComboBox(DAYS);
		comboBox_1.setBounds(79, 92, 84, 20);
		frame.getContentPane().add(comboBox_1);
		
		for (int i = 1; i < DAYS.length; i++) {
			
			if (i == day) {
				
			comboBox_1.setSelectedIndex(i - 1);
			}
		}
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(79, 154, 84, 20);
		frame.getContentPane().add(comboBox_2);
		
		for(int i = 0; i < YEARS.length; i++) {
			
			comboBox_2.addItem(YEARS[i]);
		}
		
		for (int i = 0; i < YEARS.length; i++) {
			
			if (year == YEARS[i]) {
				
				comboBox_2.setSelectedItem(YEARS[i]);
			}
		}
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
			Object selected = comboBox_1.getSelectedItem();
			
			if (selected.toString() == "January" || selected.toString() == "March" || selected.toString() == "May" || selected.toString() == "July" || selected.toString() == "August" || selected.toString() == "October" || selected.toString() == "December") {
				
				comboBox_1.removeAllItems();
				for (int i = 0; i < DAYS.length; i++) {
					comboBox_1.addItem(DAYS[i]);
				}
			}
			
			else if (selected.toString() == "February") {
				
				comboBox_1.removeAllItems();
			
				for (int i = 0; i < DAYS.length - 3; i++) {
					
					if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)) == true) {
						
						comboBox_1.addItem(DAYS[i + 1]);
					}
					else {
						
						comboBox_1.addItem(DAYS[i]);
					}
				}
				
			}
			
			else {
				
				comboBox_1.removeAllItems();
				for (int i = 0; i < DAYS.length - 1; i++) {
					comboBox_1.addItem(DAYS[i]);
				}
				
			}
			
			
			}
		});
	}

	

}
