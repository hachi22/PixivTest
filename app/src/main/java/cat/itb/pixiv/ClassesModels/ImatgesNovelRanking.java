package cat.itb.pixiv.ClassesModels;

public class ImatgesNovelRanking {
    private String title;
    private String user;
    private String description;
    private String characters;
    private int imageUser;
    private int image;

    public ImatgesNovelRanking(String title, String user, String description, String characters, int imageUser, int image) {
        this.title = title;
        this.user = user;
        this.description = description;
        this.characters = characters;
        this.imageUser = imageUser;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public int getImageUser() {
        return imageUser;
    }

    public void setImageUser(int imageUser) {
        this.imageUser = imageUser;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
