package net.orgiu.flatfootsample.lifecycle;

import android.os.Bundle;
import android.widget.Toolbar;

import android.arch.lifecycle.LifecycleActivity;

import net.orgiu.flatfootsample.R;

public class LifecycleObservingActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_observing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        SimpleLifecycleObserver.bindInto(this);
    }

}
