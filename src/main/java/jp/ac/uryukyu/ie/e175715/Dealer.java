package jp.ac.uryukyu.ie.e175715;
import java.util.Scanner;

public class Dealer{
    /*
     *ディーラー（コンピュータ）と
     * 手札調整,勝敗の設定
     */
    int limit =21;
    Player you;
    Deck deck;
    Hand dealerHand;
    Scanner sc;
    int game;
    Dealer(){
        deck = new Deck();
    }
    Card getCard(){
        Card newCard = null;
        newCard = deck.getNextCard();       //カードの配布
        return newCard;
    }
    void startNewGame(){
        do{
            you = new Player();
            dealerHand = new Hand();
            System.out.println("ゲームを開始しますか？\n1:はい　2:いいえ");
            sc = new Scanner(System.in);
            game = sc.nextInt();
            if(game == 1){      //1が入力されるとゲームスタート
                deck.resetDeck();
                deck.shuffleDeck();
                drawDealer();
                drawPlayer();
                while(you.under(22) && you.moreCards()){
                    //ディーラーの手札合計が17を下回る時に引き直す
                    you.getCard(getCard());
                    System.out.println("あなたの手札.....");
                    you.showPicture();  //プレイヤーの手札表示
                }
                while(dealerHand.mustHit()){
                    dealerHand.addToHand(getCard());
                }
                System.out.println("ディーラーの手札.....");
                dealerHand.showHand();  //ディーラーの手札表示
                System.out.println("------------");
                System.out.println("あなたの手札の合計:"+you.getValueOfHand());
                System.out.println("ディーラーの手札の合計:"+dealerHand.getValue());
                System.out.println("------------");
                showResult();
            }
        }while(game == 0);      //0が入力されると終了
    }

    public void showResult(){
        if(you.over() && dealerHand.over()){
            System.out.println("引き分け");
        }
        else if(you.over()){
            System.out.println("あなたの負けです...");
        }
        else if(dealerHand.over()){
            System.out.println("あなたの勝ちです!");
        }
        else if(you.bestScore() > dealerHand.bestScore()){
            System.out.println("あなたの勝ちです!");
        }
        else if(you.bestScore() < dealerHand.bestScore()){
            System.out.println("あなたの負けです...");
        }
        else System.out.println("引き分け");
    }

    public void drawDealer(){
        //追加ドロー（ディーラー）
        dealerHand = new Hand();
        deck.resetDeck();
        deck.shuffleDeck();
        dealerHand.addToHand(getCard());
        dealerHand.addToHand(getCard());
        System.out.println("ディーラーの手札.....");
        dealerHand.showHand();
    }
    public void drawPlayer(){
        //追加ドロー（プレイヤー）
        you = new Player();
        you.getCard(getCard());
        you.getCard(getCard());
        System.out.println("あなたの手札.....");
        you.showHand();
    }
}