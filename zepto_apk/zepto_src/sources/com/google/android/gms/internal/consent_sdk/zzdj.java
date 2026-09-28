package com.google.android.gms.internal.consent_sdk;

import android.support.v4.media.b;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzdj extends zzdf {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object f36564c;

    public zzdj(Object obj) {
        this.f36564c = obj;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final void b(Object[] objArr) {
        objArr[0] = this.f36564c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f36564c.equals(obj);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    /* renamed from: g */
    public final zzdk iterator() {
        return new zzdg(this.f36564c);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36564c.hashCode();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdg(this.f36564c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b.D("[", this.f36564c.toString(), "]");
    }
}
