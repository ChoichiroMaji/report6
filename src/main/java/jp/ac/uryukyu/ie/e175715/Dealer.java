package jp.ac.uryukyu.ie.e175715;
import java.util.Scanner;

public class Dealer {
    /*
     *ディーラー（NPC）の操作設定と
     * 勝敗の設定
     */
    int limit = 21;
    Player player;
    Deck deck;
    Hand dealerHand;
    int game;
    Scanner sc;
    public Dealer(){
        deck = new Deck();
    }
    Card getCard() {
        //カードの配布
        Card newCard = null;
        newCard = deck.getNextCard();
        return newCard;
    }
    public void startNewGame(){
        //ゲームの基本画面
        do{
            player = new Player();
            dealerHand = new Hand();
            System.out.println("ゲームを開始しますか？\n1:はい　2:いいえ");
            sc = new Scanner(System.in);
            game = sc.nextInt();
            if(game == 1){          //1と入力すればゲーム（リ）スタート
                deck.resetDeck();
                deck.shuffleDeck();
                drawDealer();
                drawPlayer();
                while(player.under(22) && player.moreCards()){
                    player.getCard(getCard());
                    System.out.println("あなたの手札...");
                    player.showPicture();
                }
                while(dealerHand.mustHit()){
                    //ディーラーの手札合計が17を下回る場合,ドロー
                    dealerHand.addToHand(getCard());
                }
                System.out.println("ディーラーの手札...");
                dealerHand.addToHand(getCard());
                System.out.println("----------------");
                System.out.println("あなたの合計：" + player.getValueOfHand());
                System.out.println("ディーラーの合計：" + dealerHand.getValue());
                System.out.println("----------------");
                showResult();
            }
        }while(game != 0);          //０と入力すればゲーム終了
    }
    public void showResult(){
        //勝敗の設定
        if(player.over() && dealerHand.over()){
            System.out.println("引き分けです");
        }else if(dealerHand.over()){
            System.out.println("あなたの勝ちです！");
        }else if(player.over()){
            System.out.println("あなたの負けです、、、");
        }else if(player.bestScore() > dealerHand.bestScore()){
            System.out.println("あなたの勝ちです！");
        }else if(player.bestScore() < dealerHand.bestScore()){
            System.out.println("あなたの負けです、、、");
        }else{
            System.out.println("引き分けです");
        }
    }
    public void drawDealer(){
        //追加ドロー（ディーラー）
        dealerHand = new Hand();
        deck.resetDeck();       //山札リセット
        deck.shuffleDeck();     //山札シャッフル
        dealerHand.addToHand(getCard());
        System.out.println("ディーラーの手札...");
        dealerHand.showHand();
    }
    public void drawPlayer(){
        //追加ドロー（プレイヤー）
        player = new Player();
        player.getCard(getCard());      //山札リセット
        player.getCard(getCard());      //山札シャッフル
        System.out.println("あなたの手札...");
        player.showHand();
    }
}