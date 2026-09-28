package com.swmansion.rnscreens;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.ReactContext;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.swmansion.rnscreens.ScreenFragment;
import com.swmansion.rnscreens.bottomsheet.BottomSheetDialogScreen;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ScreenModalFragment extends BottomSheetDialogFragment implements ScreenStackFragmentWrapper {
    public final ArrayList X = new ArrayList();

    @Metadata
    public static final class Companion {
    }

    public ScreenModalFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public final void b(ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter("An operation is not implemented: Not yet implemented", APayConstants.Error.MESSAGE);
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public final void c(ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter("An operation is not implemented: Not yet implemented", APayConstants.Error.MESSAGE);
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public final Fragment j() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final Screen k() {
        Intrinsics.h(PaymentConstants.Event.SCREEN);
        throw null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final boolean l() {
        return true;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final List n() {
        return this.X;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void o(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.X.add(container);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowsDialog(true);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new BottomSheetDialogScreen(contextRequireContext, this).f40044j = true;
        k();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        k();
        throw null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void p() {
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void q(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.X.remove(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final ReactContext r() {
        if (!(getContext() instanceof ReactContext)) {
            k();
            throw null;
        }
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        return (ReactContext) context;
    }
}
