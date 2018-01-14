package jp.ac.uryukyu.ie.e175715;
import java.util.*;

public class Deck {
    /*
    *山札を表すクラス
     */
    Random rnd;
    private int cardNum;
    private int nextItem;
    Vector Cards;
    private Vector shuffledCards;


    public Deck(){
        Cards = new Vector();       //シャッフルする前のカードを保存
        shuffledCards = new Vector();   //シャッフル後のカードを保存
        rnd = new Random();
        cardNum = 52;               //配る前のカードの枚数
        nextItem = 0;               //どのカードを配ったか記憶
    }
    public void resetDeck(){        //山札の初期化
        Heart();
        Spade();
        Club();
        Diamond();
    }
    int getDeckSize(){              //残っているカードの枚数を数える
        int size = 0;
        size = shuffledCards.size();
        return size;
    }
    Card getNextCard(){             //次のカードを配る
        Card card = null;
        Object obj = shuffledCards.get(nextItem);
        String str = obj.toString();
        int i = str.indexOf(",");
        String S1 = str.substring(0,1);
        String S2 = str.substring(i+1, str.length());
        card = new Card(S1, S2);
        ++nextItem;
        return card;
    }
    public void shuffleDeck(){      //カードのシャッフル
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
    private void Heart(){       //ハートスートの生成
        for(int i=1; i<=13; i++) {
            String s = Integer.toString(i);
            Cards.addElement(s + "　❤︎");
        }
    }
    private void Spade(){       //スペードスートの生成
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s + " ♠︎");
        }
    }
    private void Club(){
        for(int i=1; i<=13; i++){   //クラブスートの生成
            String s = Integer.toString(i);
            Cards.addElement(s + " ♣︎");
        }
    }
    private void Diamond(){     //ダイヤスートの生成
        for(int i=1; i<=13; i++) {
            String s = Integer.toString(i);
            Cards.addElement(s + "　♦︎");
        }
    }
}