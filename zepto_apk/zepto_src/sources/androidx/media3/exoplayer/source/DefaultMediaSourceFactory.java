package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.SingleSampleMediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleExtractor;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    public static final /* synthetic */ int o = 0;

    /* renamed from: c, reason: collision with root package name */
    public final DelegateFactoryLoader f7541c;

    /* renamed from: d, reason: collision with root package name */
    public DataSource.Factory f7542d;

    /* renamed from: e, reason: collision with root package name */
    public DefaultSubtitleParserFactory f7543e;

    /* renamed from: f, reason: collision with root package name */
    public AdsLoader.Provider f7544f;

    /* renamed from: g, reason: collision with root package name */
    public AdViewProvider f7545g;

    /* renamed from: h, reason: collision with root package name */
    public LoadErrorHandlingPolicy f7546h;

    /* renamed from: i, reason: collision with root package name */
    public final long f7547i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7548j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7549k;

    /* renamed from: l, reason: collision with root package name */
    public final float f7550l;

    /* renamed from: m, reason: collision with root package name */
    public final float f7551m;
    public boolean n;

    @UnstableApi
    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public static final class DelegateFactoryLoader {

        /* renamed from: a, reason: collision with root package name */
        public final DefaultExtractorsFactory f7552a;

        /* renamed from: d, reason: collision with root package name */
        public DataSource.Factory f7555d;

        /* renamed from: f, reason: collision with root package name */
        public DefaultSubtitleParserFactory f7557f;

        /* renamed from: g, reason: collision with root package name */
        public com.brentvatne.exoplayer.a f7558g;

        /* renamed from: h, reason: collision with root package name */
        public DrmSessionManagerProvider f7559h;

        /* renamed from: i, reason: collision with root package name */
        public LoadErrorHandlingPolicy f7560i;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f7553b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f7554c = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public boolean f7556e = true;

        public DelegateFactoryLoader(DefaultExtractorsFactory defaultExtractorsFactory, DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
            this.f7552a = defaultExtractorsFactory;
            this.f7557f = defaultSubtitleParserFactory;
        }

        public final MediaSource.Factory a(int i2) {
            HashMap map = this.f7554c;
            MediaSource.Factory factory = (MediaSource.Factory) map.get(Integer.valueOf(i2));
            if (factory != null) {
                return factory;
            }
            MediaSource.Factory factory2 = (MediaSource.Factory) b(i2).get();
            com.brentvatne.exoplayer.a aVar = this.f7558g;
            if (aVar != null) {
                factory2.e(aVar);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.f7559h;
            if (drmSessionManagerProvider != null) {
                factory2.b(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7560i;
            if (loadErrorHandlingPolicy != null) {
                factory2.c(loadErrorHandlingPolicy);
            }
            factory2.f(this.f7557f);
            factory2.d(this.f7556e);
            map.put(Integer.valueOf(i2), factory2);
            return factory2;
        }

        public final Supplier b(int i2) {
            Supplier supplier;
            final int i3 = 3;
            final int i4 = 2;
            final int i5 = 1;
            HashMap map = this.f7553b;
            Supplier supplier2 = (Supplier) map.get(Integer.valueOf(i2));
            if (supplier2 != null) {
                return supplier2;
            }
            final DataSource.Factory factory = this.f7555d;
            factory.getClass();
            if (i2 == 0) {
                int i6 = DashMediaSource.Factory.f6715k;
                final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                final int i7 = 0;
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.d
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        switch (i7) {
                            case 0:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass, factory);
                            case 1:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass, factory);
                            case 2:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass, factory);
                            default:
                                DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader = (DefaultMediaSourceFactory.DelegateFactoryLoader) clsAsSubclass;
                                delegateFactoryLoader.getClass();
                                return new ProgressiveMediaSource.Factory(factory, delegateFactoryLoader.f7552a);
                        }
                    }
                };
            } else if (i2 == 1) {
                int i8 = SsMediaSource.Factory.f7436j;
                final Class clsAsSubclass2 = SsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.d
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        switch (i5) {
                            case 0:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass2, factory);
                            case 1:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass2, factory);
                            case 2:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass2, factory);
                            default:
                                DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader = (DefaultMediaSourceFactory.DelegateFactoryLoader) clsAsSubclass2;
                                delegateFactoryLoader.getClass();
                                return new ProgressiveMediaSource.Factory(factory, delegateFactoryLoader.f7552a);
                        }
                    }
                };
            } else if (i2 == 2) {
                int i9 = HlsMediaSource.Factory.n;
                final Class clsAsSubclass3 = HlsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.d
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        switch (i4) {
                            case 0:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass3, factory);
                            case 1:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass3, factory);
                            case 2:
                                return DefaultMediaSourceFactory.g((Class) clsAsSubclass3, factory);
                            default:
                                DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader = (DefaultMediaSourceFactory.DelegateFactoryLoader) clsAsSubclass3;
                                delegateFactoryLoader.getClass();
                                return new ProgressiveMediaSource.Factory(factory, delegateFactoryLoader.f7552a);
                        }
                    }
                };
            } else if (i2 == 3) {
                int i10 = RtspMediaSource.Factory.f7395c;
                final Class clsAsSubclass4 = RtspMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.e
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        Class cls = clsAsSubclass4;
                        int i11 = DefaultMediaSourceFactory.o;
                        try {
                            return (MediaSource.Factory) cls.getConstructor(null).newInstance(null);
                        } catch (Exception e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                };
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unrecognized contentType: "));
                }
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.d
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        switch (i3) {
                            case 0:
                                return DefaultMediaSourceFactory.g((Class) this, factory);
                            case 1:
                                return DefaultMediaSourceFactory.g((Class) this, factory);
                            case 2:
                                return DefaultMediaSourceFactory.g((Class) this, factory);
                            default:
                                DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader = (DefaultMediaSourceFactory.DelegateFactoryLoader) this;
                                delegateFactoryLoader.getClass();
                                return new ProgressiveMediaSource.Factory(factory, delegateFactoryLoader.f7552a);
                        }
                    }
                };
            }
            map.put(Integer.valueOf(i2), supplier);
            return supplier;
        }
    }

    public static final class UnknownSubtitlesExtractor implements Extractor {

        /* renamed from: a, reason: collision with root package name */
        public final Format f7561a;

        public UnknownSubtitlesExtractor(Format format) {
            this.f7561a = format;
        }

        @Override // androidx.media3.extractor.Extractor
        public final void a(long j2, long j3) {
        }

        @Override // androidx.media3.extractor.Extractor
        public final void c(ExtractorOutput extractorOutput) {
            TrackOutput trackOutputN = extractorOutput.n(0, 3);
            extractorOutput.c(new SeekMap.Unseekable(-9223372036854775807L));
            extractorOutput.m();
            Format format = this.f7561a;
            Format.Builder builderA = format.a();
            builderA.f5237l = MimeTypes.p("text/x-unknown");
            builderA.f5234i = format.f5225m;
            android.support.v4.media.a.s(builderA, trackOutputN);
        }

        @Override // androidx.media3.extractor.Extractor
        public final boolean h(ExtractorInput extractorInput) {
            return true;
        }

        @Override // androidx.media3.extractor.Extractor
        public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
            return ((DefaultExtractorInput) extractorInput).p(Api.BaseClientBuilder.API_PRIORITY_OTHER) == -1 ? -1 : 0;
        }

        @Override // androidx.media3.extractor.Extractor
        public final void release() {
        }
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public static MediaSource.Factory g(Class cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final MediaSource a(MediaItem mediaItem) {
        MediaItem mediaItemA = mediaItem;
        mediaItemA.f5258b.getClass();
        String scheme = mediaItemA.f5258b.f5339a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            throw null;
        }
        if (Objects.equals(mediaItemA.f5258b.f5340b, "application/x-image-uri")) {
            long j2 = mediaItemA.f5258b.f5346h;
            int i2 = Util.f5744a;
            throw null;
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItemA.f5258b;
        int iM = Util.M(localConfiguration.f5339a, localConfiguration.f5340b);
        if (mediaItemA.f5258b.f5346h != -9223372036854775807L) {
            DefaultExtractorsFactory defaultExtractorsFactory = this.f7541c.f7552a;
            synchronized (defaultExtractorsFactory) {
                defaultExtractorsFactory.f8529d = 1;
            }
        }
        try {
            MediaSource.Factory factoryA = this.f7541c.a(iM);
            MediaItem.LiveConfiguration.Builder builderA = mediaItemA.f5259c.a();
            MediaItem.LiveConfiguration liveConfiguration = mediaItemA.f5259c;
            if (liveConfiguration.f5324a == -9223372036854775807L) {
                builderA.f5329a = this.f7547i;
            }
            if (liveConfiguration.f5327d == -3.4028235E38f) {
                builderA.f5332d = this.f7550l;
            }
            if (liveConfiguration.f5328e == -3.4028235E38f) {
                builderA.f5333e = this.f7551m;
            }
            if (liveConfiguration.f5325b == -9223372036854775807L) {
                builderA.f5330b = this.f7548j;
            }
            if (liveConfiguration.f5326c == -9223372036854775807L) {
                builderA.f5331c = this.f7549k;
            }
            MediaItem.LiveConfiguration liveConfiguration2 = new MediaItem.LiveConfiguration(builderA);
            if (!liveConfiguration2.equals(mediaItemA.f5259c)) {
                MediaItem.Builder builderA2 = mediaItemA.a();
                builderA2.f5277l = liveConfiguration2.a();
                mediaItemA = builderA2.a();
            }
            MediaSource mediaSourceA = factoryA.a(mediaItemA);
            ImmutableList immutableList = mediaItemA.f5258b.f5345g;
            if (!immutableList.isEmpty()) {
                MediaSource[] mediaSourceArr = new MediaSource[immutableList.size() + 1];
                mediaSourceArr[0] = mediaSourceA;
                for (int i3 = 0; i3 < immutableList.size(); i3++) {
                    if (this.n) {
                        Format.Builder builder = new Format.Builder();
                        builder.f5237l = MimeTypes.p(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5364b);
                        builder.f5229d = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5365c;
                        builder.f5230e = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5366d;
                        builder.f5231f = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5367e;
                        builder.f5227b = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5368f;
                        builder.f5226a = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5369g;
                        final Format format = new Format(builder);
                        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.f7542d, new ExtractorsFactory() { // from class: androidx.media3.exoplayer.source.c
                            @Override // androidx.media3.extractor.ExtractorsFactory
                            public final Extractor[] g() {
                                DefaultMediaSourceFactory defaultMediaSourceFactory = this.f7826a;
                                DefaultSubtitleParserFactory defaultSubtitleParserFactory = defaultMediaSourceFactory.f7543e;
                                Format format2 = format;
                                return new Extractor[]{defaultSubtitleParserFactory.b(format2) ? new SubtitleExtractor(defaultMediaSourceFactory.f7543e.c(format2), format2) : new DefaultMediaSourceFactory.UnknownSubtitlesExtractor(format2)};
                            }
                        });
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7546h;
                        if (loadErrorHandlingPolicy != null) {
                            factory.f7679f = loadErrorHandlingPolicy;
                        }
                        int i4 = i3 + 1;
                        String string = ((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f5363a.toString();
                        MediaItem.Builder builder2 = new MediaItem.Builder();
                        builder2.f5267b = string == null ? null : Uri.parse(string);
                        MediaItem mediaItemA2 = builder2.a();
                        mediaItemA2.f5258b.getClass();
                        mediaSourceArr[i4] = new ProgressiveMediaSource(mediaItemA2, factory.f7676c, factory.f7677d, factory.f7678e.a(mediaItemA2), factory.f7679f, factory.f7680g);
                    } else {
                        DataSource.Factory factory2 = this.f7542d;
                        SingleSampleMediaSource.Factory factory3 = new SingleSampleMediaSource.Factory(factory2);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f7546h;
                        if (loadErrorHandlingPolicy2 != null) {
                            factory3.f7758b = loadErrorHandlingPolicy2;
                        }
                        mediaSourceArr[i3 + 1] = new SingleSampleMediaSource((MediaItem.SubtitleConfiguration) immutableList.get(i3), factory2, factory3.f7758b, factory3.f7759c);
                    }
                }
                mediaSourceA = new MergingMediaSource(mediaSourceArr);
            }
            MediaSource mediaSource = mediaSourceA;
            MediaItem.ClippingProperties clippingProperties = mediaItemA.f5261e;
            long j3 = clippingProperties.f5286b;
            MediaSource clippingMediaSource = (j3 == 0 && clippingProperties.f5288d == Long.MIN_VALUE && !clippingProperties.f5290f) ? mediaSource : new ClippingMediaSource(mediaSource, j3, clippingProperties.f5288d, !clippingProperties.f5291g, clippingProperties.f5289e, clippingProperties.f5290f);
            mediaItemA.f5258b.getClass();
            MediaItem.LocalConfiguration localConfiguration2 = mediaItemA.f5258b;
            MediaItem.AdsConfiguration adsConfiguration = localConfiguration2.f5342d;
            if (adsConfiguration == null) {
                return clippingMediaSource;
            }
            AdsLoader.Provider provider = this.f7544f;
            AdViewProvider adViewProvider = this.f7545g;
            if (provider == null || adViewProvider == null) {
                Log.h("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
                return clippingMediaSource;
            }
            ImaAdsLoader imaAdsLoaderA = provider.a();
            if (imaAdsLoaderA == null) {
                Log.h("DMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
                return clippingMediaSource;
            }
            Uri uri = adsConfiguration.f5264a;
            DataSpec dataSpec = new DataSpec(uri);
            String str = mediaItemA.f5257a;
            Uri uri2 = localConfiguration2.f5339a;
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            Object[] objArr = {str, uri2, uri};
            ObjectArrays.a(3, objArr);
            return new AdsMediaSource(clippingMediaSource, dataSpec, ImmutableList.m(3, objArr), this, imaAdsLoaderA, adViewProvider);
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
        Assertions.e(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.f7559h = drmSessionManagerProvider;
        Iterator it = delegateFactoryLoader.f7554c.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).b(drmSessionManagerProvider);
        }
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        Assertions.e(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f7546h = loadErrorHandlingPolicy;
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.f7560i = loadErrorHandlingPolicy;
        Iterator it = delegateFactoryLoader.f7554c.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).c(loadErrorHandlingPolicy);
        }
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final void d(boolean z) {
        this.n = z;
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.f7556e = z;
        DefaultExtractorsFactory defaultExtractorsFactory = delegateFactoryLoader.f7552a;
        synchronized (defaultExtractorsFactory) {
            defaultExtractorsFactory.f8527b = z;
        }
        Iterator it = delegateFactoryLoader.f7554c.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).d(z);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final MediaSource.Factory e(com.brentvatne.exoplayer.a aVar) {
        aVar.getClass();
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.f7558g = aVar;
        Iterator it = delegateFactoryLoader.f7554c.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).e(aVar);
        }
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public final void f(DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
        this.f7543e = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.f7557f = defaultSubtitleParserFactory;
        DefaultExtractorsFactory defaultExtractorsFactory = delegateFactoryLoader.f7552a;
        synchronized (defaultExtractorsFactory) {
            defaultExtractorsFactory.f8528c = defaultSubtitleParserFactory;
        }
        Iterator it = delegateFactoryLoader.f7554c.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).f(defaultSubtitleParserFactory);
        }
    }

    public final int[] h() {
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        delegateFactoryLoader.getClass();
        try {
            delegateFactoryLoader.b(0);
        } catch (ClassNotFoundException unused) {
        }
        try {
            delegateFactoryLoader.b(1);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            delegateFactoryLoader.b(2);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            delegateFactoryLoader.b(3);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            delegateFactoryLoader.b(4);
        } catch (ClassNotFoundException unused5) {
        }
        return Ints.g(delegateFactoryLoader.f7553b.keySet());
    }

    public final void i(DataSource.Factory factory) {
        this.f7542d = factory;
        DelegateFactoryLoader delegateFactoryLoader = this.f7541c;
        if (factory != delegateFactoryLoader.f7555d) {
            delegateFactoryLoader.f7555d = factory;
            delegateFactoryLoader.f7553b.clear();
            delegateFactoryLoader.f7554c.clear();
        }
    }

    public final void j(AdsLoader.Provider provider, AdViewProvider adViewProvider) {
        this.f7544f = provider;
        adViewProvider.getClass();
        this.f7545g = adViewProvider;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, DefaultExtractorsFactory defaultExtractorsFactory) {
        this.f7542d = factory;
        DefaultSubtitleParserFactory defaultSubtitleParserFactory = new DefaultSubtitleParserFactory();
        this.f7543e = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(defaultExtractorsFactory, defaultSubtitleParserFactory);
        this.f7541c = delegateFactoryLoader;
        if (factory != delegateFactoryLoader.f7555d) {
            delegateFactoryLoader.f7555d = factory;
            delegateFactoryLoader.f7553b.clear();
            delegateFactoryLoader.f7554c.clear();
        }
        this.f7547i = -9223372036854775807L;
        this.f7548j = -9223372036854775807L;
        this.f7549k = -9223372036854775807L;
        this.f7550l = -3.4028235E38f;
        this.f7551m = -3.4028235E38f;
        this.n = true;
    }
}
