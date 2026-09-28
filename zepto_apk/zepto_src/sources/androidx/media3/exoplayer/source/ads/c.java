package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7821a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7822b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7823c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f7821a = i2;
        this.f7822b = obj;
        this.f7823c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7821a) {
            case 0:
                AdsMediaSource adsMediaSource = AdsMediaSource.this;
                AdsLoader adsLoader = adsMediaSource.n;
                MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.f7823c;
                adsLoader.c(adsMediaSource, mediaPeriodId.f7610b, mediaPeriodId.f7611c);
                break;
            default:
                AdsMediaSource.ComponentListener componentListener = (AdsMediaSource.ComponentListener) this.f7822b;
                AdPlaybackState adPlaybackState = (AdPlaybackState) this.f7823c;
                if (!componentListener.f7789b) {
                    AdsMediaSource adsMediaSource2 = AdsMediaSource.this;
                    AdPlaybackState adPlaybackState2 = adsMediaSource2.v;
                    if (adPlaybackState2 == null) {
                        AdsMediaSource.AdMediaSourceHolder[][] adMediaSourceHolderArr = new AdsMediaSource.AdMediaSourceHolder[adPlaybackState.f5125b][];
                        adsMediaSource2.w = adMediaSourceHolderArr;
                        Arrays.fill(adMediaSourceHolderArr, new AdsMediaSource.AdMediaSourceHolder[0]);
                    } else {
                        Assertions.g(adPlaybackState.f5125b == adPlaybackState2.f5125b);
                    }
                    adsMediaSource2.v = adPlaybackState;
                    adsMediaSource2.s0();
                    adsMediaSource2.t0();
                    break;
                }
                break;
        }
    }
}
