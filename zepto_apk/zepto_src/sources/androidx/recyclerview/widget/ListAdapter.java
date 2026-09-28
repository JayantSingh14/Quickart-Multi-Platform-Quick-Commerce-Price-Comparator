package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.chuckerteam.chucker.internal.data.entity.HttpTransactionTuple;
import com.chuckerteam.chucker.internal.support.TransactionDiffCallback;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: d, reason: collision with root package name */
    public final AsyncListDiffer f11534d;

    /* renamed from: e, reason: collision with root package name */
    public final AsyncListDiffer.ListListener f11535e;

    public ListAdapter(TransactionDiffCallback transactionDiffCallback) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public final void a() {
                ListAdapter.this.getClass();
            }
        };
        this.f11535e = listListener;
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(this);
        AsyncDifferConfig.Builder builder = new AsyncDifferConfig.Builder();
        if (builder.f11353a == null) {
            synchronized (AsyncDifferConfig.Builder.f11351b) {
                try {
                    if (AsyncDifferConfig.Builder.f11352c == null) {
                        AsyncDifferConfig.Builder.f11352c = Executors.newFixedThreadPool(2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            builder.f11353a = AsyncDifferConfig.Builder.f11352c;
        }
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(adapterListUpdateCallback, new AsyncDifferConfig(builder.f11353a, transactionDiffCallback));
        this.f11534d = asyncListDiffer;
        asyncListDiffer.f11358d.add(listListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return this.f11534d.f11360f.size();
    }

    public final void y(final List list) {
        final AsyncListDiffer asyncListDiffer = this.f11534d;
        final int i2 = asyncListDiffer.f11361g + 1;
        asyncListDiffer.f11361g = i2;
        final List list2 = asyncListDiffer.f11359e;
        if (list == list2) {
            return;
        }
        List list3 = asyncListDiffer.f11360f;
        AdapterListUpdateCallback adapterListUpdateCallback = asyncListDiffer.f11355a;
        if (list == null) {
            int size = list2.size();
            asyncListDiffer.f11359e = null;
            asyncListDiffer.f11360f = Collections.EMPTY_LIST;
            adapterListUpdateCallback.b(0, size);
            asyncListDiffer.a(list3);
            return;
        }
        if (list2 != null) {
            asyncListDiffer.f11356b.f11349a.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1

                /* renamed from: a */
                public final /* synthetic */ List f11362a;

                /* renamed from: b */
                public final /* synthetic */ List f11363b;

                /* renamed from: c */
                public final /* synthetic */ int f11364c;

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1 */
                class C00061 extends DiffUtil.Callback {
                    public C00061() {
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public final boolean a(int i2, int i3) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Object obj = list.get(i2);
                        Object obj2 = list.get(i3);
                        if (obj == null || obj2 == null) {
                            if (obj == null && obj2 == null) {
                                return true;
                            }
                            throw new AssertionError();
                        }
                        AsyncListDiffer.this.f11356b.f11350b.getClass();
                        HttpTransactionTuple oldItem = (HttpTransactionTuple) obj;
                        HttpTransactionTuple newItem = (HttpTransactionTuple) obj2;
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        return oldItem.equals(newItem);
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public final boolean b(int i2, int i3) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Object obj = list.get(i2);
                        Object obj2 = list.get(i3);
                        if (obj == null || obj2 == null) {
                            return obj == null && obj2 == null;
                        }
                        AsyncListDiffer.this.f11356b.f11350b.getClass();
                        HttpTransactionTuple oldItem = (HttpTransactionTuple) obj;
                        HttpTransactionTuple newItem = (HttpTransactionTuple) obj2;
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        return oldItem.f16698a == newItem.f16698a;
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public final Object c(int i2, int i3) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Object obj = list.get(i2);
                        Object obj2 = list.get(i3);
                        if (obj == null || obj2 == null) {
                            throw new AssertionError();
                        }
                        AsyncListDiffer.this.f11356b.f11350b.getClass();
                        HttpTransactionTuple oldItem = (HttpTransactionTuple) obj;
                        HttpTransactionTuple newItem = (HttpTransactionTuple) obj2;
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        return Unit.f53572a;
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public final int d() {
                        return list.size();
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public final int e() {
                        return list.size();
                    }
                }

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$2 */
                class AnonymousClass2 implements Runnable {

                    /* renamed from: a */
                    public final /* synthetic */ DiffUtil.DiffResult f11367a;

                    public AnonymousClass2(DiffUtil.DiffResult diffResult) {
                        diffResult = diffResult;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:118:0x0113  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void run() {
                        /*
                            Method dump skipped, instructions count: 346
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.AnonymousClass2.run():void");
                    }
                }

                public AnonymousClass1(final List list22, final List list4, final int i22) {
                    list = list22;
                    list = list4;
                    i = i22;
                }

                /* JADX WARN: Removed duplicated region for block: B:171:0x00e8 A[ADDED_TO_REGION] */
                /* JADX WARN: Removed duplicated region for block: B:174:0x00f4  */
                /* JADX WARN: Removed duplicated region for block: B:185:0x0117  */
                /* JADX WARN: Removed duplicated region for block: B:193:0x013c  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void run() {
                    /*
                        Method dump skipped, instructions count: 717
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.run():void");
                }
            });
            return;
        }
        asyncListDiffer.f11359e = list4;
        asyncListDiffer.f11360f = Collections.unmodifiableList(list4);
        adapterListUpdateCallback.a(0, list4.size());
        asyncListDiffer.a(list3);
    }
}
