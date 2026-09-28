package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzafa implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f37476a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37477b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f37478c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzafe f37479d;

    public final Iterator a() {
        if (this.f37478c == null) {
            this.f37478c = this.f37479d.f37484c.entrySet().iterator();
        }
        return this.f37478c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f37476a + 1;
        zzafe zzafeVar = this.f37479d;
        if (i2 >= zzafeVar.f37483b.size()) {
            return !zzafeVar.f37484c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f37477b = true;
        int i2 = this.f37476a + 1;
        this.f37476a = i2;
        zzafe zzafeVar = this.f37479d;
        return i2 < zzafeVar.f37483b.size() ? (Map.Entry) zzafeVar.f37483b.get(this.f37476a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f37477b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f37477b = false;
        int i2 = zzafe.f37481g;
        zzafe zzafeVar = this.f37479d;
        zzafeVar.f();
        if (this.f37476a >= zzafeVar.f37483b.size()) {
            a().remove();
            return;
        }
        int i3 = this.f37476a;
        this.f37476a = i3 - 1;
        zzafeVar.d(i3);
    }
}
