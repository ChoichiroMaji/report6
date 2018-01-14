package jp.ac.uryukyu.ie.e175715;
import java.util.*;
public class Hand {
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
        hand.addElement(card);
    }
    public void showHand(){
        for(int i=0; i<hand.size(); i++){
            Card card = (Card)(Object)hand.get(i);
            System.out.println(card.getPicture() + " " + card.getSuit());
        }
    }
    public void showPicture(){
        for(int i=0; i<hand.size(); i++){
            Card card = (Card)(Object)hand.get(i);
            System.out.println(card.getPicture() + " " + card.getSuit());
        }
    }
    boolean under(int limit){
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
        if(under(22)){
            return true;
        }else{
            return false;
        }
    }
    int bestScore(){
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
