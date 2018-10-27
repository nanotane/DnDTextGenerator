package nanotane.DnDGeneratorWindow.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JButton;

import nanotane.DnDGeneratorWindow.generators.EncGenTrevorScot;
import nanotane.DnDGeneratorWindow.generators.ReadFileUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.ScrollPane;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class DnDGeneratorWindow {

	private JFrame frame;

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
		frame.setResizable(false);
		
		JTextArea editorPane = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(0, 0, 481, 423);
		frame.getContentPane().add(scrollPane);
		//Create trevo scot buttons
		initTrevorScotButtons(editorPane);
		//Clear text button
		JButton btnClearText = new JButton("Clear Text");
		btnClearText.setForeground(Color.RED);
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
		trevorScotLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		trevorScotLabel.setBounds(491, 18, 173, 14);
		frame.getContentPane().add(trevorScotLabel);
				
		JPanel trevorScotButtonContainer = new JPanel();
		trevorScotButtonContainer.setBorder(new LineBorder(new Color(0, 0, 0)));
		trevorScotButtonContainer.setBounds(491, 32, 150, 147);
		frame.getContentPane().add(trevorScotButtonContainer);
		trevorScotButtonContainer.setLayout(null);
				
		//Espionage button
		JButton btnEspionage = new JButton("Espionage");
		btnEspionage.setBounds(10, 113, 128, 23);
		trevorScotButtonContainer.add(btnEspionage);
		//Countryside button
		JButton btnCountryside = new JButton("Countryside");
		btnCountryside.setBounds(10, 79, 128, 23);
		btnCountryside.addActionListener(event -> {
			pEditorPane.append(countrySideGen.gererateString() + "\n");
		});
		trevorScotButtonContainer.add(btnCountryside);
		//City: safe button
		JButton btnCitySafe = new JButton("City: Safe");
		btnCitySafe.setBounds(10, 45, 128, 23);
		trevorScotButtonContainer.add(btnCitySafe);
		//City rough button
		JButton btnCityRough = new JButton("City: Rough");
		btnCityRough.setBounds(10, 11, 128, 23);
		trevorScotButtonContainer.add(btnCityRough);
	}
}
