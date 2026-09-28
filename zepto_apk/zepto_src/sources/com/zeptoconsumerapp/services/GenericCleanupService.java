package com.zeptoconsumerapp.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import bridges.CommsModule;
import com.zeptoconsumerapp.AppServiceStarter.cleanup.CleanupAction;
import com.zeptoconsumerapp.AppServiceStarter.cleanup.CleanupActionRegistry;
import com.zeptoconsumerapp.services.GenericCleanupService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class GenericCleanupService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public static final String f47807c = Reflection.a(GenericCleanupService.class).i();

    /* renamed from: a, reason: collision with root package name */
    public String f47808a;

    /* renamed from: b, reason: collision with root package name */
    public Object f47809b = MapsKt.c();

    @Metadata
    public static final class Companion {
        public static final void a(String str) {
            String str2 = GenericCleanupService.f47807c;
            Timber.d(GenericCleanupService.f47807c).w(str, new Object[0]);
        }

        public static void b(String str, Throwable th) {
            if (th != null) {
                Timber.d(GenericCleanupService.f47807c).w(th, str, new Object[0]);
            } else {
                Timber.d(GenericCleanupService.f47807c).w(str, new Object[0]);
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        Map mapC;
        if (intent == null) {
            stopSelf(i3);
            return 2;
        }
        this.f47808a = intent.getStringExtra("cleanupActionType");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Set<String> setKeySet = extras.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            int iF = MapsKt.f(CollectionsKt.r(setKeySet, 10));
            if (iF < 16) {
                iF = 16;
            }
            mapC = new LinkedHashMap(iF);
            for (Object obj : setKeySet) {
                Object obj2 = extras.get((String) obj);
                if (!(obj2 instanceof String) && !(obj2 instanceof Integer) && !(obj2 instanceof Double) && !(obj2 instanceof Float) && !(obj2 instanceof Long)) {
                    boolean z = obj2 instanceof Boolean;
                }
                mapC.put(obj, obj2);
            }
        } else {
            mapC = MapsKt.c();
        }
        this.f47809b = mapC;
        Companion.a("Service started with action type: " + this.f47808a);
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, java.util.Map] */
    @Override // android.app.Service
    public final void onTaskRemoved(Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        Companion.a("App was killed - performing cleanup");
        String str = "";
        try {
            Companion.a("Starting doCleanupWork");
            Context applicationContext = getApplicationContext();
            String string = applicationContext.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).getString("accessToken", "");
            if (string != null) {
                str = string;
            }
            Companion.a("Access token length: " + str.length());
            String type = this.f47808a;
            if (type == null) {
                Companion.b("No cleanup action type specified", null);
                stopSelf();
            } else {
                LinkedHashMap linkedHashMap = CleanupActionRegistry.f47327a;
                Intrinsics.checkNotNullParameter(type, "type");
                CleanupAction cleanupAction = (CleanupAction) CleanupActionRegistry.f47327a.get(type);
                if (cleanupAction == 0) {
                    Companion.b("Unknown cleanup action type: ".concat(type), null);
                    stopSelf();
                } else {
                    Companion.a("Using cleanup action: ".concat(type));
                    Call callA = cleanupAction.a(applicationContext, str, this.f47809b);
                    if (callA == null) {
                        Companion.b("Failed to create cleanup call for action: ".concat(type), null);
                        stopSelf();
                    } else {
                        Companion.a("Making cleanup API call for action: ".concat(type));
                        callA.N(new Callback<Object>() { // from class: com.zeptoconsumerapp.services.GenericCleanupService$doCleanupWork$1
                            @Override // retrofit2.Callback
                            public final void a(Call call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                                String str2 = GenericCleanupService.f47807c;
                                GenericCleanupService.Companion.b("onFailure called: " + t.getMessage(), t);
                                this.f47810a.stopSelf();
                            }

                            @Override // retrofit2.Callback
                            public final void b(Call call, Response response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                String str2 = GenericCleanupService.f47807c;
                                okhttp3.Response response2 = response.f58224a;
                                GenericCleanupService.Companion.a("onResponse called - Code: " + response2.f56353d);
                                if (response2.c()) {
                                    GenericCleanupService.Companion.a("Cleanup API success: " + response.f58225b);
                                } else {
                                    GenericCleanupService.Companion.a("Cleanup API failed: " + response2.f56353d + " - " + response2.f56352c);
                                    ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = response.f58226c;
                                    if (responseBody$Companion$asResponseBody$1 != null) {
                                        GenericCleanupService.Companion.b("Error body: ".concat(responseBody$Companion$asResponseBody$1.r()), null);
                                    }
                                }
                                this.f47810a.stopSelf();
                            }
                        });
                        Companion.a("Call enqueued successfully");
                    }
                }
            }
        } catch (Exception e2) {
            stopSelf();
            Companion.b("Exception in doCleanupWork: " + e2.getMessage(), e2);
        }
        super.onTaskRemoved(rootIntent);
    }
}
