public class Music {
    public static void main(String args[]) {
        Music goodMusic = new Music("some shit", "some link", "Brahms", "niiiice", 0);
        System.out.println(goodMusic.performer);
    }
    public String title;
    public String link;
    public String category;
    public String performer;
    public int vote;
    public Music(String a, String b, String c, String d, int e) {
        title = a;
        link = b;
        performer = c;
        category = d;
        vote = e;
    }
}
