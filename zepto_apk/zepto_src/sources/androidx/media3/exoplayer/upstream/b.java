package androidx.media3.exoplayer.upstream;

import android.os.SystemClock;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements NetworkTypeObserver.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f8205a;

    public /* synthetic */ b(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f8205a = defaultBandwidthMeter;
    }

    @Override // androidx.media3.common.util.NetworkTypeObserver.Listener
    public final void a(int i2) {
        DefaultBandwidthMeter defaultBandwidthMeter = this.f8205a;
        ImmutableList immutableList = DefaultBandwidthMeter.n;
        synchronized (defaultBandwidthMeter) {
            int i3 = defaultBandwidthMeter.f8149m;
            if (i3 == 0 || defaultBandwidthMeter.f8140d) {
                if (i3 == i2) {
                    return;
                }
                defaultBandwidthMeter.f8149m = i2;
                if (i2 != 1 && i2 != 0 && i2 != 8) {
                    defaultBandwidthMeter.f8147k = defaultBandwidthMeter.j(i2);
                    defaultBandwidthMeter.f8139c.getClass();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    int i4 = defaultBandwidthMeter.f8142f > 0 ? (int) (jElapsedRealtime - defaultBandwidthMeter.f8143g) : 0;
                    long j2 = defaultBandwidthMeter.f8144h;
                    long j3 = defaultBandwidthMeter.f8147k;
                    if (i4 != 0 || j2 != 0 || j3 != defaultBandwidthMeter.f8148l) {
                        defaultBandwidthMeter.f8148l = j3;
                        Iterator it = defaultBandwidthMeter.f8138b.f8061a.iterator();
                        while (it.hasNext()) {
                            BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener = (BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener) it.next();
                            if (!handlerAndListener.f8064c) {
                                handlerAndListener.f8062a.post(new a(handlerAndListener, i4, j2, j3));
                            }
                        }
                    }
                    defaultBandwidthMeter.f8143g = jElapsedRealtime;
                    defaultBandwidthMeter.f8144h = 0L;
                    defaultBandwidthMeter.f8146j = 0L;
                    defaultBandwidthMeter.f8145i = 0L;
                    SlidingPercentile slidingPercentile = defaultBandwidthMeter.f8141e;
                    slidingPercentile.f8192b.clear();
                    slidingPercentile.f8194d = -1;
                    slidingPercentile.f8195e = 0;
                    slidingPercentile.f8196f = 0;
                }
            }
        }
    }
}
