/**
 * This is JUnit that tests the or35 method that is available 
 * in MultiplesOfThreeFive class. This contains 22 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase22).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(MultiplesOfThreeFive.or35(3), true);
	}

	@Test
	public void testCase2() {
		assertEquals(MultiplesOfThreeFive.or35(10), true);
	}

	@Test
	public void testCase3() {
		assertEquals(MultiplesOfThreeFive.or35(8), false);
	}

	@Test
	public void testCase4() {
		assertEquals(MultiplesOfThreeFive.or35(15), true);
	}

	@Test
	public void testCase5() {
		assertEquals(MultiplesOfThreeFive.or35(5), true);
	}

	@Test
	public void testCase6() {
		assertEquals(MultiplesOfThreeFive.or35(9), true);
	}

	@Test
	public void testCase7() {
		assertEquals(MultiplesOfThreeFive.or35(4), false);
	}

	@Test
	public void testCase8() {
		assertEquals(MultiplesOfThreeFive.or35(7), false);
	}

	@Test
	public void testCase9() {
		assertEquals(MultiplesOfThreeFive.or35(6), true);
	}

	@Test
	public void testCase10() {
		assertEquals(MultiplesOfThreeFive.or35(17), false);
	}

	@Test
	public void testCase11() {
		assertEquals(MultiplesOfThreeFive.or35(18), true);
	}

	@Test
	public void testCase12() {
		assertEquals(MultiplesOfThreeFive.or35(29), false);
	}

	@Test
	public void testCase13() {
		assertEquals(MultiplesOfThreeFive.or35(20), true);
	}

	@Test
	public void testCase14() {
		assertEquals(MultiplesOfThreeFive.or35(21), true);
	}

	@Test
	public void testCase15() {
		assertEquals(MultiplesOfThreeFive.or35(22), false);
	}

	@Test
	public void testCase16() {
		assertEquals(MultiplesOfThreeFive.or35(45), true);
	}

	@Test
	public void testCase17() {
		assertEquals(MultiplesOfThreeFive.or35(99), true);
	}

	@Test
	public void testCase18() {
		assertEquals(MultiplesOfThreeFive.or35(100), true);
	}

	@Test
	public void testCase19() {
		assertEquals(MultiplesOfThreeFive.or35(101), false);
	}

	@Test
	public void testCase20() {
		assertEquals(MultiplesOfThreeFive.or35(121), false);
	}

	@Test
	public void testCase21() {
		assertEquals(MultiplesOfThreeFive.or35(122), false);
	}

	@Test
	public void testCase22() {
		assertEquals(MultiplesOfThreeFive.or35(123), true);
	}
}