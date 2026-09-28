package io.invertase.firebase.common;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.invertase.firebase.app.ReactNativeFirebaseAppModule;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RCTConvertFirebase {
    public static HashMap a(FirebaseApp firebaseApp) {
        firebaseApp.a();
        firebaseApp.a();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        String str = firebaseApp.f43490b;
        map3.put(CLConstants.FIELD_PAY_INFO_NAME, str);
        map3.put("automaticDataCollectionEnabled", Boolean.valueOf(firebaseApp.j()));
        FirebaseOptions firebaseOptions = firebaseApp.f43491c;
        map2.put("apiKey", firebaseOptions.f43506a);
        map2.put(CLConstants.SALT_FIELD_APP_ID, firebaseOptions.f43507b);
        map2.put("projectId", firebaseOptions.f43512g);
        map2.put("databaseURL", firebaseOptions.f43508c);
        map2.put("gaTrackingId", firebaseOptions.f43509d);
        map2.put("messagingSenderId", firebaseOptions.f43510e);
        map2.put("storageBucket", firebaseOptions.f43511f);
        if (ReactNativeFirebaseAppModule.authDomains.get(str) != null) {
            map2.put("authDomain", ReactNativeFirebaseAppModule.authDomains.get(str));
        }
        map.put("options", map2);
        map.put("appConfig", map3);
        return map;
    }
}
