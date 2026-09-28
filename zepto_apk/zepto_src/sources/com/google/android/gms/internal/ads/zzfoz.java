package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfoz {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzx f31527a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzu f31528b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyx f31529c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfpa f31530d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcld f31531e;

    public zzfoz(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzgyx zzgyxVar, zzfpa zzfpaVar, zzcld zzcldVar) {
        this.f31527a = zzxVar;
        this.f31528b = zzuVar;
        this.f31529c = zzgyxVar;
        this.f31530d = zzfpaVar;
        this.f31531e = zzcldVar;
    }

    public final ListenableFuture a(String str) {
        com.google.android.gms.ads.internal.util.client.zzt zztVar = com.google.android.gms.ads.internal.util.client.zzt.f21444b;
        if (str != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25017g)).booleanValue() || !str.isEmpty()) {
                try {
                    return b(1, 0L, str);
                } catch (NullPointerException | RejectedExecutionException unused) {
                    return zzgym.a(zztVar);
                }
            }
        }
        return zzgym.a(zztVar);
    }

    public final ListenableFuture b(final int i2, final long j2, final String str) {
        final String strS;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.f31527a;
        if (i2 > zzxVar.a()) {
            zzfpa zzfpaVar = this.f31530d;
            if (zzfpaVar == null || !zzxVar.d()) {
                return zzgym.a(com.google.android.gms.ads.internal.util.client.zzt.f21445c);
            }
            zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), "", str, 2);
            zzehu zzehuVar = zzfpaVar.f31533a;
            zzehuVar.getClass();
            zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
            return zzgym.a(com.google.android.gms.ads.internal.util.client.zzt.f21446d);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C9)).booleanValue()) {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            builderClearQuery.appendQueryParameter("pa", Integer.toString(i2));
            String strValueOf = String.valueOf(builderClearQuery.build());
            strS = android.support.v4.media.b.s(new StringBuilder(strValueOf.length() + 1 + String.valueOf(encodedQuery).length()), strValueOf, "&", encodedQuery);
        } else {
            strS = str;
        }
        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfoy
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
                com.google.android.gms.ads.internal.util.client.zzt zztVar2 = com.google.android.gms.ads.internal.util.client.zzt.f21445c;
                zzfoz zzfozVar = this.f31523a;
                if (zztVar != zztVar2) {
                    zzfozVar.getClass();
                    return zzgym.a(zztVar);
                }
                com.google.android.gms.ads.internal.util.client.zzx zzxVar2 = zzfozVar.f31527a;
                long jB = zzxVar2.b();
                int i3 = i2;
                if (i3 != 1) {
                    jB = (long) (zzxVar2.c() * j2);
                }
                return zzfozVar.b(i3 + 1, jB, str);
            }
        };
        zzgyx zzgyxVar = this.f31529c;
        return j2 == 0 ? zzgym.h(zzgyxVar.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfox
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.f31521a.c(strS);
            }
        }), zzgxuVar, zzgyxVar) : zzgym.h(zzgyxVar.schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzfow
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.f31519a.c(strS);
            }
        }, j2, TimeUnit.MILLISECONDS), zzgxuVar, zzgyxVar);
    }

    public final com.google.android.gms.ads.internal.util.client.zzt c(String str) {
        zzcld zzcldVar;
        zzbgb zzbgbVar = zzbgk.U9;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.f31528b;
        if (zBooleanValue && (zzcldVar = this.f31531e) != null) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            if (zztVar.f21679c.H(str) || zztVar.f21679c.I(str)) {
                zziic zziicVar = zzcldVar.f26497c;
                String strEncodeToString = zziicVar != null ? Base64.encodeToString(zziicVar.g(), 10) : null;
                HashMap map = new HashMap();
                if (strEncodeToString != null) {
                    map.put((String) zzbdVar.f21153c.a(zzbgk.V9), strEncodeToString);
                }
                return zzuVar.b(str, map);
            }
        }
        return zzuVar.b(str, null);
    }
}
