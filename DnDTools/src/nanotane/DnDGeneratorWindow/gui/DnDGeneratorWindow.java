package nanotane.DnDGeneratorWindow.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import nanotane.DnDGeneratorWindow.generators.EncGenTrevorScot;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class DnDGeneratorWindow {

	private JFrame frame;
	private final Color mDark = new Color(34, 34, 34);
	private final Color mLightGrey = new Color(125, 125, 125);

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
		scrollPane.setBounds(0, 0, 481, 423);
		frame.getContentPane().add(scrollPane);
		//Create trevo scot buttons
		initTrevorScotButtons(editorPane);
		//Clear text button
		JButton btnClearText = new JButton("Clear Text");
		btnClearText.setForeground(new Color(255, 53, 49));
		btnClearText.setBackground(new Color(44, 53, 49));
		btnClearText.setBounds(491, 389, 173, 23);
		btnClearText.addActionListener(event ->{
			editorPane.setText("");
		});
		frame.getContentPane().add(btnClearText);
	}
	
	private void initTrevorScotButtons(JTextArea pEditorPane)
	{
		//Create encounter generators
		EncGenTrevorScot countrySideGen = new EncGenTrevorScot();
		
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
		btnEspionage.setBounds(10, 113, 128, 23);
		btnEspionage.setEnabled(false);
		btnEspionage.setForeground(mLightGrey);
		trevorScotButtonContainer.add(btnEspionage);
		//Countryside button
		JButton btnCountryside = new JButton("Countryside");
		btnCountryside.setBackground(new Color(255, 101, 47));
		btnCountryside.setForeground(mDark);
		btnCountryside.setBounds(10, 79, 128, 23);
		btnCountryside.addActionListener(event -> {
			pEditorPane.append(countrySideGen.generateCivilizedCountrySide() + "\n");
		});
		trevorScotButtonContainer.add(btnCountryside);
		//City: safe button
		JButton btnCitySafe = new JButton("City: Safe");
		btnCitySafe.setBackground(new Color(20, 228, 00));
		btnCitySafe.setForeground(mDark);
		btnCitySafe.setBounds(10, 45, 128, 23);
		btnCitySafe.addActionListener(event->{
			pEditorPane.append(countrySideGen.generateUrbanString() + "\n");
		});
		trevorScotButtonContainer.add(btnCitySafe);
		//City rough button
		JButton btnCityRough = new JButton("City: Rough");
		btnCityRough.setBounds(10, 11, 128, 23);
		btnCityRough.setEnabled(false);
		trevorScotButtonContainer.add(btnCityRough);
	}
}
