package ch.qos.logback.classic.db.names;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TableName {

    /* renamed from: a, reason: collision with root package name */
    public static final TableName f13261a;

    /* renamed from: b, reason: collision with root package name */
    public static final TableName f13262b;

    /* renamed from: c, reason: collision with root package name */
    public static final TableName f13263c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ TableName[] f13264d;

    static {
        TableName tableName = new TableName("LOGGING_EVENT", 0);
        f13261a = tableName;
        TableName tableName2 = new TableName("LOGGING_EVENT_PROPERTY", 1);
        f13262b = tableName2;
        TableName tableName3 = new TableName("LOGGING_EVENT_EXCEPTION", 2);
        f13263c = tableName3;
        f13264d = new TableName[]{tableName, tableName2, tableName3};
    }

    public static TableName valueOf(String str) {
        return (TableName) Enum.valueOf(TableName.class, str);
    }

    public static TableName[] values() {
        return (TableName[]) f13264d.clone();
    }
}
