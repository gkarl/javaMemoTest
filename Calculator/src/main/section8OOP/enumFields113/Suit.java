package section8OOP.enumFields113;

/**
 * Section 8 More OOP - 113 Enum Fields
 *
 * associer un symbole textuel à chacun des constantes de Enum pour les imprimer
 * => utilise Unicode
 */
enum Suit {
    CLUBS('\u2663'), // 3/ rajoute en arg le charactére unicode correspondant à chaque constante
    DIAMONDS('\u2666'),
    HEART('\u2665'),
    SPADES('\u2660');

    private char symbol; // 1/ crée un field de type char qui va contenir les Unicode

    Suit(char symbol) { // 2/ Crée un constructeur à partir de ce field
        this.symbol = symbol;
    }

    @Override
    public String toString() { // 4/ Override la methode toString pour print les instances de cette class
        return Character.toString(this.symbol); // on veut print l'attribut symbol qui est de type char mais la methode toString() doit return un int | Character.toString() => Parse le char en String
    }
}
