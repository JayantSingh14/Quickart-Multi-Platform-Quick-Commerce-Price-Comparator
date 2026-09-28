package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public class zzadl {

    /* renamed from: a, reason: collision with root package name */
    public volatile zzaef f37424a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzaby f37425b;

    static {
        zzacm.a();
    }

    public final zzaby a() {
        if (this.f37425b != null) {
            return this.f37425b;
        }
        synchronized (this) {
            try {
                if (this.f37425b != null) {
                    return this.f37425b;
                }
                if (this.f37424a == null) {
                    this.f37425b = zzaby.f37363b;
                } else {
                    this.f37425b = this.f37424a.a();
                }
                return this.f37425b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(zzaef zzaefVar) {
        if (this.f37424a != null) {
            return;
        }
        synchronized (this) {
            if (this.f37424a == null) {
                try {
                    this.f37424a = zzaefVar;
                    this.f37425b = zzaby.f37363b;
                } catch (zzadi unused) {
                    this.f37424a = zzaefVar;
                    this.f37425b = zzaby.f37363b;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzadl)) {
            return false;
        }
        zzadl zzadlVar = (zzadl) obj;
        zzaef zzaefVar = this.f37424a;
        zzaef zzaefVar2 = zzadlVar.f37424a;
        if (zzaefVar == null && zzaefVar2 == null) {
            return a().equals(zzadlVar.a());
        }
        if (zzaefVar != null && zzaefVar2 != null) {
            return zzaefVar.equals(zzaefVar2);
        }
        if (zzaefVar != null) {
            zzadlVar.b(zzaefVar.g());
            return zzaefVar.equals(zzadlVar.f37424a);
        }
        b(zzaefVar2.g());
        return this.f37424a.equals(zzaefVar2);
    }

    public int hashCode() {
        return 1;
    }
}
