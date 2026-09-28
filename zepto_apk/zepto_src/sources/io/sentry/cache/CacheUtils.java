package io.sentry.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class CacheUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f52675a = Charset.forName("UTF-8");

    public static void a(SentryAndroidOptions sentryAndroidOptions, String str, String str2) {
        File fileB = b(sentryAndroidOptions, str);
        if (fileB == null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Deleting %s from scope cache", str2);
        if (file.delete()) {
            return;
        }
        sentryAndroidOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
    }

    public static File b(SentryOptions sentryOptions, String str) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }

    public static Object c(SentryOptions sentryOptions, String str, String str2, Class cls) {
        File fileB = b(sentryOptions, str);
        if (fileB == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileB, str2);
        if (!file.exists()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "No entry stored for %s", str2);
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f52675a));
            try {
                Object objD = sentryOptions.getSerializer().d(bufferedReader, cls);
                bufferedReader.close();
                return objD;
            } finally {
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Error reading entity from scope cache: %s", str2);
            return null;
        }
    }

    public static void d(SentryOptions sentryOptions, Object obj, String str, String str2) {
        File fileB = b(sentryOptions, str);
        if (fileB == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileB, str2));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, f52675a));
                try {
                    sentryOptions.getSerializer().e(obj, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Error persisting entity: %s", str2);
        }
    }
}
