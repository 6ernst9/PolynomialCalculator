package ro.tuc.operations;

import ro.tuc.model.Monom;
import ro.tuc.model.Polynom;

import java.util.*;

public class Operations {
    public static Polynom add(Polynom firstPolynom,Polynom secondPolynom){
        ArrayList<Monom> result = new ArrayList<Monom>();
        int i = 0;
        int j = 0;
        while (i <= firstPolynom.getGrad() && j <= secondPolynom.getGrad()) {
            if (i > j){
                if(firstPolynom.getCoefficient(i)!=null) result.add(new Monom(firstPolynom.getCoefficient(i), i));
                i++;
            } else if (j > i){
                if(secondPolynom.getCoefficient(j)!=null) result.add(new Monom(secondPolynom.getCoefficient(j), j));
                i++;
            } else {
                float firstCoefficient = firstPolynom.getCoefficient(i)!=null ? firstPolynom.getCoefficient(i) : 0;
                float secondCoefficient = secondPolynom.getCoefficient(j)!=null ? secondPolynom.getCoefficient(j) : 0;
                float sumOfCoefficients = firstCoefficient + secondCoefficient;
                if(sumOfCoefficients!=0) result.add(new Monom(sumOfCoefficients, i));
                i++;
                j++;
            }
        }
        while (i <= firstPolynom.getGrad()) {
            if(firstPolynom.getCoefficient(i)!=null) result.add(new Monom(firstPolynom.getCoefficient(i), i));
            i++;
        }
        while (j <= secondPolynom.getGrad()) {
            if(secondPolynom.getCoefficient(j)!=null) result.add(new Monom(secondPolynom.getCoefficient(j), j));
            j++;
        }
        return new Polynom(result);
    }

    public static Polynom sub(Polynom firstPolynom, Polynom  secondPolynom){
        ArrayList<Monom> result = new ArrayList<Monom>();
        int i = 0;
        int j = 0;
        while (i <= firstPolynom.getGrad() && j <= secondPolynom.getGrad()) {
            if (i > j){
                if(firstPolynom.getCoefficient(i)!=null) result.add(new Monom(firstPolynom.getCoefficient(i), i));
                i++;
            } else if (j > i){
                if(secondPolynom.getCoefficient(j)!=null) result.add(new Monom(secondPolynom.getCoefficient(j), j));
                i++;
            } else {
                float firstCoefficient = firstPolynom.getCoefficient(i)!=null ? firstPolynom.getCoefficient(i) : 0;
                float secondCoefficient = secondPolynom.getCoefficient(j)!=null ? secondPolynom.getCoefficient(j) : 0;
                float sumOfCoefficients = firstCoefficient - secondCoefficient;
                if(sumOfCoefficients!=0) result.add(new Monom(sumOfCoefficients, i));
                i++;
                j++;
            }
        }
        while (i <= firstPolynom.getGrad()) {
            if(firstPolynom.getCoefficient(i)!=null) result.add(new Monom(firstPolynom.getCoefficient(i), i));
            i++;
        }
        while (j <= secondPolynom.getGrad()) {
            if(secondPolynom.getCoefficient(j)!=null) result.add(new Monom(secondPolynom.getCoefficient(j), j));
            j++;
        }
        return new Polynom(result);
    }

    public static Polynom mul(Polynom firstPolynom, Polynom secondPolynom) {
        ArrayList<Monom> productPoly = new ArrayList<Monom>();

        for (int i=0; i<=firstPolynom.getGrad(); i++) {
            for (int j=0; j<=secondPolynom.getGrad(); j++) {
                float firstCoefficient = firstPolynom.getCoefficient(i) != null ? firstPolynom.getCoefficient(i) : 0f;
                float secondCoefficient = secondPolynom.getCoefficient(j) != null ? secondPolynom.getCoefficient(j) : 0f;

                float prodCoefficient = firstCoefficient * secondCoefficient;
                int prodExponent = i + j;
                productPoly.add(new Monom(prodCoefficient, prodExponent));
            }
        }

        combineTerms(productPoly);
        return new Polynom(productPoly);
    }

    public static Polynom derivative(Polynom polynom){
        ArrayList<Monom> result = new ArrayList<Monom>();

        for(int i=0; i<= polynom.getGrad(); i++){
            if(polynom.getCoefficient(i)!=null){
                Monom monom = new Monom(polynom.getCoefficient(i), i);
                result.add(new Monom(monom.getCoefficient()* monom.getExponent(), monom.getExponent()-1));
            }
        }

        return new Polynom(result);
    }

    public static Polynom integral(Polynom polynom){
        ArrayList<Monom> result = new ArrayList<Monom>();
        for(int i=1; i<= polynom.getGrad(); i++){
            if(polynom.getCoefficient(i) != null){
                Monom monom = new Monom(polynom.getCoefficient(i), i);
                result.add(new Monom(1/((monom.getExponent()+1)* monom.getCoefficient()), monom.getExponent()+1));
            }
        }
        return new Polynom(result);
    }

    public static void combineTerms(ArrayList<Monom> polynom) {
        Map<Integer, Float> map = new HashMap<Integer,Float>();
        for (Monom mono : polynom) {
            int exponent = mono.getExponent();
            float coefficient = mono.getCoefficient();
            if (map.containsKey(exponent)) {
                map.put(exponent, map.get(exponent) + coefficient);
            }
            else {
                map.put(exponent, coefficient);
            }
        }

        polynom.clear();

        for (Map.Entry<Integer, Float> entry : map.entrySet()) {
            int exponent = entry.getKey();
            float coefficient = entry.getValue();
            if (coefficient != 0) {
                polynom.add(new Monom(coefficient, exponent));
            }
        }

        Collections.sort(polynom, new Comparator<Monom>() {
            public int compare(Monom monom1, Monom monom2) {
                return monom2.getExponent() - monom1.getExponent();
            }
        });
    }

}
