package androidx.work.impl.model;

import androidx.room.Dao;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Dao
@Metadata
/* loaded from: classes.dex */
public interface SystemIdInfoDao {

    @Metadata
    public static final class DefaultImpls {
    }

    SystemIdInfo b(int i2, String str);

    default SystemIdInfo c(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return b(id.f12894b, id.f12893a);
    }

    default void e(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        h(id.f12894b, id.f12893a);
    }

    ArrayList f();

    void g(SystemIdInfo systemIdInfo);

    void h(int i2, String str);

    void i(String str);
}
