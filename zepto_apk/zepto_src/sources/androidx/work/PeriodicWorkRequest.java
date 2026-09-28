package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    @Metadata
    @SourceDebugExtension
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class workerClass, long j2, TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            Intrinsics.checkNotNullParameter(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            WorkSpec workSpec = this.f12580c;
            long millis = repeatIntervalTimeUnit.toMillis(j2);
            workSpec.getClass();
            String str = WorkSpec.x;
            if (millis < 900000) {
                Logger.e().h(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
            }
            long j3 = millis < 900000 ? 900000L : millis;
            long j4 = millis < 900000 ? 900000L : millis;
            if (j3 < 900000) {
                Logger.e().h(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
            }
            workSpec.f12912h = j3 >= 900000 ? j3 : 900000L;
            if (j4 < 300000) {
                Logger.e().h(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
            }
            if (j4 > workSpec.f12912h) {
                Logger.e().h(str, "Flex duration greater than interval duration; Changed to " + j3);
            }
            workSpec.f12913i = RangesKt.c(j4, 300000L, workSpec.f12912h);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest c() {
            if (this.f12578a && this.f12580c.f12914j.f12489c) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (this.f12580c.q) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            Intrinsics.checkNotNullParameter(this, "builder");
            return new PeriodicWorkRequest(this.f12579b, this.f12580c, this.f12581d);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest.Builder d() {
            return this;
        }
    }

    @Metadata
    public static final class Companion {
    }
}
