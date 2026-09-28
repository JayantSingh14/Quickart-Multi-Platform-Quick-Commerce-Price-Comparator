package androidx.datastore.preferences.protobuf;

/* loaded from: classes3.dex */
public class LazyFieldLite {

    /* renamed from: a, reason: collision with root package name */
    public volatile MessageLite f4059a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ByteString f4060b;

    public final MessageLite a(MessageLite messageLite) {
        if (this.f4059a == null) {
            synchronized (this) {
                if (this.f4059a == null) {
                    try {
                        this.f4059a = messageLite;
                        this.f4060b = ByteString.f3748b;
                    } catch (InvalidProtocolBufferException unused) {
                        this.f4059a = messageLite;
                        this.f4060b = ByteString.f3748b;
                    }
                }
            }
        }
        return this.f4059a;
    }

    public final ByteString b() {
        if (this.f4060b != null) {
            return this.f4060b;
        }
        synchronized (this) {
            try {
                if (this.f4060b != null) {
                    return this.f4060b;
                }
                if (this.f4059a == null) {
                    this.f4060b = ByteString.f3748b;
                } else {
                    this.f4060b = this.f4059a.b();
                }
                return this.f4060b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f4059a;
        MessageLite messageLite2 = lazyFieldLite.f4059a;
        return (messageLite == null && messageLite2 == null) ? b().equals(lazyFieldLite.b()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.a(messageLite.f())) : a(messageLite2.f()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
