package androidx.emoji2.text.flatbuffer;

/* loaded from: classes3.dex */
public class FlexBuffers {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayReadWriteBuf f4368a;

    public static class Blob extends Sized {

        /* renamed from: e, reason: collision with root package name */
        public static final Blob f4369e = new Blob(FlexBuffers.f4368a, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder a(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.f4373a.a(this.f4374b, this.f4382d));
            sb.append('\"');
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final String toString() {
            return this.f4373a.a(this.f4374b, this.f4382d);
        }
    }

    public static class FlexBufferException extends RuntimeException {
    }

    public static class Key extends Object {

        /* renamed from: d, reason: collision with root package name */
        public static final Key f4370d = new Key(FlexBuffers.f4368a, 0, 0);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder a(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        public final boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.f4374b == this.f4374b && key.f4375c == this.f4375c;
        }

        public final int hashCode() {
            return this.f4374b ^ this.f4375c;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final String toString() {
            int i2 = this.f4374b;
            int i3 = i2;
            while (true) {
                ReadBuf readBuf = this.f4373a;
                if (readBuf.get(i3) == 0) {
                    return readBuf.a(i2, i3 - i2);
                }
                i3++;
            }
        }
    }

    public static class KeyVector {

        /* renamed from: a, reason: collision with root package name */
        public final TypedVector f4371a;

        public KeyVector(TypedVector typedVector) {
            this.f4371a = typedVector;
        }

        public final String toString() throws NumberFormatException {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int i2 = 0;
            while (true) {
                TypedVector typedVector = this.f4371a;
                int i3 = typedVector.f4382d;
                if (i2 >= i3) {
                    sb.append("]");
                    return sb.toString();
                }
                typedVector.b(i2).d(sb);
                if (i2 != i3 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
        }
    }

    public static class Map extends Vector {

        /* renamed from: f, reason: collision with root package name */
        public static final Map f4372f = new Map(FlexBuffers.f4368a, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder a(StringBuilder sb) {
            Key key;
            sb.append("{ ");
            int i2 = this.f4375c;
            int i3 = this.f4374b;
            int i4 = i3 - (i2 * 3);
            ReadBuf readBuf = this.f4373a;
            KeyVector keyVector = new KeyVector(new TypedVector(readBuf, FlexBuffers.a(readBuf, i4, i2), (int) FlexBuffers.c(readBuf, i4 + i2, i2), 4));
            Vector vector = new Vector(readBuf, i3, i2);
            int i5 = 0;
            while (true) {
                int i6 = this.f4382d;
                if (i5 >= i6) {
                    sb.append(" }");
                    return sb;
                }
                sb.append('\"');
                TypedVector typedVector = keyVector.f4371a;
                if (i5 >= typedVector.f4382d) {
                    key = Key.f4370d;
                } else {
                    int i7 = typedVector.f4374b;
                    int i8 = typedVector.f4375c;
                    ReadBuf readBuf2 = typedVector.f4373a;
                    key = new Key(readBuf2, FlexBuffers.a(readBuf2, (i5 * i8) + i7, i8), 1);
                }
                sb.append(key.toString());
                sb.append("\" : ");
                sb.append(vector.b(i5).toString());
                if (i5 != i6 - 1) {
                    sb.append(", ");
                }
                i5++;
            }
        }
    }

    public static abstract class Object {

        /* renamed from: a, reason: collision with root package name */
        public final ReadBuf f4373a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4374b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4375c;

        public Object(ReadBuf readBuf, int i2, int i3) {
            this.f4373a = readBuf;
            this.f4374b = i2;
            this.f4375c = i3;
        }

        public abstract StringBuilder a(StringBuilder sb);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class Reference {

        /* renamed from: f, reason: collision with root package name */
        public static final Reference f4376f = new Reference(FlexBuffers.f4368a, 0, 1, 0);

        /* renamed from: a, reason: collision with root package name */
        public final ReadBuf f4377a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4378b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4379c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4380d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4381e;

        public Reference(ReadBuf readBuf, int i2, int i3, int i4) {
            this(readBuf, i2, i3, 1 << (i4 & 3), i4 >> 2);
        }

        public final String a() {
            int i2 = this.f4381e;
            boolean z = i2 == 5;
            int i3 = this.f4380d;
            int i4 = this.f4378b;
            ReadBuf readBuf = this.f4377a;
            if (z) {
                int iA = FlexBuffers.a(readBuf, i4, this.f4379c);
                return readBuf.a(iA, (int) FlexBuffers.d(readBuf, iA - i3, i3));
            }
            if (i2 != 4) {
                return "";
            }
            int iA2 = FlexBuffers.a(readBuf, i4, i3);
            int i5 = iA2;
            while (readBuf.get(i5) != 0) {
                i5++;
            }
            return readBuf.a(iA2, i5 - iA2);
        }

        public final long b() {
            int i2 = this.f4378b;
            ReadBuf readBuf = this.f4377a;
            int i3 = this.f4379c;
            int i4 = this.f4381e;
            if (i4 == 2) {
                return FlexBuffers.d(readBuf, i2, i3);
            }
            if (i4 == 1) {
                return FlexBuffers.c(readBuf, i2, i3);
            }
            if (i4 == 3) {
                return (long) FlexBuffers.b(readBuf, i2, i3);
            }
            if (i4 == 10) {
                return c().f4382d;
            }
            if (i4 == 26) {
                return (int) FlexBuffers.c(readBuf, i2, i3);
            }
            if (i4 == 5) {
                return Long.parseLong(a());
            }
            int i5 = this.f4380d;
            if (i4 == 6) {
                return FlexBuffers.c(readBuf, FlexBuffers.a(readBuf, i2, i3), i5);
            }
            if (i4 == 7) {
                return FlexBuffers.d(readBuf, FlexBuffers.a(readBuf, i2, i3), i5);
            }
            if (i4 != 8) {
                return 0L;
            }
            return (long) FlexBuffers.b(readBuf, FlexBuffers.a(readBuf, i2, i3), i3);
        }

        public final Vector c() {
            int i2 = this.f4381e;
            int i3 = this.f4380d;
            int i4 = this.f4379c;
            int i5 = this.f4378b;
            ReadBuf readBuf = this.f4377a;
            return (i2 == 10 || i2 == 9) ? new Vector(readBuf, FlexBuffers.a(readBuf, i5, i4), i3) : i2 == 15 ? new TypedVector(readBuf, FlexBuffers.a(readBuf, i5, i4), i3, 4) : ((i2 < 11 || i2 > 15) && i2 != 36) ? Vector.f4384e : new TypedVector(readBuf, FlexBuffers.a(readBuf, i5, i4), i3, i2 - 10);
        }

        public final StringBuilder d(StringBuilder sb) throws NumberFormatException {
            long jD;
            double dB;
            int iC;
            long jC;
            int i2;
            double dB2;
            long jD2;
            int i3 = this.f4381e;
            if (i3 != 36) {
                int i4 = this.f4380d;
                int i5 = this.f4379c;
                int i6 = this.f4378b;
                ReadBuf readBuf = this.f4377a;
                boolean z = true;
                switch (i3) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        if (i3 == 1) {
                            jD = FlexBuffers.c(readBuf, i6, i5);
                        } else if (i3 != 2) {
                            if (i3 == 3) {
                                dB = FlexBuffers.b(readBuf, i6, i5);
                            } else if (i3 == 5) {
                                try {
                                    jD = Long.parseLong(a());
                                } catch (NumberFormatException unused) {
                                }
                            } else if (i3 == 6) {
                                jD = FlexBuffers.c(readBuf, FlexBuffers.a(readBuf, i6, i5), i4);
                            } else if (i3 == 7) {
                                jD = FlexBuffers.d(readBuf, FlexBuffers.a(readBuf, i6, i5), i5);
                            } else if (i3 != 8) {
                                if (i3 != 10) {
                                    if (i3 == 26) {
                                        iC = (int) FlexBuffers.c(readBuf, i6, i5);
                                    }
                                    jD = 0;
                                } else {
                                    iC = c().f4382d;
                                }
                                jD = iC;
                            } else {
                                dB = FlexBuffers.b(readBuf, FlexBuffers.a(readBuf, i6, i5), i4);
                            }
                            jD = (long) dB;
                        } else {
                            jD = FlexBuffers.d(readBuf, i6, i5);
                        }
                        sb.append(jD);
                        return sb;
                    case 2:
                    case 7:
                        sb.append(b());
                        return sb;
                    case 3:
                    case 8:
                        if (i3 == 3) {
                            dB2 = FlexBuffers.b(readBuf, i6, i5);
                        } else {
                            if (i3 == 1) {
                                jC = FlexBuffers.c(readBuf, i6, i5);
                            } else if (i3 == 2) {
                                jD2 = FlexBuffers.d(readBuf, i6, i5);
                                dB2 = jD2;
                            } else if (i3 == 5) {
                                dB2 = Double.parseDouble(a());
                            } else if (i3 == 6) {
                                jC = FlexBuffers.c(readBuf, FlexBuffers.a(readBuf, i6, i5), i4);
                            } else if (i3 == 7) {
                                jD2 = FlexBuffers.d(readBuf, FlexBuffers.a(readBuf, i6, i5), i4);
                                dB2 = jD2;
                            } else if (i3 == 8) {
                                dB2 = FlexBuffers.b(readBuf, FlexBuffers.a(readBuf, i6, i5), i4);
                            } else if (i3 != 10) {
                                if (i3 != 26) {
                                    dB2 = 0.0d;
                                }
                                jD2 = FlexBuffers.d(readBuf, i6, i5);
                                dB2 = jD2;
                            } else {
                                i2 = c().f4382d;
                                dB2 = i2;
                            }
                            i2 = (int) jC;
                            dB2 = i2;
                        }
                        sb.append(dB2);
                        return sb;
                    case 4:
                        Key key = i3 == 4 ? new Key(readBuf, FlexBuffers.a(readBuf, i6, i5), i4) : Key.f4370d;
                        sb.append('\"');
                        key.a(sb);
                        sb.append('\"');
                        return sb;
                    case 5:
                        sb.append('\"');
                        sb.append(a());
                        sb.append('\"');
                        return sb;
                    case 9:
                        (i3 == 9 ? new Map(readBuf, FlexBuffers.a(readBuf, i6, i5), i4) : Map.f4372f).a(sb);
                        return sb;
                    case 10:
                        c().a(sb);
                        return sb;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException(android.support.v4.media.b.f(i3, "not_implemented:"));
                    case 25:
                        ((i3 == 25 || i3 == 5) ? new Blob(readBuf, FlexBuffers.a(readBuf, i6, i5), i4) : Blob.f4369e).a(sb);
                        return sb;
                    case 26:
                        if (i3 != 26 ? b() == 0 : readBuf.get(i6) == 0) {
                            z = false;
                        }
                        sb.append(z);
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(c());
            return sb;
        }

        public final String toString() throws NumberFormatException {
            StringBuilder sb = new StringBuilder(128);
            d(sb);
            return sb.toString();
        }

        public Reference(ReadBuf readBuf, int i2, int i3, int i4, int i5) {
            this.f4377a = readBuf;
            this.f4378b = i2;
            this.f4379c = i3;
            this.f4380d = i4;
            this.f4381e = i5;
        }
    }

    public static abstract class Sized extends Object {

        /* renamed from: d, reason: collision with root package name */
        public final int f4382d;

        public Sized(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
            this.f4382d = (int) FlexBuffers.c(readBuf, i2 - i3, i3);
        }
    }

    public static class TypedVector extends Vector {

        /* renamed from: f, reason: collision with root package name */
        public final int f4383f;

        static {
            new TypedVector(FlexBuffers.f4368a, 1, 1, 1);
        }

        public TypedVector(ReadBuf readBuf, int i2, int i3, int i4) {
            super(readBuf, i2, i3);
            this.f4383f = i4;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public final Reference b(int i2) {
            if (i2 >= this.f4382d) {
                return Reference.f4376f;
            }
            return new Reference(this.f4373a, (i2 * this.f4375c) + this.f4374b, this.f4375c, 1, this.f4383f);
        }
    }

    public static class Unsigned {
    }

    public static class Vector extends Sized {

        /* renamed from: e, reason: collision with root package name */
        public static final Vector f4384e = new Vector(FlexBuffers.f4368a, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder a(StringBuilder sb) {
            sb.append("[ ");
            int i2 = 0;
            while (true) {
                int i3 = this.f4382d;
                if (i2 >= i3) {
                    sb.append(" ]");
                    return sb;
                }
                b(i2).d(sb);
                if (i2 != i3 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
        }

        public Reference b(int i2) {
            long j2 = this.f4382d;
            long j3 = i2;
            if (j3 >= j2) {
                return Reference.f4376f;
            }
            int i3 = this.f4374b;
            int i4 = this.f4375c;
            long j4 = j2 * i4;
            ReadBuf readBuf = this.f4373a;
            return new Reference(readBuf, (i2 * i4) + i3, i4, readBuf.get((int) (j4 + i3 + j3)) & 255);
        }
    }

    static {
        ArrayReadWriteBuf arrayReadWriteBuf = new ArrayReadWriteBuf();
        arrayReadWriteBuf.f4366a = new byte[]{0};
        f4368a = arrayReadWriteBuf;
    }

    public static int a(ReadBuf readBuf, int i2, int i3) {
        return (int) (i2 - d(readBuf, i2, i3));
    }

    public static double b(ReadBuf readBuf, int i2, int i3) {
        if (i3 == 4) {
            return readBuf.getFloat(i2);
        }
        if (i3 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i2);
    }

    public static long c(ReadBuf readBuf, int i2, int i3) {
        int i4;
        if (i3 == 1) {
            i4 = readBuf.get(i2);
        } else if (i3 == 2) {
            i4 = readBuf.getShort(i2);
        } else {
            if (i3 != 4) {
                if (i3 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i2);
            }
            i4 = readBuf.getInt(i2);
        }
        return i4;
    }

    public static long d(ReadBuf readBuf, int i2, int i3) {
        if (i3 == 1) {
            return readBuf.get(i2) & 255;
        }
        if (i3 == 2) {
            return readBuf.getShort(i2) & 65535;
        }
        if (i3 == 4) {
            return readBuf.getInt(i2) & 4294967295L;
        }
        if (i3 != 8) {
            return -1L;
        }
        return readBuf.getLong(i2);
    }
}
