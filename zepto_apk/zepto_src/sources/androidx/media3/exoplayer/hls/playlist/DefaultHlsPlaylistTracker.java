package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.hls.DefaultHlsDataSourceFactory;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final p o = new p(5);

    /* renamed from: a, reason: collision with root package name */
    public final DefaultHlsDataSourceFactory f7093a;

    /* renamed from: b, reason: collision with root package name */
    public final HlsPlaylistParserFactory f7094b;

    /* renamed from: c, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7095c;

    /* renamed from: f, reason: collision with root package name */
    public MediaSourceEventListener.EventDispatcher f7098f;

    /* renamed from: g, reason: collision with root package name */
    public Loader f7099g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f7100h;

    /* renamed from: i, reason: collision with root package name */
    public HlsMediaSource f7101i;

    /* renamed from: j, reason: collision with root package name */
    public HlsMultivariantPlaylist f7102j;

    /* renamed from: k, reason: collision with root package name */
    public Uri f7103k;

    /* renamed from: l, reason: collision with root package name */
    public HlsMediaPlaylist f7104l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7105m;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f7097e = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f7096d = new HashMap();
    public long n = -9223372036854775807L;

    public class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        public FirstPrimaryMediaPlaylistListener() {
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public final boolean a(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
            HashMap map;
            MediaPlaylistBundle mediaPlaylistBundle;
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            if (defaultHlsPlaylistTracker.f7104l == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                HlsMultivariantPlaylist hlsMultivariantPlaylist = defaultHlsPlaylistTracker.f7102j;
                int i2 = Util.f5744a;
                List list = hlsMultivariantPlaylist.f7155e;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int size = list.size();
                    map = defaultHlsPlaylistTracker.f7096d;
                    if (i3 >= size) {
                        break;
                    }
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) map.get(((HlsMultivariantPlaylist.Variant) list.get(i3)).f7167a);
                    if (mediaPlaylistBundle2 != null && jElapsedRealtime < mediaPlaylistBundle2.f7114h) {
                        i4++;
                    }
                    i3++;
                }
                LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionC = defaultHlsPlaylistTracker.f7095c.c(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, defaultHlsPlaylistTracker.f7102j.f7155e.size(), i4), loadErrorInfo);
                if (fallbackSelectionC != null && fallbackSelectionC.f8160a == 2 && (mediaPlaylistBundle = (MediaPlaylistBundle) map.get(uri)) != null) {
                    MediaPlaylistBundle.a(mediaPlaylistBundle, fallbackSelectionC.f8161b);
                }
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public final void c() {
            DefaultHlsPlaylistTracker.this.f7097e.remove(this);
        }
    }

    public final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7107a;

        /* renamed from: b, reason: collision with root package name */
        public final Loader f7108b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c, reason: collision with root package name */
        public final DataSource f7109c;

        /* renamed from: d, reason: collision with root package name */
        public HlsMediaPlaylist f7110d;

        /* renamed from: e, reason: collision with root package name */
        public long f7111e;

        /* renamed from: f, reason: collision with root package name */
        public long f7112f;

        /* renamed from: g, reason: collision with root package name */
        public long f7113g;

        /* renamed from: h, reason: collision with root package name */
        public long f7114h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f7115i;

        /* renamed from: j, reason: collision with root package name */
        public IOException f7116j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f7117k;

        public MediaPlaylistBundle(Uri uri) {
            this.f7107a = uri;
            this.f7109c = DefaultHlsPlaylistTracker.this.f7093a.f6973a.a();
        }

        public static boolean a(MediaPlaylistBundle mediaPlaylistBundle, long j2) {
            mediaPlaylistBundle.f7114h = SystemClock.elapsedRealtime() + j2;
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            if (!mediaPlaylistBundle.f7107a.equals(defaultHlsPlaylistTracker.f7103k)) {
                return false;
            }
            List list = defaultHlsPlaylistTracker.f7102j.f7155e;
            int size = list.size();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) defaultHlsPlaylistTracker.f7096d.get(((HlsMultivariantPlaylist.Variant) list.get(i2)).f7167a);
                mediaPlaylistBundle2.getClass();
                if (jElapsedRealtime > mediaPlaylistBundle2.f7114h) {
                    Uri uri = mediaPlaylistBundle2.f7107a;
                    defaultHlsPlaylistTracker.f7103k = uri;
                    mediaPlaylistBundle2.e(defaultHlsPlaylistTracker.d(uri));
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void a0(Loader.Loadable loadable, long j2, long j3) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            HlsPlaylist hlsPlaylist = (HlsPlaylist) parsingLoadable.f8188f;
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
            if (hlsPlaylist instanceof HlsMediaPlaylist) {
                f((HlsMediaPlaylist) hlsPlaylist, loadEventInfo);
                DefaultHlsPlaylistTracker.this.f7098f.e(loadEventInfo, 4);
            } else {
                ParserException parserExceptionB = ParserException.b("Loaded playlist has unexpected type.", null);
                this.f7116j = parserExceptionB;
                DefaultHlsPlaylistTracker.this.f7098f.i(loadEventInfo, 4, parserExceptionB, true);
            }
            DefaultHlsPlaylistTracker.this.f7095c.getClass();
        }

        public final Uri b() {
            HlsMediaPlaylist hlsMediaPlaylist = this.f7110d;
            Uri uri = this.f7107a;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.v;
                if (serverControl.f7149a != -9223372036854775807L || serverControl.f7153e) {
                    Uri.Builder builderBuildUpon = uri.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.f7110d;
                    if (hlsMediaPlaylist2.v.f7153e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hlsMediaPlaylist2.f7128k + hlsMediaPlaylist2.r.size()));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.f7110d;
                        if (hlsMediaPlaylist3.n != -9223372036854775807L) {
                            ImmutableList immutableList = hlsMediaPlaylist3.s;
                            int size = immutableList.size();
                            if (!immutableList.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.c(immutableList)).f7132m) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.f7110d.v;
                    if (serverControl2.f7149a != -9223372036854775807L) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", serverControl2.f7150b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return uri;
        }

        public final void c(boolean z) {
            e(z ? b() : this.f7107a);
        }

        public final void d(Uri uri) {
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.f7109c, uri, 4, defaultHlsPlaylistTracker.f7094b.b(defaultHlsPlaylistTracker.f7102j, this.f7110d));
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = defaultHlsPlaylistTracker.f7095c;
            int i2 = parsingLoadable.f8185c;
            this.f7108b.g(parsingLoadable, this, loadErrorHandlingPolicy.b(i2));
            defaultHlsPlaylistTracker.f7098f.k(new LoadEventInfo(parsingLoadable.f8183a, parsingLoadable.f8184b), i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            defaultHlsPlaylistTracker.f7095c.getClass();
            defaultHlsPlaylistTracker.f7098f.c(loadEventInfo, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public final void e(final Uri uri) {
            this.f7114h = 0L;
            if (this.f7115i) {
                return;
            }
            Loader loader = this.f7108b;
            if (loader.d() || loader.b()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = this.f7113g;
            if (jElapsedRealtime >= j2) {
                d(uri);
            } else {
                this.f7115i = true;
                DefaultHlsPlaylistTracker.this.f7100h.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.hls.playlist.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle = this.f7192a;
                        mediaPlaylistBundle.f7115i = false;
                        mediaPlaylistBundle.d(uri);
                    }
                }, j2 - jElapsedRealtime);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01b3  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x022d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void f(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r65, androidx.media3.exoplayer.source.LoadEventInfo r66) {
            /*
                Method dump skipped, instructions count: 577
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle.f(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist, androidx.media3.exoplayer.source.LoadEventInfo):void");
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            long j4 = parsingLoadable.f8183a;
            StatsDataSource statsDataSource = parsingLoadable.f8186d;
            Uri uri = statsDataSource.f5931c;
            LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
            boolean z = uri.getQueryParameter("_HLS_msn") != null;
            boolean z2 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            Loader.LoadErrorAction loadErrorAction = Loader.f8165e;
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            int i3 = parsingLoadable.f8185c;
            if (z || z2) {
                int i4 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).f5900d : Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (z2 || i4 == 400 || i4 == 503) {
                    this.f7113g = SystemClock.elapsedRealtime();
                    c(false);
                    MediaSourceEventListener.EventDispatcher eventDispatcher = defaultHlsPlaylistTracker.f7098f;
                    int i5 = Util.f5744a;
                    eventDispatcher.i(loadEventInfo, i3, iOException, true);
                    return loadErrorAction;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2);
            Iterator it = defaultHlsPlaylistTracker.f7097e.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                z3 |= !((HlsPlaylistTracker.PlaylistEventListener) it.next()).a(this.f7107a, loadErrorInfo, false);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = defaultHlsPlaylistTracker.f7095c;
            if (z3) {
                long jA = loadErrorHandlingPolicy.a(loadErrorInfo);
                loadErrorAction = jA != -9223372036854775807L ? new Loader.LoadErrorAction(0, jA) : Loader.f8166f;
            }
            boolean zA = loadErrorAction.a();
            defaultHlsPlaylistTracker.f7098f.i(loadEventInfo, i3, iOException, true ^ zA);
            if (!zA) {
                loadErrorHandlingPolicy.getClass();
            }
            return loadErrorAction;
        }
    }

    public DefaultHlsPlaylistTracker(DefaultHlsDataSourceFactory defaultHlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this.f7093a = defaultHlsDataSourceFactory;
        this.f7094b = hlsPlaylistParserFactory;
        this.f7095c = loadErrorHandlingPolicy;
    }

    public final void a(Uri uri) {
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f7096d.get(uri);
        if (mediaPlaylistBundle != null) {
            mediaPlaylistBundle.f7117k = false;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        HlsPlaylist hlsPlaylist = (HlsPlaylist) parsingLoadable.f8188f;
        boolean z = hlsPlaylist instanceof HlsMediaPlaylist;
        if (z) {
            String str = hlsPlaylist.f7173a;
            HlsMultivariantPlaylist hlsMultivariantPlaylist2 = HlsMultivariantPlaylist.n;
            Uri uri = Uri.parse(str);
            Format.Builder builder = new Format.Builder();
            builder.f5226a = "0";
            builder.f5236k = MimeTypes.p("application/x-mpegURL");
            List listSingletonList = Collections.singletonList(new HlsMultivariantPlaylist.Variant(uri, new Format(builder), null, null, null, null));
            List list = Collections.EMPTY_LIST;
            hlsMultivariantPlaylist = new HlsMultivariantPlaylist("", list, listSingletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) hlsPlaylist;
        }
        this.f7102j = hlsMultivariantPlaylist;
        this.f7103k = ((HlsMultivariantPlaylist.Variant) hlsMultivariantPlaylist.f7155e.get(0)).f7167a;
        this.f7097e.add(new FirstPrimaryMediaPlaylistListener());
        List list2 = hlsMultivariantPlaylist.f7154d;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri2 = (Uri) list2.get(i2);
            this.f7096d.put(uri2, new MediaPlaylistBundle(uri2));
        }
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri3 = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f7096d.get(this.f7103k);
        if (z) {
            mediaPlaylistBundle.f((HlsMediaPlaylist) hlsPlaylist, loadEventInfo);
        } else {
            mediaPlaylistBundle.c(false);
        }
        this.f7095c.getClass();
        this.f7098f.e(loadEventInfo, 4);
    }

    public final boolean b(long j2, Uri uri) {
        if (((MediaPlaylistBundle) this.f7096d.get(uri)) != null) {
            return !MediaPlaylistBundle.a(r4, j2);
        }
        return false;
    }

    public final HlsMediaPlaylist c(boolean z, Uri uri) {
        HashMap map = this.f7096d;
        HlsMediaPlaylist hlsMediaPlaylist = ((MediaPlaylistBundle) map.get(uri)).f7110d;
        if (hlsMediaPlaylist != null && z) {
            if (!uri.equals(this.f7103k)) {
                List list = this.f7102j.f7155e;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    if (uri.equals(((HlsMultivariantPlaylist.Variant) list.get(i2)).f7167a)) {
                        HlsMediaPlaylist hlsMediaPlaylist2 = this.f7104l;
                        if (hlsMediaPlaylist2 == null || !hlsMediaPlaylist2.o) {
                            this.f7103k = uri;
                            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) map.get(uri);
                            HlsMediaPlaylist hlsMediaPlaylist3 = mediaPlaylistBundle.f7110d;
                            if (hlsMediaPlaylist3 == null || !hlsMediaPlaylist3.o) {
                                mediaPlaylistBundle.e(d(uri));
                            } else {
                                this.f7104l = hlsMediaPlaylist3;
                                this.f7101i.n0(hlsMediaPlaylist3);
                            }
                        }
                    } else {
                        i2++;
                    }
                }
            }
            MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) map.get(uri);
            HlsMediaPlaylist hlsMediaPlaylist4 = mediaPlaylistBundle2.f7110d;
            if (!mediaPlaylistBundle2.f7117k) {
                mediaPlaylistBundle2.f7117k = true;
                if (hlsMediaPlaylist4 != null && !hlsMediaPlaylist4.o) {
                    mediaPlaylistBundle2.c(true);
                }
            }
        }
        return hlsMediaPlaylist;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Uri d(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.f7104l;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.v.f7153e || (renditionReport = (HlsMediaPlaylist.RenditionReport) hlsMediaPlaylist.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.f7134b));
        int i2 = renditionReport.f7135c;
        if (i2 != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i2));
        }
        return builderBuildUpon.build();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.f7095c.getClass();
        this.f7098f.c(loadEventInfo, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final boolean e(Uri uri) {
        int i2;
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f7096d.get(uri);
        if (mediaPlaylistBundle.f7110d == null) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMax = Math.max(30000L, Util.j0(mediaPlaylistBundle.f7110d.u));
        HlsMediaPlaylist hlsMediaPlaylist = mediaPlaylistBundle.f7110d;
        return hlsMediaPlaylist.o || (i2 = hlsMediaPlaylist.f7121d) == 2 || i2 == 1 || mediaPlaylistBundle.f7111e + jMax > jElapsedRealtime;
    }

    public final void f(Uri uri) throws IOException {
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f7096d.get(uri);
        mediaPlaylistBundle.f7108b.c();
        IOException iOException = mediaPlaylistBundle.f7116j;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void g(Uri uri) {
        ((MediaPlaylistBundle) this.f7096d.get(uri)).c(true);
    }

    public final void h() {
        this.f7103k = null;
        this.f7104l = null;
        this.f7102j = null;
        this.n = -9223372036854775807L;
        this.f7099g.f(null);
        this.f7099g = null;
        HashMap map = this.f7096d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((MediaPlaylistBundle) it.next()).f7108b.f(null);
        }
        this.f7100h.removeCallbacksAndMessages(null);
        this.f7100h = null;
        map.clear();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        long jA = this.f7095c.a(new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2));
        boolean z = jA == -9223372036854775807L;
        this.f7098f.i(loadEventInfo, parsingLoadable.f8185c, iOException, z);
        return z ? Loader.f8166f : new Loader.LoadErrorAction(0, jA);
    }
}
