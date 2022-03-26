package id.co.kosan;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KosanRatetTest {

	@ParameterizedTest
	@CsvSource(value = {"72.0, 250000.0, 0", "48.0, 350000.0, 1", "30.0, 600000.0, 2"})
	void testRatingCorrect(Double luas, Double harga, int rating) {
	
		// harus menggembalikan rating yang benar
		
		// yang di berikan
		kosan kost1 = new kosan(luas, new BigDecimal(harga));
		int expected = rating;
		
		// aktual (hasil run)
		int aktual = KosanRater.rateKosan(kost1);
		
		// bandingkan
		assertEquals(expected, aktual);		
	}
	
	@Test
	void testRatingIncorrect() {
	
		//Harus mengembalikan  nilai error dengan masukan kosan yang salah
		
		// yang di berikan
		kosan kost1 = new kosan(0.0, new BigDecimal(350000.0));
		int expected = -1;
		
		// aktual (hasil run)
		int aktual = KosanRater.rateKosan(kost1);
		
		// bandingkan
		assertEquals(expected, aktual);		
	}
	
	@Test //
	void testAverageNotEmptyList() {
	
		//Harus mengembalikan  menghitung rata-rata rating pada list
		
		// yang di berikan
		List<kosan> kosts = new ArrayList<>();
		kosts.add(new kosan(72.0, new BigDecimal(250000.0)));
		kosts.add(new kosan(48.0, new BigDecimal(350000.0)));
		kosts.add(new kosan(30.0, new BigDecimal(600000.0)));

		double expected = 1.0;
		
		// aktual (hasil run)
		double aktual = KosanRater.calculateAverageRating(kosts);
		
		// bandingkan
		assertEquals(expected, aktual);		
	}
	
	@Test
	void testAverageEmptyList() {
	
		// yang di berikan
		List<kosan> kosts = new ArrayList<>();
		
		// aktual (hasil run)
		Executable executable = () -> KosanRater.calculateAverageRating(kosts);
		
		// bandingkan
		assertThrows(RuntimeException.class, executable);
	}

}
