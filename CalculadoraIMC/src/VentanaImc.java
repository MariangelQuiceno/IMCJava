import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaImc extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextArea areaResultado;
	private JButton btnCalcularImc, btnCalcularPromedio, btnRegistrar, btnListaPersonas;
	
	Procesos nuevoProceso;
	
	public VentanaImc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 590);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nuevoProceso = new Procesos();
		componentes();
	}
	
	
	public void componentes() {
		
		JLabel lblTitulo = new JLabel("Calculadora IMC");
		lblTitulo.setForeground(new Color(112, 128, 144));
		lblTitulo.setBackground(new Color(119, 136, 153));
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 23));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 11, 268, 49);
		contentPane.add(lblTitulo);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDocumento.setForeground(new Color(47, 79, 79));
		lblDocumento.setBounds(20, 78, 83, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setForeground(new Color(47, 79, 79));
		lblNombre.setBounds(20, 134, 64, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setForeground(new Color(47, 79, 79));
		lblEdad.setBounds(20, 189, 64, 14);
		contentPane.add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setForeground(new Color(47, 79, 79));
		lblPeso.setBounds(20, 241, 64, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAltura.setForeground(new Color(47, 79, 79));
		lblAltura.setBounds(20, 293, 64, 14);
		contentPane.add(lblAltura);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(17, 103, 213, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(17, 158, 213, 20);
		contentPane.add(txtNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(17, 214, 213, 20);
		contentPane.add(txtEdad);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(17, 266, 213, 20);
		contentPane.add(txtPeso);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(17, 318, 213, 20);
		contentPane.add(txtAltura);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(new Color(47, 79, 79));
		lblResultado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblResultado.setBounds(20, 366, 83, 14);
		contentPane.add(lblResultado);
		
		btnListaPersonas = new JButton("Lista de Personas");
		btnListaPersonas.setBounds(258, 290, 144, 23);
		contentPane.add(btnListaPersonas);
		btnListaPersonas.addActionListener(this);
		
		btnRegistrar = new JButton("Registrar Persona");
		btnRegistrar.setBounds(258, 238, 144, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		btnCalcularPromedio = new JButton("Calcular Promedio");
		btnCalcularPromedio.setBounds(258, 186, 144, 23);
		contentPane.add(btnCalcularPromedio);
		btnCalcularPromedio.addActionListener(this);
		
		btnCalcularImc = new JButton("Calcular IMC");
		btnCalcularImc.setBounds(258, 131, 144, 23);
		contentPane.add(btnCalcularImc);
		btnCalcularImc.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 391, 414, 149);
		contentPane.add(scrollPane);
		
		areaResultado = new JTextArea();
		areaResultado.setLineWrap(true);
		scrollPane.setViewportView(areaResultado);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegistrar) {
			Persona nuevaPersona = new Persona();
			
			nuevaPersona.setDocumento(txtDocumento.getText());
			nuevaPersona.setNombre(txtNombre.getText());
			nuevaPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			nuevaPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			nuevaPersona.setAltura(Double.parseDouble(txtAltura.getText()));
			
			
			String impresor = nuevoProceso.registrarPersona(nuevaPersona);
			areaResultado.setText(impresor);
		}
		
		if(e.getSource() == btnListaPersonas) {
			String impresor = nuevoProceso.consultarLista();
			areaResultado.setText(impresor);
		}
		
		if(e.getSource() == btnCalcularImc) {
			
		    double altura = Double.parseDouble(txtAltura.getText());
		    double peso = Double.parseDouble(txtPeso.getText());
		    
		    
		    String imc = nuevoProceso.calcularSoloIMC(altura, peso);
		    
		 
		    areaResultado.setText(imc);
		}
		
	if(e.getSource() == btnCalcularPromedio) {
		    
		String impresor = nuevoProceso.calcularPromedio();
		    
		areaResultado.setText(impresor);
		}
		
		
		
		
	}
	
	
}
