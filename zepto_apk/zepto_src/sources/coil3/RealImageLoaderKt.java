package coil3;

import coil3.ComponentRegistry;
import coil3.RealImageLoader;
import coil3.decode.Decoder;
import coil3.fetch.ByteArrayFetcher;
import coil3.fetch.Fetcher;
import coil3.fetch.FileUriFetcher;
import coil3.key.FileUriKeyer;
import coil3.key.UriKeyer;
import coil3.map.PathMapper;
import coil3.map.StringMapper;
import coil3.util.DecoderServiceLoaderTarget;
import coil3.util.FetcherServiceLoaderTarget;
import coil3.util.Logger;
import coil3.util.ServiceLoaderComponentRegistry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealImageLoaderKt {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;

    @NotNull
    private static final String TAG = "RealImageLoader";

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope CoroutineScope(Logger logger) {
        Job jobB = SupervisorKt.b();
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, MainDispatcherLoader.f55099a.O1()).plus(new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.f54075a, logger)));
    }

    @NotNull
    public static final ComponentRegistry.Builder addCommonComponents(@NotNull ComponentRegistry.Builder builder) {
        return builder.add(new StringMapper(), Reflection.a(String.class)).add(new PathMapper(), Reflection.a(Path.class)).add(new FileUriKeyer(), Reflection.a(Uri.class)).add(new UriKeyer(), Reflection.a(Uri.class)).add(new FileUriFetcher.Factory(), Reflection.a(Uri.class)).add(new ByteArrayFetcher.Factory(), Reflection.a(byte[].class));
    }

    @NotNull
    public static final ComponentRegistry.Builder addServiceLoaderComponents(@NotNull ComponentRegistry.Builder builder, @NotNull RealImageLoader.Options options) {
        if (ImageLoadersKt.getServiceLoaderEnabled(options)) {
            builder.addFetcherFactories(new d(1));
            builder.addDecoderFactories(new d(2));
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List addServiceLoaderComponents$lambda$3() {
        KClass kClassType;
        List listY = CollectionsKt.Y(new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$3$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Integer.valueOf(((FetcherServiceLoaderTarget) t2).priority()), Integer.valueOf(((FetcherServiceLoaderTarget) t).priority()));
            }
        }, ServiceLoaderComponentRegistry.INSTANCE.getFetchers());
        ArrayList arrayList = new ArrayList();
        int size = listY.size();
        for (int i2 = 0; i2 < size; i2++) {
            FetcherServiceLoaderTarget fetcherServiceLoaderTarget = (FetcherServiceLoaderTarget) listY.get(i2);
            Intrinsics.d(fetcherServiceLoaderTarget, "null cannot be cast to non-null type coil3.util.FetcherServiceLoaderTarget<kotlin.Any>");
            Fetcher.Factory factory = fetcherServiceLoaderTarget.factory();
            Pair pair = null;
            if (factory != null && (kClassType = fetcherServiceLoaderTarget.type()) != null) {
                pair = new Pair(factory, kClassType);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List addServiceLoaderComponents$lambda$6() {
        List listY = CollectionsKt.Y(new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$6$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Integer.valueOf(((DecoderServiceLoaderTarget) t2).priority()), Integer.valueOf(((DecoderServiceLoaderTarget) t).priority()));
            }
        }, ServiceLoaderComponentRegistry.INSTANCE.getDecoders());
        ArrayList arrayList = new ArrayList();
        int size = listY.size();
        for (int i2 = 0; i2 < size; i2++) {
            Decoder.Factory factory = ((DecoderServiceLoaderTarget) listY.get(i2)).factory();
            if (factory != null) {
                arrayList.add(factory);
            }
        }
        return arrayList;
    }
}
