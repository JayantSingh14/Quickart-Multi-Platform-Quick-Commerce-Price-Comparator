package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    /* renamed from: b, reason: collision with root package name */
    public DatabaseConfiguration f11827b;

    /* renamed from: c, reason: collision with root package name */
    public final Delegate f11828c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11829d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11830e;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    @RestrictTo
    public static abstract class Delegate {

        /* renamed from: a, reason: collision with root package name */
        public final int f11831a;

        public Delegate(int i2) {
            this.f11831a = i2;
        }

        public abstract void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public void e(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void f(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public ValidationResult g(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(db, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @Metadata
    @RestrictTo
    /* loaded from: classes3.dex */
    public static class ValidationResult {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f11832a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11833b;

        public ValidationResult(String str, boolean z) {
            this.f11832a = z;
            this.f11833b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String identityHash, String legacyHash) {
        super(delegate.f11831a);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(identityHash, "identityHash");
        Intrinsics.checkNotNullParameter(legacyHash, "legacyHash");
        this.f11827b = configuration;
        this.f11828c = delegate;
        this.f11829d = identityHash;
        this.f11830e = legacyHash;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void b(FrameworkSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.b(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void c(FrameworkSQLiteDatabase db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(db, "db");
        Cursor cursorA = db.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            Cursor cursor = cursorA;
            boolean z = false;
            if (cursor.moveToFirst()) {
                if (cursor.getInt(0) == 0) {
                    z = true;
                }
            }
            CloseableKt.a(cursorA, null);
            Delegate delegate = this.f11828c;
            delegate.a(db);
            if (!z) {
                ValidationResult validationResultG = delegate.g(db);
                if (!validationResultG.f11832a) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultG.f11833b);
                }
            }
            g(db);
            delegate.c(db);
        } finally {
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void d(FrameworkSQLiteDatabase db, int i2, int i3) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        f(db, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r7) throws android.database.SQLException {
        /*
            r6 = this;
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            super.e(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r7.a(r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch: java.lang.Throwable -> L25
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L25
            r3 = 0
            if (r2 == 0) goto L28
            int r1 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto L28
            r1 = 1
            goto L29
        L25:
            r7 = move-exception
            goto La1
        L28:
            r1 = r3
        L29:
            r2 = 0
            kotlin.io.CloseableKt.a(r0, r2)
            androidx.room.RoomOpenHelper$Delegate r0 = r6.f11828c
            if (r1 == 0) goto L77
            androidx.sqlite.db.SimpleSQLiteQuery r1 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r4)
            android.database.Cursor r1 = r7.m0(r1)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r4 = r1
            android.database.Cursor r4 = (android.database.Cursor) r4     // Catch: java.lang.Throwable -> L4c
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L4e
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r7 = move-exception
            goto L71
        L4e:
            r3 = r2
        L4f:
            kotlin.io.CloseableKt.a(r1, r2)
            java.lang.String r1 = r6.f11829d
            boolean r4 = r1.equals(r3)
            if (r4 != 0) goto L85
            java.lang.String r4 = r6.f11830e
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L63
            goto L85
        L63:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            java.lang.String r2 = ", found: "
            java.lang.String r0 = androidx.fragment.app.e.p(r0, r1, r2, r3)
            r7.<init>(r0)
            throw r7
        L71:
            throw r7     // Catch: java.lang.Throwable -> L72
        L72:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r1, r7)
            throw r0
        L77:
            androidx.room.RoomOpenHelper$ValidationResult r1 = r0.g(r7)
            boolean r3 = r1.f11832a
            if (r3 == 0) goto L8b
            r0.e(r7)
            r6.g(r7)
        L85:
            r0.d(r7)
            r6.f11827b = r2
            return
        L8b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.f11833b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        La1:
            throw r7     // Catch: java.lang.Throwable -> La2
        La2:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.e(androidx.sqlite.db.framework.FrameworkSQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0084 A[EDGE_INSN: B:73:0x0084->B:37:0x0084 BREAK  A[LOOP:1: B:12:0x0023->B:76:?], SYNTHETIC] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r13, int r14, int r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.f(androidx.sqlite.db.framework.FrameworkSQLiteDatabase, int, int):void");
    }

    public final void g(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String hash = this.f11829d;
        Intrinsics.checkNotNullParameter(hash, "hash");
        frameworkSQLiteDatabase.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')");
    }
}
