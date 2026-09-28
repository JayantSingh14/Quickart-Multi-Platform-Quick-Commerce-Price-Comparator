package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzmv {

    /* renamed from: a, reason: collision with root package name */
    public final long f35232a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbf f35233b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35234c;

    /* renamed from: d, reason: collision with root package name */
    public final zzwg f35235d;

    /* renamed from: e, reason: collision with root package name */
    public final long f35236e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbf f35237f;

    /* renamed from: g, reason: collision with root package name */
    public final int f35238g;

    /* renamed from: h, reason: collision with root package name */
    public final zzwg f35239h;

    /* renamed from: i, reason: collision with root package name */
    public final long f35240i;

    /* renamed from: j, reason: collision with root package name */
    public final long f35241j;

    public zzmv(long j2, zzbf zzbfVar, int i2, zzwg zzwgVar, long j3, zzbf zzbfVar2, int i3, zzwg zzwgVar2, long j4, long j5) {
        this.f35232a = j2;
        this.f35233b = zzbfVar;
        this.f35234c = i2;
        this.f35235d = zzwgVar;
        this.f35236e = j3;
        this.f35237f = zzbfVar2;
        this.f35238g = i3;
        this.f35239h = zzwgVar2;
        this.f35240i = j4;
        this.f35241j = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmv.class == obj.getClass()) {
            zzmv zzmvVar = (zzmv) obj;
            if (this.f35232a == zzmvVar.f35232a && this.f35234c == zzmvVar.f35234c && this.f35236e == zzmvVar.f35236e && this.f35238g == zzmvVar.f35238g && this.f35240i == zzmvVar.f35240i && this.f35241j == zzmvVar.f35241j && Objects.equals(this.f35233b, zzmvVar.f35233b) && Objects.equals(this.f35235d, zzmvVar.f35235d) && Objects.equals(this.f35237f, zzmvVar.f35237f) && Objects.equals(this.f35239h, zzmvVar.f35239h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f35232a), this.f35233b, Integer.valueOf(this.f35234c), this.f35235d, Long.valueOf(this.f35236e), this.f35237f, Integer.valueOf(this.f35238g), this.f35239h, Long.valueOf(this.f35240i), Long.valueOf(this.f35241j));
    }
}
