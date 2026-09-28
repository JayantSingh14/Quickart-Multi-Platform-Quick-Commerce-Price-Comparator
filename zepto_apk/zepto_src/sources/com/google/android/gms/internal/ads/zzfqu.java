package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfqu implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzfqu f31663a = new zzfqu();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzfqm zzfqmVar = (zzfqm) obj2;
        zzfqm zzfqmVar2 = (zzfqm) obj;
        int iCompare = Double.compare(zzfqmVar.f31650e, zzfqmVar2.f31650e);
        return iCompare == 0 ? Long.compare(zzfqmVar2.f31647b, zzfqmVar.f31647b) : iCompare;
    }
}
