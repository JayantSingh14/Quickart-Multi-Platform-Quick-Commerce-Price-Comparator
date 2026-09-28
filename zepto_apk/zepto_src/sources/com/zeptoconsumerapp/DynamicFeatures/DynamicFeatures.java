package com.zeptoconsumerapp.DynamicFeatures;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v4.media.b;
import androidx.media3.exoplayer.analytics.l;
import bridges.CommsModule;
import coil3.network.internal.UtilsKt;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class DynamicFeatures {

    /* renamed from: a, reason: collision with root package name */
    public static a f47403a;

    /* renamed from: b, reason: collision with root package name */
    public static SplitInstallManager f47404b;

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashSet f47405c = new LinkedHashSet();

    public static void a() {
        SplitInstallManager splitInstallManager;
        a aVar = f47403a;
        if (aVar != null && (splitInstallManager = f47404b) != null) {
            splitInstallManager.c(aVar);
        }
        f47403a = null;
        f47405c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener, com.zeptoconsumerapp.DynamicFeatures.a] */
    public static void b(final Context context) {
        SharedPreferences sharedPreferences;
        String string;
        Task taskA;
        Set setB;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            f47405c.clear();
            try {
                sharedPreferences = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            } catch (Exception unused) {
                sharedPreferences = null;
            }
            String str = "";
            if (sharedPreferences == null || (string = sharedPreferences.getString("userId", null)) == null) {
                string = "";
            }
            try {
                String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (string2 != null) {
                    str = string2;
                }
            } catch (Exception unused2) {
            }
            Pair pair = new Pair("user_id", string);
            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
            final Map mapH = MapsKt.h(pair, new Pair("module_name", "dynamicfeatures"), new Pair("device_id", str));
            SplitInstallManager splitInstallManagerA = SplitInstallManagerFactory.a(context);
            f47404b = splitInstallManagerA;
            if (splitInstallManagerA != null && (setB = splitInstallManagerA.b()) != null && setB.contains("dynamicfeatures")) {
                SplitCompat.a(context);
                d(mapH);
                return;
            }
            ?? r2 = new SplitInstallStateUpdatedListener() { // from class: com.zeptoconsumerapp.DynamicFeatures.a
                /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Map] */
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                public final void onStateUpdate(Object obj) {
                    String strG;
                    SplitInstallSessionState state = (SplitInstallSessionState) obj;
                    a aVar = DynamicFeatures.f47403a;
                    Intrinsics.checkNotNullParameter(state, "state");
                    int iH = state.h();
                    ?? r1 = mapH;
                    switch (iH) {
                        case 1:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr2 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("PENDING", r1);
                            break;
                        case 2:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr3 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("DOWNLOADING", r1);
                            break;
                        case 3:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr4 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("DOWNLOADED", r1);
                            break;
                        case 4:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr5 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("INSTALLING", r1);
                            break;
                        case 5:
                            SplitCompat.a(context);
                            DynamicFeatures.d(r1);
                            DynamicFeatures.a();
                            break;
                        case 6:
                            int iC = state.c();
                            if (iC != -100) {
                                switch (iC) {
                                    case -15:
                                        strG = "App not owned (not installed from Play Store)";
                                        break;
                                    case -14:
                                        strG = "Play Store not found";
                                        break;
                                    case -13:
                                        strG = "SplitCompat copy error";
                                        break;
                                    case -12:
                                        strG = "SplitCompat emulation error";
                                        break;
                                    case -11:
                                        strG = "SplitCompat verification error";
                                        break;
                                    case -10:
                                        strG = "Insufficient storage";
                                        break;
                                    case -9:
                                        strG = "Service died";
                                        break;
                                    case -8:
                                        strG = "Incompatible with existing session";
                                        break;
                                    case -7:
                                        strG = "Access denied";
                                        break;
                                    case -6:
                                        strG = "Network error";
                                        break;
                                    case -5:
                                        strG = "API not available";
                                        break;
                                    case -4:
                                        strG = "Session not found";
                                        break;
                                    case -3:
                                        strG = "Invalid request";
                                        break;
                                    case CompanionAdSlot.FLUID_SIZE /* -2 */:
                                        strG = "Module unavailable";
                                        break;
                                    case -1:
                                        strG = "Too many active sessions";
                                        break;
                                    case 0:
                                        strG = "No error";
                                        break;
                                    default:
                                        strG = b.g(iC, "Unknown error (code: ", ")");
                                        break;
                                }
                            } else {
                                strG = "Internal error";
                            }
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr6 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("FAILED", MapsKt.j(r1, MapsKt.h(new Pair("error_code", String.valueOf(iC)), new Pair("error_message", strG))));
                            DynamicFeatures.a();
                            break;
                        case 7:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr7 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("CANCELED", r1);
                            DynamicFeatures.a();
                            break;
                        case 8:
                            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr8 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                            DynamicFeatures.c("REQUIRES_USER_CONFIRMATION", r1);
                            break;
                    }
                }
            };
            f47403a = r2;
            SplitInstallManager splitInstallManager = f47404b;
            if (splitInstallManager != 0) {
                splitInstallManager.d(r2);
            }
            SplitInstallRequest.Builder builder = new SplitInstallRequest.Builder();
            builder.f41933a.add("dynamicfeatures");
            SplitInstallRequest splitInstallRequest = new SplitInstallRequest(builder);
            Intrinsics.checkNotNullExpressionValue(splitInstallRequest, "build(...)");
            SplitInstallManager splitInstallManager2 = f47404b;
            if (splitInstallManager2 == null || (taskA = splitInstallManager2.a(splitInstallRequest)) == null) {
                return;
            }
            taskA.c(new l(mapH, 21));
        } catch (Throwable unused3) {
            a();
        }
    }

    public static void c(String str, Map map) {
        LinkedHashSet linkedHashSet = f47405c;
        if (linkedHashSet.contains(str)) {
            return;
        }
        linkedHashSet.add(str);
        LinkedHashMap data = MapsKt.j(map, MapsKt.g(new Pair(CLConstants.OTP_STATUS, str)));
        MediaType mediaType = EventLogger.f47406a;
        Intrinsics.checkNotNullParameter("dynamic_import_flow", "eventType");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JSONObject jSONObjectA = EventLogger.a(data);
            Request.Builder builder = new Request.Builder();
            builder.i("https://events.zepto.co.in/api/v2/publish-events");
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jSONObjectA.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            MediaType mediaType2 = EventLogger.f47406a;
            companion.getClass();
            RequestBody$Companion$toRequestBody$2 body = RequestBody.Companion.a(string, mediaType2);
            Intrinsics.checkNotNullParameter(body, "body");
            builder.f("POST", body);
            builder.a(UtilsKt.CONTENT_TYPE, "application/json");
            ((OkHttpClient) EventLogger.f47407b.getValue()).a(builder.b()).l0(new EventLogger$logEvent$1());
        } catch (Exception unused) {
        }
    }

    public static void d(Map map) {
        try {
            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
            Object objNewInstance = Class.forName("com.DynamicFeatures.DynamicFeatures").getDeclaredConstructor(null).newInstance(null);
            Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.zeptoconsumerapp.DynamicFeatures.IDynamicModule");
            c("INSTALLED", MapsKt.j(map, MapsKt.g(new Pair("module_name", ((IDynamicModule) objNewInstance).getModuleName()))));
        } catch (Throwable unused) {
            com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr2 = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
            c("INSTALLED", map);
        }
    }
}
