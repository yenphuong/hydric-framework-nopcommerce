package commons;

import java.io.File;

public class GlobalConstantsOrangeHRM {
	public static final String DEV_USER_URL = "https://localhost:86/orangehrm5";
	//public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DEV_ADMIN_USERNAME = "phuonglny";
	public static final String DEV_ADMIN_PASSWORD = "PhuongLNY@123";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator +"downloadFiles" + File.separator;
	public static final String REPORTING_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator +"reportNGScreenshot" +File.separator;
}