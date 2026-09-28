package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import kotlin.Metadata;

@TypeConverters
@Metadata
@Database
@RestrictTo
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {

    @Metadata
    public static final class Companion {
    }

    public abstract DependencyDao q();

    public abstract PreferenceDao r();

    public abstract SystemIdInfoDao s();

    public abstract WorkNameDao t();

    public abstract WorkProgressDao u();

    public abstract WorkSpecDao v();

    public abstract WorkTagDao w();
}
