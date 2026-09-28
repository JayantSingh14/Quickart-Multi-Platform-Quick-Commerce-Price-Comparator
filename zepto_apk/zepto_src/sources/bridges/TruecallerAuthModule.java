package bridges;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import com.truecaller.android.sdk.oAuth.TcOAuthData;
import com.truecaller.android.sdk.oAuth.TcOAuthError;
import com.truecaller.android.sdk.oAuth.TcSdk;
import com.truecaller.android.sdk.oAuth.TcSdkOptions;
import com.zeptoconsumerapp.MainActivity;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import com.zeptoconsumerapp.Utils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class TruecallerAuthModule extends ReactContextBaseJavaModule {

    @NotNull
    private static final String ERROR_KEY = "error";

    @NotNull
    private static final String LOG_EVENT_KEY = "toLogEvent";

    @NotNull
    private static final String MODULE_NAME_CONSTANT = "TruecallerAuthModule";

    @NotNull
    private static final String PROCESS_TYPE_KEY = "type";

    @NotNull
    private static final String SUCCESS_KEY = "success_authenticate";

    @NotNull
    private static final String TRUECALLER_BOTTOM_SHEET_VIEWED = "TRUECALLER_BOTTOM_SHEET_VIEWED";

    @NotNull
    private static final String TRUECALLER_EVENT = "TRUECALLER_EVENT";

    @Nullable
    private String codeVerifier;

    @NotNull
    private final TruecallerAuthModule$sdkCallback$1 sdkCallback;

    @Nullable
    private String state;

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String[] SCOPES = {Scopes.PROFILE, "phone", Scopes.OPEN_ID, "offline_access", Scopes.EMAIL};

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @DebugMetadata(c = "bridges.TruecallerAuthModule$authenticate$1", f = "TruecallerAuthModule.kt", l = {173, 244}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: bridges.TruecallerAuthModule$authenticate$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f13217a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f13219c;

        @Metadata
        @DebugMetadata(c = "bridges.TruecallerAuthModule$authenticate$1$1", f = "TruecallerAuthModule.kt", l = {}, m = "invokeSuspend")
        /* renamed from: bridges.TruecallerAuthModule$authenticate$1$1, reason: invalid class name and collision with other inner class name */
        final class C00101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TruecallerAuthModule f13220a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00101(TruecallerAuthModule truecallerAuthModule, Continuation continuation) {
                super(2, continuation);
                this.f13220a = truecallerAuthModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00101(this.f13220a, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((C00101) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                ResultKt.b(obj);
                this.f13220a.triggerGenericEvent(TruecallerAuthModule.TRUECALLER_EVENT, "error", "TcSdk instance is null", false);
                return Unit.f53572a;
            }
        }

        @Metadata
        @DebugMetadata(c = "bridges.TruecallerAuthModule$authenticate$1$3", f = "TruecallerAuthModule.kt", l = {}, m = "invokeSuspend")
        /* renamed from: bridges.TruecallerAuthModule$authenticate$1$3, reason: invalid class name */
        final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TcSdk f13221a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f13222b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ActivityResultLauncher f13223c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(TcSdk tcSdk, Activity activity, ActivityResultLauncher activityResultLauncher, Continuation continuation) {
                super(2, continuation);
                this.f13221a = tcSdk;
                this.f13222b = activity;
                this.f13223c = activityResultLauncher;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass3(this.f13221a, this.f13222b, this.f13223c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                ResultKt.b(obj);
                this.f13221a.getAuthorizationCode((FragmentActivity) this.f13222b, this.f13223c);
                return Unit.f53572a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, Continuation continuation) {
            super(2, continuation);
            this.f13219c = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TruecallerAuthModule.this.new AnonymousClass1(this.f13219c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
        
            if (kotlinx.coroutines.BuildersKt.e(r10, r11, r13) == r1) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ab A[Catch: Exception -> 0x0029, TRY_ENTER, TryCatch #1 {Exception -> 0x0029, blocks: (B:53:0x0109, B:12:0x0025, B:22:0x004c, B:17:0x002f, B:19:0x0039, B:24:0x004f, B:26:0x0055, B:28:0x005d, B:30:0x007d, B:31:0x0082, B:35:0x00ab, B:37:0x00b3, B:39:0x00c7, B:40:0x00ca, B:42:0x00d7, B:44:0x00df, B:46:0x00e5, B:6:0x0015, B:51:0x00ff, B:48:0x00ed), top: B:59:0x000f, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b3 A[Catch: Exception -> 0x0029, TryCatch #1 {Exception -> 0x0029, blocks: (B:53:0x0109, B:12:0x0025, B:22:0x004c, B:17:0x002f, B:19:0x0039, B:24:0x004f, B:26:0x0055, B:28:0x005d, B:30:0x007d, B:31:0x0082, B:35:0x00ab, B:37:0x00b3, B:39:0x00c7, B:40:0x00ca, B:42:0x00d7, B:44:0x00df, B:46:0x00e5, B:6:0x0015, B:51:0x00ff, B:48:0x00ed), top: B:59:0x000f, inners: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.security.NoSuchAlgorithmException {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: bridges.TruecallerAuthModule.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [bridges.TruecallerAuthModule$sdkCallback$1] */
    public TruecallerAuthModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.sdkCallback = new TcOAuthCallback() { // from class: bridges.TruecallerAuthModule$sdkCallback$1
            @Override // com.truecaller.android.sdk.oAuth.TcOAuthCallback
            public final void onFailure(TcOAuthError oAuthError) {
                Intrinsics.checkNotNullParameter(oAuthError, "oAuthError");
                String errorMessage = oAuthError.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = "ERROR_TYPE_NULL";
                }
                this.f13224a.triggerGenericEvent("TRUECALLER_EVENT", "error", errorMessage, false);
            }

            @Override // com.truecaller.android.sdk.oAuth.TcOAuthCallback
            public final void onSuccess(TcOAuthData oAuthData) {
                Intrinsics.checkNotNullParameter(oAuthData, "oAuthData");
                WritableMap writableMapCreateMap = Arguments.createMap();
                String authorizationCode = oAuthData.getAuthorizationCode();
                if (authorizationCode == null) {
                    authorizationCode = "";
                }
                writableMapCreateMap.putString("authorizationCode", authorizationCode);
                TruecallerAuthModule truecallerAuthModule = this.f13224a;
                writableMapCreateMap.putString("codeVerifier", truecallerAuthModule.codeVerifier);
                writableMapCreateMap.putString("type", "success_authenticate");
                truecallerAuthModule.triggerEvent("TRUECALLER_EVENT", writableMapCreateMap);
            }

            @Override // com.truecaller.android.sdk.oAuth.TcOAuthCallback
            public final void onVerificationRequired(TcOAuthError tcOAuthError) {
                String errorMessage;
                TruecallerAuthModule truecallerAuthModule = this.f13224a;
                try {
                    truecallerAuthModule.hideDisclaimerModal();
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("type", "success_authenticate");
                    truecallerAuthModule.triggerEvent("TRUECALLER_EVENT", writableMapCreateMap);
                } catch (Exception unused) {
                    if (tcOAuthError == null || (errorMessage = tcOAuthError.getErrorMessage()) == null) {
                        errorMessage = "ERROR_TYPE_NULL";
                    }
                    truecallerAuthModule.triggerGenericEvent("TRUECALLER_EVENT", "error", errorMessage, false);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> getTruecallerLauncher() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity instanceof MainActivity) {
            return ((MainActivity) currentActivity).f47521j;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideDisclaimerModal() {
        getCurrentActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTruecaller() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            TcSdk.init(new TcSdkOptions.Builder(reactApplicationContext, this.sdkCallback).buttonColor(Color.parseColor("#FF3269")).buttonTextColor(Color.parseColor("#FFFFFF")).loginTextPrefix(0).ctaText(5).buttonShapeOptions(256).footerType(4).consentTitleOption(0).sdkOptions(32).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void triggerEvent(String str, T t) {
        String string;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            if (t instanceof WritableMap) {
                Utils.j(reactApplicationContext, str, t);
                return;
            }
            if (t instanceof Map) {
                Intrinsics.d(t, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map map = (Map) t;
                String str2 = Utils.f47559a;
                JSONObject jSONObject = map != null ? new JSONObject(map) : new JSONObject();
                WritableMap writableMapCreateMap = Arguments.createMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String string2 = null;
                    try {
                        string = itKeys.next().toString();
                        try {
                            string2 = jSONObject.get(string).toString();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        string = null;
                    }
                    if (string != null && string2 != null) {
                        writableMapCreateMap.putString(string, string2);
                    }
                }
                Utils.j(reactApplicationContext, str, writableMapCreateMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerGenericEvent(String str, String str2, String str3, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", str2);
        if (str3 != null && str3.length() != 0) {
            writableMapCreateMap.putString("error", str3);
        }
        if (z) {
            writableMapCreateMap.putBoolean(LOG_EVENT_KEY, true);
        }
        triggerEvent(str, writableMapCreateMap);
    }

    @ReactMethod
    public final void authenticate() {
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                AppCoroutineManager.a(new AnonymousClass1(currentActivity, null));
            }
        } catch (Exception e2) {
            Utils.i(e2);
            triggerGenericEvent(TRUECALLER_EVENT, "error", e2.getMessage(), false);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return MODULE_NAME_CONSTANT;
    }
}
