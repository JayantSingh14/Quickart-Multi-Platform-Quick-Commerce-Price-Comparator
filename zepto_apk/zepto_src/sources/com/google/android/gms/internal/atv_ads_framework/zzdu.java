package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public class zzdu {

    /* renamed from: a, reason: collision with root package name */
    public volatile zzeo f36139a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzcn f36140b;

    static {
        int i2 = zzcx.f36105b;
    }

    public final zzcn a() {
        if (this.f36140b != null) {
            return this.f36140b;
        }
        synchronized (this) {
            try {
                if (this.f36140b != null) {
                    return this.f36140b;
                }
                if (this.f36139a == null) {
                    this.f36140b = zzcn.f36095b;
                } else {
                    this.f36140b = this.f36139a.zzk();
                }
                return this.f36140b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(zzeo zzeoVar) {
        if (this.f36139a != null) {
            return;
        }
        synchronized (this) {
            if (this.f36139a == null) {
                try {
                    this.f36139a = zzeoVar;
                    this.f36140b = zzcn.f36095b;
                } catch (zzdr unused) {
                    this.f36139a = zzeoVar;
                    this.f36140b = zzcn.f36095b;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdu)) {
            return false;
        }
        zzdu zzduVar = (zzdu) obj;
        zzeo zzeoVar = this.f36139a;
        zzeo zzeoVar2 = zzduVar.f36139a;
        if (zzeoVar == null && zzeoVar2 == null) {
            return a().equals(zzduVar.a());
        }
        if (zzeoVar != null && zzeoVar2 != null) {
            return zzeoVar.equals(zzeoVar2);
        }
        if (zzeoVar != null) {
            zzduVar.b(zzeoVar.zzl());
            return zzeoVar.equals(zzduVar.f36139a);
        }
        b(zzeoVar2.zzl());
        return this.f36139a.equals(zzeoVar2);
    }

    public int hashCode() {
        return 1;
    }
}
