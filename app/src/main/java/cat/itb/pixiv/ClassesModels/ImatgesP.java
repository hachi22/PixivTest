package cat.itb.pixiv.ClassesModels;

import android.media.Image;

public class ImatgesP {
    private String title;
    private String user;
    private String image;

    public ImatgesP(String title, String user, String image) {
        this.title = title;
        this.user = user;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
