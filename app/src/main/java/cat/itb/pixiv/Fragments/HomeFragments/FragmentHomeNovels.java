package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import cat.itb.pixiv.Adapater.AdapterMangaRecommended;
import cat.itb.pixiv.Adapater.AdapterNovelsRecommended;
import cat.itb.pixiv.Adapater.AdapterPixivVision;
import cat.itb.pixiv.Adapater.AdapterRankingIM;
import cat.itb.pixiv.Adapater.AdapterRankingNovels;
import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;

public class FragmentHomeNovels extends Fragment {


    RecyclerView recyclerView;
    AdapterNovelsRecommended adapterRecommended;
    AdapterRankingNovels adapterRanking;
    DatabaseReference myRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home_novels, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view_novels_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
        adapterRanking = new AdapterRankingNovels(options);
        adapterRanking.setContext(getContext());
        recyclerView.setAdapter(adapterRanking);

        recyclerView = rootView.findViewById(R.id.recycler_view_novels_recommended);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<ImatgesP> options2 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
                .setQuery(FireBaseHelper.getReferenceRecommendedNovels(), ImatgesP.class).build();
        adapterRecommended = new AdapterNovelsRecommended(options2);
        adapterRecommended.setContext(getContext());
        recyclerView.setAdapter(adapterRecommended);

        return rootView;
    }

}