package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {WKSRecord.Service.BOOTPC}, m = "elementAt")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f54293a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54294b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54295c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54296d;

    /* renamed from: e, reason: collision with root package name */
    public int f54297e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54296d = obj;
        int i2 = (this.f54297e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54297e = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.f54293a;
            ChannelIterator channelIterator = this.f54295c;
            ReceiveChannel receiveChannel2 = this.f54294b;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    int i4 = i3 + 1;
                    if (i3 == 0) {
                        receiveChannel2.e(null);
                        return next;
                    }
                    this.f54294b = receiveChannel2;
                    this.f54295c = channelIterator;
                    this.f54293a = i4;
                    this.f54297e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    i3 = i4;
                }
                throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index 0" + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannel2;
            }
        }
        try {
            throw th;
        } catch (Throwable th3) {
            ChannelsKt.a(receiveChannel, th);
            throw th3;
        }
    }
}
