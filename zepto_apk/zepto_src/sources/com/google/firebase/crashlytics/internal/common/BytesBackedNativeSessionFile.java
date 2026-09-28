package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
class BytesBackedNativeSessionFile implements NativeSessionFile {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f43735a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43736b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43737c;

    public BytesBackedNativeSessionFile(String str, String str2, byte[] bArr) {
        this.f43736b = str;
        this.f43737c = str2;
        this.f43735a = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public final CrashlyticsReport.FilesPayload.File a() throws IOException {
        byte[] byteArray;
        byte[] bArr = this.f43735a;
        if (bArr == null || bArr.length == 0) {
            byteArray = null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException unused) {
            }
        }
        if (byteArray == null) {
            return null;
        }
        CrashlyticsReport.FilesPayload.File.Builder builderA = CrashlyticsReport.FilesPayload.File.a();
        builderA.b(byteArray);
        builderA.c(this.f43736b);
        return builderA.a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public final String b() {
        return this.f43737c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public final InputStream j() {
        byte[] bArr = this.f43735a;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }
}
