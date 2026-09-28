package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.b;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import com.google.common.base.Charsets;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class CacheDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleCache f5961a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDataSource f5962b;

    /* renamed from: c, reason: collision with root package name */
    public final TeeDataSource f5963c;

    /* renamed from: d, reason: collision with root package name */
    public final DataSource f5964d;

    /* renamed from: e, reason: collision with root package name */
    public final CacheKeyFactory f5965e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5966f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5967g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5968h;

    /* renamed from: i, reason: collision with root package name */
    public Uri f5969i;

    /* renamed from: j, reason: collision with root package name */
    public DataSpec f5970j;

    /* renamed from: k, reason: collision with root package name */
    public DataSpec f5971k;

    /* renamed from: l, reason: collision with root package name */
    public DataSource f5972l;

    /* renamed from: m, reason: collision with root package name */
    public long f5973m;
    public long n;
    public long o;
    public CacheSpan p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
    }

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public SimpleCache f5974a;

        /* renamed from: b, reason: collision with root package name */
        public final FileDataSource.Factory f5975b = new FileDataSource.Factory();

        /* renamed from: c, reason: collision with root package name */
        public final b f5976c = CacheKeyFactory.d0;

        /* renamed from: d, reason: collision with root package name */
        public HttpDataSource.Factory f5977d;

        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            CacheDataSink cacheDataSink;
            HttpDataSource.Factory factory = this.f5977d;
            DataSource dataSourceA = factory != null ? factory.a() : null;
            SimpleCache simpleCache = this.f5974a;
            simpleCache.getClass();
            if (dataSourceA == null) {
                cacheDataSink = null;
            } else {
                new CacheDataSink.Factory();
                cacheDataSink = new CacheDataSink(simpleCache);
            }
            CacheDataSink cacheDataSink2 = cacheDataSink;
            this.f5975b.getClass();
            return new CacheDataSource(simpleCache, dataSourceA, new FileDataSource(), cacheDataSink2, this.f5976c, 0, 0);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(SimpleCache simpleCache, DataSource dataSource, FileDataSource fileDataSource, CacheDataSink cacheDataSink, b bVar, int i2, int i3) {
        this.f5961a = simpleCache;
        this.f5962b = fileDataSource;
        this.f5965e = bVar == null ? CacheKeyFactory.d0 : bVar;
        this.f5966f = (i2 & 1) != 0;
        this.f5967g = false;
        this.f5968h = false;
        if (dataSource != null) {
            this.f5964d = dataSource;
            this.f5963c = cacheDataSink != null ? new TeeDataSource(dataSource, cacheDataSink) : null;
        } else {
            this.f5964d = PlaceholderDataSource.f5921a;
            this.f5963c = null;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f5962b.a(transferListener);
        this.f5964d.a(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        return !(this.f5972l == this.f5962b) ? this.f5964d.c() : Collections.EMPTY_MAP;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5970j = null;
        this.f5969i = null;
        this.n = 0L;
        try {
            l();
        } catch (Throwable th) {
            if (this.f5972l == this.f5962b || (th instanceof Cache.CacheException)) {
                this.q = true;
            }
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        long j2;
        SimpleCache simpleCache = this.f5961a;
        try {
            String strA = this.f5965e.a(dataSpec);
            DataSpec.Builder builderA = dataSpec.a();
            long j3 = dataSpec.f5856f;
            builderA.f5867h = strA;
            DataSpec dataSpecA = builderA.a();
            this.f5970j = dataSpecA;
            Uri uri = dataSpecA.f5851a;
            byte[] bArr = (byte[]) simpleCache.h(strA).f6020b.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, Charsets.f42260c) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.f5969i = uri;
            this.n = j3;
            boolean z = this.f5967g;
            long j4 = dataSpec.f5857g;
            boolean z2 = (z && this.q) || (this.f5968h && j4 == -1);
            this.r = z2;
            if (z2) {
                this.o = -1L;
                j2 = -1;
            } else {
                j2 = -1;
                long jB = simpleCache.h(strA).b();
                this.o = jB;
                if (jB != -1) {
                    long j5 = jB - j3;
                    this.o = j5;
                    if (j5 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            if (j4 != j2) {
                long j6 = this.o;
                this.o = j6 == j2 ? j4 : Math.min(j6, j4);
            }
            long j7 = this.o;
            if (j7 > 0 || j7 == j2) {
                m(dataSpecA, false);
            }
            return j4 != j2 ? j4 : this.o;
        } catch (Throwable th) {
            if (this.f5972l == this.f5962b || (th instanceof Cache.CacheException)) {
                this.q = true;
            }
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5969i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        SimpleCache simpleCache = this.f5961a;
        DataSource dataSource = this.f5972l;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.f5971k = null;
            this.f5972l = null;
            CacheSpan cacheSpan = this.p;
            if (cacheSpan != null) {
                simpleCache.j(cacheSpan);
                this.p = null;
            }
        }
    }

    public final void m(DataSpec dataSpec, boolean z) throws InterruptedIOException {
        CacheSpan cacheSpanM;
        long j2;
        DataSpec dataSpecA;
        DataSource dataSource;
        String str = dataSpec.f5858h;
        int i2 = Util.f5744a;
        if (this.r) {
            cacheSpanM = null;
        } else if (this.f5966f) {
            try {
                SimpleCache simpleCache = this.f5961a;
                long j3 = this.n;
                long j4 = this.o;
                synchronized (simpleCache) {
                    simpleCache.d();
                    while (true) {
                        cacheSpanM = simpleCache.m(j3, j4, str);
                        if (cacheSpanM != null) {
                            break;
                        } else {
                            simpleCache.wait();
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpanM = this.f5961a.m(this.n, this.o, str);
        }
        SimpleCache simpleCache2 = this.f5961a;
        DataSource dataSource2 = this.f5964d;
        if (cacheSpanM == null) {
            DataSpec.Builder builderA = dataSpec.a();
            builderA.f5865f = this.n;
            builderA.f5866g = this.o;
            dataSpecA = builderA.a();
            dataSource = dataSource2;
            j2 = -1;
        } else {
            boolean z2 = cacheSpanM.f5986d;
            long jMin = cacheSpanM.f5985c;
            if (z2) {
                Uri uriFromFile = Uri.fromFile(cacheSpanM.f5987e);
                long j5 = this.n;
                long j6 = cacheSpanM.f5984b;
                long j7 = j5 - j6;
                long jMin2 = jMin - j7;
                j2 = -1;
                long j8 = this.o;
                if (j8 != -1) {
                    jMin2 = Math.min(jMin2, j8);
                }
                DataSpec.Builder builderA2 = dataSpec.a();
                builderA2.f5860a = uriFromFile;
                builderA2.f5861b = j6;
                builderA2.f5865f = j7;
                builderA2.f5866g = jMin2;
                dataSpecA = builderA2.a();
                dataSource = this.f5962b;
            } else {
                j2 = -1;
                if (jMin == -1) {
                    jMin = this.o;
                } else {
                    long j9 = this.o;
                    if (j9 != -1) {
                        jMin = Math.min(jMin, j9);
                    }
                }
                DataSpec.Builder builderA3 = dataSpec.a();
                builderA3.f5865f = this.n;
                builderA3.f5866g = jMin;
                dataSpecA = builderA3.a();
                dataSource = this.f5963c;
                if (dataSource == null) {
                    simpleCache2.j(cacheSpanM);
                    dataSource = dataSource2;
                    cacheSpanM = null;
                }
            }
        }
        this.t = (this.r || dataSource != dataSource2) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            Assertions.g(this.f5972l == dataSource2);
            if (dataSource == dataSource2) {
                return;
            }
            try {
                l();
            } catch (Throwable th) {
                if (!cacheSpanM.f5986d) {
                    simpleCache2.j(cacheSpanM);
                }
                throw th;
            }
        }
        if (cacheSpanM != null && !cacheSpanM.f5986d) {
            this.p = cacheSpanM;
        }
        this.f5972l = dataSource;
        this.f5971k = dataSpecA;
        this.f5973m = 0L;
        long j10 = dataSource.j(dataSpecA);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpecA.f5857g == j2 && j10 != j2) {
            this.o = j10;
            contentMetadataMutations.a(Long.valueOf(this.n + j10), "exo_len");
        }
        if (!(this.f5972l == this.f5962b)) {
            Uri uriK = dataSource.k();
            this.f5969i = uriK;
            Uri uri = dataSpec.f5851a.equals(uriK) ? null : this.f5969i;
            if (uri == null) {
                contentMetadataMutations.f6017b.add("exo_redir");
                contentMetadataMutations.f6016a.remove("exo_redir");
            } else {
                contentMetadataMutations.a(uri.toString(), "exo_redir");
            }
        }
        if (this.f5972l == this.f5963c) {
            simpleCache2.c(str, contentMetadataMutations);
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        int i4;
        long j2;
        FileDataSource fileDataSource = this.f5962b;
        if (i3 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        DataSpec dataSpec = this.f5970j;
        dataSpec.getClass();
        DataSpec dataSpec2 = this.f5971k;
        dataSpec2.getClass();
        try {
            if (this.n >= this.t) {
                m(dataSpec, true);
            }
            DataSource dataSource = this.f5972l;
            dataSource.getClass();
            int i5 = dataSource.read(bArr, i2, i3);
            if (i5 != -1) {
                if (this.f5972l == fileDataSource) {
                    this.s += i5;
                }
                long j3 = i5;
                this.n += j3;
                this.f5973m += j3;
                long j4 = this.o;
                if (j4 == -1) {
                    return i5;
                }
                this.o = j4 - j3;
                return i5;
            }
            DataSource dataSource2 = this.f5972l;
            if (!(dataSource2 == fileDataSource)) {
                j2 = -1;
                long j5 = dataSpec2.f5857g;
                if (j5 != -1) {
                    i4 = i5;
                    if (this.f5973m < j5) {
                    }
                } else {
                    i4 = i5;
                }
                String str = dataSpec.f5858h;
                int i6 = Util.f5744a;
                this.o = 0L;
                if (!(dataSource2 == this.f5963c)) {
                    return i4;
                }
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                contentMetadataMutations.a(Long.valueOf(this.n), "exo_len");
                this.f5961a.c(str, contentMetadataMutations);
                return i4;
            }
            i4 = i5;
            j2 = -1;
            long j6 = this.o;
            if (j6 <= 0 && j6 != j2) {
                return i4;
            }
            l();
            m(dataSpec, false);
            return read(bArr, i2, i3);
        } catch (Throwable th) {
            if (this.f5972l == fileDataSource || (th instanceof Cache.CacheException)) {
                this.q = true;
            }
            throw th;
        }
    }
}
