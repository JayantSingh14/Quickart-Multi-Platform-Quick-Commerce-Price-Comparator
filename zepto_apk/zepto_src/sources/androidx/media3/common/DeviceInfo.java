package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
public final class DeviceInfo {

    /* renamed from: e, reason: collision with root package name */
    public static final DeviceInfo f5188e = new Builder(0).a();

    /* renamed from: f, reason: collision with root package name */
    public static final String f5189f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f5190g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f5191h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f5192i;

    /* renamed from: a, reason: collision with root package name */
    public final int f5193a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5194b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5195c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5196d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final int f5197a;

        /* renamed from: b, reason: collision with root package name */
        public int f5198b;

        /* renamed from: c, reason: collision with root package name */
        public int f5199c;

        /* renamed from: d, reason: collision with root package name */
        public String f5200d;

        public Builder(int i2) {
            this.f5197a = i2;
        }

        public final DeviceInfo a() {
            Assertions.a(this.f5198b <= this.f5199c);
            return new DeviceInfo(this);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    static {
        int i2 = Util.f5744a;
        f5189f = Integer.toString(0, 36);
        f5190g = Integer.toString(1, 36);
        f5191h = Integer.toString(2, 36);
        f5192i = Integer.toString(3, 36);
    }

    public DeviceInfo(Builder builder) {
        this.f5193a = builder.f5197a;
        this.f5194b = builder.f5198b;
        this.f5195c = builder.f5199c;
        this.f5196d = builder.f5200d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.f5193a == deviceInfo.f5193a && this.f5194b == deviceInfo.f5194b && this.f5195c == deviceInfo.f5195c && Util.a(this.f5196d, deviceInfo.f5196d);
    }

    public final int hashCode() {
        int i2 = (((((527 + this.f5193a) * 31) + this.f5194b) * 31) + this.f5195c) * 31;
        String str = this.f5196d;
        return i2 + (str == null ? 0 : str.hashCode());
    }
}
