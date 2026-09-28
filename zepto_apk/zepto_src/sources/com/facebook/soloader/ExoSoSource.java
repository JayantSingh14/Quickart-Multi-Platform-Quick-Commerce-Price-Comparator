package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ExoSoSource extends UnpackingSoSource {

    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {

        /* renamed from: a, reason: collision with root package name */
        public final FileDso[] f20266a;

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00e9, code lost:
        
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r11 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ExoUnpacker(com.facebook.soloader.ExoSoSource r18, com.facebook.soloader.ExoSoSource r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.ExoSoSource):void");
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.Dso[] b() {
            return this.f20266a;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final void c(File file) throws IOException {
            byte[] bArr = new byte[32768];
            for (FileDso fileDso : this.f20266a) {
                FileInputStream fileInputStream = new FileInputStream(fileDso.f20267c);
                try {
                    UnpackingSoSource.InputDso inputDso = new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                    fileInputStream = null;
                    try {
                        UnpackingSoSource.Unpacker.a(inputDso, bArr, file);
                        inputDso.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        }
    }

    public static final class FileDso extends UnpackingSoSource.Dso {

        /* renamed from: c, reason: collision with root package name */
        public final File f20267c;

        public FileDso(File file, String str, String str2) {
            super(str, str2);
            this.f20267c = file;
        }
    }

    public ExoSoSource(Context context) {
        super(context, "lib-main", true);
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final String c() {
        return "ExoSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Unpacker h() {
        return new ExoUnpacker(this, this);
    }
}
