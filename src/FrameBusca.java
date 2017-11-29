import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FrameBusca {

	private JFrame frame;
	private JTextField txtDigiteASua;
	private JButton btnBuscar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBusca window = new FrameBusca();
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
	public FrameBusca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDigiteASua = new JTextField();
		txtDigiteASua.setText("Digite a sua busca aqui");
		txtDigiteASua.setBounds(71, 110, 290, 25);
		frame.getContentPane().add(txtDigiteASua);
		txtDigiteASua.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar <OR>");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(71, 147, 139, 25);
		frame.getContentPane().add(btnBuscar);
		
		btnBuscar_1 = new JButton("Buscar <AND>");
		btnBuscar_1.setBounds(222, 147, 139, 25);
		frame.getContentPane().add(btnBuscar_1);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Dialog", Font.BOLD, 24));
		lblB.setForeground(Color.BLUE);
		lblB.setBounds(71, 48, 22, 39);
		frame.getContentPane().add(lblB);
		
		JLabel lblU = new JLabel("U");
		lblU.setFont(new Font("Dialog", Font.BOLD, 24));
		lblU.setForeground(Color.RED);
		lblU.setBounds(118, 54, 29, 27);
		frame.getContentPane().add(lblU);
		
		JLabel lblS = new JLabel("S");
		lblS.setFont(new Font("Dialog", Font.BOLD, 24));
		lblS.setForeground(Color.BLUE);
		lblS.setBounds(224, 52, 22, 31);
		frame.getContentPane().add(lblS);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Dialog", Font.BOLD, 24));
		lblC.setForeground(Color.GREEN);
		lblC.setBounds(280, 52, 22, 31);
		frame.getContentPane().add(lblC);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Dialog", Font.BOLD, 24));
		lblA.setForeground(Color.RED);
		lblA.setBounds(332, 52, 29, 31);
		frame.getContentPane().add(lblA);
		
		JLabel lblU_1 = new JLabel("U");
		lblU_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblU_1.setForeground(Color.YELLOW);
		lblU_1.setBounds(170, 52, 29, 30);
		frame.getContentPane().add(lblU_1);
	}
}
