package org.shadow.apache.commons.lang3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'm' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class JavaVersion {

    /* renamed from: c, reason: collision with root package name */
    public static final JavaVersion f57708c;

    /* renamed from: d, reason: collision with root package name */
    public static final JavaVersion f57709d;

    /* renamed from: e, reason: collision with root package name */
    public static final JavaVersion f57710e;

    /* renamed from: f, reason: collision with root package name */
    public static final JavaVersion f57711f;

    /* renamed from: g, reason: collision with root package name */
    public static final JavaVersion f57712g;

    /* renamed from: h, reason: collision with root package name */
    public static final JavaVersion f57713h;

    /* renamed from: i, reason: collision with root package name */
    public static final JavaVersion f57714i;

    /* renamed from: j, reason: collision with root package name */
    public static final JavaVersion f57715j;

    /* renamed from: k, reason: collision with root package name */
    public static final JavaVersion f57716k;

    /* renamed from: l, reason: collision with root package name */
    public static final JavaVersion f57717l;

    /* renamed from: m, reason: collision with root package name */
    public static final JavaVersion f57718m;
    public static final /* synthetic */ JavaVersion[] n;

    /* renamed from: a, reason: collision with root package name */
    public final float f57719a;

    /* renamed from: b, reason: collision with root package name */
    public final String f57720b;

    static {
        JavaVersion javaVersion = new JavaVersion("JAVA_0_9", 0, 1.5f, "0.9");
        f57708c = javaVersion;
        JavaVersion javaVersion2 = new JavaVersion("JAVA_1_1", 1, 1.1f, "1.1");
        f57709d = javaVersion2;
        JavaVersion javaVersion3 = new JavaVersion("JAVA_1_2", 2, 1.2f, "1.2");
        f57710e = javaVersion3;
        JavaVersion javaVersion4 = new JavaVersion("JAVA_1_3", 3, 1.3f, "1.3");
        f57711f = javaVersion4;
        JavaVersion javaVersion5 = new JavaVersion("JAVA_1_4", 4, 1.4f, "1.4");
        f57712g = javaVersion5;
        JavaVersion javaVersion6 = new JavaVersion("JAVA_1_5", 5, 1.5f, "1.5");
        f57713h = javaVersion6;
        JavaVersion javaVersion7 = new JavaVersion("JAVA_1_6", 6, 1.6f, "1.6");
        f57714i = javaVersion7;
        JavaVersion javaVersion8 = new JavaVersion("JAVA_1_7", 7, 1.7f, "1.7");
        f57715j = javaVersion8;
        JavaVersion javaVersion9 = new JavaVersion("JAVA_1_8", 8, 1.8f, "1.8");
        f57716k = javaVersion9;
        JavaVersion javaVersion10 = new JavaVersion("JAVA_1_9", 9, 1.9f, "1.9");
        f57717l = javaVersion10;
        float fA = a(System.getProperty("java.version", "2.0"));
        fA = fA <= 0.0f ? 2.0f : fA;
        float fA2 = a(System.getProperty("java.version", "2.0"));
        JavaVersion javaVersion11 = new JavaVersion("JAVA_RECENT", 10, fA, Float.toString(fA2 > 0.0f ? fA2 : 2.0f));
        f57718m = javaVersion11;
        n = new JavaVersion[]{javaVersion, javaVersion2, javaVersion3, javaVersion4, javaVersion5, javaVersion6, javaVersion7, javaVersion8, javaVersion9, javaVersion10, javaVersion11};
    }

    public JavaVersion(String str, int i2, float f2, String str2) {
        this.f57719a = f2;
        this.f57720b = str2;
    }

    public static float a(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 2) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(strArrSplit[0] + org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR + strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    public static JavaVersion valueOf(String str) {
        return (JavaVersion) Enum.valueOf(JavaVersion.class, str);
    }

    public static JavaVersion[] values() {
        return (JavaVersion[]) n.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f57720b;
    }
}
