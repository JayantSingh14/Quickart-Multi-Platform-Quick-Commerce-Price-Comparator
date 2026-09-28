package ch.qos.logback.core.joran.spi;

/* loaded from: classes3.dex */
public class HostClassAndPropertyDouble {

    /* renamed from: a, reason: collision with root package name */
    public final Class f13560a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13561b;

    public HostClassAndPropertyDouble(Class cls, String str) {
        this.f13560a = cls;
        this.f13561b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HostClassAndPropertyDouble hostClassAndPropertyDouble = (HostClassAndPropertyDouble) obj;
        Class cls = hostClassAndPropertyDouble.f13560a;
        Class cls2 = this.f13560a;
        if (cls2 == null) {
            if (cls != null) {
                return false;
            }
        } else if (!cls2.equals(cls)) {
            return false;
        }
        String str = hostClassAndPropertyDouble.f13561b;
        String str2 = this.f13561b;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Class cls = this.f13560a;
        int iHashCode = ((cls == null ? 0 : cls.hashCode()) + 31) * 31;
        String str = this.f13561b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
