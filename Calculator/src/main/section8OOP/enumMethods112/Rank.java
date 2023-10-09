package section8OOP.enumMethods112;

/**
 *  Section 8 More OOP - 112 Enum Methods
 *
 *  Un concept avec l'orientation objet est que vous voulez que vos méthodes (ou votre comportement)
 *  soient aussi proches que possible des données avec lesquelles ils travaillent généralement.
 *
 *  => On a déplacé la methode getValue() présent dans la class Card vers la class Rank (Enum) => qq modif
 */
enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public int getValue() {
        return switch (this) {  // this => à remplacé this.rank | signifie l'instance de l'objet ou nous sommes (class Rank) ses constantes AS ou TWO ou THREE sont déja des instances en Enum (voire test RankTest)
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 1;  // ordinal()  => remplace this.rank.ordinal() | nous savons que les instances de l'Enum (AS ou TWO ou THREE... ) héritent d'une méthode appelée ordinal() => qd IDE crée les instances de ces constantes il établit un index
        };
    }


}
