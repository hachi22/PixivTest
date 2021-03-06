package cat.itb.pixiv.Fragments.onClickImage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.MangaClass;
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentOCManga extends Fragment {
    ImageView image;
    CircleImageView userimage;
    TextView title,username,description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_o_c_manga, container, false);
        image=v.findViewById(R.id.manga_oc_Image);
        userimage=v.findViewById(R.id.manga_oc_ProfileImage);
        title=v.findViewById(R.id.manga_text_view_oc_tittle);
        username=v.findViewById(R.id.manga_text_view_oc_username);
        description=v.findViewById(R.id.manga_text_view_oc_description);
        Bundle arguments=getArguments();
        MangaClass manga =arguments.getParcelable("mangaRecomended");
        if(manga!=null){
            setManga(manga);
        }else if(manga==null){
            manga=arguments.getParcelable("mangaranking");
            setManga(manga);
        }

        return v;
    }

    private void setManga(MangaClass manga){
        Picasso.with(getActivity()).load(manga.getMangaImgUrl()).into(image);
         //Picasso.with(getActivity()).load(manga.getUserImgUrl()).into(userimage);
        username.setText(manga.getUserName());
        title.setText(manga.getTitle());
        description.setText(manga.getDescription());
    }
}