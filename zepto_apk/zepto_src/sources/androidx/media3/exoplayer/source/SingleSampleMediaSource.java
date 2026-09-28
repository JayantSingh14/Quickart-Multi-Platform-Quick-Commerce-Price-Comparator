package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

@UnstableApi
/* loaded from: classes3.dex */
public final class SingleSampleMediaSource extends BaseMediaSource {

    /* renamed from: h, reason: collision with root package name */
    public final DataSpec f7751h;

    /* renamed from: i, reason: collision with root package name */
    public final DataSource.Factory f7752i;

    /* renamed from: j, reason: collision with root package name */
    public final Format f7753j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7754k = -9223372036854775807L;

    /* renamed from: l, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7755l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7756m;
    public final SinglePeriodTimeline n;
    public final MediaItem o;
    public TransferListener p;

    public static final class Factory {

        /* renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f7757a;

        /* renamed from: b, reason: collision with root package name */
        public LoadErrorHandlingPolicy f7758b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f7759c;

        public Factory(DataSource.Factory factory) {
            factory.getClass();
            this.f7757a = factory;
            this.f7758b = new DefaultLoadErrorHandlingPolicy();
            this.f7759c = true;
        }
    }

    public SingleSampleMediaSource(MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z) {
        this.f7752i = factory;
        this.f7755l = loadErrorHandlingPolicy;
        this.f7756m = z;
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5267b = Uri.EMPTY;
        String string = subtitleConfiguration.f5363a.toString();
        string.getClass();
        builder.f5266a = string;
        builder.f5273h = ImmutableList.o(ImmutableList.t(subtitleConfiguration));
        MediaItem mediaItemA = builder.a();
        this.o = mediaItemA;
        Format.Builder builder2 = new Format.Builder();
        builder2.f5237l = MimeTypes.p((String) MoreObjects.a(subtitleConfiguration.f5364b, "text/x-unknown"));
        builder2.f5229d = subtitleConfiguration.f5365c;
        builder2.f5230e = subtitleConfiguration.f5366d;
        builder2.f5231f = subtitleConfiguration.f5367e;
        builder2.f5227b = subtitleConfiguration.f5368f;
        String str = subtitleConfiguration.f5369g;
        builder2.f5226a = str == null ? null : str;
        this.f7753j = new Format(builder2);
        DataSpec.Builder builder3 = new DataSpec.Builder();
        builder3.f5860a = subtitleConfiguration.f5363a;
        builder3.f5868i = 1;
        this.f7751h = builder3.a();
        this.n = new SinglePeriodTimeline(-9223372036854775807L, true, false, mediaItemA);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        TransferListener transferListener = this.p;
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(mediaPeriodId);
        return new SingleSampleMediaPeriod(this.f7751h, this.f7752i, transferListener, this.f7753j, this.f7754k, this.f7755l, eventDispatcherF0, this.f7756m);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        return this.o;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).f7739i.f(null);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        this.p = transferListener;
        k0(this.n);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
    }
}
