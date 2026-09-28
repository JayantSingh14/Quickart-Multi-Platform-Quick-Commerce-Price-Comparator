package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzgwk {
    public static void a(File file, byte[] bArr) throws IOException {
        file.getClass();
        zzgtn zzgtnVarQ = zzgtn.q(new zzgwh[0]);
        bArr.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file, zzgtnVarQ.contains(zzgwh.f33290a));
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void b(File file) throws IOException {
        file.getClass();
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException("Unable to create parent directories of ".concat(file.toString()));
        }
    }

    public static void c(File file, File file2) throws Throwable {
        file.getClass();
        file2.getClass();
        if (file.equals(file2)) {
            throw new IllegalArgumentException(zzgqr.b("Source %s and destination %s must be different", file, file2));
        }
        if (file.renameTo(file2)) {
            return;
        }
        if (file.equals(file2)) {
            throw new IllegalArgumentException(zzgqr.b("Source %s and destination %s must be different", file, file2));
        }
        zzgtn zzgtnVarQ = zzgtn.q(new zzgwh[0]);
        zzgwg zzgwgVar = new zzgwg();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ArrayDeque arrayDeque = zzgwgVar.f33288a;
            arrayDeque.addFirst(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file2, zzgtnVarQ.contains(zzgwh.f33290a));
            arrayDeque.addFirst(fileOutputStream);
            int i2 = zzgwd.f33286a;
            byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i3);
                }
            }
            zzgwgVar.close();
            if (file.delete()) {
                return;
            }
            if (!file2.delete()) {
                throw new IOException("Unable to delete ".concat(file2.toString()));
            }
            throw new IOException("Unable to delete ".concat(file.toString()));
        } catch (Throwable th) {
            try {
                zzgwgVar.f33289b = th;
                Object obj = zzgqx.f33093a;
                if (IOException.class.isInstance(th)) {
                    throw ((Throwable) IOException.class.cast(th));
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw ((Error) th);
            } catch (Throwable th2) {
                zzgwgVar.close();
                throw th2;
            }
        }
    }
}
