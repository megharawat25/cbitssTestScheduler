package com.vikaskumar.examschedulercbitss.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.vikaskumar.examschedulercbitss.AdminActivity;
import com.vikaskumar.examschedulercbitss.MainActivity;
import com.vikaskumar.examschedulercbitss.R;
import com.vikaskumar.examschedulercbitss.RegisterActivity;

import java.util.ArrayList;

public class SignInFragment extends Fragment {

    private TextView donTHaveAnAccount;
    private FrameLayout parentLayout;
    FirebaseAuth auth;
    ProgressDialog dialog;
    private TextInputEditText email, password;
    private String emailStr, passStr;
    private Button login, forgotPassword;
    CheckBox student, instructor, scheduler;
    private ArrayList<String> mResult;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signin, container, false);
        donTHaveAnAccount = view.findViewById(R.id.newUserSignUp);
        parentLayout = getActivity().findViewById(R.id.register_framelayput);
        email = view.findViewById(R.id.userSignin);
        password = view.findViewById(R.id.passwordSignin);
        login = view.findViewById(R.id.logIn);
        forgotPassword = view.findViewById(R.id.forgotPassword);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(getContext());

        student = view.findViewById(R.id.check_student);
        instructor = view.findViewById(R.id.check_instructor);
        scheduler = view.findViewById(R.id.check_Scheduler);

        mResult = new ArrayList<>();
        dialog.setMessage("Logging in...");
        dialog.setIcon(R.drawable.backicon);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donTHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());

            }
        });

        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finishAffinity();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkbox();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.onResetPassword = true;
                setFragmentNew(new ForgotFragment());

            }
        });
    }

    private void checkbox()
    {
        if (student.isChecked() && !instructor.isChecked() && !scheduler.isChecked())
        {
            logInUser();
        }
        else if(instructor.isChecked() && !student.isChecked() && !scheduler.isChecked()) {
            startActivity(new Intent(getActivity(), AdminActivity.class));
            getActivity().finish();
        }
        else if(scheduler.isChecked() && !instructor.isChecked() && !student.isChecked()) {
            startActivity(new Intent(getActivity(), AdminActivity.class));
            getActivity().finish();
        }
        else if (student.isChecked() && instructor.isChecked() && scheduler.isChecked())
        {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "Who, Are You", Toast.LENGTH_SHORT).show();
        }
    }

    private void setFragmentNew(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private Boolean validateEmail() {
        String val = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = password.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            password.setError("Password is too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }
    private void logInUser() {
        if (!validateEmail() | !validatePassword()) {
            return;
        }
        emailStr = email.getText().toString().trim();
        passStr = password.getText().toString().trim();
        dialog.show();
        loginUser(emailStr, passStr);
    }
    private void loginUser(String emailStr, String passStr) {
        auth.signInWithEmailAndPassword(emailStr, passStr)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            dialog.dismiss();
                            startActivity(new Intent(getActivity(), MainActivity.class));
                            getActivity().finish();
                        }
                        else {
                            Toast.makeText(getActivity(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {

                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.bottom_animation, R.anim.top_animation);
        fragmentTransaction.replace(parentLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
