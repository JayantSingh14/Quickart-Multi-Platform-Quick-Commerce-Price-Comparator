package in.juspay.airborne.ota;

import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: classes4.dex */
public final class WaitTask extends FutureTask<Unit> {
    public WaitTask() {
        super(new h(0));
    }

    public final void complete() {
        set(Unit.f53572a);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
    }
}
