package ua.valeraus.tpatternexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

	TableLayout tableLayout;

	// TableRow tableRow1, tableRow2, tableRow3, tableRow4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tableLayout = (TableLayout) findViewById(R.id.table);
		TableRow trLogin = (TableRow) findViewById(R.id.tableRow1);
		TableRow trEmail = (TableRow) findViewById(R.id.tableRow2);
		TableRow trPassword = (TableRow) findViewById(R.id.tableRow3);
		TableRow trPasswordConfirm = (TableRow) findViewById(R.id.tableRow4);
		TableRow trButtons = (TableRow) findViewById(R.id.tableRow5);

		final EditText etNewLogin = new EditText(this);
		trLogin.addView(etNewLogin);
		tableLayout.addView(trLogin);

		final EditText etNewEmail = new EditText(this);
		trEmail.addView(etNewEmail);
		tableLayout.addView(trEmail);

		final EditText etNewPassword = new EditText(this);
		etNewPassword.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
		trPassword.addView(etNewPassword);
		tableLayout.addView(trPassword);

		final EditText etCheckPassword = new EditText(this);
		etCheckPassword.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
		trPasswordConfirm.addView(etCheckPassword);
		tableLayout.addView(trPasswordConfirm);

		Button btnOk = new Button(this);
		Button btnAll = new Button(this);
		btnOk.setText("OK");
		btnAll.setText("All");
		trButtons.addView(btnOk);
		trButtons.addView(btnAll);
		tableLayout.addView(trButtons);
	}
}
