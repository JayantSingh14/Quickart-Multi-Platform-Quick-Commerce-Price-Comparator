package androidx.media3.exoplayer.analytics;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Objects;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* loaded from: classes3.dex */
public interface AnalyticsListener {

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface EventFlags {
    }

    @UnstableApi
    public static final class EventTime {

        /* renamed from: a, reason: collision with root package name */
        public final long f6369a;

        /* renamed from: b, reason: collision with root package name */
        public final Timeline f6370b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6371c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6372d;

        /* renamed from: e, reason: collision with root package name */
        public final long f6373e;

        /* renamed from: f, reason: collision with root package name */
        public final Timeline f6374f;

        /* renamed from: g, reason: collision with root package name */
        public final int f6375g;

        /* renamed from: h, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6376h;

        /* renamed from: i, reason: collision with root package name */
        public final long f6377i;

        /* renamed from: j, reason: collision with root package name */
        public final long f6378j;

        public EventTime(long j2, Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId, long j3, Timeline timeline2, int i3, MediaSource.MediaPeriodId mediaPeriodId2, long j4, long j5) {
            this.f6369a = j2;
            this.f6370b = timeline;
            this.f6371c = i2;
            this.f6372d = mediaPeriodId;
            this.f6373e = j3;
            this.f6374f = timeline2;
            this.f6375g = i3;
            this.f6376h = mediaPeriodId2;
            this.f6377i = j4;
            this.f6378j = j5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && EventTime.class == obj.getClass()) {
                EventTime eventTime = (EventTime) obj;
                if (this.f6369a == eventTime.f6369a && this.f6371c == eventTime.f6371c && this.f6373e == eventTime.f6373e && this.f6375g == eventTime.f6375g && this.f6377i == eventTime.f6377i && this.f6378j == eventTime.f6378j && Objects.a(this.f6370b, eventTime.f6370b) && Objects.a(this.f6372d, eventTime.f6372d) && Objects.a(this.f6374f, eventTime.f6374f) && Objects.a(this.f6376h, eventTime.f6376h)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f6369a), this.f6370b, Integer.valueOf(this.f6371c), this.f6372d, Long.valueOf(this.f6373e), this.f6374f, Integer.valueOf(this.f6375g), this.f6376h, Long.valueOf(this.f6377i), Long.valueOf(this.f6378j)});
        }
    }

    @UnstableApi
    public static final class Events {

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f6379a;

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray f6380b;

        public Events(FlagSet flagSet, SparseArray sparseArray) {
            this.f6379a = flagSet;
            SparseBooleanArray sparseBooleanArray = flagSet.f5210a;
            SparseArray sparseArray2 = new SparseArray(sparseBooleanArray.size());
            for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
                int iB = flagSet.b(i2);
                EventTime eventTime = (EventTime) sparseArray.get(iB);
                eventTime.getClass();
                sparseArray2.append(iB, eventTime);
            }
            this.f6380b = sparseArray2;
        }

        public final boolean a(int i2) {
            return this.f6379a.f5210a.get(i2);
        }

        public final EventTime b(int i2) {
            EventTime eventTime = (EventTime) this.f6380b.get(i2);
            eventTime.getClass();
            return eventTime;
        }
    }

    default void A(EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    default void B(EventTime eventTime, String str) {
    }

    default void D(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void E(EventTime eventTime, String str) {
    }

    default void F(EventTime eventTime, int i2) {
    }

    default void G(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void J(EventTime eventTime) {
    }

    default void L(EventTime eventTime, Tracks tracks) {
    }

    default void M(EventTime eventTime, int i2) {
    }

    default void N(EventTime eventTime, VideoSize videoSize) {
    }

    default void O(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void P(Player player, Events events) {
    }

    default void Q(EventTime eventTime) {
    }

    default void a(EventTime eventTime, boolean z) {
    }

    default void d(EventTime eventTime, boolean z) {
    }

    default void e(EventTime eventTime, Metadata metadata) {
    }

    default void f(EventTime eventTime, boolean z) {
    }

    default void g(EventTime eventTime, PlaybackException playbackException) {
    }

    default void i(EventTime eventTime, DecoderCounters decoderCounters) {
    }

    default void j(EventTime eventTime) {
    }

    default void p(EventTime eventTime, AudioAttributes audioAttributes) {
    }

    default void q(EventTime eventTime, int i2) {
    }

    default void r(EventTime eventTime, Exception exc) {
    }

    default void t(EventTime eventTime, int i2, int i3) {
    }

    default void u(EventTime eventTime, int i2) {
    }

    default void v(EventTime eventTime, float f2) {
    }

    default void w(EventTime eventTime, boolean z) {
    }

    default void x(EventTime eventTime, int i2) {
    }

    default void y(EventTime eventTime, int i2, long j2, long j3) {
    }

    default void z(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void K(EventTime eventTime) {
    }

    default void c(EventTime eventTime) {
    }

    default void k(EventTime eventTime) {
    }

    default void C(EventTime eventTime, String str) {
    }

    default void I(EventTime eventTime, int i2) {
    }

    default void R(EventTime eventTime, String str) {
    }

    default void b(EventTime eventTime, Object obj) {
    }

    default void h(EventTime eventTime, Format format) {
    }

    default void l(EventTime eventTime, Format format) {
    }

    default void s(EventTime eventTime, int i2) {
    }

    default void H(int i2, long j2, EventTime eventTime) {
    }

    default void m(EventTime eventTime, int i2, boolean z) {
    }

    default void o(EventTime eventTime, MediaLoadData mediaLoadData, IOException iOException) {
    }

    default void n(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, EventTime eventTime) {
    }
}
