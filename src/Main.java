// the load balancer will use minimum load strategy to distribute
// requests evenly across a list of server instances
public class Main {
    public static void main(String[] args) {
       LoadBalancer loadBalancer = new LoadBalancer();

//       some dummy server IP addresses and loads;
        loadBalancer.addServer("192.11", 10);
        loadBalancer.addServer("192.12", 10);
        loadBalancer.addServer("192.13", 10);

//        retrieve the next server for routing requests
        String ipAddress1 = loadBalancer.getNextServer();
        System.out.println("Request routed to server" + ipAddress1);

        String ipAddres2 = loadBalancer.getNextServer();
        System.out.println("Request routed to server" + ipAddres2);

        System.out.println(loadBalancer.getSize());
    }
}