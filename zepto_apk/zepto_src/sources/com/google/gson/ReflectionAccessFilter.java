package com.google.gson;

/* loaded from: classes4.dex */
public interface ReflectionAccessFilter {

    /* renamed from: com.google.gson.ReflectionAccessFilter$1, reason: invalid class name */
    public class AnonymousClass1 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public final FilterResult a(Class cls) {
            String name = cls.getName();
            return (name.startsWith("java.") || name.startsWith("javax.")) ? FilterResult.f45262c : FilterResult.f45261b;
        }

        public final String toString() {
            return "ReflectionAccessFilter#BLOCK_INACCESSIBLE_JAVA";
        }
    }

    /* renamed from: com.google.gson.ReflectionAccessFilter$2, reason: invalid class name */
    public class AnonymousClass2 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public final FilterResult a(Class cls) {
            String name = cls.getName();
            return (name.startsWith("java.") || name.startsWith("javax.")) ? FilterResult.f45263d : FilterResult.f45261b;
        }

        public final String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_JAVA";
        }
    }

    /* renamed from: com.google.gson.ReflectionAccessFilter$3, reason: invalid class name */
    public class AnonymousClass3 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public final FilterResult a(Class cls) {
            String name = cls.getName();
            return (name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.")) ? FilterResult.f45263d : FilterResult.f45261b;
        }

        public final String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_ANDROID";
        }
    }

    /* renamed from: com.google.gson.ReflectionAccessFilter$4, reason: invalid class name */
    public class AnonymousClass4 implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public final FilterResult a(Class cls) {
            String name = cls.getName();
            return (name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.")) ? FilterResult.f45263d : FilterResult.f45261b;
        }

        public final String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_PLATFORM";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class FilterResult {

        /* renamed from: a, reason: collision with root package name */
        public static final FilterResult f45260a;

        /* renamed from: b, reason: collision with root package name */
        public static final FilterResult f45261b;

        /* renamed from: c, reason: collision with root package name */
        public static final FilterResult f45262c;

        /* renamed from: d, reason: collision with root package name */
        public static final FilterResult f45263d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ FilterResult[] f45264e;

        static {
            FilterResult filterResult = new FilterResult("ALLOW", 0);
            f45260a = filterResult;
            FilterResult filterResult2 = new FilterResult("INDECISIVE", 1);
            f45261b = filterResult2;
            FilterResult filterResult3 = new FilterResult("BLOCK_INACCESSIBLE", 2);
            f45262c = filterResult3;
            FilterResult filterResult4 = new FilterResult("BLOCK_ALL", 3);
            f45263d = filterResult4;
            f45264e = new FilterResult[]{filterResult, filterResult2, filterResult3, filterResult4};
        }

        public static FilterResult valueOf(String str) {
            return (FilterResult) Enum.valueOf(FilterResult.class, str);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) f45264e.clone();
        }
    }

    FilterResult a(Class cls);
}
