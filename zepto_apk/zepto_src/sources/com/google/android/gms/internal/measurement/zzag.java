package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzag implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final zzao f36759a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36760b;

    public zzag() {
        this.f36759a = zzao.o0;
        this.f36760b = "return";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        return this.f36760b.equals(zzagVar.f36760b) && this.f36759a.equals(zzagVar.f36759a);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return new zzag(this.f36760b, this.f36759a.f());
    }

    public final int hashCode() {
        return this.f36759a.hashCode() + (this.f36760b.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    public zzag(String str) {
        this.f36759a = zzao.o0;
        this.f36760b = str;
    }

    public zzag(String str, zzao zzaoVar) {
        this.f36759a = zzaoVar;
        this.f36760b = str;
    }
}
