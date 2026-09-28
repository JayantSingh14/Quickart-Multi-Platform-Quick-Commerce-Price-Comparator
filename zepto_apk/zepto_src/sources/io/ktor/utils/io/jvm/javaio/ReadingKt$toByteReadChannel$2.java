package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", l = {90}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ReadingKt$toByteReadChannel$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f51340a;

    /* renamed from: b, reason: collision with root package name */
    public int f51341b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51342c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteArrayPoolKt$ByteArrayPool$1 f51343d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ InputStream f51344e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingKt$toByteReadChannel$2(ByteArrayPoolKt$ByteArrayPool$1 byteArrayPoolKt$ByteArrayPool$1, InputStream inputStream, Continuation continuation) {
        super(2, continuation);
        this.f51343d = byteArrayPoolKt$ByteArrayPool$1;
        this.f51344e = inputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2 = new ReadingKt$toByteReadChannel$2(this.f51343d, this.f51344e, continuation);
        readingKt$toByteReadChannel$2.f51342c = obj;
        return readingKt$toByteReadChannel$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ReadingKt$toByteReadChannel$2) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        byte[] bArr;
        WriterScope writerScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f51341b;
        InputStream inputStream = this.f51344e;
        ByteArrayPoolKt$ByteArrayPool$1 byteArrayPoolKt$ByteArrayPool$1 = this.f51343d;
        if (i2 == 0) {
            ResultKt.b(obj);
            WriterScope writerScope2 = (WriterScope) this.f51342c;
            bArr = (byte[]) byteArrayPoolKt$ByteArrayPool$1.S0();
            writerScope = writerScope2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bArr = this.f51340a;
            writerScope = (WriterScope) this.f51342c;
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                try {
                    writerScope.l0().d(th);
                    byteArrayPoolKt$ByteArrayPool$1.G1(bArr);
                } catch (Throwable th2) {
                    byteArrayPoolKt$ByteArrayPool$1.G1(bArr);
                    inputStream.close();
                    throw th2;
                }
            }
        }
        while (true) {
            int i3 = inputStream.read(bArr, 0, bArr.length);
            if (i3 < 0) {
                byteArrayPoolKt$ByteArrayPool$1.G1(bArr);
                break;
            }
            if (i3 != 0) {
                ByteChannel byteChannelL0 = writerScope.l0();
                this.f51342c = writerScope;
                this.f51340a = bArr;
                this.f51341b = 1;
                if (byteChannelL0.J(bArr, 0, i3, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        inputStream.close();
        return Unit.f53572a;
    }
}
