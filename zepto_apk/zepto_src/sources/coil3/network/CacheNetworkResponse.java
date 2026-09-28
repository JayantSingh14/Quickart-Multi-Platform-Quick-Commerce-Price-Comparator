package coil3.network;

import coil3.annotation.InternalCoilApi;
import coil3.network.NetworkHeaders;
import coil3.network.internal.UtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSink;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata
@InternalCoilApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CacheNetworkResponse {

    @NotNull
    public static final CacheNetworkResponse INSTANCE = new CacheNetworkResponse();

    private CacheNetworkResponse() {
    }

    @NotNull
    public final NetworkResponse readFrom(@NotNull BufferedSource bufferedSource) throws NumberFormatException {
        int i2 = Integer.parseInt(bufferedSource.p0());
        long j2 = Long.parseLong(bufferedSource.p0());
        long j3 = Long.parseLong(bufferedSource.p0());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int i3 = Integer.parseInt(bufferedSource.p0());
        for (int i4 = 0; i4 < i3; i4++) {
            UtilsKt.append(builder, bufferedSource.p0());
        }
        return new NetworkResponse(i2, j2, j3, builder.build(), null, null, 48, null);
    }

    public final void writeTo(@NotNull NetworkResponse networkResponse, @NotNull BufferedSink bufferedSink) {
        bufferedSink.E0(networkResponse.getCode()).writeByte(10);
        bufferedSink.E0(networkResponse.getRequestMillis()).writeByte(10);
        bufferedSink.E0(networkResponse.getResponseMillis()).writeByte(10);
        Set<Map.Entry<String, List<String>>> setEntrySet = networkResponse.getHeaders().asMap().entrySet();
        Iterator<T> it = setEntrySet.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((List) ((Map.Entry) it.next()).getValue()).size();
        }
        bufferedSink.E0(size).writeByte(10);
        for (Map.Entry<String, List<String>> entry : setEntrySet) {
            Iterator<String> it2 = entry.getValue().iterator();
            while (it2.hasNext()) {
                bufferedSink.Y(entry.getKey()).Y(":").Y(it2.next()).writeByte(10);
            }
        }
    }
}
