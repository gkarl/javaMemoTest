package section8OOP.enumFields113;

class Card {

    private Rank rank; // Pour changer rapidement tous le type de cette attribut en type Enum clic D sur type / Rafactor/ Type Migration ou Ctrl Shift F6

    private Suit suit;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Suit.CLUBS,Rank.KING);
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
    }

    /*public int getValue() {
        return switch (this.rank) {  //
            case JACK, QUEEN, KING -> 10;
            default -> this.rank.ordinal() + 1;
        };
    }*/

    public int getValue() {
        return this.rank.getValue();  //  ici, nous déléguons simplement l'appel getValue() a un niveau inférieur la class Enum Rank
    }
}
