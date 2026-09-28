package com.amazon.identity.auth.device.interactive;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import i.b;
import i.e;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public final class WorkflowFragment extends Fragment implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f15242a = new b(this);

    @Override // i.e
    public final b a() {
        return this.f15242a;
    }

    @Override // i.e
    public final Object b() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        b bVar = this.f15242a;
        bVar.getClass();
        if (bundle == null || (bundle2 = bundle.getBundle(b.f48438f)) == null) {
            return;
        }
        String string = bundle2.getString("interactiveStateId");
        if (string != null) {
            Objects.toString(bVar.f48443e);
            bVar.f48443e = UUID.fromString(string);
        }
        ArrayList parcelableArrayList = bundle2.getParcelableArrayList("requestRecords");
        if (parcelableArrayList != null) {
            bVar.f48441c.addAll(parcelableArrayList);
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        b bVar = this.f15242a;
        if (bVar.f48441c.size() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("interactiveStateId", bVar.f48443e.toString());
            bundle2.putParcelableArrayList("requestRecords", new ArrayList<>(bVar.f48441c));
            bundle.putBundle(b.f48438f, bundle2);
            Objects.toString(bVar.f48443e);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // i.e
    public final Object a(Bundle bundle) {
        return getFragmentManager().getFragment(bundle, "wrappedFragment");
    }
}
