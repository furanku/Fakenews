package com.watashiwa.furanku.fakenews.controller.main;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;
import com.watashiwa.furanku.fakenews.R;
import com.watashiwa.furanku.fakenews.controller.webview.WebviewActivity;

import java.util.List;

/**
 * This class sets the adapter
 * Created by Furanku Watashiwa on 24/01/2018.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.NewsViewHolder> {

	/**
	 * creates and retrieves the list from the lib/
	 */
	private List<FakeNews> mNewsList = FakeNewsList.all;

	/**
	 * to get the size of the list (by layout manager)
	 * @return the total number of cells of the list
	 */
	public int getItemCount() {
		return mNewsList.size();
	}

	/**
	 * create new views (by layout manager)
	 *
	 * @param parent
	 * @param viewType
	 * @return the new view created
	 */
	@Override
	public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//create a new view
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view, parent, false);
		NewsViewHolder viewHolder = new NewsViewHolder(view);

		return viewHolder;
	}

	/**
	 * replaces the contents of a view (by layout manager)
	 *
	 * @param holder
	 * @param position
	 */
	@Override
	public void onBindViewHolder(NewsViewHolder holder, int position) {
		//-get element from the list at this position
		//- replace the contents of the view with that element
		FakeNews fakeNews = mNewsList.get(position);
		holder.display(fakeNews);
	}

	/**
	 * provide a reference to the views for each list(data) item
	 * provide access to all the views for a data item in a view holder
	 * complex data may need more than one view per item
	 */
	public static class NewsViewHolder extends RecyclerView.ViewHolder {
		/**
		 * title of the current position
		 */
		private final TextView title;
		/**
		 * contents of the current position
		 */
		private FakeNews currentFakeNews;

		public NewsViewHolder(final View itemView) {
			super(itemView);
			/**
			 * references the title
			 */
			title = itemView.findViewById(R.id.main_activity_title);

			/**
			 * to set the click on the each view
			 */
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					/**
					 * creates an intent to the webviewActivity
					 * @see WebviewActivity
					 */
					  Intent intent = new Intent(itemView.getContext(), WebviewActivity.class);

					/**
					 * transfers the title to WebviewActivity
					 * @see WebviewActivity#getIntent()
					 */
					  intent.putExtra("title", currentFakeNews.title);

					/**
					 * transfers the content to WebviewActivity
					 * @see WebviewActivity#getIntent()
					 */
					intent.putExtra("htmlContent", currentFakeNews.htmlContent);

					/**
					 * starts the webview activity after clicking the view
					 */
					itemView.getContext().startActivity(intent);
				}
			});
		}

		/**
		 * method to set the display of the view
		 * it is use in the holder
		 * @param fakeNews
		 */
		public void display(FakeNews fakeNews) {
			currentFakeNews = fakeNews;
			title.setText((fakeNews.title));
		}
	}
}
