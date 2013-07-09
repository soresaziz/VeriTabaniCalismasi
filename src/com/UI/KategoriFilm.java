package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.DAO.FilmDAO;
import com.DAO.KategoriDAO;
import com.entity.Film;
import com.entity.Kategori;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class KategoriFilm extends JFrame {
    private ArrayList<Kategori> kategoriler;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KategoriFilm frame = new KategoriFilm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KategoriFilm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setBounds(58, 37, 89, 16);
		contentPane.add(lblKategori);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 89, 336, 152);
		contentPane.add(scrollPane);
		
		final JTextArea textCikti = new JTextArea();
		scrollPane.setViewportView(textCikti);
		kategoriler = new KategoriDAO().butunKategorileriGetir();
		//Object [] test = {"A","B","C"};
		ComboBoxModel cmbModelKategori = new DefaultComboBoxModel(kategoriler.toArray());
		final JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==ItemEvent.SELECTED){
					
					int k_id = ((Kategori)comboBox.getSelectedItem()).getId();
					FilmDAO filmDao = new FilmDAO();
					ArrayList<Film> filmler = filmDao.kategoriyeAitFilmleriGetir(k_id);
					
					StringBuilder text = new StringBuilder();
					for (Film film : filmler) {
						text.append(film.toString1() + "\n");
					}
					textCikti.setText(text.toString());
				}
				
			}
		});
		comboBox.setModel(cmbModelKategori);
		comboBox.setBounds(161, 33, 119, 27);
		contentPane.add(comboBox);
		
	}

}
