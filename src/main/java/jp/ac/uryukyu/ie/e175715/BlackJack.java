package jp.ac.uryukyu.ie.e175715;

public class BlackJack {
    /*
     *メインクラス
     * "blackJack"ルール説明
     * プレイヤー（自分）とディーラー（相手）との対決
     * 1.各プレイヤーに山札（ジョーカーを含まない52枚）から二枚のカードが
     * 配られる。
     * 2.各プレイヤーは任意でドローができる。手札の数字の合計が21に近い方
     * が勝者となる。
     * 3.ただし,手札合計が21を超えた地点で敗者となる。
     *
     * 単純なようで,洞察力,先を読む力,そして運が試される奥深いゲームです。
     */
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        dealer.startNewGame();
    }
}
