package cat.itb.pixiv;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Build;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import cat.itb.pixiv.Adapater.SlideViewAdapter;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHome;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeManga;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeNovels;

public class MainActivity extends AppCompatActivity {
    public static Fragment currentFragment;
    ViewPager viewPager;
    TabLayout tabLayout;
    public static MaterialButton button_illustrations,button_manga, button_novels;

//    public static  SlideViewAdapter slideViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        button_illustrations =findViewById(R.id.top_app_bar_illustrations);
//        button_manga=findViewById(R.id.top_app_bar_manga);
//        button_novels =findViewById(R.id.top_app_bar_novel);

        System.out.println("hola");
        System.out.println("top bar");

        viewPager = findViewById(R.id.slide_view_pager);
        tabLayout=findViewById(R.id.tablayout);
        SlideViewAdapter slideViewAdapter=new SlideViewAdapter(getSupportFragmentManager());
        slideViewAdapter.addFragment(FragmentHomeIllustrations.getInstance(),"Illustrations");
        slideViewAdapter.addFragment(FragmentHomeManga.getInstance(),"Manga");
        slideViewAdapter.addFragment(FragmentHomeNovels.getInstance(),"Novels");
        viewPager.setAdapter(slideViewAdapter);
        tabLayout.setupWithViewPager(viewPager);

//        SlideViewAdapter.setAdapter(new SlideViewAdapter(this));
//        slideViewAdapter=new SlideViewAdapter(MainActivity.this);



//        currentFragment=new FragmentHomeIllustrations();
//        changeFragment(currentFragment);

//
//        button_illustrations.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
////
////                slideViewAdapter.createFragment(0);
////
////                currentFragment=new SlideViewAdapter(this);
////                changeFragment(currentFragment);
//
//            }
//        });
//
//        button_manga.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//
////                slideViewAdapter.createFragment(1);
//
//            }
//        });
//
//        button_novels.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//
////                slideViewAdapter.createFragment(2);
//
//            }
//        });


    }

    private void changeFragment(Fragment currentFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,currentFragment).commit();
    }




}
