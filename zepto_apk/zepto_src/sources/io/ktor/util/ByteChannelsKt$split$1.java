package io.ktor.util;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", l = {27, 31}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f50420a;

    /* renamed from: b, reason: collision with root package name */
    public int f50421b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50422c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f50423d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50424e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50425f;

    @Metadata
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", l = {29}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f50426a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBufferChannel f50427b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f50428c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f50429d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteBufferChannel byteBufferChannel, byte[] bArr, int i2, Continuation continuation) {
            super(2, continuation);
            this.f50427b = byteBufferChannel;
            this.f50428c = bArr;
            this.f50429d = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f50427b, this.f50428c, this.f50429d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f50426a;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f50426a = 1;
                if (this.f50427b.J(this.f50428c, 0, this.f50429d, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", l = {30}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f50430a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBufferChannel f50431b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f50432c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f50433d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteBufferChannel byteBufferChannel, byte[] bArr, int i2, Continuation continuation) {
            super(2, continuation);
            this.f50431b = byteBufferChannel;
            this.f50432c = bArr;
            this.f50433d = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f50431b, this.f50432c, this.f50433d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f50430a;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f50430a = 1;
                if (this.f50431b.J(this.f50432c, 0, this.f50433d, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteBufferChannel byteBufferChannel, ByteBufferChannel byteBufferChannel2, Continuation continuation) {
        super(2, continuation);
        this.f50423d = byteReadChannel;
        this.f50424e = byteBufferChannel;
        this.f50425f = byteBufferChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteChannelsKt$split$1 byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.f50423d, this.f50424e, this.f50425f, continuation);
        byteChannelsKt$split$1.f50422c = obj;
        return byteChannelsKt$split$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ByteChannelsKt$split$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
    
        if (kotlinx.coroutines.AwaitKt.a(r15, r14) != r3) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:7:0x0019, B:17:0x0042, B:19:0x0048, B:23:0x0059, B:26:0x008c, B:30:0x009e, B:14:0x002f), top: B:40:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #1 {all -> 0x001e, blocks: (B:7:0x0019, B:17:0x0042, B:19:0x0048, B:23:0x0059, B:26:0x008c, B:30:0x009e, B:14:0x002f), top: B:40:0x000d }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v6, types: [byte[], java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0089 -> B:8:0x001c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            r2 = 2
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r4 = r14.f50421b
            io.ktor.utils.io.ByteBufferChannel r5 = r14.f50425f
            io.ktor.utils.io.ByteBufferChannel r6 = r14.f50424e
            io.ktor.utils.io.ByteReadChannel r7 = r14.f50423d
            if (r4 == 0) goto L33
            if (r4 == r1) goto L29
            if (r4 != r2) goto L21
            byte[] r4 = r14.f50420a
            java.lang.Object r8 = r14.f50422c
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L1e
        L1c:
            r15 = r8
            goto L42
        L1e:
            r15 = move-exception
            goto L9f
        L21:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L29:
            byte[] r4 = r14.f50420a
            java.lang.Object r8 = r14.f50422c
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L1e
            goto L59
        L33:
            kotlin.ResultKt.b(r15)
            java.lang.Object r15 = r14.f50422c
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r4 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            java.lang.Object r4 = r4.S0()
            byte[] r4 = (byte[]) r4
        L42:
            boolean r8 = r7.K()     // Catch: java.lang.Throwable -> L1e
            if (r8 != 0) goto L8c
            r14.f50422c = r15     // Catch: java.lang.Throwable -> L1e
            r14.f50420a = r4     // Catch: java.lang.Throwable -> L1e
            r14.f50421b = r1     // Catch: java.lang.Throwable -> L1e
            int r8 = r4.length     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r8 = r7.j(r4, r0, r8, r14)     // Catch: java.lang.Throwable -> L1e
            if (r8 != r3) goto L56
            goto L8b
        L56:
            r13 = r8
            r8 = r15
            r15 = r13
        L59:
            java.lang.Number r15 = (java.lang.Number) r15     // Catch: java.lang.Throwable -> L1e
            int r15 = r15.intValue()     // Catch: java.lang.Throwable -> L1e
            io.ktor.util.ByteChannelsKt$split$1$1 r9 = new io.ktor.util.ByteChannelsKt$split$1$1     // Catch: java.lang.Throwable -> L1e
            r10 = 0
            r9.<init>(r6, r4, r15, r10)     // Catch: java.lang.Throwable -> L1e
            r11 = 3
            kotlinx.coroutines.Deferred r9 = kotlinx.coroutines.BuildersKt.a(r8, r10, r9, r11)     // Catch: java.lang.Throwable -> L1e
            io.ktor.util.ByteChannelsKt$split$1$2 r12 = new io.ktor.util.ByteChannelsKt$split$1$2     // Catch: java.lang.Throwable -> L1e
            r12.<init>(r5, r4, r15, r10)     // Catch: java.lang.Throwable -> L1e
            kotlinx.coroutines.Deferred r15 = kotlinx.coroutines.BuildersKt.a(r8, r10, r12, r11)     // Catch: java.lang.Throwable -> L1e
            kotlinx.coroutines.Deferred[] r10 = new kotlinx.coroutines.Deferred[r2]     // Catch: java.lang.Throwable -> L1e
            r10[r0] = r9     // Catch: java.lang.Throwable -> L1e
            r10[r1] = r15     // Catch: java.lang.Throwable -> L1e
            java.util.List r15 = kotlin.collections.CollectionsKt.I(r10)     // Catch: java.lang.Throwable -> L1e
            java.util.Collection r15 = (java.util.Collection) r15     // Catch: java.lang.Throwable -> L1e
            r14.f50422c = r8     // Catch: java.lang.Throwable -> L1e
            r14.f50420a = r4     // Catch: java.lang.Throwable -> L1e
            r14.f50421b = r2     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r15 = kotlinx.coroutines.AwaitKt.a(r15, r14)     // Catch: java.lang.Throwable -> L1e
            if (r15 != r3) goto L1c
        L8b:
            return r3
        L8c:
            java.lang.Throwable r15 = r7.a()     // Catch: java.lang.Throwable -> L1e
            if (r15 != 0) goto L9e
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r15 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            r15.G1(r4)
        L97:
            io.ktor.utils.io.ByteWriteChannelKt.a(r6)
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
            goto Lae
        L9e:
            throw r15     // Catch: java.lang.Throwable -> L1e
        L9f:
            r7.l(r15)     // Catch: java.lang.Throwable -> Lb1
            r6.d(r15)     // Catch: java.lang.Throwable -> Lb1
            r5.d(r15)     // Catch: java.lang.Throwable -> Lb1
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r15 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            r15.G1(r4)
            goto L97
        Lae:
            kotlin.Unit r15 = kotlin.Unit.f53572a
            return r15
        Lb1:
            r15 = move-exception
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r0 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            r0.G1(r4)
            io.ktor.utils.io.ByteWriteChannelKt.a(r6)
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$split$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
