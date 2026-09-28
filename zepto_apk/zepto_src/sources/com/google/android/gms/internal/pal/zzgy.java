package com.google.android.gms.internal.pal;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzgy extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f37783a;

    public zzgy(int i2) {
        super(android.support.v4.media.b.f(i2, "Signal SDK error code: "));
        this.f37783a = i2;
    }
}
