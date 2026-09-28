package com.facebook.react.bridge;

import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.UiThread;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface UIManager extends PerformanceCounter {
    @Deprecated
    @ThreadConfined
    @UiThread
    <T extends View> int addRootView(T t, @Nullable WritableMap writableMap);

    void addUIManagerEventListener(@Nullable UIManagerListener uIManagerListener);

    void dispatchCommand(int i2, int i3, @Nullable ReadableArray readableArray);

    void dispatchCommand(int i2, @NotNull String str, @Nullable ReadableArray readableArray);

    @NotNull
    EventDispatcher getEventDispatcher();

    void initialize();

    void invalidate();

    void markActiveTouchForTag(int i2, int i3);

    void receiveEvent(int i2, int i3, @NotNull String str, @Nullable WritableMap writableMap);

    @Deprecated
    void receiveEvent(int i2, @NotNull String str, @Nullable WritableMap writableMap);

    void removeUIManagerEventListener(@Nullable UIManagerListener uIManagerListener);

    @Deprecated
    @Nullable
    String resolveCustomDirectEventName(@NotNull String str);

    @Nullable
    View resolveView(int i2);

    void sendAccessibilityEvent(int i2, int i3);

    @AnyThread
    <T extends View> int startSurface(T t, @NotNull String str, @Nullable WritableMap writableMap, int i2, int i3);

    @AnyThread
    void stopSurface(int i2);

    void sweepActiveTouchForTag(int i2, int i3);

    @ThreadConfined
    @UiThread
    void synchronouslyUpdateViewOnUIThread(int i2, @Nullable ReadableMap readableMap);

    @ThreadConfined
    @UiThread
    void updateRootLayoutSpecs(int i2, int i3, int i4, int i5, int i6);
}
