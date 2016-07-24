/**
 * @author Edson F.
 * @version 2.0
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Temperature extends JFrame {

	private double result1;
	private double result2;

	private JButton calculate;

	private JTextField celsius;
	private JTextField fahrenheit;

	private JMenu file;
	private JMenu help;

	private Container container;

	private FlowLayout layout;

	public Temperature() {
		super("Temperature");

		layout = new FlowLayout();
		setLayout(layout);

		// CREATE A MENU BAR
		JMenuBar menu = new JMenuBar();

		// ADD MENU BAR
		setJMenuBar(menu);

		// SETS AND ADD MENU TO MENU BARS
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");

		// CRIATE AND ADD ITEMS TO MENU
		JMenuItem _new = new JMenuItem("New");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem howDoesWork = new JMenuItem("How does work?");
		JMenuItem about = new JMenuItem("About");

		// ADD MENU
		menu.add(file);
		menu.add(help);

		// CRIATE AND ADD A CHECKBUTTON
		file.add(_new);
		file.add(exit);
		help.add(howDoesWork);
		help.add(about);

		container = this.getContentPane();
		container.setLayout(new FlowLayout());

		// CRIATE JTEXTFIELDS
		celsius = new JTextField(5);
		fahrenheit = new JTextField(5);

		// ADD INFORMATIONS
		container.add(new JLabel("Celsius"));
		container.add(celsius);
		container.add(new JLabel("Fahrenheit"));
		container.add(fahrenheit);

		// SET ICON
		Icon temp = new ImageIcon(getClass().getResource("temp.png"));
		calculate = new JButton("Calculate", temp);
		container.add(calculate);

		calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateAction();
			}
		});

		_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_newAction();
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitAction();
			}
		});

		howDoesWork.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				howDoesWorkAction();
			}
		});

		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aboutAction();
			}
		});
	} // End contructor

	private void _newAction() {
		celsius.setText("");
		fahrenheit.setText("");
	}

	private void exitAction() {
		System.exit(0);
	}

	private void howDoesWorkAction() {
		JOptionPane.showMessageDialog(null, "Temperature converter "
				+ "celsius to fahrenheit, fahrenheit to celsius!\n"
				+ "Calculation:\n"
				+ "fahrenheit = celsius * 1.8 + 32\n"
				+ "celsius = (fahrenheit - 32) / 1.8");
	}

	private void aboutAction() {
		JOptionPane.showMessageDialog(null, "Criated by Edson F.\n"
				+ "06/10/2016\nVersion 2.0");
	}

	private void calculateAction() {
		if (isConsistentFields()) {
			double c = Double.parseDouble(celsius.getText());
			double f = Double.parseDouble(fahrenheit.getText());

			result1 = c * 1.8 + 32;
			result2 = (f - 32) / 1.8;

			String r1 = String.format(c + " celsius = %.2f fahrenheit.", result1);
			String r2 = String.format(f + " fahrenheit = %.2f celsius.", result2);

			JOptionPane.showMessageDialog(null, r1 + "\n" + r2);
		} else {
			JOptionPane.showMessageDialog(this, "Inconsistent fields!");
		}
	}

	private boolean isConsistentFields() {
		String c = celsius.getText().trim();
		String f = fahrenheit.getText().trim();

		if (c.equals("")) {
			celsius.requestFocus();
			return false;
		} else if (f.equals("")) {
			fahrenheit.requestFocus();
			return false;
		}

		try {
			Double.parseDouble(c);
		} catch (Exception e) {
			celsius.requestFocus();
			return false;
		}

		try {
			Double.parseDouble(f);
		} catch (Exception e) {
			fahrenheit.requestFocus();
			return false;
		}

		return true;
	}
}