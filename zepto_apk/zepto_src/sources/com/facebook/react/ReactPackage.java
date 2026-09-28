package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ReactPackage {
    List createNativeModules(ReactApplicationContext reactApplicationContext);

    List createViewManagers(ReactApplicationContext reactApplicationContext);
}
