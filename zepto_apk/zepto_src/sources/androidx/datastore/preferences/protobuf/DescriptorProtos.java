package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public final class DescriptorProtos {

    /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3814a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f3814a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3814a[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3814a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3814a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3814a[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3814a[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3814a[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        private static final DescriptorProto DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private Internal.ProtobufList<EnumDescriptorProto> enumType_;
        private Internal.ProtobufList<ExtensionRange> extensionRange_;
        private Internal.ProtobufList<FieldDescriptorProto> extension_;
        private Internal.ProtobufList<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<DescriptorProto> nestedType_;
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_;
        private MessageOptions options_;
        private Internal.ProtobufList<String> reservedName_;
        private Internal.ProtobufList<ReservedRange> reservedRange_;

        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        }

        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private static final ExtensionRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = 2;
            private ExtensionRangeOptions options_;
            private int start_;

            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            }

            static {
                ExtensionRange extensionRange = new ExtensionRange();
                DEFAULT_INSTANCE = extensionRange;
                GeneratedMessageLite.w(ExtensionRange.class, extensionRange);
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
                Parser defaultInstanceBasedParser;
                switch (methodToInvoke.ordinal()) {
                    case 0:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 1:
                        this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                        return null;
                    case 2:
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                    case 3:
                        return new ExtensionRange();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<ExtensionRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ExtensionRange.class) {
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

        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private static final ReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            }

            static {
                ReservedRange reservedRange = new ReservedRange();
                DEFAULT_INSTANCE = reservedRange;
                GeneratedMessageLite.w(ReservedRange.class, reservedRange);
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 3:
                        return new ReservedRange();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<ReservedRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ReservedRange.class) {
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

        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            DescriptorProto descriptorProto = new DescriptorProto();
            DEFAULT_INSTANCE = descriptorProto;
            GeneratedMessageLite.w(DescriptorProto.class, descriptorProto);
        }

        public DescriptorProto() {
            ProtobufArrayList protobufArrayList = ProtobufArrayList.f4115d;
            this.field_ = protobufArrayList;
            this.extension_ = protobufArrayList;
            this.nestedType_ = protobufArrayList;
            this.enumType_ = protobufArrayList;
            this.extensionRange_ = protobufArrayList;
            this.oneofDecl_ = protobufArrayList;
            this.reservedRange_ = protobufArrayList;
            this.reservedName_ = protobufArrayList;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", FieldDescriptorProto.class, "nestedType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", FieldDescriptorProto.class, "options_", "oneofDecl_", OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_"});
                case 3:
                    return new DescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<DescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DescriptorProto.class) {
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

    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public enum Edition implements Internal.EnumLite {
        EDITION_UNKNOWN(0),
        EDITION_LEGACY(900),
        EDITION_PROTO2(998),
        EDITION_PROTO3(999),
        EDITION_2023(1000),
        EDITION_2024(DateUtils.SEMI_MONTH),
        EDITION_1_TEST_ONLY(1),
        EDITION_2_TEST_ONLY(2),
        EDITION_99997_TEST_ONLY(99997),
        EDITION_99998_TEST_ONLY(99998),
        EDITION_99999_TEST_ONLY(99999),
        EDITION_MAX(Api.BaseClientBuilder.API_PRIORITY_OTHER);


        /* renamed from: a, reason: collision with root package name */
        public final int f3827a;

        /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$Edition$1, reason: invalid class name */
        public class AnonymousClass1 implements Internal.EnumLiteMap<Edition> {
        }

        public static final class EditionVerifier implements Internal.EnumVerifier {

            /* renamed from: a, reason: collision with root package name */
            public static final Internal.EnumVerifier f3828a = new EditionVerifier();

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
            public final boolean a(int i2) {
                Edition edition;
                if (i2 == 0) {
                    edition = Edition.EDITION_UNKNOWN;
                } else if (i2 == 1) {
                    edition = Edition.EDITION_1_TEST_ONLY;
                } else if (i2 == 2) {
                    edition = Edition.EDITION_2_TEST_ONLY;
                } else if (i2 == 900) {
                    edition = Edition.EDITION_LEGACY;
                } else if (i2 != Integer.MAX_VALUE) {
                    switch (i2) {
                        case 998:
                            edition = Edition.EDITION_PROTO2;
                            break;
                        case 999:
                            edition = Edition.EDITION_PROTO3;
                            break;
                        case 1000:
                            edition = Edition.EDITION_2023;
                            break;
                        case DateUtils.SEMI_MONTH /* 1001 */:
                            edition = Edition.EDITION_2024;
                            break;
                        default:
                            switch (i2) {
                                case 99997:
                                    edition = Edition.EDITION_99997_TEST_ONLY;
                                    break;
                                case 99998:
                                    edition = Edition.EDITION_99998_TEST_ONLY;
                                    break;
                                case 99999:
                                    edition = Edition.EDITION_99999_TEST_ONLY;
                                    break;
                                default:
                                    edition = null;
                                    break;
                            }
                    }
                } else {
                    edition = Edition.EDITION_MAX;
                }
                return edition != null;
            }
        }

        Edition(int i2) {
            this.f3827a = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
        public final int f() {
            return this.f3827a;
        }
    }

    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        private static final EnumDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private EnumOptions options_;
        private Internal.ProtobufList<String> reservedName_;
        private Internal.ProtobufList<EnumReservedRange> reservedRange_;
        private Internal.ProtobufList<EnumValueDescriptorProto> value_;

        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        }

        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            private static final EnumReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            }

            static {
                EnumReservedRange enumReservedRange = new EnumReservedRange();
                DEFAULT_INSTANCE = enumReservedRange;
                GeneratedMessageLite.w(EnumReservedRange.class, enumReservedRange);
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 3:
                        return new EnumReservedRange();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<EnumReservedRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EnumReservedRange.class) {
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

        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            DEFAULT_INSTANCE = enumDescriptorProto;
            GeneratedMessageLite.w(EnumDescriptorProto.class, enumDescriptorProto);
        }

        public EnumDescriptorProto() {
            ProtobufArrayList protobufArrayList = ProtobufArrayList.f4115d;
            this.value_ = protobufArrayList;
            this.reservedRange_ = protobufArrayList;
            this.reservedName_ = protobufArrayList;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_"});
                case 3:
                    return new EnumDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<EnumDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumDescriptorProto.class) {
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

    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        private static final EnumOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 6;
        public static final int FEATURES_FIELD_NUMBER = 7;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecatedLegacyJsonFieldConflicts_;
        private boolean deprecated_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        }

        static {
            EnumOptions enumOptions = new EnumOptions();
            DEFAULT_INSTANCE = enumOptions;
            GeneratedMessageLite.w(EnumOptions.class, enumOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0002ϧ\u0005\u0000\u0001\u0002\u0002ဇ\u0000\u0003ဇ\u0001\u0006ဇ\u0002\u0007ᐉ\u0003ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new EnumOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<EnumOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumOptions.class) {
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

    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        }

        static {
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            DEFAULT_INSTANCE = enumValueDescriptorProto;
            GeneratedMessageLite.w(EnumValueDescriptorProto.class, enumValueDescriptorProto);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
                case 3:
                    return new EnumValueDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<EnumValueDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumValueDescriptorProto.class) {
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

    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        public static final int DEBUG_REDACT_FIELD_NUMBER = 3;
        private static final EnumValueOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        public static final int FEATURES_FIELD_NUMBER = 2;
        public static final int FEATURE_SUPPORT_FIELD_NUMBER = 4;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean debugRedact_;
        private boolean deprecated_;
        private FieldOptions.FeatureSupport featureSupport_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        }

        static {
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            DEFAULT_INSTANCE = enumValueOptions;
            GeneratedMessageLite.w(EnumValueOptions.class, enumValueOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "debugRedact_", "featureSupport_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new EnumValueOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<EnumValueOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumValueOptions.class) {
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

    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
    }

    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        public static final int DECLARATION_FIELD_NUMBER = 2;
        private static final ExtensionRangeOptions DEFAULT_INSTANCE;
        public static final int FEATURES_FIELD_NUMBER = 50;
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int VERIFICATION_FIELD_NUMBER = 3;
        private int bitField0_;
        private Internal.ProtobufList<Declaration> declaration_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_;
        private int verification_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        }

        public static final class Declaration extends GeneratedMessageLite<Declaration, Builder> implements DeclarationOrBuilder {
            private static final Declaration DEFAULT_INSTANCE;
            public static final int FULL_NAME_FIELD_NUMBER = 2;
            public static final int NUMBER_FIELD_NUMBER = 1;
            private static volatile Parser<Declaration> PARSER = null;
            public static final int REPEATED_FIELD_NUMBER = 6;
            public static final int RESERVED_FIELD_NUMBER = 5;
            public static final int TYPE_FIELD_NUMBER = 3;
            private int bitField0_;
            private int number_;
            private boolean repeated_;
            private boolean reserved_;
            private String fullName_ = "";
            private String type_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Declaration, Builder> implements DeclarationOrBuilder {
            }

            static {
                Declaration declaration = new Declaration();
                DEFAULT_INSTANCE = declaration;
                GeneratedMessageLite.w(Declaration.class, declaration);
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"bitField0_", "number_", "fullName_", "type_", "reserved_", "repeated_"});
                    case 3:
                        return new Declaration();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<Declaration> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Declaration.class) {
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

        public interface DeclarationOrBuilder extends MessageLiteOrBuilder {
        }

        public enum VerificationState implements Internal.EnumLite {
            DECLARATION(0),
            UNVERIFIED(1);


            /* renamed from: a, reason: collision with root package name */
            public final int f3832a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$ExtensionRangeOptions$VerificationState$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<VerificationState> {
            }

            public static final class VerificationStateVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3833a = new VerificationStateVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? null : VerificationState.UNVERIFIED : VerificationState.DECLARATION) != null;
                }
            }

            VerificationState(int i2) {
                this.f3832a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3832a;
            }
        }

        static {
            ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions();
            DEFAULT_INSTANCE = extensionRangeOptions;
            GeneratedMessageLite.w(ExtensionRangeOptions.class, extensionRangeOptions);
        }

        public ExtensionRangeOptions() {
            ProtobufArrayList protobufArrayList = ProtobufArrayList.f4115d;
            this.uninterpretedOption_ = protobufArrayList;
            this.declaration_ = protobufArrayList;
            this.verification_ = 1;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0002ϧ\u0004\u0000\u0002\u0002\u0002\u001b\u0003᠌\u00012ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "declaration_", Declaration.class, "verification_", VerificationState.VerificationStateVerifier.f3833a, "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new ExtensionRangeOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<ExtensionRangeOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExtensionRangeOptions.class) {
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

    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
    }

    public static final class FeatureSet extends GeneratedMessageLite.ExtendableMessage<FeatureSet, Builder> implements FeatureSetOrBuilder {
        private static final FeatureSet DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 2;
        public static final int FIELD_PRESENCE_FIELD_NUMBER = 1;
        public static final int JSON_FORMAT_FIELD_NUMBER = 6;
        public static final int MESSAGE_ENCODING_FIELD_NUMBER = 5;
        private static volatile Parser<FeatureSet> PARSER = null;
        public static final int REPEATED_FIELD_ENCODING_FIELD_NUMBER = 3;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 4;
        private int bitField0_;
        private int enumType_;
        private int fieldPresence_;
        private int jsonFormat_;
        private byte memoizedIsInitialized = 2;
        private int messageEncoding_;
        private int repeatedFieldEncoding_;
        private int utf8Validation_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FeatureSet, Builder> implements FeatureSetOrBuilder {
        }

        public enum EnumType implements Internal.EnumLite {
            ENUM_TYPE_UNKNOWN(0),
            OPEN(1),
            CLOSED(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3838a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$EnumType$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<EnumType> {
            }

            public static final class EnumTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3839a = new EnumTypeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : EnumType.CLOSED : EnumType.OPEN : EnumType.ENUM_TYPE_UNKNOWN) != null;
                }
            }

            EnumType(int i2) {
                this.f3838a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3838a;
            }
        }

        public enum FieldPresence implements Internal.EnumLite {
            FIELD_PRESENCE_UNKNOWN(0),
            EXPLICIT(1),
            IMPLICIT(2),
            LEGACY_REQUIRED(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f3845a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$FieldPresence$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<FieldPresence> {
            }

            public static final class FieldPresenceVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3846a = new FieldPresenceVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : FieldPresence.LEGACY_REQUIRED : FieldPresence.IMPLICIT : FieldPresence.EXPLICIT : FieldPresence.FIELD_PRESENCE_UNKNOWN) != null;
                }
            }

            FieldPresence(int i2) {
                this.f3845a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3845a;
            }
        }

        public enum JsonFormat implements Internal.EnumLite {
            JSON_FORMAT_UNKNOWN(0),
            ALLOW(1),
            LEGACY_BEST_EFFORT(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3851a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$JsonFormat$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<JsonFormat> {
            }

            public static final class JsonFormatVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3852a = new JsonFormatVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : JsonFormat.LEGACY_BEST_EFFORT : JsonFormat.ALLOW : JsonFormat.JSON_FORMAT_UNKNOWN) != null;
                }
            }

            JsonFormat(int i2) {
                this.f3851a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3851a;
            }
        }

        public enum MessageEncoding implements Internal.EnumLite {
            MESSAGE_ENCODING_UNKNOWN(0),
            LENGTH_PREFIXED(1),
            DELIMITED(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3857a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$MessageEncoding$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<MessageEncoding> {
            }

            public static final class MessageEncodingVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3858a = new MessageEncodingVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : MessageEncoding.DELIMITED : MessageEncoding.LENGTH_PREFIXED : MessageEncoding.MESSAGE_ENCODING_UNKNOWN) != null;
                }
            }

            MessageEncoding(int i2) {
                this.f3857a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3857a;
            }
        }

        public enum RepeatedFieldEncoding implements Internal.EnumLite {
            REPEATED_FIELD_ENCODING_UNKNOWN(0),
            PACKED(1),
            EXPANDED(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3863a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$RepeatedFieldEncoding$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<RepeatedFieldEncoding> {
            }

            public static final class RepeatedFieldEncodingVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3864a = new RepeatedFieldEncodingVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : RepeatedFieldEncoding.EXPANDED : RepeatedFieldEncoding.PACKED : RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN) != null;
                }
            }

            RepeatedFieldEncoding(int i2) {
                this.f3863a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3863a;
            }
        }

        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            VERIFY(2),
            NONE(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f3869a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$Utf8Validation$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<Utf8Validation> {
            }

            public static final class Utf8ValidationVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3870a = new Utf8ValidationVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 2 ? i2 != 3 ? null : Utf8Validation.NONE : Utf8Validation.VERIFY : Utf8Validation.UTF8_VALIDATION_UNKNOWN) != null;
                }
            }

            Utf8Validation(int i2) {
                this.f3869a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3869a;
            }
        }

        static {
            FeatureSet featureSet = new FeatureSet();
            DEFAULT_INSTANCE = featureSet;
            GeneratedMessageLite.w(FeatureSet.class, featureSet);
        }

        public static FeatureSet y() {
            return DEFAULT_INSTANCE;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"bitField0_", "fieldPresence_", FieldPresence.FieldPresenceVerifier.f3846a, "enumType_", EnumType.EnumTypeVerifier.f3839a, "repeatedFieldEncoding_", RepeatedFieldEncoding.RepeatedFieldEncodingVerifier.f3864a, "utf8Validation_", Utf8Validation.Utf8ValidationVerifier.f3870a, "messageEncoding_", MessageEncoding.MessageEncodingVerifier.f3858a, "jsonFormat_", JsonFormat.JsonFormatVerifier.f3852a});
                case 3:
                    return new FeatureSet();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FeatureSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FeatureSet.class) {
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

    public static final class FeatureSetDefaults extends GeneratedMessageLite<FeatureSetDefaults, Builder> implements FeatureSetDefaultsOrBuilder {
        public static final int DEFAULTS_FIELD_NUMBER = 1;
        private static final FeatureSetDefaults DEFAULT_INSTANCE;
        public static final int MAXIMUM_EDITION_FIELD_NUMBER = 5;
        public static final int MINIMUM_EDITION_FIELD_NUMBER = 4;
        private static volatile Parser<FeatureSetDefaults> PARSER;
        private int bitField0_;
        private int maximumEdition_;
        private int minimumEdition_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FeatureSetEditionDefault> defaults_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.Builder<FeatureSetDefaults, Builder> implements FeatureSetDefaultsOrBuilder {
        }

        public static final class FeatureSetEditionDefault extends GeneratedMessageLite<FeatureSetEditionDefault, Builder> implements FeatureSetEditionDefaultOrBuilder {
            private static final FeatureSetEditionDefault DEFAULT_INSTANCE;
            public static final int EDITION_FIELD_NUMBER = 3;
            public static final int FIXED_FEATURES_FIELD_NUMBER = 5;
            public static final int OVERRIDABLE_FEATURES_FIELD_NUMBER = 4;
            private static volatile Parser<FeatureSetEditionDefault> PARSER;
            private int bitField0_;
            private int edition_;
            private FeatureSet fixedFeatures_;
            private byte memoizedIsInitialized = 2;
            private FeatureSet overridableFeatures_;

            public static final class Builder extends GeneratedMessageLite.Builder<FeatureSetEditionDefault, Builder> implements FeatureSetEditionDefaultOrBuilder {
            }

            static {
                FeatureSetEditionDefault featureSetEditionDefault = new FeatureSetEditionDefault();
                DEFAULT_INSTANCE = featureSetEditionDefault;
                GeneratedMessageLite.w(FeatureSetEditionDefault.class, featureSetEditionDefault);
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
                Parser defaultInstanceBasedParser;
                switch (methodToInvoke.ordinal()) {
                    case 0:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 1:
                        this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                        return null;
                    case 2:
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0002\u0003᠌\u0000\u0004ᐉ\u0001\u0005ᐉ\u0002", new Object[]{"bitField0_", "edition_", Edition.EditionVerifier.f3828a, "overridableFeatures_", "fixedFeatures_"});
                    case 3:
                        return new FeatureSetEditionDefault();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<FeatureSetEditionDefault> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FeatureSetEditionDefault.class) {
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

        public interface FeatureSetEditionDefaultOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            FeatureSetDefaults featureSetDefaults = new FeatureSetDefaults();
            DEFAULT_INSTANCE = featureSetDefaults;
            GeneratedMessageLite.w(FeatureSetDefaults.class, featureSetDefaults);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    Internal.EnumVerifier enumVerifier = Edition.EditionVerifier.f3828a;
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0001\u0001\u0001Л\u0004᠌\u0000\u0005᠌\u0001", new Object[]{"bitField0_", "defaults_", FeatureSetEditionDefault.class, "minimumEdition_", enumVerifier, "maximumEdition_", enumVerifier});
                case 3:
                    return new FeatureSetDefaults();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FeatureSetDefaults> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FeatureSetDefaults.class) {
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

    public interface FeatureSetDefaultsOrBuilder extends MessageLiteOrBuilder {
    }

    public interface FeatureSetOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FeatureSet, FeatureSet.Builder> {
    }

    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        private static final FieldDescriptorProto DEFAULT_INSTANCE;
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private boolean proto3Optional_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int label_ = 1;
        private int type_ = 1;
        private String typeName_ = "";
        private String extendee_ = "";
        private String defaultValue_ = "";
        private String jsonName_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        }

        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REPEATED(3),
            LABEL_REQUIRED(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3875a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldDescriptorProto$Label$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<Label> {
            }

            public static final class LabelVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3876a = new LabelVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Label.LABEL_REPEATED : Label.LABEL_REQUIRED : Label.LABEL_OPTIONAL) != null;
                }
            }

            Label(int i2) {
                this.f3875a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3875a;
            }
        }

        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);


            /* renamed from: a, reason: collision with root package name */
            public final int f3889a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldDescriptorProto$Type$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<Type> {
            }

            public static final class TypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3890a = new TypeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    Type type;
                    switch (i2) {
                        case 1:
                            type = Type.TYPE_DOUBLE;
                            break;
                        case 2:
                            type = Type.TYPE_FLOAT;
                            break;
                        case 3:
                            type = Type.TYPE_INT64;
                            break;
                        case 4:
                            type = Type.TYPE_UINT64;
                            break;
                        case 5:
                            type = Type.TYPE_INT32;
                            break;
                        case 6:
                            type = Type.TYPE_FIXED64;
                            break;
                        case 7:
                            type = Type.TYPE_FIXED32;
                            break;
                        case 8:
                            type = Type.TYPE_BOOL;
                            break;
                        case 9:
                            type = Type.TYPE_STRING;
                            break;
                        case 10:
                            type = Type.TYPE_GROUP;
                            break;
                        case 11:
                            type = Type.TYPE_MESSAGE;
                            break;
                        case 12:
                            type = Type.TYPE_BYTES;
                            break;
                        case 13:
                            type = Type.TYPE_UINT32;
                            break;
                        case 14:
                            type = Type.TYPE_ENUM;
                            break;
                        case 15:
                            type = Type.TYPE_SFIXED32;
                            break;
                        case 16:
                            type = Type.TYPE_SFIXED64;
                            break;
                        case 17:
                            type = Type.TYPE_SINT32;
                            break;
                        case 18:
                            type = Type.TYPE_SINT64;
                            break;
                        default:
                            type = null;
                            break;
                    }
                    return type != null;
                }
            }

            Type(int i2) {
                this.f3889a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3889a;
            }
        }

        static {
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            DEFAULT_INSTANCE = fieldDescriptorProto;
            GeneratedMessageLite.w(FieldDescriptorProto.class, fieldDescriptorProto);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004᠌\u0002\u0005᠌\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", Label.LabelVerifier.f3876a, "type_", Type.TypeVerifier.f3890a, "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
                case 3:
                    return new FieldDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FieldDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FieldDescriptorProto.class) {
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

    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEBUG_REDACT_FIELD_NUMBER = 16;
        private static final FieldOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int EDITION_DEFAULTS_FIELD_NUMBER = 20;
        public static final int FEATURES_FIELD_NUMBER = 21;
        public static final int FEATURE_SUPPORT_FIELD_NUMBER = 22;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int RETENTION_FIELD_NUMBER = 17;
        public static final int TARGETS_FIELD_NUMBER = 19;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int UNVERIFIED_LAZY_FIELD_NUMBER = 15;
        public static final int WEAK_FIELD_NUMBER = 10;
        private static final Internal.IntListAdapter.IntConverter<OptionTargetType> targets_converter_ = new AnonymousClass1();
        private int bitField0_;
        private int ctype_;
        private boolean debugRedact_;
        private boolean deprecated_;
        private Internal.ProtobufList<EditionDefault> editionDefaults_;
        private FeatureSupport featureSupport_;
        private FeatureSet features_;
        private int jstype_;
        private boolean lazy_;
        private boolean packed_;
        private int retention_;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_;
        private boolean unverifiedLazy_;
        private boolean weak_;
        private byte memoizedIsInitialized = 2;
        private Internal.IntList targets_ = IntArrayList.f4021d;

        /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$1, reason: invalid class name */
        public class AnonymousClass1 implements Internal.IntListAdapter.IntConverter<OptionTargetType> {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        }

        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3895a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$CType$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<CType> {
            }

            public static final class CTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3896a = new CTypeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : CType.STRING_PIECE : CType.CORD : CType.STRING) != null;
                }
            }

            CType(int i2) {
                this.f3895a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3895a;
            }
        }

        public static final class EditionDefault extends GeneratedMessageLite<EditionDefault, Builder> implements EditionDefaultOrBuilder {
            private static final EditionDefault DEFAULT_INSTANCE;
            public static final int EDITION_FIELD_NUMBER = 3;
            private static volatile Parser<EditionDefault> PARSER = null;
            public static final int VALUE_FIELD_NUMBER = 2;
            private int bitField0_;
            private int edition_;
            private String value_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<EditionDefault, Builder> implements EditionDefaultOrBuilder {
            }

            static {
                EditionDefault editionDefault = new EditionDefault();
                DEFAULT_INSTANCE = editionDefault;
                GeneratedMessageLite.w(EditionDefault.class, editionDefault);
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဈ\u0001\u0003᠌\u0000", new Object[]{"bitField0_", "value_", "edition_", Edition.EditionVerifier.f3828a});
                    case 3:
                        return new EditionDefault();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<EditionDefault> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EditionDefault.class) {
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

        public interface EditionDefaultOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class FeatureSupport extends GeneratedMessageLite<FeatureSupport, Builder> implements FeatureSupportOrBuilder {
            private static final FeatureSupport DEFAULT_INSTANCE;
            public static final int DEPRECATION_WARNING_FIELD_NUMBER = 3;
            public static final int EDITION_DEPRECATED_FIELD_NUMBER = 2;
            public static final int EDITION_INTRODUCED_FIELD_NUMBER = 1;
            public static final int EDITION_REMOVED_FIELD_NUMBER = 4;
            private static volatile Parser<FeatureSupport> PARSER;
            private int bitField0_;
            private String deprecationWarning_ = "";
            private int editionDeprecated_;
            private int editionIntroduced_;
            private int editionRemoved_;

            public static final class Builder extends GeneratedMessageLite.Builder<FeatureSupport, Builder> implements FeatureSupportOrBuilder {
            }

            static {
                FeatureSupport featureSupport = new FeatureSupport();
                DEFAULT_INSTANCE = featureSupport;
                GeneratedMessageLite.w(FeatureSupport.class, featureSupport);
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
                        Internal.EnumVerifier enumVerifier = Edition.EditionVerifier.f3828a;
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"bitField0_", "editionIntroduced_", enumVerifier, "editionDeprecated_", enumVerifier, "deprecationWarning_", "editionRemoved_", enumVerifier});
                    case 3:
                        return new FeatureSupport();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<FeatureSupport> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FeatureSupport.class) {
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

        public interface FeatureSupportOrBuilder extends MessageLiteOrBuilder {
        }

        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3901a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$JSType$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<JSType> {
            }

            public static final class JSTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3902a = new JSTypeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : JSType.JS_NUMBER : JSType.JS_STRING : JSType.JS_NORMAL) != null;
                }
            }

            JSType(int i2) {
                this.f3901a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3901a;
            }
        }

        public enum OptionRetention implements Internal.EnumLite {
            RETENTION_UNKNOWN(0),
            RETENTION_RUNTIME(1),
            RETENTION_SOURCE(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3907a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$OptionRetention$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<OptionRetention> {
            }

            public static final class OptionRetentionVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3908a = new OptionRetentionVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : OptionRetention.RETENTION_SOURCE : OptionRetention.RETENTION_RUNTIME : OptionRetention.RETENTION_UNKNOWN) != null;
                }
            }

            OptionRetention(int i2) {
                this.f3907a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3907a;
            }
        }

        public enum OptionTargetType implements Internal.EnumLite {
            TARGET_TYPE_UNKNOWN(0),
            TARGET_TYPE_FILE(1),
            TARGET_TYPE_EXTENSION_RANGE(2),
            TARGET_TYPE_MESSAGE(3),
            TARGET_TYPE_FIELD(4),
            TARGET_TYPE_ONEOF(5),
            TARGET_TYPE_ENUM(6),
            TARGET_TYPE_ENUM_ENTRY(7),
            TARGET_TYPE_SERVICE(8),
            TARGET_TYPE_METHOD(9);


            /* renamed from: a, reason: collision with root package name */
            public final int f3920a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$OptionTargetType$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<OptionTargetType> {
            }

            public static final class OptionTargetTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3921a = new OptionTargetTypeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    OptionTargetType optionTargetType;
                    switch (i2) {
                        case 0:
                            optionTargetType = OptionTargetType.TARGET_TYPE_UNKNOWN;
                            break;
                        case 1:
                            optionTargetType = OptionTargetType.TARGET_TYPE_FILE;
                            break;
                        case 2:
                            optionTargetType = OptionTargetType.TARGET_TYPE_EXTENSION_RANGE;
                            break;
                        case 3:
                            optionTargetType = OptionTargetType.TARGET_TYPE_MESSAGE;
                            break;
                        case 4:
                            optionTargetType = OptionTargetType.TARGET_TYPE_FIELD;
                            break;
                        case 5:
                            optionTargetType = OptionTargetType.TARGET_TYPE_ONEOF;
                            break;
                        case 6:
                            optionTargetType = OptionTargetType.TARGET_TYPE_ENUM;
                            break;
                        case 7:
                            optionTargetType = OptionTargetType.TARGET_TYPE_ENUM_ENTRY;
                            break;
                        case 8:
                            optionTargetType = OptionTargetType.TARGET_TYPE_SERVICE;
                            break;
                        case 9:
                            optionTargetType = OptionTargetType.TARGET_TYPE_METHOD;
                            break;
                        default:
                            optionTargetType = null;
                            break;
                    }
                    return optionTargetType != null;
                }
            }

            OptionTargetType(int i2) {
                this.f3920a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3920a;
            }
        }

        static {
            FieldOptions fieldOptions = new FieldOptions();
            DEFAULT_INSTANCE = fieldOptions;
            GeneratedMessageLite.w(FieldOptions.class, fieldOptions);
        }

        public FieldOptions() {
            ProtobufArrayList protobufArrayList = ProtobufArrayList.f4115d;
            this.editionDefaults_ = protobufArrayList;
            this.uninterpretedOption_ = protobufArrayList;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u000e\u0000\u0001\u0001ϧ\u000e\u0000\u0003\u0002\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006᠌\u0002\nဇ\u0006\u000fဇ\u0004\u0010ဇ\u0007\u0011᠌\b\u0013ࠞ\u0014\u001b\u0015ᐉ\t\u0016ဉ\nϧЛ", new Object[]{"bitField0_", "ctype_", CType.CTypeVerifier.f3896a, "packed_", "deprecated_", "lazy_", "jstype_", JSType.JSTypeVerifier.f3902a, "weak_", "unverifiedLazy_", "debugRedact_", "retention_", OptionRetention.OptionRetentionVerifier.f3908a, "targets_", OptionTargetType.OptionTargetTypeVerifier.f3921a, "editionDefaults_", EditionDefault.class, "features_", "featureSupport_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new FieldOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FieldOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FieldOptions.class) {
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

    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
    }

    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        private static final FileDescriptorProto DEFAULT_INSTANCE;
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int EDITION_FIELD_NUMBER = 14;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private Internal.ProtobufList<String> dependency_;
        private int edition_;
        private Internal.ProtobufList<EnumDescriptorProto> enumType_;
        private Internal.ProtobufList<FieldDescriptorProto> extension_;
        private Internal.ProtobufList<DescriptorProto> messageType_;
        private FileOptions options_;
        private Internal.IntList publicDependency_;
        private Internal.ProtobufList<ServiceDescriptorProto> service_;
        private SourceCodeInfo sourceCodeInfo_;
        private String syntax_;
        private Internal.IntList weakDependency_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String package_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        }

        static {
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            DEFAULT_INSTANCE = fileDescriptorProto;
            GeneratedMessageLite.w(FileDescriptorProto.class, fileDescriptorProto);
        }

        public FileDescriptorProto() {
            ProtobufArrayList protobufArrayList = ProtobufArrayList.f4115d;
            this.dependency_ = protobufArrayList;
            IntArrayList intArrayList = IntArrayList.f4021d;
            this.publicDependency_ = intArrayList;
            this.weakDependency_ = intArrayList;
            this.messageType_ = protobufArrayList;
            this.enumType_ = protobufArrayList;
            this.service_ = protobufArrayList;
            this.extension_ = protobufArrayList;
            this.syntax_ = "";
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\u000e\r\u0000\u0007\u0005\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tဉ\u0003\n\u0016\u000b\u0016\fဈ\u0004\u000e᠌\u0005", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "service_", ServiceDescriptorProto.class, "extension_", FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_", "edition_", Edition.EditionVerifier.f3828a});
                case 3:
                    return new FileDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FileDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileDescriptorProto.class) {
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

    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        private static final FileDescriptorSet DEFAULT_INSTANCE;
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FileDescriptorProto> file_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        }

        static {
            FileDescriptorSet fileDescriptorSet = new FileDescriptorSet();
            DEFAULT_INSTANCE = fileDescriptorSet;
            GeneratedMessageLite.w(FileDescriptorSet.class, fileDescriptorSet);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", FileDescriptorProto.class});
                case 3:
                    return new FileDescriptorSet();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FileDescriptorSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileDescriptorSet.class) {
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

    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        private static final FileOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int FEATURES_FIELD_NUMBER = 50;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean deprecated_;
        private FeatureSet features_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private boolean javaStringCheckUtf8_;
        private boolean pyGenericServices_;
        private byte memoizedIsInitialized = 2;
        private String javaPackage_ = "";
        private String javaOuterClassname_ = "";
        private int optimizeFor_ = 1;
        private String goPackage_ = "";
        private boolean ccEnableArenas_ = true;
        private String objcClassPrefix_ = "";
        private String csharpNamespace_ = "";
        private String swiftPrefix_ = "";
        private String phpClassPrefix_ = "";
        private String phpNamespace_ = "";
        private String phpMetadataNamespace_ = "";
        private String rubyPackage_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
        }

        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f3926a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$FileOptions$OptimizeMode$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<OptimizeMode> {
            }

            public static final class OptimizeModeVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3927a = new OptimizeModeVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 1 ? i2 != 2 ? i2 != 3 ? null : OptimizeMode.LITE_RUNTIME : OptimizeMode.CODE_SIZE : OptimizeMode.SPEED) != null;
                }
            }

            OptimizeMode(int i2) {
                this.f3926a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3926a;
            }
        }

        static {
            FileOptions fileOptions = new FileOptions();
            DEFAULT_INSTANCE = fileOptions;
            GeneratedMessageLite.w(FileOptions.class, fileOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0002\u0001ဈ\u0000\bဈ\u0001\t᠌\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\n\u001bဇ\u0004\u001fဇ\u000b$ဈ\f%ဈ\r'ဈ\u000e(ဈ\u000f)ဈ\u0010,ဈ\u0011-ဈ\u00122ᐉ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", OptimizeMode.OptimizeModeVerifier.f3927a, "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpMetadataNamespace_", "rubyPackage_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new FileOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<FileOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileOptions.class) {
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

    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
    }

    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE;
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = ProtobufArrayList.f4115d;

        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            private static final Annotation DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SEMANTIC_FIELD_NUMBER = 5;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int semantic_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = IntArrayList.f4021d;
            private String sourceFile_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            }

            public enum Semantic implements Internal.EnumLite {
                NONE(0),
                SET(1),
                ALIAS(2);


                /* renamed from: a, reason: collision with root package name */
                public final int f3932a;

                /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic$1, reason: invalid class name */
                public class AnonymousClass1 implements Internal.EnumLiteMap<Semantic> {
                }

                public static final class SemanticVerifier implements Internal.EnumVerifier {

                    /* renamed from: a, reason: collision with root package name */
                    public static final Internal.EnumVerifier f3933a = new SemanticVerifier();

                    @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                    public final boolean a(int i2) {
                        return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : Semantic.ALIAS : Semantic.SET : Semantic.NONE) != null;
                    }
                }

                Semantic(int i2) {
                    this.f3932a = i2;
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
                public final int f() {
                    return this.f3932a;
                }
            }

            static {
                Annotation annotation = new Annotation();
                DEFAULT_INSTANCE = annotation;
                GeneratedMessageLite.w(Annotation.class, annotation);
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002\u0005᠌\u0003", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_", "semantic_", Semantic.SemanticVerifier.f3933a});
                    case 3:
                        return new Annotation();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<Annotation> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Annotation.class) {
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

        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        }

        static {
            GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo();
            DEFAULT_INSTANCE = generatedCodeInfo;
            GeneratedMessageLite.w(GeneratedCodeInfo.class, generatedCodeInfo);
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
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"annotation_", Annotation.class});
                case 3:
                    return new GeneratedCodeInfo();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<GeneratedCodeInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GeneratedCodeInfo.class) {
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

    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        private static final MessageOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 11;
        public static final int FEATURES_FIELD_NUMBER = 12;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecatedLegacyJsonFieldConflicts_;
        private boolean deprecated_;
        private FeatureSet features_;
        private boolean mapEntry_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        }

        static {
            MessageOptions messageOptions = new MessageOptions();
            DEFAULT_INSTANCE = messageOptions;
            GeneratedMessageLite.w(MessageOptions.class, messageOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\u000bဇ\u0004\fᐉ\u0005ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new MessageOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<MessageOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MessageOptions.class) {
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

    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
    }

    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        private static final MethodDescriptorProto DEFAULT_INSTANCE;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private MethodOptions options_;
        private boolean serverStreaming_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String inputType_ = "";
        private String outputType_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        }

        static {
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            DEFAULT_INSTANCE = methodDescriptorProto;
            GeneratedMessageLite.w(MethodDescriptorProto.class, methodDescriptorProto);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
                case 3:
                    return new MethodDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<MethodDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MethodDescriptorProto.class) {
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

    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        private static final MethodOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int FEATURES_FIELD_NUMBER = 35;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private FeatureSet features_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        }

        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f3938a;

            /* renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel$1, reason: invalid class name */
            public class AnonymousClass1 implements Internal.EnumLiteMap<IdempotencyLevel> {
            }

            public static final class IdempotencyLevelVerifier implements Internal.EnumVerifier {

                /* renamed from: a, reason: collision with root package name */
                public static final Internal.EnumVerifier f3939a = new IdempotencyLevelVerifier();

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public final boolean a(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : IdempotencyLevel.IDEMPOTENT : IdempotencyLevel.NO_SIDE_EFFECTS : IdempotencyLevel.IDEMPOTENCY_UNKNOWN) != null;
                }
            }

            IdempotencyLevel(int i2) {
                this.f3938a = i2;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int f() {
                return this.f3938a;
            }
        }

        static {
            MethodOptions methodOptions = new MethodOptions();
            DEFAULT_INSTANCE = methodOptions;
            GeneratedMessageLite.w(MethodOptions.class, methodOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001!ϧ\u0004\u0000\u0001\u0002!ဇ\u0000\"᠌\u0001#ᐉ\u0002ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", IdempotencyLevel.IdempotencyLevelVerifier.f3939a, "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new MethodOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<MethodOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MethodOptions.class) {
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

    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
    }

    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        private static final OneofDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private OneofOptions options_;

        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        }

        static {
            OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto();
            DEFAULT_INSTANCE = oneofDescriptorProto;
            GeneratedMessageLite.w(OneofDescriptorProto.class, oneofDescriptorProto);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "name_", "options_"});
                case 3:
                    return new OneofDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<OneofDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (OneofDescriptorProto.class) {
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

    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        private static final OneofOptions DEFAULT_INSTANCE;
        public static final int FEATURES_FIELD_NUMBER = 1;
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        }

        static {
            OneofOptions oneofOptions = new OneofOptions();
            DEFAULT_INSTANCE = oneofOptions;
            GeneratedMessageLite.w(OneofOptions.class, oneofOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0002\u0001ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new OneofOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<OneofOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (OneofOptions.class) {
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

    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
    }

    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        private static final ServiceDescriptorProto DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private ServiceOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<MethodDescriptorProto> method_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        }

        static {
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            DEFAULT_INSTANCE = serviceDescriptorProto;
            GeneratedMessageLite.w(ServiceDescriptorProto.class, serviceDescriptorProto);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", MethodDescriptorProto.class, "options_"});
                case 3:
                    return new ServiceDescriptorProto();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<ServiceDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ServiceDescriptorProto.class) {
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

    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        private static final ServiceOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int FEATURES_FIELD_NUMBER = 34;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        }

        static {
            ServiceOptions serviceOptions = new ServiceOptions();
            DEFAULT_INSTANCE = serviceOptions;
            GeneratedMessageLite.w(ServiceOptions.class, serviceOptions);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0002!ဇ\u0001\"ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 3:
                    return new ServiceOptions();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<ServiceOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ServiceOptions.class) {
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

    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
    }

    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        private static final SourceCodeInfo DEFAULT_INSTANCE;
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = ProtobufArrayList.f4115d;

        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        }

        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            private static final Location DEFAULT_INSTANCE;
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private String leadingComments_;
            private Internal.ProtobufList<String> leadingDetachedComments_;
            private Internal.IntList path_;
            private Internal.IntList span_;
            private String trailingComments_;
            private int pathMemoizedSerializedSize = -1;
            private int spanMemoizedSerializedSize = -1;

            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
            }

            static {
                Location location = new Location();
                DEFAULT_INSTANCE = location;
                GeneratedMessageLite.w(Location.class, location);
            }

            public Location() {
                IntArrayList intArrayList = IntArrayList.f4021d;
                this.path_ = intArrayList;
                this.span_ = intArrayList;
                this.leadingComments_ = "";
                this.trailingComments_ = "";
                this.leadingDetachedComments_ = ProtobufArrayList.f4115d;
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
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                    case 3:
                        return new Location();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<Location> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Location.class) {
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

        public interface LocationOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            DEFAULT_INSTANCE = sourceCodeInfo;
            GeneratedMessageLite.w(SourceCodeInfo.class, sourceCodeInfo);
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
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", Location.class});
                case 3:
                    return new SourceCodeInfo();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<SourceCodeInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SourceCodeInfo.class) {
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

    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        private static final UninterpretedOption DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private int bitField0_;
        private double doubleValue_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<NamePart> name_ = ProtobufArrayList.f4115d;
        private String identifierValue_ = "";
        private ByteString stringValue_ = ByteString.f3748b;
        private String aggregateValue_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        }

        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            private static final NamePart DEFAULT_INSTANCE;
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = 2;
            private String namePart_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
            }

            static {
                NamePart namePart = new NamePart();
                DEFAULT_INSTANCE = namePart;
                GeneratedMessageLite.w(NamePart.class, namePart);
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
                Parser defaultInstanceBasedParser;
                switch (methodToInvoke.ordinal()) {
                    case 0:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 1:
                        this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                        return null;
                    case 2:
                        return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
                    case 3:
                        return new NamePart();
                    case 4:
                        return new Builder(DEFAULT_INSTANCE);
                    case 5:
                        return DEFAULT_INSTANCE;
                    case 6:
                        Parser<NamePart> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (NamePart.class) {
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

        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            DEFAULT_INSTANCE = uninterpretedOption;
            GeneratedMessageLite.w(UninterpretedOption.class, uninterpretedOption);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite) {
            Parser defaultInstanceBasedParser;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 1:
                    this.memoizedIsInitialized = (byte) (generatedMessageLite == null ? 0 : 1);
                    return null;
                case 2:
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", NamePart.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
                case 3:
                    return new UninterpretedOption();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<UninterpretedOption> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UninterpretedOption.class) {
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

    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
    }
}
