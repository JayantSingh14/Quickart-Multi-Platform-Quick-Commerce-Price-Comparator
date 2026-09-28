package androidx.lifecycle;

import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class EmittedSource implements DisposableHandle {

    /* renamed from: a, reason: collision with root package name */
    public final LiveData f4794a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineLiveData f4795b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4796c;

    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EmittedSource.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            EmittedSource emittedSource = EmittedSource.this;
            if (!emittedSource.f4796c) {
                MediatorLiveData.Source source = (MediatorLiveData.Source) emittedSource.f4795b.f4851l.f(emittedSource.f4794a);
                if (source != null) {
                    source.f4852a.j(source);
                }
                emittedSource.f4796c = true;
            }
            return Unit.f53572a;
        }
    }

    public EmittedSource(LiveData source, CoroutineLiveData mediator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediator, "mediator");
        this.f4794a = source;
        this.f4795b = mediator;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        BuildersKt.c(CoroutineScopeKt.a(MainDispatcherLoader.f55099a.O1()), null, new AnonymousClass1(null), 3);
    }
}
