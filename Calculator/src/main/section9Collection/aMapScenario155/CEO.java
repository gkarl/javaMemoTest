package section9Collection.aMapScenario155;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CEO  extends Employee implements Flyer {
    private  int avgStockPrice = 0;

    // Crée une instance de Pilot en tant que field dans CEO | Puis on la met de type Flyer à la creation de cette interface
    private Flyer pilot = new Pilot(1000, true);
    Flyer flyer = new Pilot(1000, true);

    String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
    Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String personText) {
        super(personText);
        Matcher ceoMat = ceoPat.matcher(peopleMat.group("detail"));
        if (ceoMat.find()) {
            this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));

        }
    }

    public int getSalary() {
        return 5000 * avgStockPrice;
    }

    // Alt Insert / Delegate Methods => CEO a alors essentiellement les mêmes méthodes que Pilot (mais passe par pilot)
    public void fly() {
        pilot.fly(); // j'ai maintenant une methode fly() dans CEO qui Delegate (délégue) à la methode fly() dans Pilot
    }

    public int getHoursFlows() {
        return pilot.getHoursFlows();
    }

    public void setHoursFlows(int hoursFlows) {
        pilot.setHoursFlows(hoursFlows);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }
}