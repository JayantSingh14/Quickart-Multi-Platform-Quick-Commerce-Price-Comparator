package ch.qos.logback.core.joran.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;

/* loaded from: classes3.dex */
public class ConfigurationWatchListUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ConfigurationWatchListUtil f13579a = new ConfigurationWatchListUtil();

    public static ConfigurationWatchList a(Context context) {
        return (ConfigurationWatchList) context.n0("CONFIGURATION_WATCH_LIST");
    }
}
