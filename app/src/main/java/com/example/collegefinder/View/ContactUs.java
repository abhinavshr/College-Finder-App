package com.example.collegefinder.View;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.collegefinder.Model.ContactUsModel;
import com.example.collegefinder.R;
import com.example.collegefinder.Utilities.ContactApi;

public class ContactUs extends Fragment implements View.OnClickListener {

    private EditText etFirstName, etLastName, etEmailAddress, etPhoneNumber, etDescription;
    private Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        etFirstName = view.findViewById(R.id.etFirstName);
        etLastName = view.findViewById(R.id.etLastName);
        etEmailAddress = view.findViewById(R.id.etEmailAddress);
        etPhoneNumber = view.findViewById(R.id.etPhoneNumber);
        etDescription = view.findViewById(R.id.etDescription);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            registerContact();
        }
    }

    private void registerContact() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String emailAddress = etEmailAddress.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (validateInput(firstName, lastName, emailAddress, phoneNumber, description)) {
            ContactUsModel contactUsModel = new ContactUsModel(firstName, lastName, emailAddress, phoneNumber, description);
            ContactApi contactApi = new ContactApi();
            contactApi.registerContact(contactUsModel);
            showSuccessToast("Data saved successfully!");
        }
    }

    private boolean validateInput(String firstName, String lastName, String emailAddress, String phoneNumber, String description) {
        // You can add your validation logic here
        // For example, checking if any of the fields are empty
        if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || phoneNumber.isEmpty() || description.isEmpty()) {
            showToast("Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void showSuccessToast(String message) {
        showToast(message);
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
