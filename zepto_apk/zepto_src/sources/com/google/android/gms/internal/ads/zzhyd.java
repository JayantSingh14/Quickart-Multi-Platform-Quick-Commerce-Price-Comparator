package com.google.android.gms.internal.ads;

import java.io.Writer;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhyd extends Writer implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f34506a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhyc f34507b = new zzhyc();

    public zzhyd(StringBuilder sb) {
        this.f34506a = sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f34506a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        zzhyc zzhycVar = this.f34507b;
        zzhycVar.f34504a = cArr;
        zzhycVar.f34505b = null;
        this.f34506a.append((CharSequence) zzhycVar, i2, i3 + i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i2, int i3) {
        this.f34506a.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i3) {
        append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i2) {
        this.f34506a.append((char) i2);
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i3) {
        Objects.requireNonNull(str);
        this.f34506a.append((CharSequence) str, i2, i3 + i2);
    }
}
