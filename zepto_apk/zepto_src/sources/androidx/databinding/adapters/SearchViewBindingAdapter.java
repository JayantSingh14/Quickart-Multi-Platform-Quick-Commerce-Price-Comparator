package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.SearchView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class SearchViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements SearchView.OnQueryTextListener {
        @Override // android.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextChange(String str) {
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements SearchView.OnSuggestionListener {
        @Override // android.widget.SearchView.OnSuggestionListener
        public final boolean onSuggestionClick(int i2) {
            return false;
        }

        @Override // android.widget.SearchView.OnSuggestionListener
        public final boolean onSuggestionSelect(int i2) {
            return false;
        }
    }

    @TargetApi(11)
    public interface OnQueryTextChange {
    }

    @TargetApi(11)
    public interface OnQueryTextSubmit {
    }

    @TargetApi(11)
    public interface OnSuggestionClick {
    }

    @TargetApi(11)
    public interface OnSuggestionSelect {
    }
}
