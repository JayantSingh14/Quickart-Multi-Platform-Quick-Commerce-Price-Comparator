package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzcgp extends com.google.android.gms.ads.internal.util.zzb {

    /* renamed from: b, reason: collision with root package name */
    public final zzcfk f26171b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcgx f26172c;

    /* renamed from: d, reason: collision with root package name */
    public final String f26173d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f26174e;

    public zzcgp(zzcfk zzcfkVar, zzcgx zzcgxVar, String str, String[] strArr) {
        this.f26171b = zzcfkVar;
        this.f26172c = zzcgxVar;
        this.f26173d = str;
        this.f26174e = strArr;
        com.google.android.gms.ads.internal.zzt.C.A.f26175a.add(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void a() {
        try {
            this.f26172c.f(this.f26173d, this.f26174e);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcgn(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final ListenableFuture b() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r2)).booleanValue() || !(this.f26172c instanceof zzchg)) {
            return super.b();
        }
        return ((zzgxi) zzcdo.f25987f).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzcgo
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzcgp zzcgpVar = this.f26170a;
                return Boolean.valueOf(zzcgpVar.f26172c.h(zzcgpVar.f26173d, zzcgpVar.f26174e, zzcgpVar));
            }
        });
    }
}
