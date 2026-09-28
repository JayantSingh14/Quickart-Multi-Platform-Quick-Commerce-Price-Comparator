package ch.qos.logback.classic.spi;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ClassPackagingData implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f13341a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13342b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13343c = false;

    public ClassPackagingData(String str, String str2) {
        this.f13341a = str;
        this.f13342b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassPackagingData classPackagingData = (ClassPackagingData) obj;
        String str = classPackagingData.f13341a;
        String str2 = this.f13341a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f13343c != classPackagingData.f13343c) {
            return false;
        }
        return this.f13342b.equals(classPackagingData.f13342b);
    }

    public final int hashCode() {
        String str = this.f13341a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public ClassPackagingData(int i2, String str, String str2) {
        this.f13341a = str;
        this.f13342b = str2;
    }
}
