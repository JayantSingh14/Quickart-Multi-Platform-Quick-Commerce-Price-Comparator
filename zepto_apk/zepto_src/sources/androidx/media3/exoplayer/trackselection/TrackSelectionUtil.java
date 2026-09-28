package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;

@UnstableApi
/* loaded from: classes3.dex */
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
    }

    public static LoadErrorHandlingPolicy.FallbackOptions a(ExoTrackSelection exoTrackSelection) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.b(i3, jElapsedRealtime)) {
                i2++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i2);
    }
}
