package com.google.android.play.core.splitinstall.internal;

/* loaded from: classes4.dex */
public final class zzbz implements zzcb, zzby {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f41972c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile zzcb f41973a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f41974b = f41972c;

    public zzbz(zzcb zzcbVar) {
        this.f41973a = zzcbVar;
    }

    public static zzby a(zzcb zzcbVar) {
        return zzcbVar instanceof zzby ? (zzby) zzcbVar : new zzbz(zzcbVar);
    }

    public static zzcb b(zzcb zzcbVar) {
        return zzcbVar instanceof zzbz ? zzcbVar : new zzbz(zzcbVar);
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        Object objZza;
        Object obj = this.f41974b;
        Object obj2 = f41972c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objZza = this.f41974b;
                if (objZza == obj2) {
                    objZza = this.f41973a.zza();
                    Object obj3 = this.f41974b;
                    if (obj3 != obj2 && obj3 != objZza) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZza + ". This is likely due to a circular dependency.");
                    }
                    this.f41974b = objZza;
                    this.f41973a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objZza;
    }
}
