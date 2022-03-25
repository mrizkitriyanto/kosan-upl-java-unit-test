package id.co.kosan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class KosanRater {
	private static final BigDecimal BATAS_MURAH = new BigDecimal(37500.0);
	private static final BigDecimal BATAS_NORMAL = new BigDecimal(65000.0);
	
	public static int rateKosan(kosan kosan) {
		if (kosan.getLuas() == 0.0) {
			return -1;
		}
		BigDecimal ratio = kosan.getHarga().divide(new BigDecimal(kosan.getLuas()), RoundingMode.HALF_UP);
		
		if (ratio.compareTo(BATAS_MURAH) < 0) {
			return 0;
		} else if (ratio.compareTo(BATAS_MURAH) >= 0 && ratio.compareTo(BATAS_NORMAL) < 0) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public static double calculateAverageRating(List<kosan> kosans) {
		if (kosans.isEmpty()) {
			throw new RuntimeException("Tidak bisa menghitung rate rata-rata untuk list yang kosong");
		}
		int sumRatings = 0;
		for (kosan kosan : kosans) {
			sumRatings += rateKosan(kosan);
		}
		return sumRatings * 1.0 / kosans.size();	
	}
}
