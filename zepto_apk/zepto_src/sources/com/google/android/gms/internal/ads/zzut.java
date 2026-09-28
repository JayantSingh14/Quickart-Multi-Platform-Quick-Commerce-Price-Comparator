package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes4.dex */
final class zzut {

    /* renamed from: a, reason: collision with root package name */
    public final String f35672a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35673b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f35674c;

    public zzut(String str, boolean z, boolean z2) {
        this.f35672a = str;
        this.f35673b = z;
        this.f35674c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != zzut.class) {
            return false;
        }
        zzut zzutVar = (zzut) obj;
        return TextUtils.equals(this.f35672a, zzutVar.f35672a) && this.f35673b == zzutVar.f35673b && this.f35674c == zzutVar.f35674c;
    }

    public final int hashCode() {
        return ((((this.f35672a.hashCode() + 31) * 31) + (true != this.f35673b ? 1237 : 1231)) * 31) + (true != this.f35674c ? 1237 : 1231);
    }
}
