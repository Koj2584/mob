package com.vomelaj.du_oop;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
    protected Integer delka;
    protected Integer omezeni;

    public Generator(Integer delka){
        this.delka = delka;
        omezeni = 15;
    }

    public Generator(Integer delka, Integer omezeni) {
        this.delka = delka;
        setOmezeni(omezeni);
    }

    public Integer getDelka() {
        return delka;
    }

    public void setDelka(Integer delka) {
        this.delka = delka;
    }

    public Integer getOmezeni() {
        return omezeni;
    }

    public void setOmezeni(Integer omezeni) {
        if(omezeni<1)
            omezeni = 1;
        if(omezeni>15)
            omezeni = 15;
        this.omezeni = omezeni;
    }

    private Random r = new Random();
    public String generuj(){
        String retezec = "";
        Boolean omezeniBool[] = omezeniDekoder();
        while(retezec.length() < delka){
            char znak = (char)(r.nextInt('~'-' '+1)+' ');
            if(((Character.isLowerCase(znak)&&omezeniBool[0])||
                    (Character.isUpperCase(znak)&&omezeniBool[1])||
                    (Character.isDigit(znak)&&omezeniBool[2]))||
                    (omezeniBool[3]&&!Character.isLowerCase(znak)
                    &&!Character.isUpperCase(znak)&&!Character.isDigit(znak))){
                retezec+=znak;
            }
        }
        return retezec;
    }

    protected Boolean[] omezeniDekoder(){
        Boolean omezeniBool[] = new Boolean[4];
        String omezeni2 = decToBin(omezeni);
        for(int i = 0;i<4;i++) {
            if (omezeni2.charAt(i) == '1')
                omezeniBool[i] = true;
            else
                omezeniBool[i] = false;
        }
        return omezeniBool;
    }

    String decToBin(int dec)
    {
        String s = "";
        while (dec > 0)
        {
            s = (dec % 2) + s;
            dec /= 2;
        }
        while(s.length()<4)
            s = "0"+s;
        return s;
    }


    @Override
    public String toString() {
        return "Generator{" +
                "delka=" + delka +
                ", omezeni=" + omezeni +
                '}';
    }
}
