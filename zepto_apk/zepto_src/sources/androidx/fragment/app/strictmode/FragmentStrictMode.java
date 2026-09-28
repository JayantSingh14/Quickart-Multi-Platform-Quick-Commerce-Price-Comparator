package androidx.fragment.app.strictmode;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final Policy f4740a = Policy.f4749b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Flag {

        /* renamed from: a, reason: collision with root package name */
        public static final Flag f4741a;

        /* renamed from: b, reason: collision with root package name */
        public static final Flag f4742b;

        /* renamed from: c, reason: collision with root package name */
        public static final Flag f4743c;

        /* renamed from: d, reason: collision with root package name */
        public static final Flag f4744d;

        /* renamed from: e, reason: collision with root package name */
        public static final Flag f4745e;

        /* renamed from: f, reason: collision with root package name */
        public static final Flag f4746f;

        /* renamed from: g, reason: collision with root package name */
        public static final Flag f4747g;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ Flag[] f4748h;

        /* JADX INFO: Fake field, exist only in values array */
        Flag EF0;

        static {
            Flag flag = new Flag("PENALTY_LOG", 0);
            Flag flag2 = new Flag("PENALTY_DEATH", 1);
            Flag flag3 = new Flag("DETECT_FRAGMENT_REUSE", 2);
            f4741a = flag3;
            Flag flag4 = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            f4742b = flag4;
            Flag flag5 = new Flag("DETECT_WRONG_NESTED_HIERARCHY", 4);
            f4743c = flag5;
            Flag flag6 = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 5);
            f4744d = flag6;
            Flag flag7 = new Flag("DETECT_SET_USER_VISIBLE_HINT", 6);
            f4745e = flag7;
            Flag flag8 = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 7);
            f4746f = flag8;
            Flag flag9 = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
            f4747g = flag9;
            f4748h = new Flag[]{flag, flag2, flag3, flag4, flag5, flag6, flag7, flag8, flag9};
        }

        public static Flag valueOf(String str) {
            return (Flag) Enum.valueOf(Flag.class, str);
        }

        public static Flag[] values() {
            return (Flag[]) f4748h.clone();
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface OnViolationListener {
    }

    @Metadata
    public static final class Policy {

        /* renamed from: b, reason: collision with root package name */
        public static final Policy f4749b = new Policy(EmptySet.f53611a, MapsKt.c());

        /* renamed from: a, reason: collision with root package name */
        public final EmptySet f4750a;

        @Metadata
        /* loaded from: classes3.dex */
        public static final class Builder {
            public Builder() {
                new LinkedHashSet();
                new LinkedHashMap();
            }
        }

        @Metadata
        public static final class Companion {
        }

        public Policy(EmptySet flags, Map allowedViolations) {
            Intrinsics.checkNotNullParameter(flags, "flags");
            Intrinsics.checkNotNullParameter(allowedViolations, "allowedViolations");
            this.f4750a = flags;
            new LinkedHashMap();
            ((EmptySet) allowedViolations.entrySet()).getClass();
            EmptyIterator.f53608a.getClass();
        }
    }

    public static Policy a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                parentFragmentManager.getClass();
            }
            fragment = fragment.getParentFragment();
        }
        return f4740a;
    }

    public static void b(Violation violation) {
        if (FragmentManager.O(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(violation.f4752a.getClass().getName()), violation);
        }
    }

    public static final void c(Fragment fragment, String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        b(new FragmentReuseViolation(fragment, previousFragmentId));
        a(fragment).f4750a.contains(Flag.f4741a);
    }
}
