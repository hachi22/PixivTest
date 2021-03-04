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
import cat.itb.pixiv.ClassesModels.ImatgesP;
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

        List<ImatgesP> imageslist = new ArrayList<>();
        imageslist.add(new ImatgesP("title","description","user",1,2,2,2));
        imageslist.add(new ImatgesP("title","description","user",1,2,2,2));
        imageslist.add(new ImatgesP("title","description","user",1,2,2,2));
        imageslist.add(new ImatgesP("title","description","user",1,2,2,2));
        imageslist.add(new ImatgesP("title","description","user",1,2,2,2));



//        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_ranking);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
//        adapterRanking = new AdapterRankingIM(options);
//        adapterRanking.setContext(getContext());
//        recyclerView.setAdapter(adapterRanking);

        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdapterRankingIM = new NAdapterRankingIM(imageslist);
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
        nAdapterPopularLives = new NAdapterPopularLives(imageslist);
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


        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, (imageslist.size()+1)/2*800);
        recyclerView.setLayoutParams(param);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
  }

