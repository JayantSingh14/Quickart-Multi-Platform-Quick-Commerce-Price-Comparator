package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1 extends Lambda implements Function1<SupportSQLiteDatabase, Object> {
    static {
        new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SupportSQLiteDatabase it = (SupportSQLiteDatabase) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }
}
