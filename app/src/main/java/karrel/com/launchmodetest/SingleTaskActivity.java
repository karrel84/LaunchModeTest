package karrel.com.launchmodetest;

import android.os.Bundle;

public class SingleTaskActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        initButtons();
    }
}
