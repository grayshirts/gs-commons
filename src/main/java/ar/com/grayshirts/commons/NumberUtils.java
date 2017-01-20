package ar.com.grayshirts.commons;

import java.math.BigDecimal;

public abstract class NumberUtils {

    /**
     * Does the best possible comparision between two numbers, returning
     * the same result than a {@link Comparable} object does.
     * Numbers cannot be null, but can be different types.
     */
    public static int compareNumbers(Number num1, Number num2) {
        if (num1 == null) throw new NullPointerException("num1 == null");
        if (num2 == null) throw new NullPointerException("num2 == null");
        if (num1 instanceof Comparable && num2 instanceof Comparable) {
            if (num1.getClass().equals(num2.getClass())) {
                return ((Comparable)num1).compareTo(num2);
            }
            BigDecimal b1 = num1 instanceof BigDecimal ? (BigDecimal)num1 : new BigDecimal(num1.toString());
            BigDecimal b2 = num2 instanceof BigDecimal ? (BigDecimal)num2 : new BigDecimal(num2.toString());
            return b1.compareTo(b2);
        }
        throw new ClassCastException("No comparable values " + num1 + " and " + num2);
    }

    /**
     * Does the best possible comparision between two numbers, returning
     * the same result than a <code>#equals()</code> implementations do.
     * Numbers can be different types.
     */
    public static boolean equalNumbers(Number num1, Number num2) {
        if (num1==null) {
            if (num2==null) return true;
            return false;
        }
        if (num2==null) return false;
        return compareNumbers(num1, num2)==0;
    }
}
