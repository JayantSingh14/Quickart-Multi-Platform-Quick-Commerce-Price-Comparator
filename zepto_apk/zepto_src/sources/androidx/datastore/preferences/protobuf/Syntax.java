package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* loaded from: classes3.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4169a;

    /* renamed from: androidx.datastore.preferences.protobuf.Syntax$1, reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<Syntax> {
    }

    public static final class SyntaxVerifier implements Internal.EnumVerifier {
        @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
        public final boolean a(int i2) {
            return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : Syntax.SYNTAX_EDITIONS : Syntax.SYNTAX_PROTO3 : Syntax.SYNTAX_PROTO2) != null;
        }
    }

    Syntax(int i2) {
        this.f4169a = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
    public final int f() {
        if (this != UNRECOGNIZED) {
            return this.f4169a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
