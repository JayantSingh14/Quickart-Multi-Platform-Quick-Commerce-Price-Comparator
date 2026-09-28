package kotlinx.serialization.json;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata
/* loaded from: classes.dex */
public final class JsonElementSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final JsonElementSerializer$descriptor$1 f55980c = new JsonElementSerializer$descriptor$1(1);

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonElementSerializer$descriptor$1$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function0<SerialDescriptor> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55981c = new AnonymousClass1(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonPrimitiveSerializer.f56005b;
        }
    }

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonElementSerializer$descriptor$1$2, reason: invalid class name */
    final class AnonymousClass2 extends Lambda implements Function0<SerialDescriptor> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f55982c = new AnonymousClass2(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonNullSerializer.f55995b;
        }
    }

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonElementSerializer$descriptor$1$3, reason: invalid class name */
    final class AnonymousClass3 extends Lambda implements Function0<SerialDescriptor> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass3 f55983c = new AnonymousClass3(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonLiteralSerializer.f55991b;
        }
    }

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonElementSerializer$descriptor$1$4, reason: invalid class name */
    final class AnonymousClass4 extends Lambda implements Function0<SerialDescriptor> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass4 f55984c = new AnonymousClass4(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonObjectSerializer.f56000b;
        }
    }

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonElementSerializer$descriptor$1$5, reason: invalid class name */
    final class AnonymousClass5 extends Lambda implements Function0<SerialDescriptor> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass5 f55985c = new AnonymousClass5(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonArraySerializer.f55950b;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        final AnonymousClass1 anonymousClass1 = AnonymousClass1.f55981c;
        SerialDescriptor serialDescriptor = new SerialDescriptor(anonymousClass1) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f55986a;

            {
                this.f55986a = LazyKt.b(anonymousClass1);
            }

            public final SerialDescriptor a() {
                return (SerialDescriptor) this.f55986a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean b() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String f(int i2) {
                return a().f(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List g(int i2) {
                return a().g(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List getAnnotations() {
                return EmptyList.f53609a;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialDescriptor h(int i2) {
                return a().h(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean isInline() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean j(int i2) {
                return a().j(i2);
            }
        };
        EmptyList emptyList = EmptyList.f53609a;
        buildSerialDescriptor.a("JsonPrimitive", serialDescriptor, emptyList, false);
        final AnonymousClass2 anonymousClass2 = AnonymousClass2.f55982c;
        buildSerialDescriptor.a("JsonNull", new SerialDescriptor(anonymousClass2) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f55986a;

            {
                this.f55986a = LazyKt.b(anonymousClass2);
            }

            public final SerialDescriptor a() {
                return (SerialDescriptor) this.f55986a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean b() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String f(int i2) {
                return a().f(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List g(int i2) {
                return a().g(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List getAnnotations() {
                return EmptyList.f53609a;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialDescriptor h(int i2) {
                return a().h(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean isInline() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean j(int i2) {
                return a().j(i2);
            }
        }, emptyList, false);
        final AnonymousClass3 anonymousClass3 = AnonymousClass3.f55983c;
        buildSerialDescriptor.a("JsonLiteral", new SerialDescriptor(anonymousClass3) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f55986a;

            {
                this.f55986a = LazyKt.b(anonymousClass3);
            }

            public final SerialDescriptor a() {
                return (SerialDescriptor) this.f55986a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean b() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String f(int i2) {
                return a().f(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List g(int i2) {
                return a().g(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List getAnnotations() {
                return EmptyList.f53609a;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialDescriptor h(int i2) {
                return a().h(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean isInline() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean j(int i2) {
                return a().j(i2);
            }
        }, emptyList, false);
        final AnonymousClass4 anonymousClass4 = AnonymousClass4.f55984c;
        buildSerialDescriptor.a("JsonObject", new SerialDescriptor(anonymousClass4) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f55986a;

            {
                this.f55986a = LazyKt.b(anonymousClass4);
            }

            public final SerialDescriptor a() {
                return (SerialDescriptor) this.f55986a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean b() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String f(int i2) {
                return a().f(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List g(int i2) {
                return a().g(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List getAnnotations() {
                return EmptyList.f53609a;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialDescriptor h(int i2) {
                return a().h(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean isInline() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean j(int i2) {
                return a().j(i2);
            }
        }, emptyList, false);
        final AnonymousClass5 anonymousClass5 = AnonymousClass5.f55985c;
        buildSerialDescriptor.a("JsonArray", new SerialDescriptor(anonymousClass5) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f55986a;

            {
                this.f55986a = LazyKt.b(anonymousClass5);
            }

            public final SerialDescriptor a() {
                return (SerialDescriptor) this.f55986a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean b() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String f(int i2) {
                return a().f(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List g(int i2) {
                return a().g(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final List getAnnotations() {
                return EmptyList.f53609a;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final SerialDescriptor h(int i2) {
                return a().h(i2);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean isInline() {
                return false;
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public final boolean j(int i2) {
                return a().j(i2);
            }
        }, emptyList, false);
        return Unit.f53572a;
    }
}
