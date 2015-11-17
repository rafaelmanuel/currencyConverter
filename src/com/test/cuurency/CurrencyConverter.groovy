package com.test.cuurency

import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.event.ActionListener
import java.awt.event.MouseListener

import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*
class CurrencyConverter {

	static main(args) {
		
		StringBuilder strBuilder = new StringBuilder()
			strBuilder.append("""
			AFA-Afghanistan Afghani
			ALL-Albanian Lek
			DZD-Algerian Dinar
			ARS-Argentine Peso
			AWG-Aruba Florin
			AUD-Australian Dollar
			BSD-Bahamian Dollar
			BHD-Bahraini Dinar
			BDT-Bangladesh Taka
			BBD-Barbados Dollar
			BZD-Belize Dollar
			BMD-Bermuda Dollar
			BTN-Bhutan Ngultrum
			BOB-Bolivian Boliviano
			BWP-Botswana Pula
			BRL-Brazilian Real
			GBP-British Pound
			BND-Brunei Dollar
			BIF-Burundi Franc
			XOF-CFA Franc (BCEAO)
			XAF-CFA Franc (BEAC)
			KHR-Cambodia Riel
			CAD-Canadian Dollar
			CVE-Cape Verde Escudo
			KYD-Cayman Islands Dollar
			CLP-Chilean Peso
			CNY-Chinese Yuan
			COP-Colombian Peso
			KMF-Comoros Franc
			CRC-Costa Rica Colon
			HRK-Croatian Kuna
			CUP-Cuban Peso
			CYP-Cyprus Pound
			CZK-Czech Koruna
			DKK-Danish Krone
			DJF-Dijibouti Franc
			DOP-Dominican Peso
			XCD-East Caribbean Dollar
			EGP-Egyptian Pound
			SVC-El Salvador Colon
			EEK-Estonian Kroon
			ETB-Ethiopian Birr
			EUR-Euro
			FKP-Falkland Islands Pound
			GMD-Gambian Dalasi
			GHC-Ghanian Cedi
			GIP-Gibraltar Pound
			XAU-Gold Ounces
			GTQ-Guatemala Quetzal
			GNF-Guinea Franc
			GYD-Guyana Dollar
			HTG-Haiti Gourde
			HNL-Honduras Lempira
			HKD-Hong Kong Dollar
			HUF-Hungarian Forint
			ISK-Iceland Krona
			INR-Indian Rupee
			IDR-Indonesian Rupiah
			IQD-Iraqi Dinar
			ILS-Israeli Shekel
			JMD-Jamaican Dollar
			JPY-Japanese Yen
			JOD-Jordanian Dinar
			KZT-Kazakhstan Tenge
			KES-Kenyan Shilling
			KRW-Korean Won
			KWD-Kuwaiti Dinar
			LAK-Lao Kip
			LVL-Latvian Lat
			LBP-Lebanese Pound
			LSL-Lesotho Loti
			LRD-Liberian Dollar
			LYD-Libyan Dinar
			LTL-Lithuanian Lita
			MOP-Macau Pataca
			MKD-Macedonian Denar
			MGF-Malagasy Franc
			MWK-Malawi Kwacha
			MYR-Malaysian Ringgit
			MVR-Maldives Rufiyaa
			MTL-Maltese Lira
			MRO-Mauritania Ougulya
			MUR-Mauritius Rupee
			MXN-Mexican Peso
			MDL-Moldovan Leu
			MNT-Mongolian Tugrik
			MAD-Moroccan Dirham
			MZM-Mozambique Metical
			MMK-Myanmar Kyat
			NAD-Namibian Dollar
			NPR-Nepalese Rupee
			ANG-Neth Antilles Guilder
			NZD-New Zealand Dollar
			NIO-Nicaragua Cordoba
			NGN-Nigerian Naira
			KPW-North Korean Won
			NOK-Norwegian Krone
			OMR-Omani Rial
			XPF-Pacific Franc
			PKR-Pakistani Rupee
			XPD-Palladium Ounces
			PAB-Panama Balboa
			PGK-Papua New Guinea Kina
			PYG-Paraguayan Guarani
			PEN-Peruvian Nuevo Sol
			PHP-Philippine Peso
			XPT-Platinum Ounces
			PLN-Polish Zloty
			QAR-Qatar Rial
			ROL-Romanian Leu
			RUB-Russian Rouble
			WST-Samoa Tala
			STD-Sao Tome Dobra
			SAR-Saudi Arabian Riyal
			SCR-Seychelles Rupee
			SLL-Sierra Leone Leone
			XAG-Silver Ounces
			SGD-Singapore Dollar
			SKK-Slovak Koruna
			SIT-Slovenian Tolar
			SBD-Solomon Islands Dollar
			SOS-Somali Shilling
			ZAR-South African Rand
			LKR-Sri Lanka Rupee
			SHP-St Helena Pound
			SDD-Sudanese Dinar
			SRG-Surinam Guilder
			SZL-Swaziland Lilageni
			SEK-Swedish Krona
			TRY-Turkey Lira
			CHF-Swiss Franc
			SYP-Syrian Pound
			TWD-Taiwan Dollar
			TZS-Tanzanian Shilling
			THB-Thai Baht
			TOP-Tonga Pa'anga
			TTD-Trinidad&amp;Tobago Dollar
			TND-Tunisian Dinar
			TRL-Turkish Lira
			USD-U.S. Dollar
			AED-UAE Dirham
			UGX-Ugandan Shilling
			UAH-Ukraine Hryvnia
			UYU-Uruguayan New Peso
			VUV-Vanuatu Vatu
			VEB-Venezuelan Bolivar
			VND-Vietnam Dong
			YER-Yemen Riyal
			YUM-Yugoslav Dinar
			ZMK-Zambian Kwacha
			ZWD-Zimbabwe Dollar
			""")
		print new CurrencyConverter().goConvert('PHP','USD')
		
		SwingBuilder sb = new SwingBuilder()
		sb.edt{
			
				panel = new JPanel()
				panel1 = new JPanel()
				panel2 = new JPanel()
				panel3 = new JPanel()
				
				frame = new JFrame(title:"Temperature Converter",
					defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
					size:[450,180],
					locationRelativeTo:null,layout:flowLayout())	
				
				panel = frame.contentPane
				panel.setLayout(new BorderLayout())
				
				panel1.setLayout(flowLayout())
				
			
				btnConvert = new JButton(text:"Convert")

				
				txtFrom = new JTextField(columns:10)
				txtTo = new JTextField(columns:10)
				
				fromCurrency = new JComboBox()
				toCurrency = new JComboBox()
				
				strBuilder.toString().split("\n").each{
					if(!it.equals("")){
						fromCurrency.addItem(it.trim())
						toCurrency.addItem(it.trim())
					}
				}
				
				btnConvert.addActionListener({
					//JOptionPane.showMessageDialog(frame , new CurrencyConverter().goConvert(fromCurrency.getSelectedItem().toString().split("-")[0],toCurrency.getSelectedItem().toString().split("-")[0]))
					if(txtFrom.text.equals("") && txtTo.text.equals("")){
						print "Error"
					}else if(!txtFrom.text.equals("") && !txtTo.text.equals("")){
						print "Error"
					}else if(!txtFrom.text.equals("") && txtTo.text.equals("")){
						String hello = (new CurrencyConverter().goConvert(fromCurrency.getSelectedItem().toString().split("-")[0],toCurrency.getSelectedItem().toString().split("-")[0]))
						txtTo.text = Double.parseDouble(hello) * Double.parseDouble(txtFrom.text)
					}else if(txtFrom.text.equals("") && !txtTo.text.equals("")){
						String hello = (new CurrencyConverter().goConvert(fromCurrency.getSelectedItem().toString().split("-")[0],toCurrency.getSelectedItem().toString().split("-")[0]))
						txtFrom.text = Double.parseDouble(hello) * Double.parseDouble(txtTo.text)
					}
											
				} as ActionListener)
				
				txtFrom.addMouseListener({
					txtTo.text = ""
					
				} as MouseListener)
				panel1.add(txtFrom)
				panel1.add(fromCurrency)
				panel2.add(txtTo)
				panel2.add(toCurrency)
				panel3.add(btnConvert)
				panel.add(panel1 , BorderLayout.NORTH)
				panel.add(panel2 , BorderLayout.CENTER)
				panel.add(panel3 , BorderLayout.SOUTH)
				frame.show()
		}
	}

	def goConvert(def from , def to){
		def client = new SOAPClient('http://www.webservicex.net/CurrencyConvertor.asmx?WSDL')
		def response = client.send("""<?xml version="1.0" encoding="utf-8"?>
			<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.webserviceX.NET/">
			<soap:Header/>
			<soap:Body>
			<web:ConversionRate>
            <web:FromCurrency>${from}</web:FromCurrency>
         	<web:ToCurrency>${to}</web:ToCurrency>
			</web:ConversionRate>
			</soap:Body>
			</soap:Envelope>
			""")
		response.ConversionRateResponse.ConversionRateResult
	}
}
