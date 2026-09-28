package com.rt2zz.reactnativecontacts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cl.json.a;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ReactNativeContacts extends TurboReactPackage {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap map = new HashMap();
        map.put(ContactsProvider.NAME, new ReactModuleInfo(ContactsProvider.NAME, ContactsProvider.NAME, false, false, false, false, 0));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage
    @Nullable
    public NativeModule getModule(@NonNull String str, @NonNull ReactApplicationContext reactApplicationContext) {
        if (str.equals(ContactsProvider.NAME)) {
            return new ContactsManager(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new a(6);
    }
}
