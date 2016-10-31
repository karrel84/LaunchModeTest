package karrel.com.launchmodetest;

import android.os.Bundle;

public class StandardActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        initButtons();
    }
}
