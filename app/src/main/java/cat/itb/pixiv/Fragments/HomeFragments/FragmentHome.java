package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.itb.pixiv.Adapater.SlideViewAdapter;
import cat.itb.pixiv.R;

public class FragmentHome extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager2 SlideViewAdapter = rootView.findViewById(R.id.slide_view_pager);
        SlideViewAdapter.setAdapter(new SlideViewAdapter(getActivity()));

        return rootView;
    }
}