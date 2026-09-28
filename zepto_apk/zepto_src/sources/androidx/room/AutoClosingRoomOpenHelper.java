package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void C(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean E1() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean F() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void H1(long j2) {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void L0(int i2) {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final SupportSQLiteStatement N0(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final int N1(ContentValues values, Object[] objArr) {
            Intrinsics.checkNotNullParameter("WorkSpec", "table");
            Intrinsics.checkNotNullParameter(values, "values");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long P() {
            AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.f11729c;
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void S() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void U() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean Y0() {
            throw null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean d0() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void e0() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void f1(Object[] bindArgs) {
            Intrinsics.checkNotNullParameter("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", "sql");
            Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final int getVersion() {
            AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.f11731c;
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long h1() {
            AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.f11728c;
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final String j() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final Cursor m0(SupportSQLiteQuery supportSQLiteQuery) {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean n1() {
            AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.f11732b;
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void w() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final List z() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean z1() {
            throw null;
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public final long F0() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public final int H() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public final void J(int i2, double d2) {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public final long J0() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public final String a0() {
            throw null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public final void d() {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public final void e1(int i2, long j2) {
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public final void i1(int i2, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public final void m(int i2, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public final void y1(int i2) {
            throw null;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class KeepAliveCursor implements Cursor, AutoCloseable {
        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // android.database.Cursor
        public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
            throw null;
        }

        @Override // android.database.Cursor
        public final void deactivate() {
            throw null;
        }

        @Override // android.database.Cursor
        public final byte[] getBlob(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getColumnCount() {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getColumnIndex(String str) {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getColumnIndexOrThrow(String str) {
            throw null;
        }

        @Override // android.database.Cursor
        public final String getColumnName(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final String[] getColumnNames() {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getCount() {
            throw null;
        }

        @Override // android.database.Cursor
        public final double getDouble(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final Bundle getExtras() {
            throw null;
        }

        @Override // android.database.Cursor
        public final float getFloat(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getInt(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final long getLong(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final Uri getNotificationUri() {
            Intrinsics.checkNotNullParameter(null, "cursor");
            throw null;
        }

        @Override // android.database.Cursor
        public final List getNotificationUris() {
            SupportSQLiteCompat.Api29Impl.a(null);
            throw null;
        }

        @Override // android.database.Cursor
        public final int getPosition() {
            throw null;
        }

        @Override // android.database.Cursor
        public final short getShort(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final String getString(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final int getType(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean getWantsAllOnMoveCalls() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isAfterLast() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isBeforeFirst() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isClosed() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isFirst() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isLast() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean isNull(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean move(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean moveToFirst() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean moveToLast() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean moveToNext() {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean moveToPosition(int i2) {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean moveToPrevious() {
            throw null;
        }

        @Override // android.database.Cursor
        public final void registerContentObserver(ContentObserver contentObserver) {
            throw null;
        }

        @Override // android.database.Cursor
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            throw null;
        }

        @Override // android.database.Cursor
        public final boolean requery() {
            throw null;
        }

        @Override // android.database.Cursor
        public final Bundle respond(Bundle bundle) {
            throw null;
        }

        @Override // android.database.Cursor
        public final void setExtras(Bundle extras) {
            Intrinsics.checkNotNullParameter(extras, "extras");
            Intrinsics.checkNotNullParameter(null, "cursor");
            Intrinsics.checkNotNullParameter(extras, "extras");
            throw null;
        }

        @Override // android.database.Cursor
        public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            throw null;
        }

        @Override // android.database.Cursor
        public final void setNotificationUris(ContentResolver cr, List uris) {
            Intrinsics.checkNotNullParameter(cr, "cr");
            Intrinsics.checkNotNullParameter(uris, "uris");
            SupportSQLiteCompat.Api29Impl.b(null, cr, uris);
            throw null;
        }

        @Override // android.database.Cursor
        public final void unregisterContentObserver(ContentObserver contentObserver) {
            throw null;
        }

        @Override // android.database.Cursor
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            throw null;
        }
    }

    @Override // androidx.room.DelegatingOpenHelper
    public final SupportSQLiteOpenHelper a() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase m1() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        throw null;
    }
}
