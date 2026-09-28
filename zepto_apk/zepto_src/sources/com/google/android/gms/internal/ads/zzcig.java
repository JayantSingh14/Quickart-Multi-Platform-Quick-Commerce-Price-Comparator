package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzcig extends zzceq {

    /* renamed from: c, reason: collision with root package name */
    public final zzcfl f26328c;

    /* renamed from: d, reason: collision with root package name */
    public zzcih f26329d;

    /* renamed from: e, reason: collision with root package name */
    public zzcey f26330e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26331f;

    /* renamed from: g, reason: collision with root package name */
    public int f26332g;

    public zzcig(Context context, zzcfl zzcflVar) {
        super(context);
        this.f26332g = 1;
        this.f26331f = false;
        this.f26328c = zzcflVar;
        zzcflVar.a(this);
    }

    public final boolean C() {
        int i2 = this.f26332g;
        return (i2 == 1 || i2 == 2 || this.f26329d == null) ? false : true;
    }

    public final void D(int i2) {
        zzcfo zzcfoVar = this.f26029b;
        zzcfl zzcflVar = this.f26328c;
        if (i2 == 4) {
            zzcflVar.d();
            zzcfoVar.f26116d = true;
            zzcfoVar.a();
        } else if (this.f26332g == 4) {
            zzcflVar.f26110m = false;
            zzcfoVar.f26116d = false;
            zzcfoVar.a();
        }
        this.f26332g = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final String h() {
        return "ImmersivePlayer";
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void i(zzcey zzceyVar) {
        this.f26330e = zzceyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void j(String str) {
        if (str != null) {
            Uri.parse(str).toString();
            this.f26329d = new zzcih();
            D(3);
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcif
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcey zzceyVar = this.f26327a.f26330e;
                    if (zzceyVar != null) {
                        zzceyVar.f();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void l() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView stop");
        zzcih zzcihVar = this.f26329d;
        if (zzcihVar != null) {
            zzcihVar.f26333a.set(false);
            this.f26329d = null;
            D(1);
        }
        this.f26328c.b();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void m() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView play");
        if (C()) {
            this.f26329d.f26333a.set(true);
            D(4);
            this.f26028a.f26063c = true;
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcig zzcigVar = this.f26325a;
                    zzcey zzceyVar = zzcigVar.f26330e;
                    if (zzceyVar != null) {
                        if (!zzcigVar.f26331f) {
                            zzceyVar.m();
                            zzcigVar.f26331f = true;
                        }
                        zzcigVar.f26330e.g();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void n() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView pause");
        if (C() && this.f26329d.f26333a.get()) {
            this.f26329d.f26333a.set(false);
            D(5);
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcie
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcey zzceyVar = this.f26326a.f26330e;
                    if (zzceyVar != null) {
                        zzceyVar.h();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int o() {
        return C() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int p() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void q(int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 27);
        sb.append("AdImmersivePlayerView seek ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void r(float f2, float f3) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int s() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int t() {
        return 0;
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzcig.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return android.support.v4.media.b.s(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long u() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long v() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long w() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int x() {
        return C() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcfn
    public final void zzq() {
        if (this.f26329d != null) {
            this.f26029b.getClass();
        }
    }
}
