package net.orgiu.flatfootsample.room;


import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {AndroidVersion.class}, version=1)
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
