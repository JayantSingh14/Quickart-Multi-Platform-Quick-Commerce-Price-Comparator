package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzahz extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23166b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23167c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23168d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f23169e;

    /* renamed from: f, reason: collision with root package name */
    public final zzaig[] f23170f;

    public zzahz(String str, boolean z, boolean z2, String[] strArr, zzaig[] zzaigVarArr) {
        super("CTOC");
        this.f23166b = str;
        this.f23167c = z;
        this.f23168d = z2;
        this.f23169e = strArr;
        this.f23170f = zzaigVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahz.class == obj.getClass()) {
            zzahz zzahzVar = (zzahz) obj;
            if (this.f23167c == zzahzVar.f23167c && this.f23168d == zzahzVar.f23168d && Objects.equals(this.f23166b, zzahzVar.f23166b) && Arrays.equals(this.f23169e, zzahzVar.f23169e) && Arrays.equals(this.f23170f, zzahzVar.f23170f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f23166b.hashCode() + (((((this.f23167c ? 1 : 0) + 527) * 31) + (this.f23168d ? 1 : 0)) * 31);
    }
}
