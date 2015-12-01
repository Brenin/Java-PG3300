package nr1;

public class rnMain {
	public static void main(String[] args){
		
		RationalNumber rn = new RationalNumber();
		
		//RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
		RationalNumber rn14 = new RationalNumber(-1, 2);
		
		RationalNumber rn15 = new RationalNumber(5, 10);
		
		int a = rn15.gcd(10, 5);
		
		System.out.println("lolz " + a);
		
		System.out.println("lol " + rn14.toString());
		
		System.out.println(rn.toString());
		
		RationalNumber rn3 = rn15.add(rn2);
		
		System.out.println(rn3);
		
		RationalNumber rn4 = rn15.subtract(rn2);
		
		System.out.println(rn4);
		
		RationalNumber rn5 = rn15.multiply(rn2);
		
		System.out.println(rn5);
		
		RationalNumber rn6 = rn15.divide(rn2);
		
		System.out.println(rn6);
		
	}
}
