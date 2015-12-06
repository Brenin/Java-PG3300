package nr1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RationalNumberTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void rationalNumber_EmptyConstructor_ReturnDefault() {
		
		RationalNumber rn = new RationalNumber();
		
		assertEquals("0", rn.toString());
		
	}

	@Test
	public void RationalNumber_ConstructorWithPositiveNumbers_ReturnInput() {

		RationalNumber rn = new RationalNumber(1, 2);

		assertEquals("1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_ConstructorWithNegativeNumbers_ConvertToPositive() {

		RationalNumber rn = new RationalNumber(-1, -2);

		assertEquals("1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_ConstructorWithNegativeDenominator_PrefixChangingPlace() {

		RationalNumber rn = new RationalNumber(1, -2);

		assertEquals("-1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_ConstructorWithNegativeNominator_PrefixStaying() {

		RationalNumber rn = new RationalNumber(-1, 2);

		assertEquals("-1/2", rn.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void RationalNumber_testConstructorWithInValidNumbers_ExceptionThrown() {

		@SuppressWarnings("unused")
		RationalNumber rn = new RationalNumber(3, 0);
	}

	@Test
	public void toString_ExpectedOutputAndConvertion() {

		RationalNumber rn = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(2, 1);

		assertEquals("1/2", rn.toString());
		assertEquals("2", rn2.toString());
	}
	
	@Test
	public void getNumerator_ExpectedGet_ReturnNumerator() {

		RationalNumber rn = new RationalNumber(1, 2);
		
		assertEquals(1, rn.getNumerator());
	}
	
	@Test
	public void getDenominator_ExpectedGet_ReturnDenominator() {

		RationalNumber rn = new RationalNumber(1, 2);
		
		assertEquals(2, rn.getDenominator());
	}
	
	@Test
	public void Equals_DifferentButSimilarObjects() {

		RationalNumber rn1 = new RationalNumber(3, 8);
		RationalNumber rn2 = new RationalNumber(3, 8);
		
		RationalNumber rn3 = new RationalNumber(0, 4);
		RationalNumber rn4 = new RationalNumber(0, 2);
		
		assertNotSame(rn1, rn2);
		assertEquals(rn1, rn2);
		assertNotSame(rn3, rn4);
	}
	
	@Test
	public void Equals_TheSameObject_True() {
		
		RationalNumber rn1 = new RationalNumber(3, 8);

		assertSame(rn1, rn1);

	}

	@Test
	public void Add_FractionsWithPositiveNumbers() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.add(rn2);
		
		assertEquals("1", rn3.toString());
	}
	
	@Test
	public void Add_WithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.add(rn2);
		
		assertEquals("2", rn3.toString());
	}

	@Test
	public void Subtract_WithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.subtract(rn2);
		
		assertEquals("0", rn3.toString());
	}
	
	@Test
	public void Subtract_WithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.subtract(rn2);
		
		assertEquals("0", rn3.toString());
	}

	@Test
	public void Multiply_WithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.multiply(rn2);
		
		assertEquals("1/4", rn3.toString());
	}
	
	@Test
	public void Multiply_WithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.multiply(rn2);
		
		assertEquals("1", rn3.toString());
	}

	@Test
	public void Divide_WithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.divide(rn2);
		
		assertEquals("1", rn3.toString());
	}
	
	@Test
	public void Divide_WithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(6, 2);
		RationalNumber rn2 = new RationalNumber(6, 2);
				
		RationalNumber rn3 = rn1.divide(rn2);
		
		assertEquals("1", rn3.toString());
	}

	@Test
	public void Reduce_ShouldFindSmallestCommonNumber() {
		
		RationalNumber rn1 = new RationalNumber(4, 8);
		
		RationalNumber rn2 = rn1.reduce();
		
		assertEquals("1/2", rn2.toString());
	}
	
	@Test
	public void GCD_ReturnOuput() {
		
		RationalNumber rn1 = new RationalNumber(5, 10);
		
		int returnOutput = rn1.gcd(10, 5);
		
		assertEquals(5, returnOutput);
	}
}
