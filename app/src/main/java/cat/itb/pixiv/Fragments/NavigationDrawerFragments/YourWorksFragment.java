package cat.itb.pixiv.Fragments.NavigationDrawerFragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterMangaRecommended;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterYourWorksIllustrations;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterYourWorksManga;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterYourWorksNovels;
import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.MangaClass;
import cat.itb.pixiv.ClassesModels.NovelClass;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.HomeFragment;
import cat.itb.pixiv.R;

public class YourWorksFragment extends Fragment {

    TabLayout tabs;
    MaterialToolbar topToolBar;

    int submitWorkSegunRecycler;

    MaterialButton buttonAddWorks;

    RecyclerView recyclerView;
    AdapterYourWorksIllustrations adapterYourWorksIllustrations;
    AdapterYourWorksManga adapterYourWorksManga;
    AdapterYourWorksNovels adapterYourWorksNovels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_your_works, container, false);

        tabs =  rootView.findViewById(R.id.tablayout_my_works);
        topToolBar = rootView.findViewById(R.id.top_appbar_my_works);
        recyclerView = rootView.findViewById(R.id.recycler_view_your_works_general);
        buttonAddWorks = rootView.findViewById(R.id.button_submit_work);

        tabs.addTab(tabs.newTab().setText("Illustrations"));
        tabs.addTab(tabs.newTab().setText("Manga"));
        tabs.addTab(tabs.newTab().setText("Novels"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<IllustrationClass> options = new FirebaseRecyclerOptions.Builder<IllustrationClass>()
                .setQuery(FireBaseHelper.getReferenceRanking(), IllustrationClass.class).build();
        adapterYourWorksIllustrations = new AdapterYourWorksIllustrations(options);
        adapterYourWorksIllustrations.setContext(getContext());
        recyclerView.setAdapter(adapterYourWorksIllustrations);
        submitWorkSegunRecycler =1;

        tabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numbut = tabs.getSelectedTabPosition();
                if(numbut==1){

                    FirebaseRecyclerOptions<IllustrationClass> options = new FirebaseRecyclerOptions.Builder<IllustrationClass>()
                            .setQuery(FireBaseHelper.getReferenceRanking(), IllustrationClass.class).build();
                    adapterYourWorksIllustrations = new AdapterYourWorksIllustrations(options);
                    adapterYourWorksIllustrations.setContext(getContext());
                    recyclerView.setAdapter(adapterYourWorksIllustrations);
                    submitWorkSegunRecycler =1;

                }else if(numbut==2){

                    FirebaseRecyclerOptions<MangaClass> options = new FirebaseRecyclerOptions.Builder<MangaClass>()
                            .setQuery(FireBaseHelper.getReferenceRanking(), MangaClass.class).build();
                    adapterYourWorksManga = new AdapterYourWorksManga(options);
                    adapterYourWorksManga.setContext(getContext());
                    recyclerView.setAdapter(adapterYourWorksManga);
                    submitWorkSegunRecycler =2;
                }else{

                    FirebaseRecyclerOptions<NovelClass> options = new FirebaseRecyclerOptions.Builder<NovelClass>()
                            .setQuery(FireBaseHelper.getReferenceRanking(), NovelClass.class).build();
                    adapterYourWorksNovels = new AdapterYourWorksNovels(options);
                    adapterYourWorksNovels.setContext(getContext());
                    recyclerView.setAdapter(adapterYourWorksNovels);
                    submitWorkSegunRecycler =3;
                }
            }
        });


        topToolBar.setNavigationIcon(R.drawable.ic_arrow_back);
        topToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

            }
        });

        buttonAddWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (submitWorkSegunRecycler){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });


        return rootView;
    }

}