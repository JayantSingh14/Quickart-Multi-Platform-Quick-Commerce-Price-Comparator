package org.xbill.DNS;

import java.io.EOFException;
import java.io.IOException;
import java.util.function.Consumer;
import org.xbill.DNS.NioUdpClient;

/* loaded from: classes5.dex */
public final /* synthetic */ class x implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58068b;

    public /* synthetic */ x(Object obj, int i2) {
        this.f58067a = i2;
        this.f58068b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws IOException {
        switch (this.f58067a) {
            case 0:
                NioUdpClient.Transaction.access$200((NioUdpClient.Transaction) obj, (EOFException) this.f58068b);
                break;
            default:
                ((DNSOutput) this.f58068b).writeU8(((Integer) obj).intValue());
                break;
        }
    }
}
