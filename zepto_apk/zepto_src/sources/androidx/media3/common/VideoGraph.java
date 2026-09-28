package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface VideoGraph {

    @UnstableApi
    public interface Listener {
    }

    void b();

    VideoFrameProcessor c();

    void d();

    void release();
}
