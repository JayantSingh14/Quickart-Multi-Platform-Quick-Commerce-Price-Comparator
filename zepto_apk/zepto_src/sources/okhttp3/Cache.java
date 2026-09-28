package okhttp3;

import coil3.network.internal.UtilsKt;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Base64;
import okio.Buffer;
import okio.Buffer$inputStream$1;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.xbill.DNS.TTL;

@Metadata
/* loaded from: classes3.dex */
public final class Cache implements Closeable, Flushable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final DiskLruCache f56145a;

    @Metadata
    public static final class CacheResponseBody extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        public final DiskLruCache.Snapshot f56146b;

        /* renamed from: c, reason: collision with root package name */
        public final String f56147c;

        /* renamed from: d, reason: collision with root package name */
        public final String f56148d;

        /* renamed from: e, reason: collision with root package name */
        public final RealBufferedSource f56149e;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.f56146b = snapshot;
            this.f56147c = str;
            this.f56148d = str2;
            this.f56149e = Okio.d(new ForwardingSource((Source) snapshot.f56455c.get(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
                public final void close() throws IOException {
                    this.f56146b.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public final long e() {
            String str = this.f56148d;
            if (str == null) {
                return -1L;
            }
            byte[] bArr = Util.f56394a;
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public final MediaType l() {
            String str = this.f56147c;
            if (str == null) {
                return null;
            }
            Pattern pattern = MediaType.f56278d;
            return MediaType.Companion.b(str);
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.f56149e;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static String a(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            ByteString byteString = ByteString.f56924d;
            return ByteString.Companion.c(url.f56267i).c(MessageDigestAlgorithms.MD5).e();
        }

        public static int b(RealBufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long jR = source.r();
                String strZ = source.Z(Long.MAX_VALUE);
                if (jR >= 0 && jR <= TTL.MAX_VALUE && strZ.length() <= 0) {
                    return (int) jR;
                }
                throw new IOException("expected an int but was \"" + jR + strZ + '\"');
            } catch (NumberFormatException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public static Set c(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                if ("Vary".equalsIgnoreCase(headers.f(i2))) {
                    String strM = headers.m(i2);
                    if (treeSet == null) {
                        Intrinsics.checkNotNullParameter(StringCompanionObject.f53805a, "<this>");
                        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
                        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
                        treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
                    }
                    Iterator it = StringsKt.M(strM, new char[]{','}).iterator();
                    while (it.hasNext()) {
                        treeSet.add(StringsKt.b0((String) it.next()).toString());
                    }
                }
            }
            return treeSet == null ? EmptySet.f53611a : treeSet;
        }
    }

    @Metadata
    public final class RealCacheRequest implements CacheRequest {

        /* renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Editor f56163a;

        /* renamed from: b, reason: collision with root package name */
        public final Sink f56164b;

        /* renamed from: c, reason: collision with root package name */
        public final AnonymousClass1 f56165c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f56166d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Cache f56167e;

        /* JADX WARN: Type inference failed for: r0v2, types: [okhttp3.Cache$RealCacheRequest$1] */
        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.f56167e = cache;
            this.f56163a = editor;
            Sink sinkD = editor.d(1);
            this.f56164b = sinkD;
            this.f56165c = new ForwardingSink(sinkD) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.f56166d) {
                            return;
                        }
                        realCacheRequest.f56166d = true;
                        super.close();
                        this.f56163a.b();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final AnonymousClass1 a() {
            return this.f56165c;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final void abort() {
            synchronized (this.f56167e) {
                if (this.f56166d) {
                    return;
                }
                this.f56166d = true;
                Util.c(this.f56164b);
                try {
                    this.f56163a.a();
                } catch (IOException unused) {
                }
            }
        }
    }

    public Cache(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        FileSystem fileSystem = FileSystem.f56767a;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.f56145a = new DiskLruCache(fileSystem, directory, TaskRunner.f56473h);
    }

    public static void r(Response cached, Response network) throws Throwable {
        DiskLruCache.Editor editorC;
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        Entry entry = new Entry(network);
        ResponseBody responseBody = cached.f56356g;
        Intrinsics.d(responseBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        DiskLruCache.Snapshot snapshot = ((CacheResponseBody) responseBody).f56146b;
        try {
            String str = snapshot.f56453a;
            editorC = snapshot.f56456d.c(snapshot.f56454b, str);
            if (editorC == null) {
                return;
            }
            try {
                entry.c(editorC);
                editorC.b();
            } catch (IOException unused) {
                if (editorC != null) {
                    try {
                        editorC.a();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (IOException unused3) {
            editorC = null;
        }
    }

    public final Response a(Request newRequest) {
        Intrinsics.checkNotNullParameter(newRequest, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.f56145a.e(Companion.a(newRequest.f56331a));
            if (snapshot != null) {
                try {
                    Entry entry = new Entry((Source) snapshot.f56455c.get(0));
                    Headers cachedRequest = entry.f56154b;
                    String str = entry.f56155c;
                    HttpUrl url = entry.f56153a;
                    Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                    Headers headers = entry.f56159g;
                    String strD = headers.d(UtilsKt.CONTENT_TYPE);
                    String strD2 = headers.d("Content-Length");
                    Request.Builder builder = new Request.Builder();
                    Intrinsics.checkNotNullParameter(url, "url");
                    builder.f56337a = url;
                    builder.f(str, null);
                    builder.e(cachedRequest);
                    Request request = builder.b();
                    Response.Builder builder2 = new Response.Builder();
                    Intrinsics.checkNotNullParameter(request, "request");
                    builder2.f56363a = request;
                    Protocol protocol = entry.f56156d;
                    Intrinsics.checkNotNullParameter(protocol, "protocol");
                    builder2.f56364b = protocol;
                    builder2.f56365c = entry.f56157e;
                    String message = entry.f56158f;
                    Intrinsics.checkNotNullParameter(message, "message");
                    builder2.f56366d = message;
                    builder2.c(headers);
                    builder2.f56369g = new CacheResponseBody(snapshot, strD, strD2);
                    builder2.f56367e = entry.f56160h;
                    builder2.f56373k = entry.f56161i;
                    builder2.f56374l = entry.f56162j;
                    Response cachedResponse = builder2.a();
                    Intrinsics.checkNotNullParameter(newRequest, "request");
                    Intrinsics.checkNotNullParameter(cachedResponse, "response");
                    if (url.equals(newRequest.f56331a) && str.equals(newRequest.f56332b)) {
                        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
                        Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
                        Intrinsics.checkNotNullParameter(newRequest, "newRequest");
                        Set<String> setC = Companion.c(cachedResponse.f56355f);
                        if (setC == null || !setC.isEmpty()) {
                            for (String name : setC) {
                                List listN = cachedRequest.n(name);
                                Intrinsics.checkNotNullParameter(name, "name");
                                if (!Intrinsics.b(listN, newRequest.f56333c.n(name))) {
                                }
                            }
                        }
                        return cachedResponse;
                    }
                    ResponseBody responseBody = cachedResponse.f56356g;
                    if (responseBody != null) {
                        Util.c(responseBody);
                        return null;
                    }
                } catch (IOException unused) {
                    Util.c(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public final CacheRequest b(Response response) throws Throwable {
        DiskLruCache.Editor editorC;
        Intrinsics.checkNotNullParameter(response, "response");
        Request request = response.f56350a;
        String str = request.f56332b;
        if (HttpMethod.a(str)) {
            c(request);
            return null;
        }
        if (str.equals(UtilsKt.HTTP_METHOD_GET)) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            if (!Companion.c(response.f56355f).contains("*")) {
                Entry entry = new Entry(response);
                try {
                    DiskLruCache diskLruCache = this.f56145a;
                    String strA = Companion.a(request.f56331a);
                    Regex regex = DiskLruCache.s;
                    editorC = diskLruCache.c(-1L, strA);
                    if (editorC != null) {
                        try {
                            entry.c(editorC);
                            return new RealCacheRequest(this, editorC);
                        } catch (IOException unused) {
                            if (editorC != null) {
                                editorC.a();
                            }
                            return null;
                        }
                    }
                } catch (IOException unused2) {
                    editorC = null;
                }
            }
        }
        return null;
    }

    public final void c(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String key = Companion.a(request.f56331a);
        DiskLruCache diskLruCache = this.f56145a;
        synchronized (diskLruCache) {
            Intrinsics.checkNotNullParameter(key, "key");
            diskLruCache.l();
            diskLruCache.a();
            DiskLruCache.T(key);
            DiskLruCache.Entry entry = (DiskLruCache.Entry) diskLruCache.f56428h.get(key);
            if (entry == null) {
                return;
            }
            diskLruCache.N(entry);
            if (diskLruCache.f56426f <= 10485760) {
                diskLruCache.n = false;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56145a.close();
    }

    public final synchronized void e() {
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.f56145a.flush();
    }

    public final synchronized void l(CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
    }

    @Metadata
    public static final class Entry {

        /* renamed from: k, reason: collision with root package name */
        public static final String f56151k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f56152l;

        /* renamed from: a, reason: collision with root package name */
        public final HttpUrl f56153a;

        /* renamed from: b, reason: collision with root package name */
        public final Headers f56154b;

        /* renamed from: c, reason: collision with root package name */
        public final String f56155c;

        /* renamed from: d, reason: collision with root package name */
        public final Protocol f56156d;

        /* renamed from: e, reason: collision with root package name */
        public final int f56157e;

        /* renamed from: f, reason: collision with root package name */
        public final String f56158f;

        /* renamed from: g, reason: collision with root package name */
        public final Headers f56159g;

        /* renamed from: h, reason: collision with root package name */
        public final Handshake f56160h;

        /* renamed from: i, reason: collision with root package name */
        public final long f56161i;

        /* renamed from: j, reason: collision with root package name */
        public final long f56162j;

        @Metadata
        public static final class Companion {
        }

        static {
            Platform platform = Platform.f56791a;
            Platform.f56791a.getClass();
            f56151k = "OkHttp-Sent-Millis";
            Platform.f56791a.getClass();
            f56152l = "OkHttp-Received-Millis";
        }

        public Entry(Source rawSource) throws IOException {
            HttpUrl httpUrlC;
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            try {
                RealBufferedSource realBufferedSourceD = Okio.d(rawSource);
                String strZ = realBufferedSourceD.Z(Long.MAX_VALUE);
                Intrinsics.checkNotNullParameter(strZ, "<this>");
                try {
                    httpUrlC = HttpUrl.Companion.c(strZ);
                } catch (IllegalArgumentException unused) {
                    httpUrlC = null;
                }
                if (httpUrlC == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(strZ));
                    Platform platform = Platform.f56791a;
                    Platform.f56791a.getClass();
                    Platform.i(5, "cache corruption", iOException);
                    throw iOException;
                }
                this.f56153a = httpUrlC;
                this.f56155c = realBufferedSourceD.Z(Long.MAX_VALUE);
                Headers.Builder builder = new Headers.Builder();
                int iB = Companion.b(realBufferedSourceD);
                for (int i2 = 0; i2 < iB; i2++) {
                    builder.b(realBufferedSourceD.Z(Long.MAX_VALUE));
                }
                this.f56154b = builder.e();
                StatusLine statusLineA = StatusLine.Companion.a(realBufferedSourceD.Z(Long.MAX_VALUE));
                this.f56156d = statusLineA.f56591a;
                this.f56157e = statusLineA.f56592b;
                this.f56158f = statusLineA.f56593c;
                Headers.Builder builder2 = new Headers.Builder();
                int iB2 = Companion.b(realBufferedSourceD);
                for (int i3 = 0; i3 < iB2; i3++) {
                    builder2.b(realBufferedSourceD.Z(Long.MAX_VALUE));
                }
                String str = f56151k;
                String strF = builder2.f(str);
                String str2 = f56152l;
                String strF2 = builder2.f(str2);
                builder2.g(str);
                builder2.g(str2);
                this.f56161i = strF != null ? Long.parseLong(strF) : 0L;
                this.f56162j = strF2 != null ? Long.parseLong(strF2) : 0L;
                this.f56159g = builder2.e();
                if (Intrinsics.b(this.f56153a.f56259a, "https")) {
                    String strZ2 = realBufferedSourceD.Z(Long.MAX_VALUE);
                    if (strZ2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strZ2 + '\"');
                    }
                    CipherSuite cipherSuite = CipherSuite.f56197b.b(realBufferedSourceD.Z(Long.MAX_VALUE));
                    List peerCertificates = a(realBufferedSourceD);
                    List localCertificates = a(realBufferedSourceD);
                    TlsVersion tlsVersion = !realBufferedSourceD.a() ? TlsVersion.Companion.a(realBufferedSourceD.Z(Long.MAX_VALUE)) : TlsVersion.SSL_3_0;
                    Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
                    Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
                    Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
                    Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
                    final List listY = Util.y(peerCertificates);
                    this.f56160h = new Handshake(tlsVersion, cipherSuite, Util.y(localCertificates), new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return listY;
                        }
                    });
                } else {
                    this.f56160h = null;
                }
                Unit unit = Unit.f53572a;
                rawSource.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.a(rawSource, th);
                    throw th2;
                }
            }
        }

        public static List a(RealBufferedSource realBufferedSource) throws IOException, CertificateException {
            int iB = Companion.b(realBufferedSource);
            if (iB == -1) {
                return EmptyList.f53609a;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iB);
                for (int i2 = 0; i2 < iB; i2++) {
                    String strZ = realBufferedSource.Z(Long.MAX_VALUE);
                    Buffer buffer = new Buffer();
                    ByteString byteString = ByteString.f56924d;
                    ByteString byteStringA = ByteString.Companion.a(strZ);
                    if (byteStringA == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer.s1(byteStringA);
                    arrayList.add(certificateFactory.generateCertificate(new Buffer$inputStream$1(buffer)));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public static void b(RealBufferedSink realBufferedSink, List list) throws IOException, CertificateEncodingException {
            try {
                realBufferedSink.E0(list.size());
                realBufferedSink.writeByte(10);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    byte[] bytes = ((Certificate) it.next()).getEncoded();
                    ByteString byteString = ByteString.f56924d;
                    Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                    realBufferedSink.Y(Base64.b(ByteString.Companion.d(SegmentedByteString.f56900b, bytes).f56925a));
                    realBufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final void c(DiskLruCache.Editor editor) throws Throwable {
            HttpUrl httpUrl = this.f56153a;
            Handshake handshake = this.f56160h;
            Headers headers = this.f56159g;
            Headers headers2 = this.f56154b;
            Intrinsics.checkNotNullParameter(editor, "editor");
            RealBufferedSink realBufferedSinkC = Okio.c(editor.d(0));
            try {
                realBufferedSinkC.Y(httpUrl.f56267i);
                realBufferedSinkC.writeByte(10);
                realBufferedSinkC.Y(this.f56155c);
                realBufferedSinkC.writeByte(10);
                realBufferedSinkC.E0(headers2.size());
                realBufferedSinkC.writeByte(10);
                int size = headers2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    realBufferedSinkC.Y(headers2.f(i2));
                    realBufferedSinkC.Y(": ");
                    realBufferedSinkC.Y(headers2.m(i2));
                    realBufferedSinkC.writeByte(10);
                }
                realBufferedSinkC.Y(new StatusLine(this.f56156d, this.f56157e, this.f56158f).toString());
                realBufferedSinkC.writeByte(10);
                realBufferedSinkC.E0(headers.size() + 2);
                realBufferedSinkC.writeByte(10);
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    realBufferedSinkC.Y(headers.f(i3));
                    realBufferedSinkC.Y(": ");
                    realBufferedSinkC.Y(headers.m(i3));
                    realBufferedSinkC.writeByte(10);
                }
                realBufferedSinkC.Y(f56151k);
                realBufferedSinkC.Y(": ");
                realBufferedSinkC.E0(this.f56161i);
                realBufferedSinkC.writeByte(10);
                realBufferedSinkC.Y(f56152l);
                realBufferedSinkC.Y(": ");
                realBufferedSinkC.E0(this.f56162j);
                realBufferedSinkC.writeByte(10);
                if (Intrinsics.b(httpUrl.f56259a, "https")) {
                    realBufferedSinkC.writeByte(10);
                    Intrinsics.c(handshake);
                    realBufferedSinkC.Y(handshake.f56250b.f56209a);
                    realBufferedSinkC.writeByte(10);
                    b(realBufferedSinkC, handshake.a());
                    b(realBufferedSinkC, handshake.f56251c);
                    realBufferedSinkC.Y(handshake.f56249a.f56393a);
                    realBufferedSinkC.writeByte(10);
                }
                Unit unit = Unit.f53572a;
                realBufferedSinkC.close();
            } finally {
            }
        }

        public Entry(Response response) {
            Headers headersE;
            Intrinsics.checkNotNullParameter(response, "response");
            Request request = response.f56350a;
            this.f56153a = request.f56331a;
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response response2 = response.f56357h;
            Intrinsics.c(response2);
            Headers headers = response2.f56350a.f56333c;
            Headers headers2 = response.f56355f;
            Set setC = Companion.c(headers2);
            if (setC.isEmpty()) {
                headersE = Util.f56395b;
            } else {
                Headers.Builder builder = new Headers.Builder();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String strF = headers.f(i2);
                    if (setC.contains(strF)) {
                        builder.a(strF, headers.m(i2));
                    }
                }
                headersE = builder.e();
            }
            this.f56154b = headersE;
            this.f56155c = request.f56332b;
            this.f56156d = response.f56351b;
            this.f56157e = response.f56353d;
            this.f56158f = response.f56352c;
            this.f56159g = headers2;
            this.f56160h = response.f56354e;
            this.f56161i = response.f56360k;
            this.f56162j = response.f56361l;
        }
    }
}
