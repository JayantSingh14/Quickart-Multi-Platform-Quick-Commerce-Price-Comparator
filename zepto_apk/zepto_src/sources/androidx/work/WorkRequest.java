package androidx.work;

import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public abstract class WorkRequest {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f12575a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkSpec f12576b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f12577c;

    @Metadata
    @SourceDebugExtension
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12578a;

        /* renamed from: b, reason: collision with root package name */
        public UUID f12579b;

        /* renamed from: c, reason: collision with root package name */
        public WorkSpec f12580c;

        /* renamed from: d, reason: collision with root package name */
        public final LinkedHashSet f12581d;

        public Builder(Class workerClass) {
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.f12579b = uuidRandomUUID;
            String id = this.f12579b.toString();
            Intrinsics.checkNotNullExpressionValue(id, "id.toString()");
            String workerClassName_ = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(workerClassName_, "workerClass.name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(workerClassName_, "workerClassName_");
            this.f12580c = new WorkSpec(id, (WorkInfo.State) null, workerClassName_, (String) null, (Data) null, (Data) null, 0L, 0L, 0L, (Constraints) null, 0, (BackoffPolicy) null, 0L, 0L, 0L, 0L, false, (OutOfQuotaPolicy) null, 0, 0L, 0, 0, 8388602);
            String name = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
            this.f12581d = SetsKt.c(name);
        }

        public final Builder a(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.f12581d.add(tag);
            return d();
        }

        public final WorkRequest b() {
            WorkRequest workRequestC = c();
            Constraints constraints = this.f12580c.f12914j;
            boolean z = !constraints.f12494h.isEmpty() || constraints.f12490d || constraints.f12488b || constraints.f12489c;
            WorkSpec workSpec = this.f12580c;
            if (workSpec.q) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (workSpec.f12911g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            UUID id = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(id, "randomUUID()");
            Intrinsics.checkNotNullParameter(id, "id");
            this.f12579b = id;
            String newId = id.toString();
            Intrinsics.checkNotNullExpressionValue(newId, "id.toString()");
            WorkSpec other = this.f12580c;
            Intrinsics.checkNotNullParameter(newId, "newId");
            Intrinsics.checkNotNullParameter(other, "other");
            this.f12580c = new WorkSpec(newId, other.f12906b, other.f12907c, other.f12908d, new Data(other.f12909e), new Data(other.f12910f), other.f12911g, other.f12912h, other.f12913i, new Constraints(other.f12914j), other.f12915k, other.f12916l, other.f12917m, other.n, other.o, other.p, other.q, other.r, other.s, other.u, other.v, other.w, 524288);
            return workRequestC;
        }

        public abstract WorkRequest c();

        public abstract Builder d();

        public final Builder e(Constraints constraints) {
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            this.f12580c.f12914j = constraints;
            return d();
        }

        public final Builder f(long j2, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.f12580c.f12911g = timeUnit.toMillis(j2);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f12580c.f12911g) {
                return d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final Builder g(Data inputData) {
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            this.f12580c.f12909e = inputData;
            return d();
        }
    }

    @Metadata
    public static final class Companion {
    }

    public WorkRequest(UUID id, WorkSpec workSpec, LinkedHashSet tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f12575a = id;
        this.f12576b = workSpec;
        this.f12577c = tags;
    }
}
