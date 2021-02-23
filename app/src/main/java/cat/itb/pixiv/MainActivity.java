package cat.itb.pixiv;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Build;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.button.MaterialButton;

import cat.itb.pixiv.Adapater.SlideViewAdapter;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHome;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeManga;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeNovels;

public class MainActivity extends AppCompatActivity {
    public static Fragment currentFragment;
    public static MaterialButton button_illustrations,button_manga, button_novels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_illustrations =findViewById(R.id.top_app_bar_illustrations);
        button_manga=findViewById(R.id.top_app_bar_manga);
        button_novels =findViewById(R.id.top_app_bar_novel);

        System.out.println("hola");
        System.out.println("top bar");




        FragmentHome fragemnt = new FragmentHome();
        currentFragment=new FragmentHomeIllustrations();
        changeFragment(currentFragment);


        button_illustrations.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                currentFragment=new FragmentHomeIllustrations();
                changeFragment(currentFragment);

            }
        });

        button_manga.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                currentFragment=new FragmentHomeManga();
                changeFragment(currentFragment);

            }
        });

        button_novels.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                currentFragment=new FragmentHomeNovels();
                changeFragment(currentFragment);

            }
        });


    }

    private void changeFragment(Fragment currentFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,currentFragment).commit();
    }




}
