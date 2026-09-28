package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzif implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39104b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39105c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f39106d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzjc f39107e;

    public zzif(zzjc zzjcVar, String str, String str2, String str3, long j2) {
        this.f39103a = str;
        this.f39104b = str2;
        this.f39105c = str3;
        this.f39106d = j2;
        Objects.requireNonNull(zzjcVar);
        this.f39107e = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f39104b;
        zzjc zzjcVar = this.f39107e;
        String str2 = this.f39103a;
        if (str2 == null) {
            zzpf zzpfVar = zzjcVar.f39177a;
            zzpfVar.c().g();
            String str3 = zzpfVar.G;
            if (str3 == null || str3.equals(str)) {
                zzpfVar.G = str;
                zzpfVar.F = null;
                return;
            }
            return;
        }
        zzlt zzltVar = new zzlt(this.f39106d, this.f39105c, str2);
        zzpf zzpfVar2 = zzjcVar.f39177a;
        zzpfVar2.c().g();
        String str4 = zzpfVar2.G;
        if (str4 != null) {
            str4.equals(str);
        }
        zzpfVar2.G = str;
        zzpfVar2.F = zzltVar;
    }
}
