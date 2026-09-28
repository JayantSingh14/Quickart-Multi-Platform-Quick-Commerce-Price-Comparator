package androidx.media3.session;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public final class SimpleBitmapLoader implements androidx.media3.common.util.BitmapLoader {

    /* renamed from: b, reason: collision with root package name */
    public static final Supplier f10289b = Suppliers.a(new h2());

    /* renamed from: a, reason: collision with root package name */
    public final ListeningExecutorService f10290a;

    public SimpleBitmapLoader() {
        ListeningExecutorService listeningExecutorService = (ListeningExecutorService) f10289b.get();
        Assertions.h(listeningExecutorService);
        this.f10290a = MoreExecutors.b(listeningExecutorService);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture b(Uri uri) {
        return this.f10290a.submit((Callable) new i2(uri, 1));
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture c(byte[] bArr) {
        return this.f10290a.submit((Callable) new i2(bArr, 0));
    }
}
