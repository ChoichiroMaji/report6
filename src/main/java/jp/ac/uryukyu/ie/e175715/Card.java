package jp.ac.uryukyu.ie.e175715;

public class Card {
    /*
     *カードの数字,スートの基本設定
     */
    String Suit;
    int Value;
    String picture;

    public Card(String s1,String s2){
        setSuit(s1,s2);
        setValue(s1,s2);
        setPicture(s1,s2);
    }
    public void setSuit(String S1, String S2){
        Suit = S2;
    }
    public void setValue(String S1, String S2){
        Value = Integer.parseInt(S1);
        if(Value > 10){
            Value = 10;
        }
    }
    public void setPicture(String S1, String S2){
        picture = S1;
        if(picture.equals("1")){
            picture = "Ace";
        }else if(picture.equals("11")){
            picture = "Jack";
        }else if(picture.equals("12")){
            picture = "Queen";
        }else if(picture.equals("13")){
            picture = "King";
        }
    }
}
