package androidx.datastore.preferences.protobuf;

import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class RuntimeVersion {

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RuntimeDomain {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RuntimeDomain[] f4137a = {new RuntimeDomain("GOOGLE_INTERNAL", 0), new RuntimeDomain("PUBLIC", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        RuntimeDomain EF5;

        public static RuntimeDomain valueOf(String str) {
            return (RuntimeDomain) java.lang.Enum.valueOf(RuntimeDomain.class, str);
        }

        public static RuntimeDomain[] values() {
            return (RuntimeDomain[]) f4137a.clone();
        }
    }

    static {
        String.format("%d.%d.%d%s", 4, 28, 2, "");
        Logger.getLogger(RuntimeVersion.class.getName());
    }
}
