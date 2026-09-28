package ch.qos.logback.core.recovery;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ResilientFileOutputStream extends ResilientOutputStreamBase {

    /* renamed from: g, reason: collision with root package name */
    public File f13706g;

    /* renamed from: h, reason: collision with root package name */
    public FileOutputStream f13707h;

    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public final String e() {
        return "file [" + this.f13706g + "]";
    }

    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public final OutputStream l() {
        this.f13707h = new FileOutputStream(this.f13706g, true);
        return new BufferedOutputStream(this.f13707h);
    }

    public final String toString() {
        return "c.q.l.c.recovery.ResilientFileOutputStream@" + System.identityHashCode(this);
    }
}
