package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzgi extends com.google.android.gms.internal.measurement.zzby {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgk f38927a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgi(zzgk zzgkVar, Context context) {
        super(context, "google_app_measurement_local.db");
        Objects.requireNonNull(zzgkVar);
        this.f38927a = zzgkVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e2) {
            throw e2;
        } catch (SQLiteException unused) {
            zzgk zzgkVar = this.f38927a;
            zzib zzibVar = zzgkVar.f39180a;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Opening the local database failed, dropping and recreating it");
            if (!zzibVar.f39084a.getDatabasePath("google_app_measurement_local.db").delete()) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b("google_app_measurement_local.db", "Failed to delete corrupted local db file");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e3) {
                zzgt zzgtVar3 = zzgkVar.f39180a.f39089f;
                zzib.l(zzgtVar3);
                zzgtVar3.f38958f.b(e3, "Failed to open local database. Events will bypass local storage");
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzgt zzgtVar = this.f38927a.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzaw.b(zzgtVar, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String[] strArr = zzgk.f38931e;
        zzgt zzgtVar = this.f38927a.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzaw.a(zzgtVar, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", strArr);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
