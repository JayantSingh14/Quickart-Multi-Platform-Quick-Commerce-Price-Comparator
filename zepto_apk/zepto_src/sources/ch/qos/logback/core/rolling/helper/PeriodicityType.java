package ch.qos.logback.core.rolling.helper;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class PeriodicityType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PeriodicityType[] f13727a = {new PeriodicityType("ERRONEOUS", 0), new PeriodicityType("TOP_OF_MILLISECOND", 1), new PeriodicityType("TOP_OF_SECOND", 2), new PeriodicityType("TOP_OF_MINUTE", 3), new PeriodicityType("TOP_OF_HOUR", 4), new PeriodicityType("HALF_DAY", 5), new PeriodicityType("TOP_OF_DAY", 6), new PeriodicityType("TOP_OF_WEEK", 7), new PeriodicityType("TOP_OF_MONTH", 8)};

    /* JADX INFO: Fake field, exist only in values array */
    PeriodicityType EF5;

    public static PeriodicityType valueOf(String str) {
        return (PeriodicityType) Enum.valueOf(PeriodicityType.class, str);
    }

    public static PeriodicityType[] values() {
        return (PeriodicityType[]) f13727a.clone();
    }
}
