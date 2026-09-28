package androidx.media3.exoplayer.source.mediaparser;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.SurfaceControl;
import com.brentvatne.exoplayer.VideoPlaybackService;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ MediaSession j(VideoPlaybackService videoPlaybackService, String str, Bundle bundle) {
        return new MediaSession(videoPlaybackService, str, bundle);
    }

    public static /* synthetic */ SurfaceControl.Transaction m() {
        return new SurfaceControl.Transaction();
    }
}
