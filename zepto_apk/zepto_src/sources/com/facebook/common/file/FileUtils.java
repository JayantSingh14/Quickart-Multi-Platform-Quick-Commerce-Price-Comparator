package com.facebook.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileUtils {

    public static class CreateDirectoryException extends IOException {
    }

    public static class FileDeleteException extends IOException {
    }

    public static class ParentDirNotFoundException extends FileNotFoundException {
    }

    public static class RenameException extends IOException {
    }

    public static void a(File file) throws CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                String absolutePath = file.getAbsolutePath();
                FileDeleteException fileDeleteException = new FileDeleteException(file.getAbsolutePath());
                CreateDirectoryException createDirectoryException = new CreateDirectoryException(absolutePath);
                createDirectoryException.initCause(fileDeleteException);
                throw createDirectoryException;
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static void b(File file, File file2) throws RenameException {
        file.getClass();
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable fileNotFoundException = !file2.exists() ? file.getParentFile().exists() ? !file.exists() ? new FileNotFoundException(file.getAbsolutePath()) : null : new ParentDirNotFoundException(file.getAbsolutePath()) : new FileDeleteException(file2.getAbsolutePath());
        RenameException renameException = new RenameException("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath());
        renameException.initCause(fileNotFoundException);
        throw renameException;
    }
}
