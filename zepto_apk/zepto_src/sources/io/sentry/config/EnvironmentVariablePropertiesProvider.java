package io.sentry.config;

import android.support.v4.media.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import io.sentry.util.StringUtils;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
final class EnvironmentVariablePropertiesProvider implements PropertiesProvider {
    public static String g(String str) {
        return "SENTRY_" + str.replace(CLConstants.DOT_SALT_DELIMETER, Attributes.PREDEFINED_ATTRIBUTE_PREFIX).replace("-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX).toUpperCase(Locale.ROOT);
    }

    @Override // io.sentry.config.PropertiesProvider
    public final String b(String str) {
        return StringUtils.b(System.getenv(g(str)));
    }

    @Override // io.sentry.config.PropertiesProvider
    public final Map c() {
        String strB;
        String strR = b.r(new StringBuilder(), g("tags"), Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(strR) && (strB = StringUtils.b(entry.getValue())) != null) {
                concurrentHashMap.put(key.substring(strR.length()).toLowerCase(Locale.ROOT), strB);
            }
        }
        return concurrentHashMap;
    }
}
