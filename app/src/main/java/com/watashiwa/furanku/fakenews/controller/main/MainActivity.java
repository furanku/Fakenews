package com.watashiwa.furanku.fakenews.controller.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.watashiwa.furanku.fakenews.R;


/**
 * This class is the main activity
 * The list and the recycler view are set in this class
 */
public class MainActivity extends AppCompatActivity {
	/**
	 * the recycler view to show the title of each content
	 */
	private RecyclerView mRecyclerView;
	/**
	 * the adapter to set the list
	 */
	private RecyclerView.Adapter mListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/**
		 * this, reference the recycler view to its unique id
		 */
		 mRecyclerView = findViewById(R.id.main_activity_title_list);

		/**
		 * this setting improve the performance
		 * do not change the layout size of the RecyclerView in content
		 */
		  mRecyclerView.setHasFixedSize(true);

		/**
		 * add a linear layout manager
		 * this linear layout manager allow to have the vertical scrolling
		 */
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		/**
		 * this adapter provide access to the titles
		 */
		mListAdapter = new ListAdapter();
		mRecyclerView.setAdapter(mListAdapter);
	}
}
