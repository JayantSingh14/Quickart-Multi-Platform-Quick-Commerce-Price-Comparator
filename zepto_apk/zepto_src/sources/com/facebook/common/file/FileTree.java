package com.facebook.common.file;

import com.facebook.infer.annotation.Nullsafe;
import java.io.File;

@Nullsafe
/* loaded from: classes3.dex */
public class FileTree {
    public static boolean a(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        return file.delete();
    }

    public static void b(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.c(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    b(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.b(file2);
                }
            }
        }
        fileTreeVisitor.a(file);
    }
}
