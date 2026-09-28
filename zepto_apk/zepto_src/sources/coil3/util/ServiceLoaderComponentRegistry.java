package coil3.util;

import coil3.annotation.InternalCoilApi;
import coil3.d;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@InternalCoilApi
/* loaded from: classes.dex */
public final class ServiceLoaderComponentRegistry {

    @NotNull
    public static final ServiceLoaderComponentRegistry INSTANCE = new ServiceLoaderComponentRegistry();

    @NotNull
    private static final Lazy fetchers$delegate = LazyKt.b(new d(5));

    @NotNull
    private static final Lazy decoders$delegate = LazyKt.b(new d(6));

    private ServiceLoaderComponentRegistry() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List decoders_delegate$lambda$1() {
        return Collections_jvmCommonKt.toImmutableList(SequencesKt.q(SequencesKt.c(ServiceLoader.load(DecoderServiceLoaderTarget.class, DecoderServiceLoaderTarget.class.getClassLoader()).iterator())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetchers_delegate$lambda$0() {
        return Collections_jvmCommonKt.toImmutableList(SequencesKt.q(SequencesKt.c(ServiceLoader.load(FetcherServiceLoaderTarget.class, FetcherServiceLoaderTarget.class.getClassLoader()).iterator())));
    }

    @NotNull
    public final List<DecoderServiceLoaderTarget> getDecoders() {
        return (List) decoders$delegate.getValue();
    }

    @NotNull
    public final List<FetcherServiceLoaderTarget<?>> getFetchers() {
        return (List) fetchers$delegate.getValue();
    }

    public final void register(@NotNull FetcherServiceLoaderTarget<?> fetcherServiceLoaderTarget) {
        throw new UnsupportedOperationException();
    }

    public final void register(@NotNull DecoderServiceLoaderTarget decoderServiceLoaderTarget) {
        throw new UnsupportedOperationException();
    }
}
