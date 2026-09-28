package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
class NativeSessionFileGzipper {
    public static void a(File file, InputStream inputStream) throws Throwable {
        byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        gZIPOutputStream2.finish();
                        CommonUtils.c(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.c(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(File file, ArrayList arrayList) throws IOException {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            NativeSessionFile nativeSessionFile = (NativeSessionFile) it.next();
            InputStream inputStreamJ = null;
            try {
                inputStreamJ = nativeSessionFile.j();
                if (inputStreamJ != null) {
                    a(new File(file, nativeSessionFile.b()), inputStreamJ);
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.c(null);
                throw th;
            }
            CommonUtils.c(inputStreamJ);
        }
    }
}
