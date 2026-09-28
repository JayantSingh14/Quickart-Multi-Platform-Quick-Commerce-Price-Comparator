package com.brentvatne.exoplayer;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.SubtitleView;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.api.ViewType;
import com.brentvatne.common.toolbox.DebugLog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@UnstableApi
/* loaded from: classes3.dex */
public final class ExoPlayerView extends FrameLayout implements AdViewProvider {
    public static final /* synthetic */ int o = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f15530a;

    /* renamed from: b, reason: collision with root package name */
    public View f15531b;

    /* renamed from: c, reason: collision with root package name */
    public final View f15532c;

    /* renamed from: d, reason: collision with root package name */
    public final SubtitleView f15533d;

    /* renamed from: e, reason: collision with root package name */
    public final AspectRatioFrameLayout f15534e;

    /* renamed from: f, reason: collision with root package name */
    public final ComponentListener f15535f;

    /* renamed from: g, reason: collision with root package name */
    public ExoPlayer f15536g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewGroup.LayoutParams f15537h;

    /* renamed from: i, reason: collision with root package name */
    public FrameLayout f15538i;

    /* renamed from: j, reason: collision with root package name */
    public int f15539j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15540k;

    /* renamed from: l, reason: collision with root package name */
    public SubtitleStyle f15541l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15542m;
    public final k n;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class ComponentListener implements Player.Listener {
        public ComponentListener() {
        }

        @Override // androidx.media3.common.Player.Listener
        public final void E1(Tracks tracks) {
            Intrinsics.checkNotNullParameter(tracks, "tracks");
            ExoPlayerView.a(ExoPlayerView.this, tracks);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void b(VideoSize videoSize) {
            ExoPlayerView exoPlayerView;
            ExoPlayer exoPlayer;
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            if (videoSize.f5565b == 0 || videoSize.f5564a == 0 || (exoPlayer = (exoPlayerView = ExoPlayerView.this).f15536g) == null) {
                return;
            }
            ExoPlayerView.a(exoPlayerView, exoPlayer.y0());
        }

        @Override // androidx.media3.common.Player.Listener
        public final void k(List cues) {
            Intrinsics.checkNotNullParameter(cues, "cues");
            ExoPlayerView.this.f15533d.setCues(cues);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void q1() {
            ExoPlayerView.this.f15532c.setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoPlayerView(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15530a = context;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f15537h = layoutParams;
        this.f15539j = 1;
        this.f15541l = new SubtitleStyle();
        this.f15535f = new ComponentListener();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        Intrinsics.checkNotNullParameter(context, "context");
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
        this.f15534e = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setLayoutParams(layoutParams2);
        View view = new View(context);
        this.f15532c = view;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(context.getColor(R.color.black));
        SubtitleView subtitleView = new SubtitleView(context, null);
        this.f15533d = subtitleView;
        subtitleView.setLayoutParams(layoutParams);
        subtitleView.a();
        subtitleView.b();
        f(this.f15539j);
        aspectRatioFrameLayout.addView(view, 1, layoutParams);
        if (this.f15541l.f15414f) {
            aspectRatioFrameLayout.addView(subtitleView, layoutParams);
        }
        addViewInLayout(aspectRatioFrameLayout, 0, layoutParams2);
        if (!this.f15541l.f15414f) {
            addViewInLayout(subtitleView, 1, layoutParams);
        }
        this.n = new k(this, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(ExoPlayerView exoPlayerView, Tracks tracks) {
        exoPlayerView.getClass();
        if (tracks == null) {
            return;
        }
        ImmutableList immutableList = tracks.f5548a;
        Intrinsics.checkNotNullExpressionValue(immutableList, "getGroups(...)");
        UnmodifiableListIterator unmodifiableListIteratorListIterator = immutableList.listIterator(0);
        Intrinsics.checkNotNullExpressionValue(unmodifiableListIteratorListIterator, "iterator(...)");
        while (unmodifiableListIteratorListIterator.hasNext()) {
            Tracks.Group group = (Tracks.Group) unmodifiableListIteratorListIterator.next();
            if (group.f5554b.f5503c == 2 && group.f5553a > 0) {
                Format format = group.a(0);
                Intrinsics.checkNotNullExpressionValue(format, "getTrackFormat(...)");
                int i2 = format.s;
                int i3 = format.t;
                if (i2 > 0 || i3 > 0) {
                    AspectRatioFrameLayout aspectRatioFrameLayout = exoPlayerView.f15534e;
                    aspectRatioFrameLayout.getClass();
                    Intrinsics.checkNotNullParameter(format, "format");
                    int i4 = format.v;
                    float f2 = format.w;
                    int i5 = format.s;
                    if (i4 == 90 || i4 == 270) {
                        aspectRatioFrameLayout.setVideoAspectRatio(i5 != 0 ? (i3 * f2) / i5 : 1.0f);
                        return;
                    } else {
                        aspectRatioFrameLayout.setVideoAspectRatio(i3 != 0 ? (i5 * f2) / i3 : 1.0f);
                        return;
                    }
                }
                return;
            }
        }
        exoPlayerView.e();
    }

    @ViewType.InterfaceC0018ViewType
    private static /* synthetic */ void getViewType$annotations() {
    }

    public final void b() {
        if (this.f15542m) {
            this.f15534e.removeView(this.f15538i);
            this.f15538i = null;
            this.f15542m = false;
        }
    }

    public final void c() {
        View view = this.f15531b;
        if (view instanceof TextureView) {
            ExoPlayer exoPlayer = this.f15536g;
            if (exoPlayer != null) {
                exoPlayer.J0((TextureView) view);
                return;
            }
            return;
        }
        if (!(view instanceof SurfaceView)) {
            android.support.v4.media.b.A("Unexpected surfaceView type: ", view != null ? view.getClass().getName() : null, "setVideoView");
            return;
        }
        ExoPlayer exoPlayer2 = this.f15536g;
        if (exoPlayer2 != null) {
            exoPlayer2.o0((SurfaceView) view);
        }
    }

    public final void d() {
        if (this.f15542m) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.f15530a);
        this.f15538i = frameLayout;
        this.f15534e.addView(frameLayout, this.f15537h);
        this.f15542m = true;
    }

    public final void e() {
        this.f15532c.setVisibility(this.f15540k ? 4 : 0);
    }

    public final void f(int i2) {
        boolean z;
        this.f15539j = i2;
        Context context = this.f15530a;
        if (i2 == 0) {
            if (this.f15531b instanceof TextureView) {
                z = false;
            } else {
                this.f15531b = new TextureView(context);
            }
            View view = this.f15531b;
            Intrinsics.d(view, "null cannot be cast to non-null type android.view.TextureView");
            ((TextureView) view).setOpaque(false);
            z = z;
        } else if (i2 == 1 || i2 == 2) {
            if (this.f15531b instanceof SurfaceView) {
                z = false;
            } else {
                this.f15531b = new SurfaceView(context);
                z = true;
            }
            View view2 = this.f15531b;
            Intrinsics.d(view2, "null cannot be cast to non-null type android.view.SurfaceView");
            ((SurfaceView) view2).setSecure(i2 == 2);
        } else {
            String msg = "Unexpected texture view type: " + i2;
            Intrinsics.checkNotNullParameter("ExoPlayerView", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.wtf("RNV".concat("ExoPlayerView"), "--------------->" + DebugLog.c(msg));
            if (DebugLog.f15509a <= 2) {
                new Exception().printStackTrace();
            }
            z = false;
        }
        if (z) {
            View view3 = this.f15531b;
            ViewGroup.LayoutParams layoutParams = this.f15537h;
            if (view3 != null) {
                view3.setLayoutParams(layoutParams);
            }
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f15534e;
            if (aspectRatioFrameLayout.getChildAt(0) != null) {
                aspectRatioFrameLayout.removeViewAt(0);
            }
            aspectRatioFrameLayout.addView(this.f15531b, 0, layoutParams);
            if (this.f15536g != null) {
                c();
            }
        }
    }

    @Override // androidx.media3.common.AdViewProvider
    public List getAdOverlayInfos() {
        return ImmutableList.r();
    }

    @Override // androidx.media3.common.AdViewProvider
    @NotNull
    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f15538i;
        Assertions.e(frameLayout, "exo_ad_overlay must be present for ad playback");
        Intrinsics.checkNotNullExpressionValue(frameLayout, "checkNotNull(...)");
        return frameLayout;
    }

    public final boolean getAdsShown() {
        return this.f15542m;
    }

    @Nullable
    public final View getSurfaceView() {
        return this.f15531b;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        post(this.n);
    }

    public final void setAdsShown(boolean z) {
        this.f15542m = z;
    }

    public final void setHideShutterView(boolean z) {
        this.f15540k = z;
        e();
    }

    public final void setPlayer(@Nullable ExoPlayer exoPlayer) {
        if (Intrinsics.b(this.f15536g, exoPlayer)) {
            return;
        }
        ExoPlayer exoPlayer2 = this.f15536g;
        ComponentListener componentListener = this.f15535f;
        if (exoPlayer2 != null) {
            exoPlayer2.A0(componentListener);
            View view = this.f15531b;
            if (view instanceof TextureView) {
                ExoPlayer exoPlayer3 = this.f15536g;
                if (exoPlayer3 != null) {
                    exoPlayer3.U0((TextureView) view);
                }
            } else if (view instanceof SurfaceView) {
                ExoPlayer exoPlayer4 = this.f15536g;
                if (exoPlayer4 != null) {
                    exoPlayer4.n1((SurfaceView) view);
                }
            } else {
                android.support.v4.media.b.A("Unexpected surfaceView type: ", view != null ? view.getClass().getName() : null, "clearVideoView");
            }
        }
        this.f15536g = exoPlayer;
        e();
        if (exoPlayer != null) {
            c();
            exoPlayer.D0(componentListener);
        }
    }

    public final void setResizeMode(int i2) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f15534e;
        if (aspectRatioFrameLayout.getResizeMode() != i2) {
            aspectRatioFrameLayout.setResizeMode(i2);
            post(this.n);
        }
    }

    public final void setShutterColor(int i2) {
        this.f15532c.setBackgroundColor(i2);
    }

    public final void setSubtitleStyle(@NotNull SubtitleStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        SubtitleView subtitleView = this.f15533d;
        subtitleView.a();
        subtitleView.b();
        int i2 = style.f15409a;
        if (i2 > 0) {
            float f2 = i2;
            Context context = subtitleView.getContext();
            float fApplyDimension = TypedValue.applyDimension(2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
            subtitleView.f10961c = 2;
            subtitleView.f10962d = fApplyDimension;
            subtitleView.c();
        }
        int i3 = style.f15410b;
        int i4 = style.f15411c;
        subtitleView.setPadding(i3, i4, i4, style.f15412d);
        float f3 = style.f15413e;
        if (f3 == 0.0f) {
            subtitleView.setVisibility(8);
        } else {
            subtitleView.setAlpha(f3);
            subtitleView.setVisibility(0);
        }
        boolean z = this.f15541l.f15414f;
        boolean z2 = style.f15414f;
        if (z != z2) {
            ViewGroup.LayoutParams layoutParams = this.f15537h;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f15534e;
            if (z2) {
                removeViewInLayout(subtitleView);
                aspectRatioFrameLayout.addView(subtitleView, layoutParams);
            } else {
                aspectRatioFrameLayout.removeViewInLayout(subtitleView);
                addViewInLayout(subtitleView, 1, layoutParams, false);
            }
            requestLayout();
        }
        this.f15541l = style;
    }
}
