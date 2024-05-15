package pakotne;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Metodes {
public static int picasIzvele(ArrayList<CilvekaDati>cilvekaDatiList) {
	List<String>saraksts=new ArrayList<>();
	for (int i=0;i<cilvekaDatiList.size();i++) {
	CilvekaDati cilvekaDati=cilvekaDatiList.get(i);
	
	String izvele= "Pica: "+cilvekaDati.getPicasVeidi()+ "Mērce"+cilvekaDati.getMerces();
	saraksts.add(izvele);
	}
	String izveletais=(String)JOptionPane.showInputDialog(null,"Izvēle","Izvēle",JOptionPane.QUESTION_MESSAGE,null,saraksts.toArray(new String[0]),saraksts.get(0));
	int izvIndex=saraksts.indexOf(izveletais);
	return izvIndex!=-1? izvIndex:-1;
}

}
