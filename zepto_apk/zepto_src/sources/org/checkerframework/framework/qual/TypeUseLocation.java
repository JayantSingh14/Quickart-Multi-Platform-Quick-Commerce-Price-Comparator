package org.checkerframework.framework.qual;

import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class TypeUseLocation {

    /* renamed from: a, reason: collision with root package name */
    public static final TypeUseLocation f57458a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TypeUseLocation[] f57459b;

    /* JADX INFO: Fake field, exist only in values array */
    TypeUseLocation EF1;

    static {
        TypeUseLocation typeUseLocation = new TypeUseLocation("FIELD", 0);
        TypeUseLocation typeUseLocation2 = new TypeUseLocation("LOCAL_VARIABLE", 1);
        TypeUseLocation typeUseLocation3 = new TypeUseLocation("RESOURCE_VARIABLE", 2);
        TypeUseLocation typeUseLocation4 = new TypeUseLocation("EXCEPTION_PARAMETER", 3);
        TypeUseLocation typeUseLocation5 = new TypeUseLocation("RECEIVER", 4);
        TypeUseLocation typeUseLocation6 = new TypeUseLocation("PARAMETER", 5);
        TypeUseLocation typeUseLocation7 = new TypeUseLocation("RETURN", 6);
        TypeUseLocation typeUseLocation8 = new TypeUseLocation("CONSTRUCTOR_RESULT", 7);
        TypeUseLocation typeUseLocation9 = new TypeUseLocation("LOWER_BOUND", 8);
        TypeUseLocation typeUseLocation10 = new TypeUseLocation("EXPLICIT_LOWER_BOUND", 9);
        TypeUseLocation typeUseLocation11 = new TypeUseLocation("IMPLICIT_LOWER_BOUND", 10);
        TypeUseLocation typeUseLocation12 = new TypeUseLocation("UPPER_BOUND", 11);
        TypeUseLocation typeUseLocation13 = new TypeUseLocation("EXPLICIT_UPPER_BOUND", 12);
        TypeUseLocation typeUseLocation14 = new TypeUseLocation("IMPLICIT_UPPER_BOUND", 13);
        TypeUseLocation typeUseLocation15 = new TypeUseLocation("OTHERWISE", 14);
        TypeUseLocation typeUseLocation16 = new TypeUseLocation(Rule.ALL, 15);
        f57458a = typeUseLocation16;
        f57459b = new TypeUseLocation[]{typeUseLocation, typeUseLocation2, typeUseLocation3, typeUseLocation4, typeUseLocation5, typeUseLocation6, typeUseLocation7, typeUseLocation8, typeUseLocation9, typeUseLocation10, typeUseLocation11, typeUseLocation12, typeUseLocation13, typeUseLocation14, typeUseLocation15, typeUseLocation16};
    }

    public static TypeUseLocation valueOf(String str) {
        return (TypeUseLocation) Enum.valueOf(TypeUseLocation.class, str);
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) f57459b.clone();
    }
}
