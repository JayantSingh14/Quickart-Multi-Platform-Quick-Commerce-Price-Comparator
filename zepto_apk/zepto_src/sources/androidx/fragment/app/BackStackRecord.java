package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    public final FragmentManager t;
    public boolean u;
    public int v;
    public final boolean w;

    /* JADX WARN: Illegal instructions before constructor call */
    public BackStackRecord(FragmentManager fragmentManager) {
        FragmentFactory fragmentFactoryK = fragmentManager.K();
        FragmentHostCallback fragmentHostCallback = fragmentManager.x;
        super(fragmentFactoryK, fragmentHostCallback != null ? fragmentHostCallback.f4555b.getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f4649i) {
            return true;
        }
        this.t.f4567d.add(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int c() {
        return o(false, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int d() {
        return o(true, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void e() {
        g();
        this.t.B(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void f() {
        g();
        this.t.B(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void h(int i2, Fragment fragment, String str, int i3) {
        super.h(i2, fragment, str, i3);
        fragment.mFragmentManager = this.t;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void i(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            super.i(fragment);
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void l(Fragment fragment, Lifecycle.State state) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        FragmentManager fragmentManager2 = this.t;
        if (fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + fragmentManager2);
        }
        if (state == Lifecycle.State.f4806b && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.f4805a) {
            super.l(fragment, state);
            return;
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public final void m(int i2) {
        if (this.f4649i) {
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            ArrayList arrayList = this.f4643c;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                FragmentTransaction.Op op = (FragmentTransaction.Op) arrayList.get(i3);
                Fragment fragment = op.f4655b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f4655b + " to " + op.f4655b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void n() {
        ArrayList arrayList = this.f4643c;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) arrayList.get(size);
            if (op.f4656c) {
                if (op.f4654a == 8) {
                    op.f4656c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i2 = op.f4655b.mContainerId;
                    op.f4654a = 2;
                    op.f4656c = false;
                    for (int i3 = size - 1; i3 >= 0; i3--) {
                        FragmentTransaction.Op op2 = (FragmentTransaction.Op) arrayList.get(i3);
                        if (op2.f4656c && op2.f4655b.mContainerId == i2) {
                            arrayList.remove(i3);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final int o(boolean z, boolean z2) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter());
            p("  ", printWriter, true);
            printWriter.close();
        }
        this.u = true;
        boolean z3 = this.f4649i;
        FragmentManager fragmentManager = this.t;
        if (z3) {
            this.v = fragmentManager.f4574k.getAndIncrement();
        } else {
            this.v = -1;
        }
        if (z2) {
            fragmentManager.y(this, z);
        }
        return this.v;
    }

    public final void p(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f4651k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.f4648h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f4648h));
            }
            if (this.f4644d != 0 || this.f4645e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f4644d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f4645e));
            }
            if (this.f4646f != 0 || this.f4647g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f4646f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f4647g));
            }
            if (this.f4652l != 0 || this.f4653m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f4652l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f4653m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        ArrayList arrayList = this.f4643c;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) arrayList.get(i2);
            switch (op.f4654a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = CLConstants.ACTION_HIDE;
                    break;
                case 5:
                    str2 = CLConstants.ACTION_SHOW;
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + op.f4654a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(StringUtils.SPACE);
            printWriter.println(op.f4655b);
            if (z) {
                if (op.f4657d != 0 || op.f4658e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.f4657d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.f4658e));
                }
                if (op.f4659f != 0 || op.f4660g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.f4659f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f4660g));
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.f4651k != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.f4651k);
        }
        sb.append("}");
        return sb.toString();
    }
}
