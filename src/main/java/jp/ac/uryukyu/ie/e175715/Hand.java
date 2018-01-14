package jp.ac.uryukyu.ie.e175715;
import java.util.*;
public class Hand {
    /*
     *手札の設定
     */
    private int Value;
    private Vector hand;

    public Hand(){
        hand = new Vector();
        int Value = 0;
    }
    public int getValue(){
        Value = 0;
        Value = bestScore();
        return Value;
    }
    public void addToHand(Card card){
        //ドロー
        hand.addElement(card);
    }
    public void showHand(){
        //手札を出力
        for(int i=0; i<hand.size(); i++){
            Card card = (Card)(Object)hand.get(i);
            System.out.println(card.getPicture() + " " + card.getSuit());
        }
    }
    boolean under(int limit){
        //手札の合計が21を下回る場合
        int point = 0;
        for(int i=0; i<hand.size(); i++){
            Card card = (Card)(Object)hand.get(i);
            point += card.getValue();
        }
        if(point < limit){
            return true;
        }else{
            return false;
        }
    }
    boolean over(){
        //手札の合計が21を上回ってしまった場合
        if(under(22)){
            return true;
        }else{
            return false;
        }
    }
    int bestScore(){
        //今現在の手札の合計
        int point = 0;
        boolean haveAce = false;
        for(int i=0; i<hand.size(); i++) {
            Card card = (Card) (Object) hand.get(i);
            point += card.getValue();
            if (card.getValue() == 1) {
                haveAce = true;
            }
        }
        if(haveAce){
            if(point+10 < 22){
                point += 10;
            }
        }
        return point;
    }
    boolean mustHit(){
        if(bestScore() < 17){
            return true;
        }else{
            return false;
        }
    }
}
