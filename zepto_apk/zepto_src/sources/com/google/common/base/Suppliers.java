package com.google.common.base;

import android.support.v4.media.b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public final class Suppliers {

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            throw null;
        }

        public final String toString() {
            return "Suppliers.memoizeWithExpiration(null, 0, NANOS)";
        }
    }

    @VisibleForTesting
    public static class MemoizingSupplier<T> implements Supplier<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Supplier f42314a;

        /* renamed from: b, reason: collision with root package name */
        public volatile transient boolean f42315b;

        /* renamed from: c, reason: collision with root package name */
        public transient Object f42316c;

        public MemoizingSupplier(Supplier supplier) {
            this.f42314a = supplier;
        }

        @Override // com.google.common.base.Supplier
        public final Object get() {
            if (!this.f42315b) {
                synchronized (this) {
                    try {
                        if (!this.f42315b) {
                            Object obj = this.f42314a.get();
                            this.f42316c = obj;
                            this.f42315b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return this.f42316c;
        }

        public final String toString() {
            return b.q(new StringBuilder("Suppliers.memoize("), this.f42315b ? b.q(new StringBuilder("<supplier that returned "), this.f42316c, ">") : this.f42314a, ")");
        }
    }

    @VisibleForTesting
    public static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f42317c = new a();

        /* renamed from: a, reason: collision with root package name */
        public volatile Supplier f42318a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42319b;

        @Override // com.google.common.base.Supplier
        public final Object get() {
            Supplier supplier = this.f42318a;
            a aVar = f42317c;
            if (supplier != aVar) {
                synchronized (this) {
                    try {
                        if (this.f42318a != aVar) {
                            Object obj = this.f42318a.get();
                            this.f42319b = obj;
                            this.f42318a = aVar;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return this.f42319b;
        }

        public final String toString() {
            Object objQ = this.f42318a;
            StringBuilder sb = new StringBuilder("Suppliers.memoize(");
            if (objQ == f42317c) {
                objQ = b.q(new StringBuilder("<supplier that returned "), this.f42319b, ">");
            }
            return b.q(sb, objQ, ")");
        }
    }

    /* loaded from: classes4.dex */
    public static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        public final boolean equals(Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            ((SupplierComposition) obj).getClass();
            throw null;
        }

        @Override // com.google.common.base.Supplier
        public final Object get() {
            throw null;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{null, null});
        }

        public final String toString() {
            return "Suppliers.compose(null, null)";
        }
    }

    /* loaded from: classes4.dex */
    public interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class SupplierFunctionImpl implements SupplierFunction<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SupplierFunctionImpl[] f42320a = {new SupplierFunctionImpl("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        SupplierFunctionImpl EF5;

        public static SupplierFunctionImpl valueOf(String str) {
            return (SupplierFunctionImpl) Enum.valueOf(SupplierFunctionImpl.class, str);
        }

        public static SupplierFunctionImpl[] values() {
            return (SupplierFunctionImpl[]) f42320a.clone();
        }

        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return ((Supplier) obj).get();
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    public static class SupplierOfInstance<T> implements Supplier<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42321a;

        public SupplierOfInstance(Object obj) {
            this.f42321a = obj;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.a(this.f42321a, ((SupplierOfInstance) obj).f42321a);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public final Object get() {
            return this.f42321a;
        }

        public final int hashCode() {
            return Objects.b(this.f42321a);
        }

        public final String toString() {
            return b.q(new StringBuilder("Suppliers.ofInstance("), this.f42321a, ")");
        }
    }

    /* loaded from: classes4.dex */
    public static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            throw null;
        }

        public final String toString() {
            return "Suppliers.synchronizedSupplier(null)";
        }
    }

    public static Supplier a(Supplier supplier) {
        if ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) {
            return supplier;
        }
        if (supplier instanceof Serializable) {
            return new MemoizingSupplier(supplier);
        }
        NonSerializableMemoizingSupplier nonSerializableMemoizingSupplier = new NonSerializableMemoizingSupplier();
        nonSerializableMemoizingSupplier.f42318a = supplier;
        return nonSerializableMemoizingSupplier;
    }

    public static Supplier b(Object obj) {
        return new SupplierOfInstance(obj);
    }
}
