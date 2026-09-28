package ch.qos.logback.core;

import android.support.v4.media.b;
import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import ch.qos.logback.core.util.FileSize;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class FileAppender<E> extends OutputStreamAppender<E> {
    public final boolean n = true;
    public final String o = null;
    public final FileSize p = new FileSize(8192);

    public String a2() {
        return this.o;
    }

    public final void b2(String str) {
        boolean zExists;
        ReentrantLock reentrantLock = this.f13448k;
        reentrantLock.lock();
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                zExists = true;
            } else {
                parentFile.mkdirs();
                zExists = parentFile.exists();
            }
            if (!zExists) {
                l1("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            }
            boolean z = this.n;
            long j2 = this.p.f13808a;
            ResilientFileOutputStream resilientFileOutputStream = new ResilientFileOutputStream();
            resilientFileOutputStream.f13706g = file;
            resilientFileOutputStream.f13707h = new FileOutputStream(file, z);
            resilientFileOutputStream.f13712e = new BufferedOutputStream(resilientFileOutputStream.f13707h, (int) j2);
            resilientFileOutputStream.f13713f = true;
            resilientFileOutputStream.f13710c = this.f13733b;
            X1(resilientFileOutputStream);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        Map map;
        boolean z;
        boolean z2 = true;
        if (a2() != null) {
            s1("File property is set to [" + this.o + "]");
            if (this.o == null || (map = (Map) this.f13733b.n0("FA_FILENAME_COLLISION_MAP")) == null) {
                z = false;
            } else {
                z = false;
                for (Map.Entry entry : map.entrySet()) {
                    if (this.o.equals(entry.getValue())) {
                        l1(b.m("'File' option has the same value \"", (String) entry.getValue(), "\" as that given for appender [", (String) entry.getKey(), "] defined earlier."));
                        z = true;
                    }
                }
                String str = this.f13453f;
                if (str != null) {
                    map.put(str, this.o);
                }
            }
            if (z) {
                l1("Collisions detected with FileAppender/RollingAppender instances defined earlier. Aborting.");
                l1("For more information, please visit http://logback.qos.ch/codes.html#earlier_fa_collision");
            } else {
                try {
                    b2(a2());
                    z2 = false;
                } catch (IOException e2) {
                    o1("openFile(" + this.o + "," + this.n + ") call failed.", e2);
                }
            }
        } else {
            l1("\"File\" property not set for appender named [" + this.f13453f + "].");
        }
        if (z2) {
            return;
        }
        super.start();
    }

    @Override // ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        String str;
        super.stop();
        Context context = this.f13733b;
        Map map = context == null ? null : (Map) context.n0("FA_FILENAME_COLLISION_MAP");
        if (map == null || (str = this.f13453f) == null) {
            return;
        }
        map.remove(str);
    }
}
