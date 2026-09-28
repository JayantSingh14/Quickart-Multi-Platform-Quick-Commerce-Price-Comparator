package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdzg extends zzbpp {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f28820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f28821b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f28822c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfne f28823d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzcdt f28824e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzdzp f28825f;

    public zzdzg(long j2, zzcdt zzcdtVar, zzdzp zzdzpVar, zzfne zzfneVar, Object obj, String str) {
        this.f28820a = obj;
        this.f28821b = str;
        this.f28822c = j2;
        this.f28823d = zzfneVar;
        this.f28824e = zzcdtVar;
        Objects.requireNonNull(zzdzpVar);
        this.f28825f = zzdzpVar;
    }

    public final void c0(String str) {
        synchronized (this.f28820a) {
            zzdzp zzdzpVar = this.f28825f;
            String str2 = this.f28821b;
            zzdzpVar.d(str2, (int) (com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f28822c), str, false);
            zzdzpVar.f28857l.c(str2, "error");
            zzdzpVar.o.c(str2, "error");
            zzfnr zzfnrVar = zzdzpVar.p;
            zzfne zzfneVar = this.f28823d;
            zzfneVar.b(str);
            zzfneVar.a(false);
            zzfnrVar.b(zzfneVar.zzm());
            this.f28824e.b(Boolean.FALSE);
        }
    }

    public final void zze() {
        synchronized (this.f28820a) {
            zzdzp zzdzpVar = this.f28825f;
            String str = this.f28821b;
            zzdzpVar.d(str, (int) (com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f28822c), "", true);
            zzdzpVar.f28857l.b(str);
            zzdzpVar.o.b(str);
            zzfnr zzfnrVar = zzdzpVar.p;
            zzfne zzfneVar = this.f28823d;
            zzfneVar.a(true);
            zzfnrVar.b(zzfneVar.zzm());
            this.f28824e.b(Boolean.TRUE);
        }
    }
}
