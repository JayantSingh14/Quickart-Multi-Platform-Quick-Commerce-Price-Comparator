package com.facebook.hermes.intl;

/* loaded from: classes3.dex */
public interface IPlatformCollator {

    /* renamed from: com.facebook.hermes.intl.IPlatformCollator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17518a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17519b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f17520c;

        static {
            int[] iArr = new int[CaseFirst.values().length];
            f17520c = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17520c[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17520c[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Usage.values().length];
            f17519b = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17519b[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Sensitivity.values().length];
            f17518a = iArr3;
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17518a[1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17518a[2] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17518a[3] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17518a[4] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CaseFirst {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CaseFirst[] f17521a = {new CaseFirst("UPPER", 0), new CaseFirst("LOWER", 1), new CaseFirst("FALSE", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        CaseFirst EF5;

        public static CaseFirst valueOf(String str) {
            return (CaseFirst) Enum.valueOf(CaseFirst.class, str);
        }

        public static CaseFirst[] values() {
            return (CaseFirst[]) f17521a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "upper";
            }
            if (iOrdinal == 1) {
                return "lower";
            }
            if (iOrdinal == 2) {
                return "false";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Sensitivity {

        /* renamed from: a, reason: collision with root package name */
        public static final Sensitivity f17522a;

        /* renamed from: b, reason: collision with root package name */
        public static final Sensitivity f17523b;

        /* renamed from: c, reason: collision with root package name */
        public static final Sensitivity f17524c;

        /* renamed from: d, reason: collision with root package name */
        public static final Sensitivity f17525d;

        /* renamed from: e, reason: collision with root package name */
        public static final Sensitivity f17526e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ Sensitivity[] f17527f;

        static {
            Sensitivity sensitivity = new Sensitivity("BASE", 0);
            f17522a = sensitivity;
            Sensitivity sensitivity2 = new Sensitivity("ACCENT", 1);
            f17523b = sensitivity2;
            Sensitivity sensitivity3 = new Sensitivity("CASE", 2);
            f17524c = sensitivity3;
            Sensitivity sensitivity4 = new Sensitivity("VARIANT", 3);
            f17525d = sensitivity4;
            Sensitivity sensitivity5 = new Sensitivity("LOCALE", 4);
            f17526e = sensitivity5;
            f17527f = new Sensitivity[]{sensitivity, sensitivity2, sensitivity3, sensitivity4, sensitivity5};
        }

        public static Sensitivity valueOf(String str) {
            return (Sensitivity) Enum.valueOf(Sensitivity.class, str);
        }

        public static Sensitivity[] values() {
            return (Sensitivity[]) f17527f.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "base";
            }
            if (iOrdinal == 1) {
                return "accent";
            }
            if (iOrdinal == 2) {
                return "case";
            }
            if (iOrdinal == 3) {
                return "variant";
            }
            if (iOrdinal == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Usage {

        /* renamed from: a, reason: collision with root package name */
        public static final Usage f17528a;

        /* renamed from: b, reason: collision with root package name */
        public static final Usage f17529b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Usage[] f17530c;

        static {
            Usage usage = new Usage("SORT", 0);
            f17528a = usage;
            Usage usage2 = new Usage("SEARCH", 1);
            f17529b = usage2;
            f17530c = new Usage[]{usage, usage2};
        }

        public static Usage valueOf(String str) {
            return (Usage) Enum.valueOf(Usage.class, str);
        }

        public static Usage[] values() {
            return (Usage[]) f17530c.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "sort";
            }
            if (iOrdinal == 1) {
                return "search";
            }
            throw new IllegalArgumentException();
        }
    }
}
