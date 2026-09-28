package ch.qos.logback.core.util;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes3.dex */
public class CloseUtil {
    public static void a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void b(Socket socket) throws IOException {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException unused) {
        }
    }
}
