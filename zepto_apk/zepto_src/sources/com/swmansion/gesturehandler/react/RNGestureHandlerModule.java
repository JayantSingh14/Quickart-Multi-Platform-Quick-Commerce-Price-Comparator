package com.swmansion.gesturehandler.react;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec;
import com.swmansion.gesturehandler.ReactContextExtensionsKt;
import com.swmansion.gesturehandler.ReanimatedEventDispatcher;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.ManualGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.core.OnTouchEventListener;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerEvent;
import com.swmansion.gesturehandler.react.RNGestureHandlerStateChangeEvent;
import com.swmansion.gesturehandler.react.RNGestureHandlerTouchEvent;
import com.swmansion.gesturehandler.react.eventbuilders.FlingGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.HoverGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.LongPressGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.ManualGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.NativeGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.PanGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.PinchGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.RotationGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.TapGestureHandlerEventDataBuilder;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "RNGestureHandlerModule")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RNGestureHandlerModule extends NativeRNGestureHandlerModuleSpec implements GestureHandlerStateManager {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String KEY_DIRECTION = "direction";

    @NotNull
    private static final String KEY_ENABLED = "enabled";

    @NotNull
    private static final String KEY_HIT_SLOP = "hitSlop";

    @NotNull
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";

    @NotNull
    private static final String KEY_HIT_SLOP_HEIGHT = "height";

    @NotNull
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";

    @NotNull
    private static final String KEY_HIT_SLOP_LEFT = "left";

    @NotNull
    private static final String KEY_HIT_SLOP_RIGHT = "right";

    @NotNull
    private static final String KEY_HIT_SLOP_TOP = "top";

    @NotNull
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";

    @NotNull
    private static final String KEY_HIT_SLOP_WIDTH = "width";

    @NotNull
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";

    @NotNull
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";

    @NotNull
    private static final String KEY_MANUAL_ACTIVATION = "manualActivation";

    @NotNull
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";

    @NotNull
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";

    @NotNull
    private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";

    @NotNull
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";

    @NotNull
    private static final String KEY_PAN_ACTIVATE_AFTER_LONG_PRESS = "activateAfterLongPress";

    @NotNull
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";

    @NotNull
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";

    @NotNull
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";

    @NotNull
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";

    @NotNull
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";

    @NotNull
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";

    @NotNull
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";

    @NotNull
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";

    @NotNull
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";

    @NotNull
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";

    @NotNull
    private static final String KEY_PAN_MIN_DIST = "minDist";

    @NotNull
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";

    @NotNull
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";

    @NotNull
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";

    @NotNull
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";

    @NotNull
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";

    @NotNull
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";

    @NotNull
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";

    @NotNull
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";

    @NotNull
    private static final String KEY_TAP_MAX_DIST = "maxDist";

    @NotNull
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";

    @NotNull
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";

    @NotNull
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";

    @NotNull
    public static final String NAME = "RNGestureHandlerModule";

    @NotNull
    private final RNGestureHandlerModule$eventListener$1 eventListener;

    @NotNull
    private final HandlerFactory<?>[] handlerFactories;

    @NotNull
    private final RNGestureHandlerInteractionManager interactionManager;

    @NotNull
    private final ReanimatedEventDispatcher reanimatedEventDispatcher;

    @NotNull
    private final RNGestureHandlerRegistry registry;

    @NotNull
    private final List<RNGestureHandlerRootHelper> roots;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46823a = FlingGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46824b = "FlingGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final void a(GestureHandler gestureHandler, ReadableMap config) {
            FlingGestureHandler handler = (FlingGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.a(handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                handler.M = config.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                handler.N = config.getInt(RNGestureHandlerModule.KEY_DIRECTION);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new FlingGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            FlingGestureHandler handler = (FlingGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new FlingGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46824b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46823a;
        }
    }

    @Metadata
    public static abstract class HandlerFactory<T extends GestureHandler<T>> {
        public void a(GestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            handler.y();
            if (config.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                handler.y = config.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_ENABLED)) {
                boolean z = config.getBoolean(RNGestureHandlerModule.KEY_ENABLED);
                if (handler.f46718e != null && handler.f46723j != z) {
                    UiThreadUtil.runOnUiThread(new com.swmansion.gesturehandler.core.a(0, handler));
                }
                handler.f46723j = z;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.Companion.getClass();
                if (config.getType(RNGestureHandlerModule.KEY_HIT_SLOP) == ReadableType.Number) {
                    float fB = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP));
                    handler.A(fB, fB, fB, fB, Float.NaN, Float.NaN);
                } else {
                    ReadableMap map = config.getMap(RNGestureHandlerModule.KEY_HIT_SLOP);
                    Intrinsics.c(map);
                    float fB2 = map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL) ? PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL)) : Float.NaN;
                    float fB3 = fB2;
                    float fB4 = map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL) ? PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL)) : Float.NaN;
                    float fB5 = fB4;
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
                        fB2 = PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT));
                    }
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_TOP)) {
                        fB4 = PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP));
                    }
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
                        fB3 = PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT));
                    }
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM)) {
                        fB5 = PixelUtil.b((float) map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM));
                    }
                    float fB6 = map.hasKey("width") ? PixelUtil.b((float) map.getDouble("width")) : Float.NaN;
                    handler.A(fB2, fB4, fB3, fB5, fB6, map.hasKey("height") ? PixelUtil.b((float) map.getDouble("height")) : Float.NaN);
                }
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA)) {
                handler.q = config.getBoolean(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION)) {
                handler.v = config.getBoolean(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION);
            }
            if (config.hasKey("mouseButton")) {
                handler.E = config.getInt("mouseButton");
            }
        }

        public abstract GestureHandler b(ReactApplicationContext reactApplicationContext);

        public abstract GestureHandlerEventDataBuilder c(GestureHandler gestureHandler);

        public abstract String d();

        public abstract Class e();
    }

    @Metadata
    public static final class HoverGestureHandlerFactory extends HandlerFactory<HoverGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46825a = HoverGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46826b = "HoverGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new HoverGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            HoverGestureHandler handler = (HoverGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new HoverGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46826b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46825a;
        }
    }

    @Metadata
    public static final class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46827a = LongPressGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46828b = "LongPressGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final void a(GestureHandler gestureHandler, ReadableMap config) {
            LongPressGestureHandler handler = (LongPressGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.a(handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                handler.M = config.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS);
            }
            if (config.hasKey("maxDist")) {
                float fB = PixelUtil.b((float) config.getDouble("maxDist"));
                handler.O = fB * fB;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                handler.P = config.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            Intrinsics.c(reactApplicationContext);
            return new LongPressGestureHandler(reactApplicationContext);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            LongPressGestureHandler handler = (LongPressGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new LongPressGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46828b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46827a;
        }
    }

    @Metadata
    public static final class ManualGestureHandlerFactory extends HandlerFactory<ManualGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46829a = ManualGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46830b = "ManualGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new ManualGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            ManualGestureHandler handler = (ManualGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new ManualGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46830b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46829a;
        }
    }

    @Metadata
    public static final class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46831a = NativeViewGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46832b = "NativeViewGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final void a(GestureHandler gestureHandler, ReadableMap config) {
            NativeViewGestureHandler handler = (NativeViewGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.a(handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                handler.M = config.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                handler.N = config.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new NativeViewGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            NativeViewGestureHandler handler = (NativeViewGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new NativeGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46832b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46831a;
        }
    }

    @Metadata
    public static final class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46833a = PanGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46834b = "PanGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final void a(GestureHandler gestureHandler, ReadableMap config) {
            boolean z;
            PanGestureHandler handler = (PanGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.a(handler, config);
            boolean z2 = true;
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                handler.Q = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START));
                z = true;
            } else {
                z = false;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                handler.R = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                handler.S = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                handler.T = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                handler.U = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                handler.V = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                handler.W = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                handler.X = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                float fB = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY));
                handler.a0 = fB * fB;
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                handler.Y = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                handler.Z = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y));
            } else {
                z2 = z;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                float fB2 = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST));
                handler.P = fB2 * fB2;
            } else if (z2) {
                handler.P = Float.POSITIVE_INFINITY;
            }
            if (config.hasKey("minPointers")) {
                handler.b0 = config.getInt("minPointers");
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                handler.c0 = config.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                handler.k0 = config.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS)) {
                handler.l0 = config.getInt(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new PanGestureHandler(reactApplicationContext);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            PanGestureHandler handler = (PanGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PanGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46834b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46833a;
        }
    }

    @Metadata
    public static final class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46835a = PinchGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46836b = "PinchGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new PinchGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            PinchGestureHandler handler = (PinchGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PinchGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46836b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46835a;
        }
    }

    @Metadata
    public static final class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46837a = RotationGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46838b = "RotationGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new RotationGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            RotationGestureHandler handler = (RotationGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new RotationGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46838b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46837a;
        }
    }

    @Metadata
    public static final class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f46839a = TapGestureHandler.class;

        /* renamed from: b, reason: collision with root package name */
        public final String f46840b = "TapGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final void a(GestureHandler gestureHandler, ReadableMap config) {
            TapGestureHandler handler = (TapGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.a(handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                handler.R = config.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                handler.P = config.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                handler.Q = config.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                handler.M = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                handler.N = PixelUtil.b((float) config.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y));
            }
            if (config.hasKey("maxDist")) {
                float fB = PixelUtil.b((float) config.getDouble("maxDist"));
                handler.O = fB * fB;
            }
            if (config.hasKey("minPointers")) {
                handler.S = config.getInt("minPointers");
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandler b(ReactApplicationContext reactApplicationContext) {
            return new TapGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final GestureHandlerEventDataBuilder c(GestureHandler gestureHandler) {
            TapGestureHandler handler = (TapGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new TapGestureHandlerEventDataBuilder(handler);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final String d() {
            return this.f46840b;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public final Class e() {
            return this.f46839a;
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.swmansion.gesturehandler.react.RNGestureHandlerModule$eventListener$1] */
    public RNGestureHandlerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.eventListener = new OnTouchEventListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerModule$eventListener$1
            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public final void a(GestureHandler handler, int i2, int i3) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                this.f46841a.onStateChange(handler, i2, i3);
            }

            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public final void b(GestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                this.f46841a.onTouchEvent(handler);
            }

            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public final void c(GestureHandler handler, MotionEvent event) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(event, "event");
                this.f46841a.onHandlerUpdate(handler);
            }
        };
        this.handlerFactories = new HandlerFactory[]{new NativeViewGestureHandlerFactory(), new TapGestureHandlerFactory(), new LongPressGestureHandlerFactory(), new PanGestureHandlerFactory(), new PinchGestureHandlerFactory(), new RotationGestureHandlerFactory(), new FlingGestureHandlerFactory(), new ManualGestureHandlerFactory(), new HoverGestureHandlerFactory()};
        this.registry = new RNGestureHandlerRegistry();
        this.interactionManager = new RNGestureHandlerInteractionManager();
        this.roots = new ArrayList();
        this.reanimatedEventDispatcher = new ReanimatedEventDispatcher();
    }

    private final <T extends GestureHandler<T>> void createGestureHandlerHelper(String str, int i2, ReadableMap readableMap) {
        if (this.registry.d(i2) != null) {
            throw new IllegalStateException(android.support.v4.media.b.g(i2, "Handler with tag ", " already exists. Please ensure that no Gesture instance is used across multiple GestureDetectors."));
        }
        for (HandlerFactory<?> handlerFactory : this.handlerFactories) {
            if (Intrinsics.b(handlerFactory.d(), str)) {
                GestureHandler gestureHandlerB = handlerFactory.b(getReactApplicationContext());
                gestureHandlerB.f46717d = i2;
                gestureHandlerB.B = this.eventListener;
                this.registry.f(gestureHandlerB);
                this.interactionManager.a(gestureHandlerB, readableMap);
                handlerFactory.a(gestureHandlerB, readableMap);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.C("Invalid handler name ", str));
    }

    private final native void decorateRuntime(long j2);

    private final <T extends GestureHandler<T>> HandlerFactory<T> findFactoryForHandler(GestureHandler<T> gestureHandler) {
        for (Object obj : this.handlerFactories) {
            HandlerFactory<T> handlerFactory = (HandlerFactory<T>) obj;
            if (Intrinsics.b(handlerFactory.e(), gestureHandler.getClass())) {
                return handlerFactory;
            }
        }
        return null;
    }

    private final RNGestureHandlerRootHelper findRootHelperForViewAncestor(int i2) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        int iResolveRootTagFromReactTag = ExtensionsKt.b(reactApplicationContext).resolveRootTagFromReactTag(i2);
        Object obj = null;
        if (iResolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.roots) {
            try {
                Iterator<T> it = this.roots.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    ViewGroup viewGroup = ((RNGestureHandlerRootHelper) next).f46848d;
                    if ((viewGroup instanceof ReactRootView) && ((ReactRootView) viewGroup).getRootViewTag() == iResolveRootTagFromReactTag) {
                        obj = next;
                        break;
                    }
                }
                rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rNGestureHandlerRootHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void install$lambda$2(RNGestureHandlerModule rNGestureHandlerModule) {
        try {
            SoLoader.m("gesturehandler");
            JavaScriptContextHolder javaScriptContextHolder = rNGestureHandlerModule.getReactApplicationContext().getJavaScriptContextHolder();
            Intrinsics.c(javaScriptContextHolder);
            rNGestureHandlerModule.decorateRuntime(javaScriptContextHolder.get());
        } catch (Exception unused) {
            Log.w("[RNGestureHandler]", "Could not install JSI bindings.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onHandlerUpdate(T t) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        if (t.f46717d >= 0 && t.f46719f == 4 && (handlerFactoryFindFactoryForHandler = findFactoryForHandler(t)) != null) {
            int i2 = t.f46724k;
            if (i2 == 1) {
                Pools.SynchronizedPool synchronizedPool = RNGestureHandlerEvent.f46816d;
                sendEventForReanimated(RNGestureHandlerEvent.Companion.b(t, handlerFactoryFindFactoryForHandler.c(t), false));
                return;
            }
            if (i2 == 2) {
                Pools.SynchronizedPool synchronizedPool2 = RNGestureHandlerEvent.f46816d;
                sendEventForNativeAnimatedEvent(RNGestureHandlerEvent.Companion.b(t, handlerFactoryFindFactoryForHandler.c(t), true));
            } else if (i2 == 3) {
                Pools.SynchronizedPool synchronizedPool3 = RNGestureHandlerEvent.f46816d;
                sendEventForDirectEvent(RNGestureHandlerEvent.Companion.b(t, handlerFactoryFindFactoryForHandler.c(t), false));
            } else if (i2 == 4) {
                Pools.SynchronizedPool synchronizedPool4 = RNGestureHandlerEvent.f46816d;
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.Companion.a(handlerFactoryFindFactoryForHandler.c(t)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onStateChange(T t, int i2, int i3) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        if (t.f46717d >= 0 && (handlerFactoryFindFactoryForHandler = findFactoryForHandler(t)) != null) {
            int i4 = t.f46724k;
            if (i4 == 1) {
                Pools.SynchronizedPool synchronizedPool = RNGestureHandlerStateChangeEvent.f46853d;
                sendEventForReanimated(RNGestureHandlerStateChangeEvent.Companion.b(t, i2, i3, handlerFactoryFindFactoryForHandler.c(t)));
            } else if (i4 == 2 || i4 == 3) {
                Pools.SynchronizedPool synchronizedPool2 = RNGestureHandlerStateChangeEvent.f46853d;
                sendEventForDirectEvent(RNGestureHandlerStateChangeEvent.Companion.b(t, i2, i3, handlerFactoryFindFactoryForHandler.c(t)));
            } else if (i4 == 4) {
                Pools.SynchronizedPool synchronizedPool3 = RNGestureHandlerStateChangeEvent.f46853d;
                sendEventForDeviceEvent("onGestureHandlerStateChange", RNGestureHandlerStateChangeEvent.Companion.a(handlerFactoryFindFactoryForHandler.c(t), i2, i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onTouchEvent(T t) {
        if (t.f46717d < 0) {
            return;
        }
        int i2 = t.f46719f;
        if (i2 == 2 || i2 == 4 || i2 == 0 || t.f46718e != null) {
            int i3 = t.f46724k;
            if (i3 == 1) {
                Pools.SynchronizedPool synchronizedPool = RNGestureHandlerTouchEvent.f46857c;
                sendEventForReanimated(RNGestureHandlerTouchEvent.Companion.b(t));
            } else if (i3 == 4) {
                Pools.SynchronizedPool synchronizedPool2 = RNGestureHandlerTouchEvent.f46857c;
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerTouchEvent.Companion.a(t));
            }
        }
    }

    private final void sendEventForDeviceEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ExtensionsKt.a(reactApplicationContext).emit(str, writableMap);
    }

    private final <T extends Event<T>> void sendEventForDirectEvent(T t) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ReactContextExtensionsKt.a(reactApplicationContext, t);
    }

    private final void sendEventForNativeAnimatedEvent(RNGestureHandlerEvent rNGestureHandlerEvent) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ReactContextExtensionsKt.a(reactApplicationContext, rNGestureHandlerEvent);
    }

    private final <T extends Event<T>> void sendEventForReanimated(T t) {
        sendEventForDirectEvent(t);
    }

    private final <T extends GestureHandler<T>> void updateGestureHandlerHelper(int i2, ReadableMap readableMap) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        GestureHandler gestureHandlerD = this.registry.d(i2);
        if (gestureHandlerD == null || (handlerFactoryFindFactoryForHandler = findFactoryForHandler(gestureHandlerD)) == null) {
            return;
        }
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
        rNGestureHandlerInteractionManager.f46820a.remove(i2);
        rNGestureHandlerInteractionManager.f46821b.remove(i2);
        this.interactionManager.a(gestureHandlerD, readableMap);
        handlerFactoryFindFactoryForHandler.a(gestureHandlerD, readableMap);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void attachGestureHandler(double d2, double d3, double d4) {
        int i2 = (int) d2;
        if (!this.registry.a(i2, (int) d3, (int) d4)) {
            throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.g(i2, "Handler with tag ", " does not exists"));
        }
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void createGestureHandler(@NotNull String handlerName, double d2, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        Intrinsics.checkNotNullParameter(config, "config");
        createGestureHandlerHelper(handlerName, (int) d2, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void dropGestureHandler(double d2) {
        int i2 = (int) d2;
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
        rNGestureHandlerInteractionManager.f46820a.remove(i2);
        rNGestureHandlerInteractionManager.f46821b.remove(i2);
        this.registry.c(i2);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void flushOperations() {
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @NotNull
    public Map<String, Object> getConstants() {
        return MapsKt.h(new Pair("State", MapsKt.h(new Pair("UNDETERMINED", 0), new Pair("BEGAN", 2), new Pair("ACTIVE", 4), new Pair("CANCELLED", 3), new Pair("FAILED", 1), new Pair("END", 5))), new Pair("Direction", MapsKt.h(new Pair("RIGHT", 1), new Pair("LEFT", 2), new Pair("UP", 4), new Pair("DOWN", 8))));
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNGestureHandlerModule";
    }

    @NotNull
    public final RNGestureHandlerRegistry getRegistry() {
        return this.registry;
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleClearJSResponder() {
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleSetJSResponder(double d2, boolean z) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelperFindRootHelperForViewAncestor = findRootHelperForViewAncestor((int) d2);
        if (rNGestureHandlerRootHelperFindRootHelperForViewAncestor == null || !z) {
            return;
        }
        UiThreadUtil.runOnUiThread(new b(rNGestureHandlerRootHelperFindRootHelperForViewAncestor, 0));
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public boolean install() {
        getReactApplicationContext().runOnJSQueueThread(new androidx.constraintlayout.helper.widget.a(this, 29));
        return true;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = this.registry;
        synchronized (rNGestureHandlerRegistry) {
            rNGestureHandlerRegistry.f46842a.clear();
            rNGestureHandlerRegistry.f46843b.clear();
            rNGestureHandlerRegistry.f46844c.clear();
        }
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
        rNGestureHandlerInteractionManager.f46820a.clear();
        rNGestureHandlerInteractionManager.f46821b.clear();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                try {
                    int size = this.roots.size();
                    this.roots.get(0).b();
                    if (this.roots.size() >= size) {
                        throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Unit unit = Unit.f53572a;
        }
        super.invalidate();
    }

    public final void registerRootHelper(@NotNull RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            if (this.roots.contains(root)) {
                throw new IllegalStateException("Root helper" + root + " already registered");
            }
            this.roots.add(root);
        }
    }

    @Override // com.swmansion.common.GestureHandlerStateManager
    public void setGestureHandlerState(int i2, int i3) {
        GestureHandler gestureHandlerD = this.registry.d(i2);
        if (gestureHandlerD != null) {
            if (i3 == 1) {
                gestureHandlerD.l();
                return;
            }
            if (i3 == 2) {
                gestureHandlerD.d();
                return;
            }
            if (i3 == 3) {
                gestureHandlerD.e();
            } else if (i3 == 4) {
                gestureHandlerD.a(true);
            } else {
                if (i3 != 5) {
                    return;
                }
                gestureHandlerD.j();
            }
        }
    }

    public final void unregisterRootHelper(@NotNull RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.remove(root);
        }
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void updateGestureHandler(double d2, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        updateGestureHandlerHelper((int) d2, config);
    }
}
