package ua.valeraus.tothernotelist;

import java.util.ArrayList;
import java.util.Arrays;

import ua.valeraus.tothernotelist.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

	TableLayout tableLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tableLayout = (TableLayout) findViewById(R.id.table);

		ArrayAdapter<String> listAdapter;
		String[] list = new String[] { "First", "Second", "Third", "Fourth",
				"Fifth", "Sixth", "Seventh", "Eighth" };
		ArrayList<String> allList = new ArrayList<String>();
		allList.addAll(Arrays.asList(list));
		listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, allList);

		TableRow trListView1 = new TableRow(this);
		ListView lwList = new ListView(this);
		trListView1.addView(lwList);
		tableLayout.addView(trListView1);

		TableRow trButtons = new TableRow(this);
		Button btnNew = new Button(this);
		Button btnEdit = new Button(this);
		Button btnDelete = new Button(this);
		btnNew.setText("New");
		btnEdit.setText("Edit");
		btnDelete.setText("Delete");
		trButtons.addView(btnNew);
		trButtons.addView(btnEdit);
		trButtons.addView(btnDelete);
		tableLayout.addView(trButtons);

		listAdapter.add("Ninth");
		// listAdapter.add("Tenth");
		// listAdapter.add("Eleventh");
		// listAdapter.add("Twelfth");
		// listAdapter.add("Thirteenth");
		lwList.setAdapter(listAdapter);
		
		btnNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
			}
		});
		
		btnEdit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		btnDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

	}
}
