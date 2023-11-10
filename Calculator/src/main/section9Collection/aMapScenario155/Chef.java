package section9Collection.aMapScenario155;

public interface Chef {
    String favoriteFood = "hamburger"; // On peut également rajouter des fields sur une interface mais par default ce field est final (on ne peut pas changer ça valeur) => on ne peut mettre pas de setter => on ne peut conserver aucun état

    default String getFavoriteFood() { // On peut mettre un getter sur ce field
        return favoriteFood;
    }

    // On crée des méthodes avec implémentation sur une interface avec le mot clé default
    default void cook(String food) {
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    static int convertUnits() { //  Vous pouvez également mettre des méthodes statiques sur une interface potentiellement plutôt sympa
        return 2;
    }
}
