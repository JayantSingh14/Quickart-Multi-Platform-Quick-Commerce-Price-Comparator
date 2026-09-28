package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import kotlin.Metadata;

@Dao
@Metadata
@RestrictTo
/* loaded from: classes.dex */
public interface WorkProgressDao {
    void a(String str);

    void b();

    void c(WorkProgress workProgress);
}
