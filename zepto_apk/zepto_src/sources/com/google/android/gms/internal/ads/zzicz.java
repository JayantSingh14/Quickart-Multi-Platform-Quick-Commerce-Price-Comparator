package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzicz implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f34747a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f34748b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f34749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzidb f34750d;

    public /* synthetic */ zzicz(zzidb zzidbVar) {
        Objects.requireNonNull(zzidbVar);
        this.f34750d = zzidbVar;
        this.f34747a = -1;
    }

    public final Iterator a() {
        if (this.f34749c == null) {
            this.f34749c = this.f34750d.f34756c.entrySet().iterator();
        }
        return this.f34749c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f34747a + 1;
        zzidb zzidbVar = this.f34750d;
        if (i2 >= zzidbVar.f34755b) {
            return !zzidbVar.f34756c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f34748b = true;
        int i2 = this.f34747a + 1;
        this.f34747a = i2;
        zzidb zzidbVar = this.f34750d;
        return i2 < zzidbVar.f34755b ? (zzicy) zzidbVar.f34754a[i2] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f34748b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f34748b = false;
        zzidb zzidbVar = this.f34750d;
        zzidbVar.g();
        int i2 = this.f34747a;
        if (i2 >= zzidbVar.f34755b) {
            a().remove();
        } else {
            this.f34747a = i2 - 1;
            zzidbVar.e(i2);
        }
    }
}
