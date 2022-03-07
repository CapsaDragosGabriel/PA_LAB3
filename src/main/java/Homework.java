public class Homework {
    public static void main(String[] args) {
        Network app=new Network();
        Computer v1=new Computer("Computer A","123",new Location(1,2),"ipaddress",5.6);
        app.addNode(v1);

        Router v2=new Router("Router A","123",new Location(1,2),"ipRouter");
        app.addNode(v2);
        Switch s1= new Switch("s1",new Location(1,3),"macAddr");
        app.addNode(s1);
        app.addNode(s1);
        System.out.println(app);
    }
}
