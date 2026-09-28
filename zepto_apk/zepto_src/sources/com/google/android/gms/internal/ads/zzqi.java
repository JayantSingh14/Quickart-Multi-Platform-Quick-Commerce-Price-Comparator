package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzqi {

    /* renamed from: a, reason: collision with root package name */
    public final int f35392a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35393b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35394c;

    /* renamed from: d, reason: collision with root package name */
    public final int f35395d;

    /* renamed from: e, reason: collision with root package name */
    public final zzd f35396e;

    /* renamed from: f, reason: collision with root package name */
    public final int f35397f;

    /* renamed from: g, reason: collision with root package name */
    public final int f35398g;

    public /* synthetic */ zzqi(zzqh zzqhVar) {
        this.f35392a = zzqhVar.f35385a;
        this.f35393b = zzqhVar.f35386b;
        this.f35394c = zzqhVar.f35387c;
        this.f35395d = zzqhVar.f35388d;
        this.f35396e = zzqhVar.f35389e;
        this.f35397f = zzqhVar.f35390f;
        this.f35398g = zzqhVar.f35391g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzqi.class == obj.getClass()) {
            zzqi zzqiVar = (zzqi) obj;
            if (this.f35392a == zzqiVar.f35392a && this.f35393b == zzqiVar.f35393b && this.f35394c == zzqiVar.f35394c && this.f35395d == zzqiVar.f35395d && this.f35397f == zzqiVar.f35397f && this.f35398g == zzqiVar.f35398g && this.f35396e.equals(zzqiVar.f35396e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f35392a);
        Integer numValueOf2 = Integer.valueOf(this.f35393b);
        Integer numValueOf3 = Integer.valueOf(this.f35394c);
        Boolean bool = Boolean.FALSE;
        return Objects.hash(numValueOf, numValueOf2, numValueOf3, bool, bool, Integer.valueOf(this.f35395d), this.f35396e, Integer.valueOf(this.f35397f), Integer.valueOf(this.f35398g), bool, bool);
    }
}
