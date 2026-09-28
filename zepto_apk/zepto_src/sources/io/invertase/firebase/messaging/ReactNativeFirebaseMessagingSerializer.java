package io.invertase.firebase.messaging;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import java.util.Map;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseMessagingSerializer {
    public static RemoteMessage a(ReadableMap readableMap) {
        RemoteMessage.Builder builder = new RemoteMessage.Builder(readableMap.getString("to"));
        boolean zHasKey = readableMap.hasKey("ttl");
        Bundle bundle = builder.f44735a;
        if (zHasKey) {
            bundle.putString("google.ttl", String.valueOf(readableMap.getInt("ttl")));
        }
        if (readableMap.hasKey("messageId")) {
            bundle.putString("google.message_id", readableMap.getString("messageId"));
        }
        if (readableMap.hasKey("messageType")) {
            bundle.putString("message_type", readableMap.getString("messageType"));
        }
        if (readableMap.hasKey("collapseKey")) {
            bundle.putString("collapse_key", readableMap.getString("collapseKey"));
        }
        boolean zHasKey2 = readableMap.hasKey("data");
        ArrayMap arrayMap = builder.f44736b;
        if (zHasKey2) {
            ReadableMap map = readableMap.getMap("data");
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                arrayMap.put(strNextKey, map.getString(strNextKey));
            }
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : arrayMap.entrySet()) {
            bundle2.putString((String) entry.getKey(), (String) entry.getValue());
        }
        bundle2.putAll(bundle);
        bundle.remove("from");
        return new RemoteMessage(bundle2);
    }

    public static ReactNativeFirebaseEvent b(WritableMap writableMap) {
        return new ReactNativeFirebaseEvent("messaging_notification_opened", writableMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.react.bridge.WritableMap c(com.google.firebase.messaging.RemoteMessage r10) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingSerializer.c(com.google.firebase.messaging.RemoteMessage):com.facebook.react.bridge.WritableMap");
    }
}
