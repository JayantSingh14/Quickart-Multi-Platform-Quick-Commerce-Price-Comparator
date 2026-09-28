package cl.json.social;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Build;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes3.dex */
public class TargetChosenReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13836a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static String f13837b;

    /* renamed from: c, reason: collision with root package name */
    public static TargetChosenReceiver f13838c;

    /* renamed from: d, reason: collision with root package name */
    public static Promise f13839d;

    public static void a(String str) {
        Promise promise = f13839d;
        if (promise != null) {
            promise.reject(str);
        }
        f13839d = null;
    }

    public static void b(WritableMap writableMap) {
        Promise promise = f13839d;
        if (promise != null) {
            promise.resolve(writableMap);
        }
        f13839d = null;
    }

    public static IntentSender c(ReactContext reactContext) {
        synchronized (f13836a) {
            try {
                if (f13837b == null) {
                    f13837b = reactContext.getPackageName() + "/" + TargetChosenReceiver.class.getName() + "_ACTION";
                }
                Context applicationContext = reactContext.getApplicationContext();
                TargetChosenReceiver targetChosenReceiver = f13838c;
                if (targetChosenReceiver != null) {
                    applicationContext.unregisterReceiver(targetChosenReceiver);
                }
                f13838c = new TargetChosenReceiver();
                if (Build.VERSION.SDK_INT < 34 || applicationContext.getApplicationInfo().targetSdkVersion < 34) {
                    applicationContext.registerReceiver(f13838c, new IntentFilter(f13837b));
                } else {
                    applicationContext.registerReceiver(f13838c, new IntentFilter(f13837b), 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Intent intent = new Intent(f13837b);
        intent.setPackage(reactContext.getPackageName());
        intent.setClass(reactContext.getApplicationContext(), TargetChosenReceiver.class);
        intent.putExtra("receiver_token", f13838c.hashCode());
        return PendingIntent.getBroadcast(reactContext, 0, intent, 1409286144).getIntentSender();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (f13836a) {
            try {
                if (f13838c != this) {
                    return;
                }
                context.getApplicationContext().unregisterReceiver(f13838c);
                f13838c = null;
                if (intent.hasExtra("receiver_token") && intent.getIntExtra("receiver_token", 0) == hashCode()) {
                    ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean(APayConstants.SUCCESS, true);
                    if (componentName != null) {
                        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, componentName.flattenToString());
                    } else {
                        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "OK");
                    }
                    b(writableMapCreateMap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
