public class Compulsory {
    public static void main(String[] args) {
        Network app=new Network();
        Computer c1=new Computer("C1","123",new Location(1,2),"ipaddress",5.6);
        app.addNode(c1);
        app.addNode(c1);
        Router r1=new Router("R1","123",new Location(1,2),"ipRouter");
        app.addNode(r1);
        app.addNode(r1);
        Switch s1= new Switch("s1",new Location(1,3),"macAddr");
        app.addNode(s1);
        app.addNode(s1);
        System.out.println(app);
    }
}
