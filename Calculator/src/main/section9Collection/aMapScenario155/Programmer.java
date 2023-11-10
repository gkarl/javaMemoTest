package section9Collection.aMapScenario155;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programmer extends Employee implements Chef {  //** extends Employee => la class Programmer hérite de la super class Employee, les propriétés et les méthodes présent super classe sont héritées tant qu’ils sont au moins protected ou public | c'est toujours dire qu'un Programmeur est un type Employee

    //____________On deplace ce code vers la super class mére car commun aux class__________________
    /*private String lastName; // field doivent etre protected ou public pour etre accéssible par class enfant (sub-class)
    private String firstName;
    private LocalDate dob;*/

    private  int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    //_____________On deplace ce code vers la super class mére car commun aux class______________________
    /*private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
    protected final Pattern peoplePattern = Pattern.compile(peopleRegex);
    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
*/
    private final String progRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)"; //** il crée une regex particuliere car le field varie en fct des metier | ex ici pour programmer
    private final Pattern progPat = Pattern.compile(progRegex);


    public Programmer(String personText) { // on va passer au constructeur la une ligne du texte data bases origin

        //_____________On deplace ce code vers la super class mére car commun aux class______________________
        /*Matcher peopleMat = peoplePattern.matcher(personText); // crée le Matcher capable d'analyse cet String d'1 personne (arg du constructeur)
        if (peopleMat.find()) { // lance la recherche de match | Dans le constructeur va passer 1 seule personne donc pas besoin de While un if suffis
            this.lastName = peopleMat.group("lastName"); // stock la valeur récupérer du match pour valoriser un field de la class Programmer
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));*/ // pour parse String en LocaleDate

        super(personText); // On déplacé le code juste haut dessus vers la super class (mére) dans son constructeur car commun aux 4 class | super() => cela va appeler le constructeur que nous avons déjà créé sur la classe mére Employee | ce constructeur à un String comme arg on lui passe celui de ce constructeur
        Matcher progMat = progPat.matcher(peopleMat.group("detail")); //crée le Matcher capable d'analyse la fin du String d'1 personne name groupe detail spécifique pour chaque role ici programmeur  {locpd=2000, yoe=3, iq=140}
        if (progMat.find()) { // on dit au Matcher de trouver (find()) ces détails. if() tant qu'il trouve ces details
            this.linesOfCode = Integer.parseInt(progMat.group("locpd"));  // il peut les extraire on le convertit en int et le stock dans field (propriété de la class)
            this.yearsOfExp = Integer.parseInt(progMat.group("yoe")); // idem ...
            this.iq = Integer.parseInt(progMat.group("iq"));
        }
    }

    public int getSalary() {
        return 3000 * linesOfCode + yearsOfExp + iq; // on fait des math avec pour obtenir le salaire selon nos règles arbitraires différentes sur chaque role
    }

    //**_____________On deplace ce code vers la super class mére car commun aux class______________________
    /*@Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }*/

    // Il crée les getter et les setter des fields => pour pouvoir appeler les getter et print leur valeur sur le Main
    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}



