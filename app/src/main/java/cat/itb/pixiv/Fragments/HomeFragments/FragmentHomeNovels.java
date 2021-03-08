package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterNovelsRecommended;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterRankingNovels;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterNovelsRecommended;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterPixivVision;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdaptersRankingNovels;
import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;

public class FragmentHomeNovels extends Fragment {

    public static FragmentHomeNovels getInstance(){
        return new FragmentHomeNovels();
    }

    RecyclerView recyclerView;
    AdapterNovelsRecommended adapterRecommended;
    AdapterRankingNovels adapterRanking;
    DatabaseReference myRef;

    NAdaptersRankingNovels nAdaptersRankingNovels;
    NAdapterNovelsRecommended nAdapterNovelsRecommended;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home_novels, container, false);

        List<ImatgesP> imageslist = new ArrayList<>();
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel1,2,2,2,0,R.raw.novel7));
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel2,2,2,2,0,R.raw.novel8));
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel3,2,2,2,0,R.raw.novel9));
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel4,2,2,2,0,R.raw.novel10));
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel5,2,2,2,0,R.raw.novel11));
        imageslist.add(new ImatgesP("title","description","user",R.raw.novel6,2,2,2,0,R.raw.novel12));

//        recyclerView = rootView.findViewById(R.id.recycler_view_novels_ranking);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
//        adapterRanking = new AdapterRankingNovels(options);
//        adapterRanking.setContext(getContext());
//        recyclerView.setAdapter(adapterRanking);

        recyclerView = rootView.findViewById(R.id.recycler_view_novels_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdaptersRankingNovels = new NAdaptersRankingNovels(imageslist);
        recyclerView.setAdapter(nAdaptersRankingNovels);

//        recyclerView = rootView.findViewById(R.id.recycler_view_novels_recommended);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options2 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRecommendedNovels(), ImatgesP.class).build();
//        adapterRecommended = new AdapterNovelsRecommended(options2);
//        adapterRecommended.setContext(getContext());
//        recyclerView.setAdapter(adapterRecommended);

        recyclerView = rootView.findViewById(R.id.recycler_view_novels_recommended);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        nAdapterNovelsRecommended = new NAdapterNovelsRecommended(imageslist);
        recyclerView.setAdapter(nAdapterNovelsRecommended);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, imageslist.size()*500);
        recyclerView.setLayoutParams(param);

        return rootView;
    }

}