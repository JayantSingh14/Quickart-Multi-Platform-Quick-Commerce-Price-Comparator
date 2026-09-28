package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafs {

    /* renamed from: c, reason: collision with root package name */
    public static final zzafs f22959c = new zzafs(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f22960a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22961b;

    public zzafs(long j2, long j3) {
        this.f22960a = j2;
        this.f22961b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafs.class == obj.getClass()) {
            zzafs zzafsVar = (zzafs) obj;
            if (this.f22960a == zzafsVar.f22960a && this.f22961b == zzafsVar.f22961b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f22960a) * 31) + ((int) this.f22961b);
    }

    public final String toString() {
        long j2 = this.f22960a;
        int length = String.valueOf(j2).length();
        long j3 = this.f22961b;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(j3).length() + 1);
        androidx.fragment.app.e.A(sb, "[timeUs=", j2, ", position=");
        return android.support.v4.media.b.p(sb, j3, "]");
    }
}
