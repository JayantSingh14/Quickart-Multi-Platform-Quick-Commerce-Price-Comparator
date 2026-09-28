package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
class zzgrc extends zzgrt implements zzgty {
    public final Collection e(Object obj, Collection collection) {
        List list = (List) collection;
        return list instanceof RandomAccess ? new zzgrm(this, obj, list, null) : new zzgrs(this, obj, list, null);
    }
}
