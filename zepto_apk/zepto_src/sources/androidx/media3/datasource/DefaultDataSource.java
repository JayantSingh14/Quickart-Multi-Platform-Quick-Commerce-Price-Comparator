package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DefaultDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5869a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5870b;

    /* renamed from: c, reason: collision with root package name */
    public final DataSource f5871c;

    /* renamed from: d, reason: collision with root package name */
    public FileDataSource f5872d;

    /* renamed from: e, reason: collision with root package name */
    public AssetDataSource f5873e;

    /* renamed from: f, reason: collision with root package name */
    public ContentDataSource f5874f;

    /* renamed from: g, reason: collision with root package name */
    public DataSource f5875g;

    /* renamed from: h, reason: collision with root package name */
    public UdpDataSource f5876h;

    /* renamed from: i, reason: collision with root package name */
    public DataSchemeDataSource f5877i;

    /* renamed from: j, reason: collision with root package name */
    public RawResourceDataSource f5878j;

    /* renamed from: k, reason: collision with root package name */
    public DataSource f5879k;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final Context f5880a;

        /* renamed from: b, reason: collision with root package name */
        public final HttpDataSource.Factory f5881b;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            return new DefaultDataSource(this.f5880a, this.f5881b.a());
        }

        public Factory(Context context, HttpDataSource.Factory factory) {
            this.f5880a = context.getApplicationContext();
            this.f5881b = factory;
        }
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f5869a = context.getApplicationContext();
        dataSource.getClass();
        this.f5871c = dataSource;
        this.f5870b = new ArrayList();
    }

    public static void m(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.a(transferListener);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f5871c.a(transferListener);
        this.f5870b.add(transferListener);
        m(this.f5872d, transferListener);
        m(this.f5873e, transferListener);
        m(this.f5874f, transferListener);
        m(this.f5875g, transferListener);
        m(this.f5876h, transferListener);
        m(this.f5877i, transferListener);
        m(this.f5878j, transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        DataSource dataSource = this.f5879k;
        return dataSource == null ? Collections.EMPTY_MAP : dataSource.c();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        DataSource dataSource = this.f5879k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f5879k = null;
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        Assertions.g(this.f5879k == null);
        String scheme = dataSpec.f5851a.getScheme();
        int i2 = Util.f5744a;
        Uri uri = dataSpec.f5851a;
        String scheme2 = uri.getScheme();
        boolean zIsEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f5869a;
        if (zIsEmpty || UtilsKt.SCHEME_FILE.equals(scheme2)) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f5872d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.f5872d = fileDataSource;
                    l(fileDataSource);
                }
                this.f5879k = this.f5872d;
            } else {
                if (this.f5873e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(context);
                    this.f5873e = assetDataSource;
                    l(assetDataSource);
                }
                this.f5879k = this.f5873e;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f5873e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(context);
                this.f5873e = assetDataSource2;
                l(assetDataSource2);
            }
            this.f5879k = this.f5873e;
        } else if ("content".equals(scheme)) {
            if (this.f5874f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(context);
                this.f5874f = contentDataSource;
                l(contentDataSource);
            }
            this.f5879k = this.f5874f;
        } else {
            boolean zEquals = "rtmp".equals(scheme);
            DataSource dataSource = this.f5871c;
            if (zEquals) {
                if (this.f5875g == null) {
                    try {
                        DataSource dataSource2 = (DataSource) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.f5875g = dataSource2;
                        l(dataSource2);
                    } catch (ClassNotFoundException unused) {
                        Log.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e2) {
                        throw new RuntimeException("Error instantiating RTMP extension", e2);
                    }
                    if (this.f5875g == null) {
                        this.f5875g = dataSource;
                    }
                }
                this.f5879k = this.f5875g;
            } else if ("udp".equals(scheme)) {
                if (this.f5876h == null) {
                    UdpDataSource udpDataSource = new UdpDataSource();
                    this.f5876h = udpDataSource;
                    l(udpDataSource);
                }
                this.f5879k = this.f5876h;
            } else if ("data".equals(scheme)) {
                if (this.f5877i == null) {
                    DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
                    this.f5877i = dataSchemeDataSource;
                    l(dataSchemeDataSource);
                }
                this.f5879k = this.f5877i;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.f5878j == null) {
                    RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
                    this.f5878j = rawResourceDataSource;
                    l(rawResourceDataSource);
                }
                this.f5879k = this.f5878j;
            } else {
                this.f5879k = dataSource;
            }
        }
        return this.f5879k.j(dataSpec);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        DataSource dataSource = this.f5879k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.k();
    }

    public final void l(DataSource dataSource) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f5870b;
            if (i2 >= arrayList.size()) {
                return;
            }
            dataSource.a((TransferListener) arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        DataSource dataSource = this.f5879k;
        dataSource.getClass();
        return dataSource.read(bArr, i2, i3);
    }
}
