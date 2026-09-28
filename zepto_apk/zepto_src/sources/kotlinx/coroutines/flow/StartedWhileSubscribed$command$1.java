package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {174, 176, 178, 179, 181}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54911a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ FlowCollector f54912b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f54913c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StartedWhileSubscribed f54914d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation continuation) {
        super(3, continuation);
        this.f54914d = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.f54914d, (Continuation) obj3);
        startedWhileSubscribed$command$1.f54912b = (FlowCollector) obj;
        startedWhileSubscribed$command$1.f54913c = iIntValue;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r9.a(r1, r8) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r1.a(r9, r8) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f54911a
            r2 = 0
            r4 = 5
            r5 = 2
            r6 = 1
            kotlinx.coroutines.flow.StartedWhileSubscribed r7 = r8.f54914d
            if (r1 == 0) goto L45
            if (r1 == r6) goto L41
            if (r1 == r5) goto L3b
            r5 = 3
            r6 = 4
            if (r1 == r5) goto L28
            if (r1 == r6) goto L22
            if (r1 != r4) goto L1a
            goto L41
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.f54912b
            kotlin.ResultKt.b(r9)
            goto L6b
        L28:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.f54912b
            kotlin.ResultKt.b(r9)
            r7.getClass()
            r8.f54912b = r1
            r8.f54911a = r6
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.a(r2, r8)
            if (r9 != r0) goto L6b
            goto L78
        L3b:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.f54912b
            kotlin.ResultKt.b(r9)
            goto L68
        L41:
            kotlin.ResultKt.b(r9)
            goto L79
        L45:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r8.f54912b
            int r1 = r8.f54913c
            if (r1 <= 0) goto L59
            kotlinx.coroutines.flow.SharingCommand r1 = kotlinx.coroutines.flow.SharingCommand.f54897a
            r8.f54911a = r6
            java.lang.Object r9 = r9.a(r1, r8)
            if (r9 != r0) goto L79
            goto L78
        L59:
            r7.getClass()
            r8.f54912b = r9
            r8.f54911a = r5
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.a(r2, r8)
            if (r1 != r0) goto L67
            goto L78
        L67:
            r1 = r9
        L68:
            r7.getClass()
        L6b:
            kotlinx.coroutines.flow.SharingCommand r9 = kotlinx.coroutines.flow.SharingCommand.f54898b
            r2 = 0
            r8.f54912b = r2
            r8.f54911a = r4
            java.lang.Object r9 = r1.a(r9, r8)
            if (r9 != r0) goto L79
        L78:
            return r0
        L79:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
