package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        Component.Builder builderB = Component.b(CrashlyticsNativeComponent.class);
        builderB.f43563a = "fire-cls-ndk";
        builderB.a(Dependency.b(Context.class));
        builderB.f43568f = new ComponentFactory() { // from class: com.google.firebase.crashlytics.ndk.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                this.f44489a.getClass();
                Context context = (Context) componentContainer.a(Context.class);
                return new FirebaseCrashlyticsNdk(new CrashpadController(context, new JniNativeApi(context), new FileStore(context)), !(CommonUtils.e(context, "com.google.firebase.crashlytics.unity_version", "string") != 0));
            }
        };
        builderB.d(2);
        return Arrays.asList(builderB.b(), LibraryVersionComponent.a("fire-cls-ndk", "19.4.4"));
    }
}
