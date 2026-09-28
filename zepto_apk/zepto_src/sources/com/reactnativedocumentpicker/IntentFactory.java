package com.reactnativedocumentpicker;

import android.content.Intent;
import android.os.Build;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class IntentFactory {
    public static Intent a(PickOptions options) {
        String strA;
        String str;
        Intrinsics.checkNotNullParameter(options, "options");
        String str2 = options.f46371a;
        Intent intent = new Intent(AbstractCircuitBreaker.PROPERTY_NAME.equals(str2) ? "android.intent.action.OPEN_DOCUMENT" : "android.intent.action.GET_CONTENT");
        String[] strArr = options.f46372b;
        if (strArr.length > 1) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
            strA = (AbstractCircuitBreaker.PROPERTY_NAME.equals(str2) ? "android.intent.action.OPEN_DOCUMENT" : "android.intent.action.GET_CONTENT").equals("android.intent.action.OPEN_DOCUMENT") ? "*/*" : ArraysKt.A(62, CLConstants.SALT_DELIMETER, strArr);
        } else {
            strA = strArr[0];
        }
        intent.setType(strA);
        if (Build.VERSION.SDK_INT >= 26 && (str = options.f46373c) != null) {
            intent.putExtra("android.provider.extra.INITIAL_URI", str);
        }
        if (!options.f46377g) {
            intent.addCategory("android.intent.category.OPENABLE");
        }
        intent.putExtra("android.intent.extra.LOCAL_ONLY", options.f46374d);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", options.f46375e);
        return intent;
    }
}
