package section8OOP.enumMethods112;

/**
 *  Section 8 More OOP - 112 Enum Methods
 *
 *  On a déplacé la methode getValue() présent dans la class Card vers la class Rank (Enum)
 *  Orientation objet, tels que l'encapsulation, masquer vos données (ici rank) dans les classes
 *  Et même dans ce cas, vous souhaitez uniquement autoriser l’accès extérieur à la quantité la plus restreinte de données nécessaires.
 */
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
