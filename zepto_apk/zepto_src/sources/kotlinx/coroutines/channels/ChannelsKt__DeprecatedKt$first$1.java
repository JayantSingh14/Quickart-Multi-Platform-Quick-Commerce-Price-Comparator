package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {WKSRecord.Service.SUPDUP}, m = "first")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$first$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54324a;

    /* renamed from: b, reason: collision with root package name */
    public int f54325b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54324a = obj;
        int i2 = (this.f54325b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54325b = i2;
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
            if (((Boolean) obj).booleanValue()) {
                throw null;
            }
            throw new NoSuchElementException("ReceiveChannel is empty.");
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
