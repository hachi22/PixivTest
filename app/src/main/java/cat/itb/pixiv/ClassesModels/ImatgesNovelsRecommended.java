package cat.itb.pixiv.ClassesModels;

public class ImatgesNovelsRecommended {
    private String title;
    private String description;
    private String user;
    private int image;
    private int numlikes;

    public ImatgesNovelsRecommended(String title, String description, String user, int image, int numlikes) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.image = image;
        this.numlikes = numlikes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumlikes() {
        return numlikes;
    }

    public void setNumlikes(int numlikes) {
        this.numlikes = numlikes;
    }
}
