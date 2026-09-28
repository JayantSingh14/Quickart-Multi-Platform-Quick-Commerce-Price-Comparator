package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import coil3.network.internal.UtilsKt;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource.Factory f6942a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6943b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6944c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f6945d;

    public HttpMediaDrmCallback(String str, boolean z, DataSource.Factory factory) {
        Assertions.a((z && TextUtils.isEmpty(str)) ? false : true);
        this.f6942a = factory;
        this.f6943b = str;
        this.f6944c = z;
        this.f6945d = new HashMap();
    }

    public static byte[] b(DataSource.Factory factory, String str, byte[] bArr, Map map) throws MediaDrmCallbackException {
        Map map2;
        List list;
        StatsDataSource statsDataSource = new StatsDataSource(factory.a());
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = Uri.parse(str);
        builder.f5864e = map;
        builder.f5862c = 2;
        builder.f5863d = bArr;
        builder.f5868i = 1;
        DataSpec dataSpecA = builder.a();
        int i2 = 0;
        int i3 = 0;
        DataSpec dataSpecA2 = dataSpecA;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecA2);
                try {
                    byte[] bArrC = ByteStreams.c(dataSourceInputStream);
                    Util.h(dataSourceInputStream);
                    return bArrC;
                } catch (HttpDataSource.InvalidResponseCodeException e2) {
                    try {
                        int i4 = e2.f5900d;
                        String str2 = null;
                        if ((i4 == 307 || i4 == 308) && i3 < 5 && (map2 = e2.f5901e) != null && (list = (List) map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = (String) list.get(i2);
                        }
                        if (str2 == null) {
                            throw e2;
                        }
                        i3++;
                        DataSpec.Builder builderA = dataSpecA2.a();
                        builderA.f5860a = Uri.parse(str2);
                        dataSpecA2 = builderA.a();
                        Util.h(dataSourceInputStream);
                    } catch (Throwable th) {
                        Util.h(dataSourceInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                Uri uri = statsDataSource.f5931c;
                uri.getClass();
                throw new MediaDrmCallbackException(dataSpecA, uri, statsDataSource.f5929a.c(), statsDataSource.f5930b, e3);
            }
        }
    }

    public final byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str = keyRequest.f6932b;
        if (this.f6944c || TextUtils.isEmpty(str)) {
            str = this.f6943b;
        }
        if (TextUtils.isEmpty(str)) {
            DataSpec.Builder builder = new DataSpec.Builder();
            Uri uri = Uri.EMPTY;
            builder.f5860a = uri;
            throw new MediaDrmCallbackException(builder.a(), uri, ImmutableMap.j(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.f5168e;
        map.put(UtilsKt.CONTENT_TYPE, uuid2.equals(uuid) ? coil3.util.UtilsKt.MIME_TYPE_XML : C.f5166c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f6945d) {
            map.putAll(this.f6945d);
        }
        return b(this.f6942a, str, keyRequest.f6931a, map);
    }

    public final byte[] c(ExoMediaDrm.ProvisionRequest provisionRequest) {
        return b(this.f6942a, provisionRequest.f6934b + "&signedRequest=" + Util.p(provisionRequest.f6933a), null, Collections.EMPTY_MAP);
    }

    public final void d(String str, String str2) {
        str.getClass();
        str2.getClass();
        synchronized (this.f6945d) {
            this.f6945d.put(str, str2);
        }
    }
}
