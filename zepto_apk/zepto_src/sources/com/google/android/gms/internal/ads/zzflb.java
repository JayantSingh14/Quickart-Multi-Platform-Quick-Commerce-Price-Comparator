package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzflb {

    /* renamed from: a, reason: collision with root package name */
    public final zzfkt f31355a;

    /* renamed from: b, reason: collision with root package name */
    public final ListenableFuture f31356b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31357c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31358d = false;

    public zzflb(final zzfjz zzfjzVar, final zzfks zzfksVar, final zzfkt zzfktVar) {
        this.f31355a = zzfktVar;
        zzfep zzfepVar = (zzfep) zzfktVar;
        this.f31356b = zzgym.f(zzgym.h((zzgye) ((zzfem) zzfksVar).f30966a.b(zzfepVar.f30974b, zzfepVar.f30973a, null), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfla
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzflb zzflbVar = this.f31351a;
                zzfks zzfksVar2 = zzfksVar;
                zzfjz zzfjzVar2 = zzfjzVar;
                zzfkt zzfktVar2 = zzfktVar;
                zzfki zzfkiVar = (zzfki) obj;
                synchronized (zzflbVar) {
                    try {
                        zzflbVar.f31358d = true;
                        zzfkiVar.f31317a = ((zzfem) zzfksVar2).f30966a.f30964a;
                        if (zzflbVar.f31357c) {
                            return zzgym.a(new zzfkr(zzfkiVar, zzfktVar2));
                        }
                        ((zzfka) zzfjzVar2).a(zzfktVar2.zzb(), zzfkiVar);
                        return zzgyq.f33377b;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, zzfktVar.zza()), Exception.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfky
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzflb zzflbVar = this.f31345a;
                Exception exc = (Exception) obj;
                synchronized (zzflbVar) {
                    zzflbVar.f31358d = true;
                    throw exc;
                }
            }
        }, zzfktVar.zza());
    }

    public final synchronized ListenableFuture a(zzfkt zzfktVar) {
        if (!this.f31358d && !this.f31357c) {
            zzfkt zzfktVar2 = this.f31355a;
            if (zzfktVar2.zzb() != null && ((zzfep) zzfktVar).f30979g != null && zzfktVar2.zzb().equals(((zzfep) zzfktVar).f30979g)) {
                this.f31357c = true;
                return this.f31356b;
            }
        }
        return null;
    }
}
