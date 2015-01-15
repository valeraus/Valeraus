package ua.valeraus.tothertnoteregistrations;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import ua.valera.othernote.MainActivity;
import android.app.Activity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	LinearLayout ll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ll = (LinearLayout) findViewById(R.id.linearLayout1);
		final ListView listViewTest = new ListView(this);
		final ArrayList<String> al = new ArrayList<String>();
		final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, al);

		listViewTest.setAdapter(aa);
		// установим вертикальную ориентацию
		ll.setOrientation(LinearLayout.VERTICAL);
		// ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.setGravity(Gravity.CENTER_HORIZONTAL);

		// создаем LayoutParams
		LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);

		// устанавливаем ll как корневой элемент экрана

		LinearLayout L1 = new LinearLayout(this);
		L1.setOrientation(LinearLayout.HORIZONTAL);
		L1.setGravity(Gravity.CENTER_HORIZONTAL);
		TextView tvLogin = new TextView(this);
		tvLogin.setText("Login: ");
		// tvLogin.setLayoutParams(lpView);
		final EditText etNewLogin = new EditText(this);
		etNewLogin.setHint("You login");
		// etNewLogin.setLayoutParams(lpView);
		L1.addView(tvLogin);
		L1.addView(etNewLogin);
		ll.addView(L1);

		LinearLayout L2 = new LinearLayout(this);
		L2.setOrientation(LinearLayout.HORIZONTAL);
		L2.setGravity(Gravity.CENTER_HORIZONTAL);
		TextView tvEmail = new TextView(this);
		tvEmail.setText("Email: ");
		final EditText etNewEmail = new EditText(this);
		etNewEmail.setHint("youemail@firma.com");
		L2.addView(tvEmail);
		L2.addView(etNewEmail);
		ll.addView(L2);

		LinearLayout L3 = new LinearLayout(this);
		L3.setOrientation(LinearLayout.HORIZONTAL);
		L3.setGravity(Gravity.CENTER_HORIZONTAL);
		final TextView tvNewPassword = new TextView(this);
		tvNewPassword.setText("Password: ");
		final EditText etNewPassword = new EditText(this);
		etNewPassword.setHint("You Password");
		etNewPassword.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
		L3.addView(tvNewPassword);
		L3.addView(etNewPassword);
		ll.addView(L3);

		LinearLayout L4 = new LinearLayout(this);
		L4.setOrientation(LinearLayout.HORIZONTAL);
		L4.setGravity(Gravity.CENTER_HORIZONTAL);
		final TextView tvCheckPassword = new TextView(this);
		tvCheckPassword.setText("Confirm Password: ");
		final EditText etCheckPassword = new EditText(this);
		etCheckPassword.setHint("Confirm you password");
		etCheckPassword.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
		L4.addView(tvCheckPassword);
		L4.addView(etCheckPassword);
		ll.addView(L4);

		Button btnRegistration = new Button(this);
		btnRegistration.setText("«арегистрироватьс€");
		ll.addView(btnRegistration, lpView);

		btnRegistration.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final String email = etNewEmail.getText().toString();
				if (!isValidEmail(email)) {
					// etNewEmail.setError("Invalid Email");
					Toast.makeText(
							MainActivity.this,
							"Invalid Email: " + etNewEmail.getText().toString(),
							Toast.LENGTH_SHORT).show();
				}

				final String pass = tvNewPassword.getText().toString();
				if (!isValidPassword(pass)) {
					// tvNewPassword.setError("Password to short");
					Toast.makeText(
							MainActivity.this,
							"Password to short: "
									+ tvNewPassword.getText().toString(),
							Toast.LENGTH_SHORT).show();
				}

				final String passCheck = tvCheckPassword.getText().toString();
				if (pass.equals(passCheck)) {
					// tvNewPassword.setError("Password to short");
					Toast.makeText(MainActivity.this, "Password not equil ",
							Toast.LENGTH_SHORT).show();
				}

				al.add(0, etNewLogin.getText().toString());
				aa.notifyDataSetChanged();
				al.add(0, tvNewPassword.getText().toString());
				aa.notifyDataSetChanged();
				etNewLogin.setText("");
				etNewEmail.setText("");
				etNewPassword.setText("");
				etCheckPassword.setText("");

				// LoginList [i] = (etLogin.getText().toString());
				// PasswordList [i] = (etPassword.getText().toString());
				// i=i+1;
				// etLogin.setText("");
				// etPassword.setText("");
			}

		});

		// btnAll.setOnClickListener(new OnClickListener() {

		// @Override
		// public void onClick(View v) {
		//
		// int i;
		// for (i=0; i < al.size(); i++){
		// listViewTest.setAdapter(aa);
		// al.add(0, etLogin.getText().toString());
		// aa.notifyDataSetChanged();
		// al.add(0, etPassword.getText().toString());
		// aa.notifyDataSetChanged();
		// System.out.println(al.etLogin [i]+);

		// }
		// }
		// });

	}

	// validating email id
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// validating password with retype password
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() > 5) {
			return true;
		}
		return false;
	}
}
