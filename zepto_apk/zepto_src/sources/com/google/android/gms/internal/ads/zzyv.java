package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
final /* synthetic */ class zzyv implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzyv f35930a = new zzyv();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        List list = (List) obj2;
        List list2 = (List) obj;
        return zzgso.f(zzzt.b((zzzt) Collections.max(list2, zzzs.f35978a), (zzzt) Collections.max(list, zzzn.f35974a))).b(list2.size(), list.size()).a((zzzt) Collections.max(list2, zzzp.f35975a), (zzzt) Collections.max(list, zzzq.f35976a), zzzr.f35977a).e();
    }
}
