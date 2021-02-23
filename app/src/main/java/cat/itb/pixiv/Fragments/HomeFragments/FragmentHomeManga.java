package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.itb.pixiv.MainActivity;
import cat.itb.pixiv.R;

public class FragmentHomeManga extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainActivity.button_manga.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorPrimary));
        MainActivity.button_manga.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
        return inflater.inflate(R.layout.fragment_home_manga, container, false);
    }

    @Override
    public void onStop() {
        MainActivity.button_manga.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.colorAccent));
        MainActivity.button_manga.setTextColor(getActivity().getResources().getColor(R.color.gray));
        super.onStop();
    }
}