package androidx.preference;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

@RestrictTo
/* loaded from: classes3.dex */
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f11123d;

    /* renamed from: androidx.preference.PreferenceGroupAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: androidx.preference.PreferenceGroupAdapter$2, reason: invalid class name */
    class AnonymousClass2 extends DiffUtil.Callback {
        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean a(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean b(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int d() {
            throw null;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int e() {
            throw null;
        }
    }

    /* renamed from: androidx.preference.PreferenceGroupAdapter$3, reason: invalid class name */
    class AnonymousClass3 implements Preference.OnPreferenceClickListener {
    }

    public static class PreferenceResourceDescriptor {

        /* renamed from: a, reason: collision with root package name */
        public final int f11124a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11125b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11126c;

        public PreferenceResourceDescriptor(Preference preference) {
            this.f11126c = preference.getClass().getName();
            this.f11124a = preference.u;
            this.f11125b = preference.v;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            return this.f11124a == preferenceResourceDescriptor.f11124a && this.f11125b == preferenceResourceDescriptor.f11125b && TextUtils.equals(this.f11126c, preferenceResourceDescriptor.f11126c);
        }

        public final int hashCode() {
            return this.f11126c.hashCode() + ((((527 + this.f11124a) * 31) + this.f11125b) * 31);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long e(int i2) {
        if (this.f11564b) {
            return z(i2).a();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int f(int i2) {
        new PreferenceResourceDescriptor(z(i2));
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        z(i2).g((PreferenceViewHolder) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
        throw null;
    }

    public final void y(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.A);
        }
        if (preferenceGroup.A.size() <= 0) {
            return;
        }
        Preference preferenceR = preferenceGroup.r(0);
        arrayList.add(preferenceR);
        new PreferenceResourceDescriptor(preferenceR);
        throw null;
    }

    public final Preference z(int i2) {
        if (i2 < 0) {
            return null;
        }
        throw null;
    }
}
