package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class GlideException extends Exception {

    /* renamed from: f, reason: collision with root package name */
    public static final StackTraceElement[] f16000f = new StackTraceElement[0];

    /* renamed from: a, reason: collision with root package name */
    public final List f16001a;

    /* renamed from: b, reason: collision with root package name */
    public Key f16002b;

    /* renamed from: c, reason: collision with root package name */
    public DataSource f16003c;

    /* renamed from: d, reason: collision with root package name */
    public Class f16004d;

    /* renamed from: e, reason: collision with root package name */
    public final String f16005e;

    public GlideException(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof GlideException)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((GlideException) th).f16001a.iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), arrayList);
        }
    }

    public static void b(List list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            IndentedAppendable indentedAppendable = (IndentedAppendable) appendable;
            indentedAppendable.append("Cause (");
            int i3 = i2 + 1;
            indentedAppendable.append(String.valueOf(i3));
            indentedAppendable.append(" of ");
            indentedAppendable.append(String.valueOf(size));
            indentedAppendable.append("): ");
            Throwable th = (Throwable) list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).e(indentedAppendable);
            } else {
                c(th, indentedAppendable);
            }
            i2 = i3;
        }
    }

    public static void c(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i2));
            i2 = i3;
        }
    }

    public final void e(Appendable appendable) throws IOException {
        c(this, appendable);
        try {
            b(this.f16001a, new IndentedAppendable(appendable));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f16005e);
        String str3 = "";
        if (this.f16004d != null) {
            str = ", " + this.f16004d;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f16003c != null) {
            str2 = ", " + this.f16003c;
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.f16002b != null) {
            str3 = ", " + this.f16002b;
        }
        sb.append(str3);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() throws IOException {
        e(System.err);
    }

    public GlideException(String str, List list) {
        this.f16005e = str;
        setStackTrace(f16000f);
        this.f16001a = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) throws IOException {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) throws IOException {
        e(printWriter);
    }

    public static final class IndentedAppendable implements Appendable {

        /* renamed from: a, reason: collision with root package name */
        public final Appendable f16006a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16007b = true;

        public IndentedAppendable(Appendable appendable) {
            this.f16006a = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c2) throws IOException {
            boolean z = this.f16007b;
            Appendable appendable = this.f16006a;
            if (z) {
                this.f16007b = false;
                appendable.append("  ");
            }
            this.f16007b = c2 == '\n';
            appendable.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = this.f16007b;
            Appendable appendable = this.f16006a;
            boolean z2 = false;
            if (z) {
                this.f16007b = false;
                appendable.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i3 - 1) == '\n') {
                z2 = true;
            }
            this.f16007b = z2;
            appendable.append(charSequence, i2, i3);
            return this;
        }
    }
}
