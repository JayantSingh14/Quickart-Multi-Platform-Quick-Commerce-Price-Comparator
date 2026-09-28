package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements MediaCodecUtil.ScoreProvider {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Format f7359b;

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
    public final int a(Object obj) {
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        Pattern pattern = MediaCodecUtil.f7340a;
        mediaCodecInfo.getClass();
        Format format = this.f7359b;
        String str = format.f5225m;
        String str2 = mediaCodecInfo.f7321b;
        return ((str2.equals(str) || str2.equals(MediaCodecUtil.b(format))) && mediaCodecInfo.c(format, false)) ? 1 : 0;
    }
}
