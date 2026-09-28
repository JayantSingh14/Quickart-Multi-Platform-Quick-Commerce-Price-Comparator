package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.SmallSortedMap;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.Iterator;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes3.dex */
final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: a, reason: collision with root package name */
    public final MessageLite f4095a;

    /* renamed from: b, reason: collision with root package name */
    public final UnknownFieldSchema f4096b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4097c;

    /* renamed from: d, reason: collision with root package name */
    public final ExtensionSchema f4098d;

    public MessageSetSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        this.f4096b = unknownFieldSchema;
        this.f4097c = extensionSchema.e(messageLite);
        this.f4098d = extensionSchema;
        this.f4095a = messageLite;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void a(Object obj, Object obj2) {
        Class cls = SchemaUtil.f4138a;
        UnknownFieldSchema unknownFieldSchema = this.f4096b;
        unknownFieldSchema.o(obj, unknownFieldSchema.k(unknownFieldSchema.g(obj), unknownFieldSchema.g(obj2)));
        if (this.f4097c) {
            SchemaUtil.k(this.f4098d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        UnknownFieldSchema unknownFieldSchema = this.f4096b;
        UnknownFieldSetLite unknownFieldSetLiteF = unknownFieldSchema.f(obj);
        ExtensionSchema extensionSchema = this.f4098d;
        FieldSet fieldSetD = extensionSchema.d(obj);
        while (reader.G() != Integer.MAX_VALUE) {
            try {
                Reader reader2 = reader;
                ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
                if (!j(reader2, extensionRegistryLite2, extensionSchema, fieldSetD, unknownFieldSchema, unknownFieldSetLiteF)) {
                    return;
                }
                reader = reader2;
                extensionRegistryLite = extensionRegistryLite2;
            } finally {
                unknownFieldSchema.n(obj, unknownFieldSetLiteF);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void c(Object obj) {
        this.f4096b.j(obj);
        this.f4098d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int d(AbstractMessageLite abstractMessageLite) {
        UnknownFieldSchema unknownFieldSchema = this.f4096b;
        int i2 = unknownFieldSchema.i(unknownFieldSchema.g(abstractMessageLite));
        if (!this.f4097c) {
            return i2;
        }
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f4098d.c(abstractMessageLite).f3980a;
        int size = anonymousClass1.f4142a.size();
        int iF = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iF += FieldSet.f(anonymousClass1.c(i3));
        }
        Iterator<T> it = anonymousClass1.d().iterator();
        while (it.hasNext()) {
            iF += FieldSet.f((Map.Entry) it.next());
        }
        return i2 + iF;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean e(Object obj) {
        return this.f4098d.c(obj).g();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final Object f() {
        MessageLite messageLite = this.f4095a;
        return messageLite instanceof GeneratedMessageLite ? ((GeneratedMessageLite) messageLite).u() : messageLite.e().Z();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int g(GeneratedMessageLite generatedMessageLite) {
        int iHashCode = this.f4096b.g(generatedMessageLite).hashCode();
        return this.f4097c ? (iHashCode * 53) + this.f4098d.c(generatedMessageLite).f3980a.hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void h(Object obj, Writer writer) {
        Iterator itI = this.f4098d.c(obj).i();
        while (itI.hasNext()) {
            Map.Entry entry = (Map.Entry) itI.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) entry.getKey();
            if (fieldDescriptorLite.v() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.m() || fieldDescriptorLite.w()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof LazyField.LazyEntry) {
                writer.b(fieldDescriptorLite.f(), ((LazyField) ((LazyField.LazyEntry) entry).f4057a.getValue()).b());
            } else {
                writer.b(fieldDescriptorLite.f(), entry.getValue());
            }
        }
        UnknownFieldSchema unknownFieldSchema = this.f4096b;
        unknownFieldSchema.q(unknownFieldSchema.g(obj), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean i(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        UnknownFieldSchema unknownFieldSchema = this.f4096b;
        if (!unknownFieldSchema.g(generatedMessageLite).equals(unknownFieldSchema.g(generatedMessageLite2))) {
            return false;
        }
        if (!this.f4097c) {
            return true;
        }
        ExtensionSchema extensionSchema = this.f4098d;
        return extensionSchema.c(generatedMessageLite).equals(extensionSchema.c(generatedMessageLite2));
    }

    public final boolean j(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema extensionSchema, FieldSet fieldSet, UnknownFieldSchema unknownFieldSchema, Object obj) throws InvalidProtocolBufferException {
        int iZ = reader.z();
        int iG = 0;
        MessageLite messageLite = this.f4095a;
        if (iZ != 11) {
            if ((iZ & 7) != 2) {
                return reader.K();
            }
            GeneratedMessageLite.GeneratedExtension generatedExtensionB = extensionSchema.b(extensionRegistryLite, messageLite, iZ >>> 3);
            if (generatedExtensionB == null) {
                return unknownFieldSchema.l(0, reader, obj);
            }
            extensionSchema.h(reader, generatedExtensionB, extensionRegistryLite, fieldSet);
            return true;
        }
        GeneratedMessageLite.GeneratedExtension generatedExtensionB2 = null;
        ByteString byteStringO = null;
        while (reader.G() != Integer.MAX_VALUE) {
            int iZ2 = reader.z();
            if (iZ2 == 16) {
                iG = reader.g();
                generatedExtensionB2 = extensionSchema.b(extensionRegistryLite, messageLite, iG);
            } else if (iZ2 == 26) {
                if (generatedExtensionB2 != null) {
                    extensionSchema.h(reader, generatedExtensionB2, extensionRegistryLite, fieldSet);
                } else {
                    byteStringO = reader.o();
                }
            } else if (!reader.K()) {
                break;
            }
        }
        if (reader.z() != 12) {
            throw InvalidProtocolBufferException.a();
        }
        if (byteStringO != null) {
            if (generatedExtensionB2 != null) {
                extensionSchema.i(byteStringO, generatedExtensionB2, extensionRegistryLite, fieldSet);
                return true;
            }
            unknownFieldSchema.d(obj, iG, byteStringO);
        }
        return true;
    }
}
