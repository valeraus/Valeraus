package ua.valeraus.tothernoteimage;

import ua.valeraus.tothernoteimage.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

	TableLayout tableLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tableLayout = (TableLayout) findViewById(R.id.table);

		TableRow trList = new TableRow(this);
		EditText etList = new EditText(this);
		trList.addView(etList);

	}
}
