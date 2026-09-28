package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class TimelineWithUpdatedMediaItem extends ForwardingTimeline {

    /* renamed from: f, reason: collision with root package name */
    public final MediaItem f7768f;

    public TimelineWithUpdatedMediaItem(Timeline timeline, MediaItem mediaItem) {
        super(timeline);
        this.f7768f = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
    public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
        super.m(i2, window, j2);
        MediaItem mediaItem = this.f7768f;
        window.f5488c = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        window.f5487b = null;
        return window;
    }
}
