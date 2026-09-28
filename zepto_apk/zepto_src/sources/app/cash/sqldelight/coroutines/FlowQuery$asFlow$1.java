package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$asFlow$1", f = "FlowExtensions.kt", l = {47, Type.DNSKEY}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FlowQuery$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Query<Object>>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Query.Listener f13125a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f13126b;

    /* renamed from: c, reason: collision with root package name */
    public int f13127c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f13128d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Query f13129e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$asFlow$1(Query query, Continuation continuation) {
        super(2, continuation);
        this.f13129e = query;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowQuery$asFlow$1 flowQuery$asFlow$1 = new FlowQuery$asFlow$1(this.f13129e, continuation);
        flowQuery$asFlow$1.f13128d = obj;
        return flowQuery$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowQuery$asFlow$1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r9 == r0) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:18:0x0050, B:22:0x0062, B:24:0x006a, B:14:0x002d, B:17:0x004c), top: B:31:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Type inference failed for: r5v3, types: [app.cash.sqldelight.coroutines.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:8:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f13127c
            app.cash.sqldelight.Query r2 = r8.f13129e
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L31
            if (r1 == r4) goto L25
            if (r1 != r3) goto L1d
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.f13126b
            app.cash.sqldelight.Query$Listener r5 = r8.f13125a
            java.lang.Object r6 = r8.f13128d
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1b
        L19:
            r9 = r6
            goto L50
        L1b:
            r9 = move-exception
            goto L82
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.f13126b
            app.cash.sqldelight.Query$Listener r5 = r8.f13125a
            java.lang.Object r6 = r8.f13128d
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1b
            goto L62
        L31:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f13128d
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            r1 = 6
            r5 = 0
            r6 = -1
            kotlinx.coroutines.channels.BufferedChannel r1 = kotlinx.coroutines.channels.ChannelKt.a(r6, r5, r1)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            r1.i(r5)
            app.cash.sqldelight.coroutines.a r5 = new app.cash.sqldelight.coroutines.a
            r5.<init>()
            r2.c(r5)
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1b
        L50:
            r8.f13128d = r9     // Catch: java.lang.Throwable -> L1b
            r8.f13125a = r5     // Catch: java.lang.Throwable -> L1b
            r8.f13126b = r1     // Catch: java.lang.Throwable -> L1b
            r8.f13127c = r4     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r6 = r1.b(r8)     // Catch: java.lang.Throwable -> L1b
            if (r6 != r0) goto L5f
            goto L7b
        L5f:
            r7 = r6
            r6 = r9
            r9 = r7
        L62:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L1b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L1b
            if (r9 == 0) goto L7c
            r1.next()     // Catch: java.lang.Throwable -> L1b
            r8.f13128d = r6     // Catch: java.lang.Throwable -> L1b
            r8.f13125a = r5     // Catch: java.lang.Throwable -> L1b
            r8.f13126b = r1     // Catch: java.lang.Throwable -> L1b
            r8.f13127c = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r9 = r6.a(r2, r8)     // Catch: java.lang.Throwable -> L1b
            if (r9 != r0) goto L19
        L7b:
            return r0
        L7c:
            r2.d(r5)
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L82:
            r2.d(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
