package com.zeptoconsumerapp.services;

import android.os.Bundle;
import bridges.CommsModule;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.Utils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* loaded from: classes4.dex */
public class ZMessageListenerService extends FirebaseMessagingService {
    public final void b(Bundle bundle) throws JSONException, UnsupportedEncodingException {
        try {
            Timber.d("FCMMessageService").d("interceptOrderConfirmation() called with extras=%s", bundle);
            boolean zContainsKey = bundle.containsKey("nt");
            boolean zContainsKey2 = bundle.containsKey("nm");
            boolean zContainsKey3 = bundle.containsKey("url");
            Timber.d("FCMMessageService").d("containsTitle=%s containsMsg=%s containsUrl=%s", Boolean.valueOf(zContainsKey), Boolean.valueOf(zContainsKey2), Boolean.valueOf(zContainsKey3));
            if (zContainsKey && zContainsKey3) {
                String string = bundle.getString("nt");
                String string2 = bundle.getString("url");
                String string3 = zContainsKey2 ? bundle.getString("nm") : "";
                Timber.d("FCMMessageService").d("title=%s msg=%s deeplink=%s", string, string3, string2);
                boolean z = (string != null && string.toLowerCase().contains("order confirmed")) || (string3 != null && string3.toLowerCase().contains("see you soon with your order"));
                Timber.d("FCMMessageService").d("hasConfirmationKeywords=%s", Boolean.valueOf(z));
                if (z && string2 != null && string2.contains("orderId=")) {
                    try {
                        String strDecode = URLDecoder.decode(new URL(string2).getQuery(), "UTF-8");
                        Timber.d("FCMMessageService").d("Decoded query=%s", strDecode);
                        String strE = Utils.e(strDecode);
                        Timber.d("FCMMessageService").d("Extracted orderId=%s", strE);
                        if (strE != null) {
                            getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).edit().putString("lastConfirmedOrderId", strE).apply();
                            Timber.d("FCMMessageService").d("Saved orderId to SharedPreferences", new Object[0]);
                            MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this, BuildConfig.MIXPANEL_KEY, null, false);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(PaymentConstants.ORDER_ID_CAMEL, strE);
                            mixpanelAPIL.y("order_confirmed_notification", jSONObject);
                            Timber.d("FCMMessageService").d("Tracked Mixpanel event %s with props=%s", "order_confirmed_notification", jSONObject);
                        }
                    } catch (Exception e2) {
                        Timber.d("FCMMessageService").e(e2, "Error parsing order confirmation deeplink", new Object[0]);
                    }
                }
            }
        } catch (Exception e3) {
            Timber.d("FCMMessageService").e(e3, "Error in interceptOrderConfirmation()", new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d1 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:3:0x0003, B:5:0x002a, B:6:0x003a, B:8:0x0040, B:11:0x006e, B:14:0x0095, B:16:0x009e, B:22:0x00de, B:24:0x00f3, B:27:0x00fb, B:29:0x0101, B:18:0x00b4, B:20:0x00bd, B:21:0x00d1, B:31:0x0117), top: B:35:0x0003 }] */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMessageReceived(com.google.firebase.messaging.RemoteMessage r12) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.services.ZMessageListenerService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onNewToken(String str) {
        try {
            getApplicationContext();
            Timber.d("FCMMessageService").d("onNewToken() called with token: %s", str);
        } catch (Throwable th) {
            Timber.d("FCMMessageService").e(th, "Error on new token", new Object[0]);
        }
    }
}
