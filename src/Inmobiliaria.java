import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javafx.scene.control.CheckBox;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Inmobiliaria extends JFrame implements ActionListener
{
	JComboBox combo1;
	ButtonGroup g1, g2;
	JRadioButton r1, r2, r3, r4, r5;
	JCheckBox ch1, ch2;
	JLabel l1, l2, l3;
	JTextField e1;
	JButton b1, b2;

	
	Inmobiliaria ()
	{
		setLayout (null);
			
		Font f1 = new Font ("Serif",2,25);
		Font f2 = new Font ("Serif",3,30);
		
		l1 = new JLabel("Inmobiliaria Rodriguez Perez",JLabel.CENTER);
		l1.setBounds(30,30,470,30);
		l1.setFont(f1);
		l1.setForeground(Color.red);
		add(l1);
		
		combo1 = new JComboBox();
		combo1.setBounds(30,90,220,40);
		combo1.addItem("SELECCIONE TIPO");
		combo1.addItem("Casa  (u$D80)");
		combo1.addItem("Duplex  (u$D60)");
		combo1.addItem("Departamento  (u$D50)");
		add(combo1);
		
		g1 = new ButtonGroup();
		
		r1 = new JRadioButton("1 dormitorio  (base)");
		r1.setBounds(280,90,220,40);
		r1.setSelected(true);
		g1.add(r1);
		add(r1);
		
		r2 = new JRadioButton("2 dormitorios  (+5%)");
		r2.setBounds(280,150,220,40);
		g1.add(r2);
		add(r2);
		
		r3 = new JRadioButton("3 dormitorios  (+10%)");
		r3.setBounds(280,210,220,40);
		g1.add(r3);
		add(r3);
				
		ch1 = new JCheckBox("Piscina  (U$D10)");
		ch1.setBounds(30,280,220,40);
		add(ch1);
		
		ch2 = new JCheckBox("Cochera  (U$D5)");
		ch2.setBounds(30,340,220,40);
		add(ch2);
		
		g2 = new ButtonGroup();
		
		r4 = new JRadioButton("Zona céntrica  (+2%)");
		r4.setBounds(30,400,220,40);
		g2.add(r4);
		add(r4);
		
		r5 = new JRadioButton("Zona periférica  (base)");
		r5.setBounds(30,460,220,40);
		r5.setSelected(true);
		g2.add(r5);
		add(r5);
		
		l2 = new JLabel("Cantidad de días:");
		l2.setBounds(30,540,220,40);
		add(l2);
				
		e1 = new JTextField("");
		e1.setBounds(280,540,50,40);
		add(e1);
												
		b1 = new JButton ("Calcular importe");
		b1.setBounds(30,620,220,50);
		b1.addActionListener(this);
		add(b1);
						
		l3=new JLabel ("U$D 0.00",JLabel.CENTER);
		l3.setBounds(280,620,220,50);
		l3.setFont(f2);
		l3.setForeground(Color.blue);
		l3.setBackground(Color.yellow);
		l3.setOpaque(true);
		add(l3);
		
		b2=new JButton("Salir");
		b2.setBounds(30,710,220,50);
		b2.addActionListener(this);
		add(b2);
							
	}
		

		public void actionPerformed (ActionEvent e)
		{
					
			if(e.getSource()==b1)
			{
				int indice = combo1.getSelectedIndex();
				
				double tipo = 0;
			
				switch (indice)
				{
				case 0: JOptionPane.showMessageDialog(null, "Falta seleccionar tipo de inmueble");
				case 1: tipo = 80; break;
				case 2: tipo = 60; break;
				case 3: tipo = 50; break;				
				}
											
				double dormi = 0;
				
				if(r1.isSelected())
					dormi=0;
				else
					if(r2.isSelected())
						dormi = tipo*0.05;
					else
						if (r3.isSelected())
							dormi = tipo*0.10;
												
				double zona = 0;
				
				if(r4.isSelected())
					zona = tipo*0.02;
				else
					if(r5.isSelected())
						zona = 0;
				
				double extras = 0;
				
				if(ch1.isSelected())
				extras = extras+10;
				
				if(ch2.isSelected())
				extras = extras+5;

				double total = tipo+dormi+zona+extras; 
				
				String dias = e1.getText();
				
				if(dias.equals(""))
				JOptionPane.showMessageDialog(null, "Falta ingresar cantidad de dias");
				else
				{
					double estadia = Double.parseDouble(dias);
					
					double precio = total*estadia;
					
					DecimalFormat f = new DecimalFormat("0.00");
					
					l3.setText("U$D "+f.format(precio));					
				}
			}
				
				if(e.getSource()==b2)
				{
					System.exit(0);
				}
			}
									
				
		
	public static void main(String[] args)
		{
		Inmobiliaria i = new Inmobiliaria ();
			i.setBounds (100,100,550,830);
			i.setTitle("Inmobiliaria");
			i.setVisible(true);
			i.setResizable(true);
		}

}