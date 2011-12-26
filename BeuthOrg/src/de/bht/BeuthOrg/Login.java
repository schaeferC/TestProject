package de.bht.BeuthOrg;


import de.bht.BeuthOrg.util.Common;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
	
	private Button login;
	private Button withoutLogin;
	
	private TextView nameLabel;
	private TextView passphraseLabel;
	
	private EditText nameText;
	private EditText passphraseText;
	private PopupWindow puw;
	private View view;
	
	private Button cancel;
	private Button enterLogin;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		login= (Button)findViewById(R.id.login);
		login.setOnClickListener(this);
		withoutLogin=(Button) findViewById(R.id.withoutLogin);

	}


	@Override
	public void onClick(View v) {
		if(v==login){
			Log.d("DEBUG", ""+R.id.loginPopUp);
			view=findViewById(R.id.loginPopUp);
			//Toast t=new Toast(this);
			LayoutInflater inflater=this.getLayoutInflater();
			View view= inflater.inflate(R.layout.loginpopup, (ViewGroup) findViewById(R.id.loginPopUp));
			
			nameLabel=(TextView)findViewById(R.id.nameLabel);
			passphraseLabel=(TextView)findViewById(R.id.passphraseLabel);
			nameText=(EditText)findViewById(R.id.nameTextField);
			passphraseText=(EditText)findViewById(R.id.passphraseTextField);
			
			cancel= (Button)findViewById(R.id.cancelLog);
			cancel.setOnClickListener(this);
			enterLogin=(Button) findViewById(R.id.EnterLog);
			enterLogin.setOnClickListener(this);


			puw=new PopupWindow(view, 500, 500, true);
			puw.showAtLocation(view, Gravity.CENTER, 0, 0);

		}else if(v == cancel){
			startActivity(new Intent(Common.DE_BHT_BEUTH_ORG+"Login"));
		}else if(v== enterLogin){
			
		}
		
		
	}

	
}
