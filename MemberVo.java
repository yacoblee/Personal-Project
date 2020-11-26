
public class MemberVo {
	private String name;
	private String number;
	private String address;
	private int comm;

	public MemberVo() {

	}

	public MemberVo(String name, String number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;

	}

	public MemberVo(String name, String number, String address, int comm) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.comm= comm;
	}

	public String name() {
		return name;
	}

	public String getnumber() {
		return number;
	}
	
	public String getString() {
		return address;
	}

}

