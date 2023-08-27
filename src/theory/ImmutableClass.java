package theory;

/**
 * @author Heshan Karunaratne
 */
public final class ImmutableClass {

    private final String name;
    private final String address;

    public ImmutableClass(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
