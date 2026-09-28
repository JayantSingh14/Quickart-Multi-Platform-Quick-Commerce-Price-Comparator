package androidx.media3.exoplayer.ima;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.ServerSideAdInsertionMediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class ImaServerSideAdInsertionMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: k, reason: collision with root package name */
    public ServerSideAdInsertionMediaSource f7237k;

    /* renamed from: l, reason: collision with root package name */
    public IOException f7238l;

    /* renamed from: m, reason: collision with root package name */
    public MediaItem f7239m;

    /* renamed from: androidx.media3.exoplayer.ima.ImaServerSideAdInsertionMediaSource$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7242a;

        static {
            int[] iArr = new int[AdEvent.AdEventType.values().length];
            f7242a = iArr;
            try {
                iArr[AdEvent.AdEventType.CUEPOINTS_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7242a[AdEvent.AdEventType.LOADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7242a[AdEvent.AdEventType.SKIPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class AdsLoader {

        public static final class Builder {
        }

        public static final class MediaSourceResourceHolder {
        }

        public static class State {
            static {
                int i2 = Util.f5744a;
                Integer.toString(1, 36);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof State)) {
                    return false;
                }
                ((State) obj).getClass();
                throw null;
            }

            public final int hashCode() {
                throw null;
            }
        }
    }

    public final class ComponentListener implements AdEvent.AdEventListener, Player.Listener, ServerSideAdInsertionMediaSource.AdPlaybackStateUpdater {
        @Override // androidx.media3.common.Player.Listener
        public final void f1(Metadata metadata) {
            throw null;
        }

        @Override // androidx.media3.common.Player.Listener
        public final void i1(int i2) {
            if (i2 == 4) {
                throw null;
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public final void onAdEvent(AdEvent adEvent) {
            throw null;
        }

        @Override // androidx.media3.common.Player.Listener
        public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
            throw null;
        }

        @Override // androidx.media3.common.Player.Listener
        public final void z1(float f2) {
            throw null;
        }
    }

    public static final class Factory implements MediaSource.Factory {
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            mediaItem.f5258b.getClass();
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            throw null;
        }
    }

    public class MultiPeriodLiveAdEventListener implements AdEvent.AdEventListener {
        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public final void onAdEvent(AdEvent adEvent) {
            if (Objects.equals(adEvent.getType(), AdEvent.AdEventType.LOADED)) {
                adEvent.getAd().getAdPodInfo();
                throw null;
            }
        }
    }

    public class SinglePeriodLiveAdEventListener implements AdEvent.AdEventListener {
        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public final void onAdEvent(AdEvent adEvent) {
            if (Objects.equals(adEvent.getType(), AdEvent.AdEventType.LOADED)) {
                throw null;
            }
        }
    }

    @UnstableApi
    public interface StreamEventListener {
    }

    public static class StreamManagerLoadable implements Loader.Loadable, AdsLoader.AdsLoadedListener, AdErrorEvent.AdErrorListener {
        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Throwable -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ima.ImaServerSideAdInsertionMediaSource.StreamManagerLoadable.a():void");
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void b() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
        public final void onAdError(AdErrorEvent adErrorEvent) {
            if (adErrorEvent.getError() != null) {
                String message = adErrorEvent.getError().getMessage();
                if (message != null) {
                    message.replace('\n', ' ');
                }
                adErrorEvent.getError().getErrorCodeNumber();
            }
            throw null;
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener
        public final void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent) {
            adsManagerLoadedEvent.getStreamManager().getClass();
            throw null;
        }
    }

    public final class StreamManagerLoadableCallback implements Loader.Callback<StreamManagerLoadable> {
        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void a0(Loader.Loadable loadable, long j2, long j3) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
            Assertions.g(z);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            throw null;
        }
    }

    public static final class StreamPlayer implements VideoStreamPlayer {

        public interface StreamLoadListener {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void addCallback(VideoStreamPlayer.VideoStreamPlayerCallback videoStreamPlayerCallback) {
            throw null;
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider
        public final VideoProgressUpdate getContentProgress() {
            throw null;
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VolumeProvider
        public final int getVolume() {
            throw null;
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void loadUrl(String str, List list) {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void onAdBreakEnded() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void onAdBreakStarted() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void onAdPeriodEnded() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void onAdPeriodStarted() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void pause() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void removeCallback(VideoStreamPlayer.VideoStreamPlayerCallback videoStreamPlayerCallback) {
            throw null;
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void resume() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer
        public final void seek(long j2) {
        }
    }

    public class VodAdEventListener implements AdEvent.AdEventListener {
        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public final void onAdEvent(AdEvent adEvent) {
            throw null;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource = this.f7237k;
        serverSideAdInsertionMediaSource.getClass();
        return serverSideAdInsertionMediaSource.C(mediaPeriodId, allocator, j2);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.f7239m;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource = this.f7237k;
        serverSideAdInsertionMediaSource.getClass();
        serverSideAdInsertionMediaSource.J(mediaPeriod);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.f7239m = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void V() throws IOException {
        super.V();
        IOException iOException = this.f7238l;
        if (iOException == null) {
            return;
        }
        this.f7238l = null;
        throw iOException;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem mediaItemD = D();
        MediaItem.LocalConfiguration localConfiguration = mediaItemD.f5258b;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return localConfiguration2 != null && localConfiguration2.f5339a.equals(localConfiguration.f5339a) && localConfiguration2.f5343e.equals(localConfiguration.f5343e) && Util.a(localConfiguration2.f5344f, localConfiguration.f5344f) && Util.a(localConfiguration2.f5341c, localConfiguration.f5341c) && mediaItemD.f5259c.equals(mediaItem.f5259c);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        super.l0();
        this.f7237k = null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, final Timeline timeline) {
        final MediaItem mediaItemD = D();
        k0(new ForwardingTimeline(timeline) { // from class: androidx.media3.exoplayer.ima.ImaServerSideAdInsertionMediaSource.1
            @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
            public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
                timeline.m(i2, window, j2);
                window.f5488c = mediaItemD;
                return window;
            }
        });
    }
}
