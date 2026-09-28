package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzdcz extends zzdgi implements zzdbe, zzdcj {

    /* renamed from: b, reason: collision with root package name */
    public final zzfhr f27622b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f27623c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfic f27624d;

    public zzdcz(Set set, zzfhr zzfhrVar, zzfic zzficVar) {
        super(set);
        this.f27623c = new AtomicBoolean();
        this.f27622b = zzfhrVar;
        this.f27624d = zzficVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        int i2 = this.f27622b.f31150b;
        if (i2 == 2 || i2 == 5 || i2 == 4 || i2 == 6 || i2 == 7) {
            w0();
        }
    }

    public final void w0() {
        final com.google.android.gms.ads.internal.client.zzt zztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.N8)).booleanValue() && this.f27623c.compareAndSet(false, true) && (zztVar = this.f27622b.e0) != null && zztVar.f21294a == 3) {
            v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdcy
                @Override // com.google.android.gms.internal.ads.zzdgh
                public final /* synthetic */ void zza(Object obj) {
                    ((zzddb) obj).a(zztVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcj
    public final void zzl() {
        if (this.f27622b.f31150b == 1) {
            w0();
        }
    }
}
