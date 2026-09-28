package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public final class zzfw {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f38896f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f38897a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbn f38898b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f38899c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f38900d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f38901e = null;

    public /* synthetic */ zzfw(String str, Object obj, zzbn zzbnVar) {
        this.f38897a = str;
        this.f38899c = obj;
        this.f38898b = zzbnVar;
    }

    public final Object a(Object obj) {
        synchronized (this.f38900d) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzfr.f38891a == null) {
            return this.f38899c;
        }
        synchronized (f38896f) {
            try {
                if (zzae.a()) {
                    return this.f38901e == null ? this.f38899c : this.f38901e;
                }
                try {
                    for (zzfw zzfwVar : zzfx.f38902a) {
                        if (zzae.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objZza = null;
                        try {
                            zzbn zzbnVar = zzfwVar.f38898b;
                            if (zzbnVar != null) {
                                objZza = zzbnVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f38896f) {
                            zzfwVar.f38901e = objZza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzbn zzbnVar2 = this.f38898b;
                if (zzbnVar2 != null) {
                    try {
                        return zzbnVar2.zza();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.f38899c;
            } finally {
            }
        }
    }
}
