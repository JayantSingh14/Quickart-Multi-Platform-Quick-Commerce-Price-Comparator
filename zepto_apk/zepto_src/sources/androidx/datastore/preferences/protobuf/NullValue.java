package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* loaded from: classes3.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4106a;

    /* renamed from: androidx.datastore.preferences.protobuf.NullValue$1, reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<NullValue> {
    }

    public static final class NullValueVerifier implements Internal.EnumVerifier {
        @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
        public final boolean a(int i2) {
            return (i2 != 0 ? null : NullValue.NULL_VALUE) != null;
        }
    }

    NullValue(int i2) {
        this.f4106a = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
    public final int f() {
        if (this != UNRECOGNIZED) {
            return this.f4106a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
