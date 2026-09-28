package io.invertase.firebase.messaging;

import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseMessagingStoreImpl implements ReactNativeFirebaseMessagingStore {
    public final void a(String str) {
        UniversalFirebasePreferences universalFirebasePreferences = UniversalFirebasePreferences.f49248b;
        universalFirebasePreferences.a().edit().remove(str);
        String string = universalFirebasePreferences.a().getString("all_notification_ids", "");
        if (string.isEmpty()) {
            return;
        }
        universalFirebasePreferences.a().edit().putString("all_notification_ids", string.replace(str + ",", "")).apply();
    }

    public final WritableMap b(String str) {
        String string = UniversalFirebasePreferences.f49248b.a().getString(str, null);
        if (string != null) {
            try {
                WritableMap writableMapB = JsonConvert.b(new JSONObject(string));
                writableMapB.putString("to", str);
                return writableMapB;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
