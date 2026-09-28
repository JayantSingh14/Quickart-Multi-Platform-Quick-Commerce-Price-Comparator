package io.sentry;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52669a;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f52669a) {
            case 0:
                HostnameCache hostnameCache = HostnameCache.f51644i;
                return InetAddress.getLocalHost();
            case 1:
                return null;
            default:
                return new ArrayList();
        }
    }
}
