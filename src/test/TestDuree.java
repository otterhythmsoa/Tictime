package test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Duree;

public class TestDuree {

	private Duree d;
	private Duree d1;
	private Duree resultat;
	
	@BeforeEach
	public void setUp() {
		this.d = new Duree(1,24,12);
		this.d1 = new Duree(0,0,0);
		this.resultat = new Duree(0,0,0);
	}
	
	@AfterEach
	public void tearDown() {
		this.d = null;
		this.d1 = null;
		this.resultat = null;
	}
	
	@Test
	public void test1() {
		d1.setSecondes(40);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(40, d1.getSecondes()),
				() -> assertEquals(new Duree(1,24,52).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test2() {
		d1.setMinutes(30);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(30, d1.getMinutes()),
				() -> assertEquals(new Duree(1,54,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test3() {
		d1.setHeures(30);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(30, d1.getHeures()),
				() -> assertEquals(new Duree(31,24,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test4() {
		d1.setSecondes(50);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(50, d1.getSecondes()),
				() -> assertEquals(new Duree(1,25,02).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test5() {
		d1.setMinutes(40);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(40, d1.getMinutes()),
				() -> assertEquals(new Duree(2,04,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test6() {
		d1.setMinutes(40);
		d1.setSecondes(50);
		resultat = d.addition(d1);
		assertAll(
				() -> assertEquals(50, d1.getSecondes()),
				() -> assertEquals(40, d1.getMinutes()),
				() -> assertEquals(new Duree(2,05,02).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test7() {
		d1.setSecondes(10);
		resultat = d.soustraction(d1);
		assertAll(
				() -> assertEquals(10, d1.getSecondes()),
				() -> assertEquals(new Duree(1,24,02).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test8() {
		d1.setMinutes(20);
		resultat = d.soustraction(d1);
		assertAll(
				() -> assertEquals(20, d1.getMinutes()),
				() -> assertEquals(new Duree(1,04,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test9() {
		d1.setHeures(1);
		resultat = d.soustraction(d1);
		assertAll(
				() -> assertEquals(1, d1.getHeures()),
				() -> assertEquals(new Duree(0,24,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test10() {
		d1.setSecondes(30);
		resultat = d.soustraction(d1);
		assertAll(
				() -> assertEquals(30, d1.getSecondes()),
				() -> assertEquals(new Duree(1,23,42).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test11() {
		d1.setMinutes(30);
		resultat = d.soustraction(d1);
		assertAll(
				() -> assertEquals(30, d1.getMinutes()),
				() -> assertEquals(new Duree(0,54,12).toString(), resultat.toString())
		);
	}
	
	@Test
	public void test12() {
		d1.setHeures(2);
		assertAll(
				() -> assertEquals(2, d1.getHeures()),
				() -> assertThrows(IllegalArgumentException.class, () -> d.soustraction(d1))
		);
	}
	
	@Test
	public void test13() {
		d1.setMinutes(50);
		d.setHeures(0);
		assertAll(
				() -> assertEquals(0, d.getHeures()),
				() -> assertEquals(50, d1.getMinutes()),
				() -> assertThrows(IllegalArgumentException.class, () -> d.soustraction(d1))
		);
	}
	
	@Test
	public void test14() {
		d1.setSecondes(30);
		d.setMinutes(0);
		d.setHeures(0);
		assertAll(
				() -> assertEquals(0, d.getHeures()),
				() -> assertEquals(0, d.getMinutes()),
				() -> assertEquals(30, d1.getSecondes()),
				() -> assertThrows(IllegalArgumentException.class, () -> d.soustraction(d1))
		);
	}
}
