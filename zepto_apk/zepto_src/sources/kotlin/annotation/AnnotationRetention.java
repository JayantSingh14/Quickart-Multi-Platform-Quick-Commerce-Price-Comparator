package kotlin.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class AnnotationRetention {

    /* renamed from: a, reason: collision with root package name */
    public static final AnnotationRetention f53576a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AnnotationRetention[] f53577b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53578c;

    static {
        AnnotationRetention annotationRetention = new AnnotationRetention("SOURCE", 0);
        AnnotationRetention annotationRetention2 = new AnnotationRetention("BINARY", 1);
        AnnotationRetention annotationRetention3 = new AnnotationRetention("RUNTIME", 2);
        f53576a = annotationRetention3;
        AnnotationRetention[] annotationRetentionArr = {annotationRetention, annotationRetention2, annotationRetention3};
        f53577b = annotationRetentionArr;
        f53578c = EnumEntriesKt.a(annotationRetentionArr);
    }

    public static AnnotationRetention valueOf(String str) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, str);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) f53577b.clone();
    }
}
