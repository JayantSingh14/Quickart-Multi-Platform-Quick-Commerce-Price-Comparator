package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.RNCSafeAreaProviderManagerDelegate;
import com.facebook.react.viewmanagers.RNCSafeAreaProviderManagerInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = SafeAreaProviderManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> implements RNCSafeAreaProviderManagerInterface<SafeAreaProvider> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNCSafeAreaProvider";

    @NotNull
    private final RNCSafeAreaProviderManagerDelegate<SafeAreaProvider, SafeAreaProviderManager> mDelegate = new RNCSafeAreaProviderManagerDelegate<>(this);

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* renamed from: com.th3rdwave.safeareacontext.SafeAreaProviderManager$addEventEmitters$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<SafeAreaProvider, EdgeInsets, Rect, Unit> {

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass1 f47167b = new AnonymousClass1(3, SafeAreaProviderManagerKt.class, "handleOnInsetsChange", "handleOnInsetsChange(Lcom/th3rdwave/safeareacontext/SafeAreaProvider;Lcom/th3rdwave/safeareacontext/EdgeInsets;Lcom/th3rdwave/safeareacontext/Rect;)V", 1);

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            SafeAreaProvider p0 = (SafeAreaProvider) obj;
            EdgeInsets p1 = (EdgeInsets) obj2;
            Rect p2 = (Rect) obj3;
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            Context context = p0.getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext context2 = (ReactContext) context;
            int id = p0.getId();
            EventDispatcher eventDispatcherB = UIManagerHelper.b(context2, id);
            if (eventDispatcherB != null) {
                Intrinsics.checkNotNullParameter(context2, "context");
                eventDispatcherB.g(new InsetsChangeEvent(id, p1, p2));
            }
            return Unit.f53572a;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.i(new Pair("topInsetsChange", MapsKt.i(new Pair("registrationName", "onInsetsChange"))));
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

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull SafeAreaProvider view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, (ThemedReactContext) view);
        view.setOnInsetsChangeHandler(AnonymousClass1.f47167b);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public SafeAreaProvider createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SafeAreaProvider(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public RNCSafeAreaProviderManagerDelegate<SafeAreaProvider, SafeAreaProviderManager> getDelegate() {
        return this.mDelegate;
    }
}
