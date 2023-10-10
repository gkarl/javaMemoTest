package section8OOP.enumFields113;

/**
 * Section 8 More OOP - 113 Enum Fields
 * Permetde contourner l'index par défault des Constantes Enum via la methode ordinal() et de custom ses valeurs
 */
enum Rank {
    ACE(1), // 3/ rajoute en arg la valeur du field qu'on vient de créer
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value; // 1/ crée un field de type int

    Rank(int value) {  // 2/ Crée un constructeur à partir de ce field
        this.value = value;
    }

    /*public int getValue() {
        return switch (this) {  // this => à remplacé this.rank | signifie l'instance de l'objet ou nous sommes (class Rank) ses constantes AS ou TWO ou THREE sont déja des instances en Enum (voire test RankTest)
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 1;  // ordinal()  => remplace this.rank.ordinal() | nous savons que les instances de l'Enum (AS ou TWO ou THREE... ) héritent d'une méthode appelée ordinal() => qd IDE crée les instances de ces constantes il établit un index
        };
    }*/

    public int getValue() {
        return value; // 4/ plus besoin de switch les constantes de Enum (instance) contient en arg la valeur du field value qui sera return par cette methode
    }
}
