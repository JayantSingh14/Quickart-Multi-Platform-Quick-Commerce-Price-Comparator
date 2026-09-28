package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes4.dex */
public final class zzidz extends zzidw implements Set, KMappedMarker {

    /* renamed from: b, reason: collision with root package name */
    public final Set f34797b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzidz(Set delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f34797b = delegate;
    }

    @Override // com.google.android.gms.internal.ads.zzidw, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return this.f34793a.contains((Map.Entry) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzidw, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new zzidy(this.f34797b.iterator());
    }
}
