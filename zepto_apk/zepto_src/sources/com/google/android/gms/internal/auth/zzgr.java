package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgr implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f36403a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36404b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f36405c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgv f36406d;

    public final Iterator a() {
        if (this.f36405c == null) {
            this.f36405c = this.f36406d.f36411c.entrySet().iterator();
        }
        return this.f36405c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f36403a + 1;
        zzgv zzgvVar = this.f36406d;
        if (i2 >= zzgvVar.f36410b.size()) {
            return !zzgvVar.f36411c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f36404b = true;
        int i2 = this.f36403a + 1;
        this.f36403a = i2;
        zzgv zzgvVar = this.f36406d;
        return i2 < zzgvVar.f36410b.size() ? (Map.Entry) zzgvVar.f36410b.get(this.f36403a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f36404b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f36404b = false;
        int i2 = zzgv.f36408g;
        zzgv zzgvVar = this.f36406d;
        zzgvVar.f();
        if (this.f36403a >= zzgvVar.f36410b.size()) {
            a().remove();
            return;
        }
        int i3 = this.f36403a;
        this.f36403a = i3 - 1;
        zzgvVar.d(i3);
    }
}
