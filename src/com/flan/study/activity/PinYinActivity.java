package com.flan.study.activity;

import java.io.UnsupportedEncodingException;

import com.flan.study.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PinYinActivity extends Activity {
	
	static final int GB_SP_DIFF=160;
	// ��Ź���һ�����ֲ�ͬ��������ʼ��λ�� 
    static final int[] secPosValueList = { 1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 
    	3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 
        5249, 5600 }; 
    // ��Ź���һ�����ֲ�ͬ��������ʼ��λ���Ӧ���� 
    static final char[] firstLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z' }; 
	private EditText edit;
	private TextView text;
	private Button button;
	private String pingying="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_pinyin);
		
		edit = (EditText)this.findViewById(R.id.pinyin_et);
        text = (TextView)this.findViewById(R.id.pinyin_tv);
        button = (Button)this.findViewById(R.id.pinyin_but);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String characters = edit.getText().toString();
				String spells = getSpells(characters);
				//text.setText(spells);
				pingying = spells;
				PinYinActivity.this.onRestart();
			}
		});
	}
	
	@Override
	protected void onRestart() {
		this.text.setText(pingying);
	}
	
	public static String getSpells(String characters){
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<characters.length();i++){
    		
    		char ch = characters.charAt(i);
    		if((ch>>7)==0){
    			//�ж��Ƿ�Ϊ���֣��������7ΪΪ0�Ͳ��Ǻ��֣������Ǻ���
    			buffer.append(String.valueOf(ch));
    		}else{
			char spell = getFirstLetter(ch);
			buffer.append(String.valueOf(spell));
    		}
    	}
		return buffer.toString();
    }
	
    // ��ȡһ�����ֵ�����ĸ 
    public static Character getFirstLetter(char ch) { 
         
        byte[] uniCode = null; 
        try { 
            uniCode = String.valueOf(ch).getBytes("GBK"); 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
            return null; 
        } 
        if (uniCode[0] < 128 && uniCode[0] > 0) { // �Ǻ��� 
            return null; 
        } else { 
            return convert(uniCode); 
        } 
    } 
    
    
    /**
     * ��ȡһ�����ֵ�ƴ������ĸ�� GB�������ֽڷֱ��ȥ160��ת����10��������ϾͿ��Եõ���λ��
     * ���纺�֡��㡱��GB����0xC4/0xE3���ֱ��ȥ0xA0��160������0x24/0x43
     * 0x24ת��10���ƾ���36��0x43��67����ô������λ�����3667���ڶ��ձ��ж���Ϊ��n��
     */ 
    static char convert(byte[] bytes) { 
        char result = '-'; 
        int secPosValue = 0; 
        int i; 
        for (i = 0; i < bytes.length; i++) { 
            bytes[i] -= GB_SP_DIFF; 
        } 
        secPosValue = bytes[0] * 100 + bytes[1]; 
        for (i = 0; i < 23; i++) { 
            if (secPosValue >= secPosValueList[i] && secPosValue < secPosValueList[i + 1]) { 
                result = firstLetter[i]; 
                break; 
            } 
        } 
        return result; 
    } 
	
}











