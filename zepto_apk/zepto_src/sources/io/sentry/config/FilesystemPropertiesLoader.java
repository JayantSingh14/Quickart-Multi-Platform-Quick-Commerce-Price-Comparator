package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.SystemOutLogger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes3.dex */
final class FilesystemPropertiesLoader implements PropertiesLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f52729a;

    /* renamed from: b, reason: collision with root package name */
    public final SystemOutLogger f52730b;

    public FilesystemPropertiesLoader(String str, SystemOutLogger systemOutLogger) {
        this.f52729a = str;
        this.f52730b = systemOutLogger;
    }

    public final Properties a() throws IOException {
        String str = this.f52729a;
        try {
            File file = new File(str);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                return properties;
            } finally {
            }
        } catch (IOException e2) {
            this.f52730b.a(SentryLevel.ERROR, e2, "Failed to load Sentry configuration from file: %s", str);
            return null;
        }
    }
}
