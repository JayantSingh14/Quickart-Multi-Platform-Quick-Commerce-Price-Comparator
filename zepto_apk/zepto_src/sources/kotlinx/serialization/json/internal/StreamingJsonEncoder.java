package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final Composer f56095a;

    /* renamed from: b, reason: collision with root package name */
    public final Json f56096b;

    /* renamed from: c, reason: collision with root package name */
    public final WriteMode f56097c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonEncoder[] f56098d;

    /* renamed from: e, reason: collision with root package name */
    public final SerialModuleImpl f56099e;

    /* renamed from: f, reason: collision with root package name */
    public final JsonConfiguration f56100f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f56101g;

    /* renamed from: h, reason: collision with root package name */
    public String f56102h;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                WriteMode writeMode = WriteMode.f56108c;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                WriteMode writeMode2 = WriteMode.f56108c;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f56095a = composer;
        this.f56096b = json;
        this.f56097c = mode;
        this.f56098d = jsonEncoderArr;
        this.f56099e = json.f55946b;
        this.f56100f = json.f55945a;
        int iOrdinal = mode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[iOrdinal];
            if (jsonEncoder == null && jsonEncoder == this) {
                return;
            }
            jsonEncoderArr[iOrdinal] = this;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void A(int i2) {
        if (this.f56101g) {
            F(String.valueOf(i2));
        } else {
            this.f56095a.f(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final boolean D(PluginGeneratedSerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.f56100f.f55966a;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void F(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f56095a.j(value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public final void G(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int iOrdinal = this.f56097c.ordinal();
        boolean z = true;
        Composer composer = this.f56095a;
        if (iOrdinal == 1) {
            if (!composer.f56034b) {
                composer.e(',');
            }
            composer.b();
            return;
        }
        if (iOrdinal == 2) {
            if (composer.f56034b) {
                this.f56101g = true;
                composer.b();
                return;
            }
            if (i2 % 2 == 0) {
                composer.e(',');
                composer.b();
            } else {
                composer.e(':');
                composer.k();
                z = false;
            }
            this.f56101g = z;
            return;
        }
        if (iOrdinal != 3) {
            if (!composer.f56034b) {
                composer.e(',');
            }
            composer.b();
            F(JsonNamesMapKt.b(descriptor, this.f56096b, i2));
            composer.e(':');
            composer.k();
            return;
        }
        if (i2 == 0) {
            this.f56101g = true;
        }
        if (i2 == 1) {
            composer.e(',');
            composer.k();
            this.f56101g = false;
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final SerializersModule a() {
        return this.f56099e;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder b(SerialDescriptor descriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Json json = this.f56096b;
        WriteMode writeModeB = WriteModeKt.b(descriptor, json);
        Composer composer = this.f56095a;
        composer.e(writeModeB.f56114a);
        composer.a();
        if (this.f56102h != null) {
            composer.b();
            String str = this.f56102h;
            Intrinsics.c(str);
            F(str);
            composer.e(':');
            composer.k();
            F(descriptor.i());
            this.f56102h = null;
        }
        if (this.f56097c == writeModeB) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.f56098d;
        return (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[writeModeB.ordinal()]) == null) ? new StreamingJsonEncoder(composer, json, writeModeB, jsonEncoderArr) : jsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode writeMode = this.f56097c;
        char c2 = writeMode.f56115b;
        Composer composer = this.f56095a;
        composer.l();
        composer.c();
        composer.e(writeMode.f56115b);
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json d() {
        return this.f56096b;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(kotlinx.serialization.SerializationStrategy r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlinx.serialization.json.Json r0 = r4.f56096b
            kotlinx.serialization.json.JsonConfiguration r1 = r0.f55945a
            boolean r2 = r5 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r2 == 0) goto L14
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.f55976k
            kotlinx.serialization.json.ClassDiscriminatorMode r3 = kotlinx.serialization.json.ClassDiscriminatorMode.f55938a
            if (r1 == r3) goto L4a
            goto L41
        L14:
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.f55976k
            int r1 = r1.ordinal()
            if (r1 == 0) goto L4a
            r3 = 1
            if (r1 == r3) goto L29
            r0 = 2
            if (r1 != r0) goto L23
            goto L4a
        L23:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L29:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r5.a()
            kotlinx.serialization.descriptors.SerialKind r1 = r1.d()
            kotlinx.serialization.descriptors.StructureKind$CLASS r3 = kotlinx.serialization.descriptors.StructureKind.CLASS.f55765a
            boolean r3 = kotlin.jvm.internal.Intrinsics.b(r1, r3)
            if (r3 != 0) goto L41
            kotlinx.serialization.descriptors.StructureKind$OBJECT r3 = kotlinx.serialization.descriptors.StructureKind.OBJECT.f55768a
            boolean r1 = kotlin.jvm.internal.Intrinsics.b(r1, r3)
            if (r1 == 0) goto L4a
        L41:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r5.a()
            java.lang.String r0 = kotlinx.serialization.json.internal.PolymorphicKt.c(r1, r0)
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r2 == 0) goto L89
            r1 = r5
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r1 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r1
            if (r6 == 0) goto L68
            kotlinx.serialization.SerializationStrategy r1 = kotlinx.serialization.PolymorphicSerializerKt.b(r1, r4, r6)
            if (r0 == 0) goto L5b
            kotlinx.serialization.json.internal.PolymorphicKt.a(r5, r1, r0)
        L5b:
            kotlinx.serialization.descriptors.SerialDescriptor r5 = r1.a()
            kotlinx.serialization.descriptors.SerialKind r5 = r5.d()
            kotlinx.serialization.json.internal.PolymorphicKt.b(r5)
            r5 = r1
            goto L89
        L68:
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
        L89:
            if (r0 == 0) goto L8d
            r4.f56102h = r0
        L8d:
            r5.c(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void f(double d2) {
        boolean z = this.f56101g;
        Composer composer = this.f56095a;
        if (z) {
            F(String.valueOf(d2));
        } else {
            composer.f56033a.c(String.valueOf(d2));
        }
        if (this.f56100f.f55974i) {
            return;
        }
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw JsonExceptionsKt.a(Double.valueOf(d2), composer.f56033a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void h(byte b2) {
        if (this.f56101g) {
            F(String.valueOf((int) b2));
        } else {
            this.f56095a.d(b2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void m(SerialDescriptor enumDescriptor, int i2) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        F(enumDescriptor.f(i2));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final Encoder n(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        boolean zB = StreamingJsonEncoderKt.b(descriptor);
        WriteMode writeMode = this.f56097c;
        Json json = this.f56096b;
        Composer composerForUnquotedLiterals = this.f56095a;
        if (zB) {
            if (!(composerForUnquotedLiterals instanceof ComposerForUnsignedNumbers)) {
                composerForUnquotedLiterals = new ComposerForUnsignedNumbers(composerForUnquotedLiterals.f56033a, this.f56101g);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
        }
        if (!StreamingJsonEncoderKt.a(descriptor)) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return this;
        }
        if (!(composerForUnquotedLiterals instanceof ComposerForUnquotedLiterals)) {
            composerForUnquotedLiterals = new ComposerForUnquotedLiterals(composerForUnquotedLiterals.f56033a, this.f56101g);
        }
        return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void o(long j2) {
        if (this.f56101g) {
            F(String.valueOf(j2));
        } else {
            this.f56095a.g(j2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void q() {
        this.f56095a.h("null");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void r(short s) {
        if (this.f56101g) {
            F(String.valueOf((int) s));
        } else {
            this.f56095a.i(s);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void s(boolean z) {
        if (this.f56101g) {
            F(String.valueOf(z));
        } else {
            this.f56095a.f56033a.c(String.valueOf(z));
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void t(float f2) {
        boolean z = this.f56101g;
        Composer composer = this.f56095a;
        if (z) {
            F(String.valueOf(f2));
        } else {
            composer.f56033a.c(String.valueOf(f2));
        }
        if (this.f56100f.f55974i) {
            return;
        }
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw JsonExceptionsKt.a(Float.valueOf(f2), composer.f56033a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void u(char c2) {
        F(String.valueOf(c2));
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final void z(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        e(JsonElementSerializer.f55978a, element);
    }
}
