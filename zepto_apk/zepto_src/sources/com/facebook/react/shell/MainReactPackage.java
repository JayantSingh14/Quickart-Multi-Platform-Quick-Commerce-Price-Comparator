package com.facebook.react.shell;

import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.modules.devtoolsruntimesettings.ReactDevToolsRuntimeSettingsModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.reactdevtoolssettings.ReactDevToolsSettingsManagerModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.safeareaview.ReactSafeAreaViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MainReactPackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {

    /* renamed from: a, reason: collision with root package name */
    public final MainPackageConfig f19360a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19361b;

    @JvmOverloads
    public MainReactPackage() {
        this(null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.Map] */
    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final ViewManager createViewManager(ReactApplicationContext reactContext, String viewManagerName) {
        Provider<? extends NativeModule> provider;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ModuleSpec moduleSpec = (ModuleSpec) this.f19361b.get(viewManagerName);
        NativeModule nativeModule = (moduleSpec == null || (provider = moduleSpec.getProvider()) == null) ? null : (NativeModule) provider.get();
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.I(new ReactDrawerLayoutManager(), new ReactHorizontalScrollViewManager(), new ReactHorizontalScrollContainerViewManager(), new ReactProgressBarViewManager(), new ReactScrollViewManager(), new ReactSwitchManager(), new ReactSafeAreaViewManager(), new SwipeRefreshLayoutManager(), new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null), new ReactImageManager(null, null, null, 7, null), new ReactModalHostManager(), new ReactRawTextManager(), new ReactTextInputManager(), new ReactTextViewManager(), new ReactViewManager(), new ReactVirtualTextViewManager(), new ReactUnimplementedViewManager());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -2115067288:
                if (name.equals("ToastAndroid")) {
                    return new ToastModule(reactContext);
                }
                return null;
            case -1962922905:
                if (name.equals("ImageStoreManager")) {
                    return new ImageStoreManager(reactContext);
                }
                return null;
            case -1850625090:
                if (name.equals("SoundManager")) {
                    return new SoundManagerModule(reactContext);
                }
                return null;
            case -1654566518:
                if (name.equals(NativeDialogManagerAndroidSpec.NAME)) {
                    return new DialogModule(reactContext);
                }
                return null;
            case -1344126773:
                if (name.equals(NativeFileReaderModuleSpec.NAME)) {
                    return new FileReaderModule(reactContext);
                }
                return null;
            case -1067020766:
                if (name.equals("ReactDevToolsRuntimeSettingsModule")) {
                    return new ReactDevToolsRuntimeSettingsModule(reactContext);
                }
                return null;
            case -1062061717:
                if (name.equals("PermissionsAndroid")) {
                    return new PermissionsModule(reactContext);
                }
                return null;
            case -657277650:
                if (name.equals("ImageLoader")) {
                    return new ImageLoaderModule(reactContext);
                }
                return null;
            case -585704955:
                if (name.equals("ReactDevToolsSettingsManager")) {
                    return new ReactDevToolsSettingsManagerModule(reactContext);
                }
                return null;
            case -570370161:
                if (name.equals("I18nManager")) {
                    return new I18nManagerModule(reactContext);
                }
                return null;
            case -504784764:
                if (name.equals("Appearance")) {
                    return new AppearanceModule(reactContext, null, 2, null);
                }
                return null;
            case -457866500:
                if (name.equals("AccessibilityInfo")) {
                    return new AccessibilityInfoModule(reactContext);
                }
                return null;
            case -382654004:
                if (name.equals("StatusBarManager")) {
                    return new StatusBarModule(reactContext);
                }
                return null;
            case -254310125:
                if (name.equals("WebSocketModule")) {
                    return new WebSocketModule(reactContext);
                }
                return null;
            case -99249460:
                if (name.equals("DevLoadingView")) {
                    return new DevLoadingModule(reactContext);
                }
                return null;
            case 163245714:
                if (name.equals(FrescoModule.NAME)) {
                    MainPackageConfig mainPackageConfig = this.f19360a;
                    return new FrescoModule(reactContext, true, mainPackageConfig != null ? mainPackageConfig.f19359a : null);
                }
                return null;
            case 403570038:
                if (name.equals("Clipboard")) {
                    return new ClipboardModule(reactContext);
                }
                return null;
            case 563961875:
                if (name.equals("IntentAndroid")) {
                    return new IntentModule(reactContext);
                }
                return null;
            case 1221389072:
                if (name.equals("AppState")) {
                    return new AppStateModule(reactContext);
                }
                return null;
            case 1515242260:
                if (name.equals(NativeNetworkingAndroidSpec.NAME)) {
                    return new NetworkingModule(reactContext);
                }
                return null;
            case 1547941001:
                if (name.equals(NativeBlobModuleSpec.NAME)) {
                    return new BlobModule(reactContext);
                }
                return null;
            case 1555425035:
                if (name.equals("ShareModule")) {
                    return new ShareModule(reactContext);
                }
                return null;
            case 1721274886:
                if (name.equals(NativeAnimatedModuleSpec.NAME)) {
                    return new NativeAnimatedModule(reactContext);
                }
                return null;
            case 1922110066:
                if (name.equals("Vibration")) {
                    return new VibrationModule(reactContext);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, DevLoadingModule.class, FileReaderModule.class, ClipboardModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ReactDevToolsSettingsManagerModule.class, ReactDevToolsRuntimeSettingsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 24; i2++) {
            Class cls = clsArr[i2];
            if (cls.isAnnotationPresent(ReactModule.class)) {
                arrayList.add(cls);
            }
        }
        int iF = MapsKt.f(CollectionsKt.r(arrayList, 10));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            Annotation annotation = cls2.getAnnotation(ReactModule.class);
            if (annotation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ReactModule reactModule = (ReactModule) annotation;
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            linkedHashMap.put(strName, new ReactModuleInfo(strName2, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.Companion.a(cls2)));
        }
        return new a(linkedHashMap, 0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final Collection getViewManagerNames(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.f19361b.keySet();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    @Override // com.facebook.react.BaseReactPackage
    public final List getViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.e0(this.f19361b.values());
    }

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.f19360a = mainPackageConfig;
        final int i2 = 8;
        final int i3 = 16;
        final int i4 = 0;
        final int i5 = 1;
        final int i6 = 2;
        final int i7 = 3;
        final int i8 = 4;
        final int i9 = 5;
        final int i10 = 6;
        final int i11 = 7;
        final int i12 = 9;
        final int i13 = 10;
        final int i14 = 11;
        final int i15 = 12;
        final int i16 = 13;
        final int i17 = 14;
        final int i18 = 15;
        this.f19361b = MapsKt.h(new Pair(ReactDrawerLayoutManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i2) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactHorizontalScrollViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i3) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactHorizontalScrollContainerViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i4) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactProgressBarViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i5) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactSafeAreaViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i6) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactScrollViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i7) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactSwitchManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i8) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(SwipeRefreshLayoutManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i9) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(FrescoBasedReactTextInlineImageViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i10) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactImageManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i11) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactModalHostManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i12) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactRawTextManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i13) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactTextInputManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i14) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactTextViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i15) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i16) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactVirtualTextViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i17) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })), new Pair(ReactUnimplementedViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.b
            @Override // javax.inject.Provider
            public final Object get() {
                switch (i18) {
                    case 0:
                        return new ReactHorizontalScrollContainerViewManager();
                    case 1:
                        return new ReactProgressBarViewManager();
                    case 2:
                        return new ReactSafeAreaViewManager();
                    case 3:
                        return new ReactScrollViewManager();
                    case 4:
                        return new ReactSwitchManager();
                    case 5:
                        return new SwipeRefreshLayoutManager();
                    case 6:
                        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
                    case 7:
                        return new ReactImageManager(null, null, null, 7, null);
                    case 8:
                        return new ReactDrawerLayoutManager();
                    case 9:
                        return new ReactModalHostManager();
                    case 10:
                        return new ReactRawTextManager();
                    case 11:
                        return new ReactTextInputManager();
                    case 12:
                        return new ReactTextViewManager();
                    case 13:
                        return new ReactViewManager();
                    case 14:
                        return new ReactVirtualTextViewManager();
                    case 15:
                        return new ReactUnimplementedViewManager();
                    default:
                        return new ReactHorizontalScrollViewManager();
                }
            }
        })));
    }
}
