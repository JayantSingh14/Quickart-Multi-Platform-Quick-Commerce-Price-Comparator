package androidx.media3.exoplayer.analytics;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {

    public interface Callback {
    }

    public static final class PlaybackStatsTracker {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void N(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void O(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void P(Player player, AnalyticsListener.Events events) {
        FlagSet flagSet = events.f6379a;
        if (flagSet.f5210a.size() == 0) {
            return;
        }
        if (flagSet.f5210a.size() <= 0) {
            throw null;
        }
        int iB = flagSet.b(0);
        events.b(iB);
        if (iB != 0 && iB != 11) {
            throw null;
        }
        throw null;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void n(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener.EventTime eventTime) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void r(AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void I(AnalyticsListener.EventTime eventTime, int i2) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void H(int i2, long j2, AnalyticsListener.EventTime eventTime) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void o(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, IOException iOException) {
    }
}
