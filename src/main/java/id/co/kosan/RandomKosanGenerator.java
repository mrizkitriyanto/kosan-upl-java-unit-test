package id.co.kosan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomKosanGenerator {
	private static final double MAX_MULTIPLIER = 4.0;

	private double minLuas;
	private BigDecimal minHargaPerMeterPersegi;

	public RandomKosanGenerator() {
		super();
		this.minLuas = 10.0;
		this.minHargaPerMeterPersegi = new BigDecimal(300000.0);
	}

	public RandomKosanGenerator(double minLuas, BigDecimal minHargaPerMeterPersegi) {
		super();
		this.minLuas = minLuas;
		this.minHargaPerMeterPersegi = minHargaPerMeterPersegi;
	}

	public kosan generate() {
		double maxLuas = minLuas * MAX_MULTIPLIER;
		BigDecimal maxHargaPerMeterPersegi = minHargaPerMeterPersegi.multiply(new BigDecimal(MAX_MULTIPLIER));

		double luas = Math.round((minLuas + Math.random() * (maxLuas - minLuas)) * 10) / 10;
		BigDecimal hargaPerSquareMeter = minHargaPerMeterPersegi
				.add((new BigDecimal(Math.random()).multiply(maxHargaPerMeterPersegi.subtract(minHargaPerMeterPersegi))));
		BigDecimal harga = hargaPerSquareMeter.multiply(new BigDecimal(luas)).setScale(1, RoundingMode.FLOOR);
		return new kosan(luas, harga);
	}
}
