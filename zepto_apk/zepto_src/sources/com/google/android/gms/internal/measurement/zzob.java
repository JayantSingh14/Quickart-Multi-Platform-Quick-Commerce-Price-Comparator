package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzob implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f37176a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37177b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f37178c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzod f37179d;

    public /* synthetic */ zzob(zzod zzodVar) {
        Objects.requireNonNull(zzodVar);
        this.f37179d = zzodVar;
        this.f37176a = -1;
    }

    public final Iterator a() {
        if (this.f37178c == null) {
            this.f37178c = this.f37179d.f37183c.entrySet().iterator();
        }
        return this.f37178c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f37176a + 1;
        zzod zzodVar = this.f37179d;
        if (i2 >= zzodVar.f37182b) {
            return !zzodVar.f37183c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f37177b = true;
        int i2 = this.f37176a + 1;
        this.f37176a = i2;
        zzod zzodVar = this.f37179d;
        return i2 < zzodVar.f37182b ? (zzoa) zzodVar.f37181a[i2] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f37177b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f37177b = false;
        zzod zzodVar = this.f37179d;
        zzodVar.g();
        int i2 = this.f37176a;
        if (i2 >= zzodVar.f37182b) {
            a().remove();
        } else {
            this.f37176a = i2 - 1;
            zzodVar.e(i2);
        }
    }
}
