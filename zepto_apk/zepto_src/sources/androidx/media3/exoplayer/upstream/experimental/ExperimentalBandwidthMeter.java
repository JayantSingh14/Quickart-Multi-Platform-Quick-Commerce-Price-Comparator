package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;

@UnstableApi
/* loaded from: classes3.dex */
public final class ExperimentalBandwidthMeter implements BandwidthMeter, TransferListener {

    public static final class Builder {
    }

    static {
        ImmutableList.s(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
        ImmutableList.s(1500000L, 980000L, 750000L, 520000L, 290000L);
        ImmutableList.s(2000000L, 1300000L, 1000000L, 860000L, 610000L);
        ImmutableList.s(2500000L, 1700000L, 1200000L, 970000L, 680000L);
        ImmutableList.s(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
        ImmutableList.s(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    }

    public static boolean j(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.c(8);
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final synchronized void a(BandwidthMeter.EventListener eventListener) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final synchronized long b() {
        throw null;
    }

    @Override // androidx.media3.datasource.TransferListener
    public final synchronized void c(DataSpec dataSpec, boolean z, int i2) {
        if (j(dataSpec, z)) {
            throw null;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final synchronized void d(Handler handler, BandwidthMeter.EventListener eventListener) {
        eventListener.getClass();
        throw null;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final TransferListener e() {
        return this;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final synchronized long f() {
        throw null;
    }

    @Override // androidx.media3.datasource.TransferListener
    public final synchronized void g(DataSpec dataSpec, boolean z) {
        if (j(dataSpec, z)) {
            throw null;
        }
    }

    @Override // androidx.media3.datasource.TransferListener
    public final synchronized void h(DataSpec dataSpec, boolean z) {
        if (j(dataSpec, z)) {
            throw null;
        }
    }

    @Override // androidx.media3.datasource.TransferListener
    public final synchronized void i(DataSpec dataSpec, boolean z) {
        if (j(dataSpec, z)) {
            throw null;
        }
    }
}
