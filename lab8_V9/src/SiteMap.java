public class SiteMap {
    private String url;
    private String lastMod;
    private double priority;

    public SiteMap(String url, String lastMod, double priority) {
        this.url = url;
        this.lastMod = lastMod;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SiteMap{" +
                "url='" + url + '\'' +
                ", lastMod='" + lastMod + '\'' +
                ", priority=" + priority +
                '}';
    }
}
