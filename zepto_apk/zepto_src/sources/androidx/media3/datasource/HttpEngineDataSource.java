package androidx.media3.datasource;

import android.net.Uri;
import android.net.http.HttpException;
import android.net.http.UrlRequest;
import android.net.http.UrlRequest$Callback;
import android.net.http.UrlRequest$StatusListener;
import android.net.http.UrlResponseInfo;
import androidx.annotation.RequiresApi;
import androidx.core.view.j;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class HttpEngineDataSource extends BaseDataSource implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    public boolean f5904e;

    /* renamed from: f, reason: collision with root package name */
    public long f5905f;

    /* renamed from: g, reason: collision with root package name */
    public DataSpec f5906g;

    /* renamed from: h, reason: collision with root package name */
    public UrlRequestWrapper f5907h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f5908i;

    /* renamed from: j, reason: collision with root package name */
    public UrlResponseInfo f5909j;

    /* renamed from: k, reason: collision with root package name */
    public IOException f5910k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5911l;

    /* renamed from: m, reason: collision with root package name */
    public volatile long f5912m;

    public static final class Factory implements HttpDataSource.Factory {
        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final /* bridge */ /* synthetic */ DataSource a() {
            a();
            throw null;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource a() {
            new HttpEngineDataSource(true);
            throw null;
        }
    }

    @UnstableApi
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {
    }

    public final class UrlRequestCallback implements UrlRequest$Callback {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f5913a = false;

        public UrlRequestCallback() {
        }

        public final synchronized void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public final synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, HttpException httpException) {
            try {
                if (!this.f5913a) {
                    if (j.x(httpException) && j.e(httpException).getErrorCode() == 1) {
                        HttpEngineDataSource.this.f5910k = new UnknownHostException();
                    } else {
                        HttpEngineDataSource.this.f5910k = httpException;
                    }
                    HttpEngineDataSource.this.getClass();
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (!this.f5913a) {
                HttpEngineDataSource.this.getClass();
                throw null;
            }
        }

        public final synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            try {
                if (this.f5913a) {
                    return;
                }
                DataSpec dataSpec = HttpEngineDataSource.this.f5906g;
                dataSpec.getClass();
                int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                if (dataSpec.f5853c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
                    HttpEngineDataSource httpEngineDataSource = HttpEngineDataSource.this;
                    urlResponseInfo.getHttpStatusText();
                    Map asMap = urlResponseInfo.getHeaders().getAsMap();
                    int i2 = Util.f5744a;
                    httpEngineDataSource.f5910k = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, null, asMap);
                    HttpEngineDataSource.this.getClass();
                    throw null;
                }
                HttpEngineDataSource.this.getClass();
                HttpEngineDataSource.this.getClass();
                urlRequest.followRedirect();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (!this.f5913a) {
                HttpEngineDataSource.this.f5909j = urlResponseInfo;
                throw null;
            }
        }

        public final synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (!this.f5913a) {
                HttpEngineDataSource.this.f5911l = true;
                throw null;
            }
        }
    }

    public static final class UrlRequestWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final UrlRequest f5915a;

        /* renamed from: b, reason: collision with root package name */
        public final UrlRequestCallback f5916b;

        /* renamed from: androidx.media3.datasource.HttpEngineDataSource$UrlRequestWrapper$1, reason: invalid class name */
        class AnonymousClass1 implements UrlRequest$StatusListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int[] f5917a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConditionVariable f5918b;

            public AnonymousClass1(int[] iArr, ConditionVariable conditionVariable) {
                this.f5917a = iArr;
                this.f5918b = conditionVariable;
            }

            public final void onStatus(int i2) {
                this.f5917a[0] = i2;
                this.f5918b.e();
            }
        }

        public UrlRequestWrapper(UrlRequest urlRequest, UrlRequestCallback urlRequestCallback) {
            this.f5915a = urlRequest;
            this.f5916b = urlRequestCallback;
        }
    }

    public static String q(String str, Map map) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        UrlResponseInfo urlResponseInfo = this.f5909j;
        return urlResponseInfo == null ? Collections.EMPTY_MAP : urlResponseInfo.getHeaders().getAsMap();
    }

    @Override // androidx.media3.datasource.DataSource
    public final synchronized void close() {
        try {
            UrlRequestWrapper urlRequestWrapper = this.f5907h;
            if (urlRequestWrapper != null) {
                urlRequestWrapper.f5916b.f5913a = true;
                urlRequestWrapper.f5915a.cancel();
                this.f5907h = null;
            }
            ByteBuffer byteBuffer = this.f5908i;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.f5906g = null;
            this.f5909j = null;
            this.f5910k = null;
            this.f5911l = false;
            if (this.f5904e) {
                this.f5904e = false;
                m();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        dataSpec.getClass();
        Assertions.g(!this.f5904e);
        throw null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        UrlResponseInfo urlResponseInfo = this.f5909j;
        if (urlResponseInfo == null) {
            return null;
        }
        return Uri.parse(urlResponseInfo.getUrl());
    }

    public final UrlRequestWrapper p(DataSpec dataSpec) {
        null.newUrlRequestBuilder(dataSpec.f5851a.toString(), null, new UrlRequestCallback()).setPriority(0).setDirectExecutorAllowed(true);
        new HashMap();
        throw null;
    }

    public final ByteBuffer r() {
        if (this.f5908i == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32768);
            this.f5908i = byteBufferAllocateDirect;
            byteBufferAllocateDirect.limit(0);
        }
        return this.f5908i;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        Assertions.g(this.f5904e);
        if (i3 == 0) {
            return 0;
        }
        if (this.f5905f == 0) {
            return -1;
        }
        ByteBuffer byteBufferR = r();
        if (!byteBufferR.hasRemaining()) {
            throw null;
        }
        long j2 = this.f5905f;
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        long[] jArr = {j2, byteBufferR.remaining(), i3};
        long j3 = jArr[0];
        for (int i4 = 1; i4 < 3; i4++) {
            long j4 = jArr[i4];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        int i5 = (int) j3;
        byteBufferR.get(bArr, i2, i5);
        long j5 = this.f5905f;
        if (j5 != -1) {
            this.f5905f = j5 - i5;
        }
        l(i5);
        return i5;
    }

    public final void s(ByteBuffer byteBuffer) {
        UrlRequestWrapper urlRequestWrapper = this.f5907h;
        int i2 = Util.f5744a;
        urlRequestWrapper.f5915a.read(byteBuffer);
        throw null;
    }

    public final byte[] t() {
        byte[] bArr = Util.f5749f;
        r();
        if (this.f5911l) {
            return bArr;
        }
        throw null;
    }
}
