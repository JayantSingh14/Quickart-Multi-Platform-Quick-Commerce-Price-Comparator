package cl.json;

import android.content.ActivityNotFoundException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import cl.json.RNShareImpl;
import cl.json.social.GenericShare;
import cl.json.social.ShareIntent;
import cl.json.social.TargetChosenReceiver;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class RNShare extends ReactContextBaseJavaModule {
    private final RNShareImpl delegate;

    public RNShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        RNShareImpl rNShareImpl = new RNShareImpl();
        RNShareImpl.f13815a = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(rNShareImpl);
        this.delegate = rNShareImpl;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        this.delegate.getClass();
        HashMap map = new HashMap();
        for (RNShareImpl.SHARES shares : RNShareImpl.SHARES.values()) {
            map.put(shares.toString().toUpperCase(Locale.ROOT), shares.toString());
        }
        return map;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNShare";
    }

    @ReactMethod
    public void isBase64File(String str, Promise promise) {
        this.delegate.getClass();
        try {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || !scheme.equals("data")) {
                promise.resolve(Boolean.FALSE);
            } else {
                promise.resolve(Boolean.TRUE);
            }
        } catch (Exception e2) {
            Log.e("RNShare", e2.getMessage());
            e2.printStackTrace(System.out);
            promise.reject(e2.getMessage());
        }
    }

    @ReactMethod
    public void isPackageInstalled(String str, Promise promise) throws PackageManager.NameNotFoundException {
        this.delegate.getClass();
        try {
            boolean z = true;
            try {
                RNShareImpl.f13815a.getPackageManager().getPackageInfo(str, 1);
            } catch (PackageManager.NameNotFoundException unused) {
                z = false;
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.e("RNShare", e2.getMessage());
            promise.reject(e2.getMessage());
        }
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        this.delegate.getClass();
        TargetChosenReceiver.f13839d = promise;
        try {
            new GenericShare(RNShareImpl.f13815a).f(readableMap);
        } catch (ActivityNotFoundException e2) {
            Log.e("RNShare", e2.getMessage());
            e2.printStackTrace(System.out);
            TargetChosenReceiver.a("not_available");
        } catch (Exception e3) {
            Log.e("RNShare", e3.getMessage());
            e3.printStackTrace(System.out);
            TargetChosenReceiver.a(e3.getMessage());
        }
    }

    @ReactMethod
    public void shareSingle(ReadableMap readableMap, Promise promise) {
        this.delegate.getClass();
        TargetChosenReceiver.f13839d = promise;
        if (!ShareIntent.e(readableMap, "social")) {
            TargetChosenReceiver.a("key 'social' missing in options");
            return;
        }
        try {
            ShareIntent shareIntentA = RNShareImpl.SHARES.a(RNShareImpl.f13815a, readableMap.getString("social"));
            if (shareIntentA == null) {
                throw new ActivityNotFoundException("Invalid share activity");
            }
            shareIntentA.f(readableMap);
        } catch (ActivityNotFoundException e2) {
            Log.e("RNShare", e2.getMessage());
            e2.printStackTrace(System.out);
            TargetChosenReceiver.a(e2.getMessage());
        } catch (Exception e3) {
            Log.e("RNShare", e3.getMessage());
            e3.printStackTrace(System.out);
            TargetChosenReceiver.a(e3.getMessage());
        }
    }
}
