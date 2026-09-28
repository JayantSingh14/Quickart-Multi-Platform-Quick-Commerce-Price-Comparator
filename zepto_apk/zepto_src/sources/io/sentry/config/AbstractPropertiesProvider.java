package io.sentry.config;

import android.support.v4.media.b;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
abstract class AbstractPropertiesProvider implements PropertiesProvider {

    /* renamed from: a, reason: collision with root package name */
    public final String f52723a;

    /* renamed from: b, reason: collision with root package name */
    public final Properties f52724b;

    public AbstractPropertiesProvider(String str, Properties properties) {
        this.f52723a = str;
        Objects.b(properties, "properties are required");
        this.f52724b = properties;
    }

    @Override // io.sentry.config.PropertiesProvider
    public final String b(String str) {
        return StringUtils.b(this.f52724b.getProperty(b.r(new StringBuilder(), this.f52723a, str)));
    }

    @Override // io.sentry.config.PropertiesProvider
    public final Map c() {
        String strR = b.r(new StringBuilder(), this.f52723a, "tags.");
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f52724b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str = (String) entry.getKey();
                if (str.startsWith(strR)) {
                    map.put(str.substring(strR.length()), StringUtils.b((String) entry.getValue()));
                }
            }
        }
        return map;
    }
}
