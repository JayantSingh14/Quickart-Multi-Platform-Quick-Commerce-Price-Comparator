package com.brentvatne.react;

import android.view.View;
import androidx.activity.g;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.Player;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.react.h;
import com.brentvatne.common.react.n;
import com.brentvatne.common.react.r;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class VideoManagerModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String REACT_CLASS = "VideoManager";

    @Metadata
    public static final class Companion {
    }

    public VideoManagerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enterPictureInPictureCmd$lambda$5(ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            reactExoplayerView.I();
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitPictureInPictureCmd$lambda$6(ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            reactExoplayerView.J();
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCurrentPosition$lambda$8(Promise promise, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            if (reactExoplayerView.f15570k != null) {
                promise.resolve(Float.valueOf(r3.z1() / 1000.0f));
            } else {
                promise.reject("PLAYER_NOT_AVAILABLE", "Player is not initialized.");
            }
        }
        return Unit.f53572a;
    }

    private final void performOnPlayerView(int i2, Function1<? super ReactExoplayerView, Unit> function1) {
        UiThreadUtil.runOnUiThread(new g(this, i2, function1, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performOnPlayerView$lambda$0(VideoManagerModule videoManagerModule, int i2, Function1 function1) {
        try {
            UIManager uIManagerF = UIManagerHelper.f(videoManagerModule.getReactApplicationContext(), 1, true);
            View viewResolveView = uIManagerF != null ? uIManagerF.resolveView(i2) : null;
            if (viewResolveView instanceof ReactExoplayerView) {
                function1.invoke(viewResolveView);
            } else {
                function1.invoke(null);
            }
        } catch (Exception unused) {
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit seekCmd$lambda$2(float f2, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            long jB = MathKt.b(f2 * 1000.0f);
            Player player = reactExoplayerView.f15570k;
            if (player != null) {
                ((BasePlayer) player).X(jB);
            }
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setFullScreenCmd$lambda$4(boolean z, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            reactExoplayerView.setFullscreen(z);
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setPlayerPauseStateCmd$lambda$1(Boolean bool, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            Intrinsics.c(bool);
            reactExoplayerView.setPausedModifier(bool.booleanValue());
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSourceCmd$lambda$7(ReadableMap readableMap, VideoManagerModule videoManagerModule, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            ReactApplicationContext reactApplicationContext = videoManagerModule.getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            reactExoplayerView.setSrc(Source.Companion.a(reactApplicationContext, readableMap));
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setVolumeCmd$lambda$3(float f2, ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView != null) {
            reactExoplayerView.setVolumeModifier(f2);
        }
        return Unit.f53572a;
    }

    @ReactMethod
    public final void enterPictureInPictureCmd(int i2) {
        performOnPlayerView(i2, new r(2));
    }

    @ReactMethod
    public final void exitPictureInPictureCmd(int i2) {
        performOnPlayerView(i2, new r(1));
    }

    @ReactMethod
    public final void getCurrentPosition(int i2, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        performOnPlayerView(i2, new b(0, promise));
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public final void seekCmd(int i2, float f2, float f3) {
        performOnPlayerView(i2, new n(f2, 3));
    }

    @ReactMethod
    public final void setFullScreenCmd(int i2, boolean z) {
        performOnPlayerView(i2, new h(z, 4));
    }

    @ReactMethod
    public final void setPlayerPauseStateCmd(int i2, @Nullable Boolean bool) {
        performOnPlayerView(i2, new c(bool, 0));
    }

    @ReactMethod
    public final void setSourceCmd(int i2, @Nullable ReadableMap readableMap) {
        performOnPlayerView(i2, new a(0, readableMap, this));
    }

    @ReactMethod
    public final void setVolumeCmd(int i2, float f2) {
        performOnPlayerView(i2, new n(f2, 2));
    }
}
