package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PlayerInfo {
    public static final PlayerInfo F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public static final String a0;
    public static final String b0;
    public static final String c0;
    public static final String d0;
    public static final String e0;
    public static final String f0;
    public static final String g0;
    public static final String h0;
    public static final String i0;
    public static final String j0;
    public static final String k0;
    public static final String l0;
    public final long A;
    public final long B;
    public final long C;
    public final Tracks D;
    public final TrackSelectionParameters E;

    /* renamed from: a, reason: collision with root package name */
    public final PlaybackException f10168a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10169b;

    /* renamed from: c, reason: collision with root package name */
    public final SessionPositionInfo f10170c;

    /* renamed from: d, reason: collision with root package name */
    public final Player.PositionInfo f10171d;

    /* renamed from: e, reason: collision with root package name */
    public final Player.PositionInfo f10172e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10173f;

    /* renamed from: g, reason: collision with root package name */
    public final PlaybackParameters f10174g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10175h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10176i;

    /* renamed from: j, reason: collision with root package name */
    public final Timeline f10177j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10178k;

    /* renamed from: l, reason: collision with root package name */
    public final VideoSize f10179l;

    /* renamed from: m, reason: collision with root package name */
    public final MediaMetadata f10180m;
    public final float n;
    public final AudioAttributes o;
    public final CueGroup p;
    public final DeviceInfo q;
    public final int r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final MediaMetadata z;

    public static class Builder {
        public long A;
        public long B;
        public long C;
        public Tracks D;
        public TrackSelectionParameters E;

        /* renamed from: a, reason: collision with root package name */
        public PlaybackException f10181a;

        /* renamed from: b, reason: collision with root package name */
        public int f10182b;

        /* renamed from: c, reason: collision with root package name */
        public SessionPositionInfo f10183c;

        /* renamed from: d, reason: collision with root package name */
        public Player.PositionInfo f10184d;

        /* renamed from: e, reason: collision with root package name */
        public Player.PositionInfo f10185e;

        /* renamed from: f, reason: collision with root package name */
        public int f10186f;

        /* renamed from: g, reason: collision with root package name */
        public PlaybackParameters f10187g;

        /* renamed from: h, reason: collision with root package name */
        public int f10188h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f10189i;

        /* renamed from: j, reason: collision with root package name */
        public Timeline f10190j;

        /* renamed from: k, reason: collision with root package name */
        public int f10191k;

        /* renamed from: l, reason: collision with root package name */
        public VideoSize f10192l;

        /* renamed from: m, reason: collision with root package name */
        public MediaMetadata f10193m;
        public float n;
        public AudioAttributes o;
        public CueGroup p;
        public DeviceInfo q;
        public int r;
        public boolean s;
        public boolean t;
        public int u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public MediaMetadata z;

        public Builder(PlayerInfo playerInfo) {
            this.f10181a = playerInfo.f10168a;
            this.f10182b = playerInfo.f10169b;
            this.f10183c = playerInfo.f10170c;
            this.f10184d = playerInfo.f10171d;
            this.f10185e = playerInfo.f10172e;
            this.f10186f = playerInfo.f10173f;
            this.f10187g = playerInfo.f10174g;
            this.f10188h = playerInfo.f10175h;
            this.f10189i = playerInfo.f10176i;
            this.f10190j = playerInfo.f10177j;
            this.f10191k = playerInfo.f10178k;
            this.f10192l = playerInfo.f10179l;
            this.f10193m = playerInfo.f10180m;
            this.n = playerInfo.n;
            this.o = playerInfo.o;
            this.p = playerInfo.p;
            this.q = playerInfo.q;
            this.r = playerInfo.r;
            this.s = playerInfo.s;
            this.t = playerInfo.t;
            this.u = playerInfo.u;
            this.v = playerInfo.v;
            this.w = playerInfo.w;
            this.x = playerInfo.x;
            this.y = playerInfo.y;
            this.z = playerInfo.z;
            this.A = playerInfo.A;
            this.B = playerInfo.B;
            this.C = playerInfo.C;
            this.D = playerInfo.D;
            this.E = playerInfo.E;
        }

        public final PlayerInfo a() {
            Assertions.g(this.f10190j.p() || this.f10183c.f10249a.f5441b < this.f10190j.o());
            return new PlayerInfo(this.f10181a, this.f10182b, this.f10183c, this.f10184d, this.f10185e, this.f10186f, this.f10187g, this.f10188h, this.f10189i, this.f10192l, this.f10190j, this.f10191k, this.f10193m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
        }
    }

    public static class BundlingExclusions {

        /* renamed from: c, reason: collision with root package name */
        public static final BundlingExclusions f10194c = new BundlingExclusions(false, false);

        /* renamed from: d, reason: collision with root package name */
        public static final String f10195d;

        /* renamed from: e, reason: collision with root package name */
        public static final String f10196e;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10197a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10198b;

        static {
            int i2 = Util.f5744a;
            f10195d = Integer.toString(0, 36);
            f10196e = Integer.toString(1, 36);
        }

        public BundlingExclusions(boolean z, boolean z2) {
            this.f10197a = z;
            this.f10198b = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundlingExclusions)) {
                return false;
            }
            BundlingExclusions bundlingExclusions = (BundlingExclusions) obj;
            return this.f10197a == bundlingExclusions.f10197a && this.f10198b == bundlingExclusions.f10198b;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f10197a), Boolean.valueOf(this.f10198b)});
        }
    }

    public final class InProcessBinder extends Binder {
        public InProcessBinder() {
        }
    }

    static {
        SessionPositionInfo sessionPositionInfo = SessionPositionInfo.f10247l;
        Player.PositionInfo positionInfo = SessionPositionInfo.f10246k;
        PlaybackParameters playbackParameters = PlaybackParameters.f5424d;
        VideoSize videoSize = VideoSize.f5559e;
        Timeline timeline = Timeline.f5466a;
        MediaMetadata mediaMetadata = MediaMetadata.J;
        F = new PlayerInfo(null, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, 0, false, videoSize, timeline, 0, mediaMetadata, 1.0f, AudioAttributes.f5143g, CueGroup.f5638c, DeviceInfo.f5188e, 0, false, false, 1, 0, 1, false, false, mediaMetadata, 5000L, 15000L, 3000L, Tracks.f5546b, TrackSelectionParameters.C);
        int i2 = Util.f5744a;
        G = Integer.toString(1, 36);
        H = Integer.toString(2, 36);
        I = Integer.toString(3, 36);
        J = Integer.toString(4, 36);
        K = Integer.toString(5, 36);
        L = Integer.toString(6, 36);
        M = Integer.toString(7, 36);
        N = Integer.toString(8, 36);
        O = Integer.toString(9, 36);
        P = Integer.toString(10, 36);
        Q = Integer.toString(11, 36);
        R = Integer.toString(12, 36);
        S = Integer.toString(13, 36);
        T = Integer.toString(14, 36);
        U = Integer.toString(15, 36);
        V = Integer.toString(16, 36);
        W = Integer.toString(17, 36);
        X = Integer.toString(18, 36);
        Y = Integer.toString(19, 36);
        Z = Integer.toString(20, 36);
        a0 = Integer.toString(21, 36);
        b0 = Integer.toString(22, 36);
        c0 = Integer.toString(23, 36);
        d0 = Integer.toString(24, 36);
        e0 = Integer.toString(25, 36);
        f0 = Integer.toString(26, 36);
        g0 = Integer.toString(27, 36);
        h0 = Integer.toString(28, 36);
        i0 = Integer.toString(29, 36);
        j0 = Integer.toString(30, 36);
        k0 = Integer.toString(31, 36);
        l0 = Integer.toString(32, 36);
    }

    public PlayerInfo(PlaybackException playbackException, int i2, SessionPositionInfo sessionPositionInfo, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3, PlaybackParameters playbackParameters, int i4, boolean z, VideoSize videoSize, Timeline timeline, int i5, MediaMetadata mediaMetadata, float f2, AudioAttributes audioAttributes, CueGroup cueGroup, DeviceInfo deviceInfo, int i6, boolean z2, boolean z3, int i7, int i8, int i9, boolean z4, boolean z5, MediaMetadata mediaMetadata2, long j2, long j3, long j4, Tracks tracks, TrackSelectionParameters trackSelectionParameters) {
        this.f10168a = playbackException;
        this.f10169b = i2;
        this.f10170c = sessionPositionInfo;
        this.f10171d = positionInfo;
        this.f10172e = positionInfo2;
        this.f10173f = i3;
        this.f10174g = playbackParameters;
        this.f10175h = i4;
        this.f10176i = z;
        this.f10179l = videoSize;
        this.f10177j = timeline;
        this.f10178k = i5;
        this.f10180m = mediaMetadata;
        this.n = f2;
        this.o = audioAttributes;
        this.p = cueGroup;
        this.q = deviceInfo;
        this.r = i6;
        this.s = z2;
        this.t = z3;
        this.u = i7;
        this.x = i8;
        this.y = i9;
        this.v = z4;
        this.w = z5;
        this.z = mediaMetadata2;
        this.A = j2;
        this.B = j3;
        this.C = j4;
        this.D = tracks;
        this.E = trackSelectionParameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PlayerInfo h(int i2, Bundle bundle) {
        PlaybackException playbackException;
        int i3;
        Timeline remotableTimeline;
        int i4;
        Timeline timeline;
        VideoSize videoSize;
        MediaMetadata mediaMetadata;
        float f2;
        AudioAttributes audioAttributes;
        ImmutableList immutableListJ;
        CueGroup cueGroup;
        VideoSize videoSize2;
        DeviceInfo deviceInfoA;
        PlaybackException playbackException2;
        long j2;
        Tracks tracks;
        int i5 = 4;
        IBinder binder = bundle.getBinder(l0);
        if (binder instanceof InProcessBinder) {
            return PlayerInfo.this;
        }
        Bundle bundle2 = bundle.getBundle(X);
        if (bundle2 == null) {
            playbackException = null;
        } else {
            String string = bundle2.getString(PlaybackException.f5417f);
            String string2 = bundle2.getString(PlaybackException.f5418g);
            String string3 = bundle2.getString(PlaybackException.f5419h);
            if (!TextUtils.isEmpty(string2)) {
                try {
                    Class<?> cls = Class.forName(string2, true, PlaybackException.class.getClassLoader());
                    remoteException = Throwable.class.isAssignableFrom(cls) ? (Throwable) cls.getConstructor(String.class).newInstance(string3) : null;
                    if (remoteException == null) {
                        remoteException = new RemoteException(string3);
                    }
                } catch (Throwable unused) {
                    remoteException = new RemoteException(string3);
                }
            }
            Throwable th = remoteException;
            int i6 = bundle2.getInt(PlaybackException.f5415d, 1000);
            Bundle bundle3 = bundle2.getBundle(PlaybackException.f5420i);
            if (bundle3 == null) {
                bundle3 = Bundle.EMPTY;
            }
            playbackException = new PlaybackException(string, th, i6, bundle3, bundle2.getLong(PlaybackException.f5416e, SystemClock.elapsedRealtime()));
        }
        int i7 = bundle.getInt(Z, 0);
        Bundle bundle4 = bundle.getBundle(Y);
        SessionPositionInfo sessionPositionInfoB = bundle4 == null ? SessionPositionInfo.f10247l : SessionPositionInfo.b(bundle4);
        Bundle bundle5 = bundle.getBundle(a0);
        Player.PositionInfo positionInfoC = bundle5 == null ? SessionPositionInfo.f10246k : Player.PositionInfo.c(bundle5);
        Bundle bundle6 = bundle.getBundle(b0);
        Player.PositionInfo positionInfoC2 = bundle6 == null ? SessionPositionInfo.f10246k : Player.PositionInfo.c(bundle6);
        int i8 = bundle.getInt(c0, 0);
        Bundle bundle7 = bundle.getBundle(G);
        PlaybackParameters playbackParameters = bundle7 == null ? PlaybackParameters.f5424d : new PlaybackParameters(bundle7.getFloat(PlaybackParameters.f5425e, 1.0f), bundle7.getFloat(PlaybackParameters.f5426f, 1.0f));
        int i9 = bundle.getInt(H, 0);
        boolean z = bundle.getBoolean(I, false);
        Bundle bundle8 = bundle.getBundle(J);
        if (bundle8 == null) {
            remotableTimeline = Timeline.f5466a;
            i3 = 1;
        } else {
            androidx.media3.common.b bVar = new androidx.media3.common.b(i5);
            IBinder binder2 = bundle8.getBinder(Timeline.f5467b);
            ImmutableList immutableListR = binder2 == null ? ImmutableList.r() : BundleCollectionUtil.a(bVar, BundleListRetriever.a(binder2));
            i3 = 1;
            androidx.media3.common.b bVar2 = new androidx.media3.common.b(5);
            IBinder binder3 = bundle8.getBinder(Timeline.f5468c);
            ImmutableList immutableListR2 = binder3 == null ? ImmutableList.r() : BundleCollectionUtil.a(bVar2, BundleListRetriever.a(binder3));
            int[] intArray = bundle8.getIntArray(Timeline.f5469d);
            if (intArray == null) {
                int size = immutableListR.size();
                int[] iArr = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr[i10] = i10;
                }
                intArray = iArr;
            }
            remotableTimeline = new Timeline.RemotableTimeline(immutableListR, immutableListR2, intArray);
        }
        int i11 = bundle.getInt(k0, 0);
        Bundle bundle9 = bundle.getBundle(K);
        if (bundle9 == null) {
            videoSize = VideoSize.f5559e;
            i4 = i11;
            timeline = remotableTimeline;
        } else {
            i4 = i11;
            timeline = remotableTimeline;
            videoSize = new VideoSize(bundle9.getFloat(VideoSize.f5563i, 1.0f), bundle9.getInt(VideoSize.f5560f, 0), bundle9.getInt(VideoSize.f5561g, 0), bundle9.getInt(VideoSize.f5562h, 0));
        }
        Bundle bundle10 = bundle.getBundle(L);
        MediaMetadata mediaMetadataB = bundle10 == null ? MediaMetadata.J : MediaMetadata.b(bundle10);
        float f3 = bundle.getFloat(M, 1.0f);
        Bundle bundle11 = bundle.getBundle(N);
        AudioAttributes audioAttributesA = bundle11 == null ? AudioAttributes.f5143g : AudioAttributes.a(bundle11);
        Bundle bundle12 = bundle.getBundle(d0);
        if (bundle12 == null) {
            cueGroup = CueGroup.f5638c;
            mediaMetadata = mediaMetadataB;
            f2 = f3;
            audioAttributes = audioAttributesA;
        } else {
            ArrayList parcelableArrayList = bundle12.getParcelableArrayList(CueGroup.f5639d);
            if (parcelableArrayList == null) {
                immutableListJ = ImmutableList.r();
                mediaMetadata = mediaMetadataB;
                f2 = f3;
                audioAttributes = audioAttributesA;
            } else {
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                mediaMetadata = mediaMetadataB;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                f2 = f3;
                audioAttributes = audioAttributesA;
                for (int i12 = 0; i12 < parcelableArrayList.size(); i12++) {
                    Bundle bundle13 = (Bundle) parcelableArrayList.get(i12);
                    bundle13.getClass();
                    builder.h(Cue.b(bundle13));
                }
                immutableListJ = builder.j();
            }
            cueGroup = new CueGroup(bundle12.getLong(CueGroup.f5640e), immutableListJ);
        }
        Bundle bundle14 = bundle.getBundle(O);
        if (bundle14 == null) {
            deviceInfoA = DeviceInfo.f5188e;
            videoSize2 = videoSize;
        } else {
            int i13 = bundle14.getInt(DeviceInfo.f5189f, 0);
            int i14 = bundle14.getInt(DeviceInfo.f5190g, 0);
            videoSize2 = videoSize;
            int i15 = bundle14.getInt(DeviceInfo.f5191h, 0);
            String string4 = bundle14.getString(DeviceInfo.f5192i);
            DeviceInfo.Builder builder2 = new DeviceInfo.Builder(i13);
            builder2.f5198b = i14;
            builder2.f5199c = i15;
            Assertions.a((i13 != 0 || string4 == null) ? i3 : 0);
            builder2.f5200d = string4;
            deviceInfoA = builder2.a();
        }
        int i16 = bundle.getInt(P, 0);
        boolean z2 = bundle.getBoolean(Q, false);
        boolean z3 = bundle.getBoolean(R, false);
        int i17 = i3;
        int i18 = bundle.getInt(S, i17);
        int i19 = bundle.getInt(T, 0);
        int i20 = bundle.getInt(U, i17);
        boolean z4 = bundle.getBoolean(V, false);
        boolean z5 = bundle.getBoolean(W, false);
        Bundle bundle15 = bundle.getBundle(e0);
        MediaMetadata mediaMetadataB2 = bundle15 == null ? MediaMetadata.J : MediaMetadata.b(bundle15);
        DeviceInfo deviceInfo = deviceInfoA;
        long j3 = bundle.getLong(f0, i2 < 4 ? 0L : 5000L);
        if (i2 < 4) {
            playbackException2 = playbackException;
            j2 = 0;
        } else {
            playbackException2 = playbackException;
            j2 = 15000;
        }
        long j4 = bundle.getLong(g0, j2);
        long j5 = bundle.getLong(h0, i2 < 4 ? 0L : 3000L);
        Bundle bundle16 = bundle.getBundle(j0);
        if (bundle16 == null) {
            tracks = Tracks.f5546b;
        } else {
            ArrayList parcelableArrayList2 = bundle16.getParcelableArrayList(Tracks.f5547c);
            tracks = new Tracks(parcelableArrayList2 == null ? ImmutableList.r() : BundleCollectionUtil.a(new androidx.media3.common.b(8), parcelableArrayList2));
        }
        Bundle bundle17 = bundle.getBundle(i0);
        return new PlayerInfo(playbackException2, i7, sessionPositionInfoB, positionInfoC, positionInfoC2, i8, playbackParameters, i9, z, videoSize2, timeline, i4, mediaMetadata, f2, audioAttributes, cueGroup, deviceInfo, i16, z2, z3, i18, i19, i20, z4, z5, mediaMetadataB2, j3, j4, j5, tracks, bundle17 == null ? TrackSelectionParameters.C : TrackSelectionParameters.b(bundle17));
    }

    public final PlayerInfo a(int i2, boolean z) {
        Builder builder = new Builder(this);
        builder.r = i2;
        builder.s = z;
        return builder.a();
    }

    public final PlayerInfo b(int i2, int i3, boolean z) {
        Builder builder = new Builder(this);
        builder.t = z;
        builder.u = i2;
        builder.x = i3;
        builder.v = this.y == 3 && z && i3 == 0;
        return builder.a();
    }

    public final PlayerInfo c(PlaybackParameters playbackParameters) {
        Builder builder = new Builder(this);
        builder.f10187g = playbackParameters;
        return builder.a();
    }

    public final PlayerInfo d(int i2, PlaybackException playbackException) {
        Builder builder = new Builder(this);
        builder.f10181a = playbackException;
        builder.y = i2;
        builder.v = i2 == 3 && this.t && this.x == 0;
        return builder.a();
    }

    public final PlayerInfo e(SessionPositionInfo sessionPositionInfo) {
        Builder builder = new Builder(this);
        builder.f10183c = sessionPositionInfo;
        return builder.a();
    }

    public final PlayerInfo f(Timeline timeline, int i2) {
        Builder builder = new Builder(this);
        builder.f10190j = timeline;
        builder.f10191k = 0;
        SessionPositionInfo sessionPositionInfo = this.f10170c;
        Player.PositionInfo positionInfo = sessionPositionInfo.f10249a;
        builder.f10183c = new SessionPositionInfo(new Player.PositionInfo(positionInfo.f5440a, i2, positionInfo.f5442c, positionInfo.f5443d, positionInfo.f5444e, positionInfo.f5445f, positionInfo.f5446g, positionInfo.f5447h, positionInfo.f5448i), sessionPositionInfo.f10250b, sessionPositionInfo.f10251c, sessionPositionInfo.f10252d, sessionPositionInfo.f10253e, sessionPositionInfo.f10254f, sessionPositionInfo.f10255g, sessionPositionInfo.f10256h, sessionPositionInfo.f10257i, sessionPositionInfo.f10258j);
        return builder.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.session.PlayerInfo g(androidx.media3.common.Player.Commands r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            r0 = 1
            androidx.media3.session.PlayerInfo$Builder r1 = new androidx.media3.session.PlayerInfo$Builder
            r1.<init>(r8)
            r2 = 16
            boolean r2 = r9.a(r2)
            r3 = 17
            boolean r3 = r9.a(r3)
            androidx.media3.session.SessionPositionInfo r4 = r8.f10170c
            androidx.media3.session.SessionPositionInfo r5 = r4.a(r2, r3)
            r1.f10183c = r5
            androidx.media3.common.Player$PositionInfo r5 = r8.f10171d
            androidx.media3.common.Player$PositionInfo r5 = r5.b(r2, r3)
            r1.f10184d = r5
            androidx.media3.common.Player$PositionInfo r5 = r8.f10172e
            androidx.media3.common.Player$PositionInfo r5 = r5.b(r2, r3)
            r1.f10185e = r5
            r5 = 0
            if (r3 != 0) goto L85
            if (r2 == 0) goto L85
            androidx.media3.common.Timeline r2 = r8.f10177j
            boolean r6 = r2.p()
            if (r6 != 0) goto L85
            androidx.media3.common.Player$PositionInfo r10 = r4.f10249a
            int r10 = r10.f5441b
            int r3 = r2.o()
            if (r3 != r0) goto L42
            goto L82
        L42:
            androidx.media3.common.Timeline$Window r3 = new androidx.media3.common.Timeline$Window
            r3.<init>()
            r6 = 0
            androidx.media3.common.Timeline$Window r10 = r2.m(r10, r3, r6)
            com.google.common.collect.UnmodifiableListIterator r3 = com.google.common.collect.ImmutableList.f42665b
            com.google.common.collect.ImmutableList$Builder r3 = new com.google.common.collect.ImmutableList$Builder
            r3.<init>()
            int r4 = r10.n
        L56:
            int r6 = r10.o
            if (r4 > r6) goto L6a
            androidx.media3.common.Timeline$Period r6 = new androidx.media3.common.Timeline$Period
            r6.<init>()
            androidx.media3.common.Timeline$Period r6 = r2.f(r4, r6, r0)
            r6.f5477c = r5
            r3.h(r6)
            int r4 = r4 + r0
            goto L56
        L6a:
            int r0 = r10.n
            int r6 = r6 - r0
            r10.o = r6
            r10.n = r5
            androidx.media3.common.Timeline$RemotableTimeline r2 = new androidx.media3.common.Timeline$RemotableTimeline
            com.google.common.collect.ImmutableList r10 = com.google.common.collect.ImmutableList.t(r10)
            com.google.common.collect.ImmutableList r0 = r3.j()
            int[] r3 = new int[]{r5}
            r2.<init>(r10, r0, r3)
        L82:
            r1.f10190j = r2
            goto L8d
        L85:
            if (r10 != 0) goto L89
            if (r3 != 0) goto L8d
        L89:
            androidx.media3.common.Timeline r10 = androidx.media3.common.Timeline.f5466a
            r1.f10190j = r10
        L8d:
            r10 = 18
            boolean r0 = r9.a(r10)
            if (r0 != 0) goto L99
            androidx.media3.common.MediaMetadata r0 = androidx.media3.common.MediaMetadata.J
            r1.f10193m = r0
        L99:
            r0 = 22
            boolean r0 = r9.a(r0)
            if (r0 != 0) goto La5
            r0 = 1065353216(0x3f800000, float:1.0)
            r1.n = r0
        La5:
            r0 = 21
            boolean r0 = r9.a(r0)
            if (r0 != 0) goto Lb1
            androidx.media3.common.AudioAttributes r0 = androidx.media3.common.AudioAttributes.f5143g
            r1.o = r0
        Lb1:
            r0 = 28
            boolean r0 = r9.a(r0)
            if (r0 != 0) goto Lbd
            androidx.media3.common.text.CueGroup r0 = androidx.media3.common.text.CueGroup.f5638c
            r1.p = r0
        Lbd:
            r0 = 23
            boolean r0 = r9.a(r0)
            if (r0 != 0) goto Lc9
            r1.r = r5
            r1.s = r5
        Lc9:
            boolean r10 = r9.a(r10)
            if (r10 != 0) goto Ld3
            androidx.media3.common.MediaMetadata r10 = androidx.media3.common.MediaMetadata.J
            r1.z = r10
        Ld3:
            if (r11 != 0) goto Ldd
            r10 = 30
            boolean r9 = r9.a(r10)
            if (r9 != 0) goto Le1
        Ldd:
            androidx.media3.common.Tracks r9 = androidx.media3.common.Tracks.f5546b
            r1.D = r9
        Le1:
            androidx.media3.session.PlayerInfo r9 = r1.a()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.PlayerInfo.g(androidx.media3.common.Player$Commands, boolean, boolean):androidx.media3.session.PlayerInfo");
    }

    public final MediaItem i() {
        Timeline timeline = this.f10177j;
        if (timeline.p()) {
            return null;
        }
        return timeline.m(this.f10170c.f10249a.f5441b, new Timeline.Window(), 0L).f5488c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    public final Bundle j(int i2) {
        long j2;
        boolean z;
        int i3;
        Timeline.Period period;
        int i4;
        int i5;
        Bundle bundleC;
        long j3;
        boolean z2 = true;
        Bundle bundle = new Bundle();
        PlaybackException playbackException = this.f10168a;
        if (playbackException != null) {
            bundle.putBundle(X, playbackException.c());
        }
        int i6 = this.f10169b;
        if (i6 != 0) {
            bundle.putInt(Z, i6);
        }
        SessionPositionInfo sessionPositionInfo = this.f10170c;
        if (i2 < 3 || !sessionPositionInfo.equals(SessionPositionInfo.f10247l)) {
            bundle.putBundle(Y, sessionPositionInfo.c(i2));
        }
        Player.PositionInfo positionInfo = this.f10171d;
        if (i2 < 3 || !SessionPositionInfo.f10246k.a(positionInfo)) {
            bundle.putBundle(a0, positionInfo.d(i2));
        }
        Player.PositionInfo positionInfo2 = this.f10172e;
        if (i2 < 3 || !SessionPositionInfo.f10246k.a(positionInfo2)) {
            bundle.putBundle(b0, positionInfo2.d(i2));
        }
        int i7 = this.f10173f;
        if (i7 != 0) {
            bundle.putInt(c0, i7);
        }
        PlaybackParameters playbackParameters = PlaybackParameters.f5424d;
        PlaybackParameters playbackParameters2 = this.f10174g;
        if (!playbackParameters2.equals(playbackParameters)) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat(PlaybackParameters.f5425e, playbackParameters2.f5427a);
            bundle2.putFloat(PlaybackParameters.f5426f, playbackParameters2.f5428b);
            bundle.putBundle(G, bundle2);
        }
        int i8 = this.f10175h;
        if (i8 != 0) {
            bundle.putInt(H, i8);
        }
        boolean z3 = this.f10176i;
        if (z3) {
            bundle.putBoolean(I, z3);
        }
        Timeline timeline = Timeline.f5466a;
        Timeline timeline2 = this.f10177j;
        boolean z4 = false;
        long j4 = 0;
        if (timeline2.equals(timeline)) {
            j2 = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            int iO = timeline2.o();
            Timeline.Window window = new Timeline.Window();
            int i9 = 0;
            while (i9 < iO) {
                Timeline.Window windowM = timeline2.m(i9, window, j4);
                windowM.getClass();
                Bundle bundle3 = new Bundle();
                long j5 = j4;
                if (!MediaItem.f5250g.equals(windowM.f5488c)) {
                    bundle3.putBundle(Timeline.Window.t, windowM.f5488c.c(false));
                }
                long j6 = windowM.f5490e;
                if (j6 != -9223372036854775807L) {
                    j3 = -9223372036854775807L;
                    bundle3.putLong(Timeline.Window.u, j6);
                } else {
                    j3 = -9223372036854775807L;
                }
                long j7 = windowM.f5491f;
                if (j7 != j3) {
                    bundle3.putLong(Timeline.Window.v, j7);
                }
                long j8 = windowM.f5492g;
                if (j8 != j3) {
                    bundle3.putLong(Timeline.Window.w, j8);
                }
                boolean z5 = windowM.f5493h;
                if (z5) {
                    bundle3.putBoolean(Timeline.Window.x, z5);
                }
                boolean z6 = windowM.f5494i;
                if (z6) {
                    bundle3.putBoolean(Timeline.Window.y, z6);
                }
                MediaItem.LiveConfiguration liveConfiguration = windowM.f5495j;
                if (liveConfiguration != null) {
                    bundle3.putBundle(Timeline.Window.z, liveConfiguration.c());
                }
                boolean z7 = windowM.f5496k;
                if (z7) {
                    bundle3.putBoolean(Timeline.Window.A, z7);
                }
                long j9 = windowM.f5497l;
                if (j9 != j5) {
                    bundle3.putLong(Timeline.Window.B, j9);
                }
                long j10 = windowM.f5498m;
                if (j10 != j3) {
                    bundle3.putLong(Timeline.Window.C, j10);
                }
                int i10 = windowM.n;
                if (i10 != 0) {
                    bundle3.putInt(Timeline.Window.D, i10);
                }
                int i11 = windowM.o;
                if (i11 != 0) {
                    bundle3.putInt(Timeline.Window.E, i11);
                }
                long j11 = windowM.p;
                if (j11 != j5) {
                    bundle3.putLong(Timeline.Window.F, j11);
                }
                arrayList.add(bundle3);
                i9++;
                j4 = j5;
            }
            j2 = j4;
            ArrayList arrayList2 = new ArrayList();
            int iH = timeline2.h();
            Timeline.Period period2 = new Timeline.Period();
            int i12 = 0;
            while (i12 < iH) {
                Timeline.Period periodF = timeline2.f(i12, period2, z4);
                periodF.getClass();
                Bundle bundle4 = new Bundle();
                int i13 = periodF.f5477c;
                if (i13 != 0) {
                    bundle4.putInt(Timeline.Period.f5470h, i13);
                }
                long j12 = periodF.f5478d;
                if (j12 != -9223372036854775807L) {
                    z = z4;
                    bundle4.putLong(Timeline.Period.f5471i, j12);
                } else {
                    z = z4;
                }
                long j13 = periodF.f5479e;
                if (j13 != j2) {
                    bundle4.putLong(Timeline.Period.f5472j, j13);
                }
                boolean z8 = periodF.f5480f;
                if (z8) {
                    bundle4.putBoolean(Timeline.Period.f5473k, z8);
                }
                if (periodF.f5481g.equals(AdPlaybackState.f5118g)) {
                    i3 = iH;
                    period = period2;
                    i4 = i12;
                } else {
                    AdPlaybackState adPlaybackState = periodF.f5481g;
                    adPlaybackState.getClass();
                    Bundle bundle5 = new Bundle();
                    ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                    AdPlaybackState.AdGroup[] adGroupArr = adPlaybackState.f5129f;
                    int length = adGroupArr.length;
                    i3 = iH;
                    ?? r8 = z;
                    while (r8 < length) {
                        int i14 = length;
                        AdPlaybackState.AdGroup adGroup = adGroupArr[r8];
                        adGroup.getClass();
                        int i15 = r8;
                        Bundle bundle6 = new Bundle();
                        Timeline.Period period3 = period2;
                        bundle6.putLong(AdPlaybackState.AdGroup.f5130j, adGroup.f5134a);
                        bundle6.putInt(AdPlaybackState.AdGroup.f5131k, adGroup.f5135b);
                        bundle6.putInt(AdPlaybackState.AdGroup.q, adGroup.f5136c);
                        bundle6.putParcelableArrayList(AdPlaybackState.AdGroup.f5132l, new ArrayList<>(Arrays.asList(adGroup.f5137d)));
                        ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
                        MediaItem[] mediaItemArr = adGroup.f5138e;
                        int length2 = mediaItemArr.length;
                        ?? r1 = z;
                        while (r1 < length2) {
                            int i16 = r1;
                            MediaItem mediaItem = mediaItemArr[i16];
                            if (mediaItem == null) {
                                bundleC = null;
                                i5 = length2;
                            } else {
                                i5 = length2;
                                bundleC = mediaItem.c(true);
                            }
                            arrayList4.add(bundleC);
                            length2 = i5;
                            r1 = i16 + 1;
                        }
                        bundle6.putParcelableArrayList(AdPlaybackState.AdGroup.r, arrayList4);
                        bundle6.putIntArray(AdPlaybackState.AdGroup.f5133m, adGroup.f5139f);
                        bundle6.putLongArray(AdPlaybackState.AdGroup.n, adGroup.f5140g);
                        bundle6.putLong(AdPlaybackState.AdGroup.o, adGroup.f5141h);
                        bundle6.putBoolean(AdPlaybackState.AdGroup.p, adGroup.f5142i);
                        arrayList3.add(bundle6);
                        i12 = i12;
                        length = i14;
                        period2 = period3;
                        r8 = i15 + 1;
                    }
                    period = period2;
                    i4 = i12;
                    if (!arrayList3.isEmpty()) {
                        bundle5.putParcelableArrayList(AdPlaybackState.f5120i, arrayList3);
                    }
                    long j14 = adPlaybackState.f5126c;
                    if (j14 != j2) {
                        bundle5.putLong(AdPlaybackState.f5121j, j14);
                    }
                    long j15 = adPlaybackState.f5127d;
                    if (j15 != -9223372036854775807L) {
                        bundle5.putLong(AdPlaybackState.f5122k, j15);
                    }
                    int i17 = adPlaybackState.f5128e;
                    if (i17 != 0) {
                        bundle5.putInt(AdPlaybackState.f5123l, i17);
                    }
                    bundle4.putBundle(Timeline.Period.f5474l, bundle5);
                }
                arrayList2.add(bundle4);
                i12 = i4 + 1;
                z2 = true;
                z4 = z;
                iH = i3;
                period2 = period;
            }
            boolean z9 = z2;
            int i18 = z4;
            int[] iArr = new int[iO];
            if (iO > 0) {
                iArr[i18 == true ? 1 : 0] = timeline2.a(z9);
            }
            int i19 = z9 ? 1 : 0;
            while (i19 < iO) {
                iArr[i19] = timeline2.e(iArr[i19 - 1], i18, z9);
                i19 += z9 ? 1 : 0;
                i18 = 0;
            }
            Bundle bundle7 = new Bundle();
            bundle7.putBinder(Timeline.f5467b, new BundleListRetriever(arrayList));
            bundle7.putBinder(Timeline.f5468c, new BundleListRetriever(arrayList2));
            bundle7.putIntArray(Timeline.f5469d, iArr);
            bundle.putBundle(J, bundle7);
        }
        int i20 = this.f10178k;
        if (i20 != 0) {
            bundle.putInt(k0, i20);
        }
        VideoSize videoSize = VideoSize.f5559e;
        VideoSize videoSize2 = this.f10179l;
        if (!videoSize2.equals(videoSize)) {
            Bundle bundle8 = new Bundle();
            bundle8.putInt(VideoSize.f5560f, videoSize2.f5564a);
            bundle8.putInt(VideoSize.f5561g, videoSize2.f5565b);
            bundle8.putInt(VideoSize.f5562h, videoSize2.f5566c);
            bundle8.putFloat(VideoSize.f5563i, videoSize2.f5567d);
            bundle.putBundle(K, bundle8);
        }
        MediaMetadata mediaMetadata = MediaMetadata.J;
        MediaMetadata mediaMetadata2 = this.f10180m;
        if (!mediaMetadata2.equals(mediaMetadata)) {
            bundle.putBundle(L, mediaMetadata2.c());
        }
        float f2 = this.n;
        if (f2 != 1.0f) {
            bundle.putFloat(M, f2);
        }
        AudioAttributes audioAttributes = AudioAttributes.f5143g;
        AudioAttributes audioAttributes2 = this.o;
        if (!audioAttributes2.equals(audioAttributes)) {
            bundle.putBundle(N, audioAttributes2.c());
        }
        CueGroup cueGroup = CueGroup.f5638c;
        CueGroup cueGroup2 = this.p;
        if (!cueGroup2.equals(cueGroup)) {
            Bundle bundle9 = new Bundle();
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            int i21 = 0;
            while (true) {
                ImmutableList immutableList = cueGroup2.f5641a;
                if (i21 >= immutableList.size()) {
                    break;
                }
                if (((Cue) immutableList.get(i21)).f5615d == null) {
                    builder.h((Cue) immutableList.get(i21));
                }
                i21++;
            }
            ImmutableList immutableListJ = builder.j();
            ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>(immutableListJ.size());
            UnmodifiableListIterator unmodifiableListIteratorListIterator = immutableListJ.listIterator(0);
            while (unmodifiableListIteratorListIterator.hasNext()) {
                Cue cue = (Cue) unmodifiableListIteratorListIterator.next();
                Bundle bundleC2 = cue.c();
                Bitmap bitmap = cue.f5615d;
                if (bitmap != null) {
                    bundleC2.putParcelable(Cue.v, bitmap);
                }
                arrayList5.add(bundleC2);
            }
            bundle9.putParcelableArrayList(CueGroup.f5639d, arrayList5);
            bundle9.putLong(CueGroup.f5640e, cueGroup2.f5642b);
            bundle.putBundle(d0, bundle9);
        }
        DeviceInfo deviceInfo = DeviceInfo.f5188e;
        DeviceInfo deviceInfo2 = this.q;
        if (!deviceInfo2.equals(deviceInfo)) {
            Bundle bundle10 = new Bundle();
            int i22 = deviceInfo2.f5193a;
            if (i22 != 0) {
                bundle10.putInt(DeviceInfo.f5189f, i22);
            }
            int i23 = deviceInfo2.f5194b;
            if (i23 != 0) {
                bundle10.putInt(DeviceInfo.f5190g, i23);
            }
            int i24 = deviceInfo2.f5195c;
            if (i24 != 0) {
                bundle10.putInt(DeviceInfo.f5191h, i24);
            }
            String str = deviceInfo2.f5196d;
            if (str != null) {
                bundle10.putString(DeviceInfo.f5192i, str);
            }
            bundle.putBundle(O, bundle10);
        }
        int i25 = this.r;
        if (i25 != 0) {
            bundle.putInt(P, i25);
        }
        boolean z10 = this.s;
        if (z10) {
            bundle.putBoolean(Q, z10);
        }
        boolean z11 = this.t;
        if (z11) {
            bundle.putBoolean(R, z11);
        }
        int i26 = this.u;
        if (i26 != 1) {
            bundle.putInt(S, i26);
        }
        int i27 = this.x;
        if (i27 != 0) {
            bundle.putInt(T, i27);
        }
        int i28 = this.y;
        if (i28 != 1) {
            bundle.putInt(U, i28);
        }
        boolean z12 = this.v;
        if (z12) {
            bundle.putBoolean(V, z12);
        }
        boolean z13 = this.w;
        if (z13) {
            bundle.putBoolean(W, z13);
        }
        MediaMetadata mediaMetadata3 = MediaMetadata.J;
        MediaMetadata mediaMetadata4 = this.z;
        if (!mediaMetadata4.equals(mediaMetadata3)) {
            bundle.putBundle(e0, mediaMetadata4.c());
        }
        long j16 = i2 < 6 ? j2 : 5000L;
        long j17 = this.A;
        if (j17 != j16) {
            bundle.putLong(f0, j17);
        }
        long j18 = i2 < 6 ? j2 : 15000L;
        long j19 = this.B;
        if (j19 != j18) {
            bundle.putLong(g0, j19);
        }
        long j20 = i2 < 6 ? j2 : 3000L;
        long j21 = this.C;
        if (j21 != j20) {
            bundle.putLong(h0, j21);
        }
        Tracks tracks = Tracks.f5546b;
        Tracks tracks2 = this.D;
        if (!tracks2.equals(tracks)) {
            Bundle bundle11 = new Bundle();
            bundle11.putParcelableArrayList(Tracks.f5547c, BundleCollectionUtil.b(tracks2.f5548a, new androidx.media3.common.b(7)));
            bundle.putBundle(j0, bundle11);
        }
        TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.C;
        TrackSelectionParameters trackSelectionParameters2 = this.E;
        if (!trackSelectionParameters2.equals(trackSelectionParameters)) {
            bundle.putBundle(i0, trackSelectionParameters2.c());
        }
        return bundle;
    }
}
