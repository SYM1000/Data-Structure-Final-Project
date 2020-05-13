/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaInformacion extends JFrame {

	private JPanel contentPane;
	private Hashtable<Integer, String> animaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInformacion frame = new VentanaInformacion();
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
	public VentanaInformacion() {
		setTitle("Información");
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
		btnRegresar.setBounds(159, 218, 117, 29);
		contentPane.add(btnRegresar);
		
		JLabel label = new JLabel("REGRESAR");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		label.setBounds(162, 216, 117, 29);
		contentPane.add(label);
		
		JLabel lblInformacin = new JLabel("INFORMACIÓN");
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setForeground(Color.WHITE);
		lblInformacin.setFont(new Font("DIN Alternate", Font.PLAIN, 23));
		lblInformacin.setBounds(101, 0, 241, 63);
		contentPane.add(lblInformacin);
		
		JLabel lblEsteProgramaSimula = new JLabel("Este programa simula la forma en la que ");
		lblEsteProgramaSimula.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsteProgramaSimula.setForeground(Color.WHITE);
		lblEsteProgramaSimula.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblEsteProgramaSimula.setBounds(42, 59, 356, 39);
		contentPane.add(lblEsteProgramaSimula);
		
		JLabel lblGoogleMapsCalcula = new JLabel("Google Maps calcula la ruta más rapida");
		lblGoogleMapsCalcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoogleMapsCalcula.setForeground(Color.WHITE);
		lblGoogleMapsCalcula.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblGoogleMapsCalcula.setBounds(42, 85, 356, 39);
		contentPane.add(lblGoogleMapsCalcula);
		
		JLabel lblParaLlegarDel = new JLabel("para llegar del punto A al B;");
		lblParaLlegarDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaLlegarDel.setForeground(Color.WHITE);
		lblParaLlegarDel.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblParaLlegarDel.setBounds(52, 110, 356, 39);
		contentPane.add(lblParaLlegarDel);
		
		JLabel lblEsteProgramaUtiliza = new JLabel("Utilizando teoría de grafos y el");
		lblEsteProgramaUtiliza.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsteProgramaUtiliza.setForeground(Color.WHITE);
		lblEsteProgramaUtiliza.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblEsteProgramaUtiliza.setBounds(42, 145, 356, 39);
		contentPane.add(lblEsteProgramaUtiliza);
		
		JLabel lblAlgoritmoDeDijkxtra = new JLabel("algoritmo de Dijkstra.");
		lblAlgoritmoDeDijkxtra.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmoDeDijkxtra.setForeground(Color.WHITE);
		lblAlgoritmoDeDijkxtra.setFont(new Font("DIN Alternate", Font.PLAIN, 20));
		lblAlgoritmoDeDijkxtra.setBounds(42, 171, 356, 39);
		contentPane.add(lblAlgoritmoDeDijkxtra);
		
		
		//El fondo
		JLabel lbFondo = new JLabel("");
		lbFondo.setBounds(-12, -12, 474, 312);
		int r = (int) ((Math.random() * ((this.animaciones.size() - 0))) + 0);
		ImageIcon a = new ImageIcon(getClass().getResource(this.animaciones.get(r)));
		lbFondo.setIcon(a);
		contentPane.add(lbFondo);
		
	}

}
