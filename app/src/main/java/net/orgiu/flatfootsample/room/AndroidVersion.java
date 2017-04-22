package net.orgiu.flatfootsample.room;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class AndroidVersion {

    public @PrimaryKey String id;
    public String apiLevel;
    public String releaseName;

}
