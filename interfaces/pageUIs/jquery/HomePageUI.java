package pageUIs.jquery;

public class HomePageUI {
	public static final String SEARCH_TEXTBOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_NUMBER_ACTIVE = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String ROW_DATA = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ROW_ACTION = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	public static final String ALL_PAGE_LINKS = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr/td[%s]";
	
}
