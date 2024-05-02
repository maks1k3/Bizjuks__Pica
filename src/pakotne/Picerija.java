package pakotne;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

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
				break;
			case 1:
				break;
			case 2:
				if(cilvekaDati!=null) {
			     cilvekaDati.infoIzvade();
				}else {
					JOptionPane.showMessageDialog(null, "Vēl nav informācijas ","Paziņojums",JOptionPane.PLAIN_MESSAGE);
				}
				break;
			}
		}while(izvelesIndekss!=5);

	}

}
