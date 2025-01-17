package io.github.reinershir.auth.config.property;

import java.util.List;

import org.springframework.util.StringUtils;

public class SercurityConfig {

	/**
	 * 开启全局限流开关
	 */
	private Boolean enableRequestLimit=false;
	/**
	 * 每次限流时间，单位为毫秒
	 */
	private Long requestTime=1000l;
	
	/**
	 * 每次限流次数上限，如requestTime=1000，requestLimit=3，表示1秒内最多允许请求3次
	 */
	private Integer requestLimit = 3;
	
	/**
	 * 限流IP存储方式，1、memory 存储快 2、redis 稍微有点损耗，分布式环境建议使用redis
	 */
	private String requestLimitStorage = "memory";
	
	/**
	 * 开启日志请求记录
	 */
	private Boolean enableRequestLog=false;
	
	/**
	 * 不需要记录日志的请求路径（可防止某些及少数无法获取到参数的情况，如支付宝回调接口）
	 */
	private List<String> skipLogUrls;
	
	/**
	 * Token强制绑定IP
	 */
	private Boolean bindIp=false;

	public Boolean getEnableRequestLimit() {
		return enableRequestLimit;
	}

	public void setEnableRequestLimit(Boolean enableRequestLimit) {
		this.enableRequestLimit = enableRequestLimit;
	}

	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public Integer getRequestLimit() {
		return requestLimit;
	}

	public void setRequestLimit(Integer requestLimit) {
		this.requestLimit = requestLimit;
	}

	public String getRequestLimitStorage() {
		return requestLimitStorage;
	}

	public void setRequestLimitStorage(String requestLimitStorage) {
		if(StringUtils.hasText(requestLimitStorage)) {
			if(requestLimitStorage.equalsIgnoreCase("memory")||requestLimitStorage.equalsIgnoreCase("redis")) {
				this.requestLimitStorage = requestLimitStorage;
			}else {
				throw new IllegalArgumentException("Illegal argument : "+requestLimitStorage);
			}
		}
	}

	public Boolean getEnableRequestLog() {
		return enableRequestLog;
	}

	public void setEnableRequestLog(Boolean enableRequestLog) {
		this.enableRequestLog = enableRequestLog;
	}

	public Boolean getBindIp() {
		return bindIp;
	}

	public void setBindIp(Boolean bindIp) {
		this.bindIp = bindIp;
	}

	public List<String> getSkipLogUrls() {
		return skipLogUrls;
	}

	public void setSkipLogUrls(List<String> skipLogUrls) {
		this.skipLogUrls = skipLogUrls;
	}

	

	
}
