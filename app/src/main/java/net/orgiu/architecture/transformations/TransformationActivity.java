package net.orgiu.architecture.transformations;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import net.orgiu.architecture.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TransformationActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.inputText)
    EditText input;

    @BindView(R.id.outputText)
    TextView output;

    private final LifecycleRegistry registry = new LifecycleRegistry(this);
    private CalculationViewModel viewModel;
    private final BackToStringLiveData liveData = new BackToStringLiveData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformation);
        ButterKnife.bind(this);
        setupToolbar();

        viewModel = ViewModelProviders.of(this).get(CalculationViewModel.class);

        Transformations.switchMap(viewModel.getCount(), liveData::fromInt)
                .observe(this, output::setText);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }

    @OnClick(R.id.calculateButton)
    public void onCalculateRequested() {
        String name = input.getText().toString();
        viewModel.setName(name);
    }
}
