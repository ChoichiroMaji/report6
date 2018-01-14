package jp.ac.uryukyu.ie.e175715;
import java.io.*;

public class Player {
    /*
    *ゲームプレイヤーの操作設定
     */
    int limit = 21;
    Hand hand;
    BufferedReader MyReader;

    public Player() {
        hand = new Hand();
        MyReader = new BufferedReader(new InputStreamReader(System.in), 1);
    }

    boolean moreCards() {           //さらにカードを引くかどうかの入力
        char ch = ' ';
        do {
            System.out.println("Hit or Stay: ");
            try {
                String myString = MyReader.readLine();
                ch = myString.charAt(0);
            } catch (IOException e) {
            } catch (StringIndexOutOfBoundsException e) {
            }
            if (ch == 'H' || ch == 'h') {
                return true;
            } else if (ch == 'S' || ch == 's') {
                return false;
            }
        } while (true);
    }
    public void getCard(Card card){
        hand.addToHand(card);
    }
    public void showHand(){
        hand.showHand();
    }
    public void showPicture(){
        hand.showPicture();
    }
    int getValueOfHand(){
        int Value = 0;
        Value = hand.getValue();
        return Value;
    }
    boolean under(int limit){
        return hand.under(limit);
    }
    boolean over(){
        return hand.over();
    }
    int bestScore(){
        return hand.bestScore();
    }
}