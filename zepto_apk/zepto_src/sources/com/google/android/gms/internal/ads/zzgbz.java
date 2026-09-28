package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgbz extends zzgbr {

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32238b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgby f32239c;

    /* renamed from: d, reason: collision with root package name */
    public final Function f32240d;

    public zzgbz(File file, ExecutorService executorService, zzgby zzgbyVar, Function function) {
        super(file);
        this.f32238b = executorService;
        this.f32239c = zzgbyVar;
        this.f32240d = function;
    }

    @Override // com.google.android.gms.internal.ads.zzgbr
    public final ListenableFuture a() {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object objApply;
                Object objA;
                zzgbz zzgbzVar = this.f32236a;
                synchronized (zzgbzVar) {
                    try {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(zzgbzVar.f32231a);
                            try {
                                objA = zzgbzVar.f32239c.a(fileInputStream);
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException unused) {
                            objApply = zzgbzVar.f32239c.zzc();
                            return objApply;
                        }
                    } catch (zzgbu e2) {
                        objApply = zzgbzVar.f32240d.apply(e2);
                        return objApply;
                    } catch (IOException e3) {
                        objApply = zzgbzVar.f32240d.apply(new zzgbu(e3));
                        return objApply;
                    }
                }
                return objA;
            }
        }, this.f32238b);
    }

    @Override // com.google.android.gms.internal.ads.zzgbr
    public final ListenableFuture b(final Object obj) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbv
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgbz zzgbzVar = this.f32234a;
                Object obj2 = obj;
                synchronized (zzgbzVar) {
                    File file = zzgbzVar.f32231a;
                    zzgwk.b(file);
                    String parent = file.getParent();
                    String name = file.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 5);
                    sb.append(name);
                    sb.append(".temp");
                    File file2 = new File(parent, sb.toString());
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            zzgbzVar.f32239c.b(obj2, fileOutputStream);
                            fileOutputStream.close();
                            if (!file2.renameTo(zzgbzVar.f32231a)) {
                                throw new IOException("Failed to rename file.");
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        file2.delete();
                        throw e2;
                    }
                }
                return null;
            }
        }, this.f32238b);
    }
}
