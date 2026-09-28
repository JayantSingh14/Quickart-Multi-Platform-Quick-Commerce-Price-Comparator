package com.google.firebase.sessions.api;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface SessionSubscriber {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Name {

        /* renamed from: a, reason: collision with root package name */
        public static final Name f45138a;

        /* renamed from: b, reason: collision with root package name */
        public static final Name f45139b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Name[] f45140c;

        static {
            Name name = new Name("CRASHLYTICS", 0);
            f45138a = name;
            Name name2 = new Name("PERFORMANCE", 1);
            f45139b = name2;
            f45140c = new Name[]{name, name2, new Name("MATT_SAYS_HI", 2)};
        }

        public static Name valueOf(String str) {
            return (Name) Enum.valueOf(Name.class, str);
        }

        public static Name[] values() {
            return (Name[]) f45140c.clone();
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class SessionDetails {

        /* renamed from: a, reason: collision with root package name */
        public final String f45141a;

        public SessionDetails(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.f45141a = sessionId;
        }

        public final String a() {
            return this.f45141a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && Intrinsics.b(this.f45141a, ((SessionDetails) obj).f45141a);
        }

        public final int hashCode() {
            return this.f45141a.hashCode();
        }

        public final String toString() {
            return e.t(new StringBuilder("SessionDetails(sessionId="), this.f45141a, ')');
        }
    }

    boolean a();

    void b(SessionDetails sessionDetails);
}
