package androidx.media3.exoplayer.audio;

import android.media.MediaCodecInfo;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint e() {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720, 60);
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint f(int i2, int i3, int i4) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i2, i3, i4);
    }

    public static /* bridge */ /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint g(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static /* synthetic */ void i() {
    }
}
