package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.FilesPayload.File {

    /* renamed from: a, reason: collision with root package name */
    public final String f44152a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f44153b;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.FilesPayload.File.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44154a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f44155b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public final CrashlyticsReport.FilesPayload.File a() {
            byte[] bArr;
            String str = this.f44154a;
            if (str != null && (bArr = this.f44155b) != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44154a == null) {
                sb.append(" filename");
            }
            if (this.f44155b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public final CrashlyticsReport.FilesPayload.File.Builder b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f44155b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public final CrashlyticsReport.FilesPayload.File.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f44154a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.f44152a = str;
        this.f44153b = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    public final byte[] b() {
        return this.f44153b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    public final String c() {
        return this.f44152a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload.File)) {
            return false;
        }
        CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
        if (this.f44152a.equals(file.c())) {
            return Arrays.equals(this.f44153b, file instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) file).f44153b : file.b());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f44152a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f44153b);
    }

    public final String toString() {
        return "File{filename=" + this.f44152a + ", contents=" + Arrays.toString(this.f44153b) + "}";
    }
}
