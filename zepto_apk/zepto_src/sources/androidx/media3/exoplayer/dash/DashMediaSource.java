package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.ParserException;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.UtcTimingElement;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.util.SntpClient;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import com.google.common.base.Charsets;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class DashMediaSource extends BaseMediaSource {
    public static final /* synthetic */ int A0 = 0;
    public DataSource A;
    public Loader B;
    public TransferListener C;
    public DashManifestStaleException D;
    public Handler E;
    public MediaItem.LiveConfiguration F;
    public Uri G;
    public final Uri H;
    public DashManifest I;
    public boolean J;
    public long K;
    public long L;
    public long M;
    public int Q;
    public long X;
    public int Y;
    public MediaItem Z;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6698h;

    /* renamed from: i, reason: collision with root package name */
    public final DataSource.Factory f6699i;

    /* renamed from: j, reason: collision with root package name */
    public final DefaultDashChunkSource.Factory f6700j;

    /* renamed from: k, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f6701k;

    /* renamed from: l, reason: collision with root package name */
    public final CmcdConfiguration f6702l;

    /* renamed from: m, reason: collision with root package name */
    public final DrmSessionManager f6703m;
    public final LoadErrorHandlingPolicy n;
    public final BaseUrlExclusionList o;
    public final long p;
    public final long q;
    public final MediaSourceEventListener.EventDispatcher r;
    public final ParsingLoadable.Parser s;
    public final ManifestCallback t;
    public final Object u;
    public final SparseArray v;
    public final c w;
    public final c x;
    public final PlayerEmsgHandler.PlayerEmsgCallback y;
    public final LoaderErrorThrower z;

    public static final class DashTimeline extends Timeline {

        /* renamed from: e, reason: collision with root package name */
        public final long f6705e;

        /* renamed from: f, reason: collision with root package name */
        public final long f6706f;

        /* renamed from: g, reason: collision with root package name */
        public final long f6707g;

        /* renamed from: h, reason: collision with root package name */
        public final int f6708h;

        /* renamed from: i, reason: collision with root package name */
        public final long f6709i;

        /* renamed from: j, reason: collision with root package name */
        public final long f6710j;

        /* renamed from: k, reason: collision with root package name */
        public final long f6711k;

        /* renamed from: l, reason: collision with root package name */
        public final DashManifest f6712l;

        /* renamed from: m, reason: collision with root package name */
        public final MediaItem f6713m;
        public final MediaItem.LiveConfiguration n;

        public DashTimeline(long j2, long j3, long j4, int i2, long j5, long j6, long j7, DashManifest dashManifest, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
            Assertions.g(dashManifest.f6792d == (liveConfiguration != null));
            this.f6705e = j2;
            this.f6706f = j3;
            this.f6707g = j4;
            this.f6708h = i2;
            this.f6709i = j5;
            this.f6710j = j6;
            this.f6711k = j7;
            this.f6712l = dashManifest;
            this.f6713m = mediaItem;
            this.n = liveConfiguration;
        }

        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f6708h) >= 0 && iIntValue < h()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            Assertions.c(i2, h());
            DashManifest dashManifest = this.f6712l;
            String str = z ? dashManifest.b(i2).f6822a : null;
            Integer numValueOf = z ? Integer.valueOf(this.f6708h + i2) : null;
            long jD = dashManifest.d(i2);
            long jT = Util.T(dashManifest.b(i2).f6823b - dashManifest.b(0).f6823b) - this.f6709i;
            period.getClass();
            period.g(str, numValueOf, 0, jD, jT, AdPlaybackState.f5118g, false);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return this.f6712l.f6801m.size();
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            Assertions.c(i2, h());
            return Integer.valueOf(this.f6708h + i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[PHI: r7
          0x0042: PHI (r7v1 long) = (r7v0 long), (r7v3 long) binds: [B:14:0x0031, B:16:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // androidx.media3.common.Timeline
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.media3.common.Timeline.Window m(int r24, androidx.media3.common.Timeline.Window r25, long r26) {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.DashTimeline.m(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 1;
        }
    }

    public final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        public DefaultPlayerEmsgCallback() {
        }
    }

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int f6715k = 0;

        /* renamed from: c, reason: collision with root package name */
        public final DefaultDashChunkSource.Factory f6716c;

        /* renamed from: d, reason: collision with root package name */
        public final DataSource.Factory f6717d;

        /* renamed from: e, reason: collision with root package name */
        public com.brentvatne.exoplayer.a f6718e;

        /* renamed from: f, reason: collision with root package name */
        public DrmSessionManagerProvider f6719f;

        /* renamed from: g, reason: collision with root package name */
        public final DefaultCompositeSequenceableLoaderFactory f6720g;

        /* renamed from: h, reason: collision with root package name */
        public LoadErrorHandlingPolicy f6721h;

        /* renamed from: i, reason: collision with root package name */
        public final long f6722i;

        /* renamed from: j, reason: collision with root package name */
        public final long f6723j;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            mediaItem.f5258b.getClass();
            DashManifestParser dashManifestParser = new DashManifestParser();
            List list = mediaItem.f5258b.f5343e;
            ParsingLoadable.Parser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(dashManifestParser, list) : dashManifestParser;
            com.brentvatne.exoplayer.a aVar = this.f6718e;
            CmcdConfiguration cmcdConfigurationB = aVar == null ? null : ((CmcdConfiguration.Factory) aVar.f15602b).b(mediaItem);
            return new DashMediaSource(mediaItem, this.f6717d, filteringManifestParser, this.f6716c, this.f6720g, cmcdConfigurationB, this.f6719f.a(mediaItem), this.f6721h, this.f6722i, this.f6723j);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            Assertions.e(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f6719f = drmSessionManagerProvider;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.e(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f6721h = loadErrorHandlingPolicy;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void d(boolean z) {
            this.f6716c.f6745c.f7854b = z;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory e(com.brentvatne.exoplayer.a aVar) {
            aVar.getClass();
            this.f6718e = aVar;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void f(DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
            this.f6716c.f6745c.f7853a = defaultSubtitleParserFactory;
        }

        public Factory(DefaultDashChunkSource.Factory factory, DataSource.Factory factory2) {
            this.f6716c = factory;
            this.f6717d = factory2;
            this.f6719f = new DefaultDrmSessionManagerProvider();
            this.f6721h = new DefaultLoadErrorHandlingPolicy();
            this.f6722i = 30000L;
            this.f6723j = 5000000L;
            this.f6720g = new DefaultCompositeSequenceableLoaderFactory();
            factory.f6745c.f7854b = true;
        }
    }

    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {

        /* renamed from: a, reason: collision with root package name */
        public static final Pattern f6724a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
        public final Object a(Uri uri, DataSourceInputStream dataSourceInputStream) throws IOException, NumberFormatException {
            String line = new BufferedReader(new InputStreamReader(dataSourceInputStream, Charsets.f42260c)).readLine();
            try {
                Matcher matcher = f6724a.matcher(line);
                if (!matcher.matches()) {
                    throw ParserException.b("Couldn't parse timestamp: " + line, null);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j2 = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j3 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= (((j3 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * DateUtils.MILLIS_PER_MINUTE) * j2;
                }
                return Long.valueOf(time);
            } catch (ParseException e2) {
                throw ParserException.b(null, e2);
            }
        }
    }

    public final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        public ManifestCallback() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void a0(Loader.Loadable loadable, long j2, long j3) {
            long j4;
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            final DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.getClass();
            long j5 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j5, statsDataSource.f5932d, j3);
            dashMediaSource.n.getClass();
            dashMediaSource.r.e(loadEventInfo, parsingLoadable.f8185c);
            DashManifest dashManifest = (DashManifest) parsingLoadable.f8188f;
            DashManifest dashManifest2 = dashMediaSource.I;
            int size = dashManifest2 == null ? 0 : dashManifest2.f6801m.size();
            long j6 = dashManifest.b(0).f6823b;
            int i2 = 0;
            while (i2 < size && dashMediaSource.I.b(i2).f6823b < j6) {
                i2++;
            }
            if (dashManifest.f6792d) {
                if (size - i2 > dashManifest.f6801m.size()) {
                    Log.h("DashMediaSource", "Loaded out of sync manifest");
                } else {
                    long j7 = dashMediaSource.X;
                    j4 = -9223372036854775807L;
                    if (j7 == -9223372036854775807L || dashManifest.f6796h * 1000 > j7) {
                        dashMediaSource.Q = 0;
                    } else {
                        Log.h("DashMediaSource", "Loaded stale dynamic manifest: " + dashManifest.f6796h + ", " + dashMediaSource.X);
                    }
                }
                int i3 = dashMediaSource.Q;
                dashMediaSource.Q = i3 + 1;
                if (i3 < dashMediaSource.n.b(parsingLoadable.f8185c)) {
                    dashMediaSource.E.postDelayed(dashMediaSource.w, Math.min((dashMediaSource.Q - 1) * 1000, 5000));
                    return;
                } else {
                    dashMediaSource.D = new DashManifestStaleException();
                    return;
                }
            }
            j4 = -9223372036854775807L;
            dashMediaSource.I = dashManifest;
            dashMediaSource.J = dashManifest.f6792d & dashMediaSource.J;
            dashMediaSource.K = j2 - j3;
            dashMediaSource.L = j2;
            dashMediaSource.Y += i2;
            synchronized (dashMediaSource.u) {
                try {
                    if (parsingLoadable.f8184b.f5851a == dashMediaSource.G) {
                        Uri uri2 = dashMediaSource.I.f6799k;
                        if (uri2 == null) {
                            uri2 = parsingLoadable.f8186d.f5931c;
                        }
                        dashMediaSource.G = uri2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            DashManifest dashManifest3 = dashMediaSource.I;
            if (!dashManifest3.f6792d || dashMediaSource.M != j4) {
                dashMediaSource.p0(true);
                return;
            }
            UtcTimingElement utcTimingElement = dashManifest3.f6797i;
            if (utcTimingElement == null) {
                SntpClient.c(dashMediaSource.B, new SntpClient.InitializationCallback() { // from class: androidx.media3.exoplayer.dash.DashMediaSource.1
                    @Override // androidx.media3.exoplayer.util.SntpClient.InitializationCallback
                    public final void a(IOException iOException) {
                        int i4 = DashMediaSource.A0;
                        DashMediaSource.this.o0(iOException);
                    }

                    @Override // androidx.media3.exoplayer.util.SntpClient.InitializationCallback
                    public final void b() {
                        long j8;
                        DashMediaSource dashMediaSource2 = DashMediaSource.this;
                        synchronized (SntpClient.f8215b) {
                            try {
                                j8 = SntpClient.f8216c ? SntpClient.f8217d : -9223372036854775807L;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        int i4 = DashMediaSource.A0;
                        dashMediaSource2.M = j8;
                        dashMediaSource2.p0(true);
                    }
                });
                return;
            }
            String str = utcTimingElement.f6869a;
            if (Util.a(str, "urn:mpeg:dash:utc:direct:2014") || Util.a(str, "urn:mpeg:dash:utc:direct:2012")) {
                try {
                    dashMediaSource.M = Util.W(utcTimingElement.f6870b) - dashMediaSource.L;
                    dashMediaSource.p0(true);
                    return;
                } catch (ParserException e2) {
                    dashMediaSource.o0(e2);
                    return;
                }
            }
            if (Util.a(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.a(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                ParsingLoadable parsingLoadable2 = new ParsingLoadable(dashMediaSource.A, Uri.parse(utcTimingElement.f6870b), 5, new Iso8601Parser());
                dashMediaSource.B.g(parsingLoadable2, dashMediaSource.new UtcTimestampCallback(), 1);
                dashMediaSource.r.k(new LoadEventInfo(parsingLoadable2.f8183a, parsingLoadable2.f8184b), parsingLoadable2.f8185c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
            } else if (Util.a(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.a(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                ParsingLoadable parsingLoadable3 = new ParsingLoadable(dashMediaSource.A, Uri.parse(utcTimingElement.f6870b), 5, new XsDateTimeParser());
                dashMediaSource.B.g(parsingLoadable3, dashMediaSource.new UtcTimestampCallback(), 1);
                dashMediaSource.r.k(new LoadEventInfo(parsingLoadable3.f8183a, parsingLoadable3.f8184b), parsingLoadable3.f8185c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
            } else if (Util.a(str, "urn:mpeg:dash:utc:ntp:2014") || Util.a(str, "urn:mpeg:dash:utc:ntp:2012")) {
                SntpClient.c(dashMediaSource.B, new SntpClient.InitializationCallback() { // from class: androidx.media3.exoplayer.dash.DashMediaSource.1
                    @Override // androidx.media3.exoplayer.util.SntpClient.InitializationCallback
                    public final void a(IOException iOException) {
                        int i4 = DashMediaSource.A0;
                        DashMediaSource.this.o0(iOException);
                    }

                    @Override // androidx.media3.exoplayer.util.SntpClient.InitializationCallback
                    public final void b() {
                        long j8;
                        DashMediaSource dashMediaSource2 = DashMediaSource.this;
                        synchronized (SntpClient.f8215b) {
                            try {
                                j8 = SntpClient.f8216c ? SntpClient.f8217d : -9223372036854775807L;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        int i4 = DashMediaSource.A0;
                        dashMediaSource2.M = j8;
                        dashMediaSource2.p0(true);
                    }
                });
            } else {
                dashMediaSource.o0(new IOException("Unsupported UTC timing scheme"));
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
            DashMediaSource.this.n0((ParsingLoadable) loadable, j3);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.getClass();
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
            long jA = dashMediaSource.n.a(new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2));
            Loader.LoadErrorAction loadErrorAction = jA == -9223372036854775807L ? Loader.f8166f : new Loader.LoadErrorAction(0, jA);
            dashMediaSource.r.i(loadEventInfo, parsingLoadable.f8185c, iOException, !loadErrorAction.a());
            return loadErrorAction;
        }
    }

    public final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        public ManifestLoadErrorThrower() {
        }

        @Override // androidx.media3.exoplayer.upstream.LoaderErrorThrower
        public final void c() throws IOException {
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.B.c();
            DashManifestStaleException dashManifestStaleException = dashMediaSource.D;
            if (dashManifestStaleException != null) {
                throw dashManifestStaleException;
            }
        }
    }

    public final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        public UtcTimestampCallback() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void a0(Loader.Loadable loadable, long j2, long j3) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.getClass();
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
            dashMediaSource.n.getClass();
            dashMediaSource.r.e(loadEventInfo, parsingLoadable.f8185c);
            dashMediaSource.M = ((Long) parsingLoadable.f8188f).longValue() - j2;
            dashMediaSource.p0(true);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
            DashMediaSource.this.n0((ParsingLoadable) loadable, j3);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.getClass();
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            dashMediaSource.r.i(new LoadEventInfo(j4, statsDataSource.f5932d, j3), parsingLoadable.f8185c, iOException, true);
            dashMediaSource.n.getClass();
            dashMediaSource.o0(iOException);
            return Loader.f8165e;
        }
    }

    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
        public final Object a(Uri uri, DataSourceInputStream dataSourceInputStream) {
            return Long.valueOf(Util.W(new BufferedReader(new InputStreamReader(dataSourceInputStream)).readLine()));
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.dash");
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.media3.exoplayer.dash.c] */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.media3.exoplayer.dash.c] */
    public DashMediaSource(MediaItem mediaItem, DataSource.Factory factory, ParsingLoadable.Parser parser, DefaultDashChunkSource.Factory factory2, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2, long j3) {
        this.Z = mediaItem;
        this.F = mediaItem.f5259c;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        localConfiguration.getClass();
        Uri uri = localConfiguration.f5339a;
        this.G = uri;
        this.H = uri;
        this.I = null;
        this.f6699i = factory;
        this.s = parser;
        this.f6700j = factory2;
        this.f6702l = cmcdConfiguration;
        this.f6703m = drmSessionManager;
        this.n = loadErrorHandlingPolicy;
        this.p = j2;
        this.q = j3;
        this.f6701k = defaultCompositeSequenceableLoaderFactory;
        this.o = new BaseUrlExclusionList();
        this.f6698h = false;
        this.r = f0(null);
        this.u = new Object();
        this.v = new SparseArray();
        this.y = new DefaultPlayerEmsgCallback();
        this.X = -9223372036854775807L;
        this.M = -9223372036854775807L;
        this.t = new ManifestCallback();
        this.z = new ManifestLoadErrorThrower();
        final int i2 = 0;
        this.w = new Runnable(this) { // from class: androidx.media3.exoplayer.dash.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DashMediaSource f6778b;

            {
                this.f6778b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource dashMediaSource = this.f6778b;
                switch (i2) {
                    case 0:
                        int i3 = DashMediaSource.A0;
                        dashMediaSource.q0();
                        break;
                    default:
                        int i4 = DashMediaSource.A0;
                        dashMediaSource.p0(false);
                        break;
                }
            }
        };
        final int i3 = 1;
        this.x = new Runnable(this) { // from class: androidx.media3.exoplayer.dash.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DashMediaSource f6778b;

            {
                this.f6778b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource dashMediaSource = this.f6778b;
                switch (i3) {
                    case 0:
                        int i32 = DashMediaSource.A0;
                        dashMediaSource.q0();
                        break;
                    default:
                        int i4 = DashMediaSource.A0;
                        dashMediaSource.p0(false);
                        break;
                }
            }
        };
    }

    public static boolean m0(Period period) {
        int i2 = 0;
        while (true) {
            List list = period.f6824c;
            if (i2 >= list.size()) {
                return false;
            }
            int i3 = ((AdaptationSet) list.get(i2)).f6780b;
            if (i3 == 1 || i3 == 2) {
                break;
            }
            i2++;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int iIntValue = ((Integer) mediaPeriodId.f7609a).intValue() - this.Y;
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher eventDispatcherE0 = e0(mediaPeriodId);
        int i2 = this.Y + iIntValue;
        DashManifest dashManifest = this.I;
        TransferListener transferListener = this.C;
        long j3 = this.M;
        PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback = this.y;
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(i2, dashManifest, this.o, iIntValue, this.f6700j, transferListener, this.f6702l, this.f6703m, eventDispatcherE0, this.n, eventDispatcherF0, j3, this.z, allocator, this.f6701k, playerEmsgCallback, playerId);
        this.v.put(i2, dashMediaPeriod);
        return dashMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.Z;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        PlayerEmsgHandler playerEmsgHandler = dashMediaPeriod.n;
        playerEmsgHandler.f6769i = true;
        playerEmsgHandler.f6764d.removeCallbacksAndMessages(null);
        for (ChunkSampleStream chunkSampleStream : dashMediaPeriod.t) {
            chunkSampleStream.z(dashMediaPeriod);
        }
        dashMediaPeriod.s = null;
        this.v.remove(dashMediaPeriod.f6677a);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.Z = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
        this.z.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem mediaItemD = D();
        MediaItem.LocalConfiguration localConfiguration = mediaItemD.f5258b;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return localConfiguration2 != null && localConfiguration2.f5339a.equals(localConfiguration.f5339a) && localConfiguration2.f5343e.equals(localConfiguration.f5343e) && Util.a(localConfiguration2.f5341c, localConfiguration.f5341c) && mediaItemD.f5259c.equals(mediaItem.f5259c);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        this.C = transferListener;
        Looper looperMyLooper = Looper.myLooper();
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        DrmSessionManager drmSessionManager = this.f6703m;
        drmSessionManager.a(looperMyLooper, playerId);
        drmSessionManager.p();
        if (this.f6698h) {
            p0(false);
            return;
        }
        this.A = this.f6699i.a();
        this.B = new Loader("DashMediaSource");
        this.E = Util.o(null);
        q0();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        this.J = false;
        this.A = null;
        Loader loader = this.B;
        if (loader != null) {
            loader.f(null);
            this.B = null;
        }
        this.K = 0L;
        this.L = 0L;
        this.G = this.H;
        this.D = null;
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        this.M = -9223372036854775807L;
        this.Q = 0;
        this.X = -9223372036854775807L;
        this.v.clear();
        BaseUrlExclusionList baseUrlExclusionList = this.o;
        baseUrlExclusionList.f6673a.clear();
        baseUrlExclusionList.f6674b.clear();
        baseUrlExclusionList.f6675c.clear();
        this.f6703m.release();
    }

    public final void n0(ParsingLoadable parsingLoadable, long j2) {
        long j3 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j3, statsDataSource.f5932d, j2);
        this.n.getClass();
        this.r.c(loadEventInfo, parsingLoadable.f8185c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void o0(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.M = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        p0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0378  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p0(boolean r43) {
        /*
            Method dump skipped, instructions count: 1156
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.p0(boolean):void");
    }

    public final void q0() {
        Uri uri;
        this.E.removeCallbacks(this.w);
        if (this.B.b()) {
            return;
        }
        if (this.B.d()) {
            this.J = true;
            return;
        }
        synchronized (this.u) {
            uri = this.G;
        }
        this.J = false;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.A, uri, 4, this.s);
        this.B.g(parsingLoadable, this.t, this.n.b(4));
        this.r.k(new LoadEventInfo(parsingLoadable.f8183a, parsingLoadable.f8184b), parsingLoadable.f8185c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
