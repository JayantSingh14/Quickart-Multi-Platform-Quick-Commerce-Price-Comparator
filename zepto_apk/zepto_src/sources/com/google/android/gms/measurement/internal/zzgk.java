package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/* loaded from: classes.dex */
public final class zzgk extends zzg {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f38931e = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* renamed from: c, reason: collision with root package name */
    public final zzgi f38932c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f38933d;

    public zzgk(zzib zzibVar) {
        super(zzibVar);
        this.f38932c = new zzgi(this, this.f39180a.f39084a);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return false;
    }

    public final void k() {
        int iDelete;
        zzib zzibVar = this.f39180a;
        g();
        try {
            SQLiteDatabase sQLiteDatabaseM = m();
            if (sQLiteDatabaseM == null || (iDelete = sQLiteDatabaseM.delete("messages", null, null)) <= 0) {
                return;
            }
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.b(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0072 A[PHI: r5
      0x0072: PHI (r5v3 int) = (r5v1 int), (r5v1 int), (r5v4 int) binds: [B:28:0x0069, B:34:0x0082, B:31:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.g()
            boolean r1 = r11.f38933d
            r2 = 0
            if (r1 == 0) goto Lc
            goto L9a
        Lc:
            com.google.android.gms.measurement.internal.zzib r1 = r11.f39180a
            android.content.Context r3 = r1.f39084a
            java.lang.String r4 = "google_app_measurement_local.db"
            java.io.File r3 = r3.getDatabasePath(r4)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L9a
            r3 = 5
            r4 = r2
            r5 = r3
        L1f:
            if (r4 >= r3) goto L8e
            r6 = 1
            r7 = 0
            android.database.sqlite.SQLiteDatabase r7 = r11.m()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            if (r7 != 0) goto L33
            r11.f38933d = r6     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            goto L9a
        L2d:
            r0 = move-exception
            goto L88
        L2f:
            r8 = move-exception
            goto L50
        L31:
            r8 = move-exception
            goto L76
        L33:
            r7.beginTransaction()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            java.lang.String r8 = "messages"
            java.lang.String r9 = "type == ?"
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            java.lang.String[] r10 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            r7.delete(r8, r9, r10)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            r7.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            r7.endTransaction()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f android.database.sqlite.SQLiteFullException -> L31 android.database.sqlite.SQLiteDatabaseLockedException -> L6a
            r7.close()
            return r6
        L50:
            if (r7 == 0) goto L5b
            boolean r9 = r7.inTransaction()     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L5b
            r7.endTransaction()     // Catch: java.lang.Throwable -> L2d
        L5b:
            com.google.android.gms.measurement.internal.zzgt r9 = r1.f39089f     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzib.l(r9)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzgr r9 = r9.f38958f     // Catch: java.lang.Throwable -> L2d
            r9.b(r8, r0)     // Catch: java.lang.Throwable -> L2d
            r11.f38933d = r6     // Catch: java.lang.Throwable -> L2d
            if (r7 == 0) goto L85
            goto L72
        L6a:
            long r8 = (long) r5     // Catch: java.lang.Throwable -> L2d
            android.os.SystemClock.sleep(r8)     // Catch: java.lang.Throwable -> L2d
            int r5 = r5 + 20
            if (r7 == 0) goto L85
        L72:
            r7.close()
            goto L85
        L76:
            com.google.android.gms.measurement.internal.zzgt r9 = r1.f39089f     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzib.l(r9)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzgr r9 = r9.f38958f     // Catch: java.lang.Throwable -> L2d
            r9.b(r8, r0)     // Catch: java.lang.Throwable -> L2d
            r11.f38933d = r6     // Catch: java.lang.Throwable -> L2d
            if (r7 == 0) goto L85
            goto L72
        L85:
            int r4 = r4 + 1
            goto L1f
        L88:
            if (r7 == 0) goto L8d
            r7.close()
        L8d:
            throw r0
        L8e:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r0)
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            com.google.android.gms.measurement.internal.zzgr r0 = r0.f38961i
            r0.a(r1)
        L9a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgk.l():boolean");
    }

    public final SQLiteDatabase m() {
        if (this.f38933d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f38932c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f38933d = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[Catch: all -> 0x0091, SQLiteDatabaseLockedException -> 0x0094, SQLiteException -> 0x00ef, SQLiteFullException -> 0x00f3, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0091, blocks: (B:31:0x0086, B:33:0x008c, B:40:0x00a1, B:42:0x00a8, B:44:0x00c5, B:46:0x00d0, B:61:0x00fa, B:75:0x0122, B:77:0x0128, B:78:0x012b, B:93:0x015b, B:85:0x0146), top: B:109:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0122 A[Catch: all -> 0x0091, TRY_ENTER, TryCatch #8 {all -> 0x0091, blocks: (B:31:0x0086, B:33:0x008c, B:40:0x00a1, B:42:0x00a8, B:44:0x00c5, B:46:0x00d0, B:61:0x00fa, B:75:0x0122, B:77:0x0128, B:78:0x012b, B:93:0x015b, B:85:0x0146), top: B:109:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0152 A[PHI: r8 r11 r16
      0x0152: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:81:0x013e, B:96:0x016d, B:89:0x0150] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r11v7 android.database.sqlite.SQLiteDatabase) = 
      (r11v5 android.database.sqlite.SQLiteDatabase)
      (r11v6 android.database.sqlite.SQLiteDatabase)
      (r11v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:81:0x013e, B:96:0x016d, B:89:0x0150] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r16v7 boolean) = (r16v4 boolean), (r16v5 boolean), (r16v8 boolean) binds: [B:81:0x013e, B:96:0x016d, B:89:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgk.n(int, byte[]):boolean");
    }
}
