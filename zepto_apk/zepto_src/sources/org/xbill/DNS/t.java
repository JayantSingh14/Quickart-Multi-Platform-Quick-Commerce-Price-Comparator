package org.xbill.DNS;

import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.ScheduledFuture;
import java.util.function.BiConsumer;
import org.xbill.DNS.NioTcpClient;

/* loaded from: classes5.dex */
public final /* synthetic */ class t implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58053a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58054b;

    public /* synthetic */ t(Object obj, int i2) {
        this.f58053a = i2;
        this.f58054b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) throws IOException {
        switch (this.f58053a) {
            case 0:
                NioTcpClient.lambda$closeTcp$0((EOFException) this.f58054b, (NioTcpClient.ChannelKey) obj, (NioTcpClient.ChannelState) obj2);
                break;
            default:
                TimeoutCompletableFuture.lambda$orTimeout$1((ScheduledFuture) this.f58054b, obj, (Throwable) obj2);
                break;
        }
    }
}
