package androidx.media3.common;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.FlagSet;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public interface Player {

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Command {
    }

    public static final class Commands {

        /* renamed from: b, reason: collision with root package name */
        public static final Commands f5430b = new Builder().d();

        /* renamed from: c, reason: collision with root package name */
        public static final String f5431c;

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f5432a;

        static {
            int i2 = Util.f5744a;
            f5431c = Integer.toString(0, 36);
        }

        public Commands(FlagSet flagSet) {
            this.f5432a = flagSet;
        }

        public static Commands b(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f5431c);
            if (integerArrayList == null) {
                return f5430b;
            }
            Builder builder = new Builder();
            for (int i2 = 0; i2 < integerArrayList.size(); i2++) {
                builder.a(integerArrayList.get(i2).intValue());
            }
            return builder.d();
        }

        public final boolean a(int i2) {
            return this.f5432a.f5210a.get(i2);
        }

        public final Bundle c() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int i2 = 0;
            while (true) {
                FlagSet flagSet = this.f5432a;
                if (i2 >= flagSet.f5210a.size()) {
                    bundle.putIntegerArrayList(f5431c, arrayList);
                    return bundle;
                }
                arrayList.add(Integer.valueOf(flagSet.b(i2)));
                i2++;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Commands) {
                return this.f5432a.equals(((Commands) obj).f5432a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f5432a.hashCode();
        }

        @UnstableApi
        public static final class Builder {

            /* renamed from: b, reason: collision with root package name */
            public static final int[] f5433b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* renamed from: a, reason: collision with root package name */
            public final FlagSet.Builder f5434a;

            public Builder() {
                this.f5434a = new FlagSet.Builder();
            }

            public final void a(int i2) {
                this.f5434a.a(i2);
            }

            public final void b(Commands commands) {
                FlagSet flagSet = commands.f5432a;
                FlagSet.Builder builder = this.f5434a;
                builder.getClass();
                for (int i2 = 0; i2 < flagSet.f5210a.size(); i2++) {
                    builder.a(flagSet.b(i2));
                }
            }

            public final void c(int i2, boolean z) {
                FlagSet.Builder builder = this.f5434a;
                if (z) {
                    builder.a(i2);
                } else {
                    builder.getClass();
                }
            }

            public final Commands d() {
                return new Commands(this.f5434a.c());
            }

            public Builder(Commands commands) {
                FlagSet.Builder builder = new FlagSet.Builder();
                this.f5434a = builder;
                FlagSet flagSet = commands.f5432a;
                for (int i2 = 0; i2 < flagSet.f5210a.size(); i2++) {
                    builder.a(flagSet.b(i2));
                }
            }
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    public static final class Events {

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f5435a;

        public Events(FlagSet flagSet) {
            this.f5435a = flagSet;
        }

        public final boolean a(int i2) {
            return this.f5435a.f5210a.get(i2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Events) {
                return this.f5435a.equals(((Events) obj).f5435a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f5435a.hashCode();
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    public static final class PositionInfo {

        /* renamed from: j, reason: collision with root package name */
        public static final String f5436j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5437k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5438l;

        /* renamed from: m, reason: collision with root package name */
        public static final String f5439m;
        public static final String n;
        public static final String o;
        public static final String p;

        /* renamed from: a, reason: collision with root package name */
        public final Object f5440a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5441b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaItem f5442c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f5443d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5444e;

        /* renamed from: f, reason: collision with root package name */
        public final long f5445f;

        /* renamed from: g, reason: collision with root package name */
        public final long f5446g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5447h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5448i;

        static {
            int i2 = Util.f5744a;
            f5436j = Integer.toString(0, 36);
            f5437k = Integer.toString(1, 36);
            f5438l = Integer.toString(2, 36);
            f5439m = Integer.toString(3, 36);
            n = Integer.toString(4, 36);
            o = Integer.toString(5, 36);
            p = Integer.toString(6, 36);
        }

        public PositionInfo(Object obj, int i2, MediaItem mediaItem, Object obj2, int i3, long j2, long j3, int i4, int i5) {
            this.f5440a = obj;
            this.f5441b = i2;
            this.f5442c = mediaItem;
            this.f5443d = obj2;
            this.f5444e = i3;
            this.f5445f = j2;
            this.f5446g = j3;
            this.f5447h = i4;
            this.f5448i = i5;
        }

        public static PositionInfo c(Bundle bundle) {
            int i2 = bundle.getInt(f5436j, 0);
            Bundle bundle2 = bundle.getBundle(f5437k);
            return new PositionInfo(null, i2, bundle2 == null ? null : MediaItem.b(bundle2), null, bundle.getInt(f5438l, 0), bundle.getLong(f5439m, 0L), bundle.getLong(n, 0L), bundle.getInt(o, -1), bundle.getInt(p, -1));
        }

        public final boolean a(PositionInfo positionInfo) {
            return this.f5441b == positionInfo.f5441b && this.f5444e == positionInfo.f5444e && this.f5445f == positionInfo.f5445f && this.f5446g == positionInfo.f5446g && this.f5447h == positionInfo.f5447h && this.f5448i == positionInfo.f5448i && Objects.a(this.f5442c, positionInfo.f5442c);
        }

        public final PositionInfo b(boolean z, boolean z2) {
            if (z && z2) {
                return this;
            }
            return new PositionInfo(this.f5440a, z2 ? this.f5441b : 0, z ? this.f5442c : null, this.f5443d, z2 ? this.f5444e : 0, z ? this.f5445f : 0L, z ? this.f5446g : 0L, z ? this.f5447h : -1, z ? this.f5448i : -1);
        }

        public final Bundle d(int i2) {
            Bundle bundle = new Bundle();
            int i3 = this.f5441b;
            if (i2 < 3 || i3 != 0) {
                bundle.putInt(f5436j, i3);
            }
            MediaItem mediaItem = this.f5442c;
            if (mediaItem != null) {
                bundle.putBundle(f5437k, mediaItem.c(false));
            }
            int i4 = this.f5444e;
            if (i2 < 3 || i4 != 0) {
                bundle.putInt(f5438l, i4);
            }
            long j2 = this.f5445f;
            if (i2 < 3 || j2 != 0) {
                bundle.putLong(f5439m, j2);
            }
            long j3 = this.f5446g;
            if (i2 < 3 || j3 != 0) {
                bundle.putLong(n, j3);
            }
            int i5 = this.f5447h;
            if (i5 != -1) {
                bundle.putInt(o, i5);
            }
            int i6 = this.f5448i;
            if (i6 != -1) {
                bundle.putInt(p, i6);
            }
            return bundle;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PositionInfo.class == obj.getClass()) {
                PositionInfo positionInfo = (PositionInfo) obj;
                if (a(positionInfo) && Objects.a(this.f5440a, positionInfo.f5440a) && Objects.a(this.f5443d, positionInfo.f5443d)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f5440a, Integer.valueOf(this.f5441b), this.f5442c, this.f5443d, Integer.valueOf(this.f5444e), Long.valueOf(this.f5445f), Long.valueOf(this.f5446g), Integer.valueOf(this.f5447h), Integer.valueOf(this.f5448i)});
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    void A0(Listener listener);

    long A1();

    int B0();

    MediaItem B1();

    void C(float f2);

    void C0(boolean z);

    boolean C1();

    void D(PlaybackParameters playbackParameters);

    void D0(Listener listener);

    boolean D1(int i2);

    void E();

    int E0();

    boolean E1();

    PlaybackParameters F();

    Timeline F0();

    Looper F1();

    int G();

    void G0();

    boolean G1();

    TrackSelectionParameters H0();

    boolean H1();

    void I0();

    void J0(TextureView textureView);

    int K0();

    long L0();

    void M0(int i2, long j2);

    Commands N0();

    boolean O0();

    void P0(boolean z);

    long Q0();

    void R0(int i2, MediaItem mediaItem);

    long S0();

    int T0();

    void U0(TextureView textureView);

    VideoSize V0();

    void W0(AudioAttributes audioAttributes, boolean z);

    void X(long j2);

    AudioAttributes X0();

    DeviceInfo Y0();

    void Z0(int i2, int i3);

    PlaybackException a();

    int a1();

    boolean b();

    void b1(float f2);

    void c1(List list, int i2, long j2);

    void d0(int i2);

    void d1(int i2);

    void e0(Surface surface);

    long e1();

    boolean f0();

    long f1();

    long g0();

    void g1(int i2, List list);

    long getDuration();

    float getVolume();

    void h0();

    long h1();

    int i0();

    MediaMetadata i1();

    void j0();

    boolean j1();

    void k0();

    void k1(MediaItem mediaItem, long j2);

    void l0(int i2, boolean z);

    int l1();

    void m0();

    void m1(TrackSelectionParameters trackSelectionParameters);

    void n0(int i2);

    void n1(SurfaceView surfaceView);

    void o0(SurfaceView surfaceView);

    void o1(int i2, int i3);

    void p();

    void p0(int i2, int i3, List list);

    void p1(int i2, int i3, int i4);

    void pause();

    void q0(MediaMetadata mediaMetadata);

    void q1(List list);

    void r0(int i2);

    boolean r1();

    void s0(int i2, int i3);

    boolean s1();

    void stop();

    void t0();

    long t1();

    int u();

    void u0(boolean z);

    void u1(int i2);

    void v0(MediaItem mediaItem);

    void v1();

    void w0();

    void w1();

    void x0(int i2);

    MediaMetadata x1();

    Tracks y0();

    void y1(List list);

    CueGroup z0();

    long z1();

    /* loaded from: classes.dex */
    public interface Listener {
        default void A1(AudioAttributes audioAttributes) {
        }

        default void B1(Timeline timeline, int i2) {
        }

        default void C1(MediaMetadata mediaMetadata) {
        }

        default void D1(long j2) {
        }

        default void E1(Tracks tracks) {
        }

        default void F1(DeviceInfo deviceInfo) {
        }

        default void H1(PlaybackException playbackException) {
        }

        default void I1(long j2) {
        }

        default void J1(boolean z) {
        }

        default void b(VideoSize videoSize) {
        }

        default void d(boolean z) {
        }

        default void d1(int i2) {
        }

        default void e1(CueGroup cueGroup) {
        }

        default void f1(Metadata metadata) {
        }

        default void g1(int i2) {
        }

        default void h1(boolean z) {
        }

        default void i1(int i2) {
        }

        default void k(List list) {
        }

        default void k1(boolean z) {
        }

        default void l1(PlaybackParameters playbackParameters) {
        }

        default void m1(int i2, boolean z) {
        }

        default void n1(long j2) {
        }

        default void o1(MediaMetadata mediaMetadata) {
        }

        default void p1(TrackSelectionParameters trackSelectionParameters) {
        }

        default void q1() {
        }

        default void r1(PlaybackException playbackException) {
        }

        default void s1(int i2, int i3) {
        }

        default void t1(Commands commands) {
        }

        default void u1(int i2) {
        }

        default void w1(boolean z) {
        }

        default void x1(Player player, Events events) {
        }

        default void z1(float f2) {
        }

        default void G1(int i2, boolean z) {
        }

        default void j1(int i2, MediaItem mediaItem) {
        }

        default void y1(int i2, boolean z) {
        }

        default void v1(int i2, PositionInfo positionInfo, PositionInfo positionInfo2) {
        }
    }
}
