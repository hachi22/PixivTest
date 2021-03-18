package cat.itb.pixiv.ClassesModels;

import android.os.Parcel;
import android.os.Parcelable;

public class IllustrationClass implements Parcelable {
    String idIllustration;
    String title;
    String IllustrationImgUrl;
    String userName;
    String userImgUrl;
    boolean imgpriv;

    public IllustrationClass(){}

    public IllustrationClass(String idIllustration, String title, String illustrationImgUrl, String userName, String userImgUrl, boolean imgpriv) {
        this.idIllustration = idIllustration;
        this.title = title;
        IllustrationImgUrl = illustrationImgUrl;
        this.userName = userName;
        this.userImgUrl = userImgUrl;
        this.imgpriv = imgpriv;
    }


    protected IllustrationClass(Parcel in) {
        idIllustration = in.readString();
        title = in.readString();
        IllustrationImgUrl = in.readString();
        userName = in.readString();
        userImgUrl = in.readString();
        imgpriv = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idIllustration);
        dest.writeString(title);
        dest.writeString(IllustrationImgUrl);
        dest.writeString(userName);
        dest.writeString(userImgUrl);
        dest.writeByte((byte) (imgpriv ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IllustrationClass> CREATOR = new Creator<IllustrationClass>() {
        @Override
        public IllustrationClass createFromParcel(Parcel in) {
            return new IllustrationClass(in);
        }

        @Override
        public IllustrationClass[] newArray(int size) {
            return new IllustrationClass[size];
        }
    };

    public String getIdIllustration() {
        return idIllustration;
    }

    public void setIdIllustration(String idIllustration) {
        this.idIllustration = idIllustration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIllustrationImgUrl() {
        return IllustrationImgUrl;
    }

    public void setIllustrationImgUrl(String illustrationImgUrl) {
        IllustrationImgUrl = illustrationImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }
}
