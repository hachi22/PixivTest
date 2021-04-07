package cat.itb.pixiv.SubmitWorkFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;

import cat.itb.pixiv.Fragments.HomeFragments.HomeFragment;
import cat.itb.pixiv.R;

public class FragmentSubmitNovels extends Fragment {

    Button submit;
    MaterialToolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.submit_work_novels, container, false);

        submit = v.findViewById(R.id.submitNovels);
        toolbar = v.findViewById(R.id.toolbar_subitwork_novels);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}
