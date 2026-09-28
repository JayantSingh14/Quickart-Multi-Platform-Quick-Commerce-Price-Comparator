package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Method from annotation default annotation not found: attributeId */
/* JADX WARN: Method from annotation default annotation not found: enumMapping */
/* JADX WARN: Method from annotation default annotation not found: flagMapping */
/* JADX WARN: Method from annotation default annotation not found: hasAttributeId */
/* JADX WARN: Method from annotation default annotation not found: name */
/* JADX WARN: Method from annotation default annotation not found: valueType */
@Target({ElementType.METHOD})
@Metadata
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface InspectableProperty {

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface EnumEntry {
    }

    /* JADX WARN: Method from annotation default annotation not found: mask */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface FlagEntry {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class ValueType {

        /* renamed from: a, reason: collision with root package name */
        public static final ValueType f234a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ValueType[] f235b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f236c;

        static {
            ValueType valueType = new ValueType("NONE", 0);
            ValueType valueType2 = new ValueType("INFERRED", 1);
            f234a = valueType2;
            ValueType[] valueTypeArr = {valueType, valueType2, new ValueType("INT_ENUM", 2), new ValueType("INT_FLAG", 3), new ValueType("COLOR", 4), new ValueType("GRAVITY", 5), new ValueType("RESOURCE_ID", 6)};
            f235b = valueTypeArr;
            f236c = EnumEntriesKt.a(valueTypeArr);
        }

        public static ValueType valueOf(String str) {
            return (ValueType) Enum.valueOf(ValueType.class, str);
        }

        public static ValueType[] values() {
            return (ValueType[]) f235b.clone();
        }
    }
}
