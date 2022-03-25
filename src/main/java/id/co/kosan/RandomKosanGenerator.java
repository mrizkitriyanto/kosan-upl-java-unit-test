package id.co.kosan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomKosanGenerator {
	private static final double MAX_MULTIPLIER = 4.0;

	private double minLuas;
	private BigDecimal minHargaPerMeterKuadrat;

	public RandomKosanGenerator() {
		super();
		this.minLuas = 10.0;
		this.minHargaPerMeterKuadrat = new BigDecimal(300000.0);
	}

	public RandomKosanGenerator(double minLuas, BigDecimal minHargaPerMeterKuadrat) {
		super();
		this.minLuas = minLuas;
		this.minHargaPerMeterKuadrat = minHargaPerMeterKuadrat;
	}

	public kosan generate() {
		double maxLuas = minLuas * MAX_MULTIPLIER;
		BigDecimal maxHargaPerMeterKuadrat = minHargaPerMeterKuadrat.multiply(new BigDecimal(MAX_MULTIPLIER));

		double luas = Math.round((minLuas + Math.random() * (maxLuas - minLuas)) * 10) / 10;
		BigDecimal hargaPerSquareMeter = minHargaPerMeterKuadrat
				.add((new BigDecimal(Math.random()).multiply(maxHargaPerMeterKuadrat.subtract(minHargaPerMeterKuadrat))));
		BigDecimal harga = hargaPerSquareMeter.multiply(new BigDecimal(luas)).setScale(1, RoundingMode.FLOOR);
		return new kosan(luas, harga);
	}
}
