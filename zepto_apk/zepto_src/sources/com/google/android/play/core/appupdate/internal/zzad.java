package com.google.android.play.core.appupdate.internal;

/* loaded from: classes.dex */
public final class zzad implements zzaf {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f41675c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile zzaf f41676a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f41677b;

    public static zzaf a(zzaf zzafVar) {
        if (zzafVar instanceof zzad) {
            return zzafVar;
        }
        zzad zzadVar = new zzad();
        zzadVar.f41677b = f41675c;
        zzadVar.f41676a = zzafVar;
        return zzadVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        Object objZza;
        Object obj = this.f41677b;
        Object obj2 = f41675c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objZza = this.f41677b;
                if (objZza == obj2) {
                    objZza = this.f41676a.zza();
                    Object obj3 = this.f41677b;
                    if (obj3 != obj2 && obj3 != objZza) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZza + ". This is likely due to a circular dependency.");
                    }
                    this.f41677b = objZza;
                    this.f41676a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objZza;
    }
}
