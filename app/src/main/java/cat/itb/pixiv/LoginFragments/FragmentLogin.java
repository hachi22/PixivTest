package cat.itb.pixiv.LoginFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.R;

public class FragmentLogin extends Fragment {

    TextView title;
    TextInputLayout loginInput;
    TextInputEditText loginEditText;
    TextInputLayout passwordInput;
    TextInputEditText passwordEditText;
    Button login;
    Button register;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login,container,false);
        title = v.findViewById(R.id.LoginTitle);
        loginInput = v.findViewById(R.id.input_layout_login_username);
        loginEditText = v.findViewById(R.id.input_text_login_username);
        passwordInput = v.findViewById(R.id.input_layout_login_password);
        passwordEditText = v.findViewById(R.id.input_text_login_password);
        login = v.findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginEditText.getText().toString().isEmpty()){
                    loginInput.setError("Empty username");
                } else{
                    loginInput.setError("");
                    if (passwordEditText.getText().toString().isEmpty()){
                        passwordInput.setError("Insert a valid password");
                    } else if(passwordEditText.getText().toString().length()<8) {
                        passwordInput.setError("Insert a valid password");
                    } else {
                        passwordInput.setError("");
                        FragmentManager manager = getFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment_container, new FragmentHomeIllustrations()).commit();
                    }
                }
            }
        });
        register = v.findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, new FragmentRegister()).commit();
            }
        });
        return v;
    }
}
