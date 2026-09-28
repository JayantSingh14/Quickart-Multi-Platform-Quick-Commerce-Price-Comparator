package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
final /* synthetic */ class zzp implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzp f21279a = new zzp();

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        List list = RequestConfiguration.f21019c;
        return list.indexOf((String) obj) - list.indexOf((String) obj2);
    }
}
