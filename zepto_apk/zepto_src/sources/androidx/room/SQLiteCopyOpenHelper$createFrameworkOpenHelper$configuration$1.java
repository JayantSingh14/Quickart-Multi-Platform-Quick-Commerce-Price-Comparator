package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1 extends SupportSQLiteOpenHelper.Callback {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void c(FrameworkSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void e(FrameworkSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.L0(0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void f(FrameworkSQLiteDatabase db, int i2, int i3) {
        Intrinsics.checkNotNullParameter(db, "db");
    }
}
