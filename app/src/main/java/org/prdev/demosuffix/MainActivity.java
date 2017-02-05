package org.prdev.demosuffix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.prdev.suffix.SuffixEditText;

public class MainActivity extends AppCompatActivity {

    private SuffixEditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText =(SuffixEditText) findViewById(R.id.suffix_edit);
        mEditText.setSuffixText("Suffix");
    }
}
