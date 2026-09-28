package com.google.firebase.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class UiExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final UiExecutor f43653a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f43654b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ UiExecutor[] f43655c;

    static {
        UiExecutor uiExecutor = new UiExecutor("INSTANCE", 0);
        f43653a = uiExecutor;
        f43655c = new UiExecutor[]{uiExecutor};
        f43654b = new Handler(Looper.getMainLooper());
    }

    public static UiExecutor valueOf(String str) {
        return (UiExecutor) Enum.valueOf(UiExecutor.class, str);
    }

    public static UiExecutor[] values() {
        return (UiExecutor[]) f43655c.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f43654b.post(runnable);
    }
}
