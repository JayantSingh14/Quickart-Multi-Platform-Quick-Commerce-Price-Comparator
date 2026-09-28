package com.google.android.gms.internal.fido;

import android.support.v4.media.b;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzay extends zzau {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object f36598c;

    public zzay(Object obj) {
        this.f36598c = obj;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final void b(Object[] objArr) {
        objArr[0] = this.f36598c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f36598c.equals(obj);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    /* renamed from: g */
    public final zzaz iterator() {
        return new zzav(this.f36598c);
    }

    @Override // com.google.android.gms.internal.fido.zzau, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36598c.hashCode();
    }

    @Override // com.google.android.gms.internal.fido.zzau, com.google.android.gms.internal.fido.zzaq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzav(this.f36598c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b.D("[", this.f36598c.toString(), "]");
    }
}
