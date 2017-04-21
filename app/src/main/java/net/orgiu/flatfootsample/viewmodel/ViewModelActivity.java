package net.orgiu.flatfootsample.viewmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        ButterKnife.bind(this);
        setUpToolbar();

        i = 0;
        updateCounterValue(i);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.fab)
    public void onPlusOneClicked() {
        updateCounterValue(i++);
    }

    private void updateCounterValue(int value) {
        counter.setText(String.valueOf(value));
    }

}
