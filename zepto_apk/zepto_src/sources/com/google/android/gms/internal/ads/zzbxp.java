package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbxp {

    /* renamed from: c, reason: collision with root package name */
    public static zzccj f25666c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f25667a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzek f25668b;

    public zzbxp(Context context, com.google.android.gms.ads.internal.client.zzek zzekVar) {
        this.f25667a = context;
        this.f25668b = zzekVar;
    }

    public final void a(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzccj zzccjVar;
        com.google.android.gms.ads.internal.client.zzm zzmVarA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.f25667a;
        synchronized (zzbxp.class) {
            try {
                if (f25666c == null) {
                    f25666c = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21143b.i(context, new zzbsv());
                }
                zzccjVar = f25666c;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzccjVar == null) {
            queryInfoGenerationCallback.a("Internal Error, query info generator is null.");
            return;
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        com.google.android.gms.ads.internal.client.zzek zzekVar = this.f25668b;
        if (zzekVar == null) {
            com.google.android.gms.ads.internal.client.zzn zznVar = new com.google.android.gms.ads.internal.client.zzn();
            zznVar.f21278l = jCurrentTimeMillis;
            zzmVarA = zznVar.a();
        } else {
            zzekVar.n = jCurrentTimeMillis;
            zzmVarA = com.google.android.gms.ads.internal.client.zzq.a(context, zzekVar);
        }
        try {
            zzccjVar.c6(objectWrapper, new zzccn(null, "BANNER", null, zzmVarA, 0, null), new zzbxo(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.a("Internal Error.");
        }
    }
}
