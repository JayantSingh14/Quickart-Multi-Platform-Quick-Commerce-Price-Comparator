package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
final /* synthetic */ class zzza implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzza f35946a = new zzza();

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Integer num = (Integer) obj2;
        Integer num2 = (Integer) obj;
        zzgux zzguxVar = zzzu.f35988k;
        if (num2.intValue() == -1) {
            return num.intValue() == -1 ? 0 : -1;
        }
        if (num.intValue() == -1) {
            return 1;
        }
        return num2.intValue() - num.intValue();
    }
}
