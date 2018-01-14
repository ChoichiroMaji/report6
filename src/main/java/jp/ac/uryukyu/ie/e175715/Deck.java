package jp.ac.uryukyu.ie.e175715;
import java.util.*;
import java.util.Vector;

public class Deck {
    Random rnd;
    int cardNum;
    int nextItem;
    Vector Cards;
    Vector shuffledCards;

    public Deck(){
        Cards = new Vector();
        shuffledCards = new Vector();
        rnd = new Random();
        cardNum = 52;
        nextItem = 0;
    }
    public void resetDeck(){
        Heart();
        Spade();
        Club();
        Diamond();
    }
    int getDeckSize(){
        int size = 0;
        size = shuffledCards.size();
        return size;
    }
    Card getNextCard(){
        Card card = null;
        Object obj = shuffledCards.get(nextItem);
        String str = obj.toString();
        int i = str.indexOf(",");
        String S1 = str.substring(0,1);
        String S2 = str.substring(i+1, str.length() - 1);
        card = new Card(S1, S2);
        ++nextItem;
        return card;
    }
    public void shuffleDeck(){
        for(int i=0; i<52; i++){
            shuffledCards.insertElementAt(Cards.get(i), i);
        }
        for(int i=0; i<52; i++){
            int a = rnd.nextInt();
            if(a < 0){
                a = -a;
            }
            a = a % 52;
            int b = rnd.nextInt();
            if(b < 0){
                b = -b;
            }
            b = b % 52;

            Object temp = shuffledCards.get(a);
            Object temp2 = shuffledCards.get(b);
            shuffledCards.insertElementAt(temp2,a);
            shuffledCards.remove(a);
            shuffledCards.insertElementAt(temp,b);
        }
    }
    public void Heart(){
        for(int i=1; i<=13; i++) {
            String s = Integer.toString(i);
            Cards.addElement(s + "　ハート");
        }
    }
    public void Spade(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s + " スペード");
        }
    }
    public void Club(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s + " クラブ️");
        }
    }
    public void Diamond(){
        for(int i=1; i<=13; i++) {
            String s = Integer.toString(i);
            Cards.addElement(s + "　ダイヤ︎");
        }
    }
}

class Ace1{
    public static void main(String args[]){
        Deck D = new Deck();
        String[] s = new String[100];
        int i = 0;
        D.resetDeck();
        String str = (String)(Object)D.Cards.get(0);
        i = str.indexOf(",");
        String S1 = str.substring(0,1);
        String S2 = str.substring(i+1, str.length() - 1);
        System.out.println(S1);
        System.out.println(S2);
        String Pi = null;
        if(S1.equals("1")){
            Pi = "Ace";
        }
        System.out.println(Pi);
    }
}

class Ace2{
    public static void main(String args[]){
        Card C = new Card("1", "ハート");
        System.out.println(C.getPicture());
        System.out.println(C.getSuit());
    }
}
