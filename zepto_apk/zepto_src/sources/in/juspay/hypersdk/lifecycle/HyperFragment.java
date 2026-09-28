package in.juspay.hypersdk.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class HyperFragment extends Fragment {

    @NotNull
    private final LinkedList<EventListener> onPauseListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<EventListener> onStopListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<EventListener> onResumeListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<EventListener> onDestroyListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<EventListener> onSaveInstanceListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<EventListener> onAttachListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<ActivityResultHolder> onActivityResultListeners = new LinkedList<>();

    @NotNull
    private final LinkedList<RequestPermissionResult> onRequestPermissionsResultListeners = new LinkedList<>();

    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            try {
                iArr[FragmentEvent.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FragmentEvent.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FragmentEvent.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FragmentEvent.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FragmentEvent.ON_SAVED_STATE_INSTANCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FragmentEvent.ON_ATTACH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FragmentEvent.ON_ACTIVITY_RESULT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FragmentEvent.ON_REQUEST_PERMISSION_RESULT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void unRegisterForEvent(FragmentEvent fragmentEvent) {
        switch (WhenMappings.$EnumSwitchMapping$0[fragmentEvent.ordinal()]) {
            case 1:
                this.onPauseListeners.clear();
                break;
            case 2:
                this.onResumeListeners.clear();
                break;
            case 3:
                this.onStopListeners.clear();
                break;
            case 4:
                this.onDestroyListeners.clear();
                break;
            case 5:
                this.onSaveInstanceListeners.clear();
                break;
            case 6:
                this.onAttachListeners.clear();
                break;
            case 7:
                this.onActivityResultListeners.clear();
                break;
            case 8:
                this.onRequestPermissionsResultListeners.clear();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Iterator<ActivityResultHolder> it = this.onActivityResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Iterator<EventListener> it = this.onAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Iterator<EventListener> it = this.onDestroyListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
        for (FragmentEvent fragmentEvent : FragmentEvent.values()) {
            unRegisterForEvent(fragmentEvent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<EventListener> it = this.onPauseListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        Iterator<RequestPermissionResult> it = this.onRequestPermissionsResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i2, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Iterator<EventListener> it = this.onResumeListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Iterator<EventListener> it = this.onSaveInstanceListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Iterator<EventListener> it = this.onStopListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}", this);
        }
    }

    public final void registerForEvent(@NotNull FragmentEvent event, @NotNull EventListener listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                this.onPauseListeners.add(listener);
                break;
            case 2:
                this.onResumeListeners.add(listener);
                break;
            case 3:
                this.onStopListeners.add(listener);
                break;
            case 4:
                this.onDestroyListeners.add(listener);
                break;
            case 5:
                this.onSaveInstanceListeners.add(listener);
                break;
            case 6:
                this.onAttachListeners.add(listener);
                break;
        }
    }

    public final void registerOnActivityResult(@NotNull ActivityResultHolder listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onActivityResultListeners.add(listener);
    }

    public final void registerOnRequestPermissionResult(@NotNull RequestPermissionResult listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onRequestPermissionsResultListeners.add(listener);
    }
}
