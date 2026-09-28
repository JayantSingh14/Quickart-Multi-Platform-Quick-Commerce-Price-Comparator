package com.facebook.react.runtime;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import com.facebook.react.uimanager.UIManagerModuleConstantsHelper;

/* loaded from: classes3.dex */
public final /* synthetic */ class r implements UIConstantsProviderBinding.DefaultEventTypesProvider {
    @Override // com.facebook.react.uimanager.UIConstantsProviderBinding.DefaultEventTypesProvider
    public final NativeMap getDefaultEventTypes() {
        boolean z = ReactInstance.f19261h;
        return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.c());
    }
}
