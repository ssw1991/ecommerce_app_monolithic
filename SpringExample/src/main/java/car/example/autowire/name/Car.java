package car.example.autowire.name;

public class Car {
    // Note we never see this explicity set.  It is autowired in the configuration file.
    private Specification specification;

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails(){
        System.out.println("Car details: " + specification.toString());
    }
}
