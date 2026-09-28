package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzfh implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f36189a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36190b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f36191c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfl f36192d;

    public final Iterator a() {
        if (this.f36191c == null) {
            this.f36191c = this.f36192d.f36197c.entrySet().iterator();
        }
        return this.f36191c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f36189a + 1;
        zzfl zzflVar = this.f36192d;
        if (i2 >= zzflVar.f36196b.size()) {
            return !zzflVar.f36197c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f36190b = true;
        int i2 = this.f36189a + 1;
        this.f36189a = i2;
        zzfl zzflVar = this.f36192d;
        return i2 < zzflVar.f36196b.size() ? (Map.Entry) zzflVar.f36196b.get(this.f36189a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f36190b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f36190b = false;
        int i2 = zzfl.f36194g;
        zzfl zzflVar = this.f36192d;
        zzflVar.f();
        if (this.f36189a >= zzflVar.f36196b.size()) {
            a().remove();
            return;
        }
        int i3 = this.f36189a;
        this.f36189a = i3 - 1;
        zzflVar.d(i3);
    }
}
