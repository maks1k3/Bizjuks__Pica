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
	this.Sum();
}
private void Sum() {
	if(irPiegade) {
		summa += piegade;
	}
	summa= picasCena+mercesCena;
}
	public  void infoIzvade() {
		String cekaInfo="Picas cena : "+picasCena+"/nMērces cena: "+mercesCena;
		if(irPiegade) {
			cekaInfo="Piegādes cena : "+piegade;
			cekaInfo="Čeka summa: "+ summa;
			JOptionPane.showMessageDialog(null, cekaInfo,"Čeka informācija",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void setPicasCena(double picasCena) {
		this.picasCena=picasCena;
		Sum();
	}
	public void setMercesCena(double mercesCena) {
		this.mercesCena=mercesCena;
		Sum();
	}
	
	public void setPiegade(double piegade,boolean irPiegade) {
		this.irPiegade= irPiegade;
		this.piegade= piegade;
	
	}
	public void setSumma(double summa) {
		this.summa=summa;
	}
	public double getSumma() {
		return summa;
	}
	public double getPicasCena() {
		return picasCena;
	}
	public double getMercesCena() {
		return mercesCena;
			
	}
	public double getPiegade() {
		return piegade;
	}
	public boolean isIrPiegade() {
		return irPiegade;
	}
	public boolean isEmpty() {
	
		return false;
	}
}

