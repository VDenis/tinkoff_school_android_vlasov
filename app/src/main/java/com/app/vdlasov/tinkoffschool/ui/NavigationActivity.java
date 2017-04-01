package com.app.vdlasov.tinkoffschool.ui;

import com.app.vdlasov.tinkoffschool.R;
import com.app.vdlasov.tinkoffschool.utils.Credentials;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Denis on 01.04.2017.
 */

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static int MENU_DIALOGS = 0;
    private ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_dialogs:
                DialogFragment dialogsFragment = DialogFragment.newInstance();
                addFragment(dialogsFragment);
                break;
            case R.id.nav_settings:
                StubFragment settingsFragment = StubFragment.newInstance("Настройки");
                addFragment(settingsFragment);
                break;
            case R.id.nav_about:
                AboutFragment aboutFragment = AboutFragment.newInstance();
                addFragment(aboutFragment);
                break;
            case R.id.nav_exit:
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // set user login
        String userLogin = Credentials.getUserLogin(NavigationActivity.this);

        View header = navigationView.getHeaderView(0);
        TextView tv = (TextView)header.findViewById(R.id.textView);
        tv.setText(userLogin);

        if (savedInstanceState == null) {
            navigationView.getMenu().getItem(MENU_DIALOGS).setChecked(true);
            onNavigationItemSelected(navigationView.getMenu().getItem(MENU_DIALOGS));
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction = fragmentTransaction.replace(R.id.content_navigation, fragment);
        fragmentTransaction.commit();
    }
}
