package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public interface HlsPlaylistTracker {

    public interface Factory {
    }

    public interface PlaylistEventListener {
        boolean a(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z);

        void c();
    }

    public static final class PlaylistResetException extends IOException {
    }

    public static final class PlaylistStuckException extends IOException {
    }

    public interface PrimaryPlaylistListener {
    }
}
