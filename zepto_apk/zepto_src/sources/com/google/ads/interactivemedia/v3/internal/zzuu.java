package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes3.dex */
public abstract class zzuu<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new zzaaq(reader));
    }

    public final T fromJsonTree(zzuc zzucVar) {
        try {
            return read(new zzxk(zzucVar));
        } catch (IOException e2) {
            throw new zzud(e2);
        }
    }

    public final zzuu<T> nullSafe() {
        return new zzut(this);
    }

    public abstract T read(zzaaq zzaaqVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new zzaas(writer), t);
    }

    public final zzuc toJsonTree(T t) {
        try {
            zzxm zzxmVar = new zzxm();
            write(zzxmVar, t);
            return zzxmVar.zza();
        } catch (IOException e2) {
            throw new zzud(e2);
        }
    }

    public abstract void write(zzaas zzaasVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new zzud(e2);
        }
    }
}
