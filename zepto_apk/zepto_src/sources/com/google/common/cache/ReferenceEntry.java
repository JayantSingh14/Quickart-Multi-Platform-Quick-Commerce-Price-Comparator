package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.cache.LocalCache;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
interface ReferenceEntry<K, V> {
    LocalCache.ValueReference a();

    int b();

    ReferenceEntry c();

    ReferenceEntry d();

    ReferenceEntry e();

    ReferenceEntry g();

    Object getKey();

    void h(ReferenceEntry referenceEntry);

    ReferenceEntry i();

    void l(LocalCache.ValueReference valueReference);

    long n();

    void p(long j2);

    long q();

    void r(long j2);

    void s(ReferenceEntry referenceEntry);

    void t(ReferenceEntry referenceEntry);

    void u(ReferenceEntry referenceEntry);
}
