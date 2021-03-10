package cat.itb.pixiv.ClassesModels;

public class ImatgesMangaRecommended {
    private String title;
    private String description;
    private int image;
    private int numLikes;

    public ImatgesMangaRecommended(String title, String description, int image, int numLikes) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.numLikes = numLikes;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
}
