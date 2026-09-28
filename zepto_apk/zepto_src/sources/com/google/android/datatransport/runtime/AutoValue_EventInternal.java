package com.google.android.datatransport.runtime;

import android.support.v4.media.b;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a, reason: collision with root package name */
    public final String f20697a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f20698b;

    /* renamed from: c, reason: collision with root package name */
    public final EncodedPayload f20699c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20700d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20701e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f20702f;

    /* renamed from: g, reason: collision with root package name */
    public final Integer f20703g;

    /* renamed from: h, reason: collision with root package name */
    public final String f20704h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f20705i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f20706j;

    public static final class Builder extends EventInternal.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f20707a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f20708b;

        /* renamed from: c, reason: collision with root package name */
        public EncodedPayload f20709c;

        /* renamed from: d, reason: collision with root package name */
        public Long f20710d;

        /* renamed from: e, reason: collision with root package name */
        public Long f20711e;

        /* renamed from: f, reason: collision with root package name */
        public HashMap f20712f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f20713g;

        /* renamed from: h, reason: collision with root package name */
        public String f20714h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f20715i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f20716j;

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal b() {
            String strK = this.f20707a == null ? " transportName" : "";
            if (this.f20709c == null) {
                strK = strK.concat(" encodedPayload");
            }
            if (this.f20710d == null) {
                strK = b.k(strK, " eventMillis");
            }
            if (this.f20711e == null) {
                strK = b.k(strK, " uptimeMillis");
            }
            if (this.f20712f == null) {
                strK = b.k(strK, " autoMetadata");
            }
            if (strK.isEmpty()) {
                return new AutoValue_EventInternal(this.f20707a, this.f20708b, this.f20709c, this.f20710d.longValue(), this.f20711e.longValue(), this.f20712f, this.f20713g, this.f20714h, this.f20715i, this.f20716j);
            }
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final Map c() {
            HashMap map = this.f20712f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder d(Integer num) {
            this.f20708b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder e(EncodedPayload encodedPayload) {
            if (encodedPayload == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f20709c = encodedPayload;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder f(long j2) {
            this.f20710d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder g(byte[] bArr) {
            this.f20715i = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder h(byte[] bArr) {
            this.f20716j = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder i(Integer num) {
            this.f20713g = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder j(String str) {
            this.f20714h = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder k(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f20707a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public final EventInternal.Builder l(long j2) {
            this.f20711e = Long.valueOf(j2);
            return this;
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j2, long j3, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f20697a = str;
        this.f20698b = num;
        this.f20699c = encodedPayload;
        this.f20700d = j2;
        this.f20701e = j3;
        this.f20702f = map;
        this.f20703g = num2;
        this.f20704h = str2;
        this.f20705i = bArr;
        this.f20706j = bArr2;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final Map c() {
        return this.f20702f;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final Integer d() {
        return this.f20698b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final EncodedPayload e() {
        return this.f20699c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (!this.f20697a.equals(eventInternal.l())) {
            return false;
        }
        Integer num = this.f20698b;
        if (num == null) {
            if (eventInternal.d() != null) {
                return false;
            }
        } else if (!num.equals(eventInternal.d())) {
            return false;
        }
        if (!this.f20699c.equals(eventInternal.e()) || this.f20700d != eventInternal.f() || this.f20701e != eventInternal.m() || !this.f20702f.equals(eventInternal.c())) {
            return false;
        }
        Integer num2 = this.f20703g;
        if (num2 == null) {
            if (eventInternal.j() != null) {
                return false;
            }
        } else if (!num2.equals(eventInternal.j())) {
            return false;
        }
        String str = this.f20704h;
        if (str == null) {
            if (eventInternal.k() != null) {
                return false;
            }
        } else if (!str.equals(eventInternal.k())) {
            return false;
        }
        boolean z = eventInternal instanceof AutoValue_EventInternal;
        if (Arrays.equals(this.f20705i, z ? ((AutoValue_EventInternal) eventInternal).f20705i : eventInternal.g())) {
            return Arrays.equals(this.f20706j, z ? ((AutoValue_EventInternal) eventInternal).f20706j : eventInternal.h());
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final long f() {
        return this.f20700d;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final byte[] g() {
        return this.f20705i;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final byte[] h() {
        return this.f20706j;
    }

    public final int hashCode() {
        int iHashCode = (this.f20697a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f20698b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f20699c.hashCode()) * 1000003;
        long j2 = this.f20700d;
        int i2 = (iHashCode2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f20701e;
        int iHashCode3 = (((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f20702f.hashCode()) * 1000003;
        Integer num2 = this.f20703g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f20704h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f20705i)) * 1000003) ^ Arrays.hashCode(this.f20706j);
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final Integer j() {
        return this.f20703g;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final String k() {
        return this.f20704h;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final String l() {
        return this.f20697a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public final long m() {
        return this.f20701e;
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f20697a + ", code=" + this.f20698b + ", encodedPayload=" + this.f20699c + ", eventMillis=" + this.f20700d + ", uptimeMillis=" + this.f20701e + ", autoMetadata=" + this.f20702f + ", productId=" + this.f20703g + ", pseudonymousId=" + this.f20704h + ", experimentIdsClear=" + Arrays.toString(this.f20705i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f20706j) + "}";
    }
}
