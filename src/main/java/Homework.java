public class Homework {
    public static void main(String[] args) {
        Network app=new Network();
        Computer v1=new Computer("Computer A","123",new Location(1,2),"ipaddress",5.6);
        Router v2=new Router("Router A","123",new Location(1,2),"ipRouter");
        Switch v3= new Switch("Switch A",new Location(1,3),"macAddr");
        Switch v4= new Switch("Switch B",new Location(1,3),"macAddr");
        Router v5=new Router("Router B","123",new Location(1,2),"ipRouter");
        Computer v6=new Computer("Computer B","123",new Location(1,2),"ipaddress",5.6);
        app.addNode(v1);
        app.addNode(v2);
        app.addNode(v3);
        app.addNode(v4);
        app.addNode(v5);
        app.addNode(v6);
        v1.addConnection(v2,10);
        v2.addConnection(v1,10);
        v1.addConnection(v3,50);
        v3.addConnection(v1,50);

        v2.addConnection(v3,20);
        v3.addConnection(v2,20);

        v2.addConnection(v4,20);
        v4.addConnection(v2,20);

        v2.addConnection(v5,10);
        v5.addConnection(v2,10);

        v3.addConnection(v4,20);
        v4.addConnection(v3,20);

        v4.addConnection(v5,30);
        v5.addConnection(v4,30);

        v4.addConnection(v6,10);
        v6.addConnection(v4,10);

        v5.addConnection(v6,20);
        v6.addConnection(v5,20);

        System.out.println(v1.getConnectionCosts());
        System.out.println(app);
    }
}
