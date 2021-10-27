public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }

    // *****
    // You should go ahead and copy and paste the methods
    // from last class into here:
    // *****
    public static Rational add(Rational r, Rational s) {
        int num1 = (r.numerator);
        int den2 = (r.denominator);
        int num3 = (s.numerator);
        int den4 = (s.denominator);
        int realnum1 = den4 * num1;
        int realnum2 = den2 * num3;
        int newnum = realnum1 + realnum2;
        int realden = den4 * den2;
        Rational t = new Rational(newnum, realden);
        Rational real = (simplify(t));
        return real;

    }

    // This method takes two Rationals, subtracts thems up,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int num1 = (r.numerator);
        int den2 = (r.denominator);
        int num3 = (s.numerator);
        int den4 = (s.denominator);
        int realnum1 = den4 * num1;
        int realnum2 = den2 * num3;
        int newnum = realnum1 - realnum2;
        int realden = den4 * den2;
        Rational t = new Rational(newnum, realden);
        Rational real = (simplify(t));
        return real;
    }

    public static Rational multiply(Rational r, Rational s) {
        int num1 = (r.numerator);
        int den2 = (r.denominator);
        int num3 = (s.numerator);
        int den4 = (s.denominator);
        int realnum = num1 * num3;
        int realden = den2 * den4;
        Rational t = new Rational(realnum, realden);
        Rational real = (simplify(t));
        return real;

    }

    public static Rational divide(Rational r, Rational s) {
        int num1 = (r.numerator);
        int den2 = (r.denominator);
        int num3 = (s.numerator);
        int den4 = (s.denominator);
        int realnum = num1 * den4;
        int realden = den2 * num3;
        Rational t = new Rational(realnum, realden);
        Rational real = (simplify(t));
        return real;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        for(int i = a; i > 0; i--) {
            if(a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int gcf = greatestCommonFactor(r.numerator, r.denominator);
        int newnum = r.numerator / gcf;
        int newden = r.denominator / gcf;
        Rational t = new Rational(newnum, newden);
        return t;
    }












    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {
       return (this.numerator >= this.denominator);
    }

    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        if (greatestCommonFactor(this.numerator, this.denominator) != 1) {
            return false;
        }
        return true;
    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        double num = (double) (this.numerator);
        double div = (num / this.denominator);
        return div;
    }

    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {
        return null;
    }

    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        if (x == this.numerator || x == this.denominator) {
            return true;
        }
        return false;
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator/gcf;
        int denom = this.denominator/gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator/gcf;
        this.denominator = this.denominator/gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b){
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        this.numerator = this.numerator + this.denominator;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        this.numerator = this.numerator - this.denominator;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        if(newDenominator > this.denominator) {
            int mult = newDenominator / this.denominator;
            this.numerator = this.numerator * mult;
            this.denominator = this.denominator * mult;
        }
        else if(newDenominator < this.denominator) {
            int divizzy = this.denominator / newDenominator;
            this.numerator = this.numerator / divizzy;
            this.denominator = this.denominator / divizzy;
        }
    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() {
        if(this.numerator < 0 || this.denominator < 0) {
            return true;
        }
        return false;
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        this.numerator = this.denominator;
        this.denominator = this.numerator;
        return null;
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        if (this.numerator == other.numerator && this.denominator == other.denominator) {
            return true;
        }
        return false;
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    public void round() {
        // YOUR CODE HERE
    }
}













