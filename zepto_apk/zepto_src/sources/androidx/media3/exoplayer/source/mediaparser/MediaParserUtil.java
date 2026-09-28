package androidx.media3.exoplayer.source.mediaparser;

import android.media.MediaParser;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaParserUtil {

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static void a(MediaParser mediaParser, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            mediaParser.setLogSessionId(logSessionIdA);
        }
    }

    public static void a(MediaParser mediaParser, PlayerId playerId) {
        Api31.a(mediaParser, playerId);
    }
}
