package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.TimeBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public class PlayerControlView extends FrameLayout {
    public static final float[] k1;
    public final View A;
    public final Drawable A0;
    public final View B;
    public final String B0;
    public final TextView C;
    public final String C0;
    public final TextView D;
    public final String D0;
    public final TimeBar E;
    public final Drawable E0;
    public final StringBuilder F;
    public final Drawable F0;
    public final Formatter G;
    public final float G0;
    public final Timeline.Period H;
    public final float H0;
    public final Timeline.Window I;
    public final String I0;
    public final a J;
    public final String J0;
    public final Drawable K;
    public final Drawable K0;
    public final Drawable L;
    public final Drawable L0;
    public final Drawable M;
    public final String M0;
    public final String N0;
    public final Drawable O0;
    public final Drawable P0;
    public final Drawable Q;
    public final String Q0;
    public final String R0;
    public Player S0;
    public ProgressUpdateListener T0;
    public OnFullScreenModeChangedListener U0;
    public boolean V0;
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public boolean Z0;

    /* renamed from: a, reason: collision with root package name */
    public final PlayerControlViewLayoutManager f10864a;
    public boolean a1;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f10865b;
    public int b1;

    /* renamed from: c, reason: collision with root package name */
    public final ComponentListener f10866c;
    public int c1;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f10867d;
    public int d1;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f10868e;
    public long[] e1;

    /* renamed from: f, reason: collision with root package name */
    public final SettingsAdapter f10869f;
    public boolean[] f1;

    /* renamed from: g, reason: collision with root package name */
    public final PlaybackSpeedAdapter f10870g;
    public final long[] g1;

    /* renamed from: h, reason: collision with root package name */
    public final TextTrackSelectionAdapter f10871h;
    public final boolean[] h1;

    /* renamed from: i, reason: collision with root package name */
    public final AudioTrackSelectionAdapter f10872i;
    public long i1;

    /* renamed from: j, reason: collision with root package name */
    public final DefaultTrackNameProvider f10873j;
    public boolean j1;

    /* renamed from: k, reason: collision with root package name */
    public final PopupWindow f10874k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10875l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f10876m;
    public final ImageView n;
    public final ImageView o;
    public final View p;
    public final View q;
    public final TextView r;
    public final TextView s;
    public final ImageView t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final ImageView y;
    public final View z;

    public final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        public AudioTrackSelectionAdapter() {
            super();
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public final void A(String str) {
            PlayerControlView.this.f10869f.f10884e[1] = str;
        }

        public final boolean B(TrackSelectionParameters trackSelectionParameters) {
            for (int i2 = 0; i2 < this.f10891d.size(); i2++) {
                if (trackSelectionParameters.A.containsKey(((TrackInformation) this.f10891d.get(i2)).f10888a.f5554b)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public final void z(SubSettingViewHolder subSettingViewHolder) {
            subSettingViewHolder.u.setText(R.string.exo_track_selection_auto);
            Player player = PlayerControlView.this.S0;
            player.getClass();
            subSettingViewHolder.v.setVisibility(B(player.H0()) ? 4 : 0);
            subSettingViewHolder.f11653a.setOnClickListener(new c(this, 0));
        }
    }

    public final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        public ComponentListener() {
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void B(long j2, boolean z) {
            Player player;
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = 0;
            playerControlView.a1 = false;
            if (!z && (player = playerControlView.S0) != null) {
                if (playerControlView.Z0) {
                    if (player.D1(17) && player.D1(10)) {
                        Timeline timelineF0 = player.F0();
                        int iO = timelineF0.o();
                        while (true) {
                            long jJ0 = Util.j0(timelineF0.m(i2, playerControlView.I, 0L).f5498m);
                            if (j2 < jJ0) {
                                break;
                            }
                            if (i2 == iO - 1) {
                                j2 = jJ0;
                                break;
                            } else {
                                j2 -= jJ0;
                                i2++;
                            }
                        }
                        player.M0(i2, j2);
                    }
                } else if (player.D1(5)) {
                    player.X(j2);
                }
                playerControlView.o();
            }
            playerControlView.f10864a.g();
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void h(long j2) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.a1 = true;
            TextView textView = playerControlView.D;
            if (textView != null) {
                textView.setText(Util.E(playerControlView.F, playerControlView.G, j2));
            }
            playerControlView.f10864a.f();
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlayerControlView playerControlView = PlayerControlView.this;
            Player player = playerControlView.S0;
            if (player == null) {
                return;
            }
            PlayerControlViewLayoutManager playerControlViewLayoutManager = playerControlView.f10864a;
            playerControlViewLayoutManager.g();
            if (playerControlView.n == view) {
                if (player.D1(9)) {
                    player.I0();
                    return;
                }
                return;
            }
            if (playerControlView.f10876m == view) {
                if (player.D1(7)) {
                    player.t0();
                    return;
                }
                return;
            }
            if (playerControlView.p == view) {
                if (player.u() == 4 || !player.D1(12)) {
                    return;
                }
                player.v1();
                return;
            }
            if (playerControlView.q == view) {
                if (player.D1(11)) {
                    player.w1();
                    return;
                }
                return;
            }
            if (playerControlView.o == view) {
                Util.K(player, playerControlView.Y0);
                return;
            }
            if (playerControlView.t == view) {
                if (player.D1(15)) {
                    player.d0(RepeatModeUtil.a(player.G(), playerControlView.d1));
                    return;
                }
                return;
            }
            if (playerControlView.u == view) {
                if (player.D1(14)) {
                    player.P0(!player.s1());
                    return;
                }
                return;
            }
            View view2 = playerControlView.z;
            if (view2 == view) {
                playerControlViewLayoutManager.f();
                playerControlView.e(playerControlView.f10869f, view2);
                return;
            }
            View view3 = playerControlView.A;
            if (view3 == view) {
                playerControlViewLayoutManager.f();
                playerControlView.e(playerControlView.f10870g, view3);
                return;
            }
            View view4 = playerControlView.B;
            if (view4 == view) {
                playerControlViewLayoutManager.f();
                playerControlView.e(playerControlView.f10872i, view4);
                return;
            }
            ImageView imageView = playerControlView.w;
            if (imageView == view) {
                playerControlViewLayoutManager.f();
                playerControlView.e(playerControlView.f10871h, imageView);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            PlayerControlView playerControlView = PlayerControlView.this;
            if (playerControlView.j1) {
                playerControlView.f10864a.g();
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void x1(Player player, Player.Events events) {
            FlagSet flagSet = events.f5435a;
            boolean zA = flagSet.a(4, 5, 13);
            PlayerControlView playerControlView = PlayerControlView.this;
            if (zA) {
                float[] fArr = PlayerControlView.k1;
                playerControlView.m();
            }
            if (flagSet.a(4, 5, 7, 13)) {
                float[] fArr2 = PlayerControlView.k1;
                playerControlView.o();
            }
            if (flagSet.a(8, 13)) {
                float[] fArr3 = PlayerControlView.k1;
                playerControlView.p();
            }
            if (flagSet.a(9, 13)) {
                float[] fArr4 = PlayerControlView.k1;
                playerControlView.r();
            }
            if (flagSet.a(8, 9, 11, 0, 16, 17, 13)) {
                float[] fArr5 = PlayerControlView.k1;
                playerControlView.l();
            }
            if (flagSet.a(11, 0, 13)) {
                float[] fArr6 = PlayerControlView.k1;
                playerControlView.s();
            }
            if (flagSet.a(12, 13)) {
                float[] fArr7 = PlayerControlView.k1;
                playerControlView.n();
            }
            if (flagSet.a(2, 13)) {
                float[] fArr8 = PlayerControlView.k1;
                playerControlView.t();
            }
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public final void z(long j2) {
            PlayerControlView playerControlView = PlayerControlView.this;
            TextView textView = playerControlView.D;
            if (textView != null) {
                textView.setText(Util.E(playerControlView.F, playerControlView.G, j2));
            }
        }
    }

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void z(boolean z);
    }

    public final class PlaybackSpeedAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: d, reason: collision with root package name */
        public final String[] f10879d;

        /* renamed from: e, reason: collision with root package name */
        public final float[] f10880e;

        /* renamed from: f, reason: collision with root package name */
        public int f10881f;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.f10879d = strArr;
            this.f10880e = fArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int d() {
            return this.f10879d.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void o(RecyclerView.ViewHolder viewHolder, final int i2) {
            SubSettingViewHolder subSettingViewHolder = (SubSettingViewHolder) viewHolder;
            String[] strArr = this.f10879d;
            if (i2 < strArr.length) {
                subSettingViewHolder.u.setText(strArr[i2]);
            }
            int i3 = this.f10881f;
            View view = subSettingViewHolder.v;
            View view2 = subSettingViewHolder.f11653a;
            if (i2 == i3) {
                view2.setSelected(true);
                view.setVisibility(0);
            } else {
                view2.setSelected(false);
                view.setVisibility(4);
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    PlayerControlView.PlaybackSpeedAdapter playbackSpeedAdapter = this.f10998a;
                    int i4 = playbackSpeedAdapter.f10881f;
                    int i5 = i2;
                    PlayerControlView playerControlView = PlayerControlView.this;
                    if (i5 != i4) {
                        playerControlView.setPlaybackSpeed(playbackSpeedAdapter.f10880e[i5]);
                    }
                    playerControlView.f10874k.dismiss();
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }
    }

    public interface ProgressUpdateListener {
        void a();
    }

    public final class SettingViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int y = 0;
        public final TextView u;
        public final TextView v;
        public final ImageView w;

        public SettingViewHolder(View view) {
            super(view);
            if (Util.f5744a < 26) {
                view.setFocusable(true);
            }
            this.u = (TextView) view.findViewById(R.id.exo_main_text);
            this.v = (TextView) view.findViewById(R.id.exo_sub_text);
            this.w = (ImageView) view.findViewById(R.id.exo_icon);
            view.setOnClickListener(new c(this, 1));
        }
    }

    public class SettingsAdapter extends RecyclerView.Adapter<SettingViewHolder> {

        /* renamed from: d, reason: collision with root package name */
        public final String[] f10883d;

        /* renamed from: e, reason: collision with root package name */
        public final String[] f10884e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable[] f10885f;

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.f10883d = strArr;
            this.f10884e = new String[strArr.length];
            this.f10885f = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int d() {
            return this.f10883d.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long e(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
            SettingViewHolder settingViewHolder = (SettingViewHolder) viewHolder;
            boolean zY = y(i2);
            View view = settingViewHolder.f11653a;
            if (zY) {
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                view.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            settingViewHolder.u.setText(this.f10883d[i2]);
            String str = this.f10884e[i2];
            TextView textView = settingViewHolder.v;
            if (str == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            Drawable drawable = this.f10885f[i2];
            ImageView imageView = settingViewHolder.w;
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
            PlayerControlView playerControlView = PlayerControlView.this;
            return playerControlView.new SettingViewHolder(LayoutInflater.from(playerControlView.getContext()).inflate(R.layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public final boolean y(int i2) {
            PlayerControlView playerControlView = PlayerControlView.this;
            Player player = playerControlView.S0;
            if (player == null) {
                return false;
            }
            return i2 != 0 ? i2 != 1 || (player.D1(30) && playerControlView.S0.D1(29)) : player.D1(13);
        }
    }

    public static class SubSettingViewHolder extends RecyclerView.ViewHolder {
        public final TextView u;
        public final View v;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Util.f5744a < 26) {
                view.setFocusable(true);
            }
            this.u = (TextView) view.findViewById(R.id.exo_text);
            this.v = view.findViewById(R.id.exo_check);
        }
    }

    public final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        public TextTrackSelectionAdapter() {
            super();
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public final void A(String str) {
        }

        public final void B(List list) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                TrackInformation trackInformation = (TrackInformation) list.get(i2);
                if (trackInformation.f10888a.f5557e[trackInformation.f10889b]) {
                    z = true;
                    break;
                }
                i2++;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            ImageView imageView = playerControlView.w;
            if (imageView != null) {
                imageView.setImageDrawable(z ? playerControlView.K0 : playerControlView.L0);
                playerControlView.w.setContentDescription(z ? playerControlView.M0 : playerControlView.N0);
            }
            this.f10891d = list;
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final void o(SubSettingViewHolder subSettingViewHolder, int i2) {
            super.o(subSettingViewHolder, i2);
            if (i2 > 0) {
                TrackInformation trackInformation = (TrackInformation) this.f10891d.get(i2 - 1);
                subSettingViewHolder.v.setVisibility(trackInformation.f10888a.f5557e[trackInformation.f10889b] ? 0 : 4);
            }
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public final void z(SubSettingViewHolder subSettingViewHolder) {
            subSettingViewHolder.u.setText(R.string.exo_track_selection_none);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f10891d.size()) {
                    break;
                }
                TrackInformation trackInformation = (TrackInformation) this.f10891d.get(i3);
                if (trackInformation.f10888a.f5557e[trackInformation.f10889b]) {
                    i2 = 4;
                    break;
                }
                i3++;
            }
            subSettingViewHolder.v.setVisibility(i2);
            subSettingViewHolder.f11653a.setOnClickListener(new c(this, 2));
        }
    }

    public static final class TrackInformation {

        /* renamed from: a, reason: collision with root package name */
        public final Tracks.Group f10888a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10889b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10890c;

        /* JADX WARN: Multi-variable type inference failed */
        public TrackInformation(Tracks tracks, int i2, int i3, String str) {
            this.f10888a = (Tracks.Group) tracks.f5548a.get(i2);
            this.f10889b = i3;
            this.f10890c = str;
        }
    }

    public abstract class TrackSelectionAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: d, reason: collision with root package name */
        public List f10891d = new ArrayList();

        public TrackSelectionAdapter() {
        }

        public abstract void A(String str);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int d() {
            if (this.f10891d.isEmpty()) {
                return 0;
            }
            return this.f10891d.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: y */
        public void o(SubSettingViewHolder subSettingViewHolder, int i2) {
            final Player player = PlayerControlView.this.S0;
            if (player == null) {
                return;
            }
            if (i2 == 0) {
                z(subSettingViewHolder);
                return;
            }
            final TrackInformation trackInformation = (TrackInformation) this.f10891d.get(i2 - 1);
            final TrackGroup trackGroup = trackInformation.f10888a.f5554b;
            boolean z = player.H0().A.get(trackGroup) != null && trackInformation.f10888a.f5557e[trackInformation.f10889b];
            subSettingViewHolder.u.setText(trackInformation.f10890c);
            subSettingViewHolder.v.setVisibility(z ? 0 : 4);
            subSettingViewHolder.f11653a.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.TrackSelectionAdapter trackSelectionAdapter = this.f11000a;
                    trackSelectionAdapter.getClass();
                    Player player2 = player;
                    if (player2.D1(29)) {
                        TrackSelectionParameters.Builder builderA = player2.H0().a();
                        PlayerControlView.TrackInformation trackInformation2 = trackInformation;
                        player2.m1(builderA.h(new TrackSelectionOverride(trackGroup, ImmutableList.t(Integer.valueOf(trackInformation2.f10889b)))).i(trackInformation2.f10888a.f5554b.f5503c).b());
                        trackSelectionAdapter.A(trackInformation2.f10890c);
                        PlayerControlView.this.f10874k.dismiss();
                    }
                }
            });
        }

        public abstract void z(SubSettingViewHolder subSettingViewHolder);
    }

    @Deprecated
    public interface VisibilityListener {
        void h(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
        k1 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void a(PlayerControlView playerControlView) {
        if (playerControlView.U0 == null) {
            return;
        }
        boolean z = playerControlView.V0;
        playerControlView.V0 = !z;
        String str = playerControlView.R0;
        Drawable drawable = playerControlView.P0;
        String str2 = playerControlView.Q0;
        Drawable drawable2 = playerControlView.O0;
        ImageView imageView = playerControlView.x;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else {
                imageView.setImageDrawable(drawable2);
                imageView.setContentDescription(str2);
            }
        }
        boolean z2 = playerControlView.V0;
        ImageView imageView2 = playerControlView.y;
        if (imageView2 != null) {
            if (z2) {
                imageView2.setImageDrawable(drawable2);
                imageView2.setContentDescription(str2);
            } else {
                imageView2.setImageDrawable(drawable);
                imageView2.setContentDescription(str);
            }
        }
        OnFullScreenModeChangedListener onFullScreenModeChangedListener = playerControlView.U0;
        if (onFullScreenModeChangedListener != null) {
            onFullScreenModeChangedListener.z(playerControlView.V0);
        }
    }

    public static boolean c(Player player, Timeline.Window window) {
        Timeline timelineF0;
        int iO;
        if (player.D1(17) && (iO = (timelineF0 = player.F0()).o()) > 1 && iO <= 100) {
            for (int i2 = 0; i2 < iO; i2++) {
                if (timelineF0.m(i2, window, 0L).f5498m != -9223372036854775807L) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        Player player = this.S0;
        if (player == null || !player.D1(13)) {
            return;
        }
        Player player2 = this.S0;
        player2.D(new PlaybackParameters(f2, player2.F().f5428b));
    }

    public final boolean d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.S0;
        if (player == null) {
            return false;
        }
        if (keyCode != 90 && keyCode != 89 && keyCode != 85 && keyCode != 79 && keyCode != 126 && keyCode != 127 && keyCode != 87 && keyCode != 88) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.u() == 4 || !player.D1(12)) {
                return true;
            }
            player.v1();
            return true;
        }
        if (keyCode == 89 && player.D1(11)) {
            player.w1();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Util.K(player, this.Y0);
            return true;
        }
        if (keyCode == 87) {
            if (!player.D1(9)) {
                return true;
            }
            player.I0();
            return true;
        }
        if (keyCode == 88) {
            if (!player.D1(7)) {
                return true;
            }
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
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e(RecyclerView.Adapter adapter, View view) {
        this.f10868e.setAdapter(adapter);
        q();
        this.j1 = false;
        PopupWindow popupWindow = this.f10874k;
        popupWindow.dismiss();
        this.j1 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i2 = this.f10875l;
        popupWindow.showAsDropDown(view, width - i2, (-popupWindow.getHeight()) - i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImmutableList f(Tracks tracks, int i2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = tracks.f5548a;
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            Tracks.Group group = (Tracks.Group) immutableList.get(i3);
            if (group.f5554b.f5503c == i2) {
                for (int i4 = 0; i4 < group.f5553a; i4++) {
                    if (group.b(i4)) {
                        Format formatA = group.a(i4);
                        if ((formatA.f5217e & 2) == 0) {
                            builder.h(new TrackInformation(tracks, i3, i4, this.f10873j.a(formatA)));
                        }
                    }
                }
            }
        }
        return builder.j();
    }

    public final void g() {
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.f10864a;
        int i2 = playerControlViewLayoutManager.z;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        playerControlViewLayoutManager.f();
        if (!playerControlViewLayoutManager.C) {
            playerControlViewLayoutManager.i(2);
        } else if (playerControlViewLayoutManager.z == 1) {
            playerControlViewLayoutManager.f10905m.start();
        } else {
            playerControlViewLayoutManager.n.start();
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.S0;
    }

    public int getRepeatToggleModes() {
        return this.d1;
    }

    public boolean getShowShuffleButton() {
        return this.f10864a.b(this.u);
    }

    public boolean getShowSubtitleButton() {
        return this.f10864a.b(this.w);
    }

    public int getShowTimeoutMs() {
        return this.b1;
    }

    public boolean getShowVrButton() {
        return this.f10864a.b(this.v);
    }

    public final boolean h() {
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.f10864a;
        return playerControlViewLayoutManager.z == 0 && playerControlViewLayoutManager.f10893a.i();
    }

    public final boolean i() {
        return getVisibility() == 0;
    }

    public final void j() {
        m();
        l();
        p();
        r();
        t();
        n();
        s();
    }

    public final void k(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.G0 : this.H0);
    }

    public final void l() {
        boolean zD1;
        boolean zD12;
        boolean zD13;
        boolean zD14;
        boolean zD15;
        if (i() && this.W0) {
            Player player = this.S0;
            if (player != null) {
                zD1 = (this.X0 && c(player, this.I)) ? player.D1(10) : player.D1(5);
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
            Resources resources = this.f10865b;
            View view = this.q;
            if (zD14) {
                Player player2 = this.S0;
                int iA1 = (int) ((player2 != null ? player2.A1() : 5000L) / 1000);
                TextView textView = this.s;
                if (textView != null) {
                    textView.setText(String.valueOf(iA1));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, iA1, Integer.valueOf(iA1)));
                }
            }
            View view2 = this.p;
            if (zD15) {
                Player player3 = this.S0;
                int iE1 = (int) ((player3 != null ? player3.e1() : 15000L) / 1000);
                TextView textView2 = this.r;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(iE1));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, iE1, Integer.valueOf(iE1)));
                }
            }
            k(this.f10876m, zD13);
            k(view, zD14);
            k(view2, zD15);
            k(this.n, zD12);
            TimeBar timeBar = this.E;
            if (timeBar != null) {
                timeBar.setEnabled(zD1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r4 = this;
            boolean r0 = r4.i()
            if (r0 == 0) goto L57
            boolean r0 = r4.W0
            if (r0 != 0) goto Lb
            goto L57
        Lb:
            android.widget.ImageView r0 = r4.o
            if (r0 == 0) goto L57
            androidx.media3.common.Player r1 = r4.S0
            boolean r2 = r4.Y0
            boolean r1 = androidx.media3.common.util.Util.e0(r1, r2)
            if (r1 == 0) goto L1c
            android.graphics.drawable.Drawable r2 = r4.K
            goto L1e
        L1c:
            android.graphics.drawable.Drawable r2 = r4.L
        L1e:
            if (r1 == 0) goto L23
            int r1 = androidx.media3.ui.R.string.exo_controls_play_description
            goto L25
        L23:
            int r1 = androidx.media3.ui.R.string.exo_controls_pause_description
        L25:
            r0.setImageDrawable(r2)
            android.content.res.Resources r2 = r4.f10865b
            java.lang.String r1 = r2.getString(r1)
            r0.setContentDescription(r1)
            androidx.media3.common.Player r1 = r4.S0
            if (r1 == 0) goto L53
            r2 = 1
            boolean r1 = r1.D1(r2)
            if (r1 == 0) goto L53
            androidx.media3.common.Player r1 = r4.S0
            r3 = 17
            boolean r1 = r1.D1(r3)
            if (r1 == 0) goto L54
            androidx.media3.common.Player r1 = r4.S0
            androidx.media3.common.Timeline r1 = r1.F0()
            boolean r1 = r1.p()
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            r4.k(r0, r2)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerControlView.m():void");
    }

    public final void n() {
        PlaybackSpeedAdapter playbackSpeedAdapter;
        Player player = this.S0;
        if (player == null) {
            return;
        }
        float f2 = player.F().f5427a;
        float f3 = Float.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            playbackSpeedAdapter = this.f10870g;
            float[] fArr = playbackSpeedAdapter.f10880e;
            if (i2 >= fArr.length) {
                break;
            }
            float fAbs = Math.abs(f2 - fArr[i2]);
            if (fAbs < f3) {
                i3 = i2;
                f3 = fAbs;
            }
            i2++;
        }
        playbackSpeedAdapter.f10881f = i3;
        String str = playbackSpeedAdapter.f10879d[i3];
        SettingsAdapter settingsAdapter = this.f10869f;
        settingsAdapter.f10884e[0] = str;
        k(this.z, settingsAdapter.y(1) || settingsAdapter.y(0));
    }

    public final void o() {
        long jF1;
        long jT1;
        if (i() && this.W0) {
            Player player = this.S0;
            if (player == null || !player.D1(16)) {
                jF1 = 0;
                jT1 = 0;
            } else {
                jF1 = player.f1() + this.i1;
                jT1 = player.t1() + this.i1;
            }
            TextView textView = this.D;
            if (textView != null && !this.a1) {
                textView.setText(Util.E(this.F, this.G, jF1));
            }
            TimeBar timeBar = this.E;
            if (timeBar != null) {
                timeBar.setPosition(jF1);
                timeBar.setBufferedPosition(jT1);
            }
            ProgressUpdateListener progressUpdateListener = this.T0;
            if (progressUpdateListener != null) {
                progressUpdateListener.a();
            }
            a aVar = this.J;
            removeCallbacks(aVar);
            int iU = player == null ? 1 : player.u();
            if (player != null && player.j1()) {
                long jMin = Math.min(timeBar != null ? timeBar.getPreferredUpdateDelay() : 1000L, 1000 - (jF1 % 1000));
                float f2 = player.F().f5427a;
                postDelayed(aVar, Util.l(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.c1, 1000L));
            } else {
                if (iU == 4 || iU == 1) {
                    return;
                }
                postDelayed(aVar, 1000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.f10864a;
        playerControlViewLayoutManager.f10893a.addOnLayoutChangeListener(playerControlViewLayoutManager.x);
        this.W0 = true;
        if (h()) {
            playerControlViewLayoutManager.g();
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.f10864a;
        playerControlViewLayoutManager.f10893a.removeOnLayoutChangeListener(playerControlViewLayoutManager.x);
        this.W0 = false;
        removeCallbacks(this.J);
        playerControlViewLayoutManager.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f10864a.f10894b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public final void p() {
        ImageView imageView;
        if (i() && this.W0 && (imageView = this.t) != null) {
            if (this.d1 == 0) {
                k(imageView, false);
                return;
            }
            Player player = this.S0;
            String str = this.B0;
            Drawable drawable = this.M;
            if (player == null || !player.D1(15)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            int iG = player.G();
            if (iG == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (iG == 1) {
                imageView.setImageDrawable(this.Q);
                imageView.setContentDescription(this.C0);
            } else {
                if (iG != 2) {
                    return;
                }
                imageView.setImageDrawable(this.A0);
                imageView.setContentDescription(this.D0);
            }
        }
    }

    public final void q() {
        RecyclerView recyclerView = this.f10868e;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i2 = this.f10875l;
        int iMin = Math.min(recyclerView.getMeasuredWidth(), width - (i2 * 2));
        PopupWindow popupWindow = this.f10874k;
        popupWindow.setWidth(iMin);
        popupWindow.setHeight(Math.min(getHeight() - (i2 * 2), recyclerView.getMeasuredHeight()));
    }

    public final void r() {
        ImageView imageView;
        if (i() && this.W0 && (imageView = this.u) != null) {
            Player player = this.S0;
            if (!this.f10864a.b(imageView)) {
                k(imageView, false);
                return;
            }
            String str = this.J0;
            Drawable drawable = this.F0;
            if (player == null || !player.D1(14)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            if (player.s1()) {
                drawable = this.E0;
            }
            imageView.setImageDrawable(drawable);
            if (player.s1()) {
                str = this.I0;
            }
            imageView.setContentDescription(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerControlView.s():void");
    }

    public void setAnimationEnabled(boolean z) {
        this.f10864a.C = z;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        this.U0 = onFullScreenModeChangedListener;
        boolean z = onFullScreenModeChangedListener != null;
        ImageView imageView = this.x;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z2 = onFullScreenModeChangedListener != null;
        ImageView imageView2 = this.y;
        if (imageView2 == null) {
            return;
        }
        if (z2) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(@Nullable Player player) {
        Assertions.g(Looper.myLooper() == Looper.getMainLooper());
        Assertions.a(player == null || player.F1() == Looper.getMainLooper());
        Player player2 = this.S0;
        if (player2 == player) {
            return;
        }
        ComponentListener componentListener = this.f10866c;
        if (player2 != null) {
            player2.A0(componentListener);
        }
        this.S0 = player;
        if (player != null) {
            player.D0(componentListener);
        }
        j();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.T0 = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.d1 = i2;
        Player player = this.S0;
        if (player != null && player.D1(15)) {
            int iG = this.S0.G();
            if (i2 == 0 && iG != 0) {
                this.S0.d0(0);
            } else if (i2 == 1 && iG == 2) {
                this.S0.d0(1);
            } else if (i2 == 2 && iG == 1) {
                this.S0.d0(2);
            }
        }
        this.f10864a.h(this.t, i2 != 0);
        p();
    }

    public void setShowFastForwardButton(boolean z) {
        this.f10864a.h(this.p, z);
        l();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.X0 = z;
        s();
    }

    public void setShowNextButton(boolean z) {
        this.f10864a.h(this.n, z);
        l();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.Y0 = z;
        m();
    }

    public void setShowPreviousButton(boolean z) {
        this.f10864a.h(this.f10876m, z);
        l();
    }

    public void setShowRewindButton(boolean z) {
        this.f10864a.h(this.q, z);
        l();
    }

    public void setShowShuffleButton(boolean z) {
        this.f10864a.h(this.u, z);
        r();
    }

    public void setShowSubtitleButton(boolean z) {
        this.f10864a.h(this.w, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.b1 = i2;
        if (h()) {
            this.f10864a.g();
        }
    }

    public void setShowVrButton(boolean z) {
        this.f10864a.h(this.v, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.c1 = Util.k(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            k(imageView, onClickListener != null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        TextTrackSelectionAdapter textTrackSelectionAdapter = this.f10871h;
        textTrackSelectionAdapter.getClass();
        List list = Collections.EMPTY_LIST;
        textTrackSelectionAdapter.f10891d = list;
        AudioTrackSelectionAdapter audioTrackSelectionAdapter = this.f10872i;
        audioTrackSelectionAdapter.getClass();
        audioTrackSelectionAdapter.f10891d = list;
        Player player = this.S0;
        ImageView imageView = this.w;
        if (player != null && player.D1(30) && this.S0.D1(29)) {
            Tracks tracksY0 = this.S0.y0();
            ImmutableList immutableListF = f(tracksY0, 1);
            audioTrackSelectionAdapter.f10891d = immutableListF;
            PlayerControlView playerControlView = PlayerControlView.this;
            Player player2 = playerControlView.S0;
            player2.getClass();
            TrackSelectionParameters trackSelectionParametersH0 = player2.H0();
            boolean zIsEmpty = immutableListF.isEmpty();
            SettingsAdapter settingsAdapter = playerControlView.f10869f;
            if (!zIsEmpty) {
                if (audioTrackSelectionAdapter.B(trackSelectionParametersH0)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= immutableListF.size()) {
                            break;
                        }
                        TrackInformation trackInformation = (TrackInformation) immutableListF.get(i2);
                        if (trackInformation.f10888a.f5557e[trackInformation.f10889b]) {
                            settingsAdapter.f10884e[1] = trackInformation.f10890c;
                            break;
                        }
                        i2++;
                    }
                } else {
                    settingsAdapter.f10884e[1] = playerControlView.getResources().getString(R.string.exo_track_selection_auto);
                }
            } else {
                settingsAdapter.f10884e[1] = playerControlView.getResources().getString(R.string.exo_track_selection_none);
            }
            if (this.f10864a.b(imageView)) {
                textTrackSelectionAdapter.B(f(tracksY0, 3));
            } else {
                textTrackSelectionAdapter.B(ImmutableList.r());
            }
        }
        k(imageView, textTrackSelectionAdapter.d() > 0);
        SettingsAdapter settingsAdapter2 = this.f10869f;
        k(this.z, settingsAdapter2.y(1) || settingsAdapter2.y(0));
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) throws Throwable {
        int i3;
        PlayerControlView playerControlView;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z7;
        int i18;
        int i19;
        boolean z8;
        Context context2;
        boolean z9;
        int i20;
        boolean z10;
        boolean z11;
        int i21;
        int i22;
        PlayerControlView playerControlView2;
        TextView textView;
        boolean z12;
        int i23;
        boolean z13;
        super(context, attributeSet, i2);
        int i24 = R.layout.exo_player_control_view;
        int i25 = R.drawable.exo_styled_controls_play;
        int i26 = R.drawable.exo_styled_controls_pause;
        int i27 = R.drawable.exo_styled_controls_next;
        int i28 = R.drawable.exo_styled_controls_simple_fastforward;
        int i29 = R.drawable.exo_styled_controls_previous;
        int i30 = R.drawable.exo_styled_controls_simple_rewind;
        int i31 = R.drawable.exo_styled_controls_fullscreen_exit;
        int i32 = R.drawable.exo_styled_controls_fullscreen_enter;
        int i33 = R.drawable.exo_styled_controls_repeat_off;
        int i34 = R.drawable.exo_styled_controls_repeat_one;
        int i35 = R.drawable.exo_styled_controls_repeat_all;
        int i36 = R.drawable.exo_styled_controls_shuffle_on;
        int i37 = R.drawable.exo_styled_controls_shuffle_off;
        int i38 = R.drawable.exo_styled_controls_subtitle_on;
        int i39 = R.drawable.exo_styled_controls_subtitle_off;
        int i40 = R.drawable.exo_styled_controls_vr;
        this.Y0 = true;
        this.b1 = 5000;
        this.d1 = 0;
        this.c1 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, i2, 0);
            try {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, i24);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_play_icon, i25);
                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_pause_icon, i26);
                int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_next_icon, i27);
                int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_fastforward_icon, i28);
                int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_previous_icon, i29);
                int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_rewind_icon, i30);
                int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_fullscreen_exit_icon, i31);
                int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_fullscreen_enter_icon, i32);
                int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_repeat_off_icon, i33);
                int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_repeat_one_icon, i34);
                int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_repeat_all_icon, i35);
                int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_shuffle_on_icon, i36);
                int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_shuffle_off_icon, i37);
                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_subtitle_on_icon, i38);
                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_subtitle_off_icon, i39);
                int resourceId17 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_vr_icon, i40);
                playerControlView = this;
                try {
                    playerControlView.b1 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, playerControlView.b1);
                    playerControlView.d1 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, playerControlView.d1);
                    boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_rewind_button, true);
                    boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_fastforward_button, true);
                    boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_previous_button, true);
                    boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_next_button, true);
                    boolean z18 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, false);
                    boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_subtitle_button, false);
                    boolean z20 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_vr_button, false);
                    playerControlView.setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, playerControlView.c1));
                    boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_animation_enabled, true);
                    typedArrayObtainStyledAttributes.recycle();
                    z6 = z21;
                    i8 = resourceId11;
                    i9 = resourceId12;
                    i10 = resourceId13;
                    i12 = resourceId14;
                    i6 = resourceId15;
                    i13 = resourceId16;
                    i11 = resourceId4;
                    i4 = resourceId17;
                    z = z14;
                    z3 = z18;
                    z4 = z19;
                    z5 = z20;
                    i3 = resourceId2;
                    i5 = resourceId;
                    i14 = resourceId5;
                    i15 = resourceId6;
                    i7 = resourceId7;
                    i16 = resourceId9;
                    i17 = resourceId10;
                    z2 = z15;
                    z7 = z17;
                    i18 = resourceId3;
                    i19 = resourceId8;
                    z8 = z16;
                } catch (Throwable th) {
                    th = th;
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            i3 = i25;
            playerControlView = this;
            i4 = i40;
            i5 = i24;
            i6 = i38;
            i7 = i30;
            i8 = i34;
            i9 = i35;
            i10 = i36;
            i11 = i27;
            i12 = i37;
            i13 = i39;
            z = true;
            z2 = true;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = true;
            i14 = i28;
            i15 = i29;
            i16 = i32;
            i17 = i33;
            z7 = true;
            i18 = i26;
            i19 = i31;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(i5, playerControlView);
        playerControlView.setDescendantFocusability(262144);
        ComponentListener componentListener = playerControlView.new ComponentListener();
        playerControlView.f10866c = componentListener;
        playerControlView.f10867d = new CopyOnWriteArrayList();
        playerControlView.H = new Timeline.Period();
        playerControlView.I = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        playerControlView.F = sb;
        int i41 = i19;
        int i42 = i16;
        playerControlView.G = new Formatter(sb, Locale.getDefault());
        playerControlView.e1 = new long[0];
        playerControlView.f1 = new boolean[0];
        playerControlView.g1 = new long[0];
        playerControlView.h1 = new boolean[0];
        playerControlView.J = new a(1, playerControlView);
        playerControlView.C = (TextView) playerControlView.findViewById(R.id.exo_duration);
        playerControlView.D = (TextView) playerControlView.findViewById(R.id.exo_position);
        ImageView imageView = (ImageView) playerControlView.findViewById(R.id.exo_subtitle);
        playerControlView.w = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) playerControlView.findViewById(R.id.exo_fullscreen);
        playerControlView.x = imageView2;
        c cVar = new c(playerControlView, 4);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            imageView2.setOnClickListener(cVar);
        }
        ImageView imageView3 = (ImageView) playerControlView.findViewById(R.id.exo_minimal_fullscreen);
        playerControlView.y = imageView3;
        c cVar2 = new c(playerControlView, 4);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(cVar2);
        }
        View viewFindViewById = playerControlView.findViewById(R.id.exo_settings);
        playerControlView.z = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(componentListener);
        }
        View viewFindViewById2 = playerControlView.findViewById(R.id.exo_playback_speed);
        playerControlView.A = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
        }
        View viewFindViewById3 = playerControlView.findViewById(R.id.exo_audio_track);
        playerControlView.B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
        }
        TimeBar timeBar = (TimeBar) playerControlView.findViewById(R.id.exo_progress);
        View viewFindViewById4 = playerControlView.findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            playerControlView.E = timeBar;
            context2 = context;
            z9 = z;
            i20 = i17;
            z10 = z2;
            z11 = z7;
            i21 = i42;
            i22 = i41;
            playerControlView2 = playerControlView;
            textView = null;
            z12 = z8;
            i23 = i7;
        } else if (viewFindViewById4 != null) {
            z10 = z2;
            textView = null;
            z11 = z7;
            i21 = i42;
            i20 = i17;
            playerControlView2 = this;
            z9 = z;
            z12 = z8;
            i23 = i7;
            i22 = i41;
            context2 = context;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context2, null, 0, attributeSet2, R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(R.id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            playerControlView2.E = defaultTimeBar;
        } else {
            context2 = context;
            z9 = z;
            i20 = i17;
            z10 = z2;
            z11 = z7;
            i21 = i42;
            i22 = i41;
            playerControlView2 = playerControlView;
            textView = null;
            z12 = z8;
            i23 = i7;
            playerControlView2.E = null;
        }
        TimeBar timeBar2 = playerControlView2.E;
        if (timeBar2 != null) {
            timeBar2.a(componentListener);
        }
        Resources resources = context2.getResources();
        playerControlView2.f10865b = resources;
        ImageView imageView4 = (ImageView) playerControlView2.findViewById(R.id.exo_play_pause);
        playerControlView2.o = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(componentListener);
        }
        ImageView imageView5 = (ImageView) playerControlView2.findViewById(R.id.exo_prev);
        playerControlView2.f10876m = imageView5;
        if (imageView5 != null) {
            imageView5.setImageDrawable(Util.v(context2, resources, i15));
            imageView5.setOnClickListener(componentListener);
        }
        ImageView imageView6 = (ImageView) playerControlView2.findViewById(R.id.exo_next);
        playerControlView2.n = imageView6;
        if (imageView6 != null) {
            imageView6.setImageDrawable(Util.v(context2, resources, i11));
            imageView6.setOnClickListener(componentListener);
        }
        Typeface typefaceE = ResourcesCompat.e(R.font.roboto_medium_numbers, context2);
        ImageView imageView7 = (ImageView) playerControlView2.findViewById(R.id.exo_rew);
        TextView textView2 = (TextView) playerControlView2.findViewById(R.id.exo_rew_with_amount);
        if (imageView7 != null) {
            imageView7.setImageDrawable(Util.v(context2, resources, i23));
            playerControlView2.q = imageView7;
            playerControlView2.s = textView;
        } else if (textView2 != null) {
            textView2.setTypeface(typefaceE);
            playerControlView2.s = textView2;
            playerControlView2.q = textView2;
        } else {
            playerControlView2.s = textView;
            playerControlView2.q = textView;
        }
        View view = playerControlView2.q;
        if (view != null) {
            view.setOnClickListener(componentListener);
        }
        ImageView imageView8 = (ImageView) playerControlView2.findViewById(R.id.exo_ffwd);
        TextView textView3 = (TextView) playerControlView2.findViewById(R.id.exo_ffwd_with_amount);
        if (imageView8 != null) {
            imageView8.setImageDrawable(Util.v(context2, resources, i14));
            playerControlView2.p = imageView8;
            playerControlView2.r = textView;
        } else if (textView3 != null) {
            textView3.setTypeface(typefaceE);
            playerControlView2.r = textView3;
            playerControlView2.p = textView3;
        } else {
            playerControlView2.r = textView;
            playerControlView2.p = textView;
        }
        View view2 = playerControlView2.p;
        if (view2 != null) {
            view2.setOnClickListener(componentListener);
        }
        ImageView imageView9 = (ImageView) playerControlView2.findViewById(R.id.exo_repeat_toggle);
        playerControlView2.t = imageView9;
        if (imageView9 != null) {
            imageView9.setOnClickListener(componentListener);
        }
        ImageView imageView10 = (ImageView) playerControlView2.findViewById(R.id.exo_shuffle);
        playerControlView2.u = imageView10;
        if (imageView10 != null) {
            imageView10.setOnClickListener(componentListener);
        }
        playerControlView2.G0 = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        playerControlView2.H0 = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        ImageView imageView11 = (ImageView) playerControlView2.findViewById(R.id.exo_vr);
        playerControlView2.v = imageView11;
        if (imageView11 != null) {
            imageView11.setImageDrawable(Util.v(context2, resources, i4));
            playerControlView2.k(imageView11, false);
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = new PlayerControlViewLayoutManager(playerControlView2);
        playerControlView2.f10864a = playerControlViewLayoutManager;
        playerControlViewLayoutManager.C = z6;
        SettingsAdapter settingsAdapter = playerControlView2.new SettingsAdapter(new String[]{resources.getString(R.string.exo_controls_playback_speed), resources.getString(R.string.exo_track_selection_title_audio)}, new Drawable[]{Util.v(context2, resources, R.drawable.exo_styled_controls_speed), Util.v(context2, resources, R.drawable.exo_styled_controls_audiotrack)});
        playerControlView2.f10869f = settingsAdapter;
        playerControlView2.f10875l = resources.getDimensionPixelSize(R.dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context2).inflate(R.layout.exo_styled_settings_list, (ViewGroup) null);
        playerControlView2.f10868e = recyclerView;
        recyclerView.setAdapter(settingsAdapter);
        playerControlView2.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        playerControlView2.f10874k = popupWindow;
        if (Util.f5744a < 23) {
            z13 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z13 = false;
        }
        popupWindow.setOnDismissListener(componentListener);
        playerControlView2.j1 = true;
        playerControlView2.f10873j = new DefaultTrackNameProvider(playerControlView2.getResources());
        playerControlView2.K0 = Util.v(context2, resources, i6);
        playerControlView2.L0 = Util.v(context2, resources, i13);
        playerControlView2.M0 = resources.getString(R.string.exo_controls_cc_enabled_description);
        playerControlView2.N0 = resources.getString(R.string.exo_controls_cc_disabled_description);
        playerControlView2.f10871h = playerControlView2.new TextTrackSelectionAdapter();
        playerControlView2.f10872i = playerControlView2.new AudioTrackSelectionAdapter();
        playerControlView2.f10870g = playerControlView2.new PlaybackSpeedAdapter(resources.getStringArray(R.array.exo_controls_playback_speeds), k1);
        playerControlView2.K = Util.v(context2, resources, i3);
        playerControlView2.L = Util.v(context2, resources, i18);
        playerControlView2.O0 = Util.v(context2, resources, i22);
        playerControlView2.P0 = Util.v(context2, resources, i21);
        playerControlView2.M = Util.v(context2, resources, i20);
        playerControlView2.Q = Util.v(context2, resources, i8);
        playerControlView2.A0 = Util.v(context2, resources, i9);
        playerControlView2.E0 = Util.v(context2, resources, i10);
        playerControlView2.F0 = Util.v(context2, resources, i12);
        playerControlView2.Q0 = resources.getString(R.string.exo_controls_fullscreen_exit_description);
        playerControlView2.R0 = resources.getString(R.string.exo_controls_fullscreen_enter_description);
        playerControlView2.B0 = resources.getString(R.string.exo_controls_repeat_off_description);
        playerControlView2.C0 = resources.getString(R.string.exo_controls_repeat_one_description);
        playerControlView2.D0 = resources.getString(R.string.exo_controls_repeat_all_description);
        playerControlView2.I0 = resources.getString(R.string.exo_controls_shuffle_on_description);
        playerControlView2.J0 = resources.getString(R.string.exo_controls_shuffle_off_description);
        playerControlViewLayoutManager.h((ViewGroup) playerControlView2.findViewById(R.id.exo_bottom_bar), true);
        playerControlViewLayoutManager.h(playerControlView2.p, z10);
        playerControlViewLayoutManager.h(playerControlView2.q, z9);
        playerControlViewLayoutManager.h(imageView5, z12);
        playerControlViewLayoutManager.h(imageView6, z11);
        playerControlViewLayoutManager.h(imageView10, z3);
        playerControlViewLayoutManager.h(playerControlView2.w, z4);
        playerControlViewLayoutManager.h(imageView11, z5);
        playerControlViewLayoutManager.h(imageView9, playerControlView2.d1 != 0 ? true : z13);
        playerControlView2.addOnLayoutChangeListener(new h(playerControlView2, 1));
    }
}
