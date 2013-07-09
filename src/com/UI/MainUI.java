package com.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.DAO.FilmDAO;
import com.entity.Film;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainUI extends javax.swing.JFrame {
	private JButton btnGetir;
	private JScrollPane jScrollPane1;
	private JTextArea txtCikti;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainUI inst = new MainUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				btnGetir = new JButton();
				getContentPane().add(btnGetir);
				btnGetir.setText("Filmleri Getir");
				btnGetir.setBounds(12, 30, 366, 22);
				btnGetir.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent evt) {
						btnGetirMousePressed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 77, 366, 189);
				{
					txtCikti = new JTextArea();
					jScrollPane1.setViewportView(txtCikti);
				}
			}
			pack();
			this.setSize(394, 322);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void btnGetirMousePressed(MouseEvent evt) {
		FilmDAO filmDao = new FilmDAO();
		
		ArrayList<Film> filmler = filmDao.butunFilmleriGetir();
		StringBuilder text = new StringBuilder();
		
		for (Film film : filmler) {
			text.append(film+"\n");
		}
		
		txtCikti.setText(text.toString());
		
		
	}

}
