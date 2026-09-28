package coil3.network;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class NetworkClientKt {
    @NotNull
    public static final NetworkRequestBody NetworkRequestBody(@NotNull ByteString byteString) {
        return ByteStringNetworkRequestBody.m2boximpl(ByteStringNetworkRequestBody.m3constructorimpl(byteString));
    }

    @NotNull
    public static final NetworkResponseBody NetworkResponseBody(@NotNull BufferedSource bufferedSource) {
        return SourceResponseBody.m10boximpl(SourceResponseBody.m12constructorimpl(bufferedSource));
    }
}
