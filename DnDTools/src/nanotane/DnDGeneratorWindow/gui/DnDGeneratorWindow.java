package nanotane.DnDGeneratorWindow.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import nanotane.DnDGeneratorWindow.generators.CustomGenerator;
import nanotane.DnDGeneratorWindow.generators.EncGenTrevorScot;
import nanotane.DnDGeneratorWindow.generators.TrinketGenerator;

public class DnDGeneratorWindow {

	private JFrame frame;
	private final Color mDark = new Color(34, 34, 34);
	private final Color mLightGrey = new Color(125, 125, 125);
	private final int mButtonWidth = 128;
	private final int mButtonHeight = 23;
	private final Color mButtonPurple = new Color(143, 59, 239);
	private final Color mLightBlue = new Color(44, 187, 244);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnDGeneratorWindow window = new DnDGeneratorWindow();
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
	public DnDGeneratorWindow() {
		initialize();
		//TODO testing here
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(mDark);
		frame.setResizable(false);
		frame.setBackground(mDark);
		
		JTextArea editorPane = new JTextArea();
		editorPane.setBackground(mDark);
		editorPane.setForeground(mLightGrey);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.getVerticalScrollBar().setBackground(mDark);
		scrollPane.getVerticalScrollBar().setForeground(mLightGrey);
		scrollPane.getHorizontalScrollBar().setBackground(mDark);
		scrollPane.getHorizontalScrollBar().setForeground(mLightGrey);
		scrollPane.setBounds(0, 0, 481, 423);
		frame.getContentPane().add(scrollPane);
		//Create trevo scot buttons
		initTrevorScotButtons(editorPane);
		initTrinketButtons(editorPane);
		//Clear text button
		JButton btnClearText = new JButton("Clear Text");
		btnClearText.setForeground(new Color(255, 53, 49));
		btnClearText.setBackground(new Color(44, 53, 49));
		btnClearText.setBounds(491, 389, 173, 23);
		btnClearText.addActionListener(event ->{
			editorPane.setText("");
		});
		frame.getContentPane().add(btnClearText);
		
		//Load the files
		CustomGenerator.loadFiles();
		//Create the custom options area
		JPanel customOptionsArea = new JPanel();
		customOptionsArea.setBounds(501, 258, 128, 120);
		customOptionsArea.setBackground(mDark);
		customOptionsArea.setBorder(new LineBorder(mLightGrey));
		customOptionsArea.setLayout(new GridLayout(0, 1));
		//Get the buttons and pass in the action
		List<JButton> buttons = CustomGenerator.getCustomButtons(mDark, mLightBlue, pString ->{
			appendTextArea(editorPane, pString);
		});
		buttons.forEach(customOptionsArea::add);
		frame.getContentPane().add(customOptionsArea);
	}
	
	private void initTrinketButtons(JTextArea pEditorPane) {
		// TODO Auto-generated method stub
		JButton trinketButton = new JButton("Trinkets");
		trinketButton.setForeground(mButtonPurple);
		trinketButton.setBackground(mDark);
		trinketButton.addActionListener(event->{
			appendTextArea(pEditorPane, TrinketGenerator.genTrinket());
		});
		trinketButton.setBounds(501, 190, mButtonWidth, mButtonHeight);
		frame.getContentPane().add(trinketButton);
		
		JButton uniqueTrinketButton = new JButton("Unique Trinket");
		uniqueTrinketButton.setForeground(mButtonPurple);
		uniqueTrinketButton.setBackground(mDark);
		uniqueTrinketButton.addActionListener(event ->{
			appendTextArea(pEditorPane, TrinketGenerator.genUniqueTrinket());
		});
		uniqueTrinketButton.setBounds(501, 224, mButtonWidth, mButtonHeight);
		frame.getContentPane().add(uniqueTrinketButton);
	}
	
	private void initTrevorScotButtons(JTextArea pEditorPane)
	{
		JLabel trevorScotLabel = new JLabel("Trevor Scott Encounters");
		trevorScotLabel.setForeground(mLightGrey);
		trevorScotLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		trevorScotLabel.setBounds(491, 18, 173, 14);
		frame.getContentPane().add(trevorScotLabel);
				
		JPanel trevorScotButtonContainer = new JPanel();
		trevorScotButtonContainer.setBorder(new LineBorder(mLightGrey));
		trevorScotButtonContainer.setBounds(491, 32, 150, 147);
		trevorScotButtonContainer.setBackground(mDark);
		frame.getContentPane().add(trevorScotButtonContainer);
		trevorScotButtonContainer.setLayout(null);
				
		//Espionage button
		JButton btnEspionage = new JButton("Espionage");
		btnEspionage.setBounds(10, 113, mButtonWidth, mButtonHeight);
		btnEspionage.setEnabled(false);
		btnEspionage.setForeground(mLightGrey);
		trevorScotButtonContainer.add(btnEspionage);
		//Countryside button
		JButton btnCountryside = new JButton("Countryside");
		btnCountryside.setForeground(new Color(255, 101, 47));
		btnCountryside.setBackground(mDark);
		btnCountryside.setBounds(10, 79, mButtonWidth, mButtonHeight);
		btnCountryside.addActionListener(event -> {
			appendTextArea(pEditorPane, EncGenTrevorScot.generateCivilizedCountrySide());
		});
		trevorScotButtonContainer.add(btnCountryside);
		//City: safe button
		JButton btnCitySafe = new JButton("City: Safe");
		btnCitySafe.setForeground(new Color(20, 228, 00));
		btnCitySafe.setBackground(mDark);
		btnCitySafe.setBounds(10, 45, mButtonWidth, mButtonHeight);
		btnCitySafe.addActionListener(event->{
			appendTextArea(pEditorPane, EncGenTrevorScot.generateUrbanString());
		});
		trevorScotButtonContainer.add(btnCitySafe);
		//City rough button
		JButton btnCityRough = new JButton("City: Rough");
		btnCityRough.setBounds(10, 11, mButtonWidth, mButtonHeight);
		btnCityRough.setEnabled(false);
		trevorScotButtonContainer.add(btnCityRough);
	}
	

	private void appendTextArea(JTextArea pTextArea, String pToAppend)
	{
		pTextArea.append(pToAppend + "\n");
	}
}
