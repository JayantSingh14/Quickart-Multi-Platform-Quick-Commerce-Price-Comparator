package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

@UnstableApi
/* loaded from: classes3.dex */
public final class DataSourceBitmapLoader implements BitmapLoader {

    /* renamed from: c, reason: collision with root package name */
    public static final Supplier f5841c = Suppliers.a(new a(0));

    /* renamed from: a, reason: collision with root package name */
    public final ListeningExecutorService f5842a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultDataSource.Factory f5843b;

    public DataSourceBitmapLoader(Context context) {
        ListeningExecutorService listeningExecutorService = (ListeningExecutorService) f5841c.get();
        Assertions.h(listeningExecutorService);
        DefaultDataSource.Factory factory = new DefaultDataSource.Factory(context);
        this.f5842a = listeningExecutorService;
        this.f5843b = factory;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture b(Uri uri) {
        return this.f5842a.submit((Callable) new b(1, this, uri));
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture c(byte[] bArr) {
        return this.f5842a.submit((Callable) new b(0, this, bArr));
    }
}
