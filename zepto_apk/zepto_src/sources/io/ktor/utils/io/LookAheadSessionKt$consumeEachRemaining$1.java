package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.LookAheadSessionKt", f = "LookAheadSession.kt", l = {54, Type.CDS}, m = "consumeEachRemaining")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class LookAheadSessionKt$consumeEachRemaining$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public LookAheadSuspendSession f51148a;

    /* renamed from: b, reason: collision with root package name */
    public Function2 f51149b;

    /* renamed from: c, reason: collision with root package name */
    public int f51150c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f51151d;

    /* renamed from: e, reason: collision with root package name */
    public int f51152e;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (((java.lang.Boolean) r9).booleanValue() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (r9 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        return kotlin.Unit.f53572a;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:19:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006e -> B:24:0x0071). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f51151d = r9
            int r0 = r8.f51152e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r8.f51152e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L33
            if (r0 == r3) goto L28
            if (r0 != r2) goto L20
            int r0 = r8.f51150c
            kotlin.jvm.functions.Function2 r4 = r8.f51149b
            io.ktor.utils.io.LookAheadSuspendSession r5 = r8.f51148a
            kotlin.ResultKt.b(r9)
            r6 = r0
            r0 = r8
            goto L71
        L20:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L28:
            kotlin.jvm.functions.Function2 r0 = r8.f51149b
            io.ktor.utils.io.LookAheadSuspendSession r4 = r8.f51148a
            kotlin.ResultKt.b(r9)
            r5 = r4
            r4 = r0
            r0 = r8
            goto L51
        L33:
            kotlin.ResultKt.b(r9)
            r9 = 0
            r4 = r9
            r5 = r4
            r9 = r8
        L3a:
            r0 = 0
            java.nio.ByteBuffer r0 = r5.c(r0, r3)
            if (r0 != 0) goto L5b
            r9.f51148a = r5
            r9.f51149b = r4
            r9.f51152e = r3
            java.lang.Object r0 = r5.b(r3, r9)
            if (r0 != r1) goto L4e
            goto L6d
        L4e:
            r7 = r0
            r0 = r9
            r9 = r7
        L51:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L7d
        L59:
            r9 = r0
            goto L3a
        L5b:
            int r6 = r0.remaining()
            r9.f51148a = r5
            r9.f51149b = r4
            r9.f51150c = r6
            r9.f51152e = r2
            java.lang.Object r0 = r4.invoke(r0, r9)
            if (r0 != r1) goto L6e
        L6d:
            return r1
        L6e:
            r7 = r0
            r0 = r9
            r9 = r7
        L71:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r5.B(r6)
            if (r9 == 0) goto L7d
            goto L59
        L7d:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
