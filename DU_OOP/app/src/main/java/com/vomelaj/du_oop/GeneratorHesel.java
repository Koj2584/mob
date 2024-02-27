package com.vomelaj.du_oop;

import java.util.Random;

public class GeneratorHesel extends Generator{
    Boolean nezamenitelneZnaky;
    Boolean obsahujeZnak;
    Integer pocetHesel;

    public GeneratorHesel(Integer delka)  {
        super(delka, 14);
        pocetHesel = 1;
        nezamenitelneZnaky = false;
        obsahujeZnak = false;
    }

    public GeneratorHesel(Integer delka, Integer pocetHesel)  {
        super(delka, 14);
        setPocetHesel(pocetHesel);
        nezamenitelneZnaky = false;
        obsahujeZnak = false;
    }

    public Boolean getNezamenitelneZnaky() {
        return nezamenitelneZnaky;
    }

    public void setNezamenitelneZnaky(Boolean nezamenitelneZnaky) {
        this.nezamenitelneZnaky = nezamenitelneZnaky;
    }

    public Boolean getObsahujeZnak() {
        return obsahujeZnak;
    }

    public void setObsahujeZnak(Boolean obsahujeZnak) {
        this.obsahujeZnak = obsahujeZnak;
    }

    public Integer getPocetHesel() {
        return pocetHesel;
    }

    public void setPocetHesel(Integer pocetHesel) {
        if(pocetHesel>0)
            this.pocetHesel = pocetHesel;
        else
            this.pocetHesel = 1;
    }
    private Random r = new Random();
    @Override
    public String generuj() {
        if(obsahujeZnak)
            omezeni = 15;
        else
            omezeni = 14;
        String retezec = "";
        String hesla = "";
        Boolean omezeniBool[] = omezeniDekoder();
        String znaky = "lI|0oO";
		int i = 0;
        while (retezec.length() < delka&&i<pocetHesel) {
            char znak = (char) (r.nextInt('~' - '!'+1) + '!');
            //System.out.println(znak);
            Boolean podminka = (((Character.isLowerCase(znak) && omezeniBool[0]) ||
                    (Character.isUpperCase(znak) && omezeniBool[1]) ||
                    (Character.isDigit(znak) && omezeniBool[2])) ||
                    (omezeniBool[3] && !Character.isLowerCase(znak)
                            && !Character.isUpperCase(znak) && !Character.isDigit(znak)))
                    && (!nezamenitelneZnaky || !znaky.contains(znak + ""));
            if (podminka) {
                retezec += znak;
            }
			if(retezec.length() == delka){
                if(hesla!= "")
                    hesla+="   ";
				hesla += retezec;
				retezec = "";
			i++;
			}
        }
        
        return hesla;
    }

    @Override
    public String toString() {
        return "GeneratorHesel{" +
                "delka=" + delka +
                ", omezeni=" + omezeni +
                ", nezamenitelneZnaky=" + nezamenitelneZnaky +
                ", obsahujeZnak=" + obsahujeZnak +
                ", pocetHesel=" + pocetHesel +
                '}';
    }
}
