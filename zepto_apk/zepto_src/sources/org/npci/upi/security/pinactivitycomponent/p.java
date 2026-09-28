package org.npci.upi.security.pinactivitycomponent;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Locale;

/* loaded from: classes5.dex */
public class p {
    public static Context a(Context context, String str) {
        return b(context, str);
    }

    @TargetApi(24)
    private static Context b(Context context, String str) {
        String[] strArrSplit = str.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
        Locale locale = new Locale(str);
        if (strArrSplit.length == 2) {
            locale = new Locale(strArrSplit[0], strArrSplit[1]);
        }
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context c(Context context, String str) {
        String[] strArrSplit = str.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
        Locale locale = new Locale(str);
        if (strArrSplit.length == 2) {
            locale = new Locale(strArrSplit[0], strArrSplit[1]);
        }
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
