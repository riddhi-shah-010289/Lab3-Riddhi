import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
    	System.out.println("\nTest for Equality....");
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
    	System.out.println("\nTest for InEquality1....");
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	System.out.println("\nTest Accessors....");
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
    	System.out.println("\nTest for Root Computation....");
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
       //     System.out.println("SQUARE ROOT"+sRoot.toString());
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    // Test Constructor1 - Rational(num,den)
    public void testConstructor1(){
    	System.out.println("\nTest Constructor1....");
    	Rational c = new Rational(12,16);
    	assertEquals(c.numerator(),3);
    	assertEquals(c.denominator(),4);
    }
    
    //Test gcd function
    public void testgcd(){
    	System.out.println("\nTest gcd computation....");
    	Rational g = new Rational(12,16);
    	assertEquals(g.numerator()*4,12);
    	assertEquals(g.denominator()*4,16);
    }
    
    //Test for addition of rationals
    public void testPlus(){
    	System.out.println("\nTest Addition....");
    	Rational p1 = new Rational(1,3);
    	Rational p2 = new Rational(1,6);
    	Rational sum = p1.plus(p2);
    	assertEquals(sum,new Rational(1,2));
    }
    
    //Test for subtraction of rationals
    public void testMinus(){
    	System.out.println("\nTest Subtraction....");
    	Rational p1 = new Rational(3,4);
    	Rational p2 = new Rational(1,4);
    	Rational sub = p1.minus(p2);
    	assertEquals(sub,new Rational(1,2));
    }
    
  //Test for multiplication of rationals
    public void testTimes(){
    	System.out.println("\nTest multiplication....");
    	Rational p1 = new Rational(2,3);
    	Rational p2 = new Rational(2,5);
    	Rational prod = p1.times(p2);
    	assertEquals(prod,new Rational(4,15));
    	
    }
    
    //Test for division of rationals
    public void testDivides(){
    	System.out.println("\nTest division...");
    	Rational p1 = new Rational(2,3);
    	Rational p2 = new Rational(1,4);
    	Rational div = p1.divides(p2);
    	assertEquals(div,new Rational(8,3));
    	
    }
    

    // Test setTolerance and getTolerance
    public void testSetTolerance(){
    	System.out.println("\nTest get/set tolerance....");
    	Rational tol = new Rational(1,500);
    	Rational.setTolerance(tol);
    	assertEquals(Rational.getTolerance(),tol);
    }
    
    //Test isLessThan
    public void testIsLessThan(){
    	System.out.println("\nTest isLessThan....");
    	Rational r1 = new Rational(3,8);
    	Rational r2 = new Rational(5,12);
    	assertEquals(r1.isLessThan(r2), true);
    }
    
    //Test absolute value
    public void testAbs(){
    	System.out.println("\nTest absolute value....");
    	Rational r1 = new Rational(-4,5);
    	assertEquals(r1.abs(),new Rational(4,5));
    }

    // Test toString
    public void testToString(){
    	System.out.println("\nTest toString....");
    	Rational r = new Rational(4,5);
    	assertEquals(r.toString(), "4/5");
    }
    
    //Test constructor2
    public void testConstructor2(){
    	System.out.println("\nTest Constructor2");
    	Rational r1 = new Rational(1,3);
    	Rational r2 = new Rational(r1);
    	assertEquals(r2.numerator(),1);
    	assertEquals(r2.denominator(),3);
    }
    
    //Test for denominator not equal to 0
    public void testDenominator(){
    	System.out.println("\nTest for denominator not equal to 0");
    	Rational r = new Rational(1,0);
    	assertTrue("Denominator cannot be equal to 0",r.denominator()!=0);
    }
    
    // Test for nonequality2
    public void testInEquality1() {
    	System.out.println("\nTest for InEquality2....");
        assertFalse(new Rational(2,3).equals(null));
    }
    
 // Test for nonequality3
    public void testInEquality2() {
    	System.out.println("\nTest for InEquality3....");
        assertFalse(new Rational(2,3).equals(new Integer(2)));
    }
    
    //Test lcm
    public void testlcm(){
    	System.out.println("\nTest lcm....");
    	Rational p1 = new Rational(1,-3);
    	Rational p2 = new Rational(1,-6);
    	Rational sum = p1.plus(p2);
    	assertEquals(sum,new Rational(-1,2));
    }
    
    //test for upperbound - root computation
    public void testRoot_upperbound() {
    	System.out.println("\nTest for Root Computation: upperbound check ....");
        Rational s = new Rational( 46341, 1 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
            assert false;
        } catch (IllegalArgumentToSquareRootException e) {
            assert true;
        	//e.printStackTrace();
        }
        //assertTrue(e instanceof IllegalArgumentToSquareRootException );
    }
    
    //test for lowerbound - root computation
    public void testRoot_lowerbound() {
    	System.out.println("\nTest for Root Computation: lowerbound check ....");
        Rational s = new Rational( -1, 1 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
            assert false;
        } catch (IllegalArgumentToSquareRootException e) {
            assert true;
        	//e.printStackTrace();
        }
        //assertTrue(e instanceof IllegalArgumentToSquareRootException );
    }
    
    //root of 9/16
    public void testRootcomputation1() {
    	System.out.println("\nTest for Root Computation of 9/16....");
        Rational s = new Rational( 9, 16 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
         //   System.out.println("SQUARE ROOT"+sRoot.toString());
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertEquals("Root Computation Method is incorrect: sqrt(9/16)",sRoot, new Rational(3,4));
    }
    
    //test main
    public void testMain_basic()
    {	System.out.println("\nTesting main");
    	 Rational s = new Rational( 1, 2 );
    	 ByteArrayOutputStream output = new ByteArrayOutputStream();
    	 System.setOut(new PrintStream(output));
    	 Rational.main(new String[]{});
    	 assertTrue(output!=null);
    }
    

    
    //Test for addition of rationals when there is integer overflow
    public void testPlusOverflow_upper(){
    	System.out.println("\nTest Addition Overflow:Upperbound....");
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(2147483647,1);
    	Rational sum = p1.plus(p2);
    	assertFalse("Integer overflow not handled for addtition",new Rational(-2,1).equals(sum));
    }
    
    
  //Test for multiplication of rationals when there is integer overflow
    public void testTimesOverflow(){
    	System.out.println("\nTest Times Overflow....");
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(2,1);
    	Rational prod = p1.times(p2);
    	assertFalse("Integer overflow not handled for multipliation",new Rational(-2,1).equals(prod));
    }
    
  //Test for subtraction of rationals when there is integer overflow
    public void testMinusOverflow(){
    	System.out.println("\nTest Minus Overflow....");
    	Rational p1 = new Rational(3*2147483647,1);
    	Rational p2 = new Rational(2147483647,1);
    	Rational sub = p1.minus(p2);
    	assertFalse("Integer overflow not handled for subtraction",new Rational(-2,1).equals(sub));
    }
    
    //Test for division of rationals when there is integer overflow
    public void testDivideOverflow(){
    	System.out.println("\nTest Divide Overflow....");
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(1,2147483647);
    	Rational div = p1.divides(p2);
    	assertFalse("Integer overflow not handled for division",new Rational(1,1).equals(div));
    }
    
    // Test for setting numerator to an integer overflow value
    public void testNum(){
    	System.out.println("\nTesting numerator ");
    	Rational r = new Rational(2147483647*2,1);
    	assertFalse("Numerator out of range not handled", r.numerator()==-2);
    	
    }
    
    // Test for setting denominator to an integer overflow value
    public void testDen(){
    	System.out.println("\nTesting denominator ");
    	Rational r = new Rational(1,2147483647*2);
    	assertFalse("Denominator out of range not handled", r.denominator()==-2);
    	
    }
    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
