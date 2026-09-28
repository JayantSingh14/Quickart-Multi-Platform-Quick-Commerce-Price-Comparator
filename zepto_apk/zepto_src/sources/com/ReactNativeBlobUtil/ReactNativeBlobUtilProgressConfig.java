package com.ReactNativeBlobUtil;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilProgressConfig {

    /* renamed from: a, reason: collision with root package name */
    public long f13967a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f13968b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f13969c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13970d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ReportType {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReportType[] f13971a = {new ReportType("Upload", 0), new ReportType("Download", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        ReportType EF5;

        public static ReportType valueOf(String str) {
            return (ReportType) Enum.valueOf(ReportType.class, str);
        }

        public static ReportType[] values() {
            return (ReportType[]) f13971a.clone();
        }
    }

    public ReactNativeBlobUtilProgressConfig(int i2, int i3) {
        this.f13970d = i2;
        this.f13969c = i3;
    }

    public final boolean a(float f2) {
        int i2 = this.f13969c;
        boolean z = false;
        boolean z2 = i2 <= 0 || f2 <= 0.0f || Math.floor((double) (f2 * ((float) i2))) > ((double) this.f13968b);
        if (System.currentTimeMillis() - this.f13967a > this.f13970d && z2) {
            z = true;
        }
        if (z) {
            this.f13968b++;
            this.f13967a = System.currentTimeMillis();
        }
        return z;
    }
}
