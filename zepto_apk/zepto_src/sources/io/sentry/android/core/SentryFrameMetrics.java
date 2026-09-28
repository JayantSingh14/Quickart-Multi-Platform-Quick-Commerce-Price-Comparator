package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
final class SentryFrameMetrics {

    /* renamed from: a, reason: collision with root package name */
    public int f52196a;

    /* renamed from: b, reason: collision with root package name */
    public int f52197b;

    /* renamed from: c, reason: collision with root package name */
    public long f52198c;

    /* renamed from: d, reason: collision with root package name */
    public long f52199d;

    /* renamed from: e, reason: collision with root package name */
    public long f52200e;

    public final void a(long j2, long j3, boolean z, boolean z2) {
        this.f52200e += j2;
        if (z2) {
            this.f52199d += j3;
            this.f52197b++;
        } else if (z) {
            this.f52198c += j3;
            this.f52196a++;
        }
    }
}
