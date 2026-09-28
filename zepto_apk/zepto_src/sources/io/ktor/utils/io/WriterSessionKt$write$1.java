package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", l = {22, 29, 29}, m = "write")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class WriterSessionKt$write$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f51167a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51168b;

    /* renamed from: c, reason: collision with root package name */
    public int f51169c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteWriteChannel byteWriteChannel;
        this.f51168b = obj;
        int i2 = (this.f51169c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51169c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51167a = null;
            this.f51169c = 1;
            obj = WriterSessionKt.c(null, 0, this);
            if (obj != coroutineSingletons) {
                byteWriteChannel = null;
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                Integer num = (Integer) this.f51167a;
                ResultKt.b(obj);
                return num;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th = (Throwable) this.f51167a;
            ResultKt.b(obj);
            throw th;
        }
        byteWriteChannel = (ByteWriteChannel) this.f51167a;
        ResultKt.b(obj);
        Buffer buffer = (Buffer) obj;
        if (buffer == null) {
            buffer = ChunkBuffer.f51216l;
        }
        try {
            ByteBuffer byteBuffer = buffer.f51180a;
            new Long(buffer.f51182c);
            new Long(buffer.f51184e);
            throw null;
        } catch (Throwable th2) {
            this.f51167a = th2;
            this.f51169c = 3;
            if (WriterSessionKt.a(byteWriteChannel, buffer, 0, this) != coroutineSingletons) {
                throw th2;
            }
        }
    }
}
