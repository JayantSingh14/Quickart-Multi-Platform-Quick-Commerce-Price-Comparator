package io.invertase.firebase.app;

import android.content.Context;
import android.util.Log;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import io.invertase.firebase.utils.ReactNativeFirebaseUtilsModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ReactNativeFirebaseAppPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public final List createNativeModules(ReactApplicationContext reactApplicationContext) {
        if (ReactNativeFirebaseApp.f49227a == null) {
            Context applicationContext = reactApplicationContext.getApplicationContext();
            Log.d("ReactNativeFirebaseApp", "received application context.");
            ReactNativeFirebaseApp.f49227a = applicationContext;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactNativeFirebaseAppModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseUtilsModule(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }
}
