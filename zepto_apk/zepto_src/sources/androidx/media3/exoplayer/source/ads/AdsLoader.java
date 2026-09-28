package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface AdsLoader {

    @UnstableApi
    public interface EventListener {
        default void a(AdPlaybackState adPlaybackState) {
        }

        default void b(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
        }
    }

    public interface Provider {
        ImaAdsLoader a();
    }

    void a(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void b(AdsMediaSource adsMediaSource, EventListener eventListener);

    void c(AdsMediaSource adsMediaSource, int i2, int i3);

    void d(int... iArr);

    void e(AdsMediaSource adsMediaSource, int i2, int i3, IOException iOException);
}
