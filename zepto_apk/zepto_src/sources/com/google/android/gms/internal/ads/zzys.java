package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
final /* synthetic */ class zzys implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzys f35927a = new zzys();

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzyr) Collections.max((List) obj)).compareTo((zzyr) Collections.max((List) obj2));
    }
}
