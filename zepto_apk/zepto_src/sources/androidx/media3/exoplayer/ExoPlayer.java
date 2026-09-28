package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.extractor.DefaultExtractorsFactory;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public interface ExoPlayer extends Player {

    @UnstableApi
    @Deprecated
    public interface AudioComponent {
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f6183a;

        /* renamed from: b, reason: collision with root package name */
        public final SystemClock f6184b;

        /* renamed from: c, reason: collision with root package name */
        public final o f6185c;

        /* renamed from: d, reason: collision with root package name */
        public Supplier f6186d;

        /* renamed from: e, reason: collision with root package name */
        public Supplier f6187e;

        /* renamed from: f, reason: collision with root package name */
        public Supplier f6188f;

        /* renamed from: g, reason: collision with root package name */
        public Supplier f6189g;

        /* renamed from: h, reason: collision with root package name */
        public final Looper f6190h;

        /* renamed from: i, reason: collision with root package name */
        public final int f6191i;

        /* renamed from: j, reason: collision with root package name */
        public final AudioAttributes f6192j;

        /* renamed from: k, reason: collision with root package name */
        public final int f6193k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f6194l;

        /* renamed from: m, reason: collision with root package name */
        public final SeekParameters f6195m;
        public final long n;
        public final long o;
        public final long p;
        public final DefaultLivePlaybackSpeedControl q;
        public final long r;
        public final long s;
        public final boolean t;
        public boolean u;
        public final String v;

        public Builder(final Context context, DefaultRenderersFactory defaultRenderersFactory) {
            final int i2 = 1;
            o oVar = new o(defaultRenderersFactory, 5);
            final int i3 = 0;
            Supplier supplier = new Supplier() { // from class: androidx.media3.exoplayer.b
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    DefaultBandwidthMeter defaultBandwidthMeter;
                    switch (i3) {
                        case 0:
                            return new DefaultMediaSourceFactory(new DefaultDataSource.Factory(context), new DefaultExtractorsFactory());
                        case 1:
                            return new DefaultTrackSelector(context, new AdaptiveTrackSelection.Factory());
                        default:
                            Context context2 = context;
                            ImmutableList immutableList = DefaultBandwidthMeter.n;
                            synchronized (DefaultBandwidthMeter.class) {
                                try {
                                    if (DefaultBandwidthMeter.t == null) {
                                        DefaultBandwidthMeter.Builder builder = new DefaultBandwidthMeter.Builder(context2);
                                        DefaultBandwidthMeter.t = new DefaultBandwidthMeter(builder.f8150a, builder.f8151b, builder.f8152c, builder.f8153d, builder.f8154e);
                                    }
                                    defaultBandwidthMeter = DefaultBandwidthMeter.t;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return defaultBandwidthMeter;
                    }
                }
            };
            Supplier supplier2 = new Supplier() { // from class: androidx.media3.exoplayer.b
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    DefaultBandwidthMeter defaultBandwidthMeter;
                    switch (i2) {
                        case 0:
                            return new DefaultMediaSourceFactory(new DefaultDataSource.Factory(context), new DefaultExtractorsFactory());
                        case 1:
                            return new DefaultTrackSelector(context, new AdaptiveTrackSelection.Factory());
                        default:
                            Context context2 = context;
                            ImmutableList immutableList = DefaultBandwidthMeter.n;
                            synchronized (DefaultBandwidthMeter.class) {
                                try {
                                    if (DefaultBandwidthMeter.t == null) {
                                        DefaultBandwidthMeter.Builder builder = new DefaultBandwidthMeter.Builder(context2);
                                        DefaultBandwidthMeter.t = new DefaultBandwidthMeter(builder.f8150a, builder.f8151b, builder.f8152c, builder.f8153d, builder.f8154e);
                                    }
                                    defaultBandwidthMeter = DefaultBandwidthMeter.t;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return defaultBandwidthMeter;
                    }
                }
            };
            c cVar = new c();
            final int i4 = 2;
            Supplier supplier3 = new Supplier() { // from class: androidx.media3.exoplayer.b
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    DefaultBandwidthMeter defaultBandwidthMeter;
                    switch (i4) {
                        case 0:
                            return new DefaultMediaSourceFactory(new DefaultDataSource.Factory(context), new DefaultExtractorsFactory());
                        case 1:
                            return new DefaultTrackSelector(context, new AdaptiveTrackSelection.Factory());
                        default:
                            Context context2 = context;
                            ImmutableList immutableList = DefaultBandwidthMeter.n;
                            synchronized (DefaultBandwidthMeter.class) {
                                try {
                                    if (DefaultBandwidthMeter.t == null) {
                                        DefaultBandwidthMeter.Builder builder = new DefaultBandwidthMeter.Builder(context2);
                                        DefaultBandwidthMeter.t = new DefaultBandwidthMeter(builder.f8150a, builder.f8151b, builder.f8152c, builder.f8153d, builder.f8154e);
                                    }
                                    defaultBandwidthMeter = DefaultBandwidthMeter.t;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return defaultBandwidthMeter;
                    }
                }
            };
            context.getClass();
            this.f6183a = context;
            this.f6185c = oVar;
            this.f6186d = supplier;
            this.f6187e = supplier2;
            this.f6188f = cVar;
            this.f6189g = supplier3;
            int i5 = Util.f5744a;
            Looper looperMyLooper = Looper.myLooper();
            this.f6190h = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
            this.f6192j = AudioAttributes.f5143g;
            this.f6193k = 1;
            this.f6194l = true;
            this.f6195m = SeekParameters.f6359c;
            this.n = 5000L;
            this.o = 15000L;
            this.p = 3000L;
            DefaultLivePlaybackSpeedControl.Builder builder = new DefaultLivePlaybackSpeedControl.Builder();
            this.q = new DefaultLivePlaybackSpeedControl(builder.f6155a, builder.f6156b, builder.f6157c);
            this.f6184b = Clock.f5662a;
            this.r = 500L;
            this.s = 2000L;
            this.t = true;
            this.v = "";
            this.f6191i = -1000;
        }

        public final ExoPlayer a() {
            Assertions.g(!this.u);
            this.u = true;
            return new ExoPlayerImpl(this);
        }

        public final void b(BandwidthMeter bandwidthMeter) {
            Assertions.g(!this.u);
            bandwidthMeter.getClass();
            this.f6189g = new o(bandwidthMeter, 2);
        }

        public final void c(LoadControl loadControl) {
            Assertions.g(!this.u);
            this.f6188f = new o(loadControl, 1);
        }

        public final void d(DefaultMediaSourceFactory defaultMediaSourceFactory) {
            Assertions.g(!this.u);
            this.f6186d = new o(defaultMediaSourceFactory, 4);
        }

        public final void e(TrackSelector trackSelector) {
            Assertions.g(!this.u);
            trackSelector.getClass();
            this.f6187e = new o(trackSelector, 3);
        }
    }

    @UnstableApi
    @Deprecated
    public interface DeviceComponent {
    }

    @UnstableApi
    public static class PreloadConfiguration {

        /* renamed from: a, reason: collision with root package name */
        public static final PreloadConfiguration f6196a = new PreloadConfiguration();
    }

    @UnstableApi
    @Deprecated
    public interface TextComponent {
    }

    @UnstableApi
    @Deprecated
    public interface VideoComponent {
    }

    @Override // androidx.media3.common.Player
    ExoPlaybackException a();

    void c(MediaSource mediaSource, boolean z);

    void d(MediaSource mediaSource, long j2);

    void e(AnalyticsListener analyticsListener);

    Format f();

    TrackSelectionArray g();

    int h(int i2);

    int i();

    void j(EventLogger eventLogger);

    void release();

    @UnstableApi
    void setImageOutput(@Nullable ImageOutput imageOutput);

    @UnstableApi
    public interface AudioOffloadListener {
        default void z() {
        }
    }
}
