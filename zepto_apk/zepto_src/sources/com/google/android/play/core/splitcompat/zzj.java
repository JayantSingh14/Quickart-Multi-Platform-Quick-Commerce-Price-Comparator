package com.google.android.play.core.splitcompat;

import android.support.v4.media.a;
import android.support.v4.media.b;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
final class zzj implements zzl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashSet f41919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzt f41920b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ZipFile f41921c;

    public zzj(HashSet hashSet, zzt zztVar, ZipFile zipFile) {
        this.f41919a = hashSet;
        this.f41920b = zztVar;
        this.f41921c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.zzl
    public final void a(zzm zzmVar, File file, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        this.f41919a.add(file);
        if (z) {
            return;
        }
        zzt zztVar = this.f41920b;
        String strB = zztVar.b();
        String absolutePath = zztVar.a().getAbsolutePath();
        ZipEntry zipEntry = zzmVar.f41923b;
        String name = zipEntry.getName();
        String absolutePath2 = file.getAbsolutePath();
        StringBuilder sbY = b.y("NativeLibraryExtractor: split '", strB, "' has native library '");
        b.B(sbY, zzmVar.f41922a, "' that does not exist; extracting from '", absolutePath, "!");
        Log.i("SplitCompat", a.n(sbY, name, "' to '", absolutePath2, "'"));
        byte[] bArr = new byte[4096];
        if (file.exists()) {
            file.delete();
        }
        InputStream inputStream = this.f41921c.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                file.setWritable(false, true);
                file.setWritable(false, false);
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
            } finally {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
            }
            throw th;
        }
    }
}
