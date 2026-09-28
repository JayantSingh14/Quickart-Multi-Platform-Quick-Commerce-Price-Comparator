package ch.qos.logback.core.db.dialect;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class SQLDialectCode {

    /* renamed from: a, reason: collision with root package name */
    public static final SQLDialectCode f13465a;

    /* renamed from: b, reason: collision with root package name */
    public static final SQLDialectCode f13466b;

    /* renamed from: c, reason: collision with root package name */
    public static final SQLDialectCode f13467c;

    /* renamed from: d, reason: collision with root package name */
    public static final SQLDialectCode f13468d;

    /* renamed from: e, reason: collision with root package name */
    public static final SQLDialectCode f13469e;

    /* renamed from: f, reason: collision with root package name */
    public static final SQLDialectCode f13470f;

    /* renamed from: g, reason: collision with root package name */
    public static final SQLDialectCode f13471g;

    /* renamed from: h, reason: collision with root package name */
    public static final SQLDialectCode f13472h;

    /* renamed from: i, reason: collision with root package name */
    public static final SQLDialectCode f13473i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ SQLDialectCode[] f13474j;

    static {
        SQLDialectCode sQLDialectCode = new SQLDialectCode("UNKNOWN_DIALECT", 0);
        f13465a = sQLDialectCode;
        SQLDialectCode sQLDialectCode2 = new SQLDialectCode("POSTGRES_DIALECT", 1);
        f13466b = sQLDialectCode2;
        SQLDialectCode sQLDialectCode3 = new SQLDialectCode("MYSQL_DIALECT", 2);
        f13467c = sQLDialectCode3;
        SQLDialectCode sQLDialectCode4 = new SQLDialectCode("ORACLE_DIALECT", 3);
        f13468d = sQLDialectCode4;
        SQLDialectCode sQLDialectCode5 = new SQLDialectCode("MSSQL_DIALECT", 4);
        f13469e = sQLDialectCode5;
        SQLDialectCode sQLDialectCode6 = new SQLDialectCode("HSQL_DIALECT", 5);
        f13470f = sQLDialectCode6;
        SQLDialectCode sQLDialectCode7 = new SQLDialectCode("H2_DIALECT", 6);
        f13471g = sQLDialectCode7;
        SQLDialectCode sQLDialectCode8 = new SQLDialectCode("SYBASE_SQLANYWHERE_DIALECT", 7);
        f13472h = sQLDialectCode8;
        SQLDialectCode sQLDialectCode9 = new SQLDialectCode("SQLITE_DIALECT", 8);
        f13473i = sQLDialectCode9;
        f13474j = new SQLDialectCode[]{sQLDialectCode, sQLDialectCode2, sQLDialectCode3, sQLDialectCode4, sQLDialectCode5, sQLDialectCode6, sQLDialectCode7, sQLDialectCode8, sQLDialectCode9};
    }

    public static SQLDialectCode valueOf(String str) {
        return (SQLDialectCode) Enum.valueOf(SQLDialectCode.class, str);
    }

    public static SQLDialectCode[] values() {
        return (SQLDialectCode[]) f13474j.clone();
    }
}
