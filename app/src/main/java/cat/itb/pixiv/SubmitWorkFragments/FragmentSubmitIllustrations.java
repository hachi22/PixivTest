package cat.itb.pixiv.SubmitWorkFragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import cat.itb.pixiv.Fragments.HomeFragments.HomeFragment;
import cat.itb.pixiv.R;

public class FragmentSubmitIllustrations extends Fragment {

    Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.submit_work_illustrations_manga, container, false);

        submit = v.findViewById(R.id.submitIllustrationManga);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });



        return v;
    }
}
