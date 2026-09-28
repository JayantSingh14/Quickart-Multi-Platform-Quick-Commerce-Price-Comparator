package coil3.network;

import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class NetworkRequest {

    @Nullable
    private final NetworkRequestBody body;

    @NotNull
    private final NetworkHeaders headers;

    @NotNull
    private final String method;

    @NotNull
    private final String url;

    public NetworkRequest(@NotNull String str, @NotNull String str2, @NotNull NetworkHeaders networkHeaders, @Nullable NetworkRequestBody networkRequestBody) {
        this.url = str;
        this.method = str2;
        this.headers = networkHeaders;
        this.body = networkRequestBody;
    }

    public static /* synthetic */ NetworkRequest copy$default(NetworkRequest networkRequest, String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = networkRequest.url;
        }
        if ((i2 & 2) != 0) {
            str2 = networkRequest.method;
        }
        if ((i2 & 4) != 0) {
            networkHeaders = networkRequest.headers;
        }
        if ((i2 & 8) != 0) {
            networkRequestBody = networkRequest.body;
        }
        return networkRequest.copy(str, str2, networkHeaders, networkRequestBody);
    }

    @NotNull
    public final NetworkRequest copy(@NotNull String str, @NotNull String str2, @NotNull NetworkHeaders networkHeaders, @Nullable NetworkRequestBody networkRequestBody) {
        return new NetworkRequest(str, str2, networkHeaders, networkRequestBody);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) obj;
        return Intrinsics.b(this.url, networkRequest.url) && Intrinsics.b(this.method, networkRequest.method) && Intrinsics.b(this.headers, networkRequest.headers) && Intrinsics.b(this.body, networkRequest.body);
    }

    @Nullable
    public final NetworkRequestBody getBody() {
        return this.body;
    }

    @NotNull
    public final NetworkHeaders getHeaders() {
        return this.headers;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (this.headers.hashCode() + e.e(this.url.hashCode() * 31, 31, this.method)) * 31;
        NetworkRequestBody networkRequestBody = this.body;
        return iHashCode + (networkRequestBody == null ? 0 : networkRequestBody.hashCode());
    }

    @NotNull
    public String toString() {
        return "NetworkRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ')';
    }

    public /* synthetic */ NetworkRequest(String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? UtilsKt.HTTP_METHOD_GET : str2, (i2 & 4) != 0 ? NetworkHeaders.EMPTY : networkHeaders, (i2 & 8) != 0 ? null : networkRequestBody);
    }
}
