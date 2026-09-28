package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaae {

    /* renamed from: a, reason: collision with root package name */
    public final int f22578a;

    /* renamed from: b, reason: collision with root package name */
    public final zzml[] f22579b;

    /* renamed from: c, reason: collision with root package name */
    public final zzzw[] f22580c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbn f22581d;

    /* renamed from: e, reason: collision with root package name */
    public final zzzz f22582e;

    public zzaae(zzml[] zzmlVarArr, zzzw[] zzzwVarArr, zzbn zzbnVar, zzzz zzzzVar) {
        int length = zzmlVarArr.length;
        zzgqa.a(length == zzzwVarArr.length);
        this.f22579b = zzmlVarArr;
        this.f22580c = (zzzw[]) zzzwVarArr.clone();
        this.f22581d = zzbnVar;
        this.f22582e = zzzzVar;
        this.f22578a = length;
    }

    public final boolean a(int i2) {
        return this.f22579b[i2] != null;
    }

    public final boolean b(zzaae zzaaeVar, int i2) {
        return zzaaeVar != null && Objects.equals(this.f22579b[i2], zzaaeVar.f22579b[i2]) && Objects.equals(this.f22580c[i2], zzaaeVar.f22580c[i2]);
    }
}
