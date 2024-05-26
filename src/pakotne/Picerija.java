package pakotne;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Picerija {

	public static void main(String[] args) {
	ArrayList<CilvekaDati> cilvekaDatiList=new ArrayList<>();
		String izvele;
		int izvelesIndekss = 0;
		String []darbibas={"Pasūtīt picu","Noņemt pasutījumu","Sūtītāja info","Čeks","Apturēt"};
		Ceks ceks = null;
		
		do {
			
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību","Izvēle",JOptionPane.QUESTION_MESSAGE,null, darbibas, darbibas[0]);
			izvelesIndekss=Arrays.asList(darbibas).indexOf(izvele);
			switch(izvelesIndekss) {
			case 0:
				//pasutit picu 
				String vards ;
				do {
				 
				 vards=JOptionPane.showInputDialog("Ievadi savu vārdu ");
				 if(!pareizs(vards)) {
					 JOptionPane.showMessageDialog(null, "Ievadi korrektu vārdu","Paziņojums",JOptionPane.ERROR_MESSAGE);
					 continue;
				 }
//				 if (vards==null|| vards.isEmpty()||!Pattern.matches("[a-zA-Z]", vards)) {
//					 JOptionPane.showMessageDialog(null, "Ievadi korrektu vārdu","Paziņojums",JOptionPane.ERROR_MESSAGE);
//				 }
//				 if(vards==null||vards.isEmpty()) {
//					 JOptionPane.showMessageDialog(null, "Ievadi vārdu","Paziņojums",JOptionPane.WARNING_MESSAGE);
//					 vards=JOptionPane.showInputDialog("Ievadi savu vārdu ");
				 break;
				}while(true);
				String uzvards;
				do {
				 uzvards=JOptionPane.showInputDialog("Ievadi uzvārdu");
				 if(!pareizsU(uzvards)) {
					 JOptionPane.showMessageDialog(null, "Ievadi korrektu vārdu","Paziņojums",JOptionPane.ERROR_MESSAGE);
					 continue;
				 }
				 break;
				}while(true);
				String telefonaNr;
				do {
				telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				}while(telefonaNr.length() != 8 ||!Character.isDigit( telefonaNr.charAt(0)));
				if (!Character.isDigit(telefonaNr.charAt(0))) {
					JOptionPane.showMessageDialog(null, "Telefona numur ir jāraksta ar burtiem","Kļūda ", JOptionPane.ERROR_MESSAGE);
					telefonaNr=JOptionPane.showInputDialog("Ievadi telefona numuru");
				}
			
				String[]picasVeidi= {"Lauku (5.99€)","Salami (6.99€)","Vegetāra (7.99€)"};
				int picasIzvele=JOptionPane.showOptionDialog(null, "Picas izvele", "izvēle", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picasVeidi, picasVeidi[0]);
				double picaCenas[]={5.99,6.99,7.99};
				double picaCena=picaCenas[picasIzvele];
				String[] merces= {"Kečups (0.35€)","Majonēze (0.40€)","Tabasko (0.75€)"};
				
				int izveletaMerce=JOptionPane.showOptionDialog(null, "Mērču izvēle", "izvēle", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, merces, merces[0]);
				double mercuCenas[]= {0.35,0.45,0.75};
				double merceCena=mercuCenas[izveletaMerce];
				
				double summa = picaCenas[picasIzvele] + mercuCenas[izveletaMerce];
				
				System.out.println(picaCenas[picasIzvele] +" and "+ mercuCenas[izveletaMerce]);
				int piegade=JOptionPane.showOptionDialog(null,"Vajadzīga piegāde?", "Piegāde maksā (2.50€)",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,JOptionPane.NO_OPTION);
				
				String piegadeInfo=(piegade==JOptionPane.YES_NO_OPTION)? "Ir":"Nav";
				ceks=new Ceks(picaCena,merceCena);
				double piegadesSumma=2.50;
				ceks.setMercesCena(merceCena);
				if(piegade==JOptionPane.YES_OPTION) {
					
					summa+=piegadesSumma;
//					Ceks ceks=new Ceks(6.90,0.30);
					ceks.setPiegade(piegadesSumma, true);
					
				}else {
					ceks.setPiegade(piegadesSumma, false);
				}
				ceks.setSumma(summa);
				 String picasVeidiIzv=picasVeidi[picasIzvele];
				String  mercesIzv=merces[izveletaMerce];
				cilvekaDatiList.add (new CilvekaDati(vards,uzvards,telefonaNr,picasVeidiIzv, mercesIzv, piegadeInfo));
				pasutijumi(vards,uzvards,telefonaNr,picasVeidiIzv,mercesIzv,piegadeInfo);
				break;
			case 1:
				if(!cilvekaDatiList.isEmpty()) {
					int indexRemove=Metodes.picasIzvele(cilvekaDatiList);
					if(indexRemove!= -1) {
						cilvekaDatiList.remove(indexRemove);
						JOptionPane.showMessageDialog(null, "Pica ir noņemta","Paziņojums",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "nav picas","Bridinajums",JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nav picas!","Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
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
//			String pane=JOptionPane.showMessageDialog(null, "Vēl nav informācijas ","Paziņojums",JOptionPane.PLAIN_MESSAGE);
//				if (!pane.isEmpty()) {
//					display(ceks);
//				}
				if(!cilvekaDatiList.isEmpty()) {
				     display(ceks);
					}else {
						JOptionPane.showMessageDialog(null, "Vēl nav informācijas ","Paziņojums",JOptionPane.PLAIN_MESSAGE);
					}
					
				break;
			case 4:
				System.exit(0);
				break;
			}
		}while(izvelesIndekss!=5);

		
	}
public static void display(Ceks ceks) {
	String cekaInfo= "Picas cena : "+ ceks.getPicasCena()+"€"+ "\nMērces cena: "+ceks.getMercesCena()+"€";
	if(ceks.isIrPiegade()) {
		cekaInfo+="\nPiegādes cena: "+ceks.getPiegade()+"€";
		cekaInfo+="\nSumma: "+ceks.getSumma()+"€";
	}
	JOptionPane.showMessageDialog(null, cekaInfo,"Čeks",JOptionPane.INFORMATION_MESSAGE);
}
private static boolean pareizs(String vards) {
	return Pattern.matches("[a-zA-Z]+", vards);
}
private static boolean pareizsU(String uzvards) {
	return Pattern.matches("[a-zA-Z]+", uzvards);

}
private static void pasutijumi(String vards, String uzvards, String telefonaNr, String picasVeidsIzv, String mercesIzv, String piegadeInfo) {
	try(BufferedWriter writer=new BufferedWriter(new FileWriter("pasutijumi.txt",true))){
		writer.write("vārds: "+ vards+ "\n");
		writer.write("Uzvārds: "+ uzvards+ "\n");
		writer.write("Pica: "+ picasVeidsIzv+ "\n");
		writer.write("Merce: "+ mercesIzv+ "\n");
		writer.write("Piegade: "+ piegadeInfo+ "\n-----------------\n");
		System.out.println("Iet");
	}catch(IOException e){
		System.out.println("Kļūda rakstot failā"+ e.getMessage());
	}
}
}