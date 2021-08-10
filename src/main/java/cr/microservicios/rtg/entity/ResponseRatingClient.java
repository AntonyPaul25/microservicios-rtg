package cr.microservicios.rtg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseRatingClient {

	@JsonProperty("scaleWithoutException")
	private String scaleWithoutException;
	
	@JsonProperty("scaleWithException")
	private String scaleWithException;
	
	@JsonProperty("SEICode")
	private String SEICode;
	
	@JsonProperty("SEI")
	private String SEI;
	
	@JsonProperty("financialStatusPeriod")
	private String financialStatusPeriod;
	
	@JsonProperty("updateDate")
	private String updateDate;
	
	public String getScaleWithoutException() {
		return scaleWithoutException;
	}
	public void setScaleWithoutException(String scaleWithoutException) {
		this.scaleWithoutException = scaleWithoutException;
	}
	public String getScaleWithException() {
		return scaleWithException;
	}
	public void setScaleWithException(String scaleWithException) {
		this.scaleWithException = scaleWithException;
	}
	public String getSEICode() {
		return SEICode;
	}
	public void setSEICode(String sEICode) {
		SEICode = sEICode;
	}
	public String getSEI() {
		return SEI;
	}
	public void setSEI(String sEI) {
		SEI = sEI;
	}
	public String getFinancialStatusPeriod() {
		return financialStatusPeriod;
	}
	public void setFinancialStatusPeriod(String financialStatusPeriod) {
		this.financialStatusPeriod = financialStatusPeriod;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "ResponseRatingClient [SEICode=" + SEICode + ", SEI=" + SEI + "]";
	}

	
	
}
