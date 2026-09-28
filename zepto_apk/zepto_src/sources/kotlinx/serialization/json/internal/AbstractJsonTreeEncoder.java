package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@ExperimentalSerializationApi
@SourceDebugExtension
/* loaded from: classes3.dex */
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {

    /* renamed from: b, reason: collision with root package name */
    public final Json f56013b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f56014c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonConfiguration f56015d;

    /* renamed from: e, reason: collision with root package name */
    public String f56016e;

    public AbstractJsonTreeEncoder(Json json, Function1 function1) {
        this.f56013b = json;
        this.f56014c = function1;
        this.f56015d = json.f55945a;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final boolean D(PluginGeneratedSerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.f56015d.f55966a;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void G(Object obj, boolean z) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Boolean boolValueOf = Boolean.valueOf(z);
        InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
        Z(tag, new JsonLiteral(boolValueOf, false, null));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void H(Object obj, byte b2) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonElementKt.a(Byte.valueOf(b2)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void I(Object obj, char c2) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonElementKt.b(String.valueOf(c2)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void J(Object obj, double d2) {
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "tag");
        Z(key, JsonElementKt.a(Double.valueOf(d2)));
        if (this.f56015d.f55974i) {
            return;
        }
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            Double value = Double.valueOf(d2);
            String output = Y().toString();
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(output, "output");
            throw new JsonEncodingException(JsonExceptionsKt.i(value, key, output));
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void K(Object obj, SerialDescriptor enumDescriptor, int i2) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Z(tag, JsonElementKt.b(enumDescriptor.f(i2)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void L(Object obj, float f2) {
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "tag");
        Z(key, JsonElementKt.a(Float.valueOf(f2)));
        if (this.f56015d.f55974i) {
            return;
        }
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            Float value = Float.valueOf(f2);
            String output = Y().toString();
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(output, "output");
            throw new JsonEncodingException(JsonExceptionsKt.i(value, key, output));
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final Encoder M(Object obj, final SerialDescriptor inlineDescriptor) {
        final String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.b(inlineDescriptor)) {
            return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1

                /* renamed from: a, reason: collision with root package name */
                public final SerialModuleImpl f56021a;

                {
                    this.f56021a = this.f56022b.f56013b.f55946b;
                }

                @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
                public final void A(int i2) {
                    UInt.Companion companion = UInt.f53556b;
                    I(Long.toString(i2 & 4294967295L, 10));
                }

                public final void I(String s) {
                    Intrinsics.checkNotNullParameter(s, "s");
                    this.f56022b.Z(tag, new JsonLiteral(s, false, null));
                }

                @Override // kotlinx.serialization.encoding.Encoder
                public final SerializersModule a() {
                    return this.f56021a;
                }

                @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
                public final void h(byte b2) {
                    UByte.Companion companion = UByte.f53551b;
                    I(String.valueOf(b2 & 255));
                }

                @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
                public final void o(long j2) {
                    String str;
                    ULong.Companion companion = ULong.f53561b;
                    if (j2 == 0) {
                        str = "0";
                    } else if (j2 > 0) {
                        str = Long.toString(j2, 10);
                    } else {
                        char[] cArr = new char[64];
                        long j3 = (j2 >>> 1) / 5;
                        long j4 = 10;
                        int i2 = 63;
                        cArr[63] = Character.forDigit((int) (j2 - (j3 * j4)), 10);
                        while (j3 > 0) {
                            i2--;
                            cArr[i2] = Character.forDigit((int) (j3 % j4), 10);
                            j3 /= j4;
                        }
                        str = new String(cArr, i2, 64 - i2);
                    }
                    I(str);
                }

                @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
                public final void r(short s) {
                    UShort.Companion companion = UShort.f53567b;
                    I(String.valueOf(s & 65535));
                }
            };
        }
        if (StreamingJsonEncoderKt.a(inlineDescriptor)) {
            return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1
                @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
                public final void F(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.f56018a.Z(tag, new JsonLiteral(value, false, inlineDescriptor));
                }

                @Override // kotlinx.serialization.encoding.Encoder
                public final SerializersModule a() {
                    return this.f56018a.f56013b.f55946b;
                }
            };
        }
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        this.f55909a.add(tag);
        return this;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void N(int i2, Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonElementKt.a(Integer.valueOf(i2)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void O(long j2, Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonElementKt.a(Long.valueOf(j2)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void P(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonNull.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void Q(Object obj, short s) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Z(tag, JsonElementKt.a(Short.valueOf(s)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void R(Object obj, String value) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        Z(tag, JsonElementKt.b(value));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void S(Object obj, Object value) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        Z(tag, JsonElementKt.b(value.toString()));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final void T(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f56014c.invoke(Y());
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    public final String W(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    public String X(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return JsonNamesMapKt.b(descriptor, this.f56013b, i2);
    }

    public abstract JsonElement Y();

    public abstract void Z(String str, JsonElement jsonElement);

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final SerializersModule a() {
        return this.f56013b.f55946b;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder b(SerialDescriptor descriptor) {
        AbstractJsonTreeEncoder jsonTreeEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Function1<JsonElement, Unit> nodeConsumer = CollectionsKt.G(this.f55909a) == null ? this.f56014c : new Function1<JsonElement, Unit>() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$beginStructure$consumer$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                JsonElement node = (JsonElement) obj;
                Intrinsics.checkNotNullParameter(node, "node");
                AbstractJsonTreeEncoder abstractJsonTreeEncoder = this.f56017c;
                abstractJsonTreeEncoder.Z((String) CollectionsKt.F(abstractJsonTreeEncoder.f55909a), node);
                return Unit.f53572a;
            }
        };
        SerialKind serialKindD = descriptor.d();
        boolean z = Intrinsics.b(serialKindD, StructureKind.LIST.f55766a) ? true : serialKindD instanceof PolymorphicKind;
        Json json = this.f56013b;
        if (z) {
            jsonTreeEncoder = new JsonTreeListEncoder(json, nodeConsumer);
        } else if (Intrinsics.b(serialKindD, StructureKind.MAP.f55767a)) {
            SerialDescriptor serialDescriptorA = WriteModeKt.a(descriptor.h(0), json.f55946b);
            SerialKind serialKindD2 = serialDescriptorA.d();
            if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.b(serialKindD2, SerialKind.ENUM.f55764a)) {
                Intrinsics.checkNotNullParameter(json, "json");
                Intrinsics.checkNotNullParameter(nodeConsumer, "nodeConsumer");
                JsonTreeMapEncoder jsonTreeMapEncoder = new JsonTreeMapEncoder(json, nodeConsumer);
                jsonTreeMapEncoder.f56070h = true;
                jsonTreeEncoder = jsonTreeMapEncoder;
            } else {
                if (!json.f55945a.f55969d) {
                    throw JsonExceptionsKt.b(serialDescriptorA);
                }
                jsonTreeEncoder = new JsonTreeListEncoder(json, nodeConsumer);
            }
        } else {
            jsonTreeEncoder = new JsonTreeEncoder(json, nodeConsumer);
        }
        String str = this.f56016e;
        if (str != null) {
            jsonTreeEncoder.Z(str, JsonElementKt.b(descriptor.i()));
            this.f56016e = null;
        }
        return jsonTreeEncoder;
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json d() {
        return this.f56013b;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(kotlinx.serialization.SerializationStrategy r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.ArrayList r0 = r4.f55909a
            java.lang.Object r0 = kotlin.collections.CollectionsKt.G(r0)
            kotlinx.serialization.json.Json r1 = r4.f56013b
            if (r0 != 0) goto L34
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r5.a()
            kotlinx.serialization.modules.SerialModuleImpl r2 = r1.f55946b
            kotlinx.serialization.descriptors.SerialDescriptor r0 = kotlinx.serialization.json.internal.WriteModeKt.a(r0, r2)
            kotlinx.serialization.descriptors.SerialKind r2 = r0.d()
            boolean r2 = r2 instanceof kotlinx.serialization.descriptors.PrimitiveKind
            if (r2 != 0) goto L29
            kotlinx.serialization.descriptors.SerialKind r0 = r0.d()
            kotlinx.serialization.descriptors.SerialKind$ENUM r2 = kotlinx.serialization.descriptors.SerialKind.ENUM.f55764a
            if (r0 != r2) goto L34
        L29:
            kotlinx.serialization.json.internal.JsonPrimitiveEncoder r0 = new kotlinx.serialization.json.internal.JsonPrimitiveEncoder
            kotlin.jvm.functions.Function1 r2 = r4.f56014c
            r0.<init>(r1, r2)
            r0.e(r5, r6)
            return
        L34:
            kotlinx.serialization.json.JsonConfiguration r0 = r1.f55945a
            boolean r2 = r5 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r2 == 0) goto L41
            kotlinx.serialization.json.ClassDiscriminatorMode r0 = r0.f55976k
            kotlinx.serialization.json.ClassDiscriminatorMode r3 = kotlinx.serialization.json.ClassDiscriminatorMode.f55938a
            if (r0 == r3) goto L77
            goto L6e
        L41:
            kotlinx.serialization.json.ClassDiscriminatorMode r0 = r0.f55976k
            int r0 = r0.ordinal()
            if (r0 == 0) goto L77
            r3 = 1
            if (r0 == r3) goto L56
            r1 = 2
            if (r0 != r1) goto L50
            goto L77
        L50:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L56:
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r5.a()
            kotlinx.serialization.descriptors.SerialKind r0 = r0.d()
            kotlinx.serialization.descriptors.StructureKind$CLASS r3 = kotlinx.serialization.descriptors.StructureKind.CLASS.f55765a
            boolean r3 = kotlin.jvm.internal.Intrinsics.b(r0, r3)
            if (r3 != 0) goto L6e
            kotlinx.serialization.descriptors.StructureKind$OBJECT r3 = kotlinx.serialization.descriptors.StructureKind.OBJECT.f55768a
            boolean r0 = kotlin.jvm.internal.Intrinsics.b(r0, r3)
            if (r0 == 0) goto L77
        L6e:
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r5.a()
            java.lang.String r0 = kotlinx.serialization.json.internal.PolymorphicKt.c(r0, r1)
            goto L78
        L77:
            r0 = 0
        L78:
            if (r2 == 0) goto Lb6
            r1 = r5
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r1 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r1
            if (r6 == 0) goto L95
            kotlinx.serialization.SerializationStrategy r1 = kotlinx.serialization.PolymorphicSerializerKt.b(r1, r4, r6)
            if (r0 == 0) goto L88
            kotlinx.serialization.json.internal.PolymorphicKt.a(r5, r1, r0)
        L88:
            kotlinx.serialization.descriptors.SerialDescriptor r5 = r1.a()
            kotlinx.serialization.descriptors.SerialKind r5 = r5.d()
            kotlinx.serialization.json.internal.PolymorphicKt.b(r5)
            r5 = r1
            goto Lb6
        L95:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Value for serializer "
            r6.<init>(r0)
            kotlinx.serialization.descriptors.SerialDescriptor r5 = r5.a()
            r6.append(r5)
            java.lang.String r5 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        Lb6:
            if (r0 == 0) goto Lba
            r4.f56016e = r0
        Lba:
            r5.c(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final Encoder n(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return CollectionsKt.G(this.f55909a) != null ? super.n(descriptor) : new JsonPrimitiveEncoder(this.f56013b, this.f56014c).n(descriptor);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final void q() {
        String tag = (String) CollectionsKt.G(this.f55909a);
        if (tag == null) {
            this.f56014c.invoke(JsonNull.INSTANCE);
        } else {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Z(tag, JsonNull.INSTANCE);
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final void v() {
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final void z(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        e(JsonElementSerializer.f55978a, element);
    }
}
