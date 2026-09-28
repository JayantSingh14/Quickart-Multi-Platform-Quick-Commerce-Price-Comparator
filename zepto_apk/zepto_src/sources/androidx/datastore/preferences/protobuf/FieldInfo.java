package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: androidx.datastore.preferences.protobuf.FieldInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3977a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f3977a = iArr;
            try {
                iArr[FieldType.f3985b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3977a[FieldType.f3986c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3977a[FieldType.f3987d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3977a[FieldType.f3990g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class Builder {
    }

    @Override // java.lang.Comparable
    public final int compareTo(FieldInfo fieldInfo) {
        fieldInfo.getClass();
        return 0;
    }
}
