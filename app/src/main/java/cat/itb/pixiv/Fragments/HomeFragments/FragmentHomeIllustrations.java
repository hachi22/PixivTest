package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import cat.itb.pixiv.Adapater.AdapterIlustrationsRecomended;
import cat.itb.pixiv.Adapater.AdapterPopularLives;
import cat.itb.pixiv.Adapater.AdapterRankingIM;
import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;

public class FragmentHomeIllustrations extends Fragment {

    RecyclerView recyclerView;
    AdapterRankingIM adapterRanking;
    AdapterIlustrationsRecomended adapterRecomended;
    AdapterPopularLives adapterPopularLives;
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


        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
        adapterRanking = new AdapterRankingIM(options);
        adapterRanking.setContext(getContext());
        recyclerView.setAdapter(adapterRanking);


        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_popular_lives);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<ImatgesP> options2 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
                .setQuery(FireBaseHelper.getReferencePopularLives(), ImatgesP.class).build();
        adapterPopularLives = new AdapterPopularLives(options2);
        adapterPopularLives.setContext(getContext());
        recyclerView.setAdapter(adapterPopularLives);


        recyclerView = rootView.findViewById(R.id.recycler_view_illustrations_recommended);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        FirebaseRecyclerOptions<ImatgesP> options3 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
                .setQuery(FireBaseHelper.getReferenceRecommendedIllustrations(), ImatgesP.class).build();
        adapterRecomended = new AdapterIlustrationsRecomended(options3);
        adapterRecomended.setContext(getContext());
        recyclerView.setAdapter(adapterRecomended);

        return rootView;
    }
}