package com.google.android.gms.internal.atv_ads_framework;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;

/* loaded from: classes4.dex */
public final class zzf {

    /* renamed from: c, reason: collision with root package name */
    public static zzf f36178c;

    /* renamed from: a, reason: collision with root package name */
    public final TransportFactory f36179a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f36180b;

    public zzf(Context context, TransportFactory transportFactory) {
        context.getClass();
        this.f36180b = context;
        this.f36179a = transportFactory;
    }

    public static synchronized zzf a(Context context) {
        try {
            if (f36178c == null) {
                TransportRuntime.b(context.getApplicationContext());
                f36178c = new zzf(context.getApplicationContext(), TransportRuntime.a().c(CCTDestination.f20520e));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f36178c;
    }

    public final void b(zzn zznVar) {
        zzab zzabVarB = zzad.b(this.f36180b);
        zzabVarB.d();
        zzac.n((zzac) zzabVarB.f36121b, zznVar);
        zzac zzacVar = (zzac) zzabVarB.b();
        this.f36179a.a("TV_ADS_LIB", new Encoding("proto"), zze.f36143a).b(Event.g(zzacVar));
    }
}
