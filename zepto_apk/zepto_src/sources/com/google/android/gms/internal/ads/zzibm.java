package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public class zzibm {

    /* renamed from: a, reason: collision with root package name */
    public volatile zzicc f34686a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzhzl f34687b;

    public final int a() {
        if (this.f34687b != null) {
            return ((zzhzj) this.f34687b).f34550c.length;
        }
        if (this.f34686a != null) {
            return this.f34686a.d();
        }
        return 0;
    }

    public final zzhzl b() {
        if (this.f34687b != null) {
            return this.f34687b;
        }
        synchronized (this) {
            try {
                if (this.f34687b != null) {
                    return this.f34687b;
                }
                if (this.f34686a == null) {
                    this.f34687b = zzhzl.f34557b;
                } else {
                    this.f34687b = this.f34686a.b();
                }
                return this.f34687b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(zzicc zziccVar) {
        if (this.f34686a != null) {
            return;
        }
        synchronized (this) {
            if (this.f34686a != null) {
                return;
            }
            try {
                this.f34686a = zziccVar;
                this.f34687b = zzhzl.f34557b;
            } catch (zzibg unused) {
                this.f34686a = zziccVar;
                this.f34687b = zzhzl.f34557b;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzibm)) {
            return false;
        }
        zzibm zzibmVar = (zzibm) obj;
        zzicc zziccVar = this.f34686a;
        zzicc zziccVar2 = zzibmVar.f34686a;
        if (zziccVar == null && zziccVar2 == null) {
            return b().equals(zzibmVar.b());
        }
        if (zziccVar != null && zziccVar2 != null) {
            return zziccVar.equals(zziccVar2);
        }
        if (zziccVar != null) {
            zzibmVar.c(zziccVar.e());
            return zziccVar.equals(zzibmVar.f34686a);
        }
        c(zziccVar2.e());
        return this.f34686a.equals(zziccVar2);
    }

    public int hashCode() {
        return 1;
    }
}
