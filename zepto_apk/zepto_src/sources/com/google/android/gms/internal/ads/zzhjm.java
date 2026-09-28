package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhjm implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f33891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f33892b;

    public zzhjm(zzhjp zzhjpVar, List list, List list2) {
        this.f33891a = list;
        this.f33892b = list2;
        Objects.requireNonNull(zzhjpVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzhjo(this.f33891a.iterator(), this.f33892b.iterator());
    }
}
