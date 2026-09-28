package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", l = {23, 24, 26, 31}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f50095a;

    /* renamed from: b, reason: collision with root package name */
    public ByteReadChannel f50096b;

    /* renamed from: c, reason: collision with root package name */
    public Function3 f50097c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50098d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f50099e;

    /* renamed from: f, reason: collision with root package name */
    public long f50100f;

    /* renamed from: g, reason: collision with root package name */
    public long f50101g;

    /* renamed from: h, reason: collision with root package name */
    public int f50102h;

    /* renamed from: i, reason: collision with root package name */
    public int f50103i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f50104j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Long f50105k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f50106l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Function3 f50107m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelUtilsKt$observable$1(Long l2, ByteReadChannel byteReadChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f50105k = l2;
        this.f50106l = byteReadChannel;
        this.f50107m = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.f50105k, this.f50106l, this.f50107m, continuation);
        byteChannelUtilsKt$observable$1.f50104j = obj;
        return byteChannelUtilsKt$observable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ByteChannelUtilsKt$observable$1) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x018f, code lost:
    
        if (r11.invoke(r2, r3, r20) == r0) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd A[Catch: all -> 0x00c2, TryCatch #3 {all -> 0x00c2, blocks: (B:41:0x00d7, B:43:0x00dd, B:46:0x00f9, B:58:0x0160, B:62:0x0171, B:32:0x00b6, B:35:0x00bd), top: B:77:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0160 A[Catch: all -> 0x00c2, TRY_ENTER, TryCatch #3 {all -> 0x00c2, blocks: (B:41:0x00d7, B:43:0x00dd, B:46:0x00f9, B:58:0x0160, B:62:0x0171, B:32:0x00b6, B:35:0x00bd), top: B:77:0x00b6 }] */
    /* JADX WARN: Type inference failed for: r13v3, types: [io.ktor.utils.io.pool.ObjectPool] */
    /* JADX WARN: Type inference failed for: r15v14, types: [io.ktor.utils.io.pool.ObjectPool] */
    /* JADX WARN: Type inference failed for: r5v9, types: [io.ktor.utils.io.pool.ObjectPool] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x014f -> B:55:0x0157). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt$observable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
