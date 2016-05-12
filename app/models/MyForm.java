package models;

import java.util.Date;

import play.data.validation.Constraints.Required;

public class MyForm {
	private static String win;
	private static String mac;
	private static String lin;
	private static String jp;
	private static String us;
	private static String uk;
	public static final String WIN = win;
	public static final String MAC = mac;
	public static final String LINUX = lin;

	public static final String JAPAN = jp;
	public static final String US = us;
	public static final String UK = uk;

	@Required(message = "This field is required")
	public String name;
	public String password;
	public boolean checked;
	public String os;
	public String country;
	public String area;
	public Date date;
	public Integer num;
}

