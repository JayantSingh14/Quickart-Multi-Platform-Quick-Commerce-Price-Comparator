package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ClientInfo {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract ClientInfo a();

        public abstract Builder b(AndroidClientInfo androidClientInfo);

        public abstract Builder c();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ClientType {

        /* renamed from: a, reason: collision with root package name */
        public static final ClientType f20666a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ClientType[] f20667b;

        /* JADX INFO: Fake field, exist only in values array */
        ClientType EF0;

        static {
            ClientType clientType = new ClientType("UNKNOWN", 0);
            ClientType clientType2 = new ClientType("ANDROID_FIREBASE", 1);
            f20666a = clientType2;
            f20667b = new ClientType[]{clientType, clientType2};
        }

        public static ClientType valueOf(String str) {
            return (ClientType) Enum.valueOf(ClientType.class, str);
        }

        public static ClientType[] values() {
            return (ClientType[]) f20667b.clone();
        }
    }

    public static Builder a() {
        return new AutoValue_ClientInfo.Builder();
    }

    public abstract AndroidClientInfo b();

    public abstract ClientType c();
}
