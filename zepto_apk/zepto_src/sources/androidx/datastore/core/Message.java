package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

@Metadata
/* loaded from: classes3.dex */
public abstract class Message<T> {

    @Metadata
    public static final class Read<T> extends Message<T> {
    }

    @Metadata
    public static final class Update<T> extends Message<T> {

        /* renamed from: a, reason: collision with root package name */
        public final SuspendLambda f3580a;

        /* renamed from: b, reason: collision with root package name */
        public final CompletableDeferred f3581b;

        /* renamed from: c, reason: collision with root package name */
        public final State f3582c;

        /* renamed from: d, reason: collision with root package name */
        public final CoroutineContext f3583d;

        /* JADX WARN: Multi-variable type inference failed */
        public Update(Function2 transform, CompletableDeferred ack, State state, CoroutineContext callerContext) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            Intrinsics.checkNotNullParameter(ack, "ack");
            Intrinsics.checkNotNullParameter(callerContext, "callerContext");
            this.f3580a = (SuspendLambda) transform;
            this.f3581b = ack;
            this.f3582c = state;
            this.f3583d = callerContext;
        }

        public final CompletableDeferred a() {
            return this.f3581b;
        }

        public final CoroutineContext b() {
            return this.f3583d;
        }

        public final State c() {
            return this.f3582c;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
        public final Function2 d() {
            return this.f3580a;
        }
    }
}
