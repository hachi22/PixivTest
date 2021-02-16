package cat.itb.pixiv.Adapater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeManga;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeNovels;

public class SlideViewAdapter extends FragmentStateAdapter {

    public SlideViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentHomeIllustrations();
            case 1:
                return new FragmentHomeManga();
            default:
                return new FragmentHomeNovels();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
