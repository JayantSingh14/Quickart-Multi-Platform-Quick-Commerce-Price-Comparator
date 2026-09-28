package com.amazon.identity.auth.device.interactive;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import i.b;
import i.e;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class WorkflowSupportFragment extends Fragment implements e {
    public final b Q = new b(this);

    @Override // i.e
    public final b a() {
        return this.Q;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        b bVar = this.Q;
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

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        b bVar = this.Q;
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
        return getFragmentManager().I(bundle, "wrappedFragment");
    }
}
