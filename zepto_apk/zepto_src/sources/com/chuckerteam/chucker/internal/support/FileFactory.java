package com.chuckerteam.chucker.internal.support;

import com.chuckerteam.chucker.internal.support.Logger;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FileFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicLong f16755a = new AtomicLong();

    public static File a(File directory, String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            File file = new File(directory, fileName);
            if (file.exists() && !file.delete()) {
                throw new IOException("Failed to delete file " + file);
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (file.createNewFile()) {
                return file;
            }
            throw new IOException("File " + file + " already exists");
        } catch (IOException e2) {
            Logger.Companion.f16778a.a("An error occurred while creating a file", e2);
            return null;
        }
    }
}
