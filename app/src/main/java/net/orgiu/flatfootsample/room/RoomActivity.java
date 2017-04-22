package net.orgiu.flatfootsample.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import android.arch.persistence.room.Database;

import net.orgiu.flatfootsample.R;
import net.orgiu.flatfootsample.room.utils.Dataset;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.android_versions_list)
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
        setUpToolbar();

        AndroidDatabase db = AndroidDatabase.inMemoryDatabase(this);
        Dataset.populateWithTestData(db);

        printContentOf(db.androidDao().getAllTheVersions());
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void printContentOf(List<AndroidVersion> allTheVersions) {
        StringBuilder builder = new StringBuilder(allTheVersions.size());

        for (AndroidVersion version : allTheVersions) {
            builder.append(stringify(version));
        }

        output.setText(builder.toString());
    }

    private String stringify(AndroidVersion version) {
        return String.format(Locale.getDefault(), "Android %1$s\t[%2$s]\tAPI %3$s\n", version.id, version.releaseName, version.apiLevel);
    }

}
