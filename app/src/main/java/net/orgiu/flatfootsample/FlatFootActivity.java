package net.orgiu.flatfootsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.orgiu.flatfootsample.lifecycle.LifecycleObservingActivity;
import net.orgiu.flatfootsample.livedata.LiveDataActivity;
import net.orgiu.flatfootsample.room.RoomActivity;
import net.orgiu.flatfootsample.viewmodel.ViewModelActivity;
import net.orgiu.flatfootsample.vm_livedata.ViewModelLiveDataActivity;

public class FlatFootActivity extends AppCompatActivity {

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
}
