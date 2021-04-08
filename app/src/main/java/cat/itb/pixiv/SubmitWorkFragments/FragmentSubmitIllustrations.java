package cat.itb.pixiv.SubmitWorkFragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;

import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.Fragments.HomeFragments.HomeFragment;
import cat.itb.pixiv.R;

import static android.app.Activity.RESULT_OK;

public class FragmentSubmitIllustrations extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 100;
    private static final int RESULT_OK = 200;
    Button submit;
    ImageView imgRef;
    MaterialToolbar toolbar;
    FireBaseHelper fireBaseHelper;
    Button editImage;
    Button deleteImage;
    File url;
    TextInputEditText title;
    TextInputEditText description;
    RadioGroup radioGroup;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.submit_work_illustrations_manga, container, false);

        submit = v.findViewById(R.id.submitIllustrationManga);
        toolbar = v.findViewById(R.id.toolbar_sumitwork_illustrations);
        imgRef = v.findViewById(R.id.image_view_image_submit);
        editImage = v.findViewById(R.id.button_edit_image);
        deleteImage = v.findViewById(R.id.button_delete_image);
        title = v.findViewById(R.id.edit_text_title_submit_illustration);
        description = v.findViewById(R.id.edit_description_title_submit_illustration);
        radioGroup = v.findViewById(R.id.group_radio_button_submit_illustrations);

        editImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CropImage.startPickImageActivity(getContext(), FragmentSubmitIllustrations.this);
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

                FireBaseHelper.subirMyWork(new IllustrationClass( title.getText().toString(), description.getText().toString(), FireBaseHelper.getUrlImage(), "Miquel", FireBaseHelper.getDefaultUserImage()));

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE);
        System.out.println(requestCode);
        if(requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && requestCode == RESULT_OK){
            Uri imageUri = CropImage.getPickImageResultUri(getContext(),data);
            recortarImagen(imageUri);

            System.out.println("1");

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            Uri resultUri = result.getUri();
            url = new File(resultUri.getPath());
            Picasso.with(getContext()).load(url).into(imgRef);

            System.out.println("2");

        }
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            Uri imageUri = CropImage.getPickImageResultUri(getContext(),data);
            recortarImagen(imageUri);

            System.out.println("3");
        }

        System.out.println("fuera");
    }

    public void recortarImagen(Uri imageUri){
        CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)
                .setRequestedSize(480,480)
                .start(getContext(),FragmentSubmitIllustrations.this);
    }

    private String bundle(){
        String key = (title.getText().toString() + description.getText().toString() + url);

        return key;
    }
}
