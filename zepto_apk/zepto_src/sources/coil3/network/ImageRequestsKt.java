package coil3.network;

import coil3.Extras;
import coil3.ExtrasKt;
import coil3.network.internal.UtilsKt;
import coil3.request.ImageRequest;
import coil3.request.Options;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ImageRequestsKt {

    @NotNull
    private static final Extras.Key<String> httpMethodKey = new Extras.Key<>(UtilsKt.HTTP_METHOD_GET);

    @NotNull
    private static final Extras.Key<NetworkHeaders> httpHeadersKey = new Extras.Key<>(NetworkHeaders.EMPTY);

    @NotNull
    private static final Extras.Key<NetworkRequestBody> httpBodyKey = new Extras.Key<>(null);

    @Nullable
    public static final NetworkRequestBody getHttpBody(@NotNull ImageRequest imageRequest) {
        return (NetworkRequestBody) ExtrasKt.getExtra(imageRequest, httpBodyKey);
    }

    @NotNull
    public static final NetworkHeaders getHttpHeaders(@NotNull ImageRequest imageRequest) {
        return (NetworkHeaders) ExtrasKt.getExtra(imageRequest, httpHeadersKey);
    }

    @NotNull
    public static final String getHttpMethod(@NotNull ImageRequest imageRequest) {
        return (String) ExtrasKt.getExtra(imageRequest, httpMethodKey);
    }

    @NotNull
    public static final ImageRequest.Builder httpBody(@NotNull ImageRequest.Builder builder, @NotNull NetworkRequestBody networkRequestBody) {
        builder.getExtras().set(httpBodyKey, networkRequestBody);
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder httpHeaders(@NotNull ImageRequest.Builder builder, @NotNull NetworkHeaders networkHeaders) {
        builder.getExtras().set(httpHeadersKey, networkHeaders);
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder httpMethod(@NotNull ImageRequest.Builder builder, @NotNull String str) {
        Extras.Builder extras = builder.getExtras();
        Extras.Key<String> key = httpMethodKey;
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        extras.set(key, upperCase);
        return builder;
    }

    @Nullable
    public static final NetworkRequestBody getHttpBody(@NotNull Options options) {
        return (NetworkRequestBody) ExtrasKt.getExtra(options, httpBodyKey);
    }

    @NotNull
    public static final NetworkHeaders getHttpHeaders(@NotNull Options options) {
        return (NetworkHeaders) ExtrasKt.getExtra(options, httpHeadersKey);
    }

    @NotNull
    public static final String getHttpMethod(@NotNull Options options) {
        return (String) ExtrasKt.getExtra(options, httpMethodKey);
    }

    @NotNull
    public static final Extras.Key<NetworkRequestBody> getHttpBody(@NotNull Extras.Key.Companion companion) {
        return httpBodyKey;
    }

    @NotNull
    public static final Extras.Key<NetworkHeaders> getHttpHeaders(@NotNull Extras.Key.Companion companion) {
        return httpHeadersKey;
    }

    @NotNull
    public static final Extras.Key<String> getHttpMethod(@NotNull Extras.Key.Companion companion) {
        return httpMethodKey;
    }
}
