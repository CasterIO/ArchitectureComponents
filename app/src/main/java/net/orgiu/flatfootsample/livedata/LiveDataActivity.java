package net.orgiu.flatfootsample.livedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.support.lifecycle.LiveData;
import com.android.support.lifecycle.Observer;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiveDataActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    LiveData<Integer> counterLD = new LiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        setUpToolbar();

        subscribeToLiveData();
    }

    private void setUpToolbar() {
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void subscribeToLiveData() {
        final Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer newValue) {
                counter.setText(String.valueOf(newValue));
            }
        };

        counterLD.observe(observer);
        counterLD.setValue(0);
    }

    @OnClick(R.id.fab)
    public void onPlusOneClicked() {
        Integer currentValue = counterLD.getValue();
        counterLD.setValue(currentValue +1);
    }
}
