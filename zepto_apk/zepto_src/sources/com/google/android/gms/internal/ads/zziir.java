package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public class zziir implements Iterator, Closeable, zzasw, AutoCloseable {

    /* renamed from: g, reason: collision with root package name */
    public static final zzasv f34852g = new zziiq("eof ");

    /* renamed from: a, reason: collision with root package name */
    public zzasr f34853a;

    /* renamed from: b, reason: collision with root package name */
    public zziis f34854b;

    /* renamed from: c, reason: collision with root package name */
    public zzasv f34855c = null;

    /* renamed from: d, reason: collision with root package name */
    public long f34856d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f34857e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f34858f = new ArrayList();

    static {
        zziiy.b(zziir.class);
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final zzasv next() {
        zzasv zzasvVarB;
        zzasv zzasvVar = this.f34855c;
        if (zzasvVar != null && zzasvVar != f34852g) {
            this.f34855c = null;
            return zzasvVar;
        }
        zziis zziisVar = this.f34854b;
        if (zziisVar == null || this.f34856d >= this.f34857e) {
            this.f34855c = f34852g;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zziisVar) {
                ((zzcgf) this.f34854b).h(this.f34856d);
                zzasvVarB = this.f34853a.b(this.f34854b, this);
                this.f34856d = ((zzcgf) this.f34854b).zzc();
            }
            return zzasvVarB;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public void close() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzasv zzasvVar = this.f34855c;
        zzasv zzasvVar2 = f34852g;
        if (zzasvVar == zzasvVar2) {
            return false;
        }
        if (zzasvVar != null) {
            return true;
        }
        try {
            this.f34855c = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f34855c = zzasvVar2;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f34858f;
            if (i2 >= arrayList.size()) {
                sb.append("]");
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(((zzasv) arrayList.get(i2)).toString());
            i2++;
        }
    }
}
