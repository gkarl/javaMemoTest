package section9Collection.aMapScenario155;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Manager extends Employee {

    private  int orgSize = 0;
    private int directReports = 0;

    String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
    Pattern managerPat = Pattern.compile(managerRegex);

    public Manager(String personText) {
        super(personText);
        Matcher managerMat = managerPat.matcher(peopleMat.group("detail"));
        if (managerMat.find()) {
            this.orgSize = Integer.parseInt(managerMat.group("orgSize"));
            this.directReports = Integer.parseInt(managerMat.group("dr"));
        }
    }

    //Etape 3_____________ Si on avait eu besoin de spécifier un fields particulier en plus qui est sur la su-class Manager pour différencier les personnes
    // Alt Insert Override equals et hashCode() avec le field directReports
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;  // super.equals() permet de prendre en comptes les fields qu'on a défini sur cette methode dans la super-class employee
        Manager manager = (Manager) o;
        return directReports == manager.directReports;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), directReports);
    }

    public int getSalary() { // la ligne de calcul des salaires dans le main() devient une methode | seule partie qui effectue un calcul
        return 3500 * orgSize * directReports; // meme si linesOfCode, yearsOfExp, iq égale 0 getSalary() return 3000 => pas besoin de else
    }
}

