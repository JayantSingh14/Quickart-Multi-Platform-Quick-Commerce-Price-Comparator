package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WritingKt", f = "Writing.kt", l = {50}, m = "copyTo")
/* loaded from: classes3.dex */
final class WritingKt$copyTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteReadChannel f51361a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.LongRef f51362b;

    /* renamed from: c, reason: collision with root package name */
    public Function1 f51363c;

    /* renamed from: d, reason: collision with root package name */
    public long f51364d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f51365e;

    /* renamed from: f, reason: collision with root package name */
    public int f51366f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        WritingKt$copyTo$1 writingKt$copyTo$1;
        this.f51365e = obj;
        int i2 = this.f51366f | Integer.MIN_VALUE;
        this.f51366f = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51366f = i2 - Integer.MIN_VALUE;
            writingKt$copyTo$1 = this;
        } else {
            writingKt$copyTo$1 = new WritingKt$copyTo$1(this);
        }
        Object obj2 = writingKt$copyTo$1.f51365e;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = writingKt$copyTo$1.f51366f;
        if (i3 == 0) {
            ResultKt.b(obj2);
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j2 = writingKt$copyTo$1.f51364d;
        Function1 function1 = writingKt$copyTo$1.f51363c;
        Ref.LongRef longRef = writingKt$copyTo$1.f51362b;
        ByteReadChannel byteReadChannel = writingKt$copyTo$1.f51361a;
        ResultKt.b(obj2);
        while (!byteReadChannel.K() && longRef.f53800a < j2) {
            writingKt$copyTo$1.f51361a = byteReadChannel;
            writingKt$copyTo$1.f51362b = longRef;
            writingKt$copyTo$1.f51363c = function1;
            writingKt$copyTo$1.f51364d = j2;
            writingKt$copyTo$1.f51366f = 1;
            if (byteReadChannel.E(0, function1, writingKt$copyTo$1) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        Throwable thA = byteReadChannel.a();
        if (thA == null) {
            return new Long(longRef.f53800a);
        }
        throw thA;
    }
}
