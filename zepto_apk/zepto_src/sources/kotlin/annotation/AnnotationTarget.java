package kotlin.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class AnnotationTarget {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnotationTarget[] f53579a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53580b;

    static {
        AnnotationTarget[] annotationTargetArr = {new AnnotationTarget("CLASS", 0), new AnnotationTarget("ANNOTATION_CLASS", 1), new AnnotationTarget("TYPE_PARAMETER", 2), new AnnotationTarget("PROPERTY", 3), new AnnotationTarget("FIELD", 4), new AnnotationTarget("LOCAL_VARIABLE", 5), new AnnotationTarget("VALUE_PARAMETER", 6), new AnnotationTarget("CONSTRUCTOR", 7), new AnnotationTarget("FUNCTION", 8), new AnnotationTarget("PROPERTY_GETTER", 9), new AnnotationTarget("PROPERTY_SETTER", 10), new AnnotationTarget("TYPE", 11), new AnnotationTarget("EXPRESSION", 12), new AnnotationTarget("FILE", 13), new AnnotationTarget("TYPEALIAS", 14)};
        f53579a = annotationTargetArr;
        f53580b = EnumEntriesKt.a(annotationTargetArr);
    }

    public static AnnotationTarget valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) f53579a.clone();
    }
}
