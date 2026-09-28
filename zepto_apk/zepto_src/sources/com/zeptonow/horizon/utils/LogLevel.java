package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class LogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final LogLevel f48263a;

    /* renamed from: b, reason: collision with root package name */
    public static final LogLevel f48264b;

    /* renamed from: c, reason: collision with root package name */
    public static final LogLevel f48265c;

    /* renamed from: d, reason: collision with root package name */
    public static final LogLevel f48266d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f48267e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48268f;

    static {
        LogLevel logLevel = new LogLevel("NONE", 0);
        f48263a = logLevel;
        LogLevel logLevel2 = new LogLevel("BASIC", 1);
        f48264b = logLevel2;
        LogLevel logLevel3 = new LogLevel("BATCH", 2);
        f48265c = logLevel3;
        LogLevel logLevel4 = new LogLevel("EVENT", 3);
        f48266d = logLevel4;
        LogLevel[] logLevelArr = {logLevel, logLevel2, logLevel3, logLevel4};
        f48267e = logLevelArr;
        f48268f = EnumEntriesKt.a(logLevelArr);
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f48267e.clone();
    }
}
