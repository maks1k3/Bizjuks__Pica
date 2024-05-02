package pakotne;

import javax.swing.JOptionPane;

public class CilvekaDati {
private String vards;
private String uzvards;
private String telefonaNr;

public CilvekaDati(String vards,String uzvards, String telefonaNr) {
	this.vards=vards;
	this.uzvards=uzvards;
	this.telefonaNr=telefonaNr;
}
public void  infoIzvade(){
	JOptionPane.showMessageDialog(null, "Vārds: "+vards+ "\nUzvārds: "+uzvards+"\nTelefona Numurs: "+telefonaNr,"Cilvēka dati",JOptionPane.INFORMATION_MESSAGE);
}
}
