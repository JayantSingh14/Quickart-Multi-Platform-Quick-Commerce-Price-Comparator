package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.JavaFeaturesProto;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

@CheckReturnValue
/* loaded from: classes3.dex */
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* renamed from: androidx.datastore.preferences.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3953a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3953a = iArr;
            try {
                iArr[WireFormat.FieldType.f4194c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3953a[WireFormat.FieldType.f4195d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3953a[WireFormat.FieldType.f4196e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3953a[WireFormat.FieldType.f4197f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3953a[WireFormat.FieldType.f4198g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3953a[WireFormat.FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3953a[WireFormat.FieldType.f4200i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3953a[WireFormat.FieldType.f4201j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3953a[WireFormat.FieldType.o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3953a[WireFormat.FieldType.q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3953a[WireFormat.FieldType.r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3953a[WireFormat.FieldType.s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3953a[WireFormat.FieldType.t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3953a[WireFormat.FieldType.p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3953a[WireFormat.FieldType.n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3953a[WireFormat.FieldType.f4202k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3953a[WireFormat.FieldType.f4203l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3953a[WireFormat.FieldType.f4204m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final int a(Map.Entry entry) {
        ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).getClass();
        return DateUtils.SEMI_MONTH;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final GeneratedMessageLite.GeneratedExtension b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2) {
        extensionRegistryLite.getClass();
        return (GeneratedMessageLite.GeneratedExtension) extensionRegistryLite.f3950a.get(new ExtensionRegistryLite.ObjectIntPair(i2, messageLite));
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final FieldSet c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final FieldSet d(Object obj) {
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        if (fieldSet.f3981b) {
            extendableMessage.extensions = fieldSet.clone();
        }
        return extendableMessage.extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final boolean e(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final void f(Object obj) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions.j();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final Object g(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, Object obj3, UnknownFieldSchema unknownFieldSchema) {
        Object objE;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj2;
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = generatedExtension.f4011b;
        extensionDescriptor.getClass();
        WireFormat.FieldType fieldType = extensionDescriptor.f4009a;
        Object objZ = null;
        if (fieldType == WireFormat.FieldType.p) {
            reader.p();
            extensionDescriptor.getClass();
            throw null;
        }
        int iOrdinal = fieldType.ordinal();
        JavaFeaturesProto.JavaFeatures javaFeatures = generatedExtension.f4010a;
        switch (iOrdinal) {
            case 0:
                objZ = Double.valueOf(reader.readDouble());
                break;
            case 1:
                objZ = Float.valueOf(reader.readFloat());
                break;
            case 2:
                objZ = Long.valueOf(reader.O());
                break;
            case 3:
                objZ = Long.valueOf(reader.t());
                break;
            case 4:
                objZ = Integer.valueOf(reader.p());
                break;
            case 5:
                objZ = Long.valueOf(reader.a());
                break;
            case 6:
                objZ = Integer.valueOf(reader.w());
                break;
            case 7:
                objZ = Boolean.valueOf(reader.d());
                break;
            case 8:
                objZ = reader.F();
                break;
            case 9:
                extensionDescriptor.getClass();
                Object objE2 = fieldSet.e(extensionDescriptor);
                if (!(objE2 instanceof GeneratedMessageLite)) {
                    objZ = reader.x(javaFeatures.getClass(), extensionRegistryLite);
                    break;
                } else {
                    Schema schemaB = Protobuf.f4112c.b(objE2);
                    if (!((GeneratedMessageLite) objE2).r()) {
                        Object objF = schemaB.f();
                        schemaB.a(objF, objE2);
                        fieldSet.l(extensionDescriptor, objF);
                        objE2 = objF;
                    }
                    reader.C(objE2, schemaB, extensionRegistryLite);
                    return obj3;
                }
            case 10:
                extensionDescriptor.getClass();
                Object objE3 = fieldSet.e(extensionDescriptor);
                if (!(objE3 instanceof GeneratedMessageLite)) {
                    objZ = reader.u(javaFeatures.getClass(), extensionRegistryLite);
                    break;
                } else {
                    Schema schemaB2 = Protobuf.f4112c.b(objE3);
                    if (!((GeneratedMessageLite) objE3).r()) {
                        Object objF2 = schemaB2.f();
                        schemaB2.a(objF2, objE3);
                        fieldSet.l(extensionDescriptor, objF2);
                        objE3 = objF2;
                    }
                    reader.i(objE3, schemaB2, extensionRegistryLite);
                    return obj3;
                }
            case 11:
                objZ = reader.o();
                break;
            case 12:
                objZ = Integer.valueOf(reader.g());
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 14:
                objZ = Integer.valueOf(reader.L());
                break;
            case 15:
                objZ = Long.valueOf(reader.e());
                break;
            case 16:
                objZ = Integer.valueOf(reader.l());
                break;
            case 17:
                objZ = Long.valueOf(reader.E());
                break;
        }
        extensionDescriptor.getClass();
        int iOrdinal2 = extensionDescriptor.f4009a.ordinal();
        if ((iOrdinal2 == 9 || iOrdinal2 == 10) && (objE = fieldSet.e(extensionDescriptor)) != null) {
            GeneratedMessageLite.Builder builderA = ((MessageLite) objE).a();
            MessageLite messageLite = (MessageLite) objZ;
            if (!builderA.f4007a.getClass().isInstance(messageLite)) {
                throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
            }
            builderA.getClass();
            builderA.m((GeneratedMessageLite) ((AbstractMessageLite) messageLite));
            objZ = builderA.Z();
        }
        fieldSet.l(extensionDescriptor, objZ);
        return obj3;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.l(generatedExtension.f4011b, reader.u(generatedExtension.f4010a.getClass(), extensionRegistryLite));
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        GeneratedMessageLite.Builder builderE = generatedExtension.f4010a.e();
        CodedInputStream codedInputStreamQ = byteString.q();
        builderE.k();
        try {
            Schema schemaB = Protobuf.f4112c.b(builderE.f4008b);
            GeneratedMessageLite generatedMessageLite = builderE.f4008b;
            CodedInputStreamReader codedInputStreamReader = codedInputStreamQ.f3762b;
            if (codedInputStreamReader == null) {
                codedInputStreamReader = new CodedInputStreamReader(codedInputStreamQ);
            }
            schemaB.b(generatedMessageLite, codedInputStreamReader, extensionRegistryLite);
            fieldSet.l(generatedExtension.f4011b, builderE.Z());
            codedInputStreamQ.a(0);
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof IOException)) {
                throw e2;
            }
            throw ((IOException) e2.getCause());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public final void j(Writer writer, Map.Entry entry) {
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor) entry.getKey();
        extensionDescriptor.getClass();
        switch (extensionDescriptor.f4009a.ordinal()) {
            case 0:
                writer.u(DateUtils.SEMI_MONTH, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                writer.B(((Float) entry.getValue()).floatValue(), DateUtils.SEMI_MONTH);
                break;
            case 2:
                writer.C(DateUtils.SEMI_MONTH, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                writer.g(DateUtils.SEMI_MONTH, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                writer.i(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                writer.x(DateUtils.SEMI_MONTH, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                writer.c(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                writer.D(DateUtils.SEMI_MONTH, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                writer.f(DateUtils.SEMI_MONTH, (String) entry.getValue());
                break;
            case 9:
                writer.s(DateUtils.SEMI_MONTH, entry.getValue(), Protobuf.f4112c.a(entry.getValue().getClass()));
                break;
            case 10:
                writer.m(DateUtils.SEMI_MONTH, entry.getValue(), Protobuf.f4112c.a(entry.getValue().getClass()));
                break;
            case 11:
                writer.j(DateUtils.SEMI_MONTH, (ByteString) entry.getValue());
                break;
            case 12:
                writer.t(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                writer.i(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                writer.E(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                writer.k(DateUtils.SEMI_MONTH, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                writer.O(DateUtils.SEMI_MONTH, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                writer.p(DateUtils.SEMI_MONTH, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
