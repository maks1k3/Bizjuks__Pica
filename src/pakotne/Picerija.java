package pakotne;

import javax.swing.JOptionPane;

public class Picerija {

	public static void main(String[] args) {
		String izvele;
		int izvelesIndekss = 0;
		String []darbibas={"Pasūtīt picu","Apskatīt pasūtījumus","Sūtītāja info","Čeks","Apturēt"};
		do {
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību","Izvēle",JOptionPane.QUESTION_MESSAGE,null, darbibas, darbibas[0]);
			
			switch(izvelesIndekss) {
			case 0:
				//pasutit picu 
				String vards =JOptionPane.showInputDialog("Ievadi savu vārdu ");
				
			}
		}while(izvelesIndekss!=5);

	}

}
