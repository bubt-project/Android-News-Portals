package com.example.newspotalsdemo;

import java.util.ArrayList;
import java.util.Locale;

import Model.InNewItem;
import Model.InternationalAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Interntaional_News_Activity extends Activity {

	ListView internationalNewsList;
	EditText etSearch;
	String[] urlLink;
	String keyword = "keyValue";
	private String[] internationalNewsTitle;
	private String[] internationalNewsState;

	InternationalAdapter adapter;
	ArrayList<InNewItem> NewsItemsList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.interntaional__news_activity);

		internationalNewsList = (ListView) findViewById(R.id.international_news_ListView);
		etSearch = (EditText) findViewById(R.id.et_international_search);
		internationalNewsTitle = getResources().getStringArray(
				R.array.international_news_title);

		internationalNewsState = getResources().getStringArray(
				R.array.international_state);

		NewsItemsList = new ArrayList<InNewItem>();

		for (int i = 0; i < internationalNewsTitle.length
				&& i < internationalNewsState.length; i++) {
			InNewItem ins = new InNewItem(internationalNewsTitle[i],
					internationalNewsState[i]);
			NewsItemsList.add(ins);
		}

		adapter = new InternationalAdapter(getApplicationContext(),
				NewsItemsList);
		internationalNewsList.setAdapter(adapter);

		// set search option

		etSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				String text = etSearch.getText().toString()
						.toLowerCase(Locale.getDefault());
				adapter.filter(text);
			}
		});

		// set url International link
		urlLink = getResources().getStringArray(R.array.international_news_url);

		internationalNewsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				String selected = ((TextView) v.findViewById(R.id.text_title))
						.getText().toString();

				// Toast.makeText(getApplicationContext(),
				// "you selected " + selected, Toast.LENGTH_LONG).show();
				//

				setURl(selected);

			}
		});
	}

	public void setURl(String str) {
		Intent intent = new Intent(Interntaional_News_Activity.this,
				WebViewActivity.class);
		
		if (str.equals("The New York Times")) {
			intent.putExtra(keyword, urlLink[0]);
		} else if (str.equals("The Washington Post")) {
			intent.putExtra(keyword, urlLink[1]);
		} else if (str.equals("The Wall Street Journal")) {
			intent.putExtra(keyword, urlLink[2]);
		} else if (str.equals("USA Today")) {
			intent.putExtra(keyword, urlLink[3]);
		} else if (str.equals("Los Angeles Times")) {
			intent.putExtra(keyword, urlLink[4]);
		} else if (str.equals("The Examiner")) {
			intent.putExtra(keyword, urlLink[5]);
		} else if (str.equals("Daily News")) {
			intent.putExtra(keyword, urlLink[6]);
		} else if (str.equals("Chicago Tribune")) {
			intent.putExtra(keyword, urlLink[7]);
		} else if (str.equals("Houston Chroncle")) {
			intent.putExtra(keyword, urlLink[8]);
		} else if (str.equals("New York Post")) {
			intent.putExtra(keyword, urlLink[9]);

		} else if (str.equals("The Christian Science Montor")) {
			intent.putExtra(keyword, urlLink[10]);
		} else if (str.equals("The Hollywood Reporter")) {
			intent.putExtra(keyword, urlLink[11]);
		} else if (str.equals("The Chicago Sun-Times")) {
			intent.putExtra(keyword, urlLink[12]);
		} else if (str.equals("The Washinton Times")) {
			intent.putExtra(keyword, urlLink[13]);
		} else if (str.equals("The Pladelphia Inquirer")) {
			intent.putExtra(keyword, urlLink[14]);
		} else if (str.equals("San Jose Mercury News")) {
			intent.putExtra(keyword, urlLink[15]);
		} else if (str.equals("The Onion")) {
			intent.putExtra(keyword, urlLink[16]);
		} else if (str.equals("The Denver Post")) {
			intent.putExtra(keyword, urlLink[17]);
		} else if (str.equals("Newsday")) {
			intent.putExtra(keyword, urlLink[18]);
		} else if (str.equals("The Sacramento Bee")) {
			intent.putExtra(keyword, urlLink[19]);

		} else if (str.equals("Star Tribune")) {
			intent.putExtra(keyword, urlLink[20]);
		} else if (str.equals("The Miami Herald")) {
			intent.putExtra(keyword, urlLink[21]);
		} else if (str.equals("The Dallas Mornng News")) {
			intent.putExtra(keyword, urlLink[22]);
		} else if (str.equals("The Boston Globe")) {
			intent.putExtra(keyword, urlLink[23]);
		} else if (str.equals("The Oregonian")) {
			intent.putExtra(keyword, urlLink[24]);
		} else if (str.equals("The Baltimore Sun")) {
			intent.putExtra(keyword, urlLink[25]);
		} else if (str.equals("The Seattle Times")) {
			intent.putExtra(keyword, urlLink[26]);
		} else if (str.equals("The Atlanta Journal-Constitution")) {
			intent.putExtra(keyword, urlLink[27]);
		} else if (str.equals("Boston Herald")) {
			intent.putExtra(keyword, urlLink[28]);
		} else if (str.equals("The Plain Dealer")) {
			intent.putExtra(keyword, urlLink[29]);
		}

		else if (str.equals("Detroit Free Press")) {
			intent.putExtra(keyword, urlLink[30]);
		} else if (str.equals("Seattle Post-Intelligencer")) {
			intent.putExtra(keyword, urlLink[31]);
		} else if (str.equals("Orlando Sentinel")) {
			intent.putExtra(keyword, urlLink[32]);
		} else if (str.equals("South Florida Sun-Sentinel")) {
			intent.putExtra(keyword, urlLink[33]);
		} else if (str.equals("The Hill")) {
			intent.putExtra(keyword, urlLink[34]);
		} else if (str.equals("Pittsburgh Post-Gazette")) {
			intent.putExtra(keyword, urlLink[35]);
		} else if (str.equals("Milwaukee Journal Sentinel")) {
			intent.putExtra(keyword, urlLink[36]);
		} else if (str.equals("The Kansas City Star")) {
			intent.putExtra(keyword, urlLink[37]);
		} else if (str.equals("The New York Observer")) {
			intent.putExtra(keyword, urlLink[38]);
		} else if (str.equals("St. Louis Post-Dispatch")) {
			intent.putExtra(keyword, urlLink[39]);
		}

		else if (str.equals("The Orange County Register")) {
			intent.putExtra(keyword, urlLink[40]);
		} else if (str.equals("The Columbus Dispatch")) {
			intent.putExtra(keyword, urlLink[41]);
		} else if (str.equals("Hartford Courant")) {
			intent.putExtra(keyword, urlLink[42]);
		} else if (str.equals("Express-News")) {
			intent.putExtra(keyword, urlLink[43]);
		} else if (str.equals("The News and Observer")) {
			intent.putExtra(keyword, urlLink[44]);
		} else if (str.equals("Deseret News")) {
			intent.putExtra(keyword, urlLink[45]);
		} else if (str.equals("Salt Lake Tribune")) {
			intent.putExtra(keyword, urlLink[46]);
		} else if (str.equals("Investor's Business Daily")) {
			intent.putExtra(keyword, urlLink[47]);
		} else if (str.equals("Times Union")) {
			intent.putExtra(keyword, urlLink[48]);
		} else if (str.equals("Arizona Daily Star")) {
			intent.putExtra(keyword, urlLink[49]);
		}

		else if (str.equals("The Guardian")) {
			intent.putExtra(keyword, urlLink[50]);
		} else if (str.equals("The Daily Mail")) {
			intent.putExtra(keyword, urlLink[51]);
		} else if (str.equals("The Daily Telegraph")) {
			intent.putExtra(keyword, urlLink[52]);
		} else if (str.equals("The Independent")) {
			intent.putExtra(keyword, urlLink[53]);
		} else if (str.equals("Financial Times")) {
			intent.putExtra(keyword, urlLink[54]);
		} else if (str.equals("Daily Mirror")) {
			intent.putExtra(keyword, urlLink[55]);
		} else if (str.equals("The Sun")) {
			intent.putExtra(keyword, urlLink[56]);
		} else if (str.equals("Daily Express")) {
			intent.putExtra(keyword, urlLink[57]);
		} else if (str.equals("The Times")) {
			intent.putExtra(keyword, urlLink[58]);
		} else if (str.equals("Evening Standard")) {
			intent.putExtra(keyword, urlLink[59]);
		}

		else if (str.equals("Bild")) {
			intent.putExtra(keyword, urlLink[60]);
		} else if (str.equals("Die Welt")) {
			intent.putExtra(keyword, urlLink[61]);
		} else if (str.equals("Suddeutsche Zeitung")) {
			intent.putExtra(keyword, urlLink[62]);
		} else if (str.equals("Die Zeit")) {
			intent.putExtra(keyword, urlLink[63]);
		} else if (str.equals("Handelsblatt")) {
			intent.putExtra(keyword, urlLink[64]);
		} else if (str.equals("Rheinische Post")) {
			intent.putExtra(keyword, urlLink[65]);
		} else if (str.equals("Die Tageszeitung")) {
			intent.putExtra(keyword, urlLink[66]);
		} else if (str.equals("Hamburger Abendblatt")) {
			intent.putExtra(keyword, urlLink[67]);
		} else if (str.equals("The Times of India")) {
			intent.putExtra(keyword, urlLink[68]);
		} else if (str.equals("The Hindu")) {
			intent.putExtra(keyword, urlLink[69]);
		}

		else if (str.equals("The Hindustan Times")) {
			intent.putExtra(keyword, urlLink[70]);
		} else if (str.equals("Dainik Bhaskar")) {
			intent.putExtra(keyword, urlLink[71]);
		} else if (str.equals("The People's Daily")) {
			intent.putExtra(keyword, urlLink[72]);
		} else if (str.equals("Qingdao News")) {
			intent.putExtra(keyword, urlLink[73]);
		} else if (str.equals("Yangtse Evening Post")) {
			intent.putExtra(keyword, urlLink[74]);
		} else if (str.equals("La Repubblica")) {
			intent.putExtra(keyword, urlLink[75]);
		} else if (str.equals("Corriere della Sera")) {
			intent.putExtra(keyword, urlLink[76]);
		} else if (str.equals("II Sole24 Ore")) {
			intent.putExtra(keyword, urlLink[77]);
		} else if (str.equals("La Gazzetta dello Sport")) {
			intent.putExtra(keyword, urlLink[78]);
		} else if (str.equals("La Stampa")) {
			intent.putExtra(keyword, urlLink[79]);
		}

		else if (str.equals("El Pais")) {
			intent.putExtra(keyword, urlLink[80]);
		} else if (str.equals("ABC")) {
			intent.putExtra(keyword, urlLink[81]);
		} else if (str.equals("AS")) {
			intent.putExtra(keyword, urlLink[82]);
		} else if (str.equals("El Economista")) {
			intent.putExtra(keyword, urlLink[83]);
		} else if (str.equals("La Vanguardia")) {
			intent.putExtra(keyword, urlLink[84]);
		} else if (str.equals("Le Monde")) {
			intent.putExtra(keyword, urlLink[85]);
		} else if (str.equals("Liberation")) {
			intent.putExtra(keyword, urlLink[86]);
		} else if (str.equals("Le Nouvel Observateur")) {
			intent.putExtra(keyword, urlLink[87]);
		} else if (str.equals("L'Equipe")) {
			intent.putExtra(keyword, urlLink[88]);
		} else if (str.equals("Les Echos")) {
			intent.putExtra(keyword, urlLink[89]);
		}

		else if (str.equals("Milliyet")) {
			intent.putExtra(keyword, urlLink[90]);
		} else if (str.equals("Sabah")) {
			intent.putExtra(keyword, urlLink[91]);
		} else if (str.equals("Zaman")) {
			intent.putExtra(keyword, urlLink[92]);
		} else if (str.equals("Asahi Shimbun")) {
			intent.putExtra(keyword, urlLink[93]);
		} else if (str.equals("Yomiuri Shimbun")) {
			intent.putExtra(keyword, urlLink[94]);
		} else if (str.equals("Nihon Keizai Shimbun")) {
			intent.putExtra(keyword, urlLink[95]);
		} else if (str.equals("The Japan Times")) {
			intent.putExtra(keyword, urlLink[96]);
		} else if (str.equals("Mainichi Shimbun")) {
			intent.putExtra(keyword, urlLink[97]);
		} else if (str.equals("Nikkan Sports")) {
			intent.putExtra(keyword, urlLink[98]);
		} else if (str.equals("Sankei Sports")) {
			intent.putExtra(keyword, urlLink[99]);
		}

		else if (str.equals("The Age")) {
			intent.putExtra(keyword, urlLink[100]);
		} else if (str.equals("Herald Sun")) {
			intent.putExtra(keyword, urlLink[101]);
		} else if (str.equals("The Advertiser")) {
			intent.putExtra(keyword, urlLink[102]);
		} else if (str.equals("Kommersant")) {
			intent.putExtra(keyword, urlLink[103]);
		} else if (str.equals("Rossiyskaya Gazeta")) {
			intent.putExtra(keyword, urlLink[104]);
		} else if (str.equals("Charin")) {
			intent.putExtra(keyword, urlLink[105]);
		} else if (str.equals("La Nacion")) {
			intent.putExtra(keyword, urlLink[106]);
		} else if (str.equals("Pagina/12")) {
			intent.putExtra(keyword, urlLink[107]);
		} else if (str.equals("Aftonbladet")) {
			intent.putExtra(keyword, urlLink[108]);
		} else if (str.equals("Dagens Nyheter")) {
			intent.putExtra(keyword, urlLink[109]);
		}
		// completed here
		else if (str.equals("The Jerusalem Post")) {
			intent.putExtra(keyword, urlLink[110]);
		} else if (str.equals("Haaretz")) {
			intent.putExtra(keyword, urlLink[111]);
		} else if (str.equals("Yediot Aharonot")) {
			intent.putExtra(keyword, urlLink[112]);
		} else if (str.equals("Dagbladet")) {
			intent.putExtra(keyword, urlLink[113]);
		} else if (str.equals("Verdens Gang")) {
			intent.putExtra(keyword, urlLink[114]);
		} else if (str.equals("Aftenposten")) {
			intent.putExtra(keyword, urlLink[115]);
		} else if (str.equals("The Globe and Mail")) {
			intent.putExtra(keyword, urlLink[116]);
		} else if (str.equals("The Toronto Star")) {
			intent.putExtra(keyword, urlLink[117]);
		} else if (str.equals("The Vancouver Sun")) {
			intent.putExtra(keyword, urlLink[118]);
		} else if (str.equals("Toronto Sun")) {
			intent.putExtra(keyword, urlLink[119]);
		}

		else if (str.equals("Algemeen Dagblad")) {
			intent.putExtra(keyword, urlLink[120]);
		} else if (str.equals("NRC Handelsblad")) {
			intent.putExtra(keyword, urlLink[121]);
		} else if (str.equals("United Daily News")) {
			intent.putExtra(keyword, urlLink[122]);
		} else if (str.equals("China Times")) {
			intent.putExtra(keyword, urlLink[123]);
		} else if (str.equals("Arab News")) {
			intent.putExtra(keyword, urlLink[124]);
		} else if (str.equals("Asharq Al-Awsat")) {
			intent.putExtra(keyword, urlLink[125]);
		} else if (str.equals("Gazeta Wyborcza")) {
			intent.putExtra(keyword, urlLink[126]);
		} else if (str.equals("Mlada fronta Dnes")) {
			intent.putExtra(keyword, urlLink[127]);
		} else if (str.equals("O Globo")) {
			intent.putExtra(keyword, urlLink[128]);
		} else if (str.equals("The New Zealand Herald")) {
			intent.putExtra(keyword, urlLink[129]);
		}

		else if (str.equals("Al-Ahram")) {
			intent.putExtra(keyword, urlLink[130]);
		} else if (str.equals("Philippine Daily Inquirer")) {
			intent.putExtra(keyword, urlLink[131]);
		} else if (str.equals("The Star Online")) {
			intent.putExtra(keyword, urlLink[132]);
		} else if (str.equals("Kompas")) {
			intent.putExtra(keyword, urlLink[133]);
		} else if (str.equals("Dawn")) {
			intent.putExtra(keyword, urlLink[134]);
		} else if (str.equals("The Irish Independent")) {
			intent.putExtra(keyword, urlLink[135]);
		} else if (str.equals("Het Nieuwsblad")) {
			intent.putExtra(keyword, urlLink[136]);
		} else if (str.equals("The Straits Times")) {
			intent.putExtra(keyword, urlLink[137]);
		} else if (str.equals("Gulf News")) {
			intent.putExtra(keyword, urlLink[138]);
		} else if (str.equals("Die Presse")) {
			intent.putExtra(keyword, urlLink[139]);
		} else if (str.equals("o Vima")) {
			intent.putExtra(keyword, urlLink[140]);
		} else if (str.equals("El Unversal")) {
			intent.putExtra(keyword, urlLink[141]);
		}
		startActivity(intent);
	}

}
