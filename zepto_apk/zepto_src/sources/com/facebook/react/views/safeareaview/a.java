package com.facebook.react.views.safeareaview;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.reanimated.keyboard.WindowsInsetsManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20003a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20004b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f20003a = i2;
        this.f20004b = obj;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsets) {
        Object obj = this.f20004b;
        switch (this.f20003a) {
            case 0:
                int i2 = ReactSafeAreaView.f19998c;
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
                final Insets insetsD = windowInsets.d(647);
                Intrinsics.checkNotNullExpressionValue(insetsD, "getInsets(...)");
                final ReactSafeAreaView reactSafeAreaView = (ReactSafeAreaView) obj;
                StateWrapper stateWrapper = reactSafeAreaView.f20000b;
                if (stateWrapper != null) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("left", PixelUtil.a(insetsD.f2808a));
                    writableNativeMap.putDouble("top", PixelUtil.a(insetsD.f2809b));
                    writableNativeMap.putDouble("bottom", PixelUtil.a(insetsD.f2811d));
                    writableNativeMap.putDouble("right", PixelUtil.a(insetsD.f2810c));
                    stateWrapper.updateState(writableNativeMap);
                } else {
                    final ThemedReactContext themedReactContext = reactSafeAreaView.f19999a;
                    themedReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(themedReactContext) { // from class: com.facebook.react.views.safeareaview.ReactSafeAreaView$updateState$2
                        @Override // com.facebook.react.bridge.GuardedRunnable
                        public final void runGuarded() {
                            ReactSafeAreaView reactSafeAreaView2 = reactSafeAreaView;
                            UIManagerModule uIManagerModule = (UIManagerModule) reactSafeAreaView2.getReactContext().f19479a.getNativeModule(UIManagerModule.class);
                            if (uIManagerModule != null) {
                                int id = reactSafeAreaView2.getId();
                                Insets insets = insetsD;
                                uIManagerModule.updateInsetsPadding(id, insets.f2809b, insets.f2808a, insets.f2811d, insets.f2810c);
                            }
                        }
                    });
                }
                return WindowInsetsCompat.f3149b;
            default:
                return ((WindowsInsetsManager) obj).onApplyWindowInsetsListener(view, windowInsets);
        }
    }
}
