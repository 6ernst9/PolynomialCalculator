package ro.tuc.model;

public class Monom {
    private final float coefficient;
    private final int exponent;

    public Monom(float coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }
    @Override
    public String toString() {
        String exponent ="";
        if(this.exponent!=0 && this.exponent != 1){
            exponent=String.valueOf(getExponent());
        }

        return (coefficient % 1 == 0 ? Integer.toString((int)coefficient ): coefficient)+(getExponent() == 0 ? "" : "x" )
                + (getExponent() !=0 && getExponent() != 1 ? "^" : "")
                + exponent;
    }
}
