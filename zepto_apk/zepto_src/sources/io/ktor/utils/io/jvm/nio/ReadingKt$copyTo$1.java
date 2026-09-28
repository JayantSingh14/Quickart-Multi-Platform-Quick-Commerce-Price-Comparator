package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", l = {42}, m = "copyTo")
/* loaded from: classes3.dex */
final class ReadingKt$copyTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteWriteChannel f51354a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.LongRef f51355b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.BooleanRef f51356c;

    /* renamed from: d, reason: collision with root package name */
    public Function1 f51357d;

    /* renamed from: e, reason: collision with root package name */
    public int f51358e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f51359f;

    /* renamed from: g, reason: collision with root package name */
    public int f51360g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51359f = obj;
        int i2 = (this.f51360g | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51360g = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            new Ref.LongRef();
            new Ref.BooleanRef();
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = this.f51358e;
        Function1 function1 = this.f51357d;
        Ref.BooleanRef booleanRef = this.f51356c;
        Ref.LongRef longRef = this.f51355b;
        ByteWriteChannel byteWriteChannel = this.f51354a;
        ResultKt.b(obj);
        do {
            if (i3 != 0) {
                byteWriteChannel.flush();
            }
            long j2 = longRef.f53800a;
            if (j2 >= 0 || booleanRef.f53798a) {
                return new Long(j2);
            }
            this.f51354a = byteWriteChannel;
            this.f51355b = longRef;
            this.f51356c = booleanRef;
            this.f51357d = function1;
            this.f51358e = i3;
            this.f51360g = 1;
        } while (byteWriteChannel.C(1, function1, this) != coroutineSingletons);
        return coroutineSingletons;
    }
}
