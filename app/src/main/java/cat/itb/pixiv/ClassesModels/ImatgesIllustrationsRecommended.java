package cat.itb.pixiv.ClassesModels;

public class ImatgesIllustrationsRecommended {
    private int image;
    private int numLikes;

    public ImatgesIllustrationsRecommended(int image, int numLikes) {
        this.image = image;
        this.numLikes = numLikes;
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
