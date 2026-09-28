package org.xbill.DNS;

import java.util.concurrent.CompletableFuture;
import org.xbill.DNS.Zone;

/* loaded from: classes5.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57915a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f57916b;

    public /* synthetic */ a0(Object obj, int i2) {
        this.f57915a = i2;
        this.f57916b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f57915a) {
            case 0:
                TimeoutCompletableFuture.lambda$orTimeout$0((CompletableFuture) this.f57916b);
                break;
            default:
                ((Zone.ZoneIterator) this.f57916b).lambda$remove$2();
                break;
        }
    }
}
