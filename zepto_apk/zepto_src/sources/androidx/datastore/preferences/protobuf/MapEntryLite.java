package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

/* loaded from: classes3.dex */
public class MapEntryLite<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final Metadata f4071a;

    /* renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4072a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f4072a = iArr;
            try {
                iArr[WireFormat.FieldType.f4204m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4072a[WireFormat.FieldType.p.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4072a[WireFormat.FieldType.f4203l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Metadata<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f4073a;

        /* renamed from: b, reason: collision with root package name */
        public final WireFormat.FieldType f4074b;

        /* renamed from: c, reason: collision with root package name */
        public final GeneratedMessageLite f4075c;

        public Metadata(WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2, GeneratedMessageLite generatedMessageLite) {
            this.f4073a = fieldType;
            this.f4074b = fieldType2;
            this.f4075c = generatedMessageLite;
        }
    }

    public MapEntryLite(WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2, GeneratedMessageLite generatedMessageLite) {
        this.f4071a = new Metadata(fieldType, fieldType2, generatedMessageLite);
    }

    public static int a(Metadata metadata, Object obj, Object obj2) {
        return FieldSet.b(metadata.f4073a, 1, obj) + FieldSet.b(metadata.f4074b, 2, obj2);
    }

    public static void b(CodedOutputStream codedOutputStream, Metadata metadata, Object obj, Object obj2) {
        FieldSet.n(codedOutputStream, metadata.f4073a, 1, obj);
        FieldSet.n(codedOutputStream, metadata.f4074b, 2, obj2);
    }
}
