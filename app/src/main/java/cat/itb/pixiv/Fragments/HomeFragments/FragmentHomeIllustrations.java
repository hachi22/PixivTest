package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import cat.itb.pixiv.MainActivity;
import cat.itb.pixiv.R;

public class FragmentHomeIllustrations extends Fragment {


public static FragmentHomeIllustrations getInstance(){
    return new FragmentHomeIllustrations();
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        MainActivity.button_illustrations.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
//        MainActivity.button_illustrations.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorPrimary));

        return inflater.inflate(R.layout.fragment_home_illustrations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

//    @Override
//    public void onStop() {
//        MainActivity.button_illustrations.setTextColor(getActivity().getResources().getColor(R.color.gray));
//        MainActivity.button_illustrations.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorAccent));
//        super.onStop();
//    }


}