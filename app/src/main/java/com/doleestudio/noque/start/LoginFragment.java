package com.doleestudio.noque.start;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.doleestudio.noque.R;
import com.doleestudio.noque.data.Rule;
import com.doleestudio.noque.user.MainActivity;
import com.doleestudio.noque.util.Phone;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_login, container, false);

        setPhoneNumberToEditText(layout);

        setClickListenerForSubmitButton(layout);

        return layout;
    }

    public void setClickListenerForSubmitButton(final View layout) {
        Button btnSubmit = (Button) layout.findViewById(R.id.login_btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid(layout)) {
                    loginWithPhone(layout);
                }
            }
        });
    }

    private void loginWithPhone(View layout) {
        Activity activity = getActivity();

        Intent intent = new Intent(activity, MainActivity.class);
        clearBackStack(intent);
        activity.startActivity(intent);
    }

    private void clearBackStack(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    private boolean isInputValid(View layout) {
        EditText editPhone = (EditText) layout.findViewById(R.id.login_edit_phone);
        if (!Rule.isPhoneNumberValid(editPhone.getText().toString())) {
            showErrorMessage(editPhone, R.string.logon_error_edit_phone);
            return false;
        }

        EditText editPassword = (EditText) layout.findViewById(R.id.login_edit_passwd);
        String password = editPassword.getText().toString();

        if (!Rule.isPasswordValid(password)) {
            showErrorMessage(editPassword, R.string.logon_error_edit_password);
            return false;
        }

        return true;
    }

    private void showErrorMessage(EditText editTarget, int resError) {
        editTarget.clearFocus();
        editTarget.requestFocus();
        editTarget.setError(getString(resError));
    }

    private void setPhoneNumberToEditText(View layout) {
        EditText editPhone = (EditText) layout.findViewById(R.id.login_edit_phone);
        editPhone.setText(Phone.getPhoneNumber(getActivity()));
    }


}
