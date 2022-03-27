package id.co.kosan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MKosan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomKosanGenerator generator = new RandomKosanGenerator();
		
		
		
		Kosan kost = new Kosan(10.0, new BigDecimal(550000.0));
		Kosan kost2 = generator.generate();
		Kosan kost3 = new Kosan(12.0, new BigDecimal(300000.0));
		Kosan kost4 = new Kosan(0.0, new BigDecimal(350000.0));
		
		int nilai = KosanRater.rateKosan(kost);
		int nilai2 = KosanRater.rateKosan(kost2);
		int nilai3 = KosanRater.rateKosan(kost3);
		int nilai4 = KosanRater.rateKosan(kost4);
		
		System.out.println(nilai);
		System.out.println(nilai2);
		System.out.println(nilai3);
		System.out.println(nilai4);
		System.out.println(kost2.getLuas());
		System.out.println(kost2.getHarga());

		List<Kosan> kosts = new ArrayList<>();
		kosts.add(new Kosan(10.0, new BigDecimal(550000.0)));
		kosts.add(new Kosan(40.0, new BigDecimal(2200000.0)));
		kosts.add(new Kosan(30.0, new BigDecimal(7650000.0)));
		
		double average = KosanRater.calculateAverageRating(kosts);
		System.out.println(kosts);
		System.out.println(average);
	}

}
