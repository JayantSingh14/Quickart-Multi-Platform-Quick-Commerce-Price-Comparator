package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzahy extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23160b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23161c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23162d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23163e;

    /* renamed from: f, reason: collision with root package name */
    public final long f23164f;

    /* renamed from: g, reason: collision with root package name */
    public final zzaig[] f23165g;

    public zzahy(String str, int i2, int i3, long j2, long j3, zzaig[] zzaigVarArr) {
        super("CHAP");
        this.f23160b = str;
        this.f23161c = i2;
        this.f23162d = i3;
        this.f23163e = j2;
        this.f23164f = j3;
        this.f23165g = zzaigVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahy.class == obj.getClass()) {
            zzahy zzahyVar = (zzahy) obj;
            if (this.f23161c == zzahyVar.f23161c && this.f23162d == zzahyVar.f23162d && this.f23163e == zzahyVar.f23163e && this.f23164f == zzahyVar.f23164f && Objects.equals(this.f23160b, zzahyVar.f23160b) && Arrays.equals(this.f23165g, zzahyVar.f23165g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f23160b.hashCode() + ((((((((this.f23161c + 527) * 31) + this.f23162d) * 31) + ((int) this.f23163e)) * 31) + ((int) this.f23164f)) * 31);
    }
}
