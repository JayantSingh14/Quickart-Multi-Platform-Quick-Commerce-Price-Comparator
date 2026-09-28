package io.sentry.transport;

/* loaded from: classes.dex */
public abstract class TransportResult {

    public static final class ErrorTransportResult extends TransportResult {

        /* renamed from: a, reason: collision with root package name */
        public final int f53116a;

        public ErrorTransportResult(int i2) {
            this.f53116a = i2;
        }

        @Override // io.sentry.transport.TransportResult
        public final int a() {
            return this.f53116a;
        }

        @Override // io.sentry.transport.TransportResult
        public final boolean b() {
            return false;
        }
    }

    public static final class SuccessTransportResult extends TransportResult {

        /* renamed from: a, reason: collision with root package name */
        public static final SuccessTransportResult f53117a = new SuccessTransportResult();

        @Override // io.sentry.transport.TransportResult
        public final int a() {
            return -1;
        }

        @Override // io.sentry.transport.TransportResult
        public final boolean b() {
            return true;
        }
    }

    public abstract int a();

    public abstract boolean b();
}
