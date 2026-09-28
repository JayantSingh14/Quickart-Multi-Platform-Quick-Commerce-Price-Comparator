package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzafz {

    /* renamed from: a, reason: collision with root package name */
    public final int f22974a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22975b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22976c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22977d;

    public zzafz(int i2, int i3, byte[] bArr, int i4) {
        this.f22974a = i2;
        this.f22975b = bArr;
        this.f22976c = i3;
        this.f22977d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafz.class == obj.getClass()) {
            zzafz zzafzVar = (zzafz) obj;
            if (this.f22974a == zzafzVar.f22974a && this.f22976c == zzafzVar.f22976c && this.f22977d == zzafzVar.f22977d && Arrays.equals(this.f22975b, zzafzVar.f22975b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f22975b) + (this.f22974a * 31)) * 31) + this.f22976c) * 31) + this.f22977d;
    }
}
