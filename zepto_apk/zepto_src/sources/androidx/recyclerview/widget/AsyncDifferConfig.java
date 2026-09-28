package androidx.recyclerview.widget;

import com.chuckerteam.chucker.internal.support.TransactionDiffCallback;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class AsyncDifferConfig<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f11349a;

    /* renamed from: b, reason: collision with root package name */
    public final TransactionDiffCallback f11350b;

    public static final class Builder<T> {

        /* renamed from: b, reason: collision with root package name */
        public static final Object f11351b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public static ExecutorService f11352c;

        /* renamed from: a, reason: collision with root package name */
        public ExecutorService f11353a;
    }

    public AsyncDifferConfig(ExecutorService executorService, TransactionDiffCallback transactionDiffCallback) {
        this.f11349a = executorService;
        this.f11350b = transactionDiffCallback;
    }
}
