/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Queue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BasicStroke;
import java.awt.Canvas;

public class VentanaPrincipal {

	private JFrame frame;
	private JLabel lbFotoCiudad;
	private Color fondoPanel,
				  barraControles;
	private JLabel lbBarraControles;
	private JLabel lblNav;
	private JLabel lblInformacin;
	private JLabel lblCrditos;
	private JLabel lblSalir;
	private JLabel lblInicio;
	private JComboBox comboBox;
	private JLabel lblNewLabel,
					puntoInicio,
					puntoDestino;
	private JComboBox comboJBDestino;
	private JButton buttonInfo;
	private JButton btnSalir;
	private Lugares lugares;
	private JLabel lbArriba;
	private RutaMasCorta algoritmo;
	private JLabel lbPintar;
	final VentanaCreditos vCreditos = new VentanaCreditos();
	final VentanaInformacion vInformacion = new VentanaInformacion();
	private JButton buttonCreditos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.lugares =  new Lugares();
		this.algoritmo =  new RutaMasCorta();
		fondoPanel =  new Color(201, 55, 87);
		barraControles =  new Color(250, 74, 47);
		frame.setBounds(120, 65, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		lbFotoCiudad = new JLabel("");
		lbFotoCiudad.setBounds(312, 0, 888, 728);
		this.
		
		puntoInicio = new JLabel("");
		puntoInicio.setLocation(0, 0);
		puntoInicio.setSize(30, 46);
		ImageIcon pin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("greenMarkerM.png")));
		Image pin0 = pin.getImage();
		Image pin1 = pin0.getScaledInstance(puntoInicio.getWidth(), puntoInicio.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon mark = new ImageIcon(pin1);
		puntoInicio.setIcon(mark);
		puntoInicio.setVisible(false);
		
		puntoDestino = new JLabel("");
		puntoDestino.setLocation(0, 0);
		puntoDestino.setSize(30, 46);
		ImageIcon Pin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("redMarker.png")));
		Image Pin0 = Pin.getImage();
		Image Pin1 = Pin0.getScaledInstance(puntoInicio.getWidth(), puntoInicio.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon Mark = new ImageIcon(Pin1);
		puntoDestino.setIcon(Mark);
		puntoDestino.setVisible(false);
		
		lbPintar = new JLabel("") {
			public void paint(Graphics g) {
	            super.paint(g);
	            Queue<Integer> ruta = algoritmo.getRuta();
				int n = ruta.size();
				for (int i = 0; i < n-1; i++) {
					int puntoA = ruta.remove();
					//System.out.print(puntoA + 1 + ", ");
					//System.out.println();
					int puntoB = ruta.peek();
					g.setColor(Color.YELLOW);
					((Graphics2D) g).setStroke(new BasicStroke(5));
					g.drawLine(lugares.nodosUbicacion(puntoA)[0], lugares.nodosUbicacion(puntoA)[1], lugares.nodosUbicacion(puntoB)[0], lugares.nodosUbicacion(puntoB)[1]);
				}
	         }
		};
		
		
		JPanel controles = new JPanel();
		controles.setBounds(0, 0, 312, 728);
		frame.getContentPane().add(controles);
		controles.setLayout(null);
		controles.setOpaque(true);
		controles.setBackground(fondoPanel);
		
		lbBarraControles = new JLabel("GOOGLE MAPS");
		lbBarraControles.setFont(new Font("Muna", Font.PLAIN, 21));
		lbBarraControles.setForeground(SystemColor.menu);
		lbBarraControles.setHorizontalAlignment(SwingConstants.CENTER);
		lbBarraControles.setOpaque(true);
		lbBarraControles.setBounds(0, 0, 312, 51);
		lbBarraControles.setBackground(new Color(227, 79, 67));
		controles.add(lbBarraControles);
		
		lblNav = new JLabel("NAVEGACIÓN");
		lblNav.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNav.setForeground(SystemColor.menu);
		lblNav.setHorizontalAlignment(SwingConstants.CENTER);
		lblNav.setBounds(0, 129, 312, 45);
		controles.add(lblNav);
		
		lblInicio = new JLabel("Inicio");
		lblInicio.setFont(new Font("DIN Alternate", Font.PLAIN, 21));
		lblInicio.setBackground(new Color(238, 238, 238));
		lblInicio.setForeground(SystemColor.activeCaption);
		lblInicio.setBounds(82, 199, 117, 27);
		controles.add(lblInicio);
		
		//Lugar de origen
		comboBox = new JComboBox();			
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("seleccionado " + comboBox.getSelectedItem() + " en la posicion " + comboBox.getSelectedIndex());
				//System.out.println(comboBox.getSelectedItem() + " se ubica en " + lugares.cordenadas(comboBox.getSelectedItem().toString())[0] +  " , " + lugares.cordenadas(comboBox.getSelectedItem().toString())[1]);
				puntoInicio.setVisible(true);
				int x = lugares.cordenadas(comboBox.getSelectedItem().toString())[0];
				int y = lugares.cordenadas(comboBox.getSelectedItem().toString())[1];
				puntoInicio.setLocation(x - 10, y - puntoInicio.getHeight());	
				lbArriba.add(puntoInicio);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hard Rock Hotel", "Cinepolis", "Cancha de basketball", "Construcción", "MetLife Building", "7 Eleven", "Hospital San Javier", "Librerías Ghandi", "Los Tarascos", "Ishop", "Farmacia", "Mi Casa", "Carls Jr", "Gasolinera", "OXXO", "Tec de Monterrey", "Costco", "Parque", "Cajero Automático"}));
		comboBox.setBounds(76, 228, 173, 27);
		controles.add(comboBox);
		
		
		lblNewLabel = new JLabel("Destino");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("DIN Alternate", Font.PLAIN, 21));
		lblNewLabel.setBounds(82, 289, 117, 27);
		controles.add(lblNewLabel);
		
		comboJBDestino = new JComboBox();
		comboJBDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("seleccionado " + comboBox.getSelectedItem() + " en la posicion " + comboBox.getSelectedIndex());
				//System.out.println(comboBox.getSelectedItem() + " se ubica en " + lugares.cordenadas(comboBox.getSelectedItem().toString())[0] +  " , " + lugares.cordenadas(comboBox.getSelectedItem().toString())[1]);
				puntoDestino.setVisible(true);
				int x = lugares.cordenadas(comboJBDestino.getSelectedItem().toString())[0];
				int y = lugares.cordenadas(comboJBDestino.getSelectedItem().toString())[1];
				puntoDestino.setLocation(x - 10, y - puntoDestino.getHeight());	
				lbArriba.add(puntoDestino);
			}
		});
		comboJBDestino.setModel(new DefaultComboBoxModel(new String[] {"Hard Rock Hotel", "Cinepolis", "Cancha de basketball", "Construcción", "MetLife Building", "7 Eleven", "Hospital San Javier", "Librerías Ghandi", "Los Tarascos", "Ishop", "Farmacia", "Mi Casa", "Carls Jr", "Gasolinera", "OXXO", "Tec de Monterrey", "Costco", "Parque", "Cajero Automático"}));
		comboJBDestino.setBounds(76, 316, 173, 27);
		controles.add(comboJBDestino);
		
		
		JButton btnNav = new JButton("Navegar");
		btnNav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int inicio = lugares.nodos(comboBox.getSelectedItem().toString());
				int fini = lugares.nodos(comboJBDestino.getSelectedItem().toString());
				
				algoritmo.rutaMasCorta(inicio, fini);
				
				lbPintar.updateUI();
				lbPintar.setBounds(0, 0, 1200, 730);
				lbArriba.add(lbPintar);		
			}
		});
		btnNav.setBounds(82, 375, 149, 27);
		controles.add(btnNav);
		
		
		//
		buttonInfo = new JButton("");
		buttonInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vInformacion.setVisible(true);
				
			}
		});
		buttonInfo.setForeground(SystemColor.controlHighlight);
		buttonInfo.setBounds(86, 471, 145, 27);
		//Hacer el boton transparente
		buttonInfo.setOpaque(false);
		buttonInfo.setContentAreaFilled(false);
		buttonInfo.setBorderPainted(false);
		controles.add(buttonInfo);
		
		lblInformacin = new JLabel("INFORMACIÓN");
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setForeground(Color.WHITE);
		lblInformacin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblInformacin.setBounds(0, 459, 312, 45);
		controles.add(lblInformacin);
		
		
		
		//
		buttonCreditos = new JButton("");
		buttonCreditos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vCreditos.setVisible(true);
			}
		});
		buttonCreditos.setBounds(95, 537, 117, 29);
		buttonCreditos.setOpaque(false);
		buttonCreditos.setContentAreaFilled(false);
		buttonCreditos.setBorderPainted(false);
		controles.add(buttonCreditos);
		lblCrditos = new JLabel("CRÉDITOS");
		lblCrditos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrditos.setForeground(Color.WHITE);
		lblCrditos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblCrditos.setBounds(0, 526, 312, 45);
		controles.add(lblCrditos);
		
		//Boton salir
		lblSalir = new JLabel("SALIR");
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblSalir.setBounds(0, 598, 312, 45);
		controles.add(lblSalir);
		
		btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(95, 609, 117, 29);
		//Hacer el boton transparente
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		controles.add(btnSalir);

		
		lbArriba = new JLabel("");
		lbArriba.setBounds(0, 0, 1200, 730);
		frame.getContentPane().add(lbArriba);
		frame.getContentPane().add(puntoInicio);
		frame.getContentPane().add(puntoDestino);
		frame.getContentPane().add(lbPintar); 
		
		
		ImageIcon ciud = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("CiudadEtiquetasCompleta.jpg")));
		Image ciudad1 = ciud.getImage();
		Image ciudad2 = ciudad1.getScaledInstance(lbFotoCiudad.getWidth(), lbFotoCiudad.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ciudad = new ImageIcon(ciudad2);
		lbFotoCiudad.setIcon(ciudad);
		frame.getContentPane().add(lbFotoCiudad);
		
		
		
		
		
		
		
		
	}
}
