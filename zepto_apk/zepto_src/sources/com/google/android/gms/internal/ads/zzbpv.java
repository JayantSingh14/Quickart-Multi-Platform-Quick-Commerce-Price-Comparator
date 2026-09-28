package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbpv implements InitializationStatus {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f25417a;

    public zzbpv(HashMap map) {
        this.f25417a = map;
    }

    @Override // com.google.android.gms.ads.initialization.InitializationStatus
    public final Map a() {
        return this.f25417a;
    }
}
