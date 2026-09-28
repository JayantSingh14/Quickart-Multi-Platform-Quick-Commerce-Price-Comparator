package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

@CheckReturnValue
/* loaded from: classes3.dex */
final class ManifestSchemaFactory implements SchemaFactory {

    /* renamed from: b, reason: collision with root package name */
    public static final AnonymousClass1 f4068b = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final CompositeMessageInfoFactory f4069a;

    /* renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements MessageInfoFactory {
        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final MessageInfo a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final boolean b(Class cls) {
            return false;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static {
            try {
                new int[ProtoSyntax.values().length][1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* renamed from: a, reason: collision with root package name */
        public MessageInfoFactory[] f4070a;

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final MessageInfo a(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f4070a) {
                if (messageInfoFactory.b(cls)) {
                    return messageInfoFactory.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final boolean b(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f4070a) {
                if (messageInfoFactory.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ManifestSchemaFactory() {
        MessageInfoFactory messageInfoFactory;
        Protobuf protobuf = Protobuf.f4112c;
        try {
            messageInfoFactory = (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            messageInfoFactory = f4068b;
        }
        MessageInfoFactory[] messageInfoFactoryArr = {GeneratedMessageInfoFactory.f4005a, messageInfoFactory};
        CompositeMessageInfoFactory compositeMessageInfoFactory = new CompositeMessageInfoFactory();
        compositeMessageInfoFactory.f4070a = messageInfoFactoryArr;
        Charset charset = Internal.f4024a;
        this.f4069a = compositeMessageInfoFactory;
    }
}
