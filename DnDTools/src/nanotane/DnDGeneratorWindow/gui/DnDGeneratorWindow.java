package nanotane.DnDGeneratorWindow.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import nanotane.DnDGeneratorWindow.generators.EncGenTrevorScot;
import nanotane.DnDGeneratorWindow.generators.ReadFileUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.ScrollPane;

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
		
		JTextArea editorPane = new JTextArea();
//		editorPane.setBounds(10, 10, 481, 423);
//		frame.getContentPane().add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(0, 0, 481, 423);
		frame.getContentPane().add(scrollPane);
		
		JButton btnCityRough = new JButton("City: Rough");
		btnCityRough.setBounds(491, 11, 128, 23);
		frame.getContentPane().add(btnCityRough);
		
		JButton btnCitySafe = new JButton("City: Safe");
		btnCitySafe.setBounds(491, 45, 128, 23);
		frame.getContentPane().add(btnCitySafe);
		
		EncGenTrevorScot countrySideGen = new EncGenTrevorScot();
		JButton btnCountryside = new JButton("Countryside");
		btnCountryside.setBounds(491, 79, 128, 23);
		btnCountryside.addActionListener(event->{
			editorPane.append(countrySideGen.gererateString() + "\n");
		});
		frame.getContentPane().add(btnCountryside);
		
		JButton btnEspionage = new JButton("Espionage");
		btnEspionage.setBounds(491, 113, 128, 23);
		frame.getContentPane().add(btnEspionage);
	}
}
