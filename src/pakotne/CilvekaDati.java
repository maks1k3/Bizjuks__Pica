package pakotne;

import javax.swing.JOptionPane;

public class CilvekaDati {
private String vards;
private String uzvards;
private String telefonaNr;
private String picasVeidi;
private String merces;
private String piegade;


public CilvekaDati(String vards,String uzvards, String telefonaNr,String picasVeidi,String merces,String piegade) {
	this.vards=vards;
	this.uzvards=uzvards;
	this.telefonaNr=telefonaNr;
	this.picasVeidi=picasVeidi;
	this.merces=merces;
	this.piegade=piegade;
}
public String getPicasVeidi() {
	return picasVeidi;
}
public String getMerces() {
	return merces;
}
public void  infoIzvade(){
	JOptionPane.showMessageDialog(null, "Vārds: "+vards+ "\nUzvārds: "+uzvards+"\nTelefona Numurs : "+telefonaNr+"\nPica :"+picasVeidi+"\nMērce :"+merces+"\nPiegāde : "+piegade,"Cilvēka dati",JOptionPane.INFORMATION_MESSAGE);
}





}
