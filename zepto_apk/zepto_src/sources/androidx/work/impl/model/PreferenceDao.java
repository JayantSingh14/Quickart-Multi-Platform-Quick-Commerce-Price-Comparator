package androidx.work.impl.model;

import androidx.room.Dao;
import kotlin.Metadata;

@Dao
@Metadata
/* loaded from: classes.dex */
public interface PreferenceDao {
    void a(Preference preference);

    Long b(String str);
}
