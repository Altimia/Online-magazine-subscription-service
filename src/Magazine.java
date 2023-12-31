import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
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

    public List<Supplement> getSupplementsByName(List<Supplement> supplements, List<String> names) {
        return supplements.stream()
            .filter(supplement -> names.contains(supplement.getName()))
            .collect(Collectors.toList());
    }

    public void modifySupplement(String oldSupplement, String newSupplement) {
        int index = this.supplements.indexOf(oldSupplement);
        if (index != -1) {
            this.supplements.set(index, newSupplement);
        }
    }

    public String getSupplementByName(String name) {
        for (String supplement : this.supplements) {
            if (supplement.equals(name)) {
                return supplement;
            }
        }
        return null;
    }
}
