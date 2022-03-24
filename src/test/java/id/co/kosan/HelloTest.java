package id.co.kosan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void test() {
		Hello hello = new Hello();
		String aktual = hello.SayHello();
		assertEquals("Hello", aktual);
		
	}

}
