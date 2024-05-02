package pakotne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Picerija {

	public static void main(String[] args) {
	ArrayList<CilvekaDati> cilvekaDatiList=new ArrayList<>();
		String izvele;
		int izvelesIndekss = 0;
		String []darbibas={"Pasūtīt picu","Apskatīt pasūtījumus","Sūtītāja info","Čeks","Apturēt"};
		do {
			
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību","Izvēle",JOptionPane.QUESTION_MESSAGE,null, darbibas, darbibas[0]);
			izvelesIndekss=Arrays.asList(darbibas).indexOf(izvele);
			switch(izvelesIndekss) {
			case 0:
				//pasutit picu 
				String vards ;
				do {
				 
				 vards=JOptionPane.showInputDialog("Ievadi savu vārdu ");
//				 if (vards==null|| vards.isEmpty()||!Pattern.matches("[a-zA-Z]", vards)) {
//					 JOptionPane.showMessageDialog(null, "Ievadi korrektu vārdu","Paziņojums",JOptionPane.ERROR_MESSAGE);
//				 }
//				 if(vards==null||vards.isEmpty()) {
//					 JOptionPane.showMessageDialog(null, "Ievadi vārdu","Paziņojums",JOptionPane.WARNING_MESSAGE);
//					 vards=JOptionPane.showInputDialog("Ievadi savu vārdu ");
				}while(vards.length()<3);
				String uzvards;
				do {
				 uzvards=JOptionPane.showInputDialog("Ievadi uzvārdu");
				}while(uzvards.length()<3);
				String telefonaNr;
				do {
				telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				}while(telefonaNr.length()<7||telefonaNr.length()>9);
				if (!Pattern.matches("\\d+", telefonaNr)) {
					JOptionPane.showMessageDialog(null, "Telefona numur ir jārakstā ar burtiem","Kļūda ", JOptionPane.ERROR_MESSAGE);
					telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				}
				cilvekaDatiList.add (new CilvekaDati(vards,uzvards,telefonaNr));
				String[]picasVeidi= {"Lauku","Salami","Vegetāra"};
				int picasIzvele=JOptionPane.showOptionDialog(null, "Picas izvele", "izvēle", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picasVeidi, picasVeidi[0]);
				double cenas[]={5.99,6.99,7.99};
				
				String[] merces= {"Kečups","Majonēze","Tabasko"};
				
				int izveletaMerce=JOptionPane.showOptionDialog(null, "Mērču izvēle", "izvēle", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, merces, merces[0]);
				double mercuCena[]= {0.35,0.40,0.75};
				
				double summa=0;
				summa=cenas[picasIzvele];
				summa=mercuCena[izveletaMerce];
				
				int piegade=JOptionPane.showOptionDialog(null,"Vajadzīga piegāde?", "Piegāde",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,JOptionPane.NO_OPTION);
				if(piegade==JOptionPane.YES_OPTION) {
					summa+=2.50;
				}
			case 1:
				break;
			case 2:
				if(!cilvekaDatiList.isEmpty()) {
			     for(CilvekaDati cilvekaDati : cilvekaDatiList) {
			    	 cilvekaDati.infoIzvade();
			     }
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
