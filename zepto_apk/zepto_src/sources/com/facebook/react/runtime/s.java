package com.facebook.react.runtime;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.runtime.ReactInstance;
import com.facebook.react.runtime.internal.bolts.TaskCompletionSource;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class s implements UIConstantsProviderBinding.ConstantsForViewManagerProvider, UIConstantsProviderBinding.ConstantsProvider, PackagerStatusCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f19357a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19358b;

    public /* synthetic */ s(Object obj, Object obj2) {
        this.f19357a = obj;
        this.f19358b = obj2;
    }

    @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
    public void a(boolean z) {
        AtomicInteger atomicInteger = ReactHostImpl.A;
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f19357a;
        reactHostImpl.getClass();
        reactHostImpl.r("isMetroRunning()", "Async result = " + z);
        ((TaskCompletionSource) this.f19358b).c(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.uimanager.UIConstantsProviderBinding.ConstantsProvider
    public NativeMap getConstants() {
        boolean z = ReactInstance.f19261h;
        ReactInstance reactInstance = (ReactInstance) this.f19357a;
        reactInstance.getClass();
        ReactInstance.BridgelessViewManagerResolver bridgelessViewManagerResolver = reactInstance.f19267f;
        Map<String, Object> mapCreateConstants = UIManagerModule.createConstants(new ArrayList(((HashMap) bridgelessViewManagerResolver.c()).values()), null, (HashMap) this.f19358b);
        HashSet hashSetD = bridgelessViewManagerResolver.d();
        if (hashSetD.size() > 0) {
            mapCreateConstants.put("ViewManagerNames", new ArrayList(hashSetD));
            mapCreateConstants.put("LazyViewManagersEnabled", Boolean.TRUE);
        }
        return Arguments.makeNativeMap(mapCreateConstants);
    }

    @Override // com.facebook.react.uimanager.UIConstantsProviderBinding.ConstantsForViewManagerProvider
    public NativeMap getConstantsForViewManager(String str) {
        ViewManager viewManagerB = ((ReactInstance) this.f19357a).f19267f.b(str);
        if (viewManagerB == null) {
            return null;
        }
        return (NativeMap) UIManagerModule.getConstantsForViewManager(viewManagerB, (HashMap) this.f19358b);
    }
}
