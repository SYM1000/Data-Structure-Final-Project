/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class VentanaCreditos extends JFrame {

	private JPanel contentPane;
	private Hashtable<Integer, String> animaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreditos frame = new VentanaCreditos();
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
	public VentanaCreditos() {
		setTitle("Créditos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		this.animaciones = new Hashtable<Integer, String>();
		this.animaciones.put(0, "ny.gif");
		this.animaciones.put(1, "city.gif");
		this.animaciones.put(2, "mov.gif");
		this.animaciones.put(3, "mundo.gif");
		this.animaciones.put(4, "tenor.gif");
		this.animaciones.put(5, "conect.gif");
		
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setOpaque(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setBorderPainted(false);
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("REGRESAR");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 216, 117, 29);
		contentPane.add(lblNewLabel);
		
		JLabel labelCreditos = new JLabel("CRÉDITOS");
		labelCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreditos.setForeground(Color.WHITE);
		labelCreditos.setFont(new Font("DIN Alternate", Font.PLAIN, 23));
		labelCreditos.setBounds(99, 0, 241, 63);
		contentPane.add(labelCreditos);
		
		JLabel labelTexto = new JLabel("Este programa fue cereado por");
		labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexto.setForeground(Color.WHITE);
		labelTexto.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		labelTexto.setBounds(40, 99, 356, 39);
		contentPane.add(labelTexto);
		
		JLabel lblSantiagoYeomans = new JLabel("Santiago Yeomans");
		lblSantiagoYeomans.setHorizontalAlignment(SwingConstants.CENTER);
		lblSantiagoYeomans.setForeground(Color.WHITE);
		lblSantiagoYeomans.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblSantiagoYeomans.setBounds(40, 129, 356, 39);
		contentPane.add(lblSantiagoYeomans);
		btnRegresar.setBounds(160, 216, 117, 29);
		contentPane.add(btnRegresar);
		
		
		
		JLabel lbFondo = new JLabel();
		lbFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lbFondo.setBounds(-11, -15, 511, 352);

		int r = (int) ((Math.random() * ((this.animaciones.size() - 0))) + 0);
		ImageIcon a = new ImageIcon(getClass().getResource(this.animaciones.get(r)));
		lbFondo.setIcon(a);
		contentPane.add(lbFondo);
	}

}
