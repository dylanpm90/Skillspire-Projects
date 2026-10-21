//16. Given:
//
//class Server { String region; }
//class Cluster { /* fill */ }
//
//Compose Cluster so it holds many Servers (field + add method).

import java.util.ArrayList;

public class ServerClusterComposition {

    class Server {
        int serverNumber;

        void ping() {
            System.out.println("Server ID#:" + serverNumber + " - Pinged!");
        }

        Server(int serverNumber) {
            this.serverNumber = serverNumber;
        }
    }

    class Cluster {
        String regionName;
        ArrayList<Server> serverCluster = new ArrayList<>();

        Cluster(String regionName) {
            this.regionName = regionName;
        }

        void addServer(Server server) {
            serverCluster.add(server);
        }

        void pingServers() {
            for (Server server : serverCluster) {
                server.ping();
            }
        }
    }

    void main(String[] args) {
        System.out.println("New Server Cluster:");
        Cluster cluster = new Cluster("PNW");
        cluster.addServer(new Server(123));
        cluster.addServer(new Server(456));
        cluster.addServer(new Server(789));
        cluster.addServer(new Server(101112));
        cluster.pingServers();
    }
}
