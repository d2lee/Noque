package com.doleestudio.noque.start;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.doleestudio.noque.R;
import com.doleestudio.noque.data.Rule;
import com.doleestudio.noque.util.Phone;


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
        EditText editPhone = (EditText) layout.findViewById(R.id.logon_edit_phone);
        editPhone.setText(Phone.getPhoneNumber(getActivity()));
    }

    public void setClickListenerForSubmitButton(final View layout) {
        Button btnSubmit = (Button) layout.findViewById(R.id.logon_btn_submit);

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
        EditText editPhone = (EditText) layout.findViewById(R.id.logon_edit_phone);
        if (!Rule.isPhoneNumberValid(editPhone.getText().toString())) {
            showErrorMessage(editPhone, R.string.logon_error_edit_phone);
            return false;
        }

        EditText editName = (EditText) layout.findViewById(R.id.logon_edit_user_name);
        if (!Rule.isUserNameValid(editName.getText().toString())) {
            showErrorMessage(editName, R.string.logon_error_edit_name);
            return false;
        }

        EditText editPassword = (EditText) layout.findViewById(R.id.logon_edit_passwd);
        String password = editPassword.getText().toString();

        EditText editRePassword = (EditText) layout.findViewById(R.id.logon_edit_re_passwd);
        String rePassword = editRePassword.getText().toString();

        if (!Rule.isPasswordValid(password)) {
            showErrorMessage(editPassword, R.string.logon_error_edit_password);
            return false;
        }

        if (!password.equals(rePassword)) {
            showErrorMessage(editRePassword, R.string.logon_error_re_password);
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
