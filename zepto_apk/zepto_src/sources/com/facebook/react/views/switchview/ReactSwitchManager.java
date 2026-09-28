package com.facebook.react.views.switchview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.zeptoconsumerapp.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactSwitchManager extends BaseViewManager<ReactSwitch, ReactSwitchShadowNode> implements AndroidSwitchManagerInterface<ReactSwitch> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new a();

    @NotNull
    public static final String REACT_CLASS = "AndroidSwitch";

    @NotNull
    private final ViewManagerDelegate<ReactSwitch> delegate = new AndroidSwitchManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ON_CHECKED_CHANGE_LISTENER$lambda$2(CompoundButton compoundButton, boolean z) {
        Context context = compoundButton.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int id = compoundButton.getId();
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, id);
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ReactSwitchEvent(UIManagerHelper.d(reactContext), id, z));
        }
    }

    private final void setValueInternal(ReactSwitch reactSwitch, boolean z) throws Resources.NotFoundException {
        reactSwitch.setOnCheckedChangeListener(null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ReactSwitch> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Class<ReactSwitchShadowNode> getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(@NotNull Context context, @Nullable ReadableMap readableMap, @Nullable ReadableMap readableMap2, @Nullable ReadableMap readableMap3, float f2, @NotNull YogaMeasureMode widthMode, float f3, @NotNull YogaMeasureMode heightMode, @Nullable float[] fArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        reactSwitch.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        return YogaMeasureOutput.a(PixelUtil.a(reactSwitch.getMeasuredWidth()), PixelUtil.a(reactSwitch.getMeasuredHeight()));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(@NotNull ReactSwitch root, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactSwitch view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactSwitchShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactSwitch createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactSwitch view, @NotNull String commandId, @Nullable ReadableArray readableArray) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (Intrinsics.b(commandId, "setNativeValue")) {
            setValueInternal(view, readableArray != null ? readableArray.getBoolean(0) : false);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setBackgroundColor(@NotNull ReactSwitch view, @ColorInt int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundColor(i2);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(@NotNull ReactSwitch view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(!z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "enabled")
    public void setEnabled(@NotNull ReactSwitch view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    public void setNativeValue(@NotNull ReactSwitch view, boolean z) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        setValueInternal(view, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(name = "on")
    public void setOn(@NotNull ReactSwitch view, boolean z) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        setValueInternal(view, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "thumbColor")
    public void setThumbColor(@NotNull ReactSwitch view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setThumbColor(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(@NotNull ReactSwitch view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        setThumbColor(view, num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(@NotNull ReactSwitch view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTrackColorForFalse(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(@NotNull ReactSwitch view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTrackColorForTrue(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(@NotNull ReactSwitch view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTrackColor(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(name = CLConstants.FIELD_PAY_INFO_VALUE)
    public void setValue(@NotNull ReactSwitch view, boolean z) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        setValueInternal(view, z);
    }
}
