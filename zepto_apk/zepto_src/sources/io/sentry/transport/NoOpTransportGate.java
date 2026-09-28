package io.sentry.transport;

/* loaded from: classes.dex */
public final class NoOpTransportGate implements ITransportGate {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpTransportGate f53099a = new NoOpTransportGate();

    @Override // io.sentry.transport.ITransportGate
    public final boolean isConnected() {
        return true;
    }
}
