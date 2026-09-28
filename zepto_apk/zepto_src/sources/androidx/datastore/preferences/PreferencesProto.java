package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.UninitializedMessageException;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class PreferencesProto {

    /* renamed from: androidx.datastore.preferences.PreferencesProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3703a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f3703a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3703a[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3703a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3703a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3703a[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3703a[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3703a[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class PreferenceMap extends GeneratedMessageLite<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
        private static final PreferenceMap DEFAULT_INSTANCE;
        private static volatile Parser<PreferenceMap> PARSER = null;
        public static final int PREFERENCES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> preferences_ = MapFieldLite.f4076b;

        public static final class Builder extends GeneratedMessageLite.Builder<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
            public final void o(Value value, String str) {
                str.getClass();
                k();
                PreferenceMap.y((PreferenceMap) this.f4008b).put(str, value);
            }
        }

        public static final class PreferencesDefaultEntryHolder {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntryLite f3704a = new MapEntryLite(WireFormat.FieldType.f4202k, WireFormat.FieldType.f4204m, Value.I());
        }

        static {
            PreferenceMap preferenceMap = new PreferenceMap();
            DEFAULT_INSTANCE = preferenceMap;
            GeneratedMessageLite.w(PreferenceMap.class, preferenceMap);
        }

        public static Builder A() {
            return (Builder) ((GeneratedMessageLite.Builder) DEFAULT_INSTANCE.m(GeneratedMessageLite.MethodToInvoke.f4016e, null));
        }

        public static PreferenceMap B(InputStream inputStream) throws InvalidProtocolBufferException {
            GeneratedMessageLite generatedMessageLiteV = GeneratedMessageLite.v(DEFAULT_INSTANCE, CodedInputStream.d(inputStream), ExtensionRegistryLite.a());
            if (GeneratedMessageLite.q(generatedMessageLiteV, true)) {
                return (PreferenceMap) generatedMessageLiteV;
            }
            throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
        }

        public static MapFieldLite y(PreferenceMap preferenceMap) {
            MapFieldLite<String, Value> mapFieldLite = preferenceMap.preferences_;
            if (!mapFieldLite.f4077a) {
                preferenceMap.preferences_ = mapFieldLite.c();
            }
            return preferenceMap.preferences_;
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
                    return GeneratedMessageLite.t(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.f3704a});
                case 3:
                    return new PreferenceMap();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<PreferenceMap> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PreferenceMap.class) {
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

        public final Map z() {
            return Collections.unmodifiableMap(this.preferences_);
        }
    }

    public interface PreferenceMapOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringSet extends GeneratedMessageLite<StringSet, Builder> implements StringSetOrBuilder {
        private static final StringSet DEFAULT_INSTANCE;
        private static volatile Parser<StringSet> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.n();

        public static final class Builder extends GeneratedMessageLite.Builder<StringSet, Builder> implements StringSetOrBuilder {
            public final void o(Set set) {
                k();
                StringSet.y((StringSet) this.f4008b, set);
            }
        }

        static {
            StringSet stringSet = new StringSet();
            DEFAULT_INSTANCE = stringSet;
            GeneratedMessageLite.w(StringSet.class, stringSet);
        }

        public static Builder B() {
            return (Builder) ((GeneratedMessageLite.Builder) DEFAULT_INSTANCE.m(GeneratedMessageLite.MethodToInvoke.f4016e, null));
        }

        public static void y(StringSet stringSet, Set set) {
            Internal.ProtobufList<String> protobufList = stringSet.strings_;
            if (!protobufList.r0()) {
                int size = protobufList.size();
                stringSet.strings_ = protobufList.a(size == 0 ? 10 : size * 2);
            }
            AbstractMessageLite.h(set, stringSet.strings_);
        }

        public static StringSet z() {
            return DEFAULT_INSTANCE;
        }

        public final Internal.ProtobufList A() {
            return this.strings_;
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
                    return GeneratedMessageLite.t(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
                case 3:
                    return new StringSet();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<StringSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StringSet.class) {
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

    public interface StringSetOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 1;
        public static final int BYTES_FIELD_NUMBER = 8;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_FIELD_NUMBER = 7;
        public static final int FLOAT_FIELD_NUMBER = 2;
        public static final int INTEGER_FIELD_NUMBER = 3;
        public static final int LONG_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 5;
        public static final int STRING_SET_FIELD_NUMBER = 6;
        private int valueCase_ = 0;
        private Object value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            public final void o(boolean z) {
                k();
                Value.D((Value) this.f4008b, z);
            }

            public final void p(ByteString byteString) {
                k();
                Value.B((Value) this.f4008b, byteString);
            }

            public final void q(double d2) {
                k();
                Value.A((Value) this.f4008b, d2);
            }

            public final void t(float f2) {
                k();
                Value.E((Value) this.f4008b, f2);
            }

            public final void u(int i2) {
                k();
                Value.F((Value) this.f4008b, i2);
            }

            public final void v(long j2) {
                k();
                Value.x((Value) this.f4008b, j2);
            }

            public final void w(String str) {
                k();
                Value.y((Value) this.f4008b, str);
            }

            public final void x(StringSet.Builder builder) {
                k();
                Value.z((Value) this.f4008b, (StringSet) builder.i());
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class ValueCase {

            /* renamed from: a, reason: collision with root package name */
            public static final ValueCase f3705a;

            /* renamed from: b, reason: collision with root package name */
            public static final ValueCase f3706b;

            /* renamed from: c, reason: collision with root package name */
            public static final ValueCase f3707c;

            /* renamed from: d, reason: collision with root package name */
            public static final ValueCase f3708d;

            /* renamed from: e, reason: collision with root package name */
            public static final ValueCase f3709e;

            /* renamed from: f, reason: collision with root package name */
            public static final ValueCase f3710f;

            /* renamed from: g, reason: collision with root package name */
            public static final ValueCase f3711g;

            /* renamed from: h, reason: collision with root package name */
            public static final ValueCase f3712h;

            /* renamed from: i, reason: collision with root package name */
            public static final ValueCase f3713i;

            /* renamed from: j, reason: collision with root package name */
            public static final /* synthetic */ ValueCase[] f3714j;

            static {
                ValueCase valueCase = new ValueCase("BOOLEAN", 0);
                f3705a = valueCase;
                ValueCase valueCase2 = new ValueCase("FLOAT", 1);
                f3706b = valueCase2;
                ValueCase valueCase3 = new ValueCase("INTEGER", 2);
                f3707c = valueCase3;
                ValueCase valueCase4 = new ValueCase("LONG", 3);
                f3708d = valueCase4;
                ValueCase valueCase5 = new ValueCase("STRING", 4);
                f3709e = valueCase5;
                ValueCase valueCase6 = new ValueCase("STRING_SET", 5);
                f3710f = valueCase6;
                ValueCase valueCase7 = new ValueCase("DOUBLE", 6);
                f3711g = valueCase7;
                ValueCase valueCase8 = new ValueCase("BYTES", 7);
                f3712h = valueCase8;
                ValueCase valueCase9 = new ValueCase("VALUE_NOT_SET", 8);
                f3713i = valueCase9;
                f3714j = new ValueCase[]{valueCase, valueCase2, valueCase3, valueCase4, valueCase5, valueCase6, valueCase7, valueCase8, valueCase9};
            }

            public static ValueCase valueOf(String str) {
                return (ValueCase) Enum.valueOf(ValueCase.class, str);
            }

            public static ValueCase[] values() {
                return (ValueCase[]) f3714j.clone();
            }
        }

        static {
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.w(Value.class, value);
        }

        public static void A(Value value, double d2) {
            value.valueCase_ = 7;
            value.value_ = Double.valueOf(d2);
        }

        public static void B(Value value, ByteString byteString) {
            value.getClass();
            value.valueCase_ = 8;
            value.value_ = byteString;
        }

        public static void D(Value value, boolean z) {
            value.valueCase_ = 1;
            value.value_ = Boolean.valueOf(z);
        }

        public static void E(Value value, float f2) {
            value.valueCase_ = 2;
            value.value_ = Float.valueOf(f2);
        }

        public static void F(Value value, int i2) {
            value.valueCase_ = 3;
            value.value_ = Integer.valueOf(i2);
        }

        public static Value I() {
            return DEFAULT_INSTANCE;
        }

        public static Builder Q() {
            return (Builder) ((GeneratedMessageLite.Builder) DEFAULT_INSTANCE.m(GeneratedMessageLite.MethodToInvoke.f4016e, null));
        }

        public static void x(Value value, long j2) {
            value.valueCase_ = 4;
            value.value_ = Long.valueOf(j2);
        }

        public static void y(Value value, String str) {
            value.getClass();
            str.getClass();
            value.valueCase_ = 5;
            value.value_ = str;
        }

        public static void z(Value value, StringSet stringSet) {
            value.getClass();
            value.value_ = stringSet;
            value.valueCase_ = 6;
        }

        public final boolean G() {
            if (this.valueCase_ == 1) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        public final ByteString H() {
            return this.valueCase_ == 8 ? (ByteString) this.value_ : ByteString.f3748b;
        }

        public final double J() {
            if (this.valueCase_ == 7) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        public final float K() {
            if (this.valueCase_ == 2) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        public final int L() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        public final long M() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        public final String N() {
            return this.valueCase_ == 5 ? (String) this.value_ : "";
        }

        public final StringSet O() {
            return this.valueCase_ == 6 ? (StringSet) this.value_ : StringSet.z();
        }

        public final ValueCase P() {
            switch (this.valueCase_) {
                case 0:
                    return ValueCase.f3713i;
                case 1:
                    return ValueCase.f3705a;
                case 2:
                    return ValueCase.f3706b;
                case 3:
                    return ValueCase.f3707c;
                case 4:
                    return ValueCase.f3708d;
                case 5:
                    return ValueCase.f3709e;
                case 6:
                    return ValueCase.f3710f;
                case 7:
                    return ValueCase.f3711g;
                case 8:
                    return ValueCase.f3712h;
                default:
                    return null;
            }
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
                    return GeneratedMessageLite.t(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", StringSet.class});
                case 3:
                    return new Value();
                case 4:
                    return new Builder(DEFAULT_INSTANCE);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<Value> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Value.class) {
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

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
    }
}
