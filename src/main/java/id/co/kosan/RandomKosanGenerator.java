package id.co.kosan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomKosanGenerator {
	private static final double MAX_MULTIPLIER = 4.0;

	private double minLuas;
	private BigDecimal minHargaPerMeterKuadrat;

	public RandomKosanGenerator() {
		super();
		this.minLuas = 30.0;
		this.minHargaPerMeterKuadrat = new BigDecimal(3000.0);
	}

	public RandomKosanGenerator(double minLuas, BigDecimal minHargaPerMeterKuadrat) {
		super();
		this.minLuas = minLuas;
		this.minHargaPerMeterKuadrat = minHargaPerMeterKuadrat;
	}

	public kosan generate() {
		double maxLuas = minLuas * MAX_MULTIPLIER;
		BigDecimal maxHargaPerMeterKuadrat = minHargaPerMeterKuadrat.multiply(new BigDecimal(MAX_MULTIPLIER));

		double area = Math.round((minLuas + Math.random() * (maxLuas - minLuas)) * 10) / 10;
		BigDecimal pricePerSquareMeter = minHargaPerMeterKuadrat
				.add((new BigDecimal(Math.random()).multiply(maxHargaPerMeterKuadrat.subtract(minHargaPerMeterKuadrat))));
		BigDecimal price = pricePerSquareMeter.multiply(new BigDecimal(area)).setScale(1, RoundingMode.FLOOR);
		return new kosan(area, price);
	}
}
