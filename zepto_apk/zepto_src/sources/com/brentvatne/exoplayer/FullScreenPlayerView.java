package com.brentvatne.exoplayer;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.ui.LegacyPlayerControlView;
import com.brentvatne.common.api.ControlsConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SuppressLint({"PrivateResource"})
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FullScreenPlayerView extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final ExoPlayerView f15544a;

    /* renamed from: b, reason: collision with root package name */
    public final ReactExoplayerView f15545b;

    /* renamed from: c, reason: collision with root package name */
    public final LegacyPlayerControlView f15546c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackPressedCallback f15547d;

    /* renamed from: e, reason: collision with root package name */
    public final ControlsConfig f15548e;

    /* renamed from: f, reason: collision with root package name */
    public ViewGroup f15549f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f15550g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f15551h;

    /* renamed from: i, reason: collision with root package name */
    public final KeepScreenOnUpdater f15552i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f15553j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f15554k;

    /* renamed from: l, reason: collision with root package name */
    public final Boolean f15555l;

    @Metadata
    public static final class KeepScreenOnUpdater implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f15556a;

        @Metadata
        public static final class Companion {
        }

        public KeepScreenOnUpdater(FullScreenPlayerView fullScreenPlayerView) {
            Intrinsics.checkNotNullParameter(fullScreenPlayerView, "fullScreenPlayerView");
            this.f15556a = new WeakReference(fullScreenPlayerView);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r4 = this;
                java.lang.ref.WeakReference r0 = r4.f15556a     // Catch: java.lang.Exception -> L27
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L27
                com.brentvatne.exoplayer.FullScreenPlayerView r0 = (com.brentvatne.exoplayer.FullScreenPlayerView) r0     // Catch: java.lang.Exception -> L27
                if (r0 == 0) goto L42
                android.view.Window r1 = r0.getWindow()     // Catch: java.lang.Exception -> L27
                if (r1 == 0) goto L2c
                com.brentvatne.exoplayer.ExoPlayerView r2 = r0.f15544a     // Catch: java.lang.Exception -> L27
                androidx.media3.exoplayer.ExoPlayer r2 = r2.f15536g     // Catch: java.lang.Exception -> L27
                if (r2 == 0) goto L1e
                boolean r2 = r2.j1()     // Catch: java.lang.Exception -> L27
                r3 = 1
                if (r2 != r3) goto L1e
                goto L1f
            L1e:
                r3 = 0
            L1f:
                r2 = 128(0x80, float:1.794E-43)
                if (r3 == 0) goto L29
                r1.addFlags(r2)     // Catch: java.lang.Exception -> L27
                goto L2c
            L27:
                r0 = move-exception
                goto L34
            L29:
                r1.clearFlags(r2)     // Catch: java.lang.Exception -> L27
            L2c:
                android.os.Handler r0 = r0.f15551h     // Catch: java.lang.Exception -> L27
                r1 = 200(0xc8, double:9.9E-322)
                r0.postDelayed(r4, r1)     // Catch: java.lang.Exception -> L27
                return
            L34:
                java.lang.String r1 = "ExoPlayer Exception"
                java.lang.String r2 = "Failed to flag FLAG_KEEP_SCREEN_ON on fullscreen."
                com.brentvatne.common.toolbox.DebugLog.b(r1, r2)
                java.lang.String r0 = r0.toString()
                com.brentvatne.common.toolbox.DebugLog.b(r1, r0)
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.FullScreenPlayerView.KeepScreenOnUpdater.run():void");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayerView(Context context, ExoPlayerView exoPlayerView, ReactExoplayerView reactExoplayerView, LegacyPlayerControlView legacyPlayerControlView, OnBackPressedCallback onBackPressedCallback, ControlsConfig controlsConfig) {
        super(context, R.style.Theme.Black.NoTitleBar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exoPlayerView, "exoPlayerView");
        Intrinsics.checkNotNullParameter(reactExoplayerView, "reactExoplayerView");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Intrinsics.checkNotNullParameter(controlsConfig, "controlsConfig");
        this.f15544a = exoPlayerView;
        this.f15545b = reactExoplayerView;
        this.f15546c = legacyPlayerControlView;
        this.f15547d = onBackPressedCallback;
        this.f15548e = controlsConfig;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f15550g = frameLayout;
        this.f15551h = new Handler(Looper.getMainLooper());
        this.f15552i = new KeepScreenOnUpdater(this);
        setContentView(frameLayout, a());
        Window window = getWindow();
        if (window != null) {
            this.f15553j = Integer.valueOf(new WindowInsetsControllerCompat(window, window.getDecorView()).a());
            WindowInsetsCompat windowInsetsCompatM = ViewCompat.m(window.getDecorView());
            boolean z = false;
            this.f15554k = Boolean.valueOf(windowInsetsCompatM != null && windowInsetsCompatM.o(2));
            WindowInsetsCompat windowInsetsCompatM2 = ViewCompat.m(window.getDecorView());
            if (windowInsetsCompatM2 != null && windowInsetsCompatM2.o(1)) {
                z = true;
            }
            this.f15555l = Boolean.valueOf(z);
        }
    }

    public static FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        return layoutParams;
    }

    public static void c(WindowInsetsControllerCompat windowInsetsControllerCompat, int i2, Boolean bool, Boolean bool2, Integer num) {
        if (bool != null) {
            if (bool.equals(bool2)) {
                bool = null;
            }
            if (bool != null) {
                if (!bool.booleanValue()) {
                    windowInsetsControllerCompat.g(i2);
                    return;
                }
                windowInsetsControllerCompat.b(i2);
                if (num != null) {
                    windowInsetsControllerCompat.f(num.intValue());
                }
            }
        }
    }

    public final void b() {
        FrameLayout frameLayout = this.f15550g;
        int childCount = frameLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (frameLayout.getChildAt(i2) != this.f15544a) {
                frameLayout.getChildAt(i2).setVisibility(8);
            }
        }
    }

    public final void d(LegacyPlayerControlView legacyPlayerControlView, boolean z) {
        ImageButton imageButton = (ImageButton) legacyPlayerControlView.findViewById(com.brentvatne.react.R.id.exo_fullscreen);
        if (imageButton != null) {
            int i2 = z ? androidx.media3.ui.R.drawable.exo_icon_fullscreen_exit : androidx.media3.ui.R.drawable.exo_icon_fullscreen_enter;
            String string = z ? getContext().getString(androidx.media3.ui.R.string.exo_controls_fullscreen_exit_description) : getContext().getString(androidx.media3.ui.R.string.exo_controls_fullscreen_enter_description);
            Intrinsics.c(string);
            imageButton.setImageResource(i2);
            imageButton.setContentDescription(string);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15545b.getPreventsDisplaySleepDuringVideoPlayback()) {
            this.f15551h.post(this.f15552i);
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        ExoPlayerView exoPlayerView = this.f15544a;
        ViewGroup viewGroup = (ViewGroup) exoPlayerView.getParent();
        this.f15549f = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeView(exoPlayerView);
        }
        FrameLayout frameLayout = this.f15550g;
        frameLayout.addView(exoPlayerView, a());
        LegacyPlayerControlView legacyPlayerControlView = this.f15546c;
        if (legacyPlayerControlView != null) {
            d(legacyPlayerControlView, true);
            ViewGroup viewGroup2 = this.f15549f;
            if (viewGroup2 != null) {
                viewGroup2.removeView(legacyPlayerControlView);
            }
            frameLayout.addView(legacyPlayerControlView, a());
        }
        Window window = getWindow();
        ControlsConfig controlsConfig = this.f15548e;
        if (window != null) {
            Boolean boolValueOf = Boolean.valueOf(controlsConfig.f15378j);
            Boolean boolValueOf2 = Boolean.valueOf(controlsConfig.f15379k);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            c(windowInsetsControllerCompat, 2, boolValueOf, this.f15554k, 2);
            c(windowInsetsControllerCompat, 1, boolValueOf2, this.f15555l, null);
        }
        if (controlsConfig.f15379k) {
            LinearLayout linearLayout = legacyPlayerControlView != null ? (LinearLayout) legacyPlayerControlView.findViewById(com.brentvatne.react.R.id.exo_live_container) : null;
            if (linearLayout != null) {
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = 40;
                linearLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.f15551h.removeCallbacks(this.f15552i);
        FrameLayout frameLayout = this.f15550g;
        ExoPlayerView exoPlayerView = this.f15544a;
        frameLayout.removeView(exoPlayerView);
        ViewGroup viewGroup = this.f15549f;
        if (viewGroup != null) {
            viewGroup.addView(exoPlayerView, a());
        }
        LegacyPlayerControlView legacyPlayerControlView = this.f15546c;
        if (legacyPlayerControlView != null) {
            d(legacyPlayerControlView, false);
            frameLayout.removeView(legacyPlayerControlView);
            ViewGroup viewGroup2 = this.f15549f;
            if (viewGroup2 != null) {
                viewGroup2.addView(legacyPlayerControlView, a());
            }
        }
        ViewGroup viewGroup3 = this.f15549f;
        if (viewGroup3 != null) {
            viewGroup3.requestLayout();
        }
        this.f15549f = null;
        this.f15547d.handleOnBackPressed();
        Window window = getWindow();
        if (window != null) {
            Integer num = this.f15553j;
            Boolean bool = this.f15554k;
            Boolean bool2 = this.f15555l;
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            c(windowInsetsControllerCompat, 2, bool, this.f15554k, num);
            c(windowInsetsControllerCompat, 1, bool2, this.f15555l, null);
        }
    }
}
