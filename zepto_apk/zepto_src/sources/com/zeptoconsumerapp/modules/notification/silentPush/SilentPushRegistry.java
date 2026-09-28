package com.zeptoconsumerapp.modules.notification.silentPush;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.media.b;
import bridges.CommsModule;
import com.zeptoconsumerapp.AutoLogin.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SilentPushRegistry {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f47703b;

    /* renamed from: d, reason: collision with root package name */
    public static Context f47705d;

    /* renamed from: a, reason: collision with root package name */
    public static final SilentPushRegistry f47702a = new SilentPushRegistry();

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f47704c = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f47706e = new ReentrantLock();

    public static final void a(SilentPushPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        try {
            String actionType = payload.a();
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            ActionMeta actionMeta = (ActionMeta) f47704c.get(actionType);
            if (actionMeta == null) {
                Timber.d("SilentPush").w("No handler registered for actionType=" + payload.a(), new Object[0]);
                return;
            }
            if (!d(payload.a(), actionMeta)) {
                b(actionMeta, payload);
                return;
            }
            String strA = payload.a();
            g(strA, ActionStatus.f47692b);
            Timber.d("SilentPush").i("Skipped action=" + strA + " due to throttling", new Object[0]);
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, b.C("Critical error in dispatch for actionType=", payload.a()), new Object[0]);
        }
    }

    public static void b(ActionMeta actionMeta, SilentPushPayload silentPushPayload) {
        try {
            actionMeta.f47690b.invoke(silentPushPayload.b());
            g(silentPushPayload.a(), ActionStatus.f47691a);
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, b.C("Error executing actionType=", silentPushPayload.a()), new Object[0]);
            g(silentPushPayload.a(), ActionStatus.f47691a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.Result$Failure] */
    public static JSONObject c() {
        String string;
        JSONObject jSONObjectA;
        ReentrantLock reentrantLock = f47706e;
        reentrantLock.lock();
        try {
            Context context = f47705d;
            JSONObject jSONObject = null;
            SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0) : null;
            if (sharedPreferences != null && (string = sharedPreferences.getString("silent_push_last_action", null)) != null) {
                try {
                    Result.Companion companion = Result.f53538b;
                    jSONObjectA = new JSONObject(string);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f53538b;
                    jSONObjectA = ResultKt.a(th);
                }
                Throwable thA = Result.a(jSONObjectA);
                if (thA != null) {
                    Timber.d("SilentPush").e(thA, "Failed to parse lastAction JSON", new Object[0]);
                }
                if (!(jSONObjectA instanceof Result.Failure)) {
                    jSONObject = jSONObjectA;
                }
                jSONObject = jSONObject;
            }
            reentrantLock.unlock();
            return jSONObject;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public static boolean d(String str, ActionMeta actionMeta) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObjectC = c();
            Long l2 = actionMeta.f47689a;
            if (l2 != null) {
                if (Intrinsics.b(jSONObjectC != null ? jSONObjectC.optString("actionType") : null, str)) {
                    if (jCurrentTimeMillis - jSONObjectC.optLong("timestamp", 0L) < l2.longValue()) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, b.C("Error in throttling check for actionType=", str), new Object[0]);
        }
        return false;
    }

    public static void e(ActionType actionType, ActionMeta meta) {
        String str = actionType.f47699a;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(meta, "meta");
        try {
            f47704c.put(str, meta);
            Timber.d("SilentPush").d("Registered actionType=%s", str);
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, "Failed to register actionType=".concat(str), new Object[0]);
        }
    }

    public static void f() {
        try {
            e(ActionType.f47695b, new ActionMeta(120000L, new a(1)));
            e(ActionType.f47696c, new ActionMeta(null, new a(2)));
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, "Error while registering default actions", new Object[0]);
        }
    }

    public static void g(String str, ActionStatus actionStatus) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        f47706e.lock();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionType", str);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(CLConstants.OTP_STATUS, actionStatus.name());
            Context context = f47705d;
            SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0) : null;
            if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorPutString = editorEdit.putString("silent_push_last_action", jSONObject.toString())) != null) {
                editorPutString.apply();
            }
            Timber.d("SilentPush").d("Saved lastAction=%s status=%s", str, actionStatus);
        } catch (Throwable th) {
            Timber.d("SilentPush").e(th, "Failed to save lastAction for actionType=" + str, new Object[0]);
        } finally {
        }
        Unit unit = Unit.f53572a;
    }
}
