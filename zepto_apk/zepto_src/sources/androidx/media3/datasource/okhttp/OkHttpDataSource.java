package androidx.media3.datasource.okhttp;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BaseDataSource;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.HttpUtil;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes3.dex */
public class OkHttpDataSource extends BaseDataSource implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final OkHttpClient f6042e;

    /* renamed from: f, reason: collision with root package name */
    public final HttpDataSource.RequestProperties f6043f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6044g;

    /* renamed from: h, reason: collision with root package name */
    public final HttpDataSource.RequestProperties f6045h;

    /* renamed from: i, reason: collision with root package name */
    public Response f6046i;

    /* renamed from: j, reason: collision with root package name */
    public InputStream f6047j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6048k;

    /* renamed from: l, reason: collision with root package name */
    public long f6049l;

    /* renamed from: m, reason: collision with root package name */
    public long f6050m;

    static {
        MediaLibraryInfo.a("media3.datasource.okhttp");
    }

    public OkHttpDataSource(OkHttpClient okHttpClient, String str, HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.f6042e = okHttpClient;
        this.f6044g = str;
        this.f6045h = requestProperties;
        this.f6043f = new HttpDataSource.RequestProperties();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        Response response = this.f6046i;
        return response == null ? Collections.EMPTY_MAP : response.f56355f.k();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.f6048k) {
            this.f6048k = false;
            m();
            p();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        HttpUrl url;
        long j2 = 0;
        this.f6050m = 0L;
        this.f6049l = 0L;
        n(dataSpec);
        long j3 = dataSpec.f5856f;
        String string = dataSpec.f5851a.toString();
        Intrinsics.checkNotNullParameter(string, "<this>");
        try {
            url = HttpUrl.Companion.c(string);
        } catch (IllegalArgumentException unused) {
            url = null;
        }
        if (url == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", 1004);
        }
        Request.Builder builder = new Request.Builder();
        Intrinsics.checkNotNullParameter(url, "url");
        builder.f56337a = url;
        HashMap map = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f6045h;
        if (requestProperties != null) {
            map.putAll(requestProperties.a());
        }
        map.putAll(this.f6043f.a());
        map.putAll(dataSpec.f5855e);
        for (Map.Entry entry : map.entrySet()) {
            builder.d((String) entry.getKey(), (String) entry.getValue());
        }
        long j4 = dataSpec.f5857g;
        String strA = HttpUtil.a(j3, j4);
        if (strA != null) {
            builder.a("Range", strA);
        }
        String str = this.f6044g;
        if (str != null) {
            builder.a("User-Agent", str);
        }
        if (!dataSpec.c(1)) {
            builder.a("Accept-Encoding", "identity");
        }
        int i2 = dataSpec.f5853c;
        byte[] bArr = dataSpec.f5854d;
        builder.f(DataSpec.b(i2), bArr != null ? RequestBody.create(bArr) : i2 == 2 ? RequestBody.create(Util.f5749f) : null);
        RealCall realCallA = this.f6042e.a(builder.b());
        try {
            final SettableFuture settableFuture = new SettableFuture();
            realCallA.l0(new Callback() { // from class: androidx.media3.datasource.okhttp.OkHttpDataSource.1
                @Override // okhttp3.Callback
                public final void onFailure(Call call, IOException iOException) {
                    settableFuture.o(iOException);
                }

                @Override // okhttp3.Callback
                public final void onResponse(Call call, Response response) {
                    settableFuture.n(response);
                }
            });
            try {
                try {
                    Response response = (Response) settableFuture.get();
                    this.f6046i = response;
                    ResponseBody responseBody = response.f56356g;
                    responseBody.getClass();
                    this.f6047j = responseBody.a();
                    boolean zC = response.c();
                    long j5 = dataSpec.f5856f;
                    int i3 = response.f56353d;
                    if (zC) {
                        responseBody.l();
                        if (i3 == 200 && j5 != 0) {
                            j2 = j5;
                        }
                        if (j4 != -1) {
                            this.f6049l = j4;
                        } else {
                            long jE = responseBody.e();
                            this.f6049l = jE != -1 ? jE - j2 : -1L;
                        }
                        this.f6048k = true;
                        o(dataSpec);
                        try {
                            q(j2);
                            return this.f6049l;
                        } catch (HttpDataSource.HttpDataSourceException e2) {
                            p();
                            throw e2;
                        }
                    }
                    Headers headers = response.f56355f;
                    if (i3 == 416 && j5 == HttpUtil.c(headers.d("Content-Range"))) {
                        this.f6048k = true;
                        o(dataSpec);
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0L;
                    }
                    try {
                        InputStream inputStream = this.f6047j;
                        inputStream.getClass();
                        ByteStreams.c(inputStream);
                    } catch (IOException unused2) {
                        int i4 = Util.f5744a;
                    }
                    TreeMap treeMapK = headers.k();
                    p();
                    throw new HttpDataSource.InvalidResponseCodeException(i3, i3 == 416 ? new DataSourceException(2008) : null, treeMapK);
                } catch (ExecutionException e3) {
                    throw new IOException(e3);
                }
            } catch (InterruptedException unused3) {
                realCallA.cancel();
                throw new InterruptedIOException();
            }
        } catch (IOException e4) {
            throw HttpDataSource.HttpDataSourceException.a(e4, 1);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        Response response = this.f6046i;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.f56350a.f56331a.f56267i);
    }

    public final void p() {
        Response response = this.f6046i;
        if (response != null) {
            ResponseBody responseBody = response.f56356g;
            responseBody.getClass();
            responseBody.close();
            this.f6046i = null;
        }
        this.f6047j = null;
    }

    public final void q(long j2) throws IOException {
        if (j2 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j2 > 0) {
            try {
                int iMin = (int) Math.min(j2, 4096);
                InputStream inputStream = this.f6047j;
                int i2 = Util.f5744a;
                int i3 = inputStream.read(bArr, 0, iMin);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i3 == -1) {
                    throw new HttpDataSource.HttpDataSourceException(2008);
                }
                j2 -= i3;
                l(i3);
            } catch (IOException e2) {
                if (!(e2 instanceof HttpDataSource.HttpDataSourceException)) {
                    throw new HttpDataSource.HttpDataSourceException(2000);
                }
                throw ((HttpDataSource.HttpDataSourceException) e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // androidx.media3.common.DataReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.f6049l     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.f6050m     // Catch: java.io.IOException -> L32
            long r0 = r0 - r4
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L17
            goto L27
        L17:
            long r4 = (long) r9     // Catch: java.io.IOException -> L32
            long r0 = java.lang.Math.min(r4, r0)     // Catch: java.io.IOException -> L32
            int r9 = (int) r0     // Catch: java.io.IOException -> L32
        L1d:
            java.io.InputStream r0 = r6.f6047j     // Catch: java.io.IOException -> L32
            int r1 = androidx.media3.common.util.Util.f5744a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.f6050m     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.f6050m = r8     // Catch: java.io.IOException -> L32
            r6.l(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = androidx.media3.common.util.Util.f5744a
            r8 = 2
            androidx.media3.datasource.HttpDataSource$HttpDataSourceException r7 = androidx.media3.datasource.HttpDataSource.HttpDataSourceException.a(r7, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.okhttp.OkHttpDataSource.read(byte[], int, int):int");
    }

    public static final class Factory implements HttpDataSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final HttpDataSource.RequestProperties f6052a = new HttpDataSource.RequestProperties();

        /* renamed from: b, reason: collision with root package name */
        public final OkHttpClient f6053b;

        /* renamed from: c, reason: collision with root package name */
        public String f6054c;

        /* renamed from: d, reason: collision with root package name */
        public DefaultBandwidthMeter f6055d;

        public Factory(OkHttpClient okHttpClient) {
            this.f6053b = okHttpClient;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.f6053b, this.f6054c, this.f6052a);
            DefaultBandwidthMeter defaultBandwidthMeter = this.f6055d;
            if (defaultBandwidthMeter != null) {
                okHttpDataSource.a(defaultBandwidthMeter);
            }
            return okHttpDataSource;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource a() {
            OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.f6053b, this.f6054c, this.f6052a);
            DefaultBandwidthMeter defaultBandwidthMeter = this.f6055d;
            if (defaultBandwidthMeter != null) {
                okHttpDataSource.a(defaultBandwidthMeter);
            }
            return okHttpDataSource;
        }
    }
}
