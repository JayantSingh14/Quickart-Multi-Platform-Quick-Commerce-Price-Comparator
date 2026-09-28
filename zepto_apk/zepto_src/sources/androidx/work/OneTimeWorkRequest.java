package androidx.work;

import androidx.work.WorkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    @Metadata
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest c() {
            if (this.f12578a && this.f12580c.f12914j.f12489c) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            Intrinsics.checkNotNullParameter(this, "builder");
            return new OneTimeWorkRequest(this.f12579b, this.f12580c, this.f12581d);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest.Builder d() {
            return this;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }
}
