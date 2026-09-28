package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class StartWorkRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Processor f12986a;

    /* renamed from: b, reason: collision with root package name */
    public final StartStopToken f12987b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkerParameters.RuntimeExtras f12988c;

    public StartWorkRunnable(Processor processor, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, "startStopToken");
        this.f12986a = processor;
        this.f12987b = startStopToken;
        this.f12988c = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f12986a.h(this.f12987b, this.f12988c);
    }
}
