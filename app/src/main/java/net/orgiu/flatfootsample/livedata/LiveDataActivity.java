package net.orgiu.flatfootsample.livedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toolbar;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveDataActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        setUpToolbar();
    }

    private void setUpToolbar() {
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
