package section8OOP.enumOrdinals111;

/**
 * Section 8 More OOP - Enum Ordinals
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
        Card card1 = new Card(Suit.CLUBS,Rank.KING); // On crée un Enum Suit (couleur de la carte) et Rank (valeur de la carte) pour qu'a l'instanciation de la carte il ne soit pas possible de se tromper sur les valeurs à entrer = Type Safe
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
    }

    public int getValue() {
        //return this.rank.ordinal() + 1;  // ordinal() => méthode présent dans les class Enum => associe un index à chaque constante présente | Ex met +1 car index commence à 0 et dans notre cas as 1

        // return this.rank == Rank.JACK ? 10 : this.rank.ordinal() + 1; // Ternaire si=? la carte est un JACK (valet)  return 10 si non=: retourne l'index comme avant

        return switch (this.rank) {
            case JACK, QUEEN, KING -> 10; // pour que les test marche si c'est un JACK, QUEEN, KING -> return 10
            default -> this.rank.ordinal() + 1; // si c'est un JACK, QUEEN, KING return l'index des constantes dans Enum
        };
    }
}
