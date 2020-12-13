package com.example.projekti;

/**
 * Luokka sisältää laskurin ja sen arvon muokkaamiseen tarkoitetut metodit.
 * @author Jouni Reinikainen
 */
public class Counter {
    private int laskuri;


    /**
     * Luo uuden laskurin, jollain annetulla alkuarvolla.
     * @param laskuri, uusi annettu alkuarvo
     */
    public Counter(int laskuri){
        this.laskuri=laskuri;
    }

    /**
     * Kasvattaa laskurin summaa yhdellä.
     */
    public void plus(){
        this.laskuri++;
    }

    /**
     * Vähentää laskurin summaa yhedelllä.
     */
    public void minus(){
        if (laskuri>0) {
            this.laskuri--;
        }

    }

    /**
     * Asettaa laskurin takaisin nollaan.
     */
    public void reset(){
        this.laskuri=0;
    }

    /**
     * Palautttaa laskurin arvon.
     * @return int laskuri, palauttaa laskurin arvon
     */
    public int getLaskuri(){
        return this.laskuri;
    }


    /**
     * Asettaa laskurille uuden arvon.
     * @param uusiArvo uusi arvo.
     */
    public void setLaskuri(int uusiArvo){ this.laskuri=uusiArvo;}
}
