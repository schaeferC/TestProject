package de.bht.BeuthOrg.views;


import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.datahandler.DataHandler;
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
		finishActivity(R.layout.splash);
		finishActivity(R.layout.main);
		
		login= (Button)findViewById(R.id.login);
		login.setOnClickListener(this);
		withoutLogin=(Button) findViewById(R.id.withoutLogin);

	}


	@Override
	public void onClick(View v) {
		if(v==login){
			DataHandler.isRegistered("000041", "1234");
			Log.d("DEBUG", "");
			Log.d("DEBUG", ""+R.id.loginPopUp);
			view=findViewById(R.id.loginPopUp);
			//Toast t=new Toast(this);
			LayoutInflater inflater=this.getLayoutInflater();
			View view= inflater.inflate(R.layout.loginpopup, (ViewGroup) findViewById(R.id.loginPopUp));
			
			nameLabel=(TextView)view.findViewById(R.id.nameLabel);
			passphraseLabel=(TextView)view.findViewById(R.id.passphraseLabel);
			nameText=(EditText)view.findViewById(R.id.nameTextField);
			passphraseText=(EditText)view.findViewById(R.id.passphraseTextField);
			
			cancel= (Button)view.findViewById(R.id.cancelLog);
			cancel.setOnClickListener(this);
			enterLogin=(Button) view.findViewById(R.id.EnterLog);
			enterLogin.setOnClickListener(this);


			puw=new PopupWindow(view, 500, 500, true);
			puw.showAtLocation(view, Gravity.CENTER, 0, 0);

		}else if(v == cancel){
			startActivity(new Intent(v.getContext(),Login.class));
		}else if(v== enterLogin){

			boolean registered=DataHandler.isRegistered(nameText.getText().toString(), passphraseText.getText().toString());
			if(registered){
				//finishActivity(R.layout.loginpopup);
				//finishActivity(R.layout.login);
				Log.d("DEBUG",registered+"");
				//startActivity(new Intent(Common.DE_BHT_BEUTH_ORG+"Menu"));
				startActivity(new Intent(v.getContext(), Menu.class));
			}
		}
		
		
	}

	
}