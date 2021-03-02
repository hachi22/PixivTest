package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.itb.pixiv.MainActivity;
import cat.itb.pixiv.R;

public class FragmentHomeNovels extends Fragment {

    public static FragmentHomeNovels getInstance(){
        return new FragmentHomeNovels();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        MainActivity.button_novels.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
//        MainActivity.button_novels.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorPrimary));
     return inflater.inflate(R.layout.fragment_home_novels, container, false);
    }

    @Override
    public void onStop() {

//        MainActivity.button_novels.setTextColor(getActivity().getResources().getColor(R.color.gray));
//        MainActivity.button_novels.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorAccent));
       super.onStop();
    }

}