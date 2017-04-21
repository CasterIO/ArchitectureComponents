package net.orgiu.flatfootsample.room;


import com.android.support.room.Entity;
import com.android.support.room.PrimaryKey;

@Entity
public class AndroidVersion {

    public @PrimaryKey String id;
    public String apiLevel;
    public String releaseName;

}
