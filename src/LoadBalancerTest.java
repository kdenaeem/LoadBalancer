import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class LoadBalancerTest {
    private LoadBalancer loadBalancer;

    @BeforeEach
    public void setUp() {
        loadBalancer = new LoadBalancer();
    }

    @Test
    public void addTestServer() {
        loadBalancer.addServer("192.11", 10);
        String serverIP = loadBalancer.getNextServer();
        assertTrue(loadBalancer.containsServer("192.11"));
    }

    @Test
    public void testGetNextServerWithNoServers() {
        assertThrows(IllegalStateException.class,
                () -> loadBalancer.getNextServer());
    }



    @Test
    public void testMaximumLoadBalancerSize() {
        loadBalancer.addServer("192.168", 2);
        loadBalancer.addServer("192.1", 9);
        loadBalancer.addServer("192.1113", 9);
        loadBalancer.addServer("192.12213", 9);
        loadBalancer.addServer("192.1113313", 9);
        loadBalancer.addServer("192.133313", 9);
        loadBalancer.addServer("192.1331113", 9);
        loadBalancer.addServer("192.13313", 9);
        loadBalancer.addServer("192.12213", 9);
        loadBalancer.addServer("192.11213", 9);
        loadBalancer.addServer("192.3", 9);

        assertEquals(10, loadBalancer.getSize());
    }






}
