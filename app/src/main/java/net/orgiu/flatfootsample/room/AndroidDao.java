package net.orgiu.flatfootsample.room;


import com.android.support.room.Insert;
import com.android.support.room.OnConflictStrategy;
import com.android.support.room.Query;

import java.util.List;

public interface AndroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAndroidVersion(AndroidVersion version);

    @Query("SELECT * FROM AndroidVersion")
    List<AndroidVersion> getAllTheVersions();
}
