package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public class zzmv {

    /* renamed from: a, reason: collision with root package name */
    public volatile zznl f37127a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzlg f37128b;

    public final int a() {
        if (this.f37128b != null) {
            return ((zzlf) this.f37128b).f37072c.length;
        }
        if (this.f37127a != null) {
            return this.f37127a.a();
        }
        return 0;
    }

    public final zzlg b() {
        if (this.f37128b != null) {
            return this.f37128b;
        }
        synchronized (this) {
            try {
                if (this.f37128b != null) {
                    return this.f37128b;
                }
                if (this.f37127a == null) {
                    this.f37128b = zzlg.f37073b;
                } else {
                    this.f37128b = this.f37127a.b();
                }
                return this.f37128b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(zznl zznlVar) {
        if (this.f37127a != null) {
            return;
        }
        synchronized (this) {
            if (this.f37127a != null) {
                return;
            }
            try {
                this.f37127a = zznlVar;
                this.f37128b = zzlg.f37073b;
            } catch (zzmq unused) {
                this.f37127a = zznlVar;
                this.f37128b = zzlg.f37073b;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return false;
        }
        zzmv zzmvVar = (zzmv) obj;
        zznl zznlVar = this.f37127a;
        zznl zznlVar2 = zzmvVar.f37127a;
        if (zznlVar == null && zznlVar2 == null) {
            return b().equals(zzmvVar.b());
        }
        if (zznlVar != null && zznlVar2 != null) {
            return zznlVar.equals(zznlVar2);
        }
        if (zznlVar != null) {
            zzmvVar.c(zznlVar.e());
            return zznlVar.equals(zzmvVar.f37127a);
        }
        c(zznlVar2.e());
        return this.f37127a.equals(zznlVar2);
    }

    public int hashCode() {
        return 1;
    }
}
