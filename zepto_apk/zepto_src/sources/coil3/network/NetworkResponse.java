package coil3.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class NetworkResponse {

    @Nullable
    private final NetworkResponseBody body;
    private final int code;

    @Nullable
    private final Object delegate;

    @NotNull
    private final NetworkHeaders headers;
    private final long requestMillis;
    private final long responseMillis;

    public NetworkResponse() {
        this(0, 0L, 0L, null, null, null, 63, null);
    }

    public static /* synthetic */ NetworkResponse copy$default(NetworkResponse networkResponse, int i2, long j2, long j3, NetworkHeaders networkHeaders, NetworkResponseBody networkResponseBody, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = networkResponse.code;
        }
        if ((i3 & 2) != 0) {
            j2 = networkResponse.requestMillis;
        }
        if ((i3 & 4) != 0) {
            j3 = networkResponse.responseMillis;
        }
        if ((i3 & 8) != 0) {
            networkHeaders = networkResponse.headers;
        }
        if ((i3 & 16) != 0) {
            networkResponseBody = networkResponse.body;
        }
        if ((i3 & 32) != 0) {
            obj = networkResponse.delegate;
        }
        Object obj3 = obj;
        NetworkHeaders networkHeaders2 = networkHeaders;
        long j4 = j3;
        return networkResponse.copy(i2, j2, j4, networkHeaders2, networkResponseBody, obj3);
    }

    @NotNull
    public final NetworkResponse copy(int i2, long j2, long j3, @NotNull NetworkHeaders networkHeaders, @Nullable NetworkResponseBody networkResponseBody, @Nullable Object obj) {
        return new NetworkResponse(i2, j2, j3, networkHeaders, networkResponseBody, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return this.code == networkResponse.code && this.requestMillis == networkResponse.requestMillis && this.responseMillis == networkResponse.responseMillis && Intrinsics.b(this.headers, networkResponse.headers) && Intrinsics.b(this.body, networkResponse.body) && Intrinsics.b(this.delegate, networkResponse.delegate);
    }

    @Nullable
    public final NetworkResponseBody getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Object getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final NetworkHeaders getHeaders() {
        return this.headers;
    }

    public final long getRequestMillis() {
        return this.requestMillis;
    }

    public final long getResponseMillis() {
        return this.responseMillis;
    }

    public int hashCode() {
        int iHashCode = (this.headers.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.d(this.code * 31, 31, this.requestMillis), 31, this.responseMillis)) * 31;
        NetworkResponseBody networkResponseBody = this.body;
        int iHashCode2 = (iHashCode + (networkResponseBody == null ? 0 : networkResponseBody.hashCode())) * 31;
        Object obj = this.delegate;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NetworkResponse(code=" + this.code + ", requestMillis=" + this.requestMillis + ", responseMillis=" + this.responseMillis + ", headers=" + this.headers + ", body=" + this.body + ", delegate=" + this.delegate + ')';
    }

    public NetworkResponse(int i2, long j2, long j3, @NotNull NetworkHeaders networkHeaders, @Nullable NetworkResponseBody networkResponseBody, @Nullable Object obj) {
        this.code = i2;
        this.requestMillis = j2;
        this.responseMillis = j3;
        this.headers = networkHeaders;
        this.body = networkResponseBody;
        this.delegate = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NetworkResponse(int i2, long j2, long j3, NetworkHeaders networkHeaders, NetworkResponseBody networkResponseBody, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Object obj2;
        NetworkResponseBody networkResponseBody2;
        NetworkHeaders networkHeaders2;
        i2 = (i3 & 1) != 0 ? 200 : i2;
        j2 = (i3 & 2) != 0 ? 0L : j2;
        j3 = (i3 & 4) != 0 ? 0L : j3;
        networkHeaders = (i3 & 8) != 0 ? NetworkHeaders.EMPTY : networkHeaders;
        networkResponseBody = (i3 & 16) != 0 ? null : networkResponseBody;
        if ((i3 & 32) != 0) {
            obj2 = null;
            networkHeaders2 = networkHeaders;
            networkResponseBody2 = networkResponseBody;
        } else {
            obj2 = obj;
            networkResponseBody2 = networkResponseBody;
            networkHeaders2 = networkHeaders;
        }
        this(i2, j2, j3, networkHeaders2, networkResponseBody2, obj2);
    }
}
