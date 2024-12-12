// the server instance class
//acts as a server which encapsulates ip address
//current load for each server


public class ServerInstance {
    private String ipAddress;
    private int currentLoad;
    public ServerInstance(String ipaddres, int currentLoad) {
        this.ipAddress = ipaddres;
        this.currentLoad = currentLoad;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void incrementLoad() {
        currentLoad++;
    }
}
