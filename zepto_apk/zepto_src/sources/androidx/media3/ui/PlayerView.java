package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.AttachedSurfaceControl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.ErrorMessageProvider;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class PlayerView extends FrameLayout implements AdViewProvider {
    public static final /* synthetic */ int J = 0;
    public int A;
    public boolean B;
    public ErrorMessageProvider C;
    public CharSequence D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;

    /* renamed from: a, reason: collision with root package name */
    public final ComponentListener f10918a;

    /* renamed from: b, reason: collision with root package name */
    public final AspectRatioFrameLayout f10919b;

    /* renamed from: c, reason: collision with root package name */
    public final View f10920c;

    /* renamed from: d, reason: collision with root package name */
    public final View f10921d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10922e;

    /* renamed from: f, reason: collision with root package name */
    public final SurfaceSyncGroupCompatV34 f10923f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f10924g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f10925h;

    /* renamed from: i, reason: collision with root package name */
    public final SubtitleView f10926i;

    /* renamed from: j, reason: collision with root package name */
    public final View f10927j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f10928k;

    /* renamed from: l, reason: collision with root package name */
    public final PlayerControlView f10929l;

    /* renamed from: m, reason: collision with root package name */
    public final FrameLayout f10930m;
    public final FrameLayout n;
    public final Handler o;
    public final Class p;
    public final Method q;
    public final Object r;
    public Player s;
    public boolean t;
    public ControllerVisibilityListener u;
    public PlayerControlView.VisibilityListener v;
    public FullscreenButtonClickListener w;
    public int x;
    public int y;
    public Drawable z;

    @RequiresApi
    public static class Api34 {
        @DoNotInline
        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ArtworkDisplayMode {
    }

    public final class ComponentListener implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.VisibilityListener, PlayerControlView.OnFullScreenModeChangedListener {

        /* renamed from: a, reason: collision with root package name */
        public final Timeline.Period f10931a = new Timeline.Period();

        /* renamed from: b, reason: collision with root package name */
        public Object f10932b;

        public ComponentListener() {
        }

        @Override // androidx.media3.common.Player.Listener
        public final void E1(Tracks tracks) {
            PlayerView playerView = PlayerView.this;
            Player player = playerView.s;
            player.getClass();
            Timeline timelineF0 = player.D1(17) ? player.F0() : Timeline.f5466a;
            if (timelineF0.p()) {
                this.f10932b = null;
            } else {
                boolean zD1 = player.D1(30);
                Timeline.Period period = this.f10931a;
                if (!zD1 || player.y0().f5548a.isEmpty()) {
                    Object obj = this.f10932b;
                    if (obj != null) {
                        int iB = timelineF0.b(obj);
                        if (iB != -1) {
                            if (player.l1() == timelineF0.f(iB, period, false).f5477c) {
                                return;
                            }
                        }
                        this.f10932b = null;
                    }
                } else {
                    this.f10932b = timelineF0.f(player.T0(), period, true).f5476b;
                }
            }
            playerView.o(false);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void b(VideoSize videoSize) {
            PlayerView playerView;
            Player player;
            if (videoSize.equals(VideoSize.f5559e) || (player = (playerView = PlayerView.this).s) == null || player.u() == 1) {
                return;
            }
            playerView.k();
        }

        @Override // androidx.media3.common.Player.Listener
        public final void e1(CueGroup cueGroup) {
            SubtitleView subtitleView = PlayerView.this.f10926i;
            if (subtitleView != null) {
                subtitleView.setCues(cueGroup.f5641a);
            }
        }

        @Override // androidx.media3.ui.PlayerControlView.VisibilityListener
        public final void h(int i2) {
            int i3 = PlayerView.J;
            PlayerView playerView = PlayerView.this;
            playerView.m();
            ControllerVisibilityListener controllerVisibilityListener = playerView.u;
            if (controllerVisibilityListener != null) {
                controllerVisibilityListener.a();
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void i1(int i2) {
            int i3 = PlayerView.J;
            PlayerView playerView = PlayerView.this;
            playerView.l();
            playerView.n();
            if (!playerView.e() || !playerView.G) {
                playerView.f(false);
                return;
            }
            PlayerControlView playerControlView = playerView.f10929l;
            if (playerControlView != null) {
                playerControlView.g();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i2 = PlayerView.J;
            PlayerView.this.j();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.b((TextureView) view, PlayerView.this.I);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void q1() {
            PlayerView playerView = PlayerView.this;
            View view = playerView.f10920c;
            if (view != null) {
                view.setVisibility(4);
                if (!playerView.c()) {
                    playerView.d();
                    return;
                }
                ImageView imageView = playerView.f10924g;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void s1(int i2, int i3) {
            if (Util.f5744a == 34) {
                PlayerView playerView = PlayerView.this;
                View view = playerView.f10921d;
                if (view instanceof SurfaceView) {
                    SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34 = playerView.f10923f;
                    surfaceSyncGroupCompatV34.getClass();
                    surfaceSyncGroupCompatV34.b(playerView.o, (SurfaceView) view, new a(2, playerView));
                }
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
            PlayerControlView playerControlView;
            int i3 = PlayerView.J;
            PlayerView playerView = PlayerView.this;
            if (playerView.e() && playerView.G && (playerControlView = playerView.f10929l) != null) {
                playerControlView.g();
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void y1(int i2, boolean z) {
            int i3 = PlayerView.J;
            PlayerView playerView = PlayerView.this;
            playerView.l();
            if (!playerView.e() || !playerView.G) {
                playerView.f(false);
                return;
            }
            PlayerControlView playerControlView = playerView.f10929l;
            if (playerControlView != null) {
                playerControlView.g();
            }
        }

        @Override // androidx.media3.ui.PlayerControlView.OnFullScreenModeChangedListener
        public final void z(boolean z) {
            FullscreenButtonClickListener fullscreenButtonClickListener = PlayerView.this.w;
            if (fullscreenButtonClickListener != null) {
                fullscreenButtonClickListener.a();
            }
        }
    }

    public interface ControllerVisibilityListener {
        void a();
    }

    public interface FullscreenButtonClickListener {
        void a();
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ImageDisplayMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ShowBuffering {
    }

    @RequiresApi
    public static final class SurfaceSyncGroupCompatV34 {

        /* renamed from: a, reason: collision with root package name */
        public SurfaceSyncGroup f10934a;

        @DoNotInline
        public void a() {
            SurfaceSyncGroup surfaceSyncGroup = this.f10934a;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.f10934a = null;
            }
        }

        @DoNotInline
        public void b(Handler handler, final SurfaceView surfaceView, final Runnable runnable) {
            handler.post(new Runnable() { // from class: androidx.media3.ui.j
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerView.SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34 = this.f11011a;
                    AttachedSurfaceControl rootSurfaceControl = surfaceView.getRootSurfaceControl();
                    if (rootSurfaceControl == null) {
                        return;
                    }
                    SurfaceSyncGroup surfaceSyncGroupJ = androidx.core.view.j.j();
                    surfaceSyncGroupCompatV34.f10934a = surfaceSyncGroupJ;
                    Assertions.g(surfaceSyncGroupJ.add(rootSurfaceControl, new k()));
                    runnable.run();
                    rootSurfaceControl.applyTransactionOnDraw(androidx.media3.exoplayer.source.mediaparser.a.m());
                }
            });
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void a(PlayerView playerView, Bitmap bitmap) {
        playerView.setImage(new BitmapDrawable(playerView.getResources(), bitmap));
        Player player = playerView.s;
        if (player != null && player.D1(30) && player.y0().a(2)) {
            return;
        }
        ImageView imageView = playerView.f10924g;
        if (imageView != null) {
            imageView.setVisibility(0);
            playerView.p();
        }
        View view = playerView.f10920c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static void b(TextureView textureView, int i2) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i2 != 0) {
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.postRotate(i2, f2, f3);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        }
        textureView.setTransform(matrix);
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.f10924g;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        p();
    }

    private void setImageOutput(Player player) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = this.p;
        if (cls == null || !cls.isAssignableFrom(player.getClass())) {
            return;
        }
        try {
            Method method = this.q;
            method.getClass();
            Object obj = this.r;
            obj.getClass();
            method.invoke(player, obj);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean c() {
        Player player = this.s;
        return player != null && this.r != null && player.D1(30) && player.y0().a(4);
    }

    public final void d() {
        ImageView imageView = this.f10924g;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34;
        super.dispatchDraw(canvas);
        if (Util.f5744a != 34 || (surfaceSyncGroupCompatV34 = this.f10923f) == null) {
            return;
        }
        surfaceSyncGroupCompatV34.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.s;
        if (player != null && player.D1(16) && this.s.f0()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        PlayerControlView playerControlView = this.f10929l;
        if (z && q() && !playerControlView.h()) {
            f(true);
            return true;
        }
        if ((q() && playerControlView.d(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            f(true);
            return true;
        }
        if (z && q()) {
            f(true);
        }
        return false;
    }

    public final boolean e() {
        Player player = this.s;
        return player != null && player.D1(16) && this.s.f0() && this.s.O0();
    }

    public final void f(boolean z) {
        if (!(e() && this.G) && q()) {
            PlayerControlView playerControlView = this.f10929l;
            boolean z2 = playerControlView.h() && playerControlView.getShowTimeoutMs() <= 0;
            boolean zH = h();
            if (z || z2 || zH) {
                i(zH);
            }
        }
    }

    public final boolean g(Drawable drawable) {
        ImageView imageView = this.f10925h;
        if (imageView != null && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.x == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f10919b;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(width);
                }
                imageView.setScaleType(scaleType);
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.common.AdViewProvider
    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, "Transparent overlay does not impact viewability", 4));
        }
        PlayerControlView playerControlView = this.f10929l;
        if (playerControlView != null) {
            new AdOverlayInfo.Builder(1, playerControlView);
            arrayList.add(new AdOverlayInfo(playerControlView, null, 1));
        }
        return ImmutableList.o(arrayList);
    }

    @Override // androidx.media3.common.AdViewProvider
    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f10930m;
        if (frameLayout != null) {
            return frameLayout;
        }
        throw new IllegalStateException("exo_ad_overlay must be present for ad playback");
    }

    @UnstableApi
    public int getArtworkDisplayMode() {
        return this.x;
    }

    @UnstableApi
    public boolean getControllerAutoShow() {
        return this.F;
    }

    @UnstableApi
    public boolean getControllerHideOnTouch() {
        return this.H;
    }

    @UnstableApi
    public int getControllerShowTimeoutMs() {
        return this.E;
    }

    @Nullable
    @UnstableApi
    public Drawable getDefaultArtwork() {
        return this.z;
    }

    @UnstableApi
    public int getImageDisplayMode() {
        return this.y;
    }

    @Nullable
    @UnstableApi
    public FrameLayout getOverlayFrameLayout() {
        return this.n;
    }

    @Nullable
    public Player getPlayer() {
        return this.s;
    }

    @UnstableApi
    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f10919b;
        Assertions.h(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    @Nullable
    @UnstableApi
    public SubtitleView getSubtitleView() {
        return this.f10926i;
    }

    @UnstableApi
    @Deprecated
    public boolean getUseArtwork() {
        return this.x != 0;
    }

    public boolean getUseController() {
        return this.t;
    }

    @Nullable
    @UnstableApi
    public View getVideoSurfaceView() {
        return this.f10921d;
    }

    public final boolean h() {
        Player player = this.s;
        if (player != null) {
            int iU = player.u();
            if (!this.F) {
                return false;
            }
            if (this.s.D1(17) && this.s.F0().p()) {
                return false;
            }
            if (iU != 1 && iU != 4) {
                Player player2 = this.s;
                player2.getClass();
                if (player2.O0()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void i(boolean z) {
        if (q()) {
            int i2 = z ? 0 : this.E;
            PlayerControlView playerControlView = this.f10929l;
            playerControlView.setShowTimeoutMs(i2);
            PlayerControlViewLayoutManager playerControlViewLayoutManager = playerControlView.f10864a;
            PlayerControlView playerControlView2 = playerControlViewLayoutManager.f10893a;
            if (!playerControlView2.i()) {
                playerControlView2.setVisibility(0);
                playerControlView2.j();
                ImageView imageView = playerControlView2.o;
                if (imageView != null) {
                    imageView.requestFocus();
                }
            }
            playerControlViewLayoutManager.k();
        }
    }

    public final void j() {
        if (!q() || this.s == null) {
            return;
        }
        PlayerControlView playerControlView = this.f10929l;
        if (!playerControlView.h()) {
            f(true);
        } else if (this.H) {
            playerControlView.g();
        }
    }

    public final void k() {
        Player player = this.s;
        VideoSize videoSizeV0 = player != null ? player.V0() : VideoSize.f5559e;
        int i2 = videoSizeV0.f5564a;
        int i3 = videoSizeV0.f5565b;
        float f2 = (i3 == 0 || i2 == 0) ? 0.0f : (i2 * videoSizeV0.f5567d) / i3;
        View view = this.f10921d;
        if (view instanceof TextureView) {
            int i4 = videoSizeV0.f5566c;
            if (f2 > 0.0f && (i4 == 90 || i4 == 270)) {
                f2 = 1.0f / f2;
            }
            int i5 = this.I;
            ComponentListener componentListener = this.f10918a;
            if (i5 != 0) {
                view.removeOnLayoutChangeListener(componentListener);
            }
            this.I = i4;
            if (i4 != 0) {
                view.addOnLayoutChangeListener(componentListener);
            }
            b((TextureView) view, this.I);
        }
        float f3 = this.f10922e ? 0.0f : f2;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f10919b;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f3);
        }
    }

    public final void l() {
        int i2;
        View view = this.f10927j;
        if (view != null) {
            Player player = this.s;
            view.setVisibility((player != null && player.u() == 2 && ((i2 = this.A) == 2 || (i2 == 1 && this.s.O0()))) ? 0 : 8);
        }
    }

    public final void m() {
        PlayerControlView playerControlView = this.f10929l;
        if (playerControlView == null || !this.t) {
            setContentDescription(null);
        } else if (playerControlView.h()) {
            setContentDescription(this.H ? getResources().getString(R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.exo_controls_show));
        }
    }

    public final void n() {
        ErrorMessageProvider errorMessageProvider;
        TextView textView = this.f10928k;
        if (textView != null) {
            CharSequence charSequence = this.D;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            Player player = this.s;
            if ((player != null ? player.a() : null) == null || (errorMessageProvider = this.C) == null) {
                textView.setVisibility(8);
            } else {
                textView.setText((CharSequence) errorMessageProvider.a().second);
                textView.setVisibility(0);
            }
        }
    }

    public final void o(boolean z) {
        byte[] bArr;
        Drawable drawable;
        Player player = this.s;
        boolean zG = false;
        boolean z2 = (player == null || !player.D1(30) || player.y0().f5548a.isEmpty()) ? false : true;
        boolean z3 = this.B;
        ImageView imageView = this.f10925h;
        View view = this.f10920c;
        if (!z3 && (!z2 || z)) {
            if (imageView != null) {
                imageView.setImageResource(android.R.color.transparent);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
            }
            d();
        }
        if (z2) {
            Player player2 = this.s;
            boolean z4 = player2 != null && player2.D1(30) && player2.y0().a(2);
            boolean zC = c();
            if (!z4 && !zC) {
                if (view != null) {
                    view.setVisibility(0);
                }
                d();
            }
            ImageView imageView2 = this.f10924g;
            boolean z5 = (view == null || view.getVisibility() != 4 || imageView2 == null || (drawable = imageView2.getDrawable()) == null || drawable.getAlpha() == 0) ? false : true;
            if (zC && !z4 && z5) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    p();
                }
            } else if (z4 && !zC && z5) {
                d();
            }
            if (!z4 && !zC && this.x != 0) {
                Assertions.h(imageView);
                if (player != null && player.D1(18) && (bArr = player.x1().f5389k) != null) {
                    zG = g(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                }
                if (zG || g(this.z)) {
                    return;
                }
            }
            if (imageView != null) {
                imageView.setImageResource(android.R.color.transparent);
                imageView.setVisibility(4);
            }
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!q() || this.s == null) {
            return false;
        }
        f(true);
        return true;
    }

    public final void p() {
        Drawable drawable;
        AspectRatioFrameLayout aspectRatioFrameLayout;
        ImageView imageView = this.f10924g;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float width = intrinsicWidth / intrinsicHeight;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (this.y == 1) {
            width = getWidth() / getHeight();
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (imageView.getVisibility() == 0 && (aspectRatioFrameLayout = this.f10919b) != null) {
            aspectRatioFrameLayout.setAspectRatio(width);
        }
        imageView.setScaleType(scaleType);
    }

    @Override // android.view.View
    public final boolean performClick() {
        j();
        return super.performClick();
    }

    public final boolean q() {
        if (!this.t) {
            return false;
        }
        Assertions.h(this.f10929l);
        return true;
    }

    @UnstableApi
    public void setArtworkDisplayMode(int i2) {
        Assertions.g(i2 == 0 || this.f10925h != null);
        if (this.x != i2) {
            this.x = i2;
            o(false);
        }
    }

    @UnstableApi
    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f10919b;
        Assertions.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aspectRatioListener);
    }

    @UnstableApi
    public void setControllerAnimationEnabled(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setAnimationEnabled(z);
    }

    @UnstableApi
    public void setControllerAutoShow(boolean z) {
        this.F = z;
    }

    @UnstableApi
    public void setControllerHideDuringAds(boolean z) {
        this.G = z;
    }

    @UnstableApi
    public void setControllerHideOnTouch(boolean z) {
        Assertions.h(this.f10929l);
        this.H = z;
        m();
    }

    @UnstableApi
    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable PlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        this.w = null;
        playerControlView.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    @UnstableApi
    public void setControllerShowTimeoutMs(int i2) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        this.E = i2;
        if (playerControlView.h()) {
            i(h());
        }
    }

    public void setControllerVisibilityListener(@Nullable ControllerVisibilityListener controllerVisibilityListener) {
        this.u = controllerVisibilityListener;
        if (controllerVisibilityListener != null) {
            setControllerVisibilityListener((PlayerControlView.VisibilityListener) null);
        }
    }

    @UnstableApi
    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        Assertions.g(this.f10928k != null);
        this.D = charSequence;
        n();
    }

    @UnstableApi
    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.z != drawable) {
            this.z = drawable;
            o(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.C != errorMessageProvider) {
            this.C = errorMessageProvider;
            n();
        }
    }

    public void setFullscreenButtonClickListener(@Nullable FullscreenButtonClickListener fullscreenButtonClickListener) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        this.w = fullscreenButtonClickListener;
        playerControlView.setOnFullScreenModeChangedListener(this.f10918a);
    }

    @UnstableApi
    public void setImageDisplayMode(int i2) {
        Assertions.g(this.f10924g != null);
        if (this.y != i2) {
            this.y = i2;
            p();
        }
    }

    @UnstableApi
    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.B != z) {
            this.B = z;
            o(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPlayer(@androidx.annotation.Nullable androidx.media3.common.Player r10) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.setPlayer(androidx.media3.common.Player):void");
    }

    @UnstableApi
    public void setRepeatToggleModes(int i2) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setRepeatToggleModes(i2);
    }

    @UnstableApi
    public void setResizeMode(int i2) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f10919b;
        Assertions.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    @UnstableApi
    public void setShowBuffering(int i2) {
        if (this.A != i2) {
            this.A = i2;
            l();
        }
    }

    @UnstableApi
    public void setShowFastForwardButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowFastForwardButton(z);
    }

    @UnstableApi
    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowMultiWindowTimeBar(z);
    }

    @UnstableApi
    public void setShowNextButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowNextButton(z);
    }

    @UnstableApi
    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowPlayButtonIfPlaybackIsSuppressed(z);
    }

    @UnstableApi
    public void setShowPreviousButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowPreviousButton(z);
    }

    @UnstableApi
    public void setShowRewindButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowRewindButton(z);
    }

    @UnstableApi
    public void setShowShuffleButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowShuffleButton(z);
    }

    @UnstableApi
    public void setShowSubtitleButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowSubtitleButton(z);
    }

    @UnstableApi
    public void setShowVrButton(boolean z) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        playerControlView.setShowVrButton(z);
    }

    @UnstableApi
    public void setShutterBackgroundColor(@ColorInt int i2) {
        View view = this.f10920c;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    @UnstableApi
    @Deprecated
    public void setUseArtwork(boolean z) {
        setArtworkDisplayMode(!z ? 1 : 0);
    }

    public void setUseController(boolean z) {
        boolean z2 = true;
        PlayerControlView playerControlView = this.f10929l;
        Assertions.g((z && playerControlView == null) ? false : true);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.t == z) {
            return;
        }
        this.t = z;
        if (q()) {
            playerControlView.setPlayer(this.s);
        } else if (playerControlView != null) {
            playerControlView.g();
            playerControlView.setPlayer(null);
        }
        m();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f10921d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        boolean z6;
        boolean z7;
        Class<ExoPlayer> cls;
        Object objNewProxyInstance;
        Method method;
        int i12;
        super(context, attributeSet, i2);
        ComponentListener componentListener = new ComponentListener();
        this.f10918a = componentListener;
        this.o = new Handler(Looper.getMainLooper());
        if (isInEditMode()) {
            this.f10919b = null;
            this.f10920c = null;
            this.f10921d = null;
            this.f10922e = false;
            this.f10923f = null;
            this.f10924g = null;
            this.f10925h = null;
            this.f10926i = null;
            this.f10927j = null;
            this.f10928k = null;
            this.f10929l = null;
            this.f10930m = null;
            this.n = null;
            this.p = null;
            this.q = null;
            this.r = null;
            ImageView imageView = new ImageView(context);
            if (Util.f5744a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(Util.v(context, resources, R.drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(Util.v(context, resources2, R.drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R.color.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i13 = R.layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlayerView, i2, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R.styleable.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerView_player_layout_id, i13);
                boolean z8 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_artwork, true);
                int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_artwork_display_mode, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerView_default_artwork, 0);
                int i15 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_image_display_mode, 0);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_controller, true);
                int i16 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_surface_type, 1);
                int i17 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_resize_mode, 0);
                i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_show_timeout, 5000);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.PlayerView_show_buffering, 0);
                this.B = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.B);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i6 = resourceId2;
                z2 = z10;
                z5 = zHasValue;
                i7 = i17;
                z4 = z12;
                i4 = resourceId;
                z = z9;
                z3 = z11;
                z6 = z8;
                i9 = i15;
                i11 = i14;
                i10 = color;
                i8 = i16;
                i5 = integer;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i3 = 5000;
            i4 = i13;
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 1;
            i9 = 0;
            i10 = 0;
            i11 = 1;
            z5 = false;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i4, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.f10919b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i7);
        }
        View viewFindViewById = findViewById(R.id.exo_shutter);
        this.f10920c = viewFindViewById;
        if (viewFindViewById != null && z5) {
            viewFindViewById.setBackgroundColor(i10);
        }
        if (aspectRatioFrameLayout == null || i8 == 0) {
            this.f10921d = null;
            z7 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i8 == 2) {
                this.f10921d = new TextureView(context);
            } else if (i8 == 3) {
                try {
                    int i18 = SphericalGLSurfaceView.f8417l;
                    this.f10921d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z7 = true;
                    this.f10921d.setLayoutParams(layoutParams);
                    this.f10921d.setOnClickListener(componentListener);
                    this.f10921d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f10921d, 0);
                } catch (Exception e2) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            } else if (i8 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (Util.f5744a >= 34) {
                    Api34.a(surfaceView);
                }
                this.f10921d = surfaceView;
            } else {
                try {
                    int i19 = VideoDecoderGLSurfaceView.f8289b;
                    this.f10921d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e3) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                }
            }
            z7 = false;
            this.f10921d.setLayoutParams(layoutParams);
            this.f10921d.setOnClickListener(componentListener);
            this.f10921d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f10921d, 0);
        }
        this.f10922e = z7;
        this.f10923f = Util.f5744a == 34 ? new SurfaceSyncGroupCompatV34() : null;
        this.f10930m = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.n = (FrameLayout) findViewById(R.id.exo_overlay);
        this.f10924g = (ImageView) findViewById(R.id.exo_image);
        this.y = i9;
        try {
            cls = ExoPlayer.class;
            method = cls.getMethod("setImageOutput", ImageOutput.class);
            objNewProxyInstance = Proxy.newProxyInstance(ImageOutput.class.getClassLoader(), new Class[]{ImageOutput.class}, new InvocationHandler() { // from class: androidx.media3.ui.i
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) {
                    int i20 = PlayerView.J;
                    PlayerView playerView = this.f11010a;
                    if (!method2.getName().equals("onImageAvailable")) {
                        return null;
                    }
                    playerView.o.post(new androidx.constraintlayout.motion.widget.a(7, playerView, (Bitmap) objArr[1]));
                    return null;
                }
            });
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            objNewProxyInstance = null;
            method = null;
        }
        this.p = cls;
        this.q = method;
        this.r = objNewProxyInstance;
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.f10925h = imageView2;
        this.x = (!z6 || i11 == 0 || imageView2 == null) ? 0 : i11;
        if (i6 != 0) {
            this.z = getContext().getDrawable(i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f10926i = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View viewFindViewById2 = findViewById(R.id.exo_buffering);
        this.f10927j = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.A = i5;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.f10928k = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R.id.exo_controller);
        View viewFindViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f10929l = playerControlView;
            i12 = 0;
        } else if (viewFindViewById3 != null) {
            i12 = 0;
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f10929l = playerControlView2;
            playerControlView2.setId(R.id.exo_controller);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            i12 = 0;
            this.f10929l = null;
        }
        PlayerControlView playerControlView3 = this.f10929l;
        this.E = playerControlView3 != null ? i3 : i12;
        this.H = z2;
        this.F = z3;
        this.G = z4;
        this.t = (!z || playerControlView3 == null) ? i12 : 1;
        if (playerControlView3 != null) {
            PlayerControlViewLayoutManager playerControlViewLayoutManager = playerControlView3.f10864a;
            int i20 = playerControlViewLayoutManager.z;
            if (i20 != 3 && i20 != 2) {
                playerControlViewLayoutManager.f();
                playerControlViewLayoutManager.i(2);
            }
            PlayerControlView playerControlView4 = this.f10929l;
            ComponentListener componentListener2 = this.f10918a;
            playerControlView4.getClass();
            componentListener2.getClass();
            playerControlView4.f10867d.add(componentListener2);
        }
        if (z) {
            setClickable(true);
        }
        m();
    }

    @UnstableApi
    @Deprecated
    public void setControllerVisibilityListener(@Nullable PlayerControlView.VisibilityListener visibilityListener) {
        PlayerControlView playerControlView = this.f10929l;
        Assertions.h(playerControlView);
        PlayerControlView.VisibilityListener visibilityListener2 = this.v;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = playerControlView.f10867d;
        if (visibilityListener2 != null) {
            copyOnWriteArrayList.remove(visibilityListener2);
        }
        this.v = visibilityListener;
        if (visibilityListener != null) {
            copyOnWriteArrayList.add(visibilityListener);
            setControllerVisibilityListener((ControllerVisibilityListener) null);
        }
    }
}
