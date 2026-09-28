package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzecj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29059a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29060b;

    public zzecj(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f29059a = zzijfVar;
        this.f29060b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f29059a.zzb();
        final CookieManager cookieManagerH = com.google.android.gms.ads.internal.zzt.C.f21682f.h();
        zzfmo zzfmoVar = zzfmo.WEBVIEW_COOKIE;
        Objects.requireNonNull(zzfmuVar);
        zzfml zzfmlVar = new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, ((zzgxi) zzfmuVar.f31405a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzece
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = cookieManagerH;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.j1));
            }
        }));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zzfml zzfmlVarC = zzfmlVar.c(1L);
        zzfmi zzfmiVar = new zzfmi();
        zzfmm zzfmmVar = zzfmlVarC.f31403f;
        return new zzfml(zzfmmVar, zzfmlVarC.f31398a, zzfmlVarC.f31399b, zzfmlVarC.f31400c, zzfmlVarC.f31401d, zzgym.f(zzfmlVarC.f31402e, Exception.class, zzfmiVar, zzfmmVar.f31405a)).d();
    }
}
