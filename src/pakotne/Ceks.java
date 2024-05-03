package pakotne;

import javax.swing.JOptionPane;

public class Ceks {
private double picasCena;
private double mercesCena;
private double summa;
private double piegade;
private boolean irPiegade;

public Ceks(double picasCena, double mercesCena) {
	this.picasCena=picasCena;
	this.mercesCena=mercesCena;
	this.irPiegade=false;
	this.Sum();
}
private void Sum() {
	this.summa=this.picasCena+this.mercesCena;
	if(this.irPiegade) {
		this.summa+=this.piegade;
	}
}
	public  void infoIzvade() {
		String cekaInfo="Picas cena : "+this.picasCena+"/nMērces cena: "+this.mercesCena;
		if(this.irPiegade) {
			cekaInfo="Piegādes cena : "+this.piegade;
			cekaInfo="Čeka summa: "+ this.summa;
			JOptionPane.showMessageDialog(null, cekaInfo,"Čeka informācija",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void setPicasCena(double picasCena) {
		this.picasCena=this.picasCena;
		this.Sum();
	}
	public void setMercesCena(double mercesCena) {
		this.mercesCena=this.mercesCena;
		this.Sum();
	}
	public void setPiegade(double piegade,boolean irPiegade) {
		this.irPiegade=this.irPiegade;
		this.piegade=this.piegade;
		this.Sum();
	}
	public double getSumma() {
		return this.summa;
	}
}

