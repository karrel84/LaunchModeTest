package karrel.com.launchmodetest;

import android.os.Bundle;

public class SingleInstanceActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);

        initButtons();
    }
}
