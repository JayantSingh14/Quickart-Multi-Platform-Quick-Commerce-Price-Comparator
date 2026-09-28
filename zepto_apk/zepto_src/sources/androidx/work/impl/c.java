package androidx.work.impl;

import android.content.Context;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.reactnativecommunity.webview.RNCWebChromeClient;
import com.swmansion.rnscreens.ScreenContainer;
import com.swmansion.rnscreens.ScreensShadowNode;
import com.truecaller.android.sdk.oAuth.TcSdk;
import com.zeptoconsumerapp.MainActivity;
import io.sentry.IScope;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.EventListener$Companion$NONE$1;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements SupportSQLiteOpenHelper.Factory, ComponentFactory, Deferred.DeferredHandler, Continuation, PermissionListener, UIManagerModule.CustomEventNamesResolver, UIBlock, ActivityResultCallback, ScopeCallback, Scope.IWithPropagationContext, EventListener.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12793a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12794b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f12793a = i2;
        this.f12794b = obj;
    }

    @Override // io.sentry.Scope.IWithPropagationContext
    public void a(PropagationContext propagationContext) {
        ((IScope) this.f12794b).H(new PropagationContext());
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void b(Object obj) {
        MainActivity mainActivity = (MainActivity) this.f12794b;
        ActivityResult result = (ActivityResult) obj;
        int i2 = MainActivity.f47520l;
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            TcSdk.getInstance().onActivityResultObtained(mainActivity, result.f198a, result.f199b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object c(ComponentContainer componentContainer) {
        return this.f12794b;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener d(RealCall it) {
        byte[] bArr = Util.f56394a;
        EventListener$Companion$NONE$1 this_asFactory = (EventListener$Companion$NONE$1) this.f12794b;
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    @Override // com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver
    public String e(String str) {
        return ((UIManager) this.f12794b).resolveCustomDirectEventName(str);
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void f(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = (CrashlyticsNativeComponentDeferredProxy) this.f12794b;
        crashlyticsNativeComponentDeferredProxy.getClass();
        Logger.f43705a.b("Crashlytics native component now available.", null);
        crashlyticsNativeComponentDeferredProxy.f43700b.set((CrashlyticsNativeComponent) provider.get());
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper g(SupportSQLiteOpenHelper.Configuration configuration) {
        Context context = (Context) this.f12794b;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        SupportSQLiteOpenHelper.Configuration.Builder builderA = SupportSQLiteOpenHelper.Configuration.Companion.a(context);
        builderA.f11902b = configuration.f11897b;
        SupportSQLiteOpenHelper.Callback callback = configuration.f11898c;
        Intrinsics.checkNotNullParameter(callback, "callback");
        builderA.f11903c = callback;
        builderA.f11904d = true;
        builderA.f11905e = true;
        return new FrameworkSQLiteOpenHelperFactory().g(builderA.a());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    @Override // io.sentry.ScopeCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(io.sentry.IScope r9) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.c.h(io.sentry.IScope):void");
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
        int i2 = ScreensShadowNode.A;
        if (nativeViewHierarchyManager == null) {
            return;
        }
        View viewResolveView = nativeViewHierarchyManager.resolveView(((ScreensShadowNode) this.f12794b).f19456a);
        if (viewResolveView instanceof ScreenContainer) {
            ((ScreenContainer) viewResolveView).g();
        }
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        PermissionRequest permissionRequest;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        GeolocationPermissions.Callback callback;
        String str;
        RNCWebChromeClient rNCWebChromeClient = (RNCWebChromeClient) this.f12794b;
        rNCWebChromeClient.f46237h = false;
        boolean z = false;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str2 = strArr[i3];
            boolean z2 = iArr[i3] == 0;
            if (str2.equals("android.permission.ACCESS_FINE_LOCATION") && (callback = rNCWebChromeClient.f46235f) != null && (str = rNCWebChromeClient.f46236g) != null) {
                if (z2) {
                    callback.invoke(str, true, false);
                } else {
                    callback.invoke(str, false, false);
                }
                rNCWebChromeClient.f46235f = null;
                rNCWebChromeClient.f46236g = null;
            }
            if (str2.equals("android.permission.RECORD_AUDIO")) {
                if (z2 && (arrayList4 = rNCWebChromeClient.f46234e) != null) {
                    arrayList4.add("android.webkit.resource.AUDIO_CAPTURE");
                }
                z = true;
            }
            if (str2.equals("android.permission.CAMERA")) {
                if (z2 && (arrayList3 = rNCWebChromeClient.f46234e) != null) {
                    arrayList3.add("android.webkit.resource.VIDEO_CAPTURE");
                }
                z = true;
            }
            if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (z2 && (arrayList2 = rNCWebChromeClient.f46234e) != null) {
                    arrayList2.add("android.webkit.resource.PROTECTED_MEDIA_ID");
                }
                z = true;
            }
        }
        if (z && (permissionRequest = rNCWebChromeClient.f46233d) != null && (arrayList = rNCWebChromeClient.f46234e) != null) {
            permissionRequest.grant((String[]) arrayList.toArray(new String[0]));
            rNCWebChromeClient.f46233d = null;
            rNCWebChromeClient.f46234e = null;
        }
        ArrayList arrayList5 = rNCWebChromeClient.f46238i;
        if (arrayList5.isEmpty()) {
            return true;
        }
        rNCWebChromeClient.a(arrayList5);
        return false;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        ((Runnable) this.f12794b).run();
        return Tasks.e(null);
    }
}
