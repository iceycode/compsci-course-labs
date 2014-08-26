package lab03cs402;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.util.*;
import java.awt.Panel;


/** GUI for Lotto App
 * 
 * RULES:
 * Player starts off with $10
 * IF: all 6 numbers picked are winners doubles payoff
 * ELSE: payoff is number of matches (ie, 3 = 3, 1 = 1)
 * shift-click on Draw allows for cheating: user selected numbers set to numbers
 * 
 * 
 * @author Allen Jagoda Java Lab 03
 * 
INSTRUCTIONS:

1. Clicking on a number turns the button's background blue, and adds this number into the selected 
   numbers
2. Clicking on a selected (blue) number will turn the button's background back to the default
   color, and remove this number from the selected numbers
3. If six numbers have been picked, then the user cannot select additional numbers.

 */

public class LottoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane; //main panel
	private GroupLayout gl_contentPane_1; //main layout
	
	//panels that contain elements such as textArea or Buttons
	private JPanel panel_Numbers;
	private JTextArea txtrPreparing;
	private JTextArea textArea;

	//other variables  for game function
	private int cheat_Value = 0; //if 1, allows for cheating
	private int money = 10; //initial money
	private int numCount = 0; //initial count of numbers picked	
	
	private String TEXT_INFO = "Start by clicked on draw...";
	private String MONEY = "  " + money;
	private PriorityQueue<Numbers> pqNums = new PriorityQueue<Numbers>();
	private PriorityQueue<Numbers> winningNums = new PriorityQueue<Numbers>();

	/** APPLICATION
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoGUI frame = new LottoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** FRAME
	 * Create the frame.
	 */
	public LottoGUI() {
		setTitle("CompSci Lotto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setIgnoreRepaint(true);
		contentPane.setForeground(Color.RED);
		contentPane.setVisible(true);
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(1, 5, 1, 5));
		setContentPane(contentPane);		

		//3 JPanel variables for text at bottom, numbers & buttons
		JPanel panel_TextInfo = new JPanel(); //panel for text fields at bottom
		panel_TextInfo.setBackground(Color.WHITE);
		
		panel_Numbers = new JPanel(); //panel for numbers

		JPanel panel_Buttons = new JPanel(); //panel for buttons
		panel_Buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		gl_contentPane_1 = new GroupLayout(contentPane);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_TextInfo, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addComponent(panel_Buttons, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_Numbers, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_Numbers, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_Buttons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_TextInfo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
		);
		panel_Numbers.setLayout(null);
		
		numbersPanel(panel_Numbers);
		
		buttonsPanel(panel_Buttons); //panel of main colored buttons
		
		textInfoBottom(panel_TextInfo); //info about current status
	}
	
	/**Table for the numbers 0 thru 48
	 * - clicking on number
	 * 
	 * @param panel_Numbers
	 */
	private void numbersPanel(JPanel panel_Numbers) {

		final int WIDTH = 52;
		final int LENGTH = 35;
		
		int[] numbers = new int[49];//array to store number labels
		int number = 0; //initial number for first button
		
		for (int i = 0; i < 49; i++)
			numbers[i] = i;
				
		for (int i = 0; i <= 6; i++){
			number = i;
			for (int j = 0; j <= 6; j++){
				final JButton buttonNum = new JButton(String.valueOf(number));
				buttonNum.setText(""+(number));
				
				buttonNum.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				buttonNum.setBackground(Color.LIGHT_GRAY);
				
				buttonNum.setBounds(WIDTH*i, LENGTH*j, WIDTH, LENGTH);
				 //amount of clicks variable
				//for clicking button action
				buttonNum.addActionListener(new ActionListener(){
					int clickCount = 0;
					
					public void actionPerformed(ActionEvent e ){
						clickCount++; //record number of buttons clicked
						//clickCount = e.getClickCount();
						
						clickedNumber(buttonNum, clickCount);
						//pqNums.add(pickedNum);
					}
				});
				number = number+7;
				panel_Numbers.add(buttonNum);
			}//creating the columns
		}//creating button grid (rows)
	}

	/**Main side Button components of GUI
	 * - DRAW, RESET & QUIT 
	 * - currently no actions
	 * 
	 */
	private void buttonsPanel(JPanel panel_buttons) {
		//BUTTON COMPONENETS
		JButton btnDraw = new JButton("DRAW");
		btnDraw.setFocusTraversalPolicyProvider(true);
		btnDraw.requestFocus();
		btnDraw.setFocusable(true);
		btnDraw.setMinimumSize(new Dimension(81, 34));
		btnDraw.setMaximumSize(new Dimension(81, 34));
		btnDraw.setOpaque(true);
		btnDraw.setBorderPainted(false);
		btnDraw.setHideActionText(true);
		btnDraw.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnDraw.setSelected(true);
		
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK)
					cheat_Value = 1;
				else{
					clickButtons("DRAW");
					changeTextInfo("DRAW");
				}
			}
		});
		btnDraw.setFont(UIManager.getFont("ColorChooser.font.green"));
		btnDraw.setBackground(Color.BLACK);
		btnDraw.setForeground(Color.GREEN);
		btnDraw.setFont(UIManager.getFont("ColorChooser.font.green"));
		
		
//-----RESET 
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(Color.RED);
		btnReset.setFont(UIManager.getFont("Button.font"));
		btnReset.setBorder(null);
		btnReset.setOpaque(true);
		btnReset.setBackground(Color.BLACK);
		btnReset.setName("");
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				pqNums.clear(); //clear the cue
				winningNums.clear();
				money = 10;
				textArea.setText("$"+money);
				changeTextInfo("RESET");
				panel_Numbers.removeAll();
				panel_Numbers.revalidate();
				panel_Numbers.repaint();
				numbersPanel(panel_Numbers);
				
			}
		});
		
//----QUIT
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setMaximumSize(new Dimension(81, 29));
		btnQuit.setMinimumSize(new Dimension(81, 29));
		btnQuit.setOpaque(true);
		btnQuit.setBackground(Color.BLACK);
		btnQuit.setBorderPainted(false);
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setFont(UIManager.getFont("ColorChooser.font"));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTextInfo("QUIT");
			}
		});
		
		//PANEL LAYOUT FOR BUTTONS
		GroupLayout gl_panel_Buttons = new GroupLayout(panel_buttons);
		gl_panel_Buttons.setHorizontalGroup(
			gl_panel_Buttons.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
				.addComponent(btnQuit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
				.addComponent(btnDraw, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
		);
		gl_panel_Buttons.setVerticalGroup(
			gl_panel_Buttons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Buttons.createSequentialGroup()
					.addComponent(btnDraw, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		panel_buttons.setLayout(gl_panel_Buttons);
	}


	/** Displays current progress & amount of money at bottom
	 * 
	 * @param panel_TextInfo
	 */
	private void textInfoBottom(JPanel panel_TextInfo){
		contentPane.setLayout(gl_contentPane_1);
		
		txtrPreparing = new JTextArea();
		txtrPreparing.setBackground(Color.WHITE);
		txtrPreparing.setText(TEXT_INFO);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(MONEY);
		
		GroupLayout gl_panel_TextInfo = new GroupLayout(panel_TextInfo);
		gl_panel_TextInfo.setHorizontalGroup(
			gl_panel_TextInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TextInfo.createSequentialGroup()
					.addComponent(txtrPreparing, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_TextInfo.setVerticalGroup(
			gl_panel_TextInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TextInfo.createSequentialGroup()
					.addGroup(gl_panel_TextInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrPreparing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_TextInfo.setLayout(gl_panel_TextInfo);
	}

//******************SWING ACTION METHODS & RELATED METHODS ************************//
	
	public static ActionListener initializeButton (String text, Color background, Color textColor, 
		boolean active, ActionListener listener){
		
		active = true; //event initiated
		//event specifics (mouse clicked)
		
		return listener;
	}
	
	public void changeTextInfo(String button){
		if (button.equals("DRAW")){
			if (cheat_Value == 0){
				TEXT_INFO = "Numbers drawn";
				txtrPreparing.setText(TEXT_INFO);
			}
			else
				txtrPreparing.setText("Numbers drawn ;)");
		}
		else if (button.equals("RESET")){
			//resetting all queues
			TEXT_INFO = "Reset game";
			txtrPreparing.setText(TEXT_INFO);
			numCount = 0;
			money = 10;
			cheat_Value = 0;
		}
		else
			System.exit(0); //closes game GUI
		//else if (button.getName()=="")
	}
	
	public void clickedNumber(JButton button, int clickedAmt){

		//border indicating which number currently selected
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red));
		
		//get number & add as object Number to be added to queue
		Integer num = Integer.valueOf(button.getText()); 
		Numbers n = new Numbers(num); //add as object 
		Numbers pickedNum = new Numbers(); //store as Numbers object

		if (numCount < 6){
			if (clickedAmt%2 == 0){
				button.setBackground(Color.LIGHT_GRAY);
				button.setOpaque(false);
				button.setBorder(null);
				button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				Numbers n1 = new Numbers(num); //add as object 
				pqNums.remove(n1); //remove number
				numCount--; //number deselected so decrememt 
				money++;
			}//clicked twice so return back to normal
			else{
				if (numCount < 6){
					pqNums.add(n); //add to priority queue
				}
				//change the button appearance/state
				button.setOpaque(true); //make it opaque
				button.setBackground(Color.blue); //change color
				button.setBorder(title);
				numCount++;
			}
		}
		
		if (numCount < 6){
			if (cheat_Value == 0){
				if (winningNums.contains(pickedNum)){
					money += 2;
					if (numCount == 5)
						money = money+6; //double money if all 6 picked
				}//picked correct number
				else
					money--; //decrement by 1
			}
			else{
				money+=1; //every number is correct
				if (numCount == 5)
					money = money+6;
			}
		}
		MONEY = "  $"+ money; //set new string
		
		textArea.setText(MONEY);
		
	} //changes appearance of numbers & enters as data member
	

//******************OTHER METHODS************************//
	
	/** 
	 * 
	 * @param fix - if true, sets winning combo to selected picks
	 */
	public void pickWinners( ){
		
		Random r = new Random();
		for (int i = 0; i < 6; i++){
			winningNums.add(new Numbers(r.nextInt(47)+1));
		}

	}
	
	public void clickButtons(String button){
		if (button.equals("DRAW")){
						
			pickWinners();
		}
		else if (button.equals("RESET")){
			//resetting all queues
			pqNums.clear(); //clear the cue
			winningNums.clear();
		}
		else{
			System.exit(0); //closes game GUI
		} //quit program
	}
}
