package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;

/* loaded from: classes3.dex */
final class XingFrame {

    /* renamed from: a, reason: collision with root package name */
    public final MpegAudioUtil.Header f8960a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8961b;

    public XingFrame(MpegAudioUtil.Header header, long j2, long j3, long[] jArr, int i2, int i3) {
        MpegAudioUtil.Header header2 = new MpegAudioUtil.Header();
        header2.f8592a = header.f8592a;
        header2.f8593b = header.f8593b;
        header2.f8594c = header.f8594c;
        header2.f8595d = header.f8595d;
        header2.f8596e = header.f8596e;
        header2.f8597f = header.f8597f;
        header2.f8598g = header.f8598g;
        this.f8960a = header2;
        this.f8961b = j2;
    }

    public final long a() {
        long j2 = this.f8961b;
        if (j2 == -1 || j2 == 0) {
            return -9223372036854775807L;
        }
        return Util.Z(this.f8960a.f8595d, (j2 * r0.f8598g) - 1);
    }
}
