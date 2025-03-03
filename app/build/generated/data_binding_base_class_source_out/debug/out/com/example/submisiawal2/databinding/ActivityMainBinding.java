// Generated by view binder compiler. Do not edit!
package com.example.submisiawal2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.submisiawal2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final FragmentContainerView navHostFragment;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView rvHome;

  @NonNull
  public final ImageView settings;

  @NonNull
  public final ImageView tombolFavorite;

  @NonNull
  public final View view;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout main,
      @NonNull FragmentContainerView navHostFragment, @NonNull ProgressBar progressBar,
      @NonNull RecyclerView rvHome, @NonNull ImageView settings, @NonNull ImageView tombolFavorite,
      @NonNull View view) {
    this.rootView = rootView;
    this.main = main;
    this.navHostFragment = navHostFragment;
    this.progressBar = progressBar;
    this.rvHome = rvHome;
    this.settings = settings;
    this.tombolFavorite = tombolFavorite;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.nav_host_fragment;
      FragmentContainerView navHostFragment = ViewBindings.findChildViewById(rootView, id);
      if (navHostFragment == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.rv_home;
      RecyclerView rvHome = ViewBindings.findChildViewById(rootView, id);
      if (rvHome == null) {
        break missingId;
      }

      id = R.id.settings;
      ImageView settings = ViewBindings.findChildViewById(rootView, id);
      if (settings == null) {
        break missingId;
      }

      id = R.id.tombol_favorite;
      ImageView tombolFavorite = ViewBindings.findChildViewById(rootView, id);
      if (tombolFavorite == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, main, navHostFragment,
          progressBar, rvHome, settings, tombolFavorite, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
