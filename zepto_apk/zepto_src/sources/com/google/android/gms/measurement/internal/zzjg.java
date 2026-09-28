package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzjg {
    public static void a(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(CLConstants.FIELD_PAY_INFO_VALUE, ((Long) obj).longValue());
        } else {
            bundle.putString(CLConstants.FIELD_PAY_INFO_VALUE, obj.toString());
        }
    }

    public static Object b(Bundle bundle, String str, Class cls, Object obj) {
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return obj2;
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalStateException(b.r(e.v("Invalid conditional user property field type. '", str, "' expected [", canonicalName, "] but was ["), obj2.getClass().getCanonicalName(), "]"));
    }
}
