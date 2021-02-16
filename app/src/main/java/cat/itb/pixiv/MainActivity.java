package cat.itb.pixiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cat.itb.pixiv.Fragments.HomeFragments.FragmentHome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("hola");
        System.out.println("top bar");

        FragmentHome fragemnt = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragemnt).commit();

    }
}