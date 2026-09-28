package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", l = {34}, m = "whileSelect")
/* loaded from: classes3.dex */
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function1 f55218a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f55219b;

    /* renamed from: c, reason: collision with root package name */
    public int f55220c;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003e -> B:13:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            r6.f55219b = r7
            int r0 = r6.f55220c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r6.f55220c = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 1
            if (r0 == 0) goto L21
            if (r0 != r2) goto L19
            kotlin.jvm.functions.Function1 r0 = r6.f55218a
            kotlin.ResultKt.b(r7)
            r3 = r0
            r0 = r6
            goto L42
        L19:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L21:
            kotlin.ResultKt.b(r7)
            r7 = 0
            r0 = r7
            r7 = r6
        L27:
            kotlinx.coroutines.selects.SelectImplementation r3 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r4 = r7.getContext()
            r3.<init>(r4)
            r0.invoke(r3)
            r7.f55218a = r0
            r7.f55220c = r2
            java.lang.Object r3 = r3.g(r7)
            if (r3 != r1) goto L3e
            return r1
        L3e:
            r5 = r0
            r0 = r7
            r7 = r3
            r3 = r5
        L42:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L4d
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L4d:
            r7 = r0
            r0 = r3
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
