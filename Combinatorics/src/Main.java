/*
 * Main houses the main function as well as methods that construct the GUI
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	JTextField setInput;
	JTextField chooseInput;
	JTextField output;
	JCheckBox order;
	JCheckBox rep;
	JButton calculate;
	
	JPanel checkBoxPanel;
	JPanel inputPanel;
	JPanel calcButtonPanel;
	JPanel framePanel;

	/*
	 * The layout for the window will have the JFrame set in the BorderLayout
	 * In BorderLayout.Center we will have a panel with a 3x1 Grid Layout(basically 3 vertical panels)
	 * The first 2 panels, input and calc will be 2x2 gridlayouts, with the last just being a button
	 * 
	 */
	public void drawFrame()
	{
		//create frame and set attributes
		JFrame frame = new JFrame();
		frame.setTitle("Combinatorics Calculator");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setResizable(true);
		
		//add main panel to center of Frame
		framePanel = new JPanel();
		framePanel.setLayout(new GridLayout(3,1));
		frame.add(framePanel, BorderLayout.CENTER);
		
		//calculations output in south of Borderlayout
		output = new JTextField();
		output.setPreferredSize(new Dimension(400, 100));
		frame.add(output,BorderLayout.SOUTH);
		
		//initalize subpanels
		drawCheckBoxPanel();
		drawInputPanel();
		drawCalcPanel();
		
		//add subpanels to main panel
		framePanel.add(inputPanel);
		framePanel.add(checkBoxPanel);
		framePanel.add(calcButtonPanel);
		frame.setVisible(true);
	}
	
	//creates panel that holds checkboxes
	public void drawCheckBoxPanel()
	{
		//create panel for checkbox buttons and labels
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(2,2));
		
		//initialize and add objects to CheckBoxPanel
		order = new JCheckBox();
		rep = new JCheckBox();
		JLabel o = new JLabel("Order Important?");
		JLabel r = new JLabel("Repitition Allowed?");
		checkBoxPanel.add(o);
		checkBoxPanel.add(order);
		checkBoxPanel.add(r);
		checkBoxPanel.add(rep);
		checkBoxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void drawInputPanel()
	{
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel set = new JLabel("Total Size of Set");
		JLabel setChoose = new JLabel("Size of selection from set");
		setInput = new JTextField();
		chooseInput = new JTextField();
		
		inputPanel.add(set);
		inputPanel.add(setInput);
		inputPanel.add(setChoose);
		inputPanel.add(chooseInput);
	}
	
	public void drawCalcPanel()
	{
		calcButtonPanel = new JPanel();
		calcButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		calculate = new JButton("Calculate");
		calculate.addActionListener(new CalcListener());
		calcButtonPanel.add(calculate);
	}
	
	private class CalcListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int n = Integer.parseInt(setInput.getText());
			int r = Integer.parseInt(chooseInput.getText());
			
			String outputAns = "";
			if(order.isSelected() && rep.isSelected()) //permutationRep
			{
				outputAns = Combinatorics.permutationRep(n, r);
			}
			
			if(!order.isSelected() && !rep.isSelected())
			{
				outputAns = Combinatorics.combinatoricNoRep(n,r);
			}
			
			if(order.isSelected() && !rep.isSelected())
			{
				outputAns = Combinatorics.permutationNoRep(n, r);
				
			}
			
			if(!order.isSelected() && rep.isSelected())
			{
				outputAns = Combinatorics.combinatoricRep(n,r);
			}
			
			output.setText(outputAns);
			System.out.println(outputAns);
			
		}
		
	}
	public static void main(String args[])
	{
		Main a = new Main();
		a.drawFrame();
	}

}
