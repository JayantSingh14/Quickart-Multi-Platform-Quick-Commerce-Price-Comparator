package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes4.dex */
public final class zzbzj extends zzbzl {

    /* renamed from: a, reason: collision with root package name */
    public final String f25777a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25778b;

    public zzbzj(String str, int i2) {
        this.f25777a = str;
        this.f25778b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbzj)) {
            return false;
        }
        zzbzj zzbzjVar = (zzbzj) obj;
        return Objects.equal(this.f25777a, zzbzjVar.f25777a) && Objects.equal(Integer.valueOf(this.f25778b), Integer.valueOf(zzbzjVar.f25778b));
    }
}
