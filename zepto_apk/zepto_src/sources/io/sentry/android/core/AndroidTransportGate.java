package io.sentry.android.core;

import io.sentry.IConnectionStatusProvider;
import io.sentry.transport.ITransportGate;

/* loaded from: classes.dex */
final class AndroidTransportGate implements ITransportGate {

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52066a;

    /* renamed from: io.sentry.android.core.AndroidTransportGate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52067a;

        static {
            int[] iArr = new int[IConnectionStatusProvider.ConnectionStatus.values().length];
            f52067a = iArr;
            try {
                iArr[IConnectionStatusProvider.ConnectionStatus.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52067a[IConnectionStatusProvider.ConnectionStatus.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52067a[IConnectionStatusProvider.ConnectionStatus.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AndroidTransportGate(SentryAndroidOptions sentryAndroidOptions) {
        this.f52066a = sentryAndroidOptions;
    }

    @Override // io.sentry.transport.ITransportGate
    public final boolean isConnected() {
        int i2 = AnonymousClass1.f52067a[this.f52066a.getConnectionStatusProvider().b().ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3;
    }
}
