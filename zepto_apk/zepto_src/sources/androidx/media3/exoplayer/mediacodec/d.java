package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements MediaCodecUtil.ScoreProvider, MediaCodecSelector {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7358b;

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
    public int a(Object obj) {
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        switch (this.f7358b) {
            case 0:
                Pattern pattern = MediaCodecUtil.f7340a;
                String str = mediaCodecInfo.f7320a;
                if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                    return 1;
                }
                return (Util.f5744a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
            default:
                Pattern pattern2 = MediaCodecUtil.f7340a;
                return mediaCodecInfo.f7320a.startsWith("OMX.google") ? 1 : 0;
        }
    }
}
