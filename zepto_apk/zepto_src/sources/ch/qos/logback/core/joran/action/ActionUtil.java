package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;

/* loaded from: classes3.dex */
public class ActionUtil {

    /* renamed from: ch.qos.logback.core.joran.action.ActionUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13497a;

        static {
            int[] iArr = new int[Scope.values().length];
            f13497a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13497a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13497a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Scope {

        /* renamed from: a, reason: collision with root package name */
        public static final Scope f13498a;

        /* renamed from: b, reason: collision with root package name */
        public static final Scope f13499b;

        /* renamed from: c, reason: collision with root package name */
        public static final Scope f13500c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f13501d;

        static {
            Scope scope = new Scope("LOCAL", 0);
            f13498a = scope;
            Scope scope2 = new Scope("CONTEXT", 1);
            f13499b = scope2;
            Scope scope3 = new Scope("SYSTEM", 2);
            f13500c = scope3;
            f13501d = new Scope[]{scope, scope2, scope3};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) f13501d.clone();
        }
    }

    public static void a(InterpretationContext interpretationContext, String str, String str2, Scope scope) {
        int iOrdinal = scope.ordinal();
        if (iOrdinal == 0) {
            interpretationContext.getClass();
            if (str == null || str2 == null) {
                return;
            }
            interpretationContext.f13564f.put(str, str2.trim());
            return;
        }
        if (iOrdinal == 1) {
            interpretationContext.f13733b.s0(str, str2);
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        try {
            System.setProperty(str, str2);
        } catch (SecurityException e2) {
            interpretationContext.o1("Failed to set system property [" + str + "]", e2);
        }
    }

    public static Scope b(String str) {
        return "SYSTEM".equalsIgnoreCase(str) ? Scope.f13500c : "CONTEXT".equalsIgnoreCase(str) ? Scope.f13499b : Scope.f13498a;
    }
}
