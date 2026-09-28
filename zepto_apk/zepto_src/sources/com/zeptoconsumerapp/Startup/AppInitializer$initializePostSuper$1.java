package com.zeptoconsumerapp.Startup;

import android.content.Context;
import android.content.SharedPreferences;
import bridges.CommsModule;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.phoenix.Phoenix;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.Startup.AppCacheManager;
import com.zeptoconsumerapp.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.Startup.AppInitializer$initializePostSuper$1", f = "AppInitializer.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AppInitializer$initializePostSuper$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppInitializer f47549a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInitializer$initializePostSuper$1(AppInitializer appInitializer, Continuation continuation) {
        super(2, continuation);
        this.f47549a = appInitializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppInitializer$initializePostSuper$1(this.f47549a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AppInitializer$initializePostSuper$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        Context context = this.f47549a.f47548a;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            if (sharedPreferences.getInt("APP_VERSION_NUMBER", 0) < 618) {
                try {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("appDetailsResponse", "").apply();
                    editorEdit.apply();
                } catch (Exception e2) {
                    Utils.i(e2);
                }
                try {
                    AppCacheManager.Companion.a(context.getCacheDir());
                } catch (Exception e3) {
                    Utils.i(e3);
                }
            }
            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
            editorEdit2.putInt("APP_VERSION_NUMBER", BuildConfig.VERSION_CODE).apply();
            editorEdit2.apply();
        } catch (Exception e4) {
            Utils.i(e4);
        }
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            Intrinsics.checkNotNullExpressionValue(firebaseCrashlytics, "getInstance(...)");
            String strF = Phoenix.Companion.f();
            if (strF != null) {
                firebaseCrashlytics.setCustomKey("phoenix_manifest_status", "exist");
                JSONObject jSONObject = new JSONObject(strF);
                firebaseCrashlytics.setCustomKey("phoenix_bundle_version", jSONObject.optString("bundleVersion", zzck.UNKNOWN_CONTENT_TYPE));
                firebaseCrashlytics.setCustomKey("phoenix_js_version", jSONObject.optString("jsVersion", zzck.UNKNOWN_CONTENT_TYPE));
            } else {
                firebaseCrashlytics.setCustomKey("phoenix_manifest_status", "does not exist");
            }
        } catch (Exception unused) {
        }
        return Unit.f53572a;
    }
}
