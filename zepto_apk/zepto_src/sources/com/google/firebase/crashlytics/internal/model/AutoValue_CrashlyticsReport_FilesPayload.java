package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {

    /* renamed from: a, reason: collision with root package name */
    public final List f44148a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44149b;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.FilesPayload.Builder {

        /* renamed from: a, reason: collision with root package name */
        public List f44150a;

        /* renamed from: b, reason: collision with root package name */
        public String f44151b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public final CrashlyticsReport.FilesPayload a() {
            List list = this.f44150a;
            if (list != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload(this.f44151b, list);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public final CrashlyticsReport.FilesPayload.Builder b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f44150a = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public final CrashlyticsReport.FilesPayload.Builder c(String str) {
            this.f44151b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_FilesPayload(String str, List list) {
        this.f44148a = list;
        this.f44149b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public final List b() {
        return this.f44148a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public final String c() {
        return this.f44149b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (!this.f44148a.equals(filesPayload.b())) {
            return false;
        }
        String str = this.f44149b;
        return str == null ? filesPayload.c() == null : str.equals(filesPayload.c());
    }

    public final int hashCode() {
        int iHashCode = (this.f44148a.hashCode() ^ 1000003) * 1000003;
        String str = this.f44149b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.f44148a);
        sb.append(", orgId=");
        return b.r(sb, this.f44149b, "}");
    }
}
