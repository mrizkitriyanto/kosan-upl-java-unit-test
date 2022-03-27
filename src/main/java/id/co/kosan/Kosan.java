package id.co.kosan;

import java.math.BigDecimal;

public class Kosan {
	private double luas;
	private BigDecimal harga;
	
	public Kosan(double luas, BigDecimal harga) {
		super();
		this.luas = luas;
		this.harga = harga;
	}
	public double getLuas() {
		return luas;
	}
	public void setLuas(float luas) {
		this.luas = luas;
	}
	public BigDecimal getHarga() {
		return harga;
	}
	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	@Override
	public String toString() {
		return "Kosan [luas =" + luas + ", harga =" + harga + "]";
	}

}
