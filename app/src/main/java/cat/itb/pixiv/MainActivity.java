package cat.itb.pixiv;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

import cat.itb.pixiv.Fragments.HomeFragments.FragmentHome;

public class MainActivity extends AppCompatActivity {
    MaterialButton button_illustrations,button_manga, button_novels;


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
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragemnt).commit();

//        button_illustrations.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//                button_illustrations.setTextColor(R.color.colorAccent);
//                button_manga.setTextColor(R.color.gray);
//                button_novels.setTextColor(R.color.gray);
//                button_illustrations.setBackgroundColor(R.color.colorPrimary);
//                button_novels.setBackgroundColor(R.color.colorAccent);
//                button_manga.setBackgroundColor(R.color.colorAccent);
//
//
//            }
//        });
//
//        button_manga.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//                button_illustrations.setTextColor(R.color.gray);
//                button_manga.setTextColor(R.color.colorAccent);
//                button_novels.setTextColor(R.color.gray);
//                button_illustrations.setBackgroundColor(R.color.colorAccent);
//                button_novels.setBackgroundColor(R.color.colorAccent);
//                button_manga.setBackgroundColor(R.color.colorPrimary);
//
//            }
//        });
//
//        button_novels.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//                button_manga.setTextColor(R.color.gray);
//                button_illustrations.setTextColor(R.color.gray);
//                button_novels.setTextColor(R.color.colorAccent);
//                button_illustrations.setBackgroundColor(R.color.colorAccent);
//                button_manga.setBackgroundColor(R.color.colorAccent);
//                button_novels.setBackgroundColor(R.color.colorPrimary);
//
//            }
//        });

    }
}