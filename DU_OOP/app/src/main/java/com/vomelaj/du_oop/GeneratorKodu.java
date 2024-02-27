package com.vomelaj.du_oop;

import java.util.Random;

public class GeneratorKodu extends Generator {
    private Integer pocet;
    private String oddelovac;
    public GeneratorKodu(int delka, int pocet) {
        super(delka, 6);
        oddelovac = "   ";
        this.pocet = pocet;
    }

    public GeneratorKodu(int delka, int pocet, String oddelovac) {
        super(delka, 6);
        this.pocet = pocet;
        this.oddelovac = oddelovac;
    }

    public Integer getPocet() {
        return pocet;
    }

    public void setPocet(Integer pocet) {
        this.pocet = pocet;
    }

    public String getOddelovac() {
        return oddelovac;
    }

    public void setOddelovac(String oddelovac) {
        this.oddelovac = oddelovac;
    }

    private Random r = new Random();
    @Override
    public String generuj() {
        String retezec = "";
        String kody = "";
        Boolean omezeniBool[] = omezeniDekoder();
        String znaky = "lI|0oO";
        int i = 0;
        while (retezec.length() < delka&&i<pocet) {
            char znak = (char) (r.nextInt('~' - '!'+1) + '!');
            //System.out.println(znak);
            Boolean podminka = (((Character.isLowerCase(znak) && omezeniBool[0]) ||
                    (Character.isUpperCase(znak) && omezeniBool[1]) ||
                    (Character.isDigit(znak) && omezeniBool[2])) ||
                    (omezeniBool[3] && !Character.isLowerCase(znak)
                            && !Character.isUpperCase(znak) && !Character.isDigit(znak)));
            if (podminka) {
                retezec += znak;
            }
            if(retezec.length() == delka){
                if(kody!= "")
                    kody+=oddelovac;
                kody += retezec;
                retezec = "";
                i++;
            }
        }

        return kody;
    }
}
