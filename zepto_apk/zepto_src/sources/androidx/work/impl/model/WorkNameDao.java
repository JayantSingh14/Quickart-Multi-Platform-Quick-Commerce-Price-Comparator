package androidx.work.impl.model;

import androidx.room.Dao;
import java.util.ArrayList;
import kotlin.Metadata;

@Dao
@Metadata
/* loaded from: classes.dex */
public interface WorkNameDao {
    void a(WorkName workName);

    ArrayList b(String str);
}
