package androidx.fragment.app;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentFactory f4641a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f4642b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4643c;

    /* renamed from: d, reason: collision with root package name */
    public int f4644d;

    /* renamed from: e, reason: collision with root package name */
    public int f4645e;

    /* renamed from: f, reason: collision with root package name */
    public int f4646f;

    /* renamed from: g, reason: collision with root package name */
    public int f4647g;

    /* renamed from: h, reason: collision with root package name */
    public int f4648h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4649i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4650j;

    /* renamed from: k, reason: collision with root package name */
    public String f4651k;

    /* renamed from: l, reason: collision with root package name */
    public int f4652l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f4653m;
    public int n;
    public CharSequence o;
    public ArrayList p;
    public ArrayList q;
    public boolean r;
    public ArrayList s;

    @Deprecated
    public FragmentTransaction() {
        this.f4643c = new ArrayList();
        this.f4650j = true;
        this.r = false;
        this.f4641a = null;
        this.f4642b = null;
    }

    public final void b(Op op) {
        this.f4643c.add(op);
        op.f4657d = this.f4644d;
        op.f4658e = this.f4645e;
        op.f4659f = this.f4646f;
        op.f4660g = this.f4647g;
    }

    public abstract int c();

    public abstract int d();

    public abstract void e();

    public abstract void f();

    public final void g() {
        if (this.f4649i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f4650j = false;
    }

    public void h(int i2, Fragment fragment, String str, int i3) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.c(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(fragment);
                sb.append(": was ");
                throw new IllegalStateException(android.support.v4.media.b.s(sb, fragment.mTag, " now ", str));
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        b(new Op(fragment, i3));
    }

    public void i(Fragment fragment) {
        b(new Op(fragment, 3));
    }

    public final void j(Fragment fragment, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        h(i2, fragment, null, 2);
    }

    public final void k(int i2, int i3) {
        this.f4644d = i2;
        this.f4645e = i3;
        this.f4646f = 0;
        this.f4647g = 0;
    }

    public void l(Fragment fragment, Lifecycle.State state) {
        Op op = new Op();
        op.f4654a = 10;
        op.f4655b = fragment;
        op.f4656c = false;
        op.f4661h = fragment.mMaxState;
        op.f4662i = state;
        b(op);
    }

    public static final class Op {

        /* renamed from: a, reason: collision with root package name */
        public int f4654a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f4655b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4656c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f4657d;

        /* renamed from: e, reason: collision with root package name */
        public int f4658e;

        /* renamed from: f, reason: collision with root package name */
        public int f4659f;

        /* renamed from: g, reason: collision with root package name */
        public int f4660g;

        /* renamed from: h, reason: collision with root package name */
        public Lifecycle.State f4661h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f4662i;

        public Op(Fragment fragment, int i2) {
            this.f4654a = i2;
            this.f4655b = fragment;
            Lifecycle.State state = Lifecycle.State.f4809e;
            this.f4661h = state;
            this.f4662i = state;
        }

        public Op(Fragment fragment, int i2, int i3) {
            this.f4654a = i2;
            this.f4655b = fragment;
            Lifecycle.State state = Lifecycle.State.f4809e;
            this.f4661h = state;
            this.f4662i = state;
        }
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.f4643c = new ArrayList();
        this.f4650j = true;
        this.r = false;
        this.f4641a = fragmentFactory;
        this.f4642b = classLoader;
    }
}
