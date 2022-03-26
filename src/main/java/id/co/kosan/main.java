package id.co.kosan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomKosanGenerator generator = new RandomKosanGenerator();
		
		
		
		kosan kost = new kosan(10.0, new BigDecimal(550000.0));
		kosan kost2 = generator.generate();
		kosan kost3 = new kosan(12.0, new BigDecimal(300000.0));
		
		int nilai = KosanRater.rateKosan(kost);
		int nilai2 = KosanRater.rateKosan(kost2);
		int nilai3 = KosanRater.rateKosan(kost3);
		
		System.out.println(nilai);
		System.out.println(nilai2);
		System.out.println(nilai3);
		System.out.println(kost2.getLuas());
		System.out.println(kost2.getHarga());

		List<kosan> kosts = new ArrayList<>();
		kosts.add(new kosan(10.0, new BigDecimal(550000.0)));
		kosts.add(new kosan(40.0, new BigDecimal(2200000.0)));
		kosts.add(new kosan(30.0, new BigDecimal(1650000.0)));
		
		double average = KosanRater.calculateAverageRating(kosts);
		System.out.println(kosts);
		System.out.println(average);
	}

}
