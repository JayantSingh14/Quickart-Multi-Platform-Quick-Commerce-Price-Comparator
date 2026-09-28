package com.zeptoconsumerapp.AppSetIdGenerator;

import android.content.Context;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: classes.dex */
public class AppSetIdGeneratorModule extends ReactContextBaseJavaModule {
    private static final String APP_SET_ID = "appSetId";
    private Context context;

    public AppSetIdGeneratorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext;
    }

    @ReactMethod
    public void getAppSetId(final Promise promise) {
        AppSet.a(this.context).a().e(new OnSuccessListener<AppSetIdInfo>() { // from class: com.zeptoconsumerapp.AppSetIdGenerator.AppSetIdGeneratorModule.1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                appSetIdInfo.getClass();
                Promise promise2 = promise;
                String str = appSetIdInfo.f21994a;
                if (str != null) {
                    promise2.resolve(str);
                } else {
                    promise2.reject(new Throwable(""));
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AppSetIdGenerator";
    }
}
