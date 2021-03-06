package jp.co.cyberz.konohito.model.api;

import java.util.ArrayList;
import java.util.List;

import jp.co.cyberz.konohito.model.Friend;
import android.os.AsyncTask;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public final class FbApi {

	private static FbApi api;

	private Facebook facebook;

	public static FbApi getInstance() {
		if (FbApi.api == null) {
			FbApi.api = new FbApi();
		}
		return FbApi.api;
	}

	private FbApi() {
		this.facebook = FacebookFactory.getSingleton();
		this.facebook.setOAuthAppId("325326170957493", "6e913651e863728127bfed697ea80c1c");
		facebook.setOAuthPermissions("email,publish_stream,public_profile,user_friends,user_status");
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAKNMHIWGPDcl62zdytFqfZCdkFGHGPwq9pLJqHO4uB0JfcL3ZBxDudIrJH6jaPlPjfZBygTyRZCXOepeJeDkmZBUKd8d0Uj6brovHMOs3ZA8A4TlXiarGhmcQtobhN3lIchJkcc4xtSKvgGSQXt3n4oF3B0ZAb9ZBokMG2s6rfC6gM7atpYXaIE9y2FKZByvVCgZDZD", null));
	}

	/**
	 * フレンドリストを取得
	 * 
	 * @return
	 */
	public void getFriendList(FriendListCallback callback) {
		new FriendListTask(this.facebook, callback).execute();
	}
}
