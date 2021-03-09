package cat.itb.pixiv.ClassesModels;

public class ImatgesPixivVision {
    private String title;
    private int image;

    public ImatgesPixivVision(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
