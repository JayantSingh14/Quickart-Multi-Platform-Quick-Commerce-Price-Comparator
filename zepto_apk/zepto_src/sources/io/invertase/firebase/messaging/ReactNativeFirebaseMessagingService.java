package io.invertase.firebase.messaging;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.SharedUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseMessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onDeletedMessages() {
        ReactNativeFirebaseEventEmitter.f49230g.b(new ReactNativeFirebaseEvent("messaging_message_deleted", Arguments.createMap()));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onMessageSent(String str) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("messageId", str);
        reactNativeFirebaseEventEmitter.b(new ReactNativeFirebaseEvent("messaging_message_sent", writableMapCreateMap));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onNewToken(String str) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, str);
        reactNativeFirebaseEventEmitter.b(new ReactNativeFirebaseEvent("messaging_token_refresh", writableMapCreateMap));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onSendError(String str, Exception exc) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("messageId", str);
        writableMapCreateMap.putMap("error", SharedUtils.a(exc));
        reactNativeFirebaseEventEmitter.b(new ReactNativeFirebaseEvent("messaging_message_send_error", writableMapCreateMap));
    }
}
