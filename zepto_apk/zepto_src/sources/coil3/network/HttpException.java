package coil3.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class HttpException extends RuntimeException {

    @NotNull
    private final NetworkResponse response;

    public HttpException(@NotNull NetworkResponse networkResponse) {
        super("HTTP " + networkResponse.getCode());
        this.response = networkResponse;
    }

    @NotNull
    public final NetworkResponse getResponse() {
        return this.response;
    }
}
