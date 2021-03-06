package id.co.kosan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class KosanRater {
	private static final BigDecimal BATAS_MURAH = new BigDecimal(37500.0); //Per meter persegi
	private static final BigDecimal BATAS_NORMAL = new BigDecimal(65000.0); //Per meter persegi
	
	public static int rateKosan(Kosan kosan) {
		if (kosan.getLuas() == 0.0) {
			return -1; // Error
		}
		BigDecimal ratio = kosan.getHarga().divide(new BigDecimal(kosan.getLuas()), RoundingMode.HALF_UP);
		
		if (ratio.compareTo(BATAS_MURAH) < 0) {
			return 0; //Kategori Murah
		} else if (ratio.compareTo(BATAS_MURAH) >= 0 && ratio.compareTo(BATAS_NORMAL) < 0) {
			return 1; //Kategori Normal
		} else {
			return 2; //Kategori Mahal
		}
	}
	
	public static double calculateAverageRating(List<Kosan> kosans) {
		//List Kosong akan mengembalikan nilai eksepsi
		if (kosans.isEmpty()) {
			throw new RuntimeException("Tidak bisa menghitung rate rata-rata untuk list yang kosong");
		} 
		int sumRatings = 0;
		for (Kosan kosan : kosans) {
			sumRatings += rateKosan(kosan);
		}
		return sumRatings * 1.0 / kosans.size();	
	}
}
