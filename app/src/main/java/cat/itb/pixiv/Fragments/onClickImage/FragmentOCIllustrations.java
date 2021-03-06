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
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentOCIllustrations extends Fragment {
    ImageView image;
    CircleImageView userimage;
    TextView username,title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_o_c_illustrations, container, false);
        image=v.findViewById(R.id.illustratrion_oc_Image);
        userimage=v.findViewById(R.id.illustration_oc_ProfileImage);
        username=v.findViewById(R.id.illustration_text_view_oc_username);
        title=v.findViewById(R.id.illustration_text_view_oc_tittle);
        Bundle arguments=getArguments();
        IllustrationClass ilus=arguments.getParcelable("illustrationRecommended");

        if(ilus!=null){
            setViews(ilus);
        }else if(ilus==null){
          ilus=arguments.getParcelable(  "illustrationRanking");
          setViews(ilus);
        }
        return v;
    }

    private void setViews(IllustrationClass ilustration){
        Picasso.with(getActivity()).load(ilustration.getIllustrationImgUrl()).into(image);
   //         Picasso.with(getActivity()).load(ilustration.getUserImgUrl()).into(userimage);
        username.setText(ilustration.getUserName());
        title.setText(ilustration.getTitle());
    }
}