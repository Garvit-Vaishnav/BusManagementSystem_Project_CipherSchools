package bus_managment_system;

public class Bus {
    private String busNumber;
    private String operatorName;
    private String source;
    private String destination;
    private int fare;

    public Bus(String busNumber, String operatorName, String source, String destination, int fare) {
        this.busNumber = busNumber;
        this.operatorName = operatorName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                '}';
    }
}
