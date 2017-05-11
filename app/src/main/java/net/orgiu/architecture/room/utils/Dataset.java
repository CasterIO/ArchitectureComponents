package net.orgiu.architecture.room.utils;


import net.orgiu.architecture.room.AndroidDatabase;
import net.orgiu.architecture.room.AndroidVersion;

public class Dataset {

    private static void addAndroidVersion(AndroidDatabase db, String id, String apiLevel, String releaseName) {
        AndroidVersion version = new AndroidVersion();
        version.id = id;
        version.apiLevel = apiLevel;
        version.releaseName = releaseName;

        db.androidDao().insertAndroidVersion(version);
    }

    public static void populateWithTestData(AndroidDatabase db) {
        addAndroidVersion(db, "1.0", "1", "Android (Alpha)");
        addAndroidVersion(db, "1.1", "2", "Beta");
        addAndroidVersion(db, "1.5", "3", "Cupcake");
        addAndroidVersion(db, "1.6", "4", "Donut");
        addAndroidVersion(db, "2.0", "5", "Eclair");
        addAndroidVersion(db, "2.1", "7", "Eclair");
        addAndroidVersion(db, "2.2", "8", "Froyo");
        addAndroidVersion(db, "2.3", "9", "Gingerbread");
        addAndroidVersion(db, "3.0", "11", "Honeycomb");
        addAndroidVersion(db, "4.0", "15", "Ice Cream Sandwich");
        addAndroidVersion(db, "4.1", "16", "Jelly Bean");
        addAndroidVersion(db, "4.2", "17", "Jelly Bean");
        addAndroidVersion(db, "4.3", "18", "Jelly Bean");
        addAndroidVersion(db, "4.4", "19", "KitKat");
        addAndroidVersion(db, "5.0", "21", "Lollipop");
        addAndroidVersion(db, "5.1", "22", "Lollipop");
        addAndroidVersion(db, "6.0", "23", "Marshmallow");
        addAndroidVersion(db, "7.0", "24", "Nougat");
        addAndroidVersion(db, "7.1", "25", "Nougat");
    }
}
