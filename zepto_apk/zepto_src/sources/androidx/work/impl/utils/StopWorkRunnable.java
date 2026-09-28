package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class StopWorkRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Processor f12992a;

    /* renamed from: b, reason: collision with root package name */
    public final StartStopToken f12993b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12994c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12995d;

    public StopWorkRunnable(Processor processor, StartStopToken token, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
        this.f12992a = processor;
        this.f12993b = token;
        this.f12994c = z;
        this.f12995d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        WorkerWrapper workerWrapperB;
        if (this.f12994c) {
            Processor processor = this.f12992a;
            StartStopToken startStopToken = this.f12993b;
            int i2 = this.f12995d;
            processor.getClass();
            String str = startStopToken.f12629a.f12893a;
            synchronized (processor.f12626k) {
                workerWrapperB = processor.b(str);
            }
            zD = Processor.d(str, workerWrapperB, i2);
        } else {
            Processor processor2 = this.f12992a;
            StartStopToken startStopToken2 = this.f12993b;
            int i3 = this.f12995d;
            processor2.getClass();
            String str2 = startStopToken2.f12629a.f12893a;
            synchronized (processor2.f12626k) {
                try {
                    if (processor2.f12621f.get(str2) != null) {
                        Logger.e().a(Processor.f12615l, "Ignored stopWork. WorkerWrapper " + str2 + " is in foreground");
                    } else {
                        Set set = (Set) processor2.f12623h.get(str2);
                        if (set != null && set.contains(startStopToken2)) {
                            zD = Processor.d(str2, processor2.b(str2), i3);
                        }
                    }
                    zD = false;
                } finally {
                }
            }
        }
        Logger.e().a(Logger.g("StopWorkRunnable"), "StopWorkRunnable for " + this.f12993b.f12629a.f12893a + "; Processor.stopWork = " + zD);
    }
}
