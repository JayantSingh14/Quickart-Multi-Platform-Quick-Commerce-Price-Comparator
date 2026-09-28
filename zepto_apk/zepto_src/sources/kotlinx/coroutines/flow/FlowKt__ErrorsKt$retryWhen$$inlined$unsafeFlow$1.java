package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<Object> {

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", l = {WKSRecord.Service.AUTH, WKSRecord.Service.SFTP}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f54651a;

        /* renamed from: b, reason: collision with root package name */
        public int f54652b;

        /* renamed from: d, reason: collision with root package name */
        public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 f54654d;

        /* renamed from: e, reason: collision with root package name */
        public FlowCollector f54655e;

        /* renamed from: f, reason: collision with root package name */
        public Throwable f54656f;

        /* renamed from: g, reason: collision with root package name */
        public long f54657g;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f54651a = obj;
            this.f54652b |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.c(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0074 -> B:27:0x0075). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlinx.coroutines.flow.FlowCollector r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f54652b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54652b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f54651a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54652b
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L49
            if (r2 != r3) goto L41
            long r6 = r0.f54657g
            java.lang.Throwable r10 = r0.f54656f
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f54655e
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r8 = r0.f54654d
            kotlin.ResultKt.b(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L40
            r10 = 1
            long r6 = r6 + r10
            r10 = r2
            r11 = r5
            goto L75
        L40:
            throw r10
        L41:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L49:
            long r6 = r0.f54657g
            kotlinx.coroutines.flow.FlowCollector r10 = r0.f54655e
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r2 = r0.f54654d
            kotlin.ResultKt.b(r11)
            r8 = r2
            goto L70
        L54:
            kotlin.ResultKt.b(r11)
            r6 = 0
            r11 = r9
        L5a:
            r11.getClass()
            r0.f54654d = r11
            r0.f54655e = r10
            r0.f54656f = r4
            r0.f54657g = r6
            r0.f54652b = r5
            java.io.Serializable r2 = kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(r0, r4, r10)
            if (r2 != r1) goto L6e
            return r1
        L6e:
            r8 = r11
            r11 = r2
        L70:
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            if (r11 != 0) goto L7c
            r11 = 0
        L75:
            if (r11 != 0) goto L7a
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        L7a:
            r11 = r8
            goto L5a
        L7c:
            r8.getClass()
            java.lang.Long r1 = new java.lang.Long
            r1.<init>(r6)
            r0.f54654d = r8
            r0.f54655e = r10
            r0.f54656f = r11
            r0.f54657g = r6
            r0.f54652b = r3
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.c(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
