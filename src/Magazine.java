public class Magazine {
    private double weeklyCost;
    private List<String> supplements;

    public Magazine(double weeklyCost) {
        this.weeklyCost = weeklyCost;
        this.supplements = new ArrayList<>();
    }

    // getters and setters for weeklyCost and supplements

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
