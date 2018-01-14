package jp.ac.uryukyu.ie.e175715;
import java.util.*;
public class Deck{
    /*
     *山札の設定
     */
    Random random;
    private int cardNum;
    private int nextItem;
    Vector Cards;
    private Vector shuffledCards;
    Deck(){
        Cards = new Vector();           //シャッフル前の山札を保存
        shuffledCards = new Vector();   //シャッフル後の山札を保存
        random = new Random();
        cardNum = 52;                   //全カード枚数
        nextItem = 0;
    }
    public void resetDeck(){
        //山札の初期化
        Hearts();
        Spades();
        Clubs();
        Diamonds();

    }
    public Card getNextCard(){
        //次に配られるカードの設定
        Card card = null;
        Object obj =shuffledCards.get(nextItem);
        String str = obj.toString();
        int i = str.indexOf(",");
        String S1 = str.substring(0,i);
        String S2 = str.substring(i+1,str.length());
        card = new Card(S1,S2);
        ++nextItem;
        return card;
    }
    public void shuffleDeck(){
        for(int i=0; i<52; i++){
            shuffledCards.insertElementAt(Cards.get(i),i);
        }

        for(int i=0; i<52; i++){
            int a = random.nextInt();
            if(a <0) a=0-a;
            a = a%52;

            int b = random.nextInt();
            if(b <0) b=0-b;
            b = b%52;


            Object temp = shuffledCards.get(a);    //入れ替え
            Object temp2 = shuffledCards.get(b);
            shuffledCards.remove(a);
            shuffledCards.insertElementAt(temp2,a);
            shuffledCards.remove(b);
            shuffledCards.insertElementAt(temp,b);
        }
    }
    private void Hearts(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",❤︎");
        }
    }
    private void Spades(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",♠︎");
        }
    }
    private void Clubs(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",♣︎");
        }
    }
    private void Diamonds(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",♦︎");
        }
    }
}
