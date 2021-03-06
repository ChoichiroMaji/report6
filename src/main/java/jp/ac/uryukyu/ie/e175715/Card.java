package jp.ac.uryukyu.ie.e175715;

public class Card {
    /*
     *カードの数字,スートの基本設定
     */
    private String Suit;
    private int Value;
    private String picture;

    public Card(String s1,String s2){
        setSuit(s1,s2);
        setValue(s1,s2);
        setPicture(s1,s2);
    }
    public String getSuit(){
        return Suit;
    }
    public int getValue(){
        return Value;
    }
    public String getPicture(){
        return picture;
    }
    private void setSuit(String S1, String S2){
        //スートの基本設定
        Suit = S2;
    }
    private void setValue(String S1, String S2){
        //数値の基本設定
        Value = Integer.parseInt(S1); //文字列を数値に変換
    }
    private void setPicture(String S1, String S2){
        /*
         *カードの名称変更
         * 1:Ace
         * 11:Jack
         * 12:Queen
         * 13:King
         */
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
