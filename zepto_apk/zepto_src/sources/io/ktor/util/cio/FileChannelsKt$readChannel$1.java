package io.ktor.util.cio;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.CloseableJVMKt;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", l = {44, 63}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FileChannelsKt$readChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50513a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50514b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f50515c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$readChannel$1(long j2, Continuation continuation) {
        super(2, continuation);
        this.f50515c = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileChannelsKt$readChannel$1 fileChannelsKt$readChannel$1 = new FileChannelsKt$readChannel$1(this.f50515c, continuation);
        fileChannelsKt$readChannel$1.f50514b = obj;
        return fileChannelsKt$readChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileChannelsKt$readChannel$1) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Closeable closeable;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50513a;
        if (i2 == 0) {
            ResultKt.b(obj);
            WriterScope writerScope = (WriterScope) this.f50514b;
            long j2 = this.f50515c;
            if (-1 > j2 - 1) {
                throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j2 + ", endInclusive = -1").toString());
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile((File) null, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "file.channel");
                ByteChannel byteChannelL0 = writerScope.l0();
                FileChannelsKt$readChannel$1$3$1 fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(writerScope, channel, null);
                this.f50514b = randomAccessFile;
                this.f50513a = 1;
                if (byteChannelL0.m(fileChannelsKt$readChannel$1$3$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                closeable = randomAccessFile;
            } catch (Throwable th) {
                th = th;
                closeable = randomAccessFile;
                closeable.close();
                throw th;
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeable = (Closeable) this.f50514b;
            try {
                ResultKt.b(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    closeable.close();
                } catch (Throwable th3) {
                    CloseableJVMKt.a(th, th3);
                }
                throw th;
            }
        }
        Unit unit = Unit.f53572a;
        closeable.close();
        return Unit.f53572a;
    }
}
