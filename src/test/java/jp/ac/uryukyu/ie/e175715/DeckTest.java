package jp.ac.uryukyu.ie.e175715;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {
    @Test
    //数字を異なる文字列に置き換えることができているかのテスト
    public void getNextCard() throws Exception {
        Deck D = new Deck();
        String[]  s = new String[100];
        int i = 0;
        D.resetDeck();
        String str = (String)(Object)D.Cards.get(0);
        i = str.indexOf(",");
        String S1 = str.substring(0,i);
        String S2 = str.substring(i+1,str.length());
        String Pi = null;
        if(S1.equals("1"))  Pi = "Ace";
        assertEquals(Pi,"Ace");
    }
}