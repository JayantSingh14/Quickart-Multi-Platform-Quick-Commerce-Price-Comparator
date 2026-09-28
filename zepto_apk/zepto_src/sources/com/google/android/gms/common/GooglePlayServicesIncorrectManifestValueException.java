package com.google.android.gms.common;

import androidx.fragment.app.e;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: classes4.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i2) {
        int i3 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 104 + String.valueOf(i2).length() + 194);
        e.w(i3, i2, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ", " but found ", sb);
        sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        super(i2, sb.toString());
    }
}
