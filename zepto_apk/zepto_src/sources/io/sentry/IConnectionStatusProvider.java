package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface IConnectionStatusProvider {

    public enum ConnectionStatus {
        UNKNOWN,
        CONNECTED,
        DISCONNECTED,
        NO_PERMISSION
    }

    public interface IConnectionStatusObserver {
        void a(ConnectionStatus connectionStatus);
    }

    String a();

    ConnectionStatus b();

    boolean c(IConnectionStatusObserver iConnectionStatusObserver);

    void d(IConnectionStatusObserver iConnectionStatusObserver);
}
