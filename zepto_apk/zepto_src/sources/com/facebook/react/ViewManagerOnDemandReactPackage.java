package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collection;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ViewManagerOnDemandReactPackage {
    ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str);

    Collection getViewManagerNames(ReactApplicationContext reactApplicationContext);
}
