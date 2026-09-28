package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final int f5882e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5883f;

    /* renamed from: g, reason: collision with root package name */
    public final HttpDataSource.RequestProperties f5884g;

    /* renamed from: h, reason: collision with root package name */
    public final HttpDataSource.RequestProperties f5885h;

    /* renamed from: i, reason: collision with root package name */
    public HttpURLConnection f5886i;

    /* renamed from: j, reason: collision with root package name */
    public InputStream f5887j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5888k;

    /* renamed from: l, reason: collision with root package name */
    public int f5889l;

    /* renamed from: m, reason: collision with root package name */
    public long f5890m;
    public long n;

    public static final class Factory implements HttpDataSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final HttpDataSource.RequestProperties f5891a = new HttpDataSource.RequestProperties();

        /* renamed from: b, reason: collision with root package name */
        public final int f5892b = 8000;

        /* renamed from: c, reason: collision with root package name */
        public final int f5893c = 8000;

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            return new DefaultHttpDataSource(this.f5892b, this.f5893c, this.f5891a);
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource a() {
            return new DefaultHttpDataSource(this.f5892b, this.f5893c, this.f5891a);
        }
    }

    public static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f5894a;

        public NullFilteringHeadersMap(Map map) {
            this.f5894a = map;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final boolean containsValue(Object obj) {
            return y(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Set entrySet() {
            return Sets.d(super.entrySet(), new c(0));
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final boolean equals(Object obj) {
            return obj != null && Maps.d(obj, this);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Object get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final int hashCode() {
            return Sets.e(entrySet());
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final boolean isEmpty() {
            return super.isEmpty() || (super.size() == 1 && super.containsKey(null));
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Set keySet() {
            return Sets.d(super.keySet(), new c(1));
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Object t() {
            return this.f5894a;
        }

        @Override // com.google.common.collect.ForwardingMap
        /* renamed from: u */
        public final Map t() {
            return this.f5894a;
        }
    }

    public DefaultHttpDataSource(int i2, int i3, HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.f5882e = i2;
        this.f5883f = i3;
        this.f5884g = requestProperties;
        this.f5885h = new HttpDataSource.RequestProperties();
    }

    public static void r(HttpURLConnection httpURLConnection, long j2) throws IllegalAccessException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (httpURLConnection == null || Util.f5744a > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j2 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j2 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Class<? super Object> superclass = inputStream.getClass().getSuperclass();
                superclass.getClass();
                Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        HttpURLConnection httpURLConnection = this.f5886i;
        return httpURLConnection == null ? ImmutableMap.j() : new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        try {
            InputStream inputStream = this.f5887j;
            if (inputStream != null) {
                long j2 = this.f5890m;
                long j3 = -1;
                if (j2 != -1) {
                    j3 = j2 - this.n;
                }
                r(this.f5886i, j3);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    int i2 = Util.f5744a;
                    throw new HttpDataSource.HttpDataSourceException(2000, 3, e2);
                }
            }
        } finally {
            this.f5887j = null;
            p();
            if (this.f5888k) {
                this.f5888k = false;
                m();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException, NumberFormatException {
        long j2 = 0;
        this.n = 0L;
        this.f5890m = 0L;
        n(dataSpec);
        try {
            HttpURLConnection httpURLConnectionQ = q(new URL(dataSpec.f5851a.toString()), dataSpec.f5853c, dataSpec.f5854d, dataSpec.f5856f, dataSpec.f5857g, dataSpec.c(1), true, dataSpec.f5855e);
            this.f5886i = httpURLConnectionQ;
            this.f5889l = httpURLConnectionQ.getResponseCode();
            httpURLConnectionQ.getResponseMessage();
            int i2 = this.f5889l;
            long j3 = dataSpec.f5856f;
            long j4 = dataSpec.f5857g;
            if (i2 < 200 || i2 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionQ.getHeaderFields();
                if (this.f5889l == 416 && j3 == HttpUtil.c(httpURLConnectionQ.getHeaderField("Content-Range"))) {
                    this.f5888k = true;
                    o(dataSpec);
                    if (j4 != -1) {
                        return j4;
                    }
                    return 0L;
                }
                InputStream errorStream = httpURLConnectionQ.getErrorStream();
                try {
                    if (errorStream != null) {
                        ByteStreams.c(errorStream);
                    } else {
                        int i3 = Util.f5744a;
                    }
                } catch (IOException unused) {
                    int i4 = Util.f5744a;
                }
                p();
                throw new HttpDataSource.InvalidResponseCodeException(this.f5889l, this.f5889l == 416 ? new DataSourceException(2008) : null, headerFields);
            }
            httpURLConnectionQ.getContentType();
            if (this.f5889l == 200 && j3 != 0) {
                j2 = j3;
            }
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionQ.getHeaderField("Content-Encoding"));
            if (zEqualsIgnoreCase || j4 != -1) {
                this.f5890m = j4;
            } else {
                long jB = HttpUtil.b(httpURLConnectionQ.getHeaderField("Content-Length"), httpURLConnectionQ.getHeaderField("Content-Range"));
                this.f5890m = jB != -1 ? jB - j2 : -1L;
            }
            try {
                this.f5887j = httpURLConnectionQ.getInputStream();
                if (zEqualsIgnoreCase) {
                    this.f5887j = new GZIPInputStream(this.f5887j);
                }
                this.f5888k = true;
                o(dataSpec);
                try {
                    s(j2);
                    return this.f5890m;
                } catch (IOException e2) {
                    p();
                    if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e2);
                    }
                    throw new HttpDataSource.HttpDataSourceException(2000, 1, e2);
                }
            } catch (IOException e3) {
                p();
                throw new HttpDataSource.HttpDataSourceException(2000, 1, e3);
            }
        } catch (IOException e4) {
            p();
            throw HttpDataSource.HttpDataSourceException.a(e4, 1);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        HttpURLConnection httpURLConnection = this.f5886i;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void p() {
        HttpURLConnection httpURLConnection = this.f5886i;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f5886i = null;
        }
    }

    public final HttpURLConnection q(URL url, int i2, byte[] bArr, long j2, long j3, boolean z, boolean z2, Map map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f5882e);
        httpURLConnection.setReadTimeout(this.f5883f);
        HashMap map2 = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f5884g;
        if (requestProperties != null) {
            map2.putAll(requestProperties.a());
        }
        map2.putAll(this.f5885h.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = HttpUtil.a(j2, j3);
        if (strA != null) {
            httpURLConnection.setRequestProperty("Range", strA);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(DataSpec.b(i2));
        if (bArr == null) {
            httpURLConnection.connect();
            return httpURLConnection;
        }
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnection;
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
            long r0 = r6.f5890m     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.n     // Catch: java.io.IOException -> L32
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
            java.io.InputStream r0 = r6.f5887j     // Catch: java.io.IOException -> L32
            int r1 = androidx.media3.common.util.Util.f5744a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.n     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.n = r8     // Catch: java.io.IOException -> L32
            r6.l(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = androidx.media3.common.util.Util.f5744a
            r8 = 2
            androidx.media3.datasource.HttpDataSource$HttpDataSourceException r7 = androidx.media3.datasource.HttpDataSource.HttpDataSourceException.a(r7, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.DefaultHttpDataSource.read(byte[], int, int):int");
    }

    public final void s(long j2) throws IOException {
        if (j2 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, 4096);
            InputStream inputStream = this.f5887j;
            int i2 = Util.f5744a;
            int i3 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(2000, 1, new InterruptedIOException());
            }
            if (i3 == -1) {
                throw new HttpDataSource.HttpDataSourceException(2008);
            }
            j2 -= i3;
            l(i3);
        }
    }
}
