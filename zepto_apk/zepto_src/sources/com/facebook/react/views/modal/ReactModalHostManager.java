package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.view.View;
import androidx.media3.exoplayer.analytics.q;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.ModalHostViewManagerDelegate;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = ReactModalHostManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> implements ModalHostViewManagerInterface<ReactModalHostView> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RCTModalHostView";

    @NotNull
    private final ViewManagerDelegate<ReactModalHostView> delegate = new ModalHostViewManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$0(EventDispatcher eventDispatcher, ThemedReactContext themedReactContext, ReactModalHostView reactModalHostView, DialogInterface dialogInterface) {
        eventDispatcher.g(new RequestCloseEvent(UIManagerHelper.d(themedReactContext), reactModalHostView.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$1(EventDispatcher eventDispatcher, ThemedReactContext themedReactContext, ReactModalHostView reactModalHostView, DialogInterface dialogInterface) {
        eventDispatcher.g(new ShowEvent(UIManagerHelper.d(themedReactContext), reactModalHostView.getId()));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ReactModalHostView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap<>();
        }
        exportedCustomDirectEventTypeConstants.put("topRequestClose", MapsKt.g(new Pair("registrationName", "onRequestClose")));
        exportedCustomDirectEventTypeConstants.put("topShow", MapsKt.g(new Pair("registrationName", "onShow")));
        exportedCustomDirectEventTypeConstants.put("topDismiss", MapsKt.g(new Pair("registrationName", "onDismiss")));
        exportedCustomDirectEventTypeConstants.put("topOrientationChange", MapsKt.g(new Pair("registrationName", "onOrientationChange")));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "animated")
    public void setAnimated(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "identifier")
    public void setIdentifier(@NotNull ReactModalHostView view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "presentationStyle")
    public void setPresentationStyle(@NotNull ReactModalHostView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "supportedOrientations")
    public void setSupportedOrientations(@NotNull ReactModalHostView view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "visible")
    public void setVisible(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull final ThemedReactContext reactContext, @NotNull final ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        final EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, view.getId());
        if (eventDispatcherB != null) {
            view.setOnRequestCloseListener(new q(eventDispatcherB, reactContext, view, 2));
            view.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.facebook.react.views.modal.a
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ReactModalHostManager.addEventEmitters$lambda$1(eventDispatcherB, reactContext, view, dialogInterface);
                }
            });
            view.setEventDispatcher(eventDispatcherB);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactModalHostView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactModalHostView(reactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((ReactModalHostManager) view);
        view.c();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance((ReactModalHostManager) view);
        view.b();
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "animationType")
    public void setAnimationType(@NotNull ReactModalHostView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setAnimationType(str);
        }
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "hardwareAccelerated")
    public void setHardwareAccelerated(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHardwareAccelerated(z);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(z);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setTestId(@NotNull ReactModalHostView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTestId((ReactModalHostManager) view, str);
        view.setDialogRootViewGroupTestId(str);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "transparent")
    public void setTransparent(@NotNull ReactModalHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTransparent(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(@NotNull ReactModalHostView view, @NotNull ReactStylesDiffMap props, @NotNull StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        view.setStateWrapper(stateWrapper);
        return null;
    }
}
