package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {477}, m = "none")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54375a;

    /* renamed from: b, reason: collision with root package name */
    public int f54376b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54375a = obj;
        int i2 = (this.f54376b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54376b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                throw null;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ((Boolean) obj).booleanValue();
            throw null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ChannelsKt.a(null, th);
                throw th2;
            }
        }
    }
}
