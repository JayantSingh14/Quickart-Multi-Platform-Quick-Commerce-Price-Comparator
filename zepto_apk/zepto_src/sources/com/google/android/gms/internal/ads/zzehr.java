package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzehr implements zzflu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzehu f29361a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzehw f29362b;

    public /* synthetic */ zzehr(zzehu zzehuVar, zzehw zzehwVar) {
        this.f29361a = zzehuVar;
        this.f29362b = zzehwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzflu
    public final Object zza(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        zzehu zzehuVar = this.f29361a;
        zzehuVar.getClass();
        ContentValues contentValues = new ContentValues();
        zzehw zzehwVar = this.f29362b;
        contentValues.put("timestamp", Long.valueOf(zzehwVar.f29369a));
        contentValues.put("gws_query_id", zzehwVar.f29370b);
        contentValues.put("url", zzehwVar.f29371c);
        contentValues.put("event_state", Integer.valueOf(zzehwVar.f29372d - 1));
        ((SQLiteDatabase) obj).insert("offline_buffered_pings", null, contentValues);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        Context context = zzehuVar.f29366a;
        com.google.android.gms.ads.internal.util.zzbo zzboVarC = com.google.android.gms.ads.internal.util.zzs.c(context);
        if (zzboVarC != null) {
            try {
                zzboVarC.zzf(new ObjectWrapper(context));
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zze.l("Failed to schedule offline ping sender.", e2);
            }
        }
        return null;
    }
}
