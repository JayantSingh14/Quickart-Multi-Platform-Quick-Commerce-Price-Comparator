package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.Comparator;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f7360a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Pattern pattern = MediaCodecUtil.f7340a;
        MediaCodecUtil.ScoreProvider scoreProvider = this.f7360a;
        return scoreProvider.a(obj2) - scoreProvider.a(obj);
    }
}
