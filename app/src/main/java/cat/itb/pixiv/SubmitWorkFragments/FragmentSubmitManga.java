package cat.itb.pixiv.SubmitWorkFragments;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;

import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.MangaClass;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.Fragments.HomeFragments.HomeFragment;
import cat.itb.pixiv.R;

public class FragmentSubmitManga extends Fragment {

    Button submit;
    ImageView imgRef;
    MaterialToolbar toolbar;
    FireBaseHelper fireBaseHelper;
    Button editImage;
    Button deleteImage;
    Bitmap thumb_bitmap;
    File url;
    TextInputEditText title;
    TextInputEditText description;
    RadioGroup radioGroup;
    MangaClass mangaClass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.submit_work_illustrations_manga, container, false);

        submit = v.findViewById(R.id.submitIllustrationManga);
        toolbar = v.findViewById(R.id.toolbar_sumitwork_illustrations);
        imgRef = v.findViewById(R.id.image_view_image_submit);
        editImage = v.findViewById(R.id.button_edit_image);
        title = v.findViewById(R.id.edit_text_title_submit_illustration);
        description = v.findViewById(R.id.edit_description_title_submit_illustration);
        radioGroup = v.findViewById(R.id.group_radio_button_submit_illustrations);

        editImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgRef.setImageResource(R.drawable.marc_submitwork);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fireBaseHelper.subirMyWork(mangaClass, bundle());

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });



        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new cat.itb.pixiv.Fragments.HomeFragment()).commit();
            }});



        return v;
    }

    private String bundle(){
        String key = (title.getText().toString() + description.getText().toString() + url);

        return key;
    }
}
