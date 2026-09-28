package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzcl {

    /* renamed from: e, reason: collision with root package name */
    public static final zzcl f26484e = new zzcl(-1, -1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f26485a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26486b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26487c;

    /* renamed from: d, reason: collision with root package name */
    public final int f26488d;

    public zzcl(int i2, int i3, int i4) {
        this.f26485a = i2;
        this.f26486b = i3;
        this.f26487c = i4;
        this.f26488d = zzfj.a(i4) ? zzfj.d(i4) * i3 : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzclVar = (zzcl) obj;
        return this.f26485a == zzclVar.f26485a && this.f26486b == zzclVar.f26486b && this.f26487c == zzclVar.f26487c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f26485a), Integer.valueOf(this.f26486b), Integer.valueOf(this.f26487c));
    }

    public final String toString() {
        int i2 = this.f26485a;
        int length = String.valueOf(i2).length();
        int i3 = this.f26486b;
        int length2 = String.valueOf(i3).length();
        int i4 = this.f26487c;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 11 + String.valueOf(i4).length() + 1);
        androidx.fragment.app.e.w(i2, i3, "AudioFormat[sampleRate=", ", channelCount=", sb);
        return androidx.fragment.app.e.u(sb, ", encoding=", i4, "]");
    }
}
