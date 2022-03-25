package id.co.kosan;

import java.math.BigDecimal;

public class kosan {
	private double luas;
	private BigDecimal harga;
	
	public kosan(double laus, BigDecimal harga) {
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
	public void setHarga(BigDecimal price) {
		this.harga = harga;
	}
	@Override
	public String toString() {
		return "Kosan [luas =" + luas + ", harga =" + harga + "]";
	}

}
