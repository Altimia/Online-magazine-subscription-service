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

    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

    public List<Supplement> getSupplementsByName(List<String> names) {
        return this.supplements.stream()
            .filter(supplement -> names.contains(supplement.getName()))
            .collect(Collectors.toList());
    }

    public Supplement getSupplementByName(String name) {
        return this.supplements.stream()
            .filter(supplement -> supplement.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public void modifySupplement(String oldSupplement, String newSupplement) {
        int index = this.supplements.indexOf(oldSupplement);
        if (index != -1) {
            this.supplements.set(index, newSupplement);
        }
    }
}
