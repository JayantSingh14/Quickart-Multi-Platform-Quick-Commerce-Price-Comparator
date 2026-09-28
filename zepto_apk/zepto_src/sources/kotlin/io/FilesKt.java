package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileTreeWalk.FileTreeWalkIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata
/* loaded from: classes.dex */
public final class FilesKt extends FilesKt__UtilsKt {
    public static boolean b(File start) {
        Intrinsics.checkNotNullParameter(start, "<this>");
        Intrinsics.checkNotNullParameter(start, "<this>");
        FileWalkDirection direction = FileWalkDirection.f53744b;
        Intrinsics.checkNotNullParameter(start, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk(start, direction, null, null, null, 0, 32, null).new FileTreeWalkIterator();
        while (true) {
            boolean z = true;
            while (fileTreeWalkIterator.hasNext()) {
                File file = (File) fileTreeWalkIterator.next();
                if (!file.delete() && file.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }

    public static String c(File file) throws IOException {
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strB = TextStreamsKt.b(inputStreamReader);
            inputStreamReader.close();
            return strB;
        } finally {
        }
    }

    public static void d(File file, String text) throws IOException {
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            FilesKt__FileReadWriteKt.a(fileOutputStream, text, charset);
            Unit unit = Unit.f53572a;
            fileOutputStream.close();
        } finally {
        }
    }
}
