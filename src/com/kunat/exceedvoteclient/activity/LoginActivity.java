package com.kunat.exceedvoteclient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.application.ExceedVoteApp;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity{
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */
	private static final String[] DUMMY_CREDENTIALS = new String[] {
			"foo@example.com:hello", "bar@example.com:world" };

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */


	// Values for email and password at the time of the login attempt.
	private String mEmail;

	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	private EditText mHostView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		// Set up the login form.
		mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);
		mHostView = (EditText) findViewById(R.id.host);
		mPasswordView = (EditText) findViewById(R.id.password);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						ExceedVoteApp app = (ExceedVoteApp) getApplication();
						if(!mHostView.getText().toString().equals("")){
							app.hostSet(mHostView.getText().toString());
						}
						app.login(mEmailView.getText().toString(),mPasswordView.getText().toString(),LoginActivity.this);
					}
				});
	}
	
	public void changeActivity(String result){
		if(!result.equals("error")){
			Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
			LoginActivity.this.startActivity(myIntent);
		}
		else{
			Toast.makeText(getApplicationContext(), "Connection Error check your id and your connection", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	

}
