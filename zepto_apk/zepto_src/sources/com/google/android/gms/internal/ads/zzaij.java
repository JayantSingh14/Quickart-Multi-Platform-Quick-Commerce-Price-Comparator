package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaij extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final int f23189b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23190c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23191d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f23192e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f23193f;

    public zzaij(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f23189b = i2;
        this.f23190c = i3;
        this.f23191d = i4;
        this.f23192e = iArr;
        this.f23193f = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaij.class == obj.getClass()) {
            zzaij zzaijVar = (zzaij) obj;
            if (this.f23189b == zzaijVar.f23189b && this.f23190c == zzaijVar.f23190c && this.f23191d == zzaijVar.f23191d && Arrays.equals(this.f23192e, zzaijVar.f23192e) && Arrays.equals(this.f23193f, zzaijVar.f23193f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f23193f) + ((Arrays.hashCode(this.f23192e) + ((((((this.f23189b + 527) * 31) + this.f23190c) * 31) + this.f23191d) * 31)) * 31);
    }
}
