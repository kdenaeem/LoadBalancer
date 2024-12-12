import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private List<ServerInstance> servers;
    private final Random random = new Random();
    private static final int MAX_SIZE_ALLOWED = 10;
    public LoadBalancer() {
//        array lists are good for random access
        servers = new ArrayList<>();
//        linkedLists are good for insertions
//        vectors are synchronised and so they are usually thread safe
//        ArrayLists are faster for single threaded applications
//        ArrayList is not synchronised and multiple thread access concurrently can
//        cause race condition and dirty reads
    }

//    Method to add a server to the load balancer
    public void addServer(String ipAdress, int currentLoad) {
        if (!containsServer(ipAdress) && servers.size() < MAX_SIZE_ALLOWED) {
            servers.add(new ServerInstance(ipAdress, currentLoad));
        }
    }
    public int getSize() {
        return servers.size();
    }

    public boolean containsServer(String ipAddress) {
        for (ServerInstance server : servers) {
            if (server.getIpAddress().equals(ipAddress)) {
                return true;
            }
        }
        return false;

    }

    public String getNextServer() {
        if (servers.isEmpty()) {
            throw new IllegalStateException("No servers are currently available");
        }

        int randomIndex = random.nextInt(servers.size());

        ServerInstance server = servers.get(randomIndex);

        server.incrementLoad();

        return server.getIpAddress();


    }




}
