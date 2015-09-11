package angel.core.service.common.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import angel.core.Exception.SendValidationException;
import angel.core.Exception.ValidateTooFrequentlyException;
import angel.core.service.common.XCaptchaService;
import angel.core.util.HttpPost;
import angel.core.util.ValidataUtil;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class XCaptchaServiceImpl implements XCaptchaService {
	@Resource
	private CacheManager cacheManager;

	private Cache cache = null;

	private static final String CACHE_NAME = "captcha";
	@Override
	public void sendCaptcha(String phoneNum, int frequencySeconds) {
		// 检查验证码发送间隔
				ValueWrapper vw = cache.get(TIME_PREFIX + phoneNum);
				if (vw != null) {
					long time = (Long) vw.get();
					long now = System.currentTimeMillis();
					if (now < (time + 60 * 1000)) {
						throw new ValidateTooFrequentlyException();
					}
				}
				cache.put(TIME_PREFIX + phoneNum,(Long) System.currentTimeMillis());
				String validata = ValidataUtil.validata();
				// 发送
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", "NFTB700210");// 此处填写用户账号
				map.put("scode", "205897");// 此处填写用户密码
				map.put("mobile", phoneNum);// 此处填写发送号码
				map.put("tempid", "MB-2014092718");// 此处填写模板短信编号
				map.put("content", "@1@=" + validata);// 此处填写模板短信内容
				String temp = HttpPost.doPost("http://222.185.228.25:8000/msm/sdk/http/sendsms.jsp", map, "GBK");
				if (temp == null || temp.contains("ERROR")) {
					throw new SendValidationException();
				}
				cache.put(CAPTCHA_PREFIX + phoneNum, validata);


	}

	@Override
	public void sendCaptcha(String phoneNum) {
		sendCaptcha(phoneNum, 60);

	}

	@Override
	public void saveCaptcha(String phoneNum, String captcha) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validate(String phoneNum, String captcha, boolean evict) {
		ValueWrapper vw = cache.get(CAPTCHA_PREFIX + phoneNum);
		System.out.println(captcha);
		
		if (vw == null) {
			return false;
		}
		System.out.println(String.valueOf(vw.get()));
		if (captcha == null || !captcha.equalsIgnoreCase(String.valueOf(vw.get()))) {
			return false;
		}
		if (evict) {
			cache.evict(CAPTCHA_PREFIX + phoneNum);
		}
		return true;
	}
	
	@PostConstruct
	private void init() {
		cache = cacheManager.getCache(CACHE_NAME);
	}


}
