package ro.tuc.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Polynom {
    private final HashMap<Integer, Float> polynom = new HashMap();
    private int grad=-1;
    public Polynom(ArrayList<Monom> monoms){
        createHashMap(monoms);
    }
    private void createHashMap(ArrayList<Monom> monoms){
        for(Monom monom: monoms){
            polynom.put(monom.getExponent(), monom.getCoefficient());
            if(monom.getExponent() > grad){
                grad = monom.getExponent();
            }
        }
    }

    public Float getCoefficient(Integer exponent){
        return polynom.get(exponent);
    }

    @Override
    public String toString() {
        int isFirst = 0;
        String toReturn = "";
        for(int i=getGrad();i>=0;i--){
            if(getCoefficient(i)!=null){
                isFirst++;
                Monom monom = new Monom(getCoefficient(i), i);
                if(isFirst!=1) toReturn+="+";

                toReturn+= monom.toString();
            }
        }
        return toReturn;
    }

    public int getGrad() {
        return grad;
    }
}
