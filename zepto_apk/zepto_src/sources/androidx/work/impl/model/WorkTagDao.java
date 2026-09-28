package androidx.work.impl.model;

import androidx.room.Dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Dao
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public interface WorkTagDao {

    @Metadata
    public static final class DefaultImpls {
    }

    ArrayList a(String str);

    void b(WorkTag workTag);

    default void c(String id, LinkedHashSet tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            b(new WorkTag((String) it.next(), id));
        }
    }
}
