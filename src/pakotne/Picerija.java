package pakotne;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Picerija {
private static CilvekaDati cilvekaDati=null;
	public static void main(String[] args) {
		String izvele;
		int izvelesIndekss = 0;
		String []darbibas={"Pasūtīt picu","Apskatīt pasūtījumus","Sūtītāja info","Čeks","Apturēt"};
		do {
			
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību","Izvēle",JOptionPane.QUESTION_MESSAGE,null, darbibas, darbibas[0]);
			izvelesIndekss=Arrays.asList(darbibas).indexOf(izvele);
			switch(izvelesIndekss) {
			case 0:
				//pasutit picu 
				
				 String vards =JOptionPane.showInputDialog("Ievadi savu vārdu ");
				String uzvards=JOptionPane.showInputDialog("Ievadi uzvārdu");
				String telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				if (!Pattern.matches("\\d+", telefonaNr)) {
					JOptionPane.showMessageDialog(null, "Telefona numur ir jārakstā ar burtiem","Kļūda ", JOptionPane.ERROR_MESSAGE);
					telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				}
				cilvekaDati= new CilvekaDati(vards,uzvards,telefonaNr);
				
				
				JFrame picaLogs=new JFrame("Izvēlies");
				picaLogs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				picaLogs.setSize(700,700);
				
				JPanel picas=new JPanel();
				picas.setLayout(new GridLayout(3,1));
				
				JRadioButton salami=new JRadioButton(new ImageIcon("pakotne.salami.png"));
				JRadioButton lauku=new JRadioButton(new ImageIcon("lauku.png"));
				JRadioButton vegetara=new JRadioButton(new ImageIcon("vegetara.png"));
				
				ButtonGroup grupa=new ButtonGroup();
				grupa.add(salami);
				grupa.add(lauku);
				grupa.add(vegetara);
				
				
				picas.add(salami);
				picas.add(lauku);
				picas.add(vegetara);
				
				
				picaLogs.add(picas);
				
				int picasIzvele=JOptionPane.showOptionDialog(picaLogs, picas, "Izvēlies picu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,new Object[] {salami,lauku,vegetara},salami);
				picaLogs.setVisible(true);
			case 1:
				break;
			case 2:
				if(cilvekaDati!=null) {
			     cilvekaDati.infoIzvade();
				}else {
					JOptionPane.showMessageDialog(null, "Vēl nav informācijas ","Paziņojums",JOptionPane.PLAIN_MESSAGE);
				}
				break;
			
			case 3:
				break;
			case 4:
				System.exit(0);
				break;
			}
		}while(izvelesIndekss!=5);

	}

}
