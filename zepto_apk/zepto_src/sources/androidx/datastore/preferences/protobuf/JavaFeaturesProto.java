package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;

/* loaded from: classes3.dex */
public final class JavaFeaturesProto {

    /* renamed from: androidx.datastore.preferences.protobuf.JavaFeaturesProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4038a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f4038a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4038a[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4038a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4038a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4038a[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4038a[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4038a[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class JavaFeatures extends GeneratedMessageLite<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private static volatile Parser<JavaFeatures> PARSER = null;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean legacyClosedEnum_;
        private int utf8Validation_;

        public static final class Builder extends GeneratedMessageLite.Builder<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
        }

        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f4043a;

            /* renamed from: androidx.datastore.preferences.protobuf.JavaFeaturesProto$JavaFeatures$Utf8Validation$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<Utf8Validation> {
            }

            public static final class Utf8ValidationVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f4044a = new Utf8ValidationVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : Utf8Validation.VERIFY : Utf8Validation.DEFAULT : Utf8Validation.UTF8_VALIDATION_UNKNOWN) != null;
                }
            }

            Utf8Validation(int i2) {
                this.f4043a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f4043a;
            }
        }

        static {
            JavaFeatures javaFeatures = new JavaFeatures();
            DEFAULT_INSTANCE = javaFeatures;
            GeneratedMessageLite.w(JavaFeatures.class, javaFeatures);
        }

        public static JavaFeatures y() {
            return DEFAULT_INSTANCE;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return (byte) 1;
                case 1:
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001", new Object[]{"bitField0_", "legacyClosedEnum_", "utf8Validation_", Utf8Validation.Utf8ValidationVerifier.f4044a});
                case 3:
                    return new JavaFeatures();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<JavaFeatures> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (JavaFeatures.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser();
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return defaultInstanceBasedParser;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public interface JavaFeaturesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        new GeneratedMessageLite.GeneratedExtension(DescriptorProtos.FeatureSet.y(), JavaFeatures.y(), JavaFeatures.y(), new GeneratedMessageLite.ExtensionDescriptor(WireFormat.FieldType.f4204m));
    }
}
