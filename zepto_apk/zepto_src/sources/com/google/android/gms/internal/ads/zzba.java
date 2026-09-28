package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzba {

    /* renamed from: a, reason: collision with root package name */
    public final Object f24598a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24599b;

    /* renamed from: c, reason: collision with root package name */
    public final zzak f24600c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f24601d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24602e;

    /* renamed from: f, reason: collision with root package name */
    public final long f24603f;

    /* renamed from: g, reason: collision with root package name */
    public final long f24604g;

    /* renamed from: h, reason: collision with root package name */
    public final int f24605h;

    /* renamed from: i, reason: collision with root package name */
    public final int f24606i;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
    }

    public zzba(Object obj, int i2, zzak zzakVar, Object obj2, int i3, long j2, long j3, int i4, int i5) {
        this.f24598a = obj;
        this.f24599b = i2;
        this.f24600c = zzakVar;
        this.f24601d = obj2;
        this.f24602e = i3;
        this.f24603f = j2;
        this.f24604g = j3;
        this.f24605h = i4;
        this.f24606i = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzba.class == obj.getClass()) {
            zzba zzbaVar = (zzba) obj;
            if (this.f24599b == zzbaVar.f24599b && this.f24602e == zzbaVar.f24602e && this.f24603f == zzbaVar.f24603f && this.f24604g == zzbaVar.f24604g && this.f24605h == zzbaVar.f24605h && this.f24606i == zzbaVar.f24606i && Objects.equals(this.f24600c, zzbaVar.f24600c) && Objects.equals(this.f24598a, zzbaVar.f24598a) && Objects.equals(this.f24601d, zzbaVar.f24601d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f24598a, Integer.valueOf(this.f24599b), this.f24600c, this.f24601d, Integer.valueOf(this.f24602e), Long.valueOf(this.f24603f), Long.valueOf(this.f24604g), Integer.valueOf(this.f24605h), Integer.valueOf(this.f24606i));
    }

    public final String toString() {
        int i2 = this.f24599b;
        int length = String.valueOf(i2).length();
        int i3 = this.f24602e;
        int length2 = String.valueOf(i3).length();
        long j2 = this.f24603f;
        StringBuilder sb = new StringBuilder(length + 19 + length2 + 6 + String.valueOf(j2).length());
        androidx.fragment.app.e.w(i2, i3, "mediaItem=", ", period=", sb);
        sb.append(", pos=");
        sb.append(j2);
        String string = sb.toString();
        int i4 = this.f24605h;
        if (i4 == -1) {
            return string;
        }
        int length3 = string.length();
        long j3 = this.f24604g;
        int length4 = String.valueOf(i4).length() + length3 + 13 + String.valueOf(j3).length() + 10;
        int i5 = this.f24606i;
        StringBuilder sb2 = new StringBuilder(length4 + 5 + String.valueOf(i5).length());
        sb2.append(string);
        sb2.append(", contentPos=");
        sb2.append(j3);
        return androidx.fragment.app.e.n(i4, i5, ", adGroup=", ", ad=", sb2);
    }
}
