package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
final class ByteStringNetworkRequestBody implements NetworkRequestBody {

    @NotNull
    private final ByteString bytes;

    private /* synthetic */ ByteStringNetworkRequestBody(ByteString byteString) {
        this.bytes = byteString;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ByteStringNetworkRequestBody m2boximpl(ByteString byteString) {
        return new ByteStringNetworkRequestBody(byteString);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static ByteString m3constructorimpl(@NotNull ByteString byteString) {
        return byteString;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4equalsimpl(ByteString byteString, Object obj) {
        return (obj instanceof ByteStringNetworkRequestBody) && Intrinsics.b(byteString, ((ByteStringNetworkRequestBody) obj).m9unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5equalsimpl0(ByteString byteString, ByteString byteString2) {
        return Intrinsics.b(byteString, byteString2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6hashCodeimpl(ByteString byteString) {
        return byteString.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7toStringimpl(ByteString byteString) {
        return "ByteStringNetworkRequestBody(bytes=" + byteString + ')';
    }

    @Nullable
    /* renamed from: writeTo-impl, reason: not valid java name */
    public static Object m8writeToimpl(ByteString byteString, @NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation) {
        bufferedSink.D1(byteString);
        return Unit.f53572a;
    }

    public boolean equals(Object obj) {
        return m4equalsimpl(this.bytes, obj);
    }

    public int hashCode() {
        return m6hashCodeimpl(this.bytes);
    }

    public String toString() {
        return m7toStringimpl(this.bytes);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ByteString m9unboximpl() {
        return this.bytes;
    }

    @Override // coil3.network.NetworkRequestBody
    @Nullable
    public Object writeTo(@NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation) {
        return m8writeToimpl(this.bytes, bufferedSink, continuation);
    }
}
