package com.websarva.wings.android.fragment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private boolean isShowFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        //　表示するフラグメントクラスのインスタンス
        final Fragment fragment = new ButtonFragment();

        // ボタンをクリックしたらフラグメントを表示・非表示
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isShowFragment) {
                    // 表示処理
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.add(R.id.container, fragment);
                    transaction.commit();

                    isShowFragment = true;
                } else {
                    // 非表示処理
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.remove(fragment);
                    transaction.commit();

                    isShowFragment = false;
                }
            }
        });
    }
}