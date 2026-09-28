package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class WeekDay {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WeekDay[] f50553a = {new WeekDay("MONDAY", 0), new WeekDay("TUESDAY", 1), new WeekDay("WEDNESDAY", 2), new WeekDay("THURSDAY", 3), new WeekDay("FRIDAY", 4), new WeekDay("SATURDAY", 5), new WeekDay("SUNDAY", 6)};

    /* JADX INFO: Fake field, exist only in values array */
    WeekDay EF5;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public static WeekDay valueOf(String str) {
        return (WeekDay) Enum.valueOf(WeekDay.class, str);
    }

    public static WeekDay[] values() {
        return (WeekDay[]) f50553a.clone();
    }
}
