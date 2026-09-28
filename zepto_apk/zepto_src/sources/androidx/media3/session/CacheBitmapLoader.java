package androidx.media3.session;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceBitmapLoader;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class CacheBitmapLoader implements androidx.media3.common.util.BitmapLoader {

    /* renamed from: a, reason: collision with root package name */
    public final DataSourceBitmapLoader f9859a;

    /* renamed from: b, reason: collision with root package name */
    public BitmapLoadRequest f9860b;

    public CacheBitmapLoader(DataSourceBitmapLoader dataSourceBitmapLoader) {
        this.f9859a = dataSourceBitmapLoader;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture b(Uri uri) {
        Uri uri2;
        BitmapLoadRequest bitmapLoadRequest = this.f9860b;
        if (bitmapLoadRequest == null || (uri2 = bitmapLoadRequest.f9862b) == null || !uri2.equals(uri)) {
            ListenableFuture listenableFutureB = this.f9859a.b(uri);
            this.f9860b = new BitmapLoadRequest(uri, listenableFutureB);
            return listenableFutureB;
        }
        ListenableFuture listenableFuture = this.f9860b.f9863c;
        Assertions.h(listenableFuture);
        return listenableFuture;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture c(byte[] bArr) {
        byte[] bArr2;
        BitmapLoadRequest bitmapLoadRequest = this.f9860b;
        if (bitmapLoadRequest == null || (bArr2 = bitmapLoadRequest.f9861a) == null || !Arrays.equals(bArr2, bArr)) {
            ListenableFuture listenableFutureC = this.f9859a.c(bArr);
            this.f9860b = new BitmapLoadRequest(bArr, listenableFutureC);
            return listenableFutureC;
        }
        ListenableFuture listenableFuture = this.f9860b.f9863c;
        Assertions.h(listenableFuture);
        return listenableFuture;
    }

    public static class BitmapLoadRequest {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f9861a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f9862b;

        /* renamed from: c, reason: collision with root package name */
        public final ListenableFuture f9863c;

        public BitmapLoadRequest(byte[] bArr, ListenableFuture listenableFuture) {
            this.f9861a = bArr;
            this.f9862b = null;
            this.f9863c = listenableFuture;
        }

        public BitmapLoadRequest(Uri uri, ListenableFuture listenableFuture) {
            this.f9861a = null;
            this.f9862b = uri;
            this.f9863c = listenableFuture;
        }
    }
}
