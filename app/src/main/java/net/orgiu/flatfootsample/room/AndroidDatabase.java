package net.orgiu.flatfootsample.room;


import android.content.Context;

import com.android.support.room.Database;
import com.android.support.room.Room;
import com.android.support.room.RoomDatabase;

@Database(entities = {AndroidVersion.class})
public abstract class AndroidDatabase extends RoomDatabase {

    private static AndroidDatabase INSTANCE;

    public abstract AndroidDao androidDao();

    public static AndroidDatabase inMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context, AndroidDatabase.class).build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
