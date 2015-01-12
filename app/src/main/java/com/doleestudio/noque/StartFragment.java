package com.doleestudio.noque;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {


    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_start, container, false);

        setClickHandlerForLogon(layout);
        setClickHandlerForLogin(layout);

        return layout;
    }

    private void setClickHandlerForLogin(View layout) {
        Button btnLogin = (Button) layout.findViewById(R.id.btn_start_existing_user);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new LoginFragment());
            }
        });
    }

    private void openFragment(android.support.v4.app.Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.start_container, fragment).addToBackStack(null).commit();
    }

    private void setClickHandlerForLogon(View layout) {
        Button btnLogin = (Button) layout.findViewById(R.id.btn_start_new_user);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new LogonFragment());
            }
        });
    }

}
