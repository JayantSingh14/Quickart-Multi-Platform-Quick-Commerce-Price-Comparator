package androidx.media3.common;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BasePlayer implements Player {

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.Window f5161a = new Timeline.Window();

    @Override // androidx.media3.common.Player
    public final MediaItem B1() {
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            return null;
        }
        return timelineF0.m(l1(), this.f5161a, 0L).f5488c;
    }

    @Override // androidx.media3.common.Player
    public final void C(float f2) {
        D(new PlaybackParameters(f2, F().f5428b));
    }

    @Override // androidx.media3.common.Player
    public final boolean C1() {
        return true;
    }

    @Override // androidx.media3.common.Player
    public final boolean D1(int i2) {
        return N0().a(i2);
    }

    @Override // androidx.media3.common.Player
    public final void E() {
        u0(true);
    }

    @Override // androidx.media3.common.Player
    public final boolean E1() {
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f5161a, 0L).f5494i;
    }

    @Override // androidx.media3.common.Player
    public final boolean G1() {
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f5161a, 0L).f5493h;
    }

    @Override // androidx.media3.common.Player
    public final boolean H1() {
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f5161a, 0L).a();
    }

    @Override // androidx.media3.common.Player
    public final void I0() {
        int iE;
        if (F0().p() || f0()) {
            m(9);
            return;
        }
        if (!k()) {
            if (H1() && E1()) {
                n(l1(), -9223372036854775807L, false);
                return;
            } else {
                m(9);
                return;
            }
        }
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            iE = -1;
        } else {
            int iL1 = l1();
            int iG = G();
            if (iG == 1) {
                iG = 0;
            }
            iE = timelineF0.e(iL1, iG, s1());
        }
        if (iE == -1) {
            m(9);
        } else if (iE == l1()) {
            n(l1(), -9223372036854775807L, true);
        } else {
            n(iE, -9223372036854775807L, false);
        }
    }

    @Override // androidx.media3.common.Player
    public final long L0() {
        Timeline timelineF0 = F0();
        if (!timelineF0.p()) {
            int iL1 = l1();
            Timeline.Window window = this.f5161a;
            if (timelineF0.m(iL1, window, 0L).f5491f != -9223372036854775807L) {
                return (Util.A(window.f5492g) - window.f5491f) - f1();
            }
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final void M0(int i2, long j2) {
        n(i2, j2, false);
    }

    @Override // androidx.media3.common.Player
    public final void R0(int i2, MediaItem mediaItem) {
        p0(i2, i2 + 1, ImmutableList.t(mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final long S0() {
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            return -9223372036854775807L;
        }
        return Util.j0(timelineF0.m(l1(), this.f5161a, 0L).f5498m);
    }

    @Override // androidx.media3.common.Player
    public final void X(long j2) {
        n(l1(), j2, false);
    }

    @Override // androidx.media3.common.Player
    public final void d1(int i2) {
        n(i2, -9223372036854775807L, false);
    }

    @Override // androidx.media3.common.Player
    public final void h0() {
        s0(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // androidx.media3.common.Player
    public final int i0() {
        long jH1 = h1();
        long duration = getDuration();
        if (jH1 == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.k((int) ((jH1 * 100) / duration), 0, 100);
    }

    @Override // androidx.media3.common.Player
    public final void j0() {
        o(6);
    }

    @Override // androidx.media3.common.Player
    public final boolean j1() {
        return u() == 3 && O0() && E0() == 0;
    }

    public final boolean k() {
        int iE;
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            iE = -1;
        } else {
            int iL1 = l1();
            int iG = G();
            if (iG == 1) {
                iG = 0;
            }
            iE = timelineF0.e(iL1, iG, s1());
        }
        return iE != -1;
    }

    @Override // androidx.media3.common.Player
    public final void k0() {
        n(l1(), -9223372036854775807L, false);
    }

    @Override // androidx.media3.common.Player
    public final void k1(MediaItem mediaItem, long j2) {
        c1(ImmutableList.t(mediaItem), 0, j2);
    }

    public final boolean l() {
        int iK;
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            iK = -1;
        } else {
            int iL1 = l1();
            int iG = G();
            if (iG == 1) {
                iG = 0;
            }
            iK = timelineF0.k(iL1, iG, s1());
        }
        return iK != -1;
    }

    public final void m(int i2) {
        n(-1, -9223372036854775807L, false);
    }

    public abstract void n(int i2, long j2, boolean z);

    public final void o(int i2) {
        int iK;
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            iK = -1;
        } else {
            int iL1 = l1();
            int iG = G();
            if (iG == 1) {
                iG = 0;
            }
            iK = timelineF0.k(iL1, iG, s1());
        }
        if (iK == -1) {
            m(i2);
        } else if (iK == l1()) {
            n(l1(), -9223372036854775807L, true);
        } else {
            n(iK, -9223372036854775807L, false);
        }
    }

    @Override // androidx.media3.common.Player
    public final void o1(int i2, int i3) {
        if (i2 != i3) {
            p1(i2, i2 + 1, i3);
        }
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        u0(false);
    }

    @Override // androidx.media3.common.Player
    public final void q1(List list) {
        g1(Api.BaseClientBuilder.API_PRIORITY_OTHER, list);
    }

    @Override // androidx.media3.common.Player
    public final void r0(int i2) {
        s0(i2, i2 + 1);
    }

    @Override // androidx.media3.common.Player
    public final void t0() {
        if (F0().p() || f0()) {
            m(7);
            return;
        }
        boolean zL = l();
        if (H1() && !G1()) {
            if (zL) {
                o(7);
                return;
            } else {
                m(7);
                return;
            }
        }
        if (!zL || z1() > Q0()) {
            n(l1(), 0L, false);
        } else {
            o(7);
        }
    }

    @Override // androidx.media3.common.Player
    public final void v0(MediaItem mediaItem) {
        y1(ImmutableList.t(mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final void v1() {
        long jZ1 = z1() + e1();
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            jZ1 = Math.min(jZ1, duration);
        }
        n(l1(), Math.max(jZ1, 0L), false);
    }

    @Override // androidx.media3.common.Player
    public final void w0() {
        int iE;
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            iE = -1;
        } else {
            int iL1 = l1();
            int iG = G();
            if (iG == 1) {
                iG = 0;
            }
            iE = timelineF0.e(iL1, iG, s1());
        }
        if (iE == -1) {
            m(8);
        } else if (iE == l1()) {
            n(l1(), -9223372036854775807L, true);
        } else {
            n(iE, -9223372036854775807L, false);
        }
    }

    @Override // androidx.media3.common.Player
    public final void w1() {
        long jZ1 = z1() + (-A1());
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            jZ1 = Math.min(jZ1, duration);
        }
        n(l1(), Math.max(jZ1, 0L), false);
    }
}
