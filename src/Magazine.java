import java.util.List;
import java.util.ArrayList;
public class Magazine {
    private double weeklyCost;
    private List<String> supplements;

    public Magazine(double weeklyCost) {
        this.weeklyCost = weeklyCost;
        this.supplements = new ArrayList<>();
    }

    public double getWeeklyCost() {
        return this.weeklyCost;
    }

    public void setWeeklyCost(double weeklyCost) {
        this.weeklyCost = weeklyCost;
    }

    public List<String> getSupplements() {
        return this.supplements;
    }

    public void addSupplement(String supplement) {
        this.supplements.add(supplement);
    }

    public void removeSupplement(String supplement) {
        this.supplements.remove(supplement);
    }

    public void modifySupplement(String oldSupplement, String newSupplement) {
        int index = this.supplements.indexOf(oldSupplement);
        if (index != -1) {
            this.supplements.set(index, newSupplement);
        }
    }
}
