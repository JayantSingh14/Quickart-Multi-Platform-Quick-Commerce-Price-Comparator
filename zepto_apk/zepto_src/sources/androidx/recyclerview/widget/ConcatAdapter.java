package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final class Config {

        public static final class Builder {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class StableIdMode {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ StableIdMode[] f11380a = {new StableIdMode("NO_STABLE_IDS", 0), new StableIdMode("ISOLATED_STABLE_IDS", 1), new StableIdMode("SHARED_STABLE_IDS", 2)};

            /* JADX INFO: Fake field, exist only in values array */
            StableIdMode EF5;

            public static StableIdMode valueOf(String str) {
                return (StableIdMode) Enum.valueOf(StableIdMode.class, str);
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) f11380a.clone();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int c(RecyclerView.Adapter adapter, int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long e(int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int f(int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void n(RecyclerView recyclerView) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void q(RecyclerView recyclerView) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean r(RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void s(RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void t() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void u(RecyclerView.ViewHolder viewHolder) {
        throw null;
    }
}
