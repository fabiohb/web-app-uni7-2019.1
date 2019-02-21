package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NumberBean {
	
	private double number = Math.random();
	
	private double range = 1.0;

	public double getRange() {
		return (range);
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getNumber() {
		return (number);
	}

	public void randomize() {
		number = range * Math.random();
	}
}