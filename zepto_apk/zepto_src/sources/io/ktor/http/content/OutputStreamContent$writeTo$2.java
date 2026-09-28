package io.ktor.http.content;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.Closeable;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.http.content.OutputStreamContent$writeTo$2", f = "OutputStreamContent.kt", l = {28}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class OutputStreamContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f50296a;

    /* renamed from: b, reason: collision with root package name */
    public int f50297b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteWriteChannel f50298c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OutputStreamContent f50299d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputStreamContent$writeTo$2(ByteWriteChannel byteWriteChannel, OutputStreamContent outputStreamContent, Continuation continuation) {
        super(1, continuation);
        this.f50298c = byteWriteChannel;
        this.f50299d = outputStreamContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OutputStreamContent$writeTo$2(this.f50298c, this.f50299d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((OutputStreamContent$writeTo$2) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int, java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ?? r0 = this.f50297b;
        try {
            if (r0 == 0) {
                ResultKt.b(obj);
                OutputStream outputStreamB = BlockingKt.b(this.f50298c);
                this.f50299d.getClass();
                this.f50296a = outputStreamB;
                this.f50297b = 1;
                throw null;
            }
            if (r0 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Closeable closeable = (Closeable) this.f50296a;
            ResultKt.b(obj);
            Unit unit = Unit.f53572a;
            CloseableKt.a(closeable, null);
            return Unit.f53572a;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(r0, th);
                throw th2;
            }
        }
    }
}
