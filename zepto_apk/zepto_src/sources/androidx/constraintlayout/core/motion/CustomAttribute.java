package androidx.constraintlayout.core.motion;

/* loaded from: classes3.dex */
public class CustomAttribute {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AttributeType {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AttributeType[] f1778a = {new AttributeType("INT_TYPE", 0), new AttributeType("FLOAT_TYPE", 1), new AttributeType("COLOR_TYPE", 2), new AttributeType("COLOR_DRAWABLE_TYPE", 3), new AttributeType("STRING_TYPE", 4), new AttributeType("BOOLEAN_TYPE", 5), new AttributeType("DIMENSION_TYPE", 6), new AttributeType("REFERENCE_TYPE", 7)};

        /* JADX INFO: Fake field, exist only in values array */
        AttributeType EF5;

        public static AttributeType valueOf(String str) {
            return (AttributeType) Enum.valueOf(AttributeType.class, str);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f1778a.clone();
        }
    }
}
