package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;
import org.xbill.DNS.Message;

/* loaded from: classes3.dex */
public class ExtensionRegistryLite {

    /* renamed from: b, reason: collision with root package name */
    public static volatile ExtensionRegistryLite f3948b;

    /* renamed from: c, reason: collision with root package name */
    public static final ExtensionRegistryLite f3949c = new ExtensionRegistryLite();

    /* renamed from: a, reason: collision with root package name */
    public final Map f3950a = Collections.EMPTY_MAP;

    public static class ExtensionClassHolder {
        static {
            try {
                Class.forName("androidx.datastore.preferences.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static final class ObjectIntPair {

        /* renamed from: a, reason: collision with root package name */
        public final MessageLite f3951a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3952b;

        public ObjectIntPair(int i2, MessageLite messageLite) {
            this.f3951a = messageLite;
            this.f3952b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f3951a == objectIntPair.f3951a && this.f3952b == objectIntPair.f3952b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f3951a) * Message.MAXLENGTH) + this.f3952b;
        }
    }

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite extensionRegistryLite;
        Protobuf protobuf = Protobuf.f4112c;
        ExtensionRegistryLite extensionRegistryLite2 = f3948b;
        if (extensionRegistryLite2 != null) {
            return extensionRegistryLite2;
        }
        synchronized (ExtensionRegistryLite.class) {
            try {
                extensionRegistryLite = f3948b;
                if (extensionRegistryLite == null) {
                    Class cls = ExtensionRegistryFactory.f3947a;
                    ExtensionRegistryLite extensionRegistryLite3 = null;
                    if (cls != null) {
                        try {
                            extensionRegistryLite3 = (ExtensionRegistryLite) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    extensionRegistryLite = extensionRegistryLite3 != null ? extensionRegistryLite3 : f3949c;
                    f3948b = extensionRegistryLite;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return extensionRegistryLite;
    }
}
