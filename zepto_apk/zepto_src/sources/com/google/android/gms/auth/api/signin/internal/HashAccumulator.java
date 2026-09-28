package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes4.dex */
public class HashAccumulator {

    /* renamed from: a, reason: collision with root package name */
    public int f22195a = 1;

    public final void a(Object obj) {
        this.f22195a = (this.f22195a * 31) + (obj == null ? 0 : obj.hashCode());
    }
}
