package BusService;

public class Bus {
    private String busNumber;       // No for the bus
    private String source;          // Starting point of the bus 
    private String destination;     // Ending point of the bus 
    private String departure;       // Departure time of the bus
    private String arrival;         // Arrival time of the bus
    private int totalSeats;         // Total number of seats on the bus
    private int availableSeats;     // Number of seats  available 

    // Constructor to initialize a Bus object
    public Bus(String busNumber, String source, String destination, String departure, String arrival, int totalSeats, int availableSeats) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    // toString method to convert Bus object to a string format for file storage
    @Override
    public String toString() {
        return busNumber + "," + source + "," + destination + "," + departure + "," + arrival + "," + totalSeats + "," + availableSeats;
    }

    // fromString method to parse a string from file into a Bus object
    public static Bus fromString(String busString) {
        String[] parts = busString.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid bus string: " + busString);
        }
        String busNumber = parts[0];
        String source = parts[1];
        String destination = parts[2];
        String departure = parts[3];
        String arrival = parts[4];
        int totalSeats = Integer.parseInt(parts[5]);
        int availableSeats = Integer.parseInt(parts[6]);

        return new Bus(busNumber, source, destination, departure, arrival, totalSeats, availableSeats);
    }

    // Getters and setters for private fields

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
