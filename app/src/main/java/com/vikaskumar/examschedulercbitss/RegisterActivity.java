package com.vikaskumar.examschedulercbitss;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.vikaskumar.examschedulercbitss.Fragments.SignInFragment;

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    public static boolean onResetPassword = false;

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        frameLayout = findViewById(R.id.register_framelayput);
        setFragment1(new SignInFragment());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (onResetPassword)
            {
                onResetPassword = false;
                setFragment(new SignInFragment());

                return false;
            }
        }
        return super.onKeyDown(keyCode, event);

    }

    private void setFragment1(Fragment fragment) {
        FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.top_animation, R.anim.bottom_animation);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}