package com.reactcommunity.rndatetimepicker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.util.RNLog;
import j$.util.DesugarTimeZone;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class Common {
    public static Bundle a(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(CLConstants.FIELD_PAY_INFO_VALUE) && !readableMap.isNull(CLConstants.FIELD_PAY_INFO_VALUE)) {
            bundle.putLong(CLConstants.FIELD_PAY_INFO_VALUE, (long) readableMap.getDouble(CLConstants.FIELD_PAY_INFO_VALUE));
        }
        if (readableMap.hasKey("timeZoneName") && !readableMap.isNull("timeZoneName")) {
            bundle.putString("timeZoneName", readableMap.getString("timeZoneName"));
        }
        return bundle;
    }

    public static void b(FragmentActivity fragmentActivity, String str, Promise promise) {
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to close a " + str + " dialog while not attached to an Activity");
            return;
        }
        try {
            DialogFragment dialogFragment = (DialogFragment) fragmentActivity.getSupportFragmentManager().E(str);
            boolean z = dialogFragment != null;
            if (z) {
                dialogFragment.dismiss();
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }

    public static TimeZone c(Bundle bundle) {
        if (bundle != null && bundle.containsKey("timeZoneOffsetInMinutes")) {
            return new SimpleTimeZone(((int) bundle.getLong("timeZoneOffsetInMinutes")) * 60000, TimeZones.GMT_ID);
        }
        if (bundle != null && bundle.containsKey("timeZoneName")) {
            String string = bundle.getString("timeZoneName");
            if (TimeZones.GMT_ID.equals(string)) {
                return DesugarTimeZone.getTimeZone(TimeZones.GMT_ID);
            }
            if (!TimeZones.GMT_ID.equals(DesugarTimeZone.getTimeZone(string).getID())) {
                return DesugarTimeZone.getTimeZone(string);
            }
            StringBuilder sbY = android.support.v4.media.b.y("'", string, "' does not exist in TimeZone.getAvailableIDs(). Falling back to TimeZone.getDefault()=");
            sbY.append(TimeZone.getDefault().getID());
            RNLog.c(null, sbY.toString());
        }
        return TimeZone.getDefault();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Bundle bundle, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
        Bundle bundle2 = bundle.getBundle("dialogButtons");
        if (bundle2 == null) {
            return;
        }
        Bundle bundle3 = bundle2.getBundle("neutral");
        if (bundle3 != null && bundle3.getString("label") != null) {
            alertDialog.setButton(-3, bundle3.getString("label"), onClickListener);
        }
        Bundle bundle4 = bundle2.getBundle("positive");
        DialogInterface.OnClickListener onClickListener2 = (DialogInterface.OnClickListener) alertDialog;
        if (bundle4 != null && bundle4.getString("label") != null) {
            alertDialog.setButton(-1, bundle4.getString("label"), onClickListener2);
        }
        Bundle bundle5 = bundle2.getBundle("negative");
        if (bundle5 == null || bundle5.getString("label") == null) {
            return;
        }
        alertDialog.setButton(-2, bundle5.getString("label"), onClickListener2);
    }

    public static void e(Button button, String str, Bundle bundle, boolean z, int i2) {
        Bundle bundle2;
        int i3;
        if (button == null) {
            return;
        }
        Bundle bundle3 = bundle.getBundle("dialogButtons");
        Integer numValueOf = null;
        if (bundle3 != null && (bundle2 = bundle3.getBundle(str)) != null && (i3 = (int) bundle2.getDouble("textColor", 0.0d)) != 0) {
            numValueOf = Integer.valueOf(i3);
        }
        if (z || numValueOf != null) {
            if (numValueOf != null) {
                i2 = numValueOf.intValue();
            }
            button.setTextColor(i2);
        }
    }
}
