package id.co.kosan;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;



class RandomKosanGeneratorTest {

private static final double MAX_MULTIPLIER = 4.0;
	
    /*https://junit.org/junit5/docs/5.4.1/api/org/junit/jupiter/api/Nested.html
     *digunakan untuk memberi sinyal bahwa kelas yg ditanda ini adalah kelas uji non-statis bersarang
    */
	@Nested 
	class GeneratorDefaultParameterTests {
		
		private RandomKosanGenerator generator;
		
		/*https://junit.org/junit5/docs/5.4.1/api/org/junit/jupiter/api/BeforeEach.html
		 * @BeforeEach digunakan untuk memberi sinyal bahwa metode beranotasi 
		 * harus dijalankan sebelum setiap metode 
		 * @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, dan @TestTemplate 
		 * di kelas pengujian saat ini.
		*/
		@BeforeEach
		void setup() {
			this.generator = new RandomKosanGenerator();
		}
		
		
		@RepeatedTest(30) //Test akan diulang sebanyak 30 kali
		void generateCorrectKosanDefault() {
			
			// Test harus membuat Kosan yang benar dengan default Minimal Luas dan Minimal Harga
			
			// yang di berikan
			double minLuas = 10.0;
			double maxLuas = minLuas * MAX_MULTIPLIER;
			BigDecimal minHargaPerMeterPersegi = new BigDecimal(300000.0);
			BigDecimal maxHargaPerMeterPersegi = minHargaPerMeterPersegi.multiply(new BigDecimal(MAX_MULTIPLIER));
			
			// aktual (hasil run)
			Kosan kost = generator.generate();
			
			// bandingkan
			BigDecimal maxHargaKosan = new BigDecimal(kost.getLuas()).multiply(maxHargaPerMeterPersegi);
			BigDecimal minHargaKosan = new BigDecimal(kost.getLuas()).multiply(minHargaPerMeterPersegi);
			assertAll(
				() -> assertTrue(kost.getLuas() >= minLuas),
				() -> assertTrue(kost.getLuas() <= maxLuas),
				() -> assertTrue(kost.getHarga().compareTo(minHargaKosan) >= 0),
				() -> assertTrue(kost.getHarga().compareTo(maxHargaKosan) <= 0)
			);
		}
	}
	
	
	/*https://junit.org/junit5/docs/5.4.1/api/org/junit/jupiter/api/Nested.html
     *digunakan untuk memberi sinyal bahwa kelas yg ditanda ini adalah kelas uji non-statis bersarang
    */
	@Nested 
	class GeneratorCustomParameterTests {
		
		private RandomKosanGenerator generator;
		private double minLuas = 150.0;
		private BigDecimal minHargaPerMeterPersegi = new BigDecimal(3585000.0);
		
		/*https://junit.org/junit5/docs/5.4.1/api/org/junit/jupiter/api/BeforeEach.html
		 * @BeforeEach digunakan untuk memberi sinyal bahwa metode beranotasi 
		 * harus dijalankan sebelum setiap metode 
		 * @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, dan @TestTemplate 
		 * di kelas pengujian saat ini.
		*/
		@BeforeEach
		void setup() {
			this.generator = new RandomKosanGenerator(minLuas, minHargaPerMeterPersegi);
		}
		
		
		@RepeatedTest(30) //Test akan diulang sebanyak 30 kali
		void generateCorrectKosanCustom() {
			
			// Test harus membuat Kosan yang benar dengan default Minimal Luas dan Minimal Harga
			
			// yang di berikan
			double minLuas = this.minLuas;
			double maxLuas = minLuas * MAX_MULTIPLIER;
			BigDecimal minHargaPerMeterPersegi = this.minHargaPerMeterPersegi;
			BigDecimal maxHargaPerMeterPersegi = minHargaPerMeterPersegi.multiply(new BigDecimal(MAX_MULTIPLIER));
			
			// aktual (hasil run)
			Kosan kost = generator.generate();
			
			// bandingkan
			BigDecimal maxHargaKosan = new BigDecimal(kost.getLuas()).multiply(maxHargaPerMeterPersegi);
			BigDecimal minHargaKosan = new BigDecimal(kost.getLuas()).multiply(minHargaPerMeterPersegi);
			assertAll(
				() -> assertTrue(kost.getLuas() >= minLuas),
				() -> assertTrue(kost.getLuas() <= maxLuas),
				() -> assertTrue(kost.getHarga().compareTo(minHargaKosan) >= 0),
				() -> assertTrue(kost.getHarga().compareTo(maxHargaKosan) <= 0)
			);
		}
	}
	
	
}
