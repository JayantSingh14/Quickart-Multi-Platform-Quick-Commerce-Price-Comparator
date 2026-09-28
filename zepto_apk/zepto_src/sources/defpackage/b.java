package defpackage;

import android.content.Context;
import coil3.ImageLoader;
import coil3.memory.MemoryCache;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.core.DiskCachesStoreFactory;
import com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1;
import com.facebook.react.bridge.Promise;
import com.horizon.HorizonModule;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13171b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f13170a = i2;
        this.f13171b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f13170a) {
            case 0:
                return (OkHttpClient) this.f13171b;
            case 1:
                return new MemoryCache.Builder().maxSizePercent((Context) this.f13171b, 0.25d).build();
            case 2:
                return CollectionsKt.H((Pair) this.f13171b);
            case 3:
                return ImageLoader.Builder.build$lambda$23((ImageLoader.Builder) this.f13171b);
            case 4:
                return ((ImageLoader) this.f13171b).getDiskCache();
            case 5:
                return OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$2((Function0) this.f13171b);
            case 6:
                DiskCachesStoreFactory this$0 = (DiskCachesStoreFactory) this.f13171b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                return new DiskCachesStoreFactory$diskCachesStore$2$1(this$0);
            case 7:
                return HorizonModule.init$lambda$0((Promise) this.f13171b);
            default:
                return ArrayIteratorKt.a((Object[]) this.f13171b);
        }
    }
}
