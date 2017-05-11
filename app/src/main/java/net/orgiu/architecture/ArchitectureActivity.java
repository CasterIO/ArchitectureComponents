package net.orgiu.architecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.orgiu.architecture.lifecycle.LifecycleObservingActivity;
import net.orgiu.architecture.livedata.LiveDataActivity;
import net.orgiu.architecture.room.RoomActivity;
import net.orgiu.architecture.transformations.TransformationActivity;
import net.orgiu.architecture.viewmodel.ViewModelActivity;
import net.orgiu.architecture.vm_livedata.ViewModelLiveDataActivity;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_foot);
    }

    public void onViewModelRequested(View v) {
        startActivity(new Intent(this, ViewModelActivity.class));
    }

    public void onLiveDataRequested(View v) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }

    public void onViewModelLiveDataRequested(View v) {
        startActivity(new Intent(this, ViewModelLiveDataActivity.class));
    }

    public void onLifecycleObservingActivityRequested(View v) {
        startActivity(new Intent(this, LifecycleObservingActivity.class));
    }

    public void onRoomActivityRequested(View v) {
        startActivity(new Intent(this, RoomActivity.class));
    }

    public void onAdvancedLiveDataRequested(View v) {
        startActivity(new Intent(this, TransformationActivity.class));
    }
}
