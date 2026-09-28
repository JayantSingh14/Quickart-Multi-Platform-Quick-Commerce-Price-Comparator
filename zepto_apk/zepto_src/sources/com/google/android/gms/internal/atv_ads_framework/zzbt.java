package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbt extends zzbi {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object f36081c;

    public zzbt(Object obj) {
        this.f36081c = obj;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int b(Object[] objArr) {
        objArr[0] = this.f36081c;
        return 1;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f36081c.equals(obj);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb
    public final zzbe g() {
        zzbv zzbvVar = zzbe.f36045b;
        Object[] objArr = {this.f36081c};
        for (int i2 = 0; i2 < 1; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException(b.f(i2, "at index "));
            }
        }
        return zzbe.n(1, objArr);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36081c.hashCode();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    /* renamed from: i */
    public final zzbu iterator() {
        return new zzbj(this.f36081c);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzbj(this.f36081c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b.D("[", this.f36081c.toString(), "]");
    }
}
