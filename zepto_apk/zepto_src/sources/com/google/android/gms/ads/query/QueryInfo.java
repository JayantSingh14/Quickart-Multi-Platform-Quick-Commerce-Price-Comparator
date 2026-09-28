package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzfa;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbxp;

/* loaded from: classes4.dex */
public class QueryInfo {

    /* renamed from: a, reason: collision with root package name */
    public final zzfa f21972a;

    public QueryInfo(zzfa zzfaVar) {
        this.f21972a = zzfaVar;
    }

    public static void a(final Context context, final AdRequest adRequest, final QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbgk.a(context);
        if (((Boolean) zzbii.f25164j.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.query.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        new zzbxp(context, adRequest.f20997a).a(queryInfoGenerationCallback);
                    }
                });
                return;
            }
        }
        new zzbxp(context, adRequest.f20997a).a(queryInfoGenerationCallback);
    }
}
