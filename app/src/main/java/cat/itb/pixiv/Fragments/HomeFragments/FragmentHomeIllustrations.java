package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterIlustrationsRecomended;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterPopularLives;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterRankingIM;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterIllustrationsRecommended;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterPopularLives;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterRankingIM;
import cat.itb.pixiv.ClassesModels.ImatgesIllusMangaRanking;
import cat.itb.pixiv.ClassesModels.ImatgesIllustrationsRecommended;
import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.ClassesModels.ImatgesPopularLives;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;

public class FragmentHomeIllustrations extends Fragment {


public static FragmentHomeIllustrations getInstance(){
    return new FragmentHomeIllustrations();
}

    RecyclerView recyclerView;
    AdapterRankingIM adapterRanking;
    AdapterIlustrationsRecomended adapterRecomended;
    AdapterPopularLives adapterPopularLives;

    NAdapterIllustrationsRecommended nAdapterIllustrationsRecommended;
    NAdapterRankingIM nAdapterRankingIM;
    NAdapterPopularLives nAdapterPopularLives;
    DatabaseReference myRef;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_illustrations, container, false);
        FireBaseHelper.obtenerReferencia();

//        List<ImatgesP> imageslist = new ArrayList<>();
//        imageslist.add(new ImatgesP("title","description","user",R.raw.img1,2,2,2,R.raw.img6,R.raw.img11));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.img2,2,2,2,R.raw.img7,R.raw.img12));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.img3,2,2,2,R.raw.img8,R.raw.img13));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.img4,2,2,2,R.raw.img9,R.raw.img14));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.img5,2,2,2,R.raw.img10,R.raw.img15));

        List<ImatgesIllustrationsRecommended> imageslist=new ArrayList<>();
        imageslist.add(new ImatgesIllustrationsRecommended(R.raw.img1,566));
        imageslist.add(new ImatgesIllustrationsRecommended(R.raw.img2,785));
        imageslist.add(new ImatgesIllustrationsRecommended(R.raw.img3,897));
        imageslist.add(new ImatgesIllustrationsRecommended(R.raw.img4,489));
        imageslist.add(new ImatgesIllustrationsRecommended(R.raw.img5,656));

        List<ImatgesIllusMangaRanking>rankinglist=new ArrayList<>();
        rankinglist.add(new ImatgesIllusMangaRanking("Gintama","Harada",R.drawable.perro,R.raw.img6));
        rankinglist.add(new ImatgesIllusMangaRanking("KHR","Yamasaki",R.drawable.perro,R.raw.img7));
        rankinglist.add(new ImatgesIllusMangaRanking("KHR","Tsuna",R.drawable.perro,R.raw.img8));
        rankinglist.add(new ImatgesIllusMangaRanking("KHR","Sawada",R.drawable.perro,R.raw.img9));
        rankinglist.add(new ImatgesIllusMangaRanking("Persona","Kimihito",R.drawable.perro,R.raw.img10));

        List<ImatgesPopularLives>popularLives=new ArrayList<>();
        popularLives.add(new ImatgesPopularLives("Lewis Gun",R.drawable.perro,R.raw.img11,1000));
        popularLives.add(new ImatgesPopularLives("Akai haato",R.drawable.perro,R.raw.img12,2000));
        popularLives.add(new ImatgesPopularLives("Senjougahara",R.drawable.perro,R.raw.img13,400));
        popularLives.add(new ImatgesPopularLives("Ibai",R.drawable.perro,R.raw.img14,320));
        popularLives.add(new ImatgesPopularLives("Edelgard",R.drawable.perro,R.raw.img15,100));





//        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_ranking);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
//        adapterRanking = new AdapterRankingIM(options);
//        adapterRanking.setContext(getContext());
//        recyclerView.setAdapter(adapterRanking);

        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdapterRankingIM = new NAdapterRankingIM(rankinglist);
        recyclerView.setAdapter(nAdapterRankingIM);



//        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_popular_lives);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options2 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferencePopularLives(), ImatgesP.class).build();
//        adapterPopularLives = new AdapterPopularLives(options2);
//        adapterPopularLives.setContext(getContext());
//        recyclerView.setAdapter(adapterPopularLives);

        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_popular_lives);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdapterPopularLives = new NAdapterPopularLives(popularLives);
        recyclerView.setAdapter(nAdapterPopularLives);


//        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_recommended);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
//        FirebaseRecyclerOptions<ImatgesP> options3 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRecommendedIllustrations(), ImatgesP.class).build();
//        adapterRecomended = new AdapterIlustrationsRecomended(options3);
//        adapterRecomended.setContext(getContext());
//        recyclerView.setAdapter(adapterRecomended);

        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_recommended);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        nAdapterIllustrationsRecommended = new NAdapterIllustrationsRecommended(imageslist);
        recyclerView.setAdapter(nAdapterIllustrationsRecommended);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
  }

