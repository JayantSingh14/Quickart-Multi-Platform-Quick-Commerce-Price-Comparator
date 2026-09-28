package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f4558a;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.f4558a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        final FragmentStateManager fragmentStateManagerH;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.f4558a;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_name);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = Fragment.class.isAssignableFrom(FragmentFactory.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragment = resourceId != -1 ? fragmentManager.D(resourceId) : null;
                    if (fragment == null && string != null) {
                        fragment = fragmentManager.E(string);
                    }
                    if (fragment == null && id != -1) {
                        fragment = fragmentManager.D(id);
                    }
                    if (fragment == null) {
                        fragment = fragmentManager.K().a(context.getClassLoader(), attributeValue);
                        fragment.mFromLayout = true;
                        fragment.mFragmentId = resourceId != 0 ? resourceId : id;
                        fragment.mContainerId = id;
                        fragment.mTag = string;
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = fragmentManager;
                        FragmentHostCallback<?> fragmentHostCallback = fragmentManager.x;
                        fragment.mHost = fragmentHostCallback;
                        fragment.onInflate((Context) fragmentHostCallback.f4555b, attributeSet, fragment.mSavedFragmentState);
                        fragmentStateManagerH = fragmentManager.a(fragment);
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (fragment.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = fragmentManager;
                        FragmentHostCallback<?> fragmentHostCallback2 = fragmentManager.x;
                        fragment.mHost = fragmentHostCallback2;
                        fragment.onInflate((Context) fragmentHostCallback2.f4555b, attributeSet, fragment.mSavedFragmentState);
                        fragmentStateManagerH = fragmentManager.h(fragment);
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    FragmentStrictMode.Policy policy = FragmentStrictMode.f4740a;
                    Intrinsics.checkNotNullParameter(fragment, "fragment");
                    FragmentStrictMode.b(new FragmentTagUsageViolation(fragment, viewGroup));
                    FragmentStrictMode.a(fragment).f4750a.contains(FragmentStrictMode.Flag.f4742b);
                    fragment.mContainer = viewGroup;
                    fragmentStateManagerH.k();
                    fragmentStateManagerH.j();
                    View view2 = fragment.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(android.support.v4.media.b.D("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.mView.getTag() == null) {
                        fragment.mView.setTag(string);
                    }
                    fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewAttachedToWindow(View view3) {
                            FragmentStateManager fragmentStateManager = fragmentStateManagerH;
                            fragmentStateManager.k();
                            SpecialEffectsController.m((ViewGroup) fragmentStateManager.f4621c.mView.getParent(), FragmentLayoutInflaterFactory.this.f4558a).l();
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewDetachedFromWindow(View view3) {
                        }
                    });
                    return fragment.mView;
                }
            }
        }
        return null;
    }
}
