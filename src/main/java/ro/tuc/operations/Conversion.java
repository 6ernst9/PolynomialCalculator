package ro.tuc.operations;

import ro.tuc.model.Monom;
import ro.tuc.model.Polynom;

import java.util.ArrayList;
import java.util.Arrays;

public class Conversion {
    public static Polynom convertFromString(String input){
        String[] terms = input.split("(?=[-+])|\\s+");
        System.out.println(Arrays.toString(terms));
        ArrayList<Monom> monoms = new ArrayList<Monom>();

        for (String term : terms) {
            Monom monom;
            if (term.contains("x^")) {
                String[] parts = term.split("\\*x\\^");
                monom = new Monom(Float.parseFloat(parts[0].trim()), Integer.parseInt(parts[1].trim()));

            }
            else if (term.contains("x")) {
                monom = new Monom(Float.parseFloat(term.replace("*x", "").trim()), 1);
            }
            else {
                monom = new Monom( Float.parseFloat(term.trim()), 0);
            }
            monoms.add(monom);
        }
        return new Polynom(monoms);
    }
}
