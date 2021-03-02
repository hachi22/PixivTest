package cat.itb.pixiv.FireBase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseHelper {

    private static FirebaseDatabase database;
    private static DatabaseReference referenceRecommendedIllustrations;
    private static DatabaseReference referenceRanking;
    private static DatabaseReference referencePopularLives;
    private static DatabaseReference referenceRecommendedManga;
    private static DatabaseReference referenceRecommendedNovels;
    private static DatabaseReference referencePixivVision;

    public static void obtenerReferencia(){
        database = FirebaseDatabase.getInstance();
        referencePopularLives = database.getReference("PopularLives");
        referenceRanking = database.getReference("Ranking");
        referenceRecommendedIllustrations = database.getReference("RecommendedIllu");
        referenceRecommendedNovels = database.getReference("RecomendedNovels");
        referenceRecommendedManga = database.getReference("RecomendedManga");
        referencePixivVision = database.getReference("PixivVision");
    }

    public static DatabaseReference getReferenceRecommendedIllustrations() {
        return referenceRecommendedIllustrations;
    }

    public static DatabaseReference getReferenceRanking() {
        return referenceRanking;
    }

    public static DatabaseReference getReferencePopularLives() {
        return referencePopularLives;
    }

    public static DatabaseReference getReferenceRecommendedManga() {
        return referenceRecommendedManga;
    }

    public static DatabaseReference getReferenceRecommendedNovels() {
        return referenceRecommendedNovels;
    }

    public static DatabaseReference getReferencePixivVision() {
        return referencePixivVision;
    }
}
