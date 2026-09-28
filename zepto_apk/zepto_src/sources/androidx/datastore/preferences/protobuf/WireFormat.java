package androidx.datastore.preferences.protobuf;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class WireFormat {

    /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4193a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f4193a = iArr;
            try {
                iArr[FieldType.f4194c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4193a[FieldType.f4195d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4193a[FieldType.f4196e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4193a[FieldType.f4197f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4193a[FieldType.f4198g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4193a[FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4193a[FieldType.f4200i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4193a[FieldType.f4201j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4193a[FieldType.n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4193a[FieldType.o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4193a[FieldType.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4193a[FieldType.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4193a[FieldType.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4193a[FieldType.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4193a[FieldType.f4202k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4193a[FieldType.f4203l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4193a[FieldType.f4204m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4193a[FieldType.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class FieldType {

        /* renamed from: c, reason: collision with root package name */
        public static final FieldType f4194c;

        /* renamed from: d, reason: collision with root package name */
        public static final FieldType f4195d;

        /* renamed from: e, reason: collision with root package name */
        public static final FieldType f4196e;

        /* renamed from: f, reason: collision with root package name */
        public static final FieldType f4197f;

        /* renamed from: g, reason: collision with root package name */
        public static final FieldType f4198g;

        /* renamed from: h, reason: collision with root package name */
        public static final FieldType f4199h;

        /* renamed from: i, reason: collision with root package name */
        public static final FieldType f4200i;

        /* renamed from: j, reason: collision with root package name */
        public static final FieldType f4201j;

        /* renamed from: k, reason: collision with root package name */
        public static final FieldType f4202k;

        /* renamed from: l, reason: collision with root package name */
        public static final FieldType f4203l;

        /* renamed from: m, reason: collision with root package name */
        public static final FieldType f4204m;
        public static final FieldType n;
        public static final FieldType o;
        public static final FieldType p;
        public static final FieldType q;
        public static final FieldType r;
        public static final FieldType s;
        public static final FieldType t;
        public static final /* synthetic */ FieldType[] u;

        /* renamed from: a, reason: collision with root package name */
        public final JavaType f4205a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4206b;

        /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$FieldType$1, reason: invalid class name */
        public enum AnonymousClass1 extends FieldType {
        }

        /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$FieldType$2, reason: invalid class name */
        public enum AnonymousClass2 extends FieldType {
        }

        /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$FieldType$3, reason: invalid class name */
        public enum AnonymousClass3 extends FieldType {
        }

        /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$FieldType$4, reason: invalid class name */
        public enum AnonymousClass4 extends FieldType {
        }

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            f4194c = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            f4195d = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            f4196e = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            f4197f = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            f4198g = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            f4199h = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            f4200i = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            f4201j = fieldType8;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("STRING", 8, JavaType.STRING, 2);
            f4202k = anonymousClass1;
            JavaType javaType3 = JavaType.MESSAGE;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("GROUP", 9, javaType3, 3);
            f4203l = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(MerchantConstants.MESSAGE, 10, javaType3, 2);
            f4204m = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4("BYTES", 11, JavaType.BYTE_STRING, 2);
            n = anonymousClass4;
            FieldType fieldType9 = new FieldType("UINT32", 12, javaType2, 0);
            o = fieldType9;
            FieldType fieldType10 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            p = fieldType10;
            FieldType fieldType11 = new FieldType("SFIXED32", 14, javaType2, 5);
            q = fieldType11;
            FieldType fieldType12 = new FieldType("SFIXED64", 15, javaType, 1);
            r = fieldType12;
            FieldType fieldType13 = new FieldType("SINT32", 16, javaType2, 0);
            s = fieldType13;
            FieldType fieldType14 = new FieldType("SINT64", 17, javaType, 0);
            t = fieldType14;
            u = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14};
        }

        public FieldType(String str, int i2, JavaType javaType, int i3) {
            this.f4205a = javaType;
            this.f4206b = i3;
        }

        public static FieldType valueOf(String str) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) u.clone();
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f3748b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a, reason: collision with root package name */
        public final Serializable f4217a;

        JavaType(Serializable serializable) {
            this.f4217a = serializable;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Utf8Validation {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Utf8Validation[] f4218a = {new Utf8Validation() { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.1
        }, new Utf8Validation() { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.2
        }, new Utf8Validation() { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.3
        }};

        /* JADX INFO: Fake field, exist only in values array */
        Utf8Validation EF2;

        public static Utf8Validation valueOf(String str) {
            return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, str);
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) f4218a.clone();
        }
    }
}
