package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzghs implements zzfvz {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32606a;

    /* renamed from: b, reason: collision with root package name */
    public final zzglx f32607b;

    /* renamed from: c, reason: collision with root package name */
    public final String f32608c;

    /* renamed from: d, reason: collision with root package name */
    public final long f32609d;

    /* renamed from: e, reason: collision with root package name */
    public final long f32610e;

    public zzghs(Context context, zzgad zzgadVar, zzglx zzglxVar) {
        this.f32606a = context;
        this.f32608c = zzgadVar.I();
        this.f32609d = zzgadVar.P();
        this.f32610e = zzgadVar.Q();
        this.f32607b = zzglxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(HashMap map) {
        ListenableFuture listenableFuture;
        zzawp zzawpVar;
        map.put("v", this.f32608c);
        map.put("t", new Throwable());
        try {
            listenableFuture = (ListenableFuture) map.get("gs");
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        String strY0 = (listenableFuture == null || (Build.VERSION.SDK_INT >= 31 && !listenableFuture.isDone()) || (zzawpVar = (zzawp) listenableFuture.get(this.f32609d, TimeUnit.MILLISECONDS)) == null || zzawpVar.y0().length() <= 1) ? "E" : zzawpVar.y0();
        if (strY0.equals("E")) {
            try {
                ListenableFuture listenableFuture2 = (ListenableFuture) map.get("ai");
                if (listenableFuture2 != null) {
                    String str = (String) listenableFuture2.get(this.f32610e, TimeUnit.MILLISECONDS);
                    if (!zzgpz.a(str)) {
                        strY0 = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        map.put("int", strY0);
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzb() {
        HashMap mapA = this.f32607b.a();
        a(mapA);
        return mapA;
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzc() {
        HashMap mapB = this.f32607b.b(this.f32606a, null);
        a(mapB);
        return mapB;
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzd() {
        HashMap mapC = this.f32607b.c();
        a(mapC);
        return mapC;
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zze() {
        HashMap map = new HashMap();
        map.put("t", new Throwable());
        return map;
    }
}
