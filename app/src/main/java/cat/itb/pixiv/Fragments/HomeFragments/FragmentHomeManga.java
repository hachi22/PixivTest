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

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterMangaRecommended;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterPixivVision;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterRankingIM;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterPixivVision;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterRankingIM;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdaptersMangaRecommended;
import cat.itb.pixiv.ClassesModels.ImatgesIllusMangaRanking;
import cat.itb.pixiv.ClassesModels.ImatgesMangaRecommended;
import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.ClassesModels.ImatgesPixivVision;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;

public class FragmentHomeManga extends Fragment {

    public static FragmentHomeManga getInstance(){
        return new FragmentHomeManga();
    }

    RecyclerView recyclerView;
    AdapterRankingIM adapterRanking;
    AdapterPixivVision adapterPixivVision;
    AdapterMangaRecommended adapterRecommended;
    DatabaseReference myRef;

    NAdapterRankingIM nAdapterRankingIM;
    NAdapterPixivVision nAdapterPixivVision;
    NAdaptersMangaRecommended nAdaptersMangaRecommended;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_manga, container, false);

//        List<ImatgesP> imageslist = new ArrayList<>();
//        imageslist.add(new ImatgesP("title","description","user",R.raw.manga1,2,2,2,R.raw.manga6,R.raw.manga11));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.manga2,2,2,2,R.raw.manga7,R.raw.manga12));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.manga3,2,2,2,R.raw.manga8,R.raw.manga13));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.manga4,2,2,2,R.raw.manga9,R.raw.manga14));
//        imageslist.add(new ImatgesP("title","description","user",R.raw.manga5,2,2,2,R.raw.manga10,R.raw.manga15));

        List<ImatgesIllusMangaRanking>rankinglist=new ArrayList<>();
        rankinglist.add(new ImatgesIllusMangaRanking("FGO","Katarina",R.drawable.perro,R.raw.manga1));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO","Ereshikigal",R.drawable.perro,R.raw.manga2));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO","Ishtar",R.drawable.perro,R.raw.manga3));
        rankinglist.add(new ImatgesIllusMangaRanking("Gotoubun no Hanayome","Bolulu",R.drawable.perro,R.raw.manga4));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO","Persona",R.drawable.perro,R.raw.manga5));

        List<ImatgesPixivVision>pixivVisionslist=new ArrayList<>();
        pixivVisionslist.add(new ImatgesPixivVision("Me, A Genius? I Was Reborn Into Another World And I Think They've Got The Wrong Idea!",R.raw.manga6));
        pixivVisionslist.add(new ImatgesPixivVision("WATARU!!! The Hot-Blooded Fighting Teen & His Epic Adventures After Stopping A Truck With His Bare Hands!",R.raw.manga7));
        pixivVisionslist.add(new ImatgesPixivVision("Do You Love Your Mom And Her Two-Hit Multi-Target Attacks?",R.raw.manga8));
        pixivVisionslist.add(new ImatgesPixivVision("The Hero And His Elf Bride Open A Pizza Parlor In Another World",R.raw.manga9));
        pixivVisionslist.add(new ImatgesPixivVision("Reborn As A Vending Machine, I Now Wander The Dungeon",R.raw.manga10));

        List<ImatgesMangaRecommended>mangaRecommendeds=new ArrayList<>();
        mangaRecommendeds.add(new ImatgesMangaRecommended("Fate","work inspired in king arthur books",R.raw.manga11,20));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Horimiya","Tada Banri is lost at a law school ",R.raw.manga12,2560));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Toradora","This manga focuses on Ryuuji ",R.raw.manga13,2000));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Oregairu","Oregairu is one of the best romcom",R.raw.manga14,1230));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Nisekoi","This anime focuses on Raku Ichijou",R.raw.manga15,40));


//        recyclerView = rootView.findViewById(R.id.recycler_view_manga_ranking);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRanking(), ImatgesP.class).build();
//        adapterRanking = new AdapterRankingIM(options);
//        adapterRanking.setContext(getContext());
//        recyclerView.setAdapter(adapterRanking);

        recyclerView = rootView.findViewById(R.id.recycler_view_manga_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdapterRankingIM = new NAdapterRankingIM(rankinglist);
        recyclerView.setAdapter(nAdapterRankingIM);


//        recyclerView = rootView.findViewById(R.id.recycler_view_manga_pixi_vision);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        FirebaseRecyclerOptions<ImatgesP> options2 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferencePixivVision(), ImatgesP.class).build();
//        adapterPixivVision = new AdapterPixivVision(options2);
//        adapterPixivVision.setContext(getContext());
//        recyclerView.setAdapter(adapterPixivVision);

        recyclerView = rootView.findViewById(R.id.recycler_view_manga_pixi_vision);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        nAdapterPixivVision = new NAdapterPixivVision(pixivVisionslist);
        recyclerView.setAdapter(nAdapterPixivVision);

//        recyclerView = rootView.findViewById(R.id.recycler_view_manga_mangas);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
//        FirebaseRecyclerOptions<ImatgesP> options3 = new FirebaseRecyclerOptions.Builder<ImatgesP>()
//                .setQuery(FireBaseHelper.getReferenceRecommendedManga(), ImatgesP.class).build();
//        adapterRecommended = new AdapterMangaRecommended(options3);
//        adapterRecommended.setContext(getContext());
//        recyclerView.setAdapter(adapterRecommended);

        recyclerView = rootView.findViewById(R.id.recycler_view_manga_mangas);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        nAdaptersMangaRecommended = new NAdaptersMangaRecommended(mangaRecommendeds);
        recyclerView.setAdapter(nAdaptersMangaRecommended);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, (mangaRecommendeds.size()+1)/2*1350);
        recyclerView.setLayoutParams(param);
        
        return rootView;
    }


}