package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class ProgramInformation {

    /* renamed from: a, reason: collision with root package name */
    public final String f6826a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6827b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6828c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6829d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6830e;

    public ProgramInformation(String str, String str2, String str3, String str4, String str5) {
        this.f6826a = str;
        this.f6827b = str2;
        this.f6828c = str3;
        this.f6829d = str4;
        this.f6830e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInformation)) {
            return false;
        }
        ProgramInformation programInformation = (ProgramInformation) obj;
        return Util.a(this.f6826a, programInformation.f6826a) && Util.a(this.f6827b, programInformation.f6827b) && Util.a(this.f6828c, programInformation.f6828c) && Util.a(this.f6829d, programInformation.f6829d) && Util.a(this.f6830e, programInformation.f6830e);
    }

    public final int hashCode() {
        String str = this.f6826a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6827b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6828c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f6829d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f6830e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
