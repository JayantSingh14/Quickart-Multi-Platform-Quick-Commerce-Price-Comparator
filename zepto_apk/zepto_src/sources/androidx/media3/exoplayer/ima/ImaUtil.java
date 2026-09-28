package androidx.media3.exoplayer.ima;

import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSchemeDataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
final class ImaUtil {

    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final long f7243a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7244b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7245c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f7246d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f7247e;

        /* renamed from: f, reason: collision with root package name */
        public final int f7248f;

        /* renamed from: g, reason: collision with root package name */
        public final ReactExoplayerView f7249g;

        /* renamed from: h, reason: collision with root package name */
        public final ReactExoplayerView f7250h;

        /* renamed from: i, reason: collision with root package name */
        public final ImaSdkSettings f7251i;

        public Configuration(long j2, int i2, int i3, boolean z, boolean z2, int i4, ReactExoplayerView reactExoplayerView, ReactExoplayerView reactExoplayerView2, ImaSdkSettings imaSdkSettings) {
            this.f7243a = j2;
            this.f7244b = i2;
            this.f7245c = i3;
            this.f7246d = z;
            this.f7247e = z2;
            this.f7248f = i4;
            this.f7249g = reactExoplayerView;
            this.f7250h = reactExoplayerView2;
            this.f7251i = imaSdkSettings;
        }
    }

    public interface ImaFactory {
    }

    public static final class ServerSideAdInsertionConfiguration {
    }

    public static long[] a(List list) {
        if (list.isEmpty()) {
            return new long[]{0};
        }
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            double dFloatValue = ((Float) list.get(i3)).floatValue();
            if (dFloatValue == -1.0d) {
                jArr[size - 1] = Long.MIN_VALUE;
            } else {
                jArr[i2] = Math.round(dFloatValue * 1000000.0d);
                i2++;
            }
        }
        Arrays.sort(jArr, 0, i2);
        return jArr;
    }

    public static AdsRequest b(ImaFactory imaFactory, DataSpec dataSpec) {
        ((ImaAdsLoader.DefaultImaFactory) imaFactory).getClass();
        AdsRequest adsRequestCreateAdsRequest = ImaSdkFactory.getInstance().createAdsRequest();
        if (!"data".equals(dataSpec.f5851a.getScheme())) {
            adsRequestCreateAdsRequest.setAdTagUrl(dataSpec.f5851a.toString());
            return adsRequestCreateAdsRequest;
        }
        DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
        try {
            dataSchemeDataSource.j(dataSpec);
            adsRequestCreateAdsRequest.setAdsResponse(Util.p(DataSourceUtil.b(dataSchemeDataSource)));
            return adsRequestCreateAdsRequest;
        } finally {
            dataSchemeDataSource.close();
        }
    }
}
