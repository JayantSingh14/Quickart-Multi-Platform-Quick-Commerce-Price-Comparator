package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfiu implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdir f31236a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcra f31237b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfpi f31238c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzehu f31239d;

    public /* synthetic */ zzfiu(zzdir zzdirVar, zzcra zzcraVar, zzfpi zzfpiVar, zzehu zzehuVar) {
        this.f31236a = zzdirVar;
        this.f31237b = zzcraVar;
        this.f31238c = zzfpiVar;
        this.f31239d = zzehuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        zzcir zzcirVar = (zzcir) obj;
        zzbnm.b(map, this.f31236a);
        String str = (String) map.get("u");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from click GMSG.");
            return;
        }
        ListenableFuture listenableFutureA = zzbnm.a(zzcirVar, str);
        zzfis zzfisVar = new zzfis(zzcirVar, this.f31237b, this.f31238c, this.f31239d);
        listenableFutureA.q(new zzgyk(listenableFutureA, zzfisVar), zzcdo.f25982a);
    }
}
