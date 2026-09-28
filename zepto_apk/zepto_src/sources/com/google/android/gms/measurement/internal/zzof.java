package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
final class zzof {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f39542a;

    /* renamed from: b, reason: collision with root package name */
    public long f39543b;

    public zzof(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f39542a = clock;
    }
}
