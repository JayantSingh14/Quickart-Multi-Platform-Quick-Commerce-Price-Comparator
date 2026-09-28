package coil3.network.okhttp;

import coil3.PlatformContext;
import coil3.d;
import coil3.decode.a;
import coil3.decode.b;
import coil3.network.CacheStrategy;
import coil3.network.ConnectivityChecker;
import coil3.network.NetworkClient;
import coil3.network.NetworkFetcher;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class OkHttpNetworkFetcher {
    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$0() {
        return asNetworkClient(new OkHttpClient());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$2(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$4(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    @NotNull
    public static final NetworkClient asNetworkClient(@NotNull Call.Factory factory) {
        return CallFactoryNetworkClient.m20boximpl(CallFactoryNetworkClient.m21constructorimpl(factory));
    }

    @JvmName
    @NotNull
    public static final NetworkFetcher.Factory factory() {
        return new NetworkFetcher.Factory(new d(4), null, null, 6, null);
    }

    public static /* synthetic */ NetworkFetcher.Factory factory$default(Function0 function0, Function0 function02, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            function02 = new b(2);
        }
        if ((i2 & 4) != 0) {
            function1 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6.INSTANCE;
        }
        return factory(function0, function02, function1);
    }

    @JvmName
    @NotNull
    public static final NetworkFetcher.Factory factory(@NotNull Call.Factory factory) {
        return new NetworkFetcher.Factory(new a(factory, 2), null, null, 6, null);
    }

    @JvmName
    @NotNull
    public static final NetworkFetcher.Factory factory(@NotNull Function0<? extends Call.Factory> function0) {
        return new NetworkFetcher.Factory(new defpackage.b(function0, 5), null, null, 6, null);
    }

    @JvmName
    @NotNull
    public static final NetworkFetcher.Factory factory(@NotNull Function0<? extends Call.Factory> function0, @NotNull Function0<? extends CacheStrategy> function02, @NotNull Function1<? super PlatformContext, ? extends ConnectivityChecker> function1) {
        return new NetworkFetcher.Factory(new a(function0, 1), function02, function1);
    }
}
