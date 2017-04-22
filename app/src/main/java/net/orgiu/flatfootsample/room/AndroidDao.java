package net.orgiu.flatfootsample.room;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AndroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAndroidVersion(AndroidVersion version);

    @Query("SELECT * FROM AndroidVersion")
    List<AndroidVersion> getAllTheVersions();
}
