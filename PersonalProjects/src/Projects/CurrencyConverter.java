package Projects;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {
	public void start(Stage mainstage) {
		String[]currency1arr= 
			{"Afghan Afghani",
			 "Albanian Lek",
			 "Algerian Dinar",
			 "Angolan Kwanza",
			 "Argentine Peso",
			 "Armenian Dram",
			 "Aruban Florin",
			 "Australian Dollar",
			 "Azeri Manat",
			 "Bahamian Dollar",
			 "Bahraini Dinar",
			 "Bengali Taka",
			 "Barbadian Dollar",
			 "Belarusian Ruble",
			 "Belize Dollar",
			 "Bermudian Dollar",
			 "Bhutanese Ngultrum",
			 "Bolivian Boliviano",
			 "Bosnian Mark",
			 "Botswanan Pula",
			 "Brazilian Real",
			 "Brunei Dollar",
			 "Bulgarian Lev",
			 "Burundian Franc",
			 "Cambodian Riel",
			 "Central African Franc",
			 "Canadian Dollar",
			 "Cape Verdean Escudo",
			 "Cayman Islands Dollar",
			 "Chilean Peso",
			 "Chinese Yuan",
			 "Colombian Peso",
			 "Comorian Franc",
			 "Congolese Franc",
			 "Costa Rican Colon",
			 "Croatian Kuna",
			 "Cuban Peso",
			 "Netherlands Antillean Guilder",
			 "Czech Koruna",
			 "Danish Krone",
			 "Djiboutian Franc",
			 "Eastern Caribbean Dollar",
			 "Dominican Peso",
			 "Egyptian Pound",
			 "Eritrean Nakfa",
			 "Swazi Lilangeni",
			 "European Euro",
			 "Ethiopian Birr",
			 "Falkland Islands Pounds",
			 "Farose Krona",
			 "Fijian Dollar",
			 "CFP Franc",
			 "Gambian Dalasi",
			 "Georgian Lari",
			 "Ghanaian Cedi",
			 "Gibraltar Pounds",
			 "Guatemalan Quetzal",
			 "Guinean Franc",
			 "Guyanese Dollar",
			 "Haitian Gourde",
			 "Honduras Lempira",
			 "Hong Kong Dollar",
			 "Hungarian Forint",
			 "Icelandic Krona",
			 "Indian Rupee",
			 "Indonesian Rupiah",
			 "Iranian Rial",
			 "Iraqi Dinar",
			 "Israeli Shekel",
			 "Jamaica Dollar",
			 "Japanese Yen",
			 "Jordanian Dinar",
			 "Kazakhstani Tenge",
			 "Kenyan Shilling",
		  	 "Kiribati Dollar",
			 "North Korean Won",
			 "South Korean Won",
			 "Kuwaiti Dinar",
			 "Kyrgystani Som",
			 "Laotian Kip",
			 "Lebanese Pound",
			 "Lesotho Loti",
			 "Liberian Dollar",
			 "Libyan Dinar",
			 "Macanese Pataca",
			 "Malagasy Ariary",
			 "Malawian Kwacha",
			 "Malaysian Ringgit",
			 "Maldivian Rufiyaa",
			 "Mauritanian Ouguiya",
			 "Mauritius Rupee",
			 "Mexican Peso",
			 "Moldovan Leu",
			 "Mongolian Togrog",
			 "Moroccan Dirham",
			 "Monzambican Metical",
			 "Burmese Kyat",
			 "Namibia Dollar",
			 "Nepalese Rupee",
			 "New Zealand Dollar",
			 "Nicaraguan Cordoba",
			 "Nigerian Naira",
			 "Niue Dollar",
			 "North Macedonian Denar",
			 "Norwegian Krone",
 			 "Omani Rial",
			 "Pakistani Rupee",
			 "Panamanian Balboa",
		 	 "Papua New Guinean Kina",
			 "Paraguayan Guarani",
			 "Peruvian Sol",
			 "Phillipine Peso",
			 "New Zealand Dollar",
			 "Polish Zloty",
			 "Qatari Riyal",
			 "Romanian Leu",
			 "Russian Ruble",
			 "Rwandan Franc",
			 "Sahrawi Peseta",
			 "Saint Helena Pound",
			 "Samoan Tala",
			 "Sao Tome and Principe Dobra",
			 "Saudi Riyal",
			 "Serbian Dinar",
			 "Seychellois Rupee",
			 "Sierra Leonean Leone",
			 "Singaporean Dollar",
			 "Solomon Islands Dollar",
			 "Somali Shilling",
			 "Somaliland Shilling",
			 "South African Rand",
			 "South Sudanese Pound",
			 "Sri Lankan Rupee",
			 "Sudanese Pound",
			 "Surinamese Dollar",
			 "Swedish Krona",
			 "Swiss Franc",
			 "Syrian Pound",
			 "New Taiwan Dollar",
			 "Tajikistani Somoni",
			 "Tanzanian Shilling",
			 "Thai Baht",
			 "Tongan Pa'anga",
			 "Transnistrian Ruble",
			 "Trinidad and Tobago Dollar",
			 "Tunisian Dinar",
			 "Turkish Lira",
			 "Turkmenistan Manat",
			 "Tuvaluan Dollar",
			 "Ugandan Shilling",
			 "Ukranian Hryvnia",
			 "United Arab Emirates Dirham",
			 "British Pound",
			 "United States Dollar",
			 "Uruguayan Peso",
			 "Uzbekistani So'm",
			 "Vanuatu Vatu",
			 "Venezeualan Bolivar Soberano",
			 "Vietnamese Dong",
			 "West African Franc",
			 "Yemeni Rial",
			 "Zambian Kwacha",
			 "Zimbabwe RTGS Dollar"		
			};
			String[]currency2arr= 
				{"Afghan Afghani",
				 "Albanian Lek",
				 "Algerian Dinar",
				 "Angolan Kwanza",
				 "Argentine Peso",
				 "Armenian Dram",
				 "Aruban Florin",
				 "Australian Dollar",
				 "Azeri Manat",
				 "Bahamian Dollar",
				 "Bahraini Dinar",
				 "Bengali Taka",
				 "Barbadian Dollar",
				 "Belarusian Ruble",
				 "Belize Dollar",
				 "Bermudian Dollar",
				 "Bhutanese Ngultrum",
				 "Bolivian Boliviano",
				 "Bosnian Mark",
				 "Botswanan Pula",
				 "Brazilian Real",
				 "Brunei Dollar",
				 "Bulgarian Lev",
				 "Burundian Franc",
				 "Cambodian Riel",
				 "Central African Franc",
				 "Canadian Dollar",
				 "Cape Verdean Escudo",
				 "Cayman Islands Dollar",
				 "Chilean Peso",
				 "Chinese Yuan",
				 "Colombian Peso",
				 "Comorian Franc",
				 "Congolese Franc",
				 "Costa Rican Colon",
				 "Croatian Kuna",
				 "Cuban Peso",
				 "Netherlands Antillean Guilder",
				 "Czech Koruna",
				 "Danish Krone",
				 "Djiboutian Franc",
				 "Eastern Caribbean Dollar",
				 "Dominican Peso",
				 "Egyptian Pound",
				 "Eritrean Nakfa",
				 "Swazi Lilangeni",
				 "European Euro",
				 "Ethiopian Birr",
				 "Falkland Islands Pounds",
				 "Farose Krona",
				 "Fijian Dollar",
				 "CFP Franc",
				 "Gambian Dalasi",
				 "Georgian Lari",
				 "Ghanaian Cedi",
				 "Gibraltar Pounds",
				 "Guatemalan Quetzal",
				 "Guinean Franc",
				 "Guyanese Dollar",
				 "Haitian Gourde",
				 "Honduras Lempira",
				 "Hong Kong Dollar",
				 "Hungarian Forint",
				 "Icelandic Krona",
				 "Indian Rupee",
				 "Indonesian Rupiah",
				 "Iranian Rial",
				 "Iraqi Dinar",
				 "Israeli Shekel",
				 "Jamaica Dollar",
				 "Japanese Yen",
				 "Jersey Pound",
				 "Jordanian Dinar",
				 "Kazakhstani Tenge",
				 "Kenyan Shilling",
			  	 "Kiribati Dollar",
				 "North Korean Won",
				 "South Korean Won",
				 "Kuwaiti Dinar",
				 "Kyrgystani Som",
				 "Laotian Kip",
				 "Lebanese Pound",
				 "Lesotho Loti",
				 "Liberian Dollar",
				 "Libyan Dinar",
				 "Macanese Pataca",
				 "Malagasy Ariary",
				 "Malawian Kwacha",
				 "Malaysian Ringgit",
				 "Maldivian Rufiyaa",
				 "Mauritanian Ouguiya",
				 "Mauritius Rupee",
				 "Mexican Peso",
				 "Moldovan Leu",
				 "Mongolian Togrog",
				 "Moroccan Dirham",
				 "Monzambican Metical",
				 "Burmese Kyat",
				 "Namibia Dollar",
				 "Nepalese Rupee",
				 "New Zealand Dollar",
				 "Nicaraguan Cordoba",
				 "Nigerian Naira",
				 "Niue Dollar",
				 "North Macedonian Denar",
				 "Norwegian Krone",
	 			 "Omani Rial",
				 "Pakistani Rupee",
				 "Panamanian Balboa",
			 	 "Papua New Guinean Kina",
				 "Paraguayan Guarani",
				 "Peruvian Sol",
				 "Phillipine Peso",
				 "New Zealand Dollar",
				 "Polish Zloty",
				 "Qatari Riyal",
				 "Romanian Leu",
				 "Russian Ruble",
				 "Rwandan Franc",
				 "Sahrawi Peseta",
				 "Saint Helena Pound",
				 "Samoan Tala",
				 "Sao Tome and Principe Dobra",
				 "Saudi Riyal",
				 "Serbian Dinar",
				 "Seychellois Rupee",
				 "Sierra Leonean Leone",
				 "Singaporean Dollar",
				 "Solomon Islands Dollar",
				 "Somali Shilling",
				 "Somaliland Shilling",
				 "South African Rand",
				 "South Sudanese Pound",
				 "Sri Lankan Rupee",
				 "Sudanese Pound",
				 "Surinamese Dollar",
				 "Swedish Krona",
				 "Swiss Franc",
				 "Syrian Pound",
				 "New Taiwan Dollar",
				 "Tajikistani Somoni",
				 "Tanzanian Shilling",
				 "Thai Baht",
				 "Tongan Pa'anga",
				 "Transnistrian Ruble",
				 "Trinidad and Tobago Dollar",
				 "Tunisian Dinar",
				 "Turkish Lira",
				 "Turkmenistan Manat",
				 "Tuvaluan Dollar",
				 "Ugandan Shilling",
				 "Ukranian Hryvnia",
				 "United Arab Emirates Dirham",
				 "British Pound",
				 "United States Dollar",
				 "Uruguayan Peso",
				 "Uzbekistani So'm",
				 "Vanuatu Vatu",
				 "Venezeualan Bolivar Soberano",
				 "Vietnamese Dong",
				 "West African Franc",
				 "Yemeni Rial",
				 "Zambian Kwacha",
				 "Zimbabwe RTGS Dollar"		
				};
			
			
			Label Currencyequals=new Label("=");
			ComboBox Currencybox1=new ComboBox(FXCollections.observableArrayList(currency1arr));
			TextField Currency1text=new TextField();
			ComboBox Currencybox2=new ComboBox(FXCollections.observableArrayList(currency2arr));
			TextField Currency2text=new TextField();
			Currency1text.setOnKeyPressed(new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e) {
					if(!Currency1text.getText().isEmpty()&&e.getCode().equals(KeyCode.ENTER)){
						String CInitial1="";
						String CInitial2="result";
						if(Currencybox1.getValue().toString().equals("Afghan Afghani")){
							CInitial1="AFN";
						}if(Currencybox2.getValue().toString().equals("Afghan Afghani")){
							CInitial2="AFN";
						}if(Currencybox1.getValue().toString().equals("Albanian Lek")) {
							CInitial1="ALL";
						}if(Currencybox2.getValue().toString().equals("Albanian Lek")) {
							CInitial2="ALL";
						}if(Currencybox1.getValue().toString().equals("Algerian Dinar")) {
							CInitial1="DZD";
						}if(Currencybox2.getValue().toString().equals("Algerian Dinar")) {
							CInitial2="DZD";
						}if(Currencybox1.getValue().toString().equals("Angolan Kwanza")) {
							CInitial1="AOA";
						}if(Currencybox2.getValue().toString().equals("Angolan Kwanza")) {
							CInitial2="AOA";
						}if(Currencybox1.getValue().toString().equals("Argentine Peso")) {
							CInitial1="ARS";
						}if(Currencybox2.getValue().toString().equals("Argentine Peso")) {
							CInitial2="ARS";
						}if(Currencybox1.getValue().toString().equals("Armenian Dram")) {
							CInitial1="AMD";
						}if(Currencybox2.getValue().toString().equals("Armenian Dram")) {
							CInitial2="AMD";
						}if(Currencybox1.getValue().toString().equals("Aruban Florin")) {
							CInitial1="AWG";
						}if(Currencybox2.getValue().toString().equals("Aruban Florin")) {
							CInitial2="AWG";
						}if(Currencybox1.getValue().toString().equals("Australian Dollar")) {
							CInitial1="AUD";
						}if(Currencybox2.getValue().toString().equals("Australian Dollar")) {
							CInitial2="AUD";
						}if(Currencybox1.getValue().toString().equals("Azeri Manat")) {
							CInitial1="AZN";
						}if(Currencybox2.getValue().toString().equals("Azeri Manat")) {
							CInitial2="AZN";
						}if(Currencybox1.getValue().toString().equals("Bahamian Dollar")) {
							CInitial1="BSD";
						}if(Currencybox2.getValue().toString().equals("Bahamian Dollar")) {
							CInitial2="BSD";
						}if(Currencybox1.getValue().toString().equals("Bahraini Dinar")) {
							CInitial1="BHD";
						}if(Currencybox2.getValue().toString().equals("Bahraini Dinar")) {
							CInitial2="BHD";
						}if(Currencybox1.getValue().toString().equals("Bengali Taka")) {
							CInitial1="BDT";
						}if(Currencybox2.getValue().toString().equals("Bengali Taka")) {
							CInitial2="BDT";
						}if(Currencybox1.getValue().toString().equals("Barbadian Dollar")) {
							CInitial1="BBD";
						}if(Currencybox2.getValue().toString().equals("Barbadian Dollar")) {
							CInitial2="BBD";
						}if(Currencybox1.getValue().toString().equals("Belarusian Ruble")) {
							CInitial1="BYN";
						}if(Currencybox2.getValue().toString().equals("Belarusian Ruble")) {
							CInitial2="BYN";
						}if(Currencybox1.getValue().toString().equals("Belize Dollar")) {
							CInitial1="BZD";
						}if(Currencybox2.getValue().toString().equals("Belize Dollar")) {
							CInitial2="BZD";
						}if(Currencybox1.getValue().toString().equals("Bermudian Dollar")) {
							CInitial1="BMD";
						}if(Currencybox2.getValue().toString().equals("Bermudian Dollar")) {
							CInitial2="BMD";
						}if(Currencybox1.getValue().toString().equals("Bhutanese Ngultrum")) {
							CInitial1="BTN";
						}if(Currencybox2.getValue().toString().equals("Bhutanese Ngultrum")) {
							CInitial2="BTN";
						}if(Currencybox1.getValue().toString().equals("Bolivian Boliviano")) {
							CInitial1="BOB";
						}if(Currencybox2.getValue().toString().equals("Bolivian Boliviano")) {
							CInitial2="BOB";
						}if(Currencybox1.getValue().toString().equals("Bosnian Mark")) {
							CInitial1="BAM";
						}if(Currencybox2.getValue().toString().equals("Bosnian Mark")) {
							CInitial2="BAM";
						}if(Currencybox1.getValue().toString().equals("Botswanan Pula")) {
							CInitial1="BWP";
						}if(Currencybox2.getValue().toString().equals("Botswanan Pula")) {
							CInitial2="BWP";
						}if(Currencybox1.getValue().toString().equals("Brazilian Real")) {
							CInitial1="BRL";
						}if(Currencybox2.getValue().toString().equals("Brazilian Real")) {
							CInitial2="BRL";
						}if(Currencybox1.getValue().toString().equals("Brunei Dollar")) {
							CInitial1="BND";
						}if(Currencybox2.getValue().toString().equals("Brunei Dollar")) {
							CInitial2="BND";
						}if(Currencybox1.getValue().toString().equals("Bulgarian Lev")) {
							CInitial1="BGN";
						}if(Currencybox2.getValue().toString().equals("Bulgarian Lev")) {
							CInitial2="BGN";
						}if(Currencybox1.getValue().toString().equals("Burundian Franc")) {
							CInitial1="BIF";
						}if(Currencybox2.getValue().toString().equals("Burundian Franc")) {
							CInitial2="BIF";
						}if(Currencybox1.getValue().toString().equals("Cambodian Riel")) {
							CInitial1="KHR";
						}if(Currencybox2.getValue().toString().equals("Cambodian Riel")) {
							CInitial2="KHR";
						}if(Currencybox1.getValue().toString().equals("Central African Franc")) {
							CInitial1="XAF";
						}if(Currencybox2.getValue().toString().equals("Central African Franc")) {
							CInitial2="XAF";
						}if(Currencybox1.getValue().toString().equals("Canadian Dollar")) {
							CInitial1="CAD";
						}if(Currencybox2.getValue().toString().equals("Canadian Dollar")) {
							CInitial2="CAD";
						}if(Currencybox1.getValue().toString().equals("Cape Verdean Escudo")) {
							CInitial1="CVE";
						}if(Currencybox2.getValue().toString().equals("Cape Verdean Escudo")) {
							CInitial2="CVE";
						}if(Currencybox1.getValue().toString().equals("Cayman Islands Dollar")) {
							CInitial1="KYD";
						}if(Currencybox2.getValue().toString().equals("Cayman Islands Dollar")) {
							CInitial2="KYD";
						}if(Currencybox1.getValue().toString().equals("Chilean Peso")) {
							CInitial1="CLP";
						}if(Currencybox2.getValue().toString().equals("Chilean Peso")) {
							CInitial2="CLP";
						}if(Currencybox1.getValue().toString().equals("Chinese Yuan")) {
							CInitial1="CYN";
						}if(Currencybox2.getValue().toString().equals("Chinese Yuan")) {
							CInitial2="CYN";
						}if(Currencybox1.getValue().toString().equals("Colombian Peso")) {
							CInitial1="COP";
						}if(Currencybox2.getValue().toString().equals("Colombian Peso")) {
							CInitial2="COP";
						}if(Currencybox1.getValue().toString().equals("Comorian Franc")) {
							CInitial1="KMF";
						}if(Currencybox2.getValue().toString().equals("Comorian Franc")) {
							CInitial2="KMF";
						}if(Currencybox1.getValue().toString().equals("Congolese Franc")) {
							CInitial1="CDF";
						}if(Currencybox2.getValue().toString().equals("Congolese Franc")) {
							CInitial2="CDF";
						}if(Currencybox1.getValue().toString().equals("Costa Rican Colon")) {
							CInitial1="CRC";
						}if(Currencybox2.getValue().toString().equals("Costa Rican Colon")) {
							CInitial2="CRC";
						}if(Currencybox1.getValue().toString().equals("Croatian Kuna")) {
							CInitial1="HRK";
						}if(Currencybox2.getValue().toString().equals("Croatian Kuna")) {
							CInitial2="HRK";
						}if(Currencybox1.getValue().toString().equals("Cuban Peso")) {
							CInitial1="CUP";
						}if(Currencybox2.getValue().toString().equals("Cuban Peso")) {
							CInitial2="CUP";
						}if(Currencybox1.getValue().toString().equals("Netherlands Antillean Guilder")) {
							CInitial1="ANG";
						}if(Currencybox2.getValue().toString().equals("Netherlands Antillean Guilder")) {
							CInitial2="ANG";
						}if(Currencybox1.getValue().toString().equals("Czech Koruna")) {
							CInitial1="CZK";
						}if(Currencybox2.getValue().toString().equals("Czech Koruna")) {
							CInitial2="CZK";
						}if(Currencybox1.getValue().toString().equals("Danish Krone")) {
							CInitial1="DKK";
						}if(Currencybox2.getValue().toString().equals("Danish Krone")) {
							CInitial2="DKK";
						}if(Currencybox1.getValue().toString().equals("Djiboutian Franc")) {
							CInitial1="DJF";
						}if(Currencybox2.getValue().toString().equals("Djiboutian Franc")) {
							CInitial2="DJF";
						}if(Currencybox1.getValue().toString().equals("Dominican Peso")) {
							CInitial1="DOP";
						}if(Currencybox2.getValue().toString().equals("Dominican Peso")) {
							CInitial2="DOP";
						}if(Currencybox1.getValue().toString().equals("Eastern Caribbean Dollar")) {
							CInitial1="XCD";
						}if(Currencybox2.getValue().toString().equals("Eastern Caribbean Dollar")) {
							CInitial2="XCD";
						}if(Currencybox1.getValue().toString().equals("Egyptian Pound")) {
							CInitial1="EGP";
						}if(Currencybox2.getValue().toString().equals("Egyptian Pound")) {
							CInitial2="EGP";
						}if(Currencybox1.getValue().toString().equals("Eritrean Nakfa")) {
							CInitial1="ERN";
						}if(Currencybox2.getValue().toString().equals("Eritrean Nakfa")) {
							CInitial2="ERN";
						}if(Currencybox1.getValue().toString().equals("Swazi Lilangeni")) {
							CInitial1="SZL";
						}if(Currencybox2.getValue().toString().equals("Swazi Lilangeni")) {
							CInitial2="SZL";
						}if(Currencybox1.getValue().toString().equals("European Euro")) {
							CInitial1="EUR";
						}if(Currencybox2.getValue().toString().equals("European Euro")) {
							CInitial2="EUR";
						}if(Currencybox1.getValue().toString().equals("Ethiopian Birr")) {
							CInitial1="ETB";
						}if(Currencybox2.getValue().toString().equals("Ethiopian Birr")) {
							CInitial2="ETB";
						}if(Currencybox1.getValue().toString().equals("Falkland Islands Pounds")) {
							CInitial1="FKP";
						}if(Currencybox2.getValue().toString().equals("Falkland Islands Pounds")) {
							CInitial2="FKP";
						}if(Currencybox1.getValue().toString().equals("Fijian Dollar")) {
							CInitial1="FJD";
						}if(Currencybox2.getValue().toString().equals("Fijian Dollar")) {
							CInitial2="FJD";
						}if(Currencybox1.getValue().toString().equals("CFP Franc")) {
							CInitial1="XPF";
						}if(Currencybox2.getValue().toString().equals("CFP Franc")) {
							CInitial2="XPF";
						}if(Currencybox1.getValue().toString().equals("Gambian Dalasi")) {
							CInitial1="GMD";
						}if(Currencybox2.getValue().toString().equals("Gambian Dalasi")) {
							CInitial2="GMD";
						}if(Currencybox1.getValue().toString().equals("Georgian Lari")) {
							CInitial1="GEL";
						}if(Currencybox2.getValue().toString().equals("Georgian Lari")) {
							CInitial2="GEL";
						}if(Currencybox1.getValue().toString().equals("Ghanaian Cedi")) {
							CInitial1="GHS";
						}if(Currencybox2.getValue().toString().equals("Ghanaian Cedi")) {
							CInitial2="GHS";
						}if(Currencybox1.getValue().toString().equals("Gibraltar Pounds")) {
							CInitial1="GIP";
						}if(Currencybox2.getValue().toString().equals("Gibraltar Pounds")) {
							CInitial2="GIP";
						}if(Currencybox1.getValue().toString().equals("Guatemalan Quetzal")) {
							CInitial1="GTQ";
						}if(Currencybox2.getValue().toString().equals("Guatemalan Quetzal")) {
							CInitial2="GTQ";
						}if(Currencybox1.getValue().toString().equals("Guinean Franc")) {
							CInitial1="GNF";
						}if(Currencybox2.getValue().toString().equals("Guinean Franc")) {
							CInitial2="GNF";
						}if(Currencybox1.getValue().toString().equals("Guyanese Dollar")) {
							CInitial1="GYD";
						}if(Currencybox2.getValue().toString().equals("Guyanese Dollar")) {
							CInitial2="GYD";
						}if(Currencybox1.getValue().toString().equals("Haitian Gourde")) {
							CInitial1="HTG";
						}if(Currencybox2.getValue().toString().equals("Haitian Gourde")) {
							CInitial2="HTG";
						}if(Currencybox1.getValue().toString().equals("Honduras Lempira")) {
							CInitial1="HNL";
						}if(Currencybox2.getValue().toString().equals("Honduras Lempira")) {
							CInitial2="HNL";
						}if(Currencybox1.getValue().toString().equals("Hong Kong Dollar")) {
							CInitial1="HKD";
						}if(Currencybox2.getValue().toString().equals("Hong Kong Dollar")) {
							CInitial2="HKD";
						}if(Currencybox1.getValue().toString().equals("Hungarian Forint")) {
							CInitial1="HUF";
						}if(Currencybox2.getValue().toString().equals("Hungarian Forint")) {
							CInitial2="HUF";
						}if(Currencybox1.getValue().toString().equals("Icelandic Krona")) {
							CInitial1="ISK";
						}if(Currencybox2.getValue().toString().equals("Icelandic Krona")) {
							CInitial2="ISK";
						}if(Currencybox1.getValue().toString().equals("Indian Rupee")) {
							CInitial1="INR";
						}if(Currencybox2.getValue().toString().equals("Indian Rupee")) {
							CInitial2="INR";
						}if(Currencybox1.getValue().toString().equals("Indonesian Rupiah")) {
							CInitial1="IDR";
						}if(Currencybox2.getValue().toString().equals("Indonesian Rupiah")) {
							CInitial2="IDR";
						}if(Currencybox1.getValue().toString().equals("Iranian Rial")) {
							CInitial1="IRR";
						}if(Currencybox2.getValue().toString().equals("Iranian Rial")) {
							CInitial2="IRR";
						}if(Currencybox1.getValue().toString().equals("Iraqi Dinar")) {
							CInitial1="IQD";
						}if(Currencybox2.getValue().toString().equals("Iraqi Dinar")) {
							CInitial2="IQD";
						}if(Currencybox1.getValue().toString().equals("Israeli Shekel")) {
							CInitial1="ILS";
						}if(Currencybox2.getValue().toString().equals("Israeli Shekel")) {
							CInitial2="ILS";
						}if(Currencybox1.getValue().toString().equals("Jamaica Dollar")) {
							CInitial1="JMD";
						}if(Currencybox2.getValue().toString().equals("Jamaica Dollar")) {
							CInitial2="JMD";
						}if(Currencybox1.getValue().toString().equals("Japanese Yen")) {
							CInitial1="JPY";
						}if(Currencybox2.getValue().toString().equals("Japanese Yen")) {
							CInitial2="JPY";
						}if(Currencybox1.getValue().toString().equals("Jordanian Dinar")) {
							CInitial1="JOD";
						}if(Currencybox2.getValue().toString().equals("Jordanian Dinar")) {
							CInitial2="JOD";
						}if(Currencybox1.getValue().toString().equals("Kazakhstani Tenge")) {
							CInitial1="KZT";
						}if(Currencybox2.getValue().toString().equals("Kazakhstani Tenge")) {
							CInitial2="KZT";
						}if(Currencybox1.getValue().toString().equals("Kenyan Shilling")) {
							CInitial1="KES";
						}if(Currencybox2.getValue().toString().equals("Kenyan Shilling")) {
							CInitial2="KES";
						}if(Currencybox1.getValue().toString().equals("North Korean Won")) {
							CInitial1="KPW";
						}if(Currencybox2.getValue().toString().equals("North Korean Won")) {
							CInitial2="KPW";
						}if(Currencybox1.getValue().toString().equals("South Korean Won")) {
							CInitial1="KRW";
						}if(Currencybox2.getValue().toString().equals("South Korean Won")) {
							CInitial2="KRW";
						}if(Currencybox1.getValue().toString().equals("Kuwaiti Dinar")) {
							CInitial1="KWD";
						}if(Currencybox2.getValue().toString().equals("Kuwaiti Dinar")) {
							CInitial2="KWD";
						}if(Currencybox1.getValue().toString().equals("Kyrgystani Som")) {
							CInitial1="KGS";
						}if(Currencybox2.getValue().toString().equals("Kyrgystani Som")) {
							CInitial2="KGS";
						}if(Currencybox1.getValue().toString().equals("Laotian Kip")) {
							CInitial1="LAK";
						}if(Currencybox2.getValue().toString().equals("Laotian Kip")) {
							CInitial2="LAK";
						}if(Currencybox1.getValue().toString().equals("Lebanese Pound")) {
							CInitial1="LBP";
						}if(Currencybox2.getValue().toString().equals("Lebanese Pound")) {
							CInitial2="LBP";
						}if(Currencybox1.getValue().toString().equals("Lesotho Loti")) {
							CInitial1="LSL";
						}if(Currencybox2.getValue().toString().equals("Lesotho Loti")) {
							CInitial2="LSL";
						}if(Currencybox1.getValue().toString().equals("Liberian Dollar")) {
							CInitial1="LRD";
						}if(Currencybox2.getValue().toString().equals("Liberian Dollar")) {
							CInitial2="LRD";
						}if(Currencybox1.getValue().toString().equals("Libyan Dinar")) {
							CInitial1="LYD";
						}if(Currencybox2.getValue().toString().equals("Libyan Dinar")) {
							CInitial2="LYD";
						}if(Currencybox1.getValue().toString().equals("Macanese Pataca")) {
							CInitial1="MOP";
						}if(Currencybox2.getValue().toString().equals("Macanese Pataca")) {
							CInitial2="MOP";
						}if(Currencybox1.getValue().toString().equals("Malagasy Ariary")) {
							CInitial1="MGA";
						}if(Currencybox2.getValue().toString().equals("Malagasy Ariary")) {
							CInitial2="MGA";
						}if(Currencybox1.getValue().toString().equals("Malawian Kwacha")) {
							CInitial1="MWK";
						}if(Currencybox2.getValue().toString().equals("Malawian Kwacha")) {
							CInitial2="MWK";
						}if(Currencybox1.getValue().toString().equals("Malaysian Ringgit")) {
							CInitial1="MYR";
						}if(Currencybox2.getValue().toString().equals("Malaysian Ringgit")) {
							CInitial2="MYR";
						}if(Currencybox1.getValue().toString().equals("Maldivian Rufiyaa")) {
							CInitial1="MVR";
						}if(Currencybox2.getValue().toString().equals("Maldivian Rufiyaa")) {
							CInitial2="MVR";
						}if(Currencybox1.getValue().toString().equals("Mauritanian Ouguiya")) {
							CInitial1="MRU";
						}if(Currencybox2.getValue().toString().equals("Mauritanian Ouguiya")) {
							CInitial2="MRU";
						}if(Currencybox1.getValue().toString().equals("Mauritius Rupee")) {
							CInitial1="MUR";
						}if(Currencybox2.getValue().toString().equals("Mauritius Rupee")) {
							CInitial2="MUR";
						}if(Currencybox1.getValue().toString().equals("Mexican Peso")) {
							CInitial1="MXN";
						}if(Currencybox2.getValue().toString().equals("Mexican Peso")) {
							CInitial2="MXN";
						}if(Currencybox1.getValue().toString().equals("Moldovan Leu")) {
							CInitial1="MDL";
						}if(Currencybox2.getValue().toString().equals("Moldovan Leu")) {
							CInitial2="MDL";
						}if(Currencybox1.getValue().toString().equals("Mongolian Togrog")) {
							CInitial1="MNT";
						}if(Currencybox2.getValue().toString().equals("Mongolian Togrog")) {
							CInitial2="MNT";
						}if(Currencybox1.getValue().toString().equals("Moroccan Dirham")) {
							CInitial1="MAD";
						}if(Currencybox2.getValue().toString().equals("Moroccan Dirham")) {
							CInitial2="MAD";
						}if(Currencybox1.getValue().toString().equals("Monzambican Metical")) {
							CInitial1="MZN";
						}if(Currencybox2.getValue().toString().equals("Monzambican Metical")) {
							CInitial2="MZN";
						}if(Currencybox1.getValue().toString().equals("Burmese Kyat")) {
							CInitial1="MMK";
						}if(Currencybox2.getValue().toString().equals("Burmese Kyat")) {
							CInitial2="MMK";
						}if(Currencybox1.getValue().toString().equals("Namibia Dollar")) {
							CInitial1="NAD";
						}if(Currencybox2.getValue().toString().equals("Namibia Dollar")) {
							CInitial2="NAD";
						}if(Currencybox1.getValue().toString().equals("Nepalese Rupee")) {
							CInitial1="NPR";
						}if(Currencybox2.getValue().toString().equals("Nepalese Rupee")) {
							CInitial2="NPR";
						}if(Currencybox1.getValue().toString().equals("New Zealand Dollar")) {
							CInitial1="NZD";
						}if(Currencybox2.getValue().toString().equals("New Zealand Dollar")) {
							CInitial2="NZD";
						}if(Currencybox1.getValue().toString().equals("Nicaraguan Cordoba")) {
							CInitial1="NIO";
						}if(Currencybox2.getValue().toString().equals("Nicaraguan Cordoba")) {
							CInitial2="NIO";
						}if(Currencybox1.getValue().toString().equals("Nigerian Naira")) {
							CInitial1="NGN";
						}if(Currencybox2.getValue().toString().equals("Nigerian Naira")) {
							CInitial2="NGN";
						}if(Currencybox1.getValue().toString().equals("Norwegian Krone")) {
							CInitial1="NOK";
						}if(Currencybox2.getValue().toString().equals("Norwegian Krone")) {
							CInitial2="NOK";
						}if(Currencybox1.getValue().toString().equals("Omani Rial")) {
							CInitial1="OMR";
						}if(Currencybox2.getValue().toString().equals("Omani Rial")) {
							CInitial2="OMR";
						}if(Currencybox1.getValue().toString().equals("Pakistani Rupee")) {
							CInitial1="PKR";
						}if(Currencybox2.getValue().toString().equals("Pakistani Rupee")) {
							CInitial2="PKR";
						}if(Currencybox1.getValue().toString().equals("Panamanian Balboa")) {
							CInitial1="PAB";
						}if(Currencybox2.getValue().toString().equals("Panamanian Balboa")) {
							CInitial2="PAB";
						}if(Currencybox1.getValue().toString().equals("Papua New Guinean Kina")) {
							CInitial1="PGK";
						}if(Currencybox2.getValue().toString().equals("Papua New Guinean Kina")) {
							CInitial2="PGK";
						}if(Currencybox1.getValue().toString().equals("Paraguayan Guarani")) {
							CInitial1="PYG";
						}if(Currencybox2.getValue().toString().equals("Paraguayan Guarani")) {
							CInitial2="PYG";
						}if(Currencybox1.getValue().toString().equals("Peruvian Sol")) {
							CInitial1="PEN";
						}if(Currencybox2.getValue().toString().equals("Peruvian Sol")) {
							CInitial2="PEN";
						}if(Currencybox1.getValue().toString().equals("Phillipine Peso")) {
							CInitial1="PHP";
						}if(Currencybox2.getValue().toString().equals("Phillipine Peso")) {
							CInitial2="PHP";
						}if(Currencybox1.getValue().toString().equals("Polish Zloty")) {
							CInitial1="PLN";
						}if(Currencybox2.getValue().toString().equals("Polish Zloty")) {
							CInitial2="PLN";
						}if(Currencybox1.getValue().toString().equals("Qatari Riyal")) {
							CInitial1="QAR";
						}if(Currencybox2.getValue().toString().equals("Qatari Riyal")) {
							CInitial2="QAR";
						}if(Currencybox1.getValue().toString().equals("Romanian Leu")) {
							CInitial1="RON";
						}if(Currencybox2.getValue().toString().equals("Romanian Leu")) {
							CInitial2="RON";
						}if(Currencybox1.getValue().toString().equals("Russian Ruble")) {
							CInitial1="RUB";
						}if(Currencybox2.getValue().toString().equals("Russian Ruble")) {
							CInitial2="RUB";
						}if(Currencybox1.getValue().toString().equals("Rwandan Franc")) {
							CInitial1="RWF";
						}if(Currencybox2.getValue().toString().equals("Rwandan Franc")) {
							CInitial2="RWF";
						}if(Currencybox1.getValue().toString().equals("Saint Helena Pound")) {
							CInitial1="SHP";
						}if(Currencybox2.getValue().toString().equals("Saint Helena Pound")) {
							CInitial2="SHP";
						}if(Currencybox1.getValue().toString().equals("Samoan Tala")) {
							CInitial1="WST";
						}if(Currencybox2.getValue().toString().equals("Samoan Tala")) {
							CInitial2="WST";
						}if(Currencybox1.getValue().toString().equals("Sao Tome and Principe Dobra")) {
							CInitial1="STN";
						}if(Currencybox2.getValue().toString().equals("Sao Tome and Principe Dobra")) {
							CInitial2="STN";
						}if(Currencybox1.getValue().toString().equals("Saudi Riyal")) {
							CInitial1="SAR";
						}if(Currencybox2.getValue().toString().equals("Saudi Riyal")) {
							CInitial2="SAR";
						}if(Currencybox1.getValue().toString().equals("Serbian Dinar")) {
							CInitial1="RSD";
						}if(Currencybox2.getValue().toString().equals("Serbian Dinar")) {
							CInitial2="RSD";
						}if(Currencybox1.getValue().toString().equals("Seychellois Rupee")) {
							CInitial1="SCR";
						}if(Currencybox2.getValue().toString().equals("Seychellois Rupee")) {
							CInitial2="SCR";
						}if(Currencybox1.getValue().toString().equals("Sierra Leonean Leone")) {
							CInitial1="SLL";
						}if(Currencybox2.getValue().toString().equals("Sierra Leonean Leone")) {
							CInitial2="SLL";
						}if(Currencybox1.getValue().toString().equals("Singaporean Dollar")) {
							CInitial1="SGD";
						}if(Currencybox2.getValue().toString().equals("Singaporean Dollar")) {
							CInitial2="SGD";
						}if(Currencybox1.getValue().toString().equals("Solomon Islands Dollar")) {
							CInitial1="SBD";
						}if(Currencybox2.getValue().toString().equals("Solomon Islands Dollar")) {
							CInitial2="SBD";
						}if(Currencybox1.getValue().toString().equals("Somali Shilling")) {
							CInitial1="SOS";
						}if(Currencybox2.getValue().toString().equals("Somali Shilling")) {
							CInitial2="SOS";
						}if(Currencybox1.getValue().toString().equals("South African Rand")) {
							CInitial1="ZAR";
						}if(Currencybox2.getValue().toString().equals("South African Rand")) {
							CInitial2="ZAR";
						}if(Currencybox1.getValue().toString().equals("South Sudanese Pound")) {
							CInitial1="SSP";
						}if(Currencybox2.getValue().toString().equals("South Sudanese Pound")) {
							CInitial2="SSP";
						}if(Currencybox1.getValue().toString().equals("Sri Lankan Rupee")) {
							CInitial1="LKR";
						}if(Currencybox2.getValue().toString().equals("Sri Lankan Rupee")) {
							CInitial2="LKR";
						}if(Currencybox1.getValue().toString().equals("Sudanese Pound")) {
							CInitial1="SDG";
						}if(Currencybox2.getValue().toString().equals("Sudanese Pound")) {
							CInitial2="SGD";
						}if(Currencybox1.getValue().toString().equals("Surinamese Dollar")) {
							CInitial1="SRD";
						}if(Currencybox2.getValue().toString().equals("Surinamese Dollar")) {
							CInitial2="SRD";
						}if(Currencybox1.getValue().toString().equals("Swedish Krona")) {
							CInitial1="SEK";
						}if(Currencybox2.getValue().toString().equals("Swedish Krona")) {
							CInitial2="SEK";
						}if(Currencybox1.getValue().toString().equals("Swiss Franc")) {
							CInitial1="CHF";
						}if(Currencybox2.getValue().toString().equals("Swiss Franc")) {
							CInitial2="CHF";
						}if(Currencybox1.getValue().toString().equals("Syrian Pound")) {
							CInitial1="SYP";
						}if(Currencybox2.getValue().toString().equals("Syrian Pound")) {
							CInitial2="SYP";
						}if(Currencybox1.getValue().toString().equals("New Taiwan Dollar")) {
							CInitial1="TWD";
						}if(Currencybox2.getValue().toString().equals("New Taiwan Dollar")) {
							CInitial2="TWD";
						}if(Currencybox1.getValue().toString().equals("Tajikistani Somoni")) {
							CInitial1="TJS";
						}if(Currencybox2.getValue().toString().equals("Tajikistani Somoni")) {
							CInitial2="TJS";
						}if(Currencybox1.getValue().toString().equals("Tanzanian Shilling")) {
							CInitial1="TZS";
						}if(Currencybox2.getValue().toString().equals("Tanzanian Shilling")) {
							CInitial2="TZS";
						}if(Currencybox1.getValue().toString().equals("Thai Baht")) {
							CInitial1="THB";
						}if(Currencybox2.getValue().toString().equals("Thai Baht")) {
							CInitial2="THB";
						}if(Currencybox1.getValue().toString().equals("Tongan Pa'anga")) {
							CInitial1="TOP";
						}if(Currencybox2.getValue().toString().equals("Tongan Pa'anga")) {
							CInitial2="TOP";
						}if(Currencybox1.getValue().toString().equals("Trinidad and Tobago Dollar")) {
							CInitial1="TTD";
						}if(Currencybox2.getValue().toString().equals("Trinidad and Tobago Dollar")) {
							CInitial2="TTD";
						}if(Currencybox1.getValue().toString().equals("Tunisian Dinar")) {
							CInitial1="TND";
						}if(Currencybox2.getValue().toString().equals("Tunisian Dinar")) {
							CInitial2="TND";
						}if(Currencybox1.getValue().toString().equals("Turkish Lira")) {
							CInitial1="TRY";
						}if(Currencybox2.getValue().toString().equals("Turkish Lira")) {
							CInitial2="TRY";
						}if(Currencybox1.getValue().toString().equals("Turkmenistan Manat")) {
							CInitial1="TMT";
						}if(Currencybox2.getValue().toString().equals("Turkmenistan Manat")) {
							CInitial2="TMT";
						}if(Currencybox1.getValue().toString().equals("Ugandan Shilling")) {
							CInitial1="UGX";
						}if(Currencybox2.getValue().toString().equals("Ugandan Shilling")) {
							CInitial2="UGX";
						}if(Currencybox1.getValue().toString().equals("Ukranian Hryvnia")) {
							CInitial1="UAH";
						}if(Currencybox2.getValue().toString().equals("Ukranian Hryvnia")) {
							CInitial2="UAH";
						}if(Currencybox1.getValue().toString().equals("United Arab Emirates Dirham")) {
							CInitial1="AED";
						}if(Currencybox2.getValue().toString().equals("United Arab Emirates Dirham")) {
							CInitial2="AED";
						}if(Currencybox1.getValue().toString().equals("British Pound")) {
							CInitial1="GBP";
						}if(Currencybox2.getValue().toString().equals("British Pound")) {
							CInitial2="AED";
						}if(Currencybox1.getValue().toString().equals("United States Dollar")) {
							CInitial1="USD";
						}if(Currencybox2.getValue().toString().equals("United States Dollar")) {
							CInitial2="USD";
						}if(Currencybox1.getValue().toString().equals("Uruguayan Peso")) {
							CInitial1="UYU";
						}if(Currencybox2.getValue().toString().equals("Uruguayan Peso")) {
							CInitial2="UYU";
						}if(Currencybox1.getValue().toString().equals("Uzbekistani So'm")) {
							CInitial1="UZS";
						}if(Currencybox2.getValue().toString().equals("Uzbekistani So'm")) {
							CInitial2="UZS";
						}if(Currencybox1.getValue().toString().equals("Vanuatu Vatu")) {
							CInitial1="VUV";
						}if(Currencybox2.getValue().toString().equals("Vanuatu Vatu")) {
							CInitial2="VUV";
						}if(Currencybox1.getValue().toString().equals("Venezeualan Bolivar Soberano")) {
							CInitial1="VEF";
						}if(Currencybox2.getValue().toString().equals("Venezeualan Bolivar Soberano")) {
							CInitial2="VEF";
						}if(Currencybox1.getValue().toString().equals("Vietnamese Dong")) {
							CInitial1="VND";
						}if(Currencybox2.getValue().toString().equals("Vietnamese Dong")) {
							CInitial2="VND";
						}if(Currencybox1.getValue().toString().equals("West African Franc")) {
							CInitial1="XOF";
						}if(Currencybox2.getValue().toString().equals("West African Franc")) {
							CInitial2="XOF";
						}if(Currencybox1.getValue().toString().equals("Yemeni Rial")) {
							CInitial1="YER";
						}if(Currencybox2.getValue().toString().equals("Yemeni Rial")) {
							CInitial2="YER";
						}if(Currencybox1.getValue().toString().equals("Zambian Kwacha")) {
							CInitial1="ZMW";
						}if(Currencybox2.getValue().toString().equals("Zambian Kwacha")) {
							CInitial2="ZMW";
						}if(Currencybox1.getValue().toString().equals("Zimbabwe RTGS Dollar")) {
							CInitial1="ZWL";
						}if(Currencybox2.getValue().toString().equals("Zimbabwe RTGS Dollar")) {
							CInitial2="ZWL";
						}
					try {
						// Setting URL
						//Enter API KEY in string below
						String APIKey="";
						String urlstr = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s",APIKey,CInitial1);
						// Making Request
						URL url = new URL(urlstr);
						HttpURLConnection request = (HttpURLConnection) url.openConnection();
						request.connect();
						// Convert to JSON
						JSONParser jp = new JSONParser();
						Object root =  jp.parse(new InputStreamReader((InputStream) request.getContent()));
						JSONObject jsonobj =  (JSONObject)root;
						// Accessing object
						JSONObject conversions =  (JSONObject) jsonobj.get("conversion_rates");
						String foundcurrency=conversions.get(CInitial2).toString();
						double ccurrency=Double.parseDouble(foundcurrency)*Double.parseDouble(Currency1text.getText());
						Currency2text.setText(Double.toString(ccurrency));
					} catch (IOException | ParseException e1) {
						e1.printStackTrace();
					}
						
					}
				}
			});
			GridPane MainGridPane=new GridPane();
			HBox components=new HBox();
			components.getChildren().addAll(Currency1text,Currencybox1,Currencyequals,Currency2text,Currencybox2);
			MainGridPane.add(components, 0, 0);
			Scene Conversionscene=new Scene(MainGridPane);
			mainstage.show();
			mainstage.setScene(Conversionscene);
			mainstage.setTitle("Currency Converter");
	}
	public static void main(String[]args) {
		launch(args);
	}
}
