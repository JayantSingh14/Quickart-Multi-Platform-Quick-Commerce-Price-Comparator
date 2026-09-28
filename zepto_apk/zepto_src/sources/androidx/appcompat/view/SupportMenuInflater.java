package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo
/* loaded from: classes3.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f487e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f488f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f489a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f490b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f491c;

    /* renamed from: d, reason: collision with root package name */
    public Object f492d;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class[] f493c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f494a;

        /* renamed from: b, reason: collision with root package name */
        public Method f495b;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f495b;
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = Boolean.TYPE;
                Object obj = this.f494a;
                if (returnType == cls) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class MenuState {
        public CharSequence A;
        public CharSequence B;

        /* renamed from: a, reason: collision with root package name */
        public final Menu f496a;

        /* renamed from: h, reason: collision with root package name */
        public boolean f503h;

        /* renamed from: i, reason: collision with root package name */
        public int f504i;

        /* renamed from: j, reason: collision with root package name */
        public int f505j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f506k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f507l;

        /* renamed from: m, reason: collision with root package name */
        public int f508m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public ActionProvider z;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;

        /* renamed from: b, reason: collision with root package name */
        public int f497b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f498c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f499d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f500e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f501f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f502g = true;

        public MenuState(Menu menu) {
            this.f496a = menu;
        }

        public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f491c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f507l).setIcon(this.f508m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            String str = this.y;
            SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
            if (str != null) {
                if (supportMenuInflater.f491c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                if (supportMenuInflater.f492d == null) {
                    supportMenuInflater.f492d = SupportMenuInflater.a(supportMenuInflater.f491c);
                }
                Object obj = supportMenuInflater.f492d;
                String str2 = this.y;
                InflatedOnMenuItemClickListener inflatedOnMenuItemClickListener = new InflatedOnMenuItemClickListener();
                inflatedOnMenuItemClickListener.f494a = obj;
                Class<?> cls = obj.getClass();
                try {
                    inflatedOnMenuItemClickListener.f495b = cls.getMethod(str2, InflatedOnMenuItemClickListener.f493c);
                    menuItem.setOnMenuItemClickListener(inflatedOnMenuItemClickListener);
                } catch (Exception e2) {
                    StringBuilder sbY = b.y("Couldn't resolve menu item onClick handler ", str2, " in class ");
                    sbY.append(cls.getName());
                    InflateException inflateException = new InflateException(sbY.toString());
                    inflateException.initCause(e2);
                    throw inflateException;
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).f(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    try {
                        Method method = menuItemWrapperICS.f634e;
                        SupportMenuItem supportMenuItem = menuItemWrapperICS.f633d;
                        if (method == null) {
                            menuItemWrapperICS.f634e = supportMenuItem.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemWrapperICS.f634e.invoke(supportMenuItem, Boolean.TRUE);
                    } catch (Exception e3) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e3);
                    }
                }
            }
            String str3 = this.x;
            if (str3 != null) {
                menuItem.setActionView((View) a(str3, SupportMenuInflater.f487e, supportMenuInflater.f489a));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i3);
                }
            }
            ActionProvider actionProvider = this.z;
            if (actionProvider != null) {
                if (menuItem instanceof SupportMenuItem) {
                    ((SupportMenuItem) menuItem).b(actionProvider);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            MenuItemCompat.b(menuItem, this.A);
            MenuItemCompat.f(menuItem, this.B);
            MenuItemCompat.a(menuItem, this.n, this.o);
            MenuItemCompat.e(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                MenuItemCompat.d(menuItem, mode);
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                MenuItemCompat.c(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f487e = clsArr;
        f488f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f491c = context;
        Object[] objArr = {context};
        this.f489a = objArr;
        this.f490b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.res.XmlResourceParser r17, android.util.AttributeSet r18, android.view.Menu r19) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.b(android.content.res.XmlResourceParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.f491c.getResources().getLayout(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (!menuBuilder.p) {
                        menuBuilder.B();
                        z = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((MenuBuilder) menu).A();
                }
                layout.close();
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z) {
                ((MenuBuilder) menu).A();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
