package androidx.datastore.core;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SimpleActor<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f3614a;

    /* renamed from: b, reason: collision with root package name */
    public final Function2 f3615b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferedChannel f3616c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInt f3617d;

    public SimpleActor(CoroutineScope scope, final Function1 onComplete, Function2 consumeMessage) {
        DataStoreImpl$writeActor$2 onUndeliveredElement = DataStoreImpl$writeActor$2.f3527c;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onUndeliveredElement, "onUndeliveredElement");
        Intrinsics.checkNotNullParameter(consumeMessage, "consumeMessage");
        this.f3614a = scope;
        this.f3615b = consumeMessage;
        this.f3616c = ChannelKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, 6);
        this.f3617d = new AtomicInt();
        Job job = (Job) scope.r().get(Job.Key.f54121a);
        if (job != null) {
            job.j0(new Function1<Throwable, Unit>() { // from class: androidx.datastore.core.SimpleActor.1

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ Function2 f3620e = DataStoreImpl$writeActor$2.f3527c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Throwable th = (Throwable) obj;
                    ((DataStoreImpl$writeActor$1) onComplete).invoke(th);
                    SimpleActor simpleActor = this;
                    simpleActor.f3616c.s(false, th);
                    do {
                        Object objB = ChannelResult.b(simpleActor.f3616c.m());
                        if (objB != null) {
                            DataStoreImpl$writeActor$2.f3527c.invoke(objB, th);
                            unit = Unit.f53572a;
                        } else {
                            unit = null;
                        }
                    } while (unit != null);
                    return Unit.f53572a;
                }
            });
        }
    }
}
