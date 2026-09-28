package com.google.firebase.crashlytics.internal.model;

import android.os.Build;
import android.support.v4.media.b;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes.dex */
final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {

    /* renamed from: a, reason: collision with root package name */
    public final int f44354a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44355b;

    /* renamed from: c, reason: collision with root package name */
    public final int f44356c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44357d;

    /* renamed from: e, reason: collision with root package name */
    public final long f44358e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f44359f;

    /* renamed from: g, reason: collision with root package name */
    public final int f44360g;

    /* renamed from: h, reason: collision with root package name */
    public final String f44361h;

    /* renamed from: i, reason: collision with root package name */
    public final String f44362i;

    public AutoValue_StaticSessionData_DeviceData(int i2, int i3, long j2, long j3, boolean z, int i4) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f44354a = i2;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f44355b = str;
        this.f44356c = i3;
        this.f44357d = j2;
        this.f44358e = j3;
        this.f44359f = z;
        this.f44360g = i4;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f44361h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f44362i = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int a() {
        return this.f44354a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int b() {
        return this.f44356c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long d() {
        return this.f44358e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final boolean e() {
        return this.f44359f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        return this.f44354a == deviceData.a() && this.f44355b.equals(deviceData.g()) && this.f44356c == deviceData.b() && this.f44357d == deviceData.j() && this.f44358e == deviceData.d() && this.f44359f == deviceData.e() && this.f44360g == deviceData.i() && this.f44361h.equals(deviceData.f()) && this.f44362i.equals(deviceData.h());
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String f() {
        return this.f44361h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String g() {
        return this.f44355b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String h() {
        return this.f44362i;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f44354a ^ 1000003) * 1000003) ^ this.f44355b.hashCode()) * 1000003) ^ this.f44356c) * 1000003;
        long j2 = this.f44357d;
        int i2 = (iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f44358e;
        return ((((((((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f44359f ? 1231 : 1237)) * 1000003) ^ this.f44360g) * 1000003) ^ this.f44361h.hashCode()) * 1000003) ^ this.f44362i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int i() {
        return this.f44360g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long j() {
        return this.f44357d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.f44354a);
        sb.append(", model=");
        sb.append(this.f44355b);
        sb.append(", availableProcessors=");
        sb.append(this.f44356c);
        sb.append(", totalRam=");
        sb.append(this.f44357d);
        sb.append(", diskSpace=");
        sb.append(this.f44358e);
        sb.append(", isEmulator=");
        sb.append(this.f44359f);
        sb.append(", state=");
        sb.append(this.f44360g);
        sb.append(", manufacturer=");
        sb.append(this.f44361h);
        sb.append(", modelClass=");
        return b.r(sb, this.f44362i, "}");
    }
}
