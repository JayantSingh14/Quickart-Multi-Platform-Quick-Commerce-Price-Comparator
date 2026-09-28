package com.zeptonow.horizon.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor$processBatch$3", f = "EventProcessor.kt", l = {46, Type.TLSA, Type.RKEY}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventProcessor$processBatch$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f48031a;

    /* renamed from: b, reason: collision with root package name */
    public int f48032b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventProcessor f48033c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f48034d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventProcessor$processBatch$3(EventProcessor eventProcessor, List list, Continuation continuation) {
        super(2, continuation);
        this.f48033c = eventProcessor;
        this.f48034d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventProcessor$processBatch$3(this.f48033c, this.f48034d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventProcessor$processBatch$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[PHI: r1
      0x0060: PHI (r1v2 java.lang.Object) = (r1v1 java.lang.Object), (r1v1 java.lang.Object), (r1v5 java.lang.Object) binds: [B:17:0x0044, B:19:0x005d, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r9.f48032b
            com.zeptonow.horizon.domain.EventProcessor r2 = r9.f48033c
            r3 = 3
            r4 = 2
            java.util.List r5 = r9.f48034d
            com.zeptonow.horizon.utils.DefaultLogger r6 = r2.f48005d
            r7 = 1
            if (r1 == 0) goto L32
            if (r1 == r7) goto L29
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            java.lang.Object r0 = r9.f48031a
            kotlin.ResultKt.b(r10)
            goto L7c
        L1b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L23:
            java.lang.Object r1 = r9.f48031a
            kotlin.ResultKt.b(r10)
            goto L60
        L29:
            kotlin.ResultKt.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.f53539a
        L30:
            r1 = r10
            goto L40
        L32:
            kotlin.ResultKt.b(r10)
            r9.f48032b = r7
            com.zeptonow.horizon.network.NetworkClient r10 = r2.f48003b
            java.lang.Object r10 = r10.b(r5, r9)
            if (r10 != r0) goto L30
            goto L7a
        L40:
            kotlin.Result$Companion r10 = kotlin.Result.f53538b
            boolean r10 = r1 instanceof kotlin.Result.Failure
            if (r10 != 0) goto L60
            r10 = r1
            kotlin.Unit r10 = (kotlin.Unit) r10
            com.zeptonow.horizon.utils.LogLevel r10 = com.zeptonow.horizon.utils.LogLevel.f48265c
            com.zeptonow.horizon.domain.EventProcessor$processBatch$3$1$1 r8 = new com.zeptonow.horizon.domain.EventProcessor$processBatch$3$1$1
            r8.<init>()
            r6.a(r10, r8)
            r9.f48031a = r1
            r9.f48032b = r4
            com.zeptonow.horizon.storage.EventStorage r10 = r2.f48004c
            java.lang.Object r10 = r10.d(r5, r9)
            if (r10 != r0) goto L60
            goto L7a
        L60:
            java.lang.Throwable r10 = kotlin.Result.a(r1)
            if (r10 == 0) goto L7d
            com.zeptonow.horizon.utils.LogLevel r4 = com.zeptonow.horizon.utils.LogLevel.f48265c
            com.zeptonow.horizon.domain.EventProcessor$processBatch$3$2$1 r8 = new com.zeptonow.horizon.domain.EventProcessor$processBatch$3$2$1
            r8.<init>()
            r6.a(r4, r8)
            r9.f48031a = r1
            r9.f48032b = r3
            java.lang.Object r10 = r2.b(r5, r10, r9)
            if (r10 != r0) goto L7b
        L7a:
            return r0
        L7b:
            r0 = r1
        L7c:
            r1 = r0
        L7d:
            kotlin.Result$Companion r10 = kotlin.Result.f53538b
            boolean r10 = r1 instanceof kotlin.Result.Failure
            r10 = r10 ^ r7
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventProcessor$processBatch$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
