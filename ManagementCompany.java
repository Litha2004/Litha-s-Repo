public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmtFeePercentage;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constant class variables
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Constructors
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmtFeePercentage = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmtFeePercentage) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmtFeePercentage, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmtFeePercentage() {
        return mgmtFeePercentage;
    }

    public Plot getPlot() {
        return plot;
    }

    // Method to add a property to the array
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) return -1; // array full
        if (property == null) return -2; // property is null
        if (!plot.encompasses(property.getPlot())) return -3; // plot not within management company plot
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // overlap detected
        }
        properties[numberOfProperties] = property;
        return numberOfProperties++;
    }

    // Method to add a property by parameters
    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(property);
    }

    // Method to calculate total rent
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    // Remove the last property in the array
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[--numberOfProperties] = null;
        }
    }

    // Check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Get the count of properties
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Check if management fee is valid
    public boolean isManagementFeeValid() {
        return mgmtFeePercentage >= 0 && mgmtFeePercentage <= 100;
    }

    // toString method to list all properties
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n" +
                                             "______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n")
          .append(" total management Fee: ").append((getTotalRent() * mgmtFeePercentage) / 100);
        return sb.toString();
    }
}