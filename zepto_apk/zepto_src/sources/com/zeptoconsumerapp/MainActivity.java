package com.zeptoconsumerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.profileinstaller.b;
import androidx.work.impl.c;
import bridges.CommsModule;
import coil3.ComponentRegistry;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import coil3.Uri;
import coil3.disk.DiskCache;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import coil3.request.ImageRequests_androidKt;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactApplication;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.service.NotificationService;
import com.falcon.notification.utils.NotificationUtils;
import com.phoenix.Phoenix;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.AutoLogin.CredentialManager;
import com.zeptoconsumerapp.DynamicAppIcon.DynamicAppIconController;
import com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen;
import com.zeptoconsumerapp.FusedLocation.FusedLocationMain;
import com.zeptoconsumerapp.NetworkLogger.UserAgentClientFactory;
import com.zeptoconsumerapp.PaymentUPIHelper.PaymentUPIHelperModule;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import com.zeptoconsumerapp.Startup.AppLifecycleManager;
import com.zeptoconsumerapp.Startup.AppLocationManager;
import com.zeptoconsumerapp.Startup.AppSessionManager;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.modules.configservice.ConfigManager;
import com.zeptoconsumerapp.modules.notification.constants.AppState;
import in.juspay.hypersdkreact.HyperSdkReactModule;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okio.Path;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MainActivity extends ReactActivity {

    /* renamed from: k, reason: collision with root package name */
    public static long f47519k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f47520l = 0;

    /* renamed from: j, reason: collision with root package name */
    public ActivityResultLauncher f47521j;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.MainActivity$onCreate$2", f = "MainActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.MainActivity$onCreate$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MainActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:3:0x0019, B:6:0x0026, B:9:0x002f, B:13:0x003d, B:15:0x0043, B:18:0x0053, B:23:0x007a, B:25:0x0080, B:27:0x0086, B:29:0x008f, B:21:0x0067), top: B:37:0x0019 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.String r0 = "getValue(...)"
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                kotlin.ResultKt.b(r11)
                com.zeptoconsumerapp.Appography.AppListOnDevice r11 = new com.zeptoconsumerapp.Appography.AppListOnDevice
                com.zeptoconsumerapp.MainActivity r1 = com.zeptoconsumerapp.MainActivity.this
                android.content.Context r1 = r1.getApplicationContext()
                java.lang.String r2 = "getApplicationContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                r11.<init>(r1)
                java.lang.String r2 = "app_cached_list"
                kotlin.Lazy r3 = r11.f47338d     // Catch: java.lang.Throwable -> La3
                java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> La3
                android.content.SharedPreferences r3 = (android.content.SharedPreferences) r3     // Catch: java.lang.Throwable -> La3
                java.lang.String r4 = ""
                r5 = 0
                if (r3 == 0) goto L2e
                java.lang.String r6 = "userId"
                java.lang.String r3 = r3.getString(r6, r5)     // Catch: java.lang.Throwable -> La3
                if (r3 != 0) goto L2f
            L2e:
                r3 = r4
            L2f:
                android.content.ContentResolver r6 = r1.getContentResolver()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> La3
                java.lang.String r7 = "android_id"
                java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> La3
                if (r6 != 0) goto L3c
                goto L3d
            L3c:
                r4 = r6
            L3d:
                java.util.List r1 = r11.a(r1)     // Catch: java.lang.Throwable -> La3
                kotlin.Lazy r6 = r11.f47336b
                java.lang.Object r7 = r6.getValue()     // Catch: java.lang.Throwable -> La3
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch: java.lang.Throwable -> La3
                com.tencent.mmkv.MMKV r7 = (com.tencent.mmkv.MMKV) r7     // Catch: java.lang.Throwable -> La3
                java.lang.String r7 = r7.decodeString(r2)     // Catch: java.lang.Throwable -> La3
                if (r7 != 0) goto L53
                goto L7a
            L53:
                com.google.gson.Gson r8 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                com.zeptoconsumerapp.Appography.AppListOnDevice$compareCachedAndNewAppList$cachedList$1 r9 = new com.zeptoconsumerapp.Appography.AppListOnDevice$compareCachedAndNewAppList$cachedList$1     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                r9.<init>()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                java.lang.reflect.Type r9 = r9.f45460b     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                java.lang.Object r7 = r8.e(r7, r9)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> La3
                r5 = r7
            L65:
                if (r5 == 0) goto L7a
                java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> La3
                java.util.Set r5 = kotlin.collections.CollectionsKt.h0(r5)     // Catch: java.lang.Throwable -> La3
                r7 = r1
                java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> La3
                java.util.Set r7 = kotlin.collections.CollectionsKt.h0(r7)     // Catch: java.lang.Throwable -> La3
                boolean r5 = kotlin.jvm.internal.Intrinsics.b(r5, r7)     // Catch: java.lang.Throwable -> La3
                if (r5 != 0) goto La3
            L7a:
                boolean r4 = kotlin.text.StringsKt.z(r4)     // Catch: java.lang.Throwable -> La3
                if (r4 == 0) goto L86
                boolean r4 = kotlin.text.StringsKt.z(r3)     // Catch: java.lang.Throwable -> La3
                if (r4 != 0) goto La3
            L86:
                r11.b(r1)     // Catch: java.lang.Throwable -> La3
                boolean r11 = kotlin.text.StringsKt.z(r3)     // Catch: java.lang.Throwable -> La3
                if (r11 != 0) goto La3
                java.lang.Object r11 = r6.getValue()     // Catch: java.lang.Throwable -> La3
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch: java.lang.Throwable -> La3
                com.tencent.mmkv.MMKV r11 = (com.tencent.mmkv.MMKV) r11     // Catch: java.lang.Throwable -> La3
                com.google.gson.Gson r0 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Throwable -> La3
                java.lang.String r0 = r0.j(r1)     // Catch: java.lang.Throwable -> La3
                r11.encode(r2, r0)     // Catch: java.lang.Throwable -> La3
            La3:
                kotlin.Unit r11 = kotlin.Unit.f53572a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.MainActivity.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.MainActivity$onCreate$3", f = "MainActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.MainActivity$onCreate$3, reason: invalid class name */
    final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MainActivity.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            Context applicationContext = MainActivity.this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            CredentialManager.initialize(applicationContext);
            return Unit.f53572a;
        }
    }

    @Override // com.facebook.react.ReactActivity
    public final ReactActivityDelegate l() {
        return new DefaultReactActivityDelegate() { // from class: com.zeptoconsumerapp.MainActivity$createReactActivityDelegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.f47522f, "zeptoConsumerApp");
                Intrinsics.checkNotNullParameter(this.f47522f, "activity");
                Intrinsics.checkNotNullParameter("zeptoConsumerApp", "mainComponentName");
                Intrinsics.checkNotNullParameter(this.f47522f, "activity");
                Intrinsics.checkNotNullParameter("zeptoConsumerApp", "mainComponentName");
            }

            @Override // com.facebook.react.ReactActivityDelegate
            public final Bundle a() throws JSONException, PackageManager.NameNotFoundException, RuntimeException {
                boolean z;
                String string;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                MainActivity mainActivity = this.f47522f;
                Intent intent = mainActivity.getIntent();
                Bundle bundle = new Bundle();
                Context context = mainActivity.getApplicationContext();
                Intrinsics.c(intent);
                Intrinsics.c(context);
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(context, "context");
                Bundle extras = intent.getExtras();
                if (extras != null && (string = extras.getString("action")) != null) {
                    if (string.equals("startMockTest")) {
                        Bundle extras2 = intent.getExtras();
                        if (extras2 != null) {
                            MMKV.initialize(context);
                            MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
                            Intrinsics.checkNotNullExpressionValue(mmkvDefaultMMKV, "defaultMMKV(...)");
                            JSONObject jSONObject = new JSONObject();
                            for (String str : extras2.keySet()) {
                                jSONObject.put(str, extras2.get(str));
                            }
                            mmkvDefaultMMKV.encode("perfParams", jSONObject.toString());
                        }
                    } else {
                        System.out.println((Object) "Default");
                    }
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
                bundle.putString("sessionId", AppSessionManager.f47556a.a());
                String string2 = sharedPreferences.getString("accessToken", "");
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = sharedPreferences.getString("refreshToken", "");
                if (string3 == null) {
                    string3 = "";
                }
                String string4 = sharedPreferences.getString("appDetailsResponse", "");
                if (string4 == null) {
                    string4 = "";
                }
                String string5 = sharedPreferences.getString("isAppLaunched", "");
                if (string5 == null) {
                    string5 = "";
                }
                String string6 = sharedPreferences.getString("userExperiments", "");
                String str2 = string6 == null ? "" : string6;
                String string7 = sharedPreferences.getString("appsflyerID", "");
                if (string7 == null) {
                    string7 = "";
                }
                String string8 = sharedPreferences.getString("lastSelectedStoreId", "");
                String str3 = string8 == null ? "" : string8;
                String string9 = sharedPreferences.getString("currentAppIconCampaign", "");
                String str4 = string9 != null ? string9 : "";
                String strF = Phoenix.Companion.f();
                bundle.putString("locationPermission", FusedLocationMain.f47427a.toString());
                bundle.putString("accessToken", string2);
                bundle.putString("refreshToken", string3);
                String string10 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                bundle.putString("deviceUniqueId", string10);
                if (NotificationUtils.Companion.d(intent)) {
                    bundle.putString("pendingUrl", intent.getDataString());
                }
                if (strF.length() > 0) {
                    bundle.putString("phoenixManifest", strF);
                }
                if (string7.length() > 0) {
                    bundle.putString("appsflyerID", string7);
                }
                if (string4.length() > 0) {
                    bundle.putString("appDetailsResponse", string4);
                }
                if (string5.length() > 0) {
                    bundle.putBoolean("isAppLaunched", true);
                }
                if (str2.length() > 0) {
                    bundle.putString("userExperiments", str2);
                }
                if (str3.length() > 0) {
                    bundle.putString("lastSelectedStoreId", str3);
                }
                if (str4.length() > 0) {
                    bundle.putString("currentAppIconCampaign", str4);
                }
                long j2 = MainActivity.f47519k;
                if (j2 > 0) {
                    bundle.putLong("appInitTimeStamp", j2);
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                Context applicationContext = mainActivity.getApplicationContext();
                String str5 = Utils.f47559a;
                HashMap map = new HashMap();
                for (String str6 : Utils.f47561c) {
                    try {
                        applicationContext.getPackageManager().getPackageInfo(str6, 1);
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    map.put(str6, Boolean.valueOf(z));
                }
                bundle.putLong("durationGetAppsOnDeviceMs", SystemClock.elapsedRealtime() - jElapsedRealtime2);
                for (Map.Entry entry : map.entrySet()) {
                    String str7 = (String) entry.getKey();
                    Boolean bool = (Boolean) entry.getValue();
                    Intrinsics.c(bool);
                    bundle.putBoolean(str7, bool.booleanValue());
                }
                try {
                    Context applicationContext2 = mainActivity.getApplicationContext();
                    long j3 = -1;
                    if (applicationContext2 != null) {
                        try {
                            j3 = applicationContext2.getPackageManager().getPackageInfo(applicationContext2.getPackageName(), 0).firstInstallTime;
                        } catch (Exception e2) {
                            Utils.i(e2);
                        }
                    }
                    bundle.putLong("appInstallTime", j3);
                } catch (Exception unused2) {
                }
                String string11 = sharedPreferences.getString("lastConfirmedOrderId", null);
                if (string11 != null) {
                    bundle.putString("lastConfirmedOrderIdFromNotif", string11);
                }
                bundle.putLong("durationTotalLaunchOptionsMs", SystemClock.elapsedRealtime() - jElapsedRealtime);
                return bundle;
            }
        };
    }

    @Override // com.facebook.react.ReactActivity
    public final String m() {
        return "zeptoConsumerApp";
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PaymentUPIHelperModule.onActivityResult(this.f18435i.f18440e.f18450f.f().f(), i2, i3, intent);
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        f47519k = System.currentTimeMillis();
        super.onCreate(null);
        try {
            this.f47521j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this, 7));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ContextProvider.f47615b.a().b(this);
        try {
            Context applicationContext = getApplicationContext();
            UserAgentClientFactory userAgentClientFactory = new UserAgentClientFactory();
            userAgentClientFactory.f47535a = applicationContext;
            OkHttpClientProvider.f19144b = userAgentClientFactory;
        } catch (Exception unused) {
        }
        ConfigManager.a();
        try {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            sharedPreferences.edit().remove("pendingUrl").apply();
            Intent intent = getIntent();
            String dataString = intent != null ? intent.getDataString() : null;
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
            if (NotificationUtils.Companion.d(intent2) && dataString != null && dataString.length() != 0) {
                sharedPreferences.edit().putString("pendingUrl", dataString).apply();
            }
        } catch (Exception unused2) {
        }
        OkHttpClient okHttpClient = OkHttpClientProvider.b();
        Intrinsics.checkNotNullExpressionValue(okHttpClient, "getOkHttpClient(...)");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        final OkHttpClient okHttpClient2 = new OkHttpClient(okHttpClient.c());
        SingletonImageLoader.setSafe(new SingletonImageLoader.Factory() { // from class: a
            @Override // coil3.SingletonImageLoader.Factory
            public final ImageLoader newImageLoader(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                final File cacheDir = context.getCacheDir();
                final long jMin = 1073741824;
                try {
                    jMin = Math.min((long) (new StatFs(cacheDir.getPath()).getAvailableBytes() * 0.1d), 1073741824L);
                } catch (Exception unused3) {
                }
                ImageLoader.Builder builder = new ImageLoader.Builder(context);
                ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
                builder2.add(OkHttpNetworkFetcher.factory(new b(okHttpClient2, 0)), Reflection.a(Uri.class));
                return ImageRequests_androidKt.crossfade(builder.components(builder2.build()).memoryCache(new b(context, 1)).diskCache(new Function0() { // from class: c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int length;
                        File file;
                        int iW;
                        DiskCache.Builder builder3 = new DiskCache.Builder();
                        String str = Path.f56972b;
                        File file2 = cacheDir;
                        Intrinsics.c(file2);
                        Intrinsics.checkNotNullParameter(file2, "<this>");
                        Intrinsics.checkNotNullParameter("coil_image_cache", "relative");
                        File relative = new File("coil_image_cache");
                        Intrinsics.checkNotNullParameter(file2, "<this>");
                        Intrinsics.checkNotNullParameter(relative, "relative");
                        Intrinsics.checkNotNullParameter(relative, "<this>");
                        String path = relative.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                        char c2 = File.separatorChar;
                        int iW2 = StringsKt.w(path, c2, 0, 4);
                        if (iW2 != 0) {
                            length = (iW2 <= 0 || path.charAt(iW2 + (-1)) != ':') ? (iW2 == -1 && StringsKt.s(path, ':')) ? path.length() : 0 : iW2 + 1;
                        } else if (path.length() <= 1 || path.charAt(1) != c2 || (iW = StringsKt.w(path, c2, 2, 4)) < 0) {
                            length = 1;
                        } else {
                            int iW3 = StringsKt.w(path, c2, iW + 1, 4);
                            length = iW3 >= 0 ? iW3 + 1 : path.length();
                        }
                        if (!(length > 0)) {
                            String string = file2.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            if ((string.length() == 0) || StringsKt.s(string, c2)) {
                                file = new File(string + relative);
                            } else {
                                file = new File(string + c2 + relative);
                            }
                            relative = file;
                        }
                        return builder3.directory(Path.Companion.b(relative)).maxSizeBytes(jMin).build();
                    }
                }), 300).build();
            }
        });
        ReactActivity reactActivity = this.f18435i.f18436a;
        Assertions.c(reactActivity);
        DynamicSplashScreen.e(this, ((ReactApplication) reactActivity.getApplication()).a());
        getTheme().applyStyle(R.style.OptOutEdgeToEdgeEnforcement, false);
        AppLocationManager.Companion.a(getApplicationContext());
        Phoenix.Companion.a();
        try {
            Context applicationContext2 = getApplicationContext();
            String str = Utils.f47559a;
            Executors.newSingleThreadExecutor().submit(new b(applicationContext2, 2));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Intent intent3 = getIntent();
        Intrinsics.c(intent3);
        if (NotificationUtils.Companion.d(intent3)) {
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            String stringExtra = intent3.getStringExtra("notification_data");
            if (stringExtra != null) {
                new NotificationService();
                NotificationService.b(stringExtra);
            }
        }
        AppCoroutineManager.a(new AnonymousClass2(null));
        AppCoroutineManager.a(new AnonymousClass3(null));
    }

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        if (NotificationUtils.Companion.d(intent)) {
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            String stringExtra = intent.getStringExtra("notification_data");
            if (stringExtra != null) {
                new NotificationService();
                NotificationService.b(stringExtra);
            }
        }
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        HyperSdkReactModule.onRequestPermissionsResult(i2, permissions, grantResults);
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        AppState[] appStateArr = AppState.f47658a;
        AppLifecycleManager.f47551b = "FOREGROUND";
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        ImagePipeline imagePipelineA;
        super.onStop();
        AppState[] appStateArr = AppState.f47658a;
        AppLifecycleManager.f47551b = "BACKGROUND";
        DynamicAppIconController dynamicAppIconController = new DynamicAppIconController(getApplicationContext());
        String string = dynamicAppIconController.f47399e.getString("queuedAppIconCampaign", "");
        String string2 = dynamicAppIconController.f47399e.getString("queuedAppIconCampaignActivity", "");
        Intrinsics.c(string);
        if (string.length() > 0) {
            dynamicAppIconController.e(string, string2);
        } else {
            dynamicAppIconController.d();
        }
        try {
            if (!Fresco.f17199b || (imagePipelineA = Fresco.a()) == null) {
                return;
            }
            imagePipelineA.a();
        } catch (Exception unused) {
        }
    }
}
