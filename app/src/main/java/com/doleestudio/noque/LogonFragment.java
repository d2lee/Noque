package com.doleestudio.noque;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.doleestudio.noque.com.doleestudio.noque.utils.Phone;
import com.doleestudio.noque.data.Rule;


public class LogonFragment extends Fragment {

    public LogonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_logon, container, false);
        setPhoneNumberToPhoneInputText(layout);
        setClickListenerForSubmitButton(layout);

        return layout;
    }

    private void setPhoneNumberToPhoneInputText(View layout) {
        EditText editPhone = (EditText) layout.findViewById(R.id.edit_logon_phone);
        editPhone.setText(Phone.getPhoneNumber(getActivity()));
    }

    public void setClickListenerForSubmitButton(final View layout) {
        Button btnSubmit = (Button) layout.findViewById(R.id.btn_logon_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid(layout)) {
                    createNewUserWithPhone(layout);
                }
            }
        });
    }

    private void createNewUserWithPhone(View layout) {

    }

    private boolean isInputValid(View layout) {
        EditText editPhone = (EditText) layout.findViewById(R.id.edit_logon_phone);
        if (!Rule.isPhoneNumberValid(editPhone.getText().toString())) {
            showErrorMessage(editPhone, R.string.logon_edit_phone_error);
            return false;
        }

        EditText editName = (EditText) layout.findViewById(R.id.edit_logon_user_name);
        if (!Rule.isUserNameValid(editName.getText().toString())) {
            showErrorMessage(editName, R.string.logon_edit_name_error);
            return false;
        }

        EditText editPassword = (EditText) layout.findViewById(R.id.edit_logon_passwd);
        String password = editPassword.getText().toString();

        EditText editRePassword = (EditText) layout.findViewById(R.id.edit_logon_re_passwd);
        String rePassword = editRePassword.getText().toString();

        if (!Rule.isPasswordValid(password)) {
            showErrorMessage(editPassword, R.string.logon_edit_password_error);
            return false;
        }

        if (!password.equals(rePassword)) {
            showErrorMessage(editRePassword, R.string.logon_edit_re_password_error);
            return false;
        }

        return true;
    }

    private void showErrorMessage(EditText editTarget, int resError) {
        editTarget.clearFocus();
        editTarget.requestFocus();
        editTarget.setError(getString(resError));
    }
}
