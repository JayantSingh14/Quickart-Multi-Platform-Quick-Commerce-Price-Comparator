package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes4.dex */
final /* synthetic */ class zzeho implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f29354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f29355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzu f29356c;

    public /* synthetic */ zzeho(SQLiteDatabase sQLiteDatabase, String str, com.google.android.gms.ads.internal.util.client.zzu zzuVar) {
        this.f29354a = sQLiteDatabase;
        this.f29355b = str;
        this.f29356c = zzuVar;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() throws Throwable {
        int i2 = zzehu.f29365c;
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        String[] strArr = {this.f29355b};
        SQLiteDatabase sQLiteDatabase = this.f29354a;
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", strArr);
        zzehu.c(sQLiteDatabase, this.f29356c);
    }
}
