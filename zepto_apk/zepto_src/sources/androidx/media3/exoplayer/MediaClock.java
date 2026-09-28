package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface MediaClock {
    void D(PlaybackParameters playbackParameters);

    PlaybackParameters F();

    default boolean n() {
        return false;
    }

    long w();
}
