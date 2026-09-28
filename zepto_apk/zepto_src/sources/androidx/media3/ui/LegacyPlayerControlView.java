package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public class LegacyPlayerControlView extends FrameLayout {
    public static final /* synthetic */ int P0 = 0;
    public final Drawable A;
    public int A0;
    public final Drawable B;
    public int B0;
    public final float C;
    public boolean C0;
    public final float D;
    public boolean D0;
    public final String E;
    public boolean E0;
    public final String F;
    public boolean F0;
    public Player G;
    public boolean G0;
    public ProgressUpdateListener H;
    public long H0;
    public boolean I;
    public long[] I0;
    public boolean J;
    public boolean[] J0;
    public boolean K;
    public final long[] K0;
    public boolean L;
    public final boolean[] L0;
    public boolean M;
    public long M0;
    public long N0;
    public long O0;
    public int Q;

    /* renamed from: a, reason: collision with root package name */
    public final ComponentListener f10850a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f10851b;

    /* renamed from: c, reason: collision with root package name */
    public final View f10852c;

    /* renamed from: d, reason: collision with root package name */
    public final View f10853d;

    /* renamed from: e, reason: collision with root package name */
    public final View f10854e;

    /* renamed from: f, reason: collision with root package name */
    public final View f10855f;

    /* renamed from: g, reason: collision with root package name */
    public final View f10856g;

    /* renamed from: h, reason: collision with root package name */
    public final View f10857h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f10858i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f10859j;

    /* renamed from: k, reason: collision with root package name */
    public final View f10860k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f10861l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f10862m;
    public final TimeBar n;
    public final StringBuilder o;
    public final Formatter p;
    public final Timeline.Period q;
    public final Timeline.Window r;
    public final b s;
    public final b t;
    public final Drawable u;
    public final Drawable v;
    public final Drawable w;
    public final String x;
    public final String y;
    public final String z;

    @RequiresApi
    public static final class Api21 {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    public final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener {
        public ComponentListener() {
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void B(long j2, boolean z) {
            Player player;
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            int iL1 = 0;
            legacyPlayerControlView.M = false;
            if (z || (player = legacyPlayerControlView.G) == null) {
                return;
            }
            Timeline timelineF0 = player.F0();
            if (legacyPlayerControlView.L && !timelineF0.p()) {
                int iO = timelineF0.o();
                while (true) {
                    long jJ0 = Util.j0(timelineF0.m(iL1, legacyPlayerControlView.r, 0L).f5498m);
                    if (j2 < jJ0) {
                        break;
                    }
                    if (iL1 == iO - 1) {
                        j2 = jJ0;
                        break;
                    } else {
                        j2 -= jJ0;
                        iL1++;
                    }
                }
            } else {
                iL1 = player.l1();
            }
            player.M0(iL1, j2);
            legacyPlayerControlView.j();
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void h(long j2) {
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            legacyPlayerControlView.M = true;
            TextView textView = legacyPlayerControlView.f10862m;
            if (textView != null) {
                textView.setText(Util.E(legacyPlayerControlView.o, legacyPlayerControlView.p, j2));
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            Player player = legacyPlayerControlView.G;
            if (player == null) {
                return;
            }
            if (legacyPlayerControlView.f10853d == view) {
                player.I0();
                return;
            }
            if (legacyPlayerControlView.f10852c == view) {
                player.t0();
                return;
            }
            if (legacyPlayerControlView.f10856g == view) {
                if (player.u() != 4) {
                    player.v1();
                    return;
                }
                return;
            }
            if (legacyPlayerControlView.f10857h == view) {
                player.w1();
                return;
            }
            if (legacyPlayerControlView.f10854e == view) {
                Util.J(player);
                return;
            }
            if (legacyPlayerControlView.f10855f == view) {
                Util.I(player);
            } else if (legacyPlayerControlView.f10858i == view) {
                player.d0(RepeatModeUtil.a(player.G(), legacyPlayerControlView.B0));
            } else if (legacyPlayerControlView.f10859j == view) {
                player.P0(!player.s1());
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void x1(Player player, Player.Events events) {
            FlagSet flagSet = events.f5435a;
            boolean zA = flagSet.a(4, 5);
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            if (zA) {
                int i2 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.i();
            }
            if (flagSet.a(4, 5, 7)) {
                int i3 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.j();
            }
            if (events.a(8)) {
                int i4 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.k();
            }
            if (events.a(9)) {
                int i5 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.l();
            }
            if (flagSet.a(8, 9, 11, 0, 13)) {
                int i6 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.h();
            }
            if (flagSet.a(11, 0)) {
                int i7 = LegacyPlayerControlView.P0;
                legacyPlayerControlView.m();
            }
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void z(long j2) {
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            TextView textView = legacyPlayerControlView.f10862m;
            if (textView != null) {
                textView.setText(Util.E(legacyPlayerControlView.o, legacyPlayerControlView.p, j2));
            }
        }
    }

    public interface ProgressUpdateListener {
        void a();
    }

    public interface VisibilityListener {
        void h(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
    }

    public LegacyPlayerControlView(Context context) {
        this(context, null);
    }

    public final void a(VisibilityListener visibilityListener) {
        this.f10851b.add(visibilityListener);
    }

    public final void b() {
        if (d()) {
            setVisibility(8);
            Iterator it = this.f10851b.iterator();
            while (it.hasNext()) {
                ((VisibilityListener) it.next()).h(getVisibility());
            }
            removeCallbacks(this.s);
            removeCallbacks(this.t);
            this.H0 = -9223372036854775807L;
        }
    }

    public final void c() {
        b bVar = this.t;
        removeCallbacks(bVar);
        if (this.Q <= 0) {
            this.H0 = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = this.Q;
        this.H0 = jUptimeMillis + j2;
        if (this.I) {
            postDelayed(bVar, j2);
        }
    }

    public final boolean d() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.G;
        if (player == null || !(keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.u() == 4) {
                return true;
            }
            player.v1();
            return true;
        }
        if (keyCode == 89) {
            player.w1();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Util.K(player, this.K);
            return true;
        }
        if (keyCode == 87) {
            player.I0();
            return true;
        }
        if (keyCode == 88) {
            player.t0();
            return true;
        }
        if (keyCode == 126) {
            Util.J(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        Util.I(player);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.t);
        } else if (motionEvent.getAction() == 1) {
            c();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        View view;
        View view2;
        boolean zE0 = Util.e0(this.G, this.K);
        if (zE0 && (view2 = this.f10854e) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (zE0 || (view = this.f10855f) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void f() {
        View view;
        View view2;
        if (!d()) {
            setVisibility(0);
            Iterator it = this.f10851b.iterator();
            while (it.hasNext()) {
                ((VisibilityListener) it.next()).h(getVisibility());
            }
            i();
            h();
            k();
            l();
            m();
            boolean zE0 = Util.e0(this.G, this.K);
            if (zE0 && (view2 = this.f10854e) != null) {
                view2.requestFocus();
            } else if (!zE0 && (view = this.f10855f) != null) {
                view.requestFocus();
            }
            e();
        }
        c();
    }

    public final void g(View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.C : this.D);
        view.setVisibility(z ? 0 : 8);
    }

    @Nullable
    public Player getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.B0;
    }

    public boolean getShowShuffleButton() {
        return this.G0;
    }

    public int getShowTimeoutMs() {
        return this.Q;
    }

    public boolean getShowVrButton() {
        View view = this.f10860k;
        return view != null && view.getVisibility() == 0;
    }

    public final void h() {
        boolean zD1;
        boolean zD12;
        boolean zD13;
        boolean zD14;
        boolean zD15;
        if (d() && this.I) {
            Player player = this.G;
            if (player != null) {
                zD1 = player.D1(5);
                zD13 = player.D1(7);
                zD14 = player.D1(11);
                zD15 = player.D1(12);
                zD12 = player.D1(9);
            } else {
                zD1 = false;
                zD12 = false;
                zD13 = false;
                zD14 = false;
                zD15 = false;
            }
            g(this.f10852c, this.E0, zD13);
            g(this.f10857h, this.C0, zD14);
            g(this.f10856g, this.D0, zD15);
            g(this.f10853d, this.F0, zD12);
            TimeBar timeBar = this.n;
            if (timeBar != null) {
                timeBar.setEnabled(zD1);
            }
        }
    }

    public final void i() {
        boolean z;
        boolean z2;
        if (d() && this.I) {
            boolean zE0 = Util.e0(this.G, this.K);
            View view = this.f10854e;
            boolean z3 = true;
            if (view != null) {
                z = !zE0 && view.isFocused();
                z2 = Util.f5744a < 21 ? z : !zE0 && Api21.a(view);
                view.setVisibility(zE0 ? 0 : 8);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.f10855f;
            if (view2 != null) {
                z |= zE0 && view2.isFocused();
                if (Util.f5744a < 21) {
                    z3 = z;
                } else if (!zE0 || !Api21.a(view2)) {
                    z3 = false;
                }
                z2 |= z3;
                view2.setVisibility(zE0 ? 8 : 0);
            }
            if (z) {
                boolean zE02 = Util.e0(this.G, this.K);
                if (zE02 && view != null) {
                    view.requestFocus();
                } else if (!zE02 && view2 != null) {
                    view2.requestFocus();
                }
            }
            if (z2) {
                e();
            }
        }
    }

    public final void j() {
        long jF1;
        long jT1;
        if (d() && this.I) {
            Player player = this.G;
            if (player != null) {
                jF1 = player.f1() + this.M0;
                jT1 = player.t1() + this.M0;
            } else {
                jF1 = 0;
                jT1 = 0;
            }
            boolean z = jF1 != this.N0;
            boolean z2 = jT1 != this.O0;
            this.N0 = jF1;
            this.O0 = jT1;
            TextView textView = this.f10862m;
            if (textView != null && !this.M && z) {
                textView.setText(Util.E(this.o, this.p, jF1));
            }
            TimeBar timeBar = this.n;
            if (timeBar != null) {
                timeBar.setPosition(jF1);
                timeBar.setBufferedPosition(jT1);
            }
            ProgressUpdateListener progressUpdateListener = this.H;
            if (progressUpdateListener != null && (z || z2)) {
                progressUpdateListener.a();
            }
            b bVar = this.s;
            removeCallbacks(bVar);
            int iU = player == null ? 1 : player.u();
            if (player != null && player.j1()) {
                long jMin = Math.min(timeBar != null ? timeBar.getPreferredUpdateDelay() : 1000L, 1000 - (jF1 % 1000));
                float f2 = player.F().f5427a;
                postDelayed(bVar, Util.l(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.A0, 1000L));
            } else {
                if (iU == 4 || iU == 1) {
                    return;
                }
                postDelayed(bVar, 1000L);
            }
        }
    }

    public final void k() {
        ImageView imageView;
        if (d() && this.I && (imageView = this.f10858i) != null) {
            if (this.B0 == 0) {
                g(imageView, false, false);
                return;
            }
            Player player = this.G;
            String str = this.x;
            Drawable drawable = this.u;
            if (player == null) {
                g(imageView, true, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            g(imageView, true, true);
            int iG = player.G();
            if (iG == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (iG == 1) {
                imageView.setImageDrawable(this.v);
                imageView.setContentDescription(this.y);
            } else if (iG == 2) {
                imageView.setImageDrawable(this.w);
                imageView.setContentDescription(this.z);
            }
            imageView.setVisibility(0);
        }
    }

    public final void l() {
        ImageView imageView;
        if (d() && this.I && (imageView = this.f10859j) != null) {
            Player player = this.G;
            if (!this.G0) {
                g(imageView, false, false);
                return;
            }
            String str = this.F;
            Drawable drawable = this.B;
            if (player == null) {
                g(imageView, true, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            g(imageView, true, true);
            if (player.s1()) {
                drawable = this.A;
            }
            imageView.setImageDrawable(drawable);
            if (player.s1()) {
                str = this.E;
            }
            imageView.setContentDescription(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[EDGE_INSN: B:17:0x003a->B:18:0x003b BREAK  A[LOOP:0: B:11:0x0028->B:15:0x0035]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.LegacyPlayerControlView.m():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j2 = this.H0;
        if (j2 != -9223372036854775807L) {
            long jUptimeMillis = j2 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                b();
            } else {
                postDelayed(this.t, jUptimeMillis);
            }
        } else if (d()) {
            c();
        }
        i();
        h();
        k();
        l();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.s);
        removeCallbacks(this.t);
    }

    public void setPlayer(@Nullable Player player) {
        Assertions.g(Looper.myLooper() == Looper.getMainLooper());
        Assertions.a(player == null || player.F1() == Looper.getMainLooper());
        Player player2 = this.G;
        if (player2 == player) {
            return;
        }
        ComponentListener componentListener = this.f10850a;
        if (player2 != null) {
            player2.A0(componentListener);
        }
        this.G = player;
        if (player != null) {
            player.D0(componentListener);
        }
        i();
        h();
        k();
        l();
        m();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.H = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.B0 = i2;
        Player player = this.G;
        if (player != null) {
            int iG = player.G();
            if (i2 == 0 && iG != 0) {
                this.G.d0(0);
            } else if (i2 == 1 && iG == 2) {
                this.G.d0(1);
            } else if (i2 == 2 && iG == 1) {
                this.G.d0(2);
            }
        }
        k();
    }

    public void setShowFastForwardButton(boolean z) {
        this.D0 = z;
        h();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.J = z;
        m();
    }

    public void setShowNextButton(boolean z) {
        this.F0 = z;
        h();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.K = z;
        i();
    }

    public void setShowPreviousButton(boolean z) {
        this.E0 = z;
        h();
    }

    public void setShowRewindButton(boolean z) {
        this.C0 = z;
        h();
    }

    public void setShowShuffleButton(boolean z) {
        this.G0 = z;
        l();
    }

    public void setShowTimeoutMs(int i2) {
        this.Q = i2;
        if (d()) {
            c();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.f10860k;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.A0 = Util.k(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f10860k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            g(view, getShowVrButton(), onClickListener != null);
        }
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.media3.ui.b] */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.media3.ui.b] */
    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        Context context2;
        super(context, attributeSet, i2);
        int resourceId = R.layout.exo_legacy_player_control_view;
        this.K = true;
        this.Q = 5000;
        this.B0 = 0;
        this.A0 = 200;
        this.H0 = -9223372036854775807L;
        this.C0 = true;
        this.D0 = true;
        this.E0 = true;
        this.F0 = true;
        this.G0 = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.LegacyPlayerControlView, i2, 0);
            try {
                this.Q = typedArrayObtainStyledAttributes.getInt(R.styleable.LegacyPlayerControlView_show_timeout, this.Q);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LegacyPlayerControlView_controller_layout_id, resourceId);
                this.B0 = typedArrayObtainStyledAttributes.getInt(R.styleable.LegacyPlayerControlView_repeat_toggle_modes, this.B0);
                this.C0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LegacyPlayerControlView_show_rewind_button, this.C0);
                this.D0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LegacyPlayerControlView_show_fastforward_button, this.D0);
                this.E0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LegacyPlayerControlView_show_previous_button, this.E0);
                this.F0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LegacyPlayerControlView_show_next_button, this.F0);
                this.G0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LegacyPlayerControlView_show_shuffle_button, this.G0);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.LegacyPlayerControlView_time_bar_min_update_interval, this.A0));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f10851b = new CopyOnWriteArrayList();
        this.q = new Timeline.Period();
        this.r = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.o = sb;
        this.p = new Formatter(sb, Locale.getDefault());
        this.I0 = new long[0];
        this.J0 = new boolean[0];
        this.K0 = new long[0];
        this.L0 = new boolean[0];
        ComponentListener componentListener = new ComponentListener();
        this.f10850a = componentListener;
        final int i3 = 0;
        this.s = new Runnable(this) { // from class: androidx.media3.ui.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LegacyPlayerControlView f10995b;

            {
                this.f10995b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LegacyPlayerControlView legacyPlayerControlView = this.f10995b;
                switch (i3) {
                    case 0:
                        int i4 = LegacyPlayerControlView.P0;
                        legacyPlayerControlView.j();
                        break;
                    default:
                        legacyPlayerControlView.b();
                        break;
                }
            }
        };
        final int i4 = 1;
        this.t = new Runnable(this) { // from class: androidx.media3.ui.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LegacyPlayerControlView f10995b;

            {
                this.f10995b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LegacyPlayerControlView legacyPlayerControlView = this.f10995b;
                switch (i4) {
                    case 0:
                        int i42 = LegacyPlayerControlView.P0;
                        legacyPlayerControlView.j();
                        break;
                    default:
                        legacyPlayerControlView.b();
                        break;
                }
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        TimeBar timeBar = (TimeBar) findViewById(R.id.exo_progress);
        View viewFindViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.n = timeBar;
            context2 = context;
        } else if (viewFindViewById != null) {
            context2 = context;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context2, null, 0, attributeSet, 0);
            defaultTimeBar.setId(R.id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.n = defaultTimeBar;
        } else {
            context2 = context;
            this.n = null;
        }
        this.f10861l = (TextView) findViewById(R.id.exo_duration);
        this.f10862m = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar2 = this.n;
        if (timeBar2 != null) {
            timeBar2.a(componentListener);
        }
        View viewFindViewById2 = findViewById(R.id.exo_play);
        this.f10854e = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
        }
        View viewFindViewById3 = findViewById(R.id.exo_pause);
        this.f10855f = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
        }
        View viewFindViewById4 = findViewById(R.id.exo_prev);
        this.f10852c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(componentListener);
        }
        View viewFindViewById5 = findViewById(R.id.exo_next);
        this.f10853d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(componentListener);
        }
        View viewFindViewById6 = findViewById(R.id.exo_rew);
        this.f10857h = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(componentListener);
        }
        View viewFindViewById7 = findViewById(R.id.exo_ffwd);
        this.f10856g = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f10858i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f10859j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        View viewFindViewById8 = findViewById(R.id.exo_vr);
        this.f10860k = viewFindViewById8;
        setShowVrButton(false);
        g(viewFindViewById8, false, false);
        Resources resources = context2.getResources();
        this.C = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.u = Util.v(context2, resources, R.drawable.exo_legacy_controls_repeat_off);
        this.v = Util.v(context2, resources, R.drawable.exo_legacy_controls_repeat_one);
        this.w = Util.v(context2, resources, R.drawable.exo_legacy_controls_repeat_all);
        this.A = Util.v(context2, resources, R.drawable.exo_legacy_controls_shuffle_on);
        this.B = Util.v(context2, resources, R.drawable.exo_legacy_controls_shuffle_off);
        this.x = resources.getString(R.string.exo_controls_repeat_off_description);
        this.y = resources.getString(R.string.exo_controls_repeat_one_description);
        this.z = resources.getString(R.string.exo_controls_repeat_all_description);
        this.E = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R.string.exo_controls_shuffle_off_description);
        this.N0 = -9223372036854775807L;
        this.O0 = -9223372036854775807L;
    }
}
