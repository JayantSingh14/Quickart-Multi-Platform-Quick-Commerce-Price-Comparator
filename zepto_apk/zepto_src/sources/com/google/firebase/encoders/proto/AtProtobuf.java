package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes4.dex */
public final class AtProtobuf {

    /* renamed from: a, reason: collision with root package name */
    public int f44515a;

    public static final class ProtobufImpl implements Protobuf {

        /* renamed from: b, reason: collision with root package name */
        public final int f44516b;

        public ProtobufImpl(int i2) {
            this.f44516b = i2;
        }

        @Override // java.lang.annotation.Annotation
        public final Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.f44516b == protobuf.tag() && Protobuf.IntEncoding.f44518a.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public final int hashCode() {
            return (14552422 ^ this.f44516b) + (Protobuf.IntEncoding.f44518a.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final Protobuf.IntEncoding intEncoding() {
            return Protobuf.IntEncoding.f44518a;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final int tag() {
            return this.f44516b;
        }

        @Override // java.lang.annotation.Annotation
        public final String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f44516b + "intEncoding=" + Protobuf.IntEncoding.f44518a + ')';
        }
    }

    public final Protobuf a() {
        return new ProtobufImpl(this.f44515a);
    }
}
