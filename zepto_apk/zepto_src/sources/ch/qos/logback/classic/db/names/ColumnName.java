package ch.qos.logback.classic.db.names;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class ColumnName {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColumnName[] f13260a = {new ColumnName("EVENT_ID", 0), new ColumnName("TIMESTMP", 1), new ColumnName("FORMATTED_MESSAGE", 2), new ColumnName("LOGGER_NAME", 3), new ColumnName("LEVEL_STRING", 4), new ColumnName("THREAD_NAME", 5), new ColumnName("REFERENCE_FLAG", 6), new ColumnName("ARG0", 7), new ColumnName("ARG1", 8), new ColumnName("ARG2", 9), new ColumnName("ARG3", 10), new ColumnName("CALLER_FILENAME", 11), new ColumnName("CALLER_CLASS", 12), new ColumnName("CALLER_METHOD", 13), new ColumnName("CALLER_LINE", 14), new ColumnName("MAPPED_KEY", 15), new ColumnName("MAPPED_VALUE", 16), new ColumnName("I", 17), new ColumnName("TRACE_LINE", 18)};

    /* JADX INFO: Fake field, exist only in values array */
    ColumnName EF5;

    public static ColumnName valueOf(String str) {
        return (ColumnName) Enum.valueOf(ColumnName.class, str);
    }

    public static ColumnName[] values() {
        return (ColumnName[]) f13260a.clone();
    }
}
