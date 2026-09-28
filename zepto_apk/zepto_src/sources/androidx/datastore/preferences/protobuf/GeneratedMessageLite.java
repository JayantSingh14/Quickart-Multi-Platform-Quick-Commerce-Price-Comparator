package androidx.datastore.preferences.protobuf;

import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.JavaFeaturesProto;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.f4175f;

    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4006a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f4006a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4006a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        public final GeneratedMessageLite f4007a;

        /* renamed from: b, reason: collision with root package name */
        public GeneratedMessageLite f4008b;

        public Builder(GeneratedMessageLite generatedMessageLite) {
            this.f4007a = generatedMessageLite;
            if (generatedMessageLite.r()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f4008b = generatedMessageLite.u();
        }

        public static void n(Object obj, Object obj2) {
            Protobuf.f4112c.b(obj).a(obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder
        public final Object clone() {
            Builder builder = (Builder) this.f4007a.m(MethodToInvoke.f4016e, null);
            builder.f4008b = Z();
            return builder;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public final boolean d() {
            return GeneratedMessageLite.q(this.f4008b, false);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder
        /* renamed from: h */
        public final Builder clone() {
            Builder builder = (Builder) this.f4007a.m(MethodToInvoke.f4016e, null);
            builder.f4008b = Z();
            return builder;
        }

        public final GeneratedMessageLite i() {
            GeneratedMessageLite generatedMessageLiteZ = Z();
            generatedMessageLiteZ.getClass();
            if (GeneratedMessageLite.q(generatedMessageLiteZ, true)) {
                return generatedMessageLiteZ;
            }
            throw new UninitializedMessageException();
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLite.Builder
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite Z() {
            if (!this.f4008b.r()) {
                return this.f4008b;
            }
            GeneratedMessageLite generatedMessageLite = this.f4008b;
            generatedMessageLite.getClass();
            Protobuf protobuf = Protobuf.f4112c;
            protobuf.getClass();
            protobuf.a(generatedMessageLite.getClass()).c(generatedMessageLite);
            generatedMessageLite.s();
            return this.f4008b;
        }

        public final void k() {
            if (this.f4008b.r()) {
                return;
            }
            l();
        }

        public void l() {
            GeneratedMessageLite generatedMessageLiteU = this.f4007a.u();
            n(generatedMessageLiteU, this.f4008b);
            this.f4008b = generatedMessageLiteU;
        }

        public final void m(GeneratedMessageLite generatedMessageLite) {
            if (this.f4007a.equals(generatedMessageLite)) {
                return;
            }
            k();
            n(this.f4008b, generatedMessageLite);
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder
        public final void l() {
            super.l();
            GeneratedMessageLite generatedMessageLite = this.f4008b;
            if (((ExtendableMessage) generatedMessageLite).extensions != FieldSet.f3979d) {
                ((ExtendableMessage) generatedMessageLite).extensions = ((ExtendableMessage) generatedMessageLite).extensions.clone();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public final ExtendableMessage Z() {
            if (!((ExtendableMessage) this.f4008b).r()) {
                return (ExtendableMessage) this.f4008b;
            }
            ((ExtendableMessage) this.f4008b).extensions.j();
            return (ExtendableMessage) super.Z();
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.f3979d;

        public class ExtensionWriter {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLite
        public final Builder a() {
            Builder builder = (Builder) m(MethodToInvoke.f4016e, null);
            builder.m(this);
            return builder;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLite
        public final Builder e() {
            return (Builder) m(MethodToInvoke.f4016e, null);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public final GeneratedMessageLite f() {
            return (GeneratedMessageLite) m(MethodToInvoke.f4017f, null);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f4009a;

        public ExtensionDescriptor(WireFormat.FieldType fieldType) {
            this.f4009a = fieldType;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((ExtensionDescriptor) obj).getClass();
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final int f() {
            return DateUtils.SEMI_MONTH;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final Builder k(MessageLite.Builder builder, MessageLite messageLite) {
            Builder builder2 = (Builder) builder;
            builder2.m((GeneratedMessageLite) messageLite);
            return builder2;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final boolean m() {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.FieldType o() {
            return this.f4009a;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.JavaType v() {
            return this.f4009a.f4205a;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public final boolean w() {
            return false;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        public final JavaFeaturesProto.JavaFeatures f4010a;

        /* renamed from: b, reason: collision with root package name */
        public final ExtensionDescriptor f4011b;

        public GeneratedExtension(DescriptorProtos.FeatureSet featureSet, JavaFeaturesProto.JavaFeatures javaFeatures, JavaFeaturesProto.JavaFeatures javaFeatures2, ExtensionDescriptor extensionDescriptor) {
            if (featureSet == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (extensionDescriptor.f4009a == WireFormat.FieldType.f4204m && javaFeatures2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f4010a = javaFeatures2;
            this.f4011b = extensionDescriptor;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MethodToInvoke {

        /* renamed from: a, reason: collision with root package name */
        public static final MethodToInvoke f4012a;

        /* renamed from: b, reason: collision with root package name */
        public static final MethodToInvoke f4013b;

        /* renamed from: c, reason: collision with root package name */
        public static final MethodToInvoke f4014c;

        /* renamed from: d, reason: collision with root package name */
        public static final MethodToInvoke f4015d;

        /* renamed from: e, reason: collision with root package name */
        public static final MethodToInvoke f4016e;

        /* renamed from: f, reason: collision with root package name */
        public static final MethodToInvoke f4017f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ MethodToInvoke[] f4018g;

        static {
            MethodToInvoke methodToInvoke = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            f4012a = methodToInvoke;
            MethodToInvoke methodToInvoke2 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            f4013b = methodToInvoke2;
            MethodToInvoke methodToInvoke3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            f4014c = methodToInvoke3;
            MethodToInvoke methodToInvoke4 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            f4015d = methodToInvoke4;
            MethodToInvoke methodToInvoke5 = new MethodToInvoke("NEW_BUILDER", 4);
            f4016e = methodToInvoke5;
            MethodToInvoke methodToInvoke6 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            f4017f = methodToInvoke6;
            f4018g = new MethodToInvoke[]{methodToInvoke, methodToInvoke2, methodToInvoke3, methodToInvoke4, methodToInvoke5, methodToInvoke6, new MethodToInvoke("GET_PARSER", 6)};
        }

        public static MethodToInvoke valueOf(String str) {
            return (MethodToInvoke) java.lang.Enum.valueOf(MethodToInvoke.class, str);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) f4018g.clone();
        }
    }

    public static final class SerializedForm implements Serializable {
    }

    public static Internal.ProtobufList n() {
        return ProtobufArrayList.f4115d;
    }

    public static GeneratedMessageLite o(Class cls) throws ClassNotFoundException {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (generatedMessageLite != null) {
            return generatedMessageLite;
        }
        GeneratedMessageLite<?, ?> generatedMessageLite2 = (GeneratedMessageLite) ((GeneratedMessageLite) UnsafeUtil.c(cls)).m(MethodToInvoke.f4017f, null);
        if (generatedMessageLite2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, generatedMessageLite2);
        return generatedMessageLite2;
    }

    public static Object p(java.lang.reflect.Method method, MessageLite messageLite, Object... objArr) {
        try {
            return method.invoke(messageLite, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean q(GeneratedMessageLite generatedMessageLite, boolean z) {
        byte bByteValue = ((Byte) generatedMessageLite.m(MethodToInvoke.f4012a, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        Protobuf protobuf = Protobuf.f4112c;
        protobuf.getClass();
        boolean zE = protobuf.a(generatedMessageLite.getClass()).e(generatedMessageLite);
        if (z) {
            generatedMessageLite.m(MethodToInvoke.f4013b, zE ? generatedMessageLite : null);
        }
        return zE;
    }

    public static Object t(GeneratedMessageLite generatedMessageLite, String str, Object[] objArr) {
        return new RawMessageInfo(generatedMessageLite, str, objArr);
    }

    public static GeneratedMessageLite v(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteU = generatedMessageLite.u();
        try {
            Schema schemaB = Protobuf.f4112c.b(generatedMessageLiteU);
            CodedInputStreamReader codedInputStreamReader = codedInputStream.f3762b;
            if (codedInputStreamReader == null) {
                codedInputStreamReader = new CodedInputStreamReader(codedInputStream);
            }
            schemaB.b(generatedMessageLiteU, codedInputStreamReader, extensionRegistryLite);
            schemaB.c(generatedMessageLiteU);
            return generatedMessageLiteU;
        } catch (InvalidProtocolBufferException e2) {
            if (e2.f4028a) {
                throw new InvalidProtocolBufferException(e2.getMessage(), e2);
            }
            throw e2;
        } catch (UninitializedMessageException e3) {
            throw new InvalidProtocolBufferException(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw new InvalidProtocolBufferException(e4.getMessage(), e4);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e5.getCause());
            }
            throw e5;
        }
    }

    public static void w(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.s();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public Builder a() {
        Builder builder = (Builder) m(MethodToInvoke.f4016e, null);
        builder.m(this);
        return builder;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final int c() {
        return j(null);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
    public final boolean d() {
        return q(this, true);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public Builder e() {
        return (Builder) m(MethodToInvoke.f4016e, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Protobuf protobuf = Protobuf.f4112c;
        protobuf.getClass();
        return protobuf.a(getClass()).i(this, (GeneratedMessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
    public GeneratedMessageLite f() {
        return (GeneratedMessageLite) m(MethodToInvoke.f4017f, null);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final void g(CodedOutputStream codedOutputStream) {
        Protobuf protobuf = Protobuf.f4112c;
        protobuf.getClass();
        Schema schemaA = protobuf.a(getClass());
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f3803a;
        if (codedOutputStreamWriter == null) {
            codedOutputStreamWriter = new CodedOutputStreamWriter(codedOutputStream);
        }
        schemaA.h(this, codedOutputStreamWriter);
    }

    public final int hashCode() {
        if (r()) {
            Protobuf protobuf = Protobuf.f4112c;
            protobuf.getClass();
            return protobuf.a(getClass()).g(this);
        }
        if (this.memoizedHashCode == 0) {
            Protobuf protobuf2 = Protobuf.f4112c;
            protobuf2.getClass();
            this.memoizedHashCode = protobuf2.a(getClass()).g(this);
        }
        return this.memoizedHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    public final int i() {
        return this.memoizedSerializedSize & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    public final int j(Schema schema) {
        int iD;
        int iD2;
        if (r()) {
            if (schema == null) {
                Protobuf protobuf = Protobuf.f4112c;
                protobuf.getClass();
                iD2 = protobuf.a(getClass()).d(this);
            } else {
                iD2 = schema.d(this);
            }
            if (iD2 >= 0) {
                return iD2;
            }
            throw new IllegalStateException(b.f(iD2, "serialized size must be non-negative, was "));
        }
        if (i() != Integer.MAX_VALUE) {
            return i();
        }
        if (schema == null) {
            Protobuf protobuf2 = Protobuf.f4112c;
            protobuf2.getClass();
            iD = protobuf2.a(getClass()).d(this);
        } else {
            iD = schema.d(this);
        }
        k(iD);
        return iD;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    public final void k(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException(b.f(i2, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public abstract Object m(MethodToInvoke methodToInvoke, GeneratedMessageLite generatedMessageLite);

    public final boolean r() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void s() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = MessageLiteToString.f4080a;
        StringBuilder sbX = b.x("# ", string);
        MessageLiteToString.c(this, sbX, 0);
        return sbX.toString();
    }

    public final GeneratedMessageLite u() {
        return (GeneratedMessageLite) m(MethodToInvoke.f4015d, null);
    }
}
