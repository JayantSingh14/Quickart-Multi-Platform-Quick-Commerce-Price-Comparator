package coil3.network.okhttp.internal;

import coil3.Uri;
import coil3.fetch.Fetcher;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import coil3.util.FetcherServiceLoaderTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class OkHttpNetworkFetcherServiceLoaderTarget implements FetcherServiceLoaderTarget<Uri> {
    @Override // coil3.util.FetcherServiceLoaderTarget
    public int priority() {
        return 2;
    }

    @Override // coil3.util.FetcherServiceLoaderTarget
    @NotNull
    public KClass<Uri> type() {
        return Reflection.a(Uri.class);
    }

    @Override // coil3.util.FetcherServiceLoaderTarget
    @NotNull
    public Fetcher.Factory<Uri> factory() {
        return OkHttpNetworkFetcher.factory();
    }
}
