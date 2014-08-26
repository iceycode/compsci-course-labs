package lab02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


/** GUI for Lotto App
 * 
 * @author Allen Jagoda Java Lab 02
 *
 */

public class LottoGUI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GroupLayout gl_contentPane_1;
	private JTextArea txtrPreparing;

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
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setIgnoreRepaint(true);
		contentPane.setForeground(Color.RED);
		contentPane.setVisible(false);
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(1, 5, 1, 5));
		setContentPane(contentPane);		

		//3 JPanel variables for text at bottom, numbers & buttons
		JPanel panel_TextInfo = new JPanel(); //panel for text fields at bottom
		panel_TextInfo.setBackground(Color.WHITE);
		
		JPanel panel_Numbers = new JPanel(); //panel for numbers
		
		JPanel panel_Buttons = new JPanel(); //panel for buttons
		panel_Buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		gl_contentPane_1 = new GroupLayout(contentPane);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_TextInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addComponent(panel_Buttons, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_Numbers, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_Buttons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_Numbers, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_TextInfo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(227))
		);
		panel_Numbers.setLayout(null);
		
		numbersPanel(panel_Numbers); //panel of number buttons
		
		buttonsPanel(panel_Buttons); //panel of main colored buttons
		
		textInfoBottom(panel_TextInfo); //info about current status
		
		
	}


	/**Table for the numbers 0 thru 48
	 * 
	 * @param panel_Numbers
	 */
	private void numbersPanel(JPanel panel_Numbers) {
		JButton btnNumButton = new JButton("0");
		btnNumButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNumButton.setBackground(Color.LIGHT_GRAY);
		btnNumButton.setBounds(0, 0, 52, 35);
		panel_Numbers.add(btnNumButton);
		
		JButton button = new JButton("1");
		button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(52, 0, 52, 35);
		panel_Numbers.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(105, 0, 52, 35);
		panel_Numbers.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(157, 0, 52, 35);
		panel_Numbers.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(210, 0, 52, 35);
		panel_Numbers.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setBounds(263, 0, 52, 35);
		panel_Numbers.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBounds(316, 0, 52, 35);
		panel_Numbers.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setBounds(0, 37, 52, 35);
		panel_Numbers.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setBounds(52, 37, 52, 35);
		panel_Numbers.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_8.setBackground(Color.LIGHT_GRAY);
		button_8.setBounds(105, 37, 52, 35);
		panel_Numbers.add(button_8);
		
		JButton button_9 = new JButton("10");
		button_9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_9.setBackground(Color.LIGHT_GRAY);
		button_9.setBounds(157, 37, 52, 35);
		panel_Numbers.add(button_9);
		
		JButton button_10 = new JButton("11");
		button_10.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_10.setBackground(Color.LIGHT_GRAY);
		button_10.setBounds(210, 37, 52, 35);
		panel_Numbers.add(button_10);
		
		JButton button_11 = new JButton("12");
		button_11.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_11.setBackground(Color.LIGHT_GRAY);
		button_11.setBounds(263, 37, 52, 35);
		panel_Numbers.add(button_11);
		
		JButton button_12 = new JButton("13");
		button_12.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_12.setBackground(Color.LIGHT_GRAY);
		button_12.setBounds(316, 37, 52, 35);
		panel_Numbers.add(button_12);
		
		JButton button_13 = new JButton("14");
		button_13.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_13.setBackground(Color.LIGHT_GRAY);
		button_13.setBounds(0, 74, 52, 35);
		panel_Numbers.add(button_13);
		
		JButton button_14 = new JButton("15");
		button_14.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_14.setBackground(Color.LIGHT_GRAY);
		button_14.setBounds(52, 74, 52, 35);
		panel_Numbers.add(button_14);
		
		JButton button_15 = new JButton("16");
		button_15.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_15.setBackground(Color.LIGHT_GRAY);
		button_15.setBounds(105, 74, 52, 35);
		panel_Numbers.add(button_15);
		
		JButton button_16 = new JButton("17");
		button_16.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_16.setBackground(Color.LIGHT_GRAY);
		button_16.setBounds(157, 74, 52, 35);
		panel_Numbers.add(button_16);
		
		JButton button_17 = new JButton("18");
		button_17.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_17.setBackground(Color.LIGHT_GRAY);
		button_17.setBounds(210, 74, 52, 35);
		panel_Numbers.add(button_17);
		
		JButton button_18 = new JButton("19");
		button_18.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_18.setBackground(Color.LIGHT_GRAY);
		button_18.setBounds(263, 74, 52, 35);
		panel_Numbers.add(button_18);
		
		JButton button_19 = new JButton("20");
		button_19.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_19.setBackground(Color.LIGHT_GRAY);
		button_19.setBounds(316, 74, 52, 35);
		panel_Numbers.add(button_19);
		
		JButton button_20 = new JButton("21");
		button_20.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_20.setBackground(Color.LIGHT_GRAY);
		button_20.setBounds(0, 108, 52, 35);
		panel_Numbers.add(button_20);
		
		JButton button_21 = new JButton("22");
		button_21.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_21.setBackground(Color.LIGHT_GRAY);
		button_21.setBounds(52, 108, 52, 35);
		panel_Numbers.add(button_21);
		
		JButton button_22 = new JButton("23");
		button_22.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_22.setBackground(Color.LIGHT_GRAY);
		button_22.setBounds(105, 108, 52, 35);
		panel_Numbers.add(button_22);
		
		JButton button_23 = new JButton("24");
		button_23.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_23.setBackground(Color.LIGHT_GRAY);
		button_23.setBounds(157, 108, 52, 35);
		panel_Numbers.add(button_23);
		
		JButton button_24 = new JButton("25");
		button_24.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_24.setBackground(Color.LIGHT_GRAY);
		button_24.setBounds(210, 108, 52, 35);
		panel_Numbers.add(button_24);
		
		JButton button_25 = new JButton("26");
		button_25.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_25.setBackground(Color.LIGHT_GRAY);
		button_25.setBounds(263, 108, 52, 35);
		panel_Numbers.add(button_25);
		
		JButton button_26 = new JButton("27");
		button_26.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_26.setBackground(Color.LIGHT_GRAY);
		button_26.setBounds(316, 108, 52, 35);
		panel_Numbers.add(button_26);
		
		JButton button_34 = new JButton("35");
		button_34.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_34.setBackground(Color.LIGHT_GRAY);
		button_34.setBounds(0, 181, 52, 35);
		panel_Numbers.add(button_34);
		
		JButton button_35 = new JButton("36");
		button_35.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_35.setBackground(Color.LIGHT_GRAY);
		button_35.setBounds(52, 181, 52, 35);
		panel_Numbers.add(button_35);
		
		JButton button_36 = new JButton("37");
		button_36.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_36.setBackground(Color.LIGHT_GRAY);
		button_36.setBounds(105, 181, 52, 35);
		panel_Numbers.add(button_36);
		
		JButton button_37 = new JButton("38");
		button_37.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_37.setBackground(Color.LIGHT_GRAY);
		button_37.setBounds(157, 181, 52, 35);
		panel_Numbers.add(button_37);
		
		JButton button_38 = new JButton("39");
		button_38.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_38.setBackground(Color.LIGHT_GRAY);
		button_38.setBounds(210, 181, 52, 35);
		panel_Numbers.add(button_38);
		
		JButton button_39 = new JButton("40");
		button_39.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_39.setBackground(Color.LIGHT_GRAY);
		button_39.setBounds(263, 181, 52, 35);
		panel_Numbers.add(button_39);
		
		JButton button_40 = new JButton("41");
		button_40.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_40.setBackground(Color.LIGHT_GRAY);
		button_40.setBounds(316, 181, 52, 35);
		panel_Numbers.add(button_40);
		
		JButton button_41 = new JButton("42");
		button_41.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_41.setBackground(Color.LIGHT_GRAY);
		button_41.setBounds(0, 216, 52, 35);
		panel_Numbers.add(button_41);
		
		JButton button_42 = new JButton("43");
		button_42.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_42.setBackground(Color.LIGHT_GRAY);
		button_42.setBounds(52, 216, 52, 35);
		panel_Numbers.add(button_42);
		
		JButton button_43 = new JButton("44");
		button_43.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_43.setBackground(Color.LIGHT_GRAY);
		button_43.setBounds(105, 216, 52, 35);
		panel_Numbers.add(button_43);
		
		JButton button_44 = new JButton("45");
		button_44.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_44.setBackground(Color.LIGHT_GRAY);
		button_44.setBounds(157, 216, 52, 35);
		panel_Numbers.add(button_44);
		
		JButton button_45 = new JButton("46");
		button_45.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_45.setBackground(Color.LIGHT_GRAY);
		button_45.setBounds(210, 216, 52, 35);
		panel_Numbers.add(button_45);
		
		JButton button_46 = new JButton("47");
		button_46.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_46.setBackground(Color.LIGHT_GRAY);
		button_46.setBounds(263, 216, 52, 35);
		panel_Numbers.add(button_46);
		
		JButton button_47 = new JButton("48");
		button_47.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_47.setBackground(Color.LIGHT_GRAY);
		button_47.setBounds(316, 216, 52, 35);
		panel_Numbers.add(button_47);
		
		JButton button_27 = new JButton("28");
		button_27.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_27.setBackground(Color.LIGHT_GRAY);
		button_27.setBounds(0, 143, 52, 35);
		panel_Numbers.add(button_27);
		
		JButton button_28 = new JButton("29");
		button_28.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_28.setBackground(Color.LIGHT_GRAY);
		button_28.setBounds(52, 143, 52, 35);
		panel_Numbers.add(button_28);
		
		JButton button_29 = new JButton("30");
		button_29.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_29.setBackground(Color.LIGHT_GRAY);
		button_29.setBounds(105, 143, 52, 35);
		panel_Numbers.add(button_29);
		
		JButton button_30 = new JButton("31");
		button_30.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_30.setBackground(Color.LIGHT_GRAY);
		button_30.setBounds(157, 143, 52, 35);
		panel_Numbers.add(button_30);
		
		JButton button_31 = new JButton("32");
		button_31.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_31.setBackground(Color.LIGHT_GRAY);
		button_31.setBounds(210, 143, 52, 35);
		panel_Numbers.add(button_31);
		
		JButton button_32 = new JButton("34");
		button_32.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_32.setBackground(Color.LIGHT_GRAY);
		button_32.setBounds(316, 143, 52, 35);
		panel_Numbers.add(button_32);
		
		JButton button_33 = new JButton("33");
		button_33.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_33.setBackground(Color.LIGHT_GRAY);
		button_33.setBounds(263, 143, 52, 35);
		panel_Numbers.add(button_33);
	}

	/**Main side Button components of GUI
	 * - DRAW, RESET & QUIT 
	 * - currently no actions
	 * 
	 */
	private void buttonsPanel(JPanel panel_buttons) {
		//BUTTON COMPONENETS
		JButton btnDraw = new JButton("DRAW");
		btnDraw.setMinimumSize(new Dimension(81, 34));
		btnDraw.setMaximumSize(new Dimension(81, 34));
		btnDraw.setOpaque(true);
		btnDraw.setBorderPainted(false);
		btnDraw.setHideActionText(true);
		btnDraw.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnDraw.setSelected(true);
		btnDraw.setRequestFocusEnabled(false);
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDraw.setFont(UIManager.getFont("ColorChooser.font.green"));
		btnDraw.setBackground(Color.BLACK);
		btnDraw.setForeground(Color.GREEN);
		btnDraw.setFont(UIManager.getFont("ColorChooser.font.green"));
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(Color.RED);
		btnReset.setFont(UIManager.getFont("Button.font"));
		btnReset.setBorder(null);
		btnReset.setOpaque(true);
		btnReset.setBackground(Color.BLACK);
		btnReset.setName("");
		
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
	private void textInfoBottom(JPanel panel_TextInfo) {
		contentPane.setLayout(gl_contentPane_1);
		txtrPreparing = new JTextArea();
		txtrPreparing.setBackground(Color.WHITE);
		txtrPreparing.setText("Preparing... ");
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setText("                                                 $10");
		GroupLayout gl_panel_TextInfo = new GroupLayout(panel_TextInfo);
		gl_panel_TextInfo.setHorizontalGroup(
			gl_panel_TextInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TextInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrPreparing, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
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
}
