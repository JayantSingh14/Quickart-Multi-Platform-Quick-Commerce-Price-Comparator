package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 extends PropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 f11728c = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1("maximumSize", "getMaximumSize()J", SupportSQLiteDatabase.class);

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).h1());
    }
}
