package cat.itb.pixiv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;




import android.os.Bundle;




import com.google.android.material.tabs.TabLayout;

import cat.itb.pixiv.Adapater.SlideViewAdapter;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeManga;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeNovels;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
